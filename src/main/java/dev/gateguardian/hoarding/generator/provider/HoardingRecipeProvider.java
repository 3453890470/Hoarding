package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import dev.gateguardian.hoarding.common.registry.HoardingItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class HoardingRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public HoardingRecipeProvider(PackOutput output) {
        super(output);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed) {
        ShapelessRecipeBuilder.shapeless(unpackedCategory, unpacked, 9)
                .requires(packed)
                .unlockedBy(getHasName(packed), has(packed))
                .save(finishedRecipeConsumer, Hoarding.id(getSimpleRecipeName(unpacked)));
        ShapedRecipeBuilder.shaped(packedCategory, packed)
                .define('#', unpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(unpacked), has(unpacked))
                .save(finishedRecipeConsumer, Hoarding.id(getSimpleRecipeName(packed)));
    }

    protected static void threeByThreePacker(Consumer<FinishedRecipe> finishedRecipeConsumer, RecipeCategory category, ItemLike packed, ItemLike unpacked, String criterionName) {
        ShapelessRecipeBuilder.shapeless(category, packed).requires(unpacked, 9).unlockedBy(criterionName, has(unpacked)).save(finishedRecipeConsumer, Hoarding.id(getSimpleRecipeName(packed)));
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> output) {
        nineBlockStorageRecipes(output, RecipeCategory.MISC, HoardingItems.PUMPKIN_SLICE.get(), RecipeCategory.BUILDING_BLOCKS, Blocks.PUMPKIN);

        //region Birch Crates
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.ALLIUM, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.ALLIUM_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.AZURE_BLUET, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.AZURE_BLUET_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.BLUE_ORCHID, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BLUE_ORCHID_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.CORNFLOWER, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.CORNFLOWER_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.DANDELION, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.DANDELION_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.LILY_OF_THE_VALLEY, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.LILY_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.OXEYE_DAISY, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.OXEYE_DAISY_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.POPPY, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.POPPY_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.ORANGE_TULIP, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.ORANGE_TULIP_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.PINK_TULIP, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.PINK_TULIP_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.RED_TULIP, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.RED_TULIP_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.WHITE_TULIP, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.WHITE_TULIP_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.TORCHFLOWER, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.TORCHFLOWER_CRATE.get());
        //endregion

        //region Oak Crates
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.APPLE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.APPLE_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.GOLDEN_APPLE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.GOLDEN_APPLE_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.POTATO, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.POTATO_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.BAKED_POTATO, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BAKED_POTATO_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.POISONOUS_POTATO, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.POISONOUS_POTATO_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.BEETROOT, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BEETROOT_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.BROWN_MUSHROOM, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BROWN_MUSHROOM_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.RED_MUSHROOM, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.RED_MUSHROOM_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.CARROT, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.CARROT_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.GOLDEN_CARROT, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.GOLDEN_CARROT_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.SWEET_BERRIES, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.SWEET_BERRIES_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.GLOW_BERRIES, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.GLOW_BERRIES_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.COOKIE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.COOKIE_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.BREAD, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BREAD_CRATE.get());
        //endregion

        //region Spruce Crates
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.BEEF, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BEEF_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.COOKED_BEEF, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.COOKED_BEEF_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.CHICKEN, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.CHICKEN_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.COOKED_CHICKEN, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.COOKED_CHICKEN_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.MUTTON, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.MUTTON_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.COOKED_MUTTON, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.COOKED_MUTTON_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.RABBIT, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.RABBIT_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.COOKED_RABBIT, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.COOKED_RABBIT_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.RABBIT_FOOT, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.RABBIT_FOOT_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.PORKCHOP, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.PORKCHOP_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.COOKED_PORKCHOP, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.COOKED_PORKCHOP_CRATE.get());
        //endregion

        //region Iron Crates
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.ENDER_EYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.ENDER_EYE_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.ENDER_PEARL, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.ENDER_PEARL_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.ROTTEN_FLESH_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.SPIDER_EYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.SPIDER_EYE_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.FERMENTED_SPIDER_EYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.FERMENTED_SPIDER_EYE_CRATE.get());
        //endregion

        //region Crimson Crates
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.CRIMSON_FUNGUS, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.CRIMSON_FUNGUS_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.WARPED_FUNGUS, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.WARPED_FUNGUS_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.NETHER_WART, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.NETHER_WART_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.WITHER_ROSE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.WITHER_ROSE_CRATE.get());
        //endregion

        //region End Stone Crates
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.CHORUS_FRUIT, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.CHORUS_FRUIT_CRATE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.POPPED_CHORUS_FRUIT, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.POPPED_CHORUS_FRUIT_CRATE.get());
        //endregion

        //region Barrels
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.COD, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.COD_BARREL.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.COOKED_COD, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.COOKED_COD_BARREL.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.SALMON, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.SALMON_BARREL.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.COOKED_SALMON, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.COOKED_SALMON_BARREL.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.INK_SAC, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.INK_SAC_BARREL.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.GLOW_INK_SAC, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.GLOW_INK_SAC_BARREL.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.PUFFERFISH, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.PUFFER_FISH_BARREL.get());
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, Items.TROPICAL_FISH, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.TROPICAL_FISH_BARREL.get());
        //endregion

        //region Buckets
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.WHITE_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.WHITE_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.ORANGE_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.ORANGE_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.MAGENTA_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.MAGENTA_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.LIGHT_BLUE_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.LIGHT_BLUE_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.YELLOW_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.YELLOW_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.LIME_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.LIME_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.PINK_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.PINK_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.GRAY_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.GRAY_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.LIGHT_GRAY_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.LIGHT_GRAY_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.CYAN_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.CYAN_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.PURPLE_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.PURPLE_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.BLUE_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BLUE_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.BROWN_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BROWN_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.GREEN_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.GREEN_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.RED_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.RED_DYE_BUCKET.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.BLACK_DYE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BLACK_DYE_BUCKET.get());
        //endregion

        //region Racks
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.EGG, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.EGG_RACK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.TURTLE_EGG, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.TURTLE_EGG_RACK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.GLASS_BOTTLE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BOTTLE_RACK.get());
        //endregion

        //region Sacks
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.SUGAR, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.SUGAR_BAG.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.GUNPOWDER, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.GUNPOWDER_BAG.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.COCOA_BEANS, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.COCOA_BEANS_BAG.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.FEATHER, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.FEATHER_BAG.get());
        //endregion

        //region Seed Bags
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.WHEAT_SEEDS, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.WHEAT_SEEDS_BAG.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.BEETROOT_SEEDS, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BEETROOT_SEEDS_BAG.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.MELON_SEEDS, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.MELON_SEEDS_BAG.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.PUMPKIN_SEEDS, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.PUMPKIN_SEEDS_BAG.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.TORCHFLOWER_SEEDS, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.TORCHFLOWER_SEEDS_BAG.get());
        //endregion

        //region Crimson Bags
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.BLAZE_POWDER, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BLAZE_POWDER_BAG.get());
        //endregion

        //region Compressed Blocks
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.FLINT, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.FLINT_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.NETHER_STAR, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.NETHER_STAR_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.LEATHER, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.LEATHER_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.CACTUS, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.CACTUS_BUNDLE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.SUGAR_CANE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.SUGARCANE_BUNDLE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.STICK, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.STICK_BUNDLE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.BLAZE_ROD, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BLAZE_ROD_BUNDLE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.GLISTERING_MELON_SLICE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.GLISTERING_MELON.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.STRING, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.SPOOL.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.BONE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BONE_PILE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.BOOK, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.BOOK_PILE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.PAPER, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.PAPER_STACK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.TURTLE_HELMET, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.TURTLE_SCUTE_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.PHANTOM_MEMBRANE_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.MAGMA_CREAM, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.MAGMA_CREAM_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, Items.NAUTILUS_SHELL, RecipeCategory.BUILDING_BLOCKS, HoardingBlocks.NAUTILUS_BLOCK.get());
        //endregion
    }
}
