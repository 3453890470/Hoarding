package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.common.Hoarding;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import static dev.gateguardian.hoarding.common.registry.HoardingBlocks.*;
import static dev.gateguardian.hoarding.common.registry.HoardingItems.*;
import static dev.gateguardian.hoarding.integration.arsnouveau.HoardingArsNouveauBlocks.*;
import static dev.gateguardian.hoarding.integration.botania.HoardingBotaniaBlocks.*;

public class HoardingLanguageProvider extends LanguageProvider {

    public HoardingLanguageProvider(PackOutput output) {
        super(output, Hoarding.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.hoarding.main", "Hoarding");

        // Items
        addItem(PUMPKIN_SLICE, "Pumpkin Slice");

        // Birch Crates
        addBlock(ALLIUM_CRATE, "Allium Crate");
        addBlock(AZURE_BLUET_CRATE, "Azure Bluet Crate");
        addBlock(BLUE_ORCHID_CRATE, "Blue Orchid Crate");
        addBlock(CORNFLOWER_CRATE, "Cornflower Crate");
        addBlock(DANDELION_CRATE, "Dandelion Crate");
        addBlock(LILY_CRATE, "Lily Crate");
        addBlock(OXEYE_DAISY_CRATE, "Oxeye Daisy Crate");
        addBlock(POPPY_CRATE, "Poppy Crate");
        addBlock(ORANGE_TULIP_CRATE, "Orange Tulip Crate");
        addBlock(PINK_TULIP_CRATE, "Pink Tulip Crate");
        addBlock(RED_TULIP_CRATE, "Red Tulip Crate");
        addBlock(WHITE_TULIP_CRATE, "White Tulip Crate");
        addBlock(TORCHFLOWER_CRATE, "Torchflower Crate");

        // Oak Crates
        addBlock(APPLE_CRATE, "Apple Crate");
        addBlock(GOLDEN_APPLE_CRATE, "Golden Apple Crate");
        addBlock(POTATO_CRATE, "Potato Crate");
        addBlock(BAKED_POTATO_CRATE, "Baked Potato Crate");
        addBlock(POISONOUS_POTATO_CRATE, "Poisonous Potato Crate");
        addBlock(BEETROOT_CRATE, "Beetroot Crate");
        addBlock(BROWN_MUSHROOM_CRATE, "Brown Mushroom Crate");
        addBlock(RED_MUSHROOM_CRATE, "Red Mushroom Crate");
        addBlock(CARROT_CRATE, "Carrot Crate");
        addBlock(GOLDEN_CARROT_CRATE, "Golden Carrot Crate");
        addBlock(SWEET_BERRIES_CRATE, "Sweet Berries Crate");
        addBlock(GLOW_BERRIES_CRATE, "Glow Berries Crate");
        addBlock(COOKIE_CRATE, "Cookie Crate");
        addBlock(BREAD_CRATE, "Bread Crate");

        // Spruce Crates
        addBlock(BEEF_CRATE, "Beef Crate");
        addBlock(COOKED_BEEF_CRATE, "Cooked Beef Crate");
        addBlock(CHICKEN_CRATE, "Chicken Crate");
        addBlock(COOKED_CHICKEN_CRATE, "Cooked Chicken Crate");
        addBlock(MUTTON_CRATE, "Mutton Crate");
        addBlock(COOKED_MUTTON_CRATE, "Cooked Mutton Crate");
        addBlock(RABBIT_CRATE, "Rabbit Crate");
        addBlock(COOKED_RABBIT_CRATE, "Cooked Rabbit Crate");
        addBlock(RABBIT_FOOT_CRATE, "Rabbit Foot Crate");
        addBlock(PORKCHOP_CRATE, "Porkchop Crate");
        addBlock(COOKED_PORKCHOP_CRATE, "Cooked Porkchop Crate");

        // Iron Crates
        addBlock(ENDER_EYE_CRATE, "Ender Eye Crate");
        addBlock(ENDER_PEARL_CRATE, "Ender Pearl Crate");
        addBlock(ROTTEN_FLESH_CRATE, "Rotten Flesh Crate");
        addBlock(SPIDER_EYE_CRATE, "Spider Eye Crate");
        addBlock(FERMENTED_SPIDER_EYE_CRATE, "Fermented Spider Eye Crate");

        // Crimson Crates
        addBlock(CRIMSON_FUNGUS_CRATE, "Crimson Fungus Crate");
        addBlock(WARPED_FUNGUS_CRATE, "Warped Fungus Crate");
        addBlock(NETHER_WART_CRATE, "Nether Wart Crate");
        addBlock(WITHER_ROSE_CRATE, "Wither Rose Crate");

        // End Stone Crates
        addBlock(CHORUS_FRUIT_CRATE, "Chorus Fruit Crate");
        addBlock(POPPED_CHORUS_FRUIT_CRATE, "Popped Chorus Fruit Crate");

        // Wooden Barrels
        addBlock(COD_BARREL, "Cod Barrel");
        addBlock(COOKED_COD_BARREL, "Cooked Cod Barrel");
        addBlock(SALMON_BARREL, "Salmon Barrel");
        addBlock(COOKED_SALMON_BARREL, "Cooked Salmon Barrel");
        addBlock(INK_SAC_BARREL, "Ink Sac Barrel");
        addBlock(GLOW_INK_SAC_BARREL, "Glow Ink Sac Barrel");
        addBlock(PUFFER_FISH_BARREL, "Pufferfish Barrel");
        addBlock(TROPICAL_FISH_BARREL, "Tropical Fish Barrel");

        // Dye Buckets
        addBlock(WHITE_DYE_BUCKET, "White Dye Bucket");
        addBlock(ORANGE_DYE_BUCKET, "Orange Dye Bucket");
        addBlock(MAGENTA_DYE_BUCKET, "Magenta Dye Bucket");
        addBlock(LIGHT_BLUE_DYE_BUCKET, "Light Blue Dye Bucket");
        addBlock(YELLOW_DYE_BUCKET, "Yellow Dye Bucket");
        addBlock(LIME_DYE_BUCKET, "Lime Dye Bucket");
        addBlock(PINK_DYE_BUCKET, "Pink Dye Bucket");
        addBlock(GRAY_DYE_BUCKET, "Gray Dye Bucket");
        addBlock(LIGHT_GRAY_DYE_BUCKET, "Light Gray Dye Bucket");
        addBlock(CYAN_DYE_BUCKET, "Cyan Dye Bucket");
        addBlock(PURPLE_DYE_BUCKET, "Purple Dye Bucket");
        addBlock(BLUE_DYE_BUCKET, "Blue Dye Bucket");
        addBlock(BROWN_DYE_BUCKET, "Brown Dye Bucket");
        addBlock(GREEN_DYE_BUCKET, "Green Dye Bucket");
        addBlock(RED_DYE_BUCKET, "Red Dye Bucket");
        addBlock(BLACK_DYE_BUCKET, "Black Dye Bucket");

        // Racks
        addBlock(EGG_RACK, "Egg Rack");
        addBlock(TURTLE_EGG_RACK, "Turtle Egg Rack");
        addBlock(BOTTLE_RACK, "Bottle Rack");

        // Sacks
        addBlock(SUGAR_BAG, "Sugar Bag");
        addBlock(GUNPOWDER_BAG, "Gunpowder Bag");
        addBlock(COCOA_BEANS_BAG, "Cocoa Beans Bag");
        addBlock(FEATHER_BAG, "Feather Bag");

        // Seed Bags
        addBlock(WHEAT_SEEDS_BAG, "Wheat Seeds Bag");
        addBlock(BEETROOT_SEEDS_BAG, "Beetroot Seeds Bag");
        addBlock(MELON_SEEDS_BAG, "Melon Seeds Bag");
        addBlock(PUMPKIN_SEEDS_BAG, "Pumpkin Seeds Bag");
        addBlock(TORCHFLOWER_SEEDS_BAG, "Torchflower Seeds Bag");

        // Crimson Bags
        addBlock(BLAZE_POWDER_BAG, "Blaze Powder Bag");

        // Compressed Blocks
        addBlock(FLINT_BLOCK, "Flint Block");
        addBlock(NETHER_STAR_BLOCK, "Nether Star Block");
        addBlock(LEATHER_BLOCK, "Leather Block");
        addBlock(CACTUS_BUNDLE, "Cactus Bundle");
        addBlock(SUGARCANE_BUNDLE, "Sugarcane Bundle");
        addBlock(STICK_BUNDLE, "Stick Bundle");
        addBlock(BLAZE_ROD_BUNDLE, "Blaze Rod Bundle");
        addBlock(GLISTERING_MELON, "Glistering Melon");
        addBlock(SPOOL, "Spool");
        addBlock(BONE_PILE, "Bone Pile");
        addBlock(BOOK_PILE, "Book Pile");
        addBlock(PAPER_STACK, "Paper Stack");
        addBlock(SCUTE_BLOCK, "Scute Block");
        addBlock(PHANTOM_MEMBRANE_BLOCK, "Phantom Membrane Block");
        addBlock(MAGMA_CREAM_BLOCK, "Magma Cream Block");
        addBlock(NAUTILUS_BLOCK, "Nautilus Block");

        // Cross-mod integration translations
        addCrossModTranslations();
    }

    private void addCrossModTranslations() {
        // Ars Nouveau integration
        addBlock(MAGEBLOOM_CRATE, "Magebloom Crate");
        addBlock(SOURCEBERRY_CRATE, "Source Berry Crate");

        // Botania integration
        addBlock(WHITE_MYSTICAL_FLOWER_CRATE, "White Mystical Flower Crate");
        addBlock(ORANGE_MYSTICAL_FLOWER_CRATE, "Orange Mystical Flower Crate");
        addBlock(MAGENTA_MYSTICAL_FLOWER_CRATE, "Magenta Mystical Flower Crate");
        addBlock(LIGHT_BLUE_MYSTICAL_FLOWER_CRATE, "Light Blue Mystical Flower Crate");
        addBlock(YELLOW_MYSTICAL_FLOWER_CRATE, "Yellow Mystical Flower Crate");
        addBlock(LIME_MYSTICAL_FLOWER_CRATE, "Lime Mystical Flower Crate");
        addBlock(PINK_MYSTICAL_FLOWER_CRATE, "Pink Mystical Flower Crate");
        addBlock(GRAY_MYSTICAL_FLOWER_CRATE, "Gray Mystical Flower Crate");
        addBlock(LIGHT_GRAY_MYSTICAL_FLOWER_CRATE, "Light Gray Mystical Flower Crate");
        addBlock(CYAN_MYSTICAL_FLOWER_CRATE, "Cyan Mystical Flower Crate");
        addBlock(PURPLE_MYSTICAL_FLOWER_CRATE, "Purple Mystical Flower Crate");
        addBlock(BLUE_MYSTICAL_FLOWER_CRATE, "Blue Mystical Flower Crate");
        addBlock(BROWN_MYSTICAL_FLOWER_CRATE, "Brown Mystical Flower Crate");
        addBlock(GREEN_MYSTICAL_FLOWER_CRATE, "Green Mystical Flower Crate");
        addBlock(RED_MYSTICAL_FLOWER_CRATE, "Red Mystical Flower Crate");
        addBlock(BLACK_MYSTICAL_FLOWER_CRATE, "Black Mystical Flower Crate");
    }
}
