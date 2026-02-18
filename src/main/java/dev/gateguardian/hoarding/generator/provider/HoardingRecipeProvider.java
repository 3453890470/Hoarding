package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class HoardingRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public HoardingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        for (var entry : StorageBlocks.getEntries()) {
            RecipeCategory unpackedCategory = entry.unpackedCategory();
            RecipeCategory packedCategory = entry.packedCategory();
            Block packed = entry.getBlock();
            ItemLike unpacked = entry.getItem();
            String modId = entry.modId();
            if (modId != null) {
                // Cross-mod recipes with conditions
                compressRecipe(output, packedCategory, packed, unpacked, modId);
                decompressRecipe(output, unpackedCategory, packed, unpacked, modId);
            } else {
                compressRecipe(output, packedCategory, packed, unpacked);
                decompressRecipe(output, unpackedCategory, packed, unpacked);
            }
        }
    }

    private void compressRecipe(RecipeOutput output, RecipeCategory category, Block packed, ItemLike unpacked) {
        ShapedRecipeBuilder.shaped(category, packed)
                .define('#', unpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(unpacked), has(unpacked))
                .save(output, Hoarding.id("compress/" + getSimpleRecipeName(packed)));
    }

    private void compressRecipe(RecipeOutput output, RecipeCategory category, Block packed, ItemLike unpacked, String modId) {
        ShapedRecipeBuilder.shaped(category, packed)
                .define('#', unpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(unpacked), has(unpacked))
                .save(output.withConditions(modLoaded(modId)), Hoarding.id(modId + "/compress/" + getSimpleRecipeName(packed)));
    }

    private void decompressRecipe(RecipeOutput output, RecipeCategory category, Block packed, ItemLike unpacked) {
        ShapelessRecipeBuilder.shapeless(category, unpacked, 9)
                .requires(packed)
                .unlockedBy(getHasName(packed), has(packed))
                .save(output, Hoarding.id("decompress/" + getSimpleRecipeName(unpacked)));
    }

    private void decompressRecipe(RecipeOutput output, RecipeCategory category, Block packed, ItemLike unpacked, String modId) {
        ShapelessRecipeBuilder.shapeless(category, unpacked, 9)
                .requires(packed)
                .unlockedBy(getHasName(packed), has(packed))
                .save(output.withConditions(modLoaded(modId)), Hoarding.id(modId + "/decompress/" + getSimpleRecipeName(unpacked)));
    }
}
