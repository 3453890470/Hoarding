package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class HoardingBlockTagsProvider extends BlockTagsProvider {

    public HoardingBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Hoarding.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        var storageBlocks = tag(Tags.Blocks.STORAGE_BLOCKS);
        for (var entry : StorageBlocks.getEntries()) {
            Block block = entry.getBlock();
            Item item = entry.getItem();
            TagKey<Block> subTag = createStorageBlockSubTag(item);
            if (entry.modId() != null) {
                tag(subTag).addOptional(block);
                storageBlocks.addOptionalTag(subTag);
            } else {
                tag(subTag).add(block);
                storageBlocks.addTag(subTag);
            }
        }
        tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(HoardingBlocks.BOOK_PILE.get());

        // ====== AXE (wooden / wool / plant blocks) ======

        var axe = tag(BlockTags.MINEABLE_WITH_AXE);

        // --- Birch crates ---
        axe.add(HoardingBlocks.ALLIUM_CRATE.get());
        axe.add(HoardingBlocks.AZURE_BLUET_CRATE.get());
        axe.add(HoardingBlocks.BLUE_ORCHID_CRATE.get());
        axe.add(HoardingBlocks.CORNFLOWER_CRATE.get());
        axe.add(HoardingBlocks.DANDELION_CRATE.get());
        axe.add(HoardingBlocks.LILY_CRATE.get());
        axe.add(HoardingBlocks.OXEYE_DAISY_CRATE.get());
        axe.add(HoardingBlocks.POPPY_CRATE.get());
        axe.add(HoardingBlocks.ORANGE_TULIP_CRATE.get());
        axe.add(HoardingBlocks.PINK_TULIP_CRATE.get());
        axe.add(HoardingBlocks.RED_TULIP_CRATE.get());
        axe.add(HoardingBlocks.WHITE_TULIP_CRATE.get());
        axe.add(HoardingBlocks.TORCHFLOWER_CRATE.get());

        // --- Oak crates ---
        axe.add(HoardingBlocks.APPLE_CRATE.get());
        axe.add(HoardingBlocks.GOLDEN_APPLE_CRATE.get());
        axe.add(HoardingBlocks.POTATO_CRATE.get());
        axe.add(HoardingBlocks.BAKED_POTATO_CRATE.get());
        axe.add(HoardingBlocks.POISONOUS_POTATO_CRATE.get());
        axe.add(HoardingBlocks.BEETROOT_CRATE.get());
        axe.add(HoardingBlocks.BROWN_MUSHROOM_CRATE.get());
        axe.add(HoardingBlocks.RED_MUSHROOM_CRATE.get());
        axe.add(HoardingBlocks.CARROT_CRATE.get());
        axe.add(HoardingBlocks.GOLDEN_CARROT_CRATE.get());
        axe.add(HoardingBlocks.SWEET_BERRIES_CRATE.get());
        axe.add(HoardingBlocks.GLOW_BERRIES_CRATE.get());
        axe.add(HoardingBlocks.COOKIE_CRATE.get());
        axe.add(HoardingBlocks.BREAD_CRATE.get());

        // --- Spruce crates ---
        axe.add(HoardingBlocks.BEEF_CRATE.get());
        axe.add(HoardingBlocks.COOKED_BEEF_CRATE.get());
        axe.add(HoardingBlocks.CHICKEN_CRATE.get());
        axe.add(HoardingBlocks.COOKED_CHICKEN_CRATE.get());
        axe.add(HoardingBlocks.MUTTON_CRATE.get());
        axe.add(HoardingBlocks.COOKED_MUTTON_CRATE.get());
        axe.add(HoardingBlocks.RABBIT_CRATE.get());
        axe.add(HoardingBlocks.COOKED_RABBIT_CRATE.get());
        axe.add(HoardingBlocks.RABBIT_FOOT_CRATE.get());
        axe.add(HoardingBlocks.PORKCHOP_CRATE.get());
        axe.add(HoardingBlocks.COOKED_PORKCHOP_CRATE.get());

        // --- Crimson crates ---
        axe.add(HoardingBlocks.CRIMSON_FUNGUS_CRATE.get());
        axe.add(HoardingBlocks.WARPED_FUNGUS_CRATE.get());
        axe.add(HoardingBlocks.NETHER_WART_CRATE.get());
        axe.add(HoardingBlocks.WITHER_ROSE_CRATE.get());

        // --- Iron crates ---
        axe.add(HoardingBlocks.ENDER_EYE_CRATE.get());
        axe.add(HoardingBlocks.ENDER_PEARL_CRATE.get());
        axe.add(HoardingBlocks.ROTTEN_FLESH_CRATE.get());
        axe.add(HoardingBlocks.SPIDER_EYE_CRATE.get());
        axe.add(HoardingBlocks.FERMENTED_SPIDER_EYE_CRATE.get());

        // --- End stone crates ---
        axe.add(HoardingBlocks.CHORUS_FRUIT_CRATE.get());
        axe.add(HoardingBlocks.POPPED_CHORUS_FRUIT_CRATE.get());

        // --- Barrels ---
        axe.add(HoardingBlocks.COD_BARREL.get());
        axe.add(HoardingBlocks.COOKED_COD_BARREL.get());
        axe.add(HoardingBlocks.SALMON_BARREL.get());
        axe.add(HoardingBlocks.COOKED_SALMON_BARREL.get());
        axe.add(HoardingBlocks.INK_SAC_BARREL.get());
        axe.add(HoardingBlocks.GLOW_INK_SAC_BARREL.get());
        axe.add(HoardingBlocks.PUFFER_FISH_BARREL.get());
        axe.add(HoardingBlocks.TROPICAL_FISH_BARREL.get());

        // --- Buckets ---
        axe.add(HoardingBlocks.WHITE_DYE_BUCKET.get());
        axe.add(HoardingBlocks.ORANGE_DYE_BUCKET.get());
        axe.add(HoardingBlocks.MAGENTA_DYE_BUCKET.get());
        axe.add(HoardingBlocks.LIGHT_BLUE_DYE_BUCKET.get());
        axe.add(HoardingBlocks.YELLOW_DYE_BUCKET.get());
        axe.add(HoardingBlocks.LIME_DYE_BUCKET.get());
        axe.add(HoardingBlocks.PINK_DYE_BUCKET.get());
        axe.add(HoardingBlocks.GRAY_DYE_BUCKET.get());
        axe.add(HoardingBlocks.LIGHT_GRAY_DYE_BUCKET.get());
        axe.add(HoardingBlocks.CYAN_DYE_BUCKET.get());
        axe.add(HoardingBlocks.PURPLE_DYE_BUCKET.get());
        axe.add(HoardingBlocks.BLUE_DYE_BUCKET.get());
        axe.add(HoardingBlocks.BROWN_DYE_BUCKET.get());
        axe.add(HoardingBlocks.GREEN_DYE_BUCKET.get());
        axe.add(HoardingBlocks.RED_DYE_BUCKET.get());
        axe.add(HoardingBlocks.BLACK_DYE_BUCKET.get());

        // --- Racks ---
        axe.add(HoardingBlocks.EGG_RACK.get());
        axe.add(HoardingBlocks.TURTLE_EGG_RACK.get());
        axe.add(HoardingBlocks.BOTTLE_RACK.get());

        // --- Bags ---
        axe.add(HoardingBlocks.SUGAR_BAG.get());
        axe.add(HoardingBlocks.GUNPOWDER_BAG.get());
        axe.add(HoardingBlocks.COCOA_BEANS_BAG.get());
        axe.add(HoardingBlocks.FEATHER_BAG.get());

        // --- Seed bags ---
        axe.add(HoardingBlocks.WHEAT_SEEDS_BAG.get());
        axe.add(HoardingBlocks.BEETROOT_SEEDS_BAG.get());
        axe.add(HoardingBlocks.MELON_SEEDS_BAG.get());
        axe.add(HoardingBlocks.PUMPKIN_SEEDS_BAG.get());
        axe.add(HoardingBlocks.TORCHFLOWER_SEEDS_BAG.get());

        // --- Nether bag ---
        axe.add(HoardingBlocks.BLAZE_POWDER_BAG.get());

        // --- Bundles ---
        axe.add(HoardingBlocks.CACTUS_BUNDLE.get());
        axe.add(HoardingBlocks.SUGARCANE_BUNDLE.get());
        axe.add(HoardingBlocks.STICK_BUNDLE.get());
        axe.add(HoardingBlocks.BLAZE_ROD_BUNDLE.get());

        // --- Books & paper ---
        axe.add(HoardingBlocks.BOOK_PILE.get());
        axe.add(HoardingBlocks.PAPER_STACK.get());

        // --- Spool ---
        axe.add(HoardingBlocks.SPOOL.get());

        // --- Leather / membrane ---
        axe.add(HoardingBlocks.LEATHER_BLOCK.get());
        axe.add(HoardingBlocks.PHANTOM_MEMBRANE_BLOCK.get());

        // --- Glistering melon (plant-based) ---
        axe.add(HoardingBlocks.GLISTERING_MELON.get());

        // ====== PICKAXE (stone / bone / metal blocks) ======
        var pickaxe = tag(BlockTags.MINEABLE_WITH_PICKAXE);
        pickaxe.add(HoardingBlocks.FLINT_BLOCK.get());
        pickaxe.add(HoardingBlocks.NETHER_STAR_BLOCK.get());
        pickaxe.add(HoardingBlocks.SCUTE_BLOCK.get());
        pickaxe.add(HoardingBlocks.NAUTILUS_SHELL_BLOCK.get());
        pickaxe.add(HoardingBlocks.MAGMA_CREAM_BLOCK.get());
        pickaxe.add(HoardingBlocks.BONE_PILE.get());
    }

    private TagKey<Block> createStorageBlockSubTag(Item item) {
        Identifier itemKey = Objects.requireNonNull(
                BuiltInRegistries.ITEM.getKey(item), "Item is not registered!"
        );
        return TagKey.create(
                Registries.BLOCK,
                Identifier.fromNamespaceAndPath("c", "storage_blocks/" + itemKey.getPath())
        );
    }
}
