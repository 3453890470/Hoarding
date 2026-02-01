package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class HoardingRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public HoardingRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> output) {
        for (var entry : StorageBlocks.getEntries()) {
            RecipeCategory unpackedCategory = entry.unpackedCategory();
            RecipeCategory packedCategory = entry.packedCategory();
            Block packed = entry.getBlock();
            ItemLike unpacked = entry.getItem();
            String modId = entry.modId();
            if (modId != null) {
                ConditionalRecipe.builder()
                        .addCondition(modLoaded(modId))
                        .addRecipe(consumer -> compressRecipe(consumer, packedCategory, packed, unpacked))
                        .build(output, Hoarding.id(modId + "/compress/" + getSimpleRecipeName(packed)));
                ConditionalRecipe.builder()
                        .addCondition(modLoaded(modId))
                        .addRecipe(consumer -> decompressRecipe(consumer, unpackedCategory, packed, unpacked))
                        .build(output, Hoarding.id(modId + "/decompress/" + getSimpleRecipeName(unpacked)));
            } else {
                compressRecipe(output, packedCategory, packed, unpacked);
                decompressRecipe(output, unpackedCategory, packed, unpacked);
            }
        }
    }

    private void compressRecipe(Consumer<FinishedRecipe> output, RecipeCategory category, Block packed, ItemLike unpacked) {
        ShapedRecipeBuilder.shaped(category, packed)
                .define('#', unpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(unpacked), has(unpacked))
                .save(output, Hoarding.id("compress/" + getSimpleRecipeName(packed)));
    }

    private void decompressRecipe(Consumer<FinishedRecipe> output, RecipeCategory category, Block packed, ItemLike unpacked) {
        ShapelessRecipeBuilder.shapeless(category, unpacked, 9)
                .requires(packed)
                .unlockedBy(getHasName(packed), has(packed))
                .save(output, Hoarding.id("decompress/" + getSimpleRecipeName(unpacked)));
    }
}
