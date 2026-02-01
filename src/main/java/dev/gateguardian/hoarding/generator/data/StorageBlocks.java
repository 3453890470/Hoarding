package dev.gateguardian.hoarding.generator.data;

import com.hollingsworth.arsnouveau.setup.registry.BlockRegistry;
import com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import dev.gateguardian.hoarding.common.registry.HoardingItems;
import dev.gateguardian.hoarding.integration.ModIntegration;
import dev.gateguardian.hoarding.integration.arsnouveau.HoardingArsNouveauBlocks;
import dev.gateguardian.hoarding.integration.botania.HoardingBotaniaBlocks;
import lombok.experimental.UtilityClass;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import vazkii.botania.common.block.BotaniaBlocks;

@UtilityClass
public class StorageBlocks {

    public void init() {
        StorageBlockRegistry.builder(Blocks.PUMPKIN, HoardingItems.PUMPKIN_SLICE)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();

        StorageBlockRegistry.builder(HoardingBlocks.ALLIUM_CRATE, Items.ALLIUM)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.AZURE_BLUET_CRATE, Items.AZURE_BLUET)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BLUE_ORCHID_CRATE, Items.BLUE_ORCHID)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.CORNFLOWER_CRATE, Items.CORNFLOWER)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.DANDELION_CRATE, Items.DANDELION)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.LILY_CRATE, Items.LILY_OF_THE_VALLEY)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.OXEYE_DAISY_CRATE, Items.OXEYE_DAISY)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.POPPY_CRATE, Items.POPPY)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.ORANGE_TULIP_CRATE, Items.ORANGE_TULIP)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.PINK_TULIP_CRATE, Items.PINK_TULIP)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.RED_TULIP_CRATE, Items.RED_TULIP)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.WHITE_TULIP_CRATE, Items.WHITE_TULIP)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.TORCHFLOWER_CRATE, Items.TORCHFLOWER)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.APPLE_CRATE, Items.APPLE)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.GOLDEN_APPLE_CRATE, Items.GOLDEN_APPLE)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.POTATO_CRATE, Items.POTATO)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BAKED_POTATO_CRATE, Items.BAKED_POTATO)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.POISONOUS_POTATO_CRATE, Items.POISONOUS_POTATO)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BEETROOT_CRATE, Items.BEETROOT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BROWN_MUSHROOM_CRATE, Items.BROWN_MUSHROOM)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.RED_MUSHROOM_CRATE, Items.RED_MUSHROOM)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.CARROT_CRATE, Items.CARROT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.GOLDEN_CARROT_CRATE, Items.GOLDEN_CARROT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.SWEET_BERRIES_CRATE, Items.SWEET_BERRIES)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.GLOW_BERRIES_CRATE, Items.GLOW_BERRIES)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.COOKIE_CRATE, Items.COOKIE)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BREAD_CRATE, Items.BREAD)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BEEF_CRATE, Items.BEEF)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.COOKED_BEEF_CRATE, Items.COOKED_BEEF)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.CHICKEN_CRATE, Items.CHICKEN)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.COOKED_CHICKEN_CRATE, Items.COOKED_CHICKEN)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.MUTTON_CRATE, Items.MUTTON)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.COOKED_MUTTON_CRATE, Items.COOKED_MUTTON)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.RABBIT_CRATE, Items.RABBIT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.COOKED_RABBIT_CRATE, Items.COOKED_RABBIT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.RABBIT_FOOT_CRATE, Items.RABBIT_FOOT)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.PORKCHOP_CRATE, Items.PORKCHOP)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.COOKED_PORKCHOP_CRATE, Items.COOKED_PORKCHOP)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.ENDER_EYE_CRATE, Items.ENDER_EYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.ENDER_PEARL_CRATE, Items.ENDER_PEARL)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.ROTTEN_FLESH_CRATE, Items.ROTTEN_FLESH)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.SPIDER_EYE_CRATE, Items.SPIDER_EYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.FERMENTED_SPIDER_EYE_CRATE, Items.FERMENTED_SPIDER_EYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.CRIMSON_FUNGUS_CRATE, Items.CRIMSON_FUNGUS)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.WARPED_FUNGUS_CRATE, Items.WARPED_FUNGUS)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.NETHER_WART_CRATE, Items.NETHER_WART)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.WITHER_ROSE_CRATE, Items.WITHER_ROSE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.CHORUS_FRUIT_CRATE, Items.CHORUS_FRUIT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.POPPED_CHORUS_FRUIT_CRATE, Items.POPPED_CHORUS_FRUIT)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.COD_BARREL, Items.COD)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.COOKED_COD_BARREL, Items.COOKED_COD)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.SALMON_BARREL, Items.SALMON)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.COOKED_SALMON_BARREL, Items.COOKED_SALMON)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.INK_SAC_BARREL, Items.INK_SAC)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.GLOW_INK_SAC_BARREL, Items.GLOW_INK_SAC)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.PUFFER_FISH_BARREL, Items.PUFFERFISH)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.TROPICAL_FISH_BARREL, Items.TROPICAL_FISH)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.WHITE_DYE_BUCKET, Items.WHITE_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.ORANGE_DYE_BUCKET, Items.ORANGE_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.MAGENTA_DYE_BUCKET, Items.MAGENTA_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.LIGHT_BLUE_DYE_BUCKET, Items.LIGHT_BLUE_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.YELLOW_DYE_BUCKET, Items.YELLOW_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.LIME_DYE_BUCKET, Items.LIME_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.PINK_DYE_BUCKET, Items.PINK_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.GRAY_DYE_BUCKET, Items.GRAY_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.LIGHT_GRAY_DYE_BUCKET, Items.LIGHT_GRAY_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.CYAN_DYE_BUCKET, Items.CYAN_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.PURPLE_DYE_BUCKET, Items.PURPLE_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BLUE_DYE_BUCKET, Items.BLUE_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BROWN_DYE_BUCKET, Items.BROWN_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.GREEN_DYE_BUCKET, Items.GREEN_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.RED_DYE_BUCKET, Items.RED_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BLACK_DYE_BUCKET, Items.BLACK_DYE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.EGG_RACK, Items.EGG)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.TURTLE_EGG_RACK, Items.TURTLE_EGG)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BOTTLE_RACK, Items.GLASS_BOTTLE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.SUGAR_BAG, Items.SUGAR)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.GUNPOWDER_BAG, Items.GUNPOWDER)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.COCOA_BEANS_BAG, Items.COCOA_BEANS)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.FEATHER_BAG, Items.FEATHER)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.WHEAT_SEEDS_BAG, Items.WHEAT_SEEDS)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BEETROOT_SEEDS_BAG, Items.BEETROOT_SEEDS)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.MELON_SEEDS_BAG, Items.MELON_SEEDS)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.PUMPKIN_SEEDS_BAG, Items.PUMPKIN_SEEDS)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.TORCHFLOWER_SEEDS_BAG, Items.TORCHFLOWER_SEEDS)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BLAZE_POWDER_BAG, Items.BLAZE_POWDER)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.FLINT_BLOCK, Items.FLINT)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.NETHER_STAR_BLOCK, Items.NETHER_STAR)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.LEATHER_BLOCK, Items.LEATHER)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.CACTUS_BUNDLE, Items.CACTUS)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.SUGARCANE_BUNDLE, Items.SUGAR_CANE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.STICK_BUNDLE, Items.STICK)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BLAZE_ROD_BUNDLE, Items.BLAZE_ROD)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.GLISTERING_MELON, Items.GLISTERING_MELON_SLICE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.SPOOL, Items.STRING)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BONE_PILE, Items.BONE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.BOOK_PILE, Items.BOOK)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.PAPER_STACK, Items.PAPER)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.SCUTE_BLOCK, Items.SCUTE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.PHANTOM_MEMBRANE_BLOCK, Items.PHANTOM_MEMBRANE)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.MAGMA_CREAM_BLOCK, Items.MAGMA_CREAM)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        StorageBlockRegistry.builder(HoardingBlocks.NAUTILUS_BLOCK, Items.NAUTILUS_SHELL)
                .unpackedCategory(RecipeCategory.MISC)
                .build();
        // Ars Nouveau
        StorageBlockRegistry.builder(
                        HoardingArsNouveauBlocks.MAGEBLOOM_CRATE,
                        ItemsRegistry.MAGE_BLOOM
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.ARS_NOUVEAU_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingArsNouveauBlocks.SOURCEBERRY_CRATE,
                        BlockRegistry.SOURCEBERRY_BUSH.asItem()
                )
                .unpackedCategory(RecipeCategory.FOOD)
                .modId(ModIntegration.ARS_NOUVEAU_MOD_ID)
                .build();

        // Botania
        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.WHITE_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.whiteFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.ORANGE_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.orangeFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.MAGENTA_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.magentaFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.LIGHT_BLUE_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.lightBlueFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.YELLOW_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.yellowFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.LIME_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.limeFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.PINK_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.pinkFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.GRAY_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.grayFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.LIGHT_GRAY_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.lightGrayFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.CYAN_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.cyanFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.PURPLE_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.purpleFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.BLUE_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.blueFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.BROWN_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.brownFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.GREEN_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.greenFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.RED_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.redFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        StorageBlockRegistry.builder(
                        HoardingBotaniaBlocks.BLACK_MYSTICAL_FLOWER_CRATE,
                        BotaniaBlocks.blackFlower.asItem()
                )
                .unpackedCategory(RecipeCategory.MISC)
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();
    }
}
