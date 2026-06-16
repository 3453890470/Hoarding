package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

/**
 * MC 26.1.2 RecipeProvider — Runner 模式
 */
public class HoardingRecipeProvider extends RecipeProvider {

    private final HolderLookup.Provider registries;

    protected HoardingRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
        this.registries = registries;
    }

    @Override
    protected void buildRecipes() {
        var items = registries.lookupOrThrow(Registries.ITEM);

        for (var entry : StorageBlocks.getEntries()) {
            RecipeCategory unpackedCategory = entry.unpackedCategory();
            RecipeCategory packedCategory = entry.packedCategory();
            Block packed = entry.getBlock();
            ItemLike unpacked = entry.getItem();
            String modId = entry.modId();

            if (unpacked == null || unpacked.asItem() == null) {
                Hoarding.LOGGER.warn("Invalid unpacked item for {}, skipping recipe", packed);
                continue;
            }

            if (modId != null) {
                Hoarding.LOGGER.info("Skipping cross-mod recipe for {} (mod: {}), no IConditionBuilder in 26.1.2", packed, modId);
                continue;
            }

            compressRecipe(items, output, packedCategory, packed, unpacked);
            decompressRecipe(items, output, unpackedCategory, packed, unpacked);
        }
    }

    private void compressRecipe(HolderLookup<Item> items, RecipeOutput output, RecipeCategory category, Block packed, ItemLike unpacked) {
        ShapedRecipeBuilder.shaped(items, category, packed)
                .define('#', unpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(unpacked), has(unpacked))
                .save(output, Hoarding.id("compress/" + getSimpleRecipeName(packed)).toString());
    }

    private void decompressRecipe(HolderLookup<Item> items, RecipeOutput output, RecipeCategory category, Block packed, ItemLike unpacked) {
        ShapelessRecipeBuilder.shapeless(items, category, unpacked, 9)
                .requires(packed)
                .unlockedBy(getHasName(packed), has(packed))
                .save(output, Hoarding.id("decompress/" + getSimpleRecipeName(unpacked)).toString());
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new HoardingRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Hoarding Recipes";
        }
    }
}
