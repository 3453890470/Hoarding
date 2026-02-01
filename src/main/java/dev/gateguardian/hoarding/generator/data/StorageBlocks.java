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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;
import vazkii.botania.common.block.BotaniaBlocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

@UtilityClass
public class StorageBlocks {

    private final List<Entry> ENTRIES = new ArrayList<>(256);

    public void init() {
        builder(Blocks.PUMPKIN, HoardingItems.PUMPKIN_SLICE)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.ALLIUM_CRATE, Items.ALLIUM).build();
        builder(HoardingBlocks.AZURE_BLUET_CRATE, Items.AZURE_BLUET).build();
        builder(HoardingBlocks.BLUE_ORCHID_CRATE, Items.BLUE_ORCHID).build();
        builder(HoardingBlocks.CORNFLOWER_CRATE, Items.CORNFLOWER).build();
        builder(HoardingBlocks.DANDELION_CRATE, Items.DANDELION).build();
        builder(HoardingBlocks.LILY_CRATE, Items.LILY_OF_THE_VALLEY).build();
        builder(HoardingBlocks.OXEYE_DAISY_CRATE, Items.OXEYE_DAISY).build();
        builder(HoardingBlocks.POPPY_CRATE, Items.POPPY).build();
        builder(HoardingBlocks.ORANGE_TULIP_CRATE, Items.ORANGE_TULIP).build();
        builder(HoardingBlocks.PINK_TULIP_CRATE, Items.PINK_TULIP).build();
        builder(HoardingBlocks.RED_TULIP_CRATE, Items.RED_TULIP).build();
        builder(HoardingBlocks.WHITE_TULIP_CRATE, Items.WHITE_TULIP).build();
        builder(HoardingBlocks.TORCHFLOWER_CRATE, Items.TORCHFLOWER).build();
        builder(HoardingBlocks.APPLE_CRATE, Items.APPLE)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.GOLDEN_APPLE_CRATE, Items.GOLDEN_APPLE)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.POTATO_CRATE, Items.POTATO)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.BAKED_POTATO_CRATE, Items.BAKED_POTATO)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.POISONOUS_POTATO_CRATE, Items.POISONOUS_POTATO)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.BEETROOT_CRATE, Items.BEETROOT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.BROWN_MUSHROOM_CRATE, Items.BROWN_MUSHROOM).build();
        builder(HoardingBlocks.RED_MUSHROOM_CRATE, Items.RED_MUSHROOM).build();
        builder(HoardingBlocks.CARROT_CRATE, Items.CARROT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.GOLDEN_CARROT_CRATE, Items.GOLDEN_CARROT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.SWEET_BERRIES_CRATE, Items.SWEET_BERRIES)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.GLOW_BERRIES_CRATE, Items.GLOW_BERRIES)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.COOKIE_CRATE, Items.COOKIE)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.BREAD_CRATE, Items.BREAD)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.BEEF_CRATE, Items.BEEF)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.COOKED_BEEF_CRATE, Items.COOKED_BEEF)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.CHICKEN_CRATE, Items.CHICKEN)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.COOKED_CHICKEN_CRATE, Items.COOKED_CHICKEN)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.MUTTON_CRATE, Items.MUTTON)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.COOKED_MUTTON_CRATE, Items.COOKED_MUTTON)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.RABBIT_CRATE, Items.RABBIT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.COOKED_RABBIT_CRATE, Items.COOKED_RABBIT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.RABBIT_FOOT_CRATE, Items.RABBIT_FOOT).build();
        builder(HoardingBlocks.PORKCHOP_CRATE, Items.PORKCHOP)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.COOKED_PORKCHOP_CRATE, Items.COOKED_PORKCHOP)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.ENDER_EYE_CRATE, Items.ENDER_EYE).build();
        builder(HoardingBlocks.ENDER_PEARL_CRATE, Items.ENDER_PEARL).build();
        builder(HoardingBlocks.ROTTEN_FLESH_CRATE, Items.ROTTEN_FLESH).build();
        builder(HoardingBlocks.SPIDER_EYE_CRATE, Items.SPIDER_EYE).build();
        builder(HoardingBlocks.FERMENTED_SPIDER_EYE_CRATE, Items.FERMENTED_SPIDER_EYE).build();
        builder(HoardingBlocks.CRIMSON_FUNGUS_CRATE, Items.CRIMSON_FUNGUS).build();
        builder(HoardingBlocks.WARPED_FUNGUS_CRATE, Items.WARPED_FUNGUS).build();
        builder(HoardingBlocks.NETHER_WART_CRATE, Items.NETHER_WART).build();
        builder(HoardingBlocks.WITHER_ROSE_CRATE, Items.WITHER_ROSE).build();
        builder(HoardingBlocks.CHORUS_FRUIT_CRATE, Items.CHORUS_FRUIT)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.POPPED_CHORUS_FRUIT_CRATE, Items.POPPED_CHORUS_FRUIT).build();
        builder(HoardingBlocks.COD_BARREL, Items.COD)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.COOKED_COD_BARREL, Items.COOKED_COD)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.SALMON_BARREL, Items.SALMON)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.COOKED_SALMON_BARREL, Items.COOKED_SALMON)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.INK_SAC_BARREL, Items.INK_SAC).build();
        builder(HoardingBlocks.GLOW_INK_SAC_BARREL, Items.GLOW_INK_SAC).build();
        builder(HoardingBlocks.PUFFER_FISH_BARREL, Items.PUFFERFISH)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.TROPICAL_FISH_BARREL, Items.TROPICAL_FISH)
                .unpackedCategory(RecipeCategory.FOOD)
                .build();
        builder(HoardingBlocks.WHITE_DYE_BUCKET, Items.WHITE_DYE).build();
        builder(HoardingBlocks.ORANGE_DYE_BUCKET, Items.ORANGE_DYE).build();
        builder(HoardingBlocks.MAGENTA_DYE_BUCKET, Items.MAGENTA_DYE).build();
        builder(HoardingBlocks.LIGHT_BLUE_DYE_BUCKET, Items.LIGHT_BLUE_DYE).build();
        builder(HoardingBlocks.YELLOW_DYE_BUCKET, Items.YELLOW_DYE).build();
        builder(HoardingBlocks.LIME_DYE_BUCKET, Items.LIME_DYE).build();
        builder(HoardingBlocks.PINK_DYE_BUCKET, Items.PINK_DYE).build();
        builder(HoardingBlocks.GRAY_DYE_BUCKET, Items.GRAY_DYE).build();
        builder(HoardingBlocks.LIGHT_GRAY_DYE_BUCKET, Items.LIGHT_GRAY_DYE).build();
        builder(HoardingBlocks.CYAN_DYE_BUCKET, Items.CYAN_DYE).build();
        builder(HoardingBlocks.PURPLE_DYE_BUCKET, Items.PURPLE_DYE).build();
        builder(HoardingBlocks.BLUE_DYE_BUCKET, Items.BLUE_DYE).build();
        builder(HoardingBlocks.BROWN_DYE_BUCKET, Items.BROWN_DYE).build();
        builder(HoardingBlocks.GREEN_DYE_BUCKET, Items.GREEN_DYE).build();
        builder(HoardingBlocks.RED_DYE_BUCKET, Items.RED_DYE).build();
        builder(HoardingBlocks.BLACK_DYE_BUCKET, Items.BLACK_DYE).build();
        builder(HoardingBlocks.EGG_RACK, Items.EGG).build();
        builder(HoardingBlocks.TURTLE_EGG_RACK, Items.TURTLE_EGG).build();
        builder(HoardingBlocks.BOTTLE_RACK, Items.GLASS_BOTTLE).build();
        builder(HoardingBlocks.SUGAR_BAG, Items.SUGAR).build();
        builder(HoardingBlocks.GUNPOWDER_BAG, Items.GUNPOWDER).build();
        builder(HoardingBlocks.COCOA_BEANS_BAG, Items.COCOA_BEANS).build();
        builder(HoardingBlocks.FEATHER_BAG, Items.FEATHER).build();
        builder(HoardingBlocks.WHEAT_SEEDS_BAG, Items.WHEAT_SEEDS).build();
        builder(HoardingBlocks.BEETROOT_SEEDS_BAG, Items.BEETROOT_SEEDS).build();
        builder(HoardingBlocks.MELON_SEEDS_BAG, Items.MELON_SEEDS).build();
        builder(HoardingBlocks.PUMPKIN_SEEDS_BAG, Items.PUMPKIN_SEEDS).build();
        builder(HoardingBlocks.TORCHFLOWER_SEEDS_BAG, Items.TORCHFLOWER_SEEDS).build();
        builder(HoardingBlocks.BLAZE_POWDER_BAG, Items.BLAZE_POWDER).build();
        builder(HoardingBlocks.FLINT_BLOCK, Items.FLINT).build();
        builder(HoardingBlocks.NETHER_STAR_BLOCK, Items.NETHER_STAR).build();
        builder(HoardingBlocks.LEATHER_BLOCK, Items.LEATHER).build();
        builder(HoardingBlocks.CACTUS_BUNDLE, Items.CACTUS).build();
        builder(HoardingBlocks.SUGARCANE_BUNDLE, Items.SUGAR_CANE).build();
        builder(HoardingBlocks.STICK_BUNDLE, Items.STICK).build();
        builder(HoardingBlocks.BLAZE_ROD_BUNDLE, Items.BLAZE_ROD).build();
        builder(HoardingBlocks.GLISTERING_MELON, Items.GLISTERING_MELON_SLICE).build();
        builder(HoardingBlocks.SPOOL, Items.STRING).build();
        builder(HoardingBlocks.BONE_PILE, Items.BONE).build();
        builder(HoardingBlocks.BOOK_PILE, Items.BOOK).build();
        builder(HoardingBlocks.PAPER_STACK, Items.PAPER).build();
        builder(HoardingBlocks.SCUTE_BLOCK, Items.SCUTE).build();
        builder(HoardingBlocks.PHANTOM_MEMBRANE_BLOCK, Items.PHANTOM_MEMBRANE).build();
        builder(HoardingBlocks.MAGMA_CREAM_BLOCK, Items.MAGMA_CREAM).build();
        builder(HoardingBlocks.NAUTILUS_BLOCK, Items.NAUTILUS_SHELL).build();
        // Ars Nouveau
        builder(HoardingArsNouveauBlocks.MAGEBLOOM_CRATE, ItemsRegistry.MAGE_BLOOM)
                .modId(ModIntegration.ARS_NOUVEAU_MOD_ID)
                .build();

        builder(HoardingArsNouveauBlocks.SOURCEBERRY_CRATE, BlockRegistry.SOURCEBERRY_BUSH.asItem())
                .unpackedCategory(RecipeCategory.FOOD)
                .modId(ModIntegration.ARS_NOUVEAU_MOD_ID)
                .build();

        // Botania
        builder(HoardingBotaniaBlocks.WHITE_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.whiteFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.ORANGE_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.orangeFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.MAGENTA_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.magentaFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.LIGHT_BLUE_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.lightBlueFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.YELLOW_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.yellowFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.LIME_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.limeFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.PINK_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.pinkFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.GRAY_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.grayFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.LIGHT_GRAY_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.lightGrayFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.CYAN_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.cyanFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.PURPLE_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.purpleFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.BLUE_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.blueFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.BROWN_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.brownFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.GREEN_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.greenFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.RED_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.redFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();

        builder(HoardingBotaniaBlocks.BLACK_MYSTICAL_FLOWER_CRATE, BotaniaBlocks.blackFlower.asItem())
                .modId(ModIntegration.BOTANIA_MOD_ID)
                .build();
    }

    public Builder builder(Supplier<? extends Block> storageBlock, Supplier<? extends Item> sourceItem) {
        return new Builder(storageBlock, sourceItem);
    }

    public Builder builder(Supplier<? extends Block> storageBlock, Item sourceItem) {
        return new Builder(storageBlock, () -> sourceItem);
    }

    public Builder builder(Block storageBlock, Supplier<? extends Item> sourceItem) {
        return new Builder(() -> storageBlock, sourceItem);
    }

    public List<Entry> getEntries() {
        return Collections.unmodifiableList(ENTRIES);
    }

    public record Entry(
            Supplier<? extends Block> storageBlock,
            Supplier<? extends Item> sourceItem,
            RecipeCategory unpackedCategory,
            RecipeCategory packedCategory,
            @Nullable String modId
    ) {

        public Block getBlock() {
            return storageBlock.get();
        }

        public Item getItem() {
            return sourceItem.get();
        }
    }

    public class Builder {
        private final Supplier<? extends Block> storageBlock;
        private final Supplier<? extends Item> sourceItem;
        private RecipeCategory unpackedCategory = RecipeCategory.MISC;
        private RecipeCategory packedCategory = RecipeCategory.BUILDING_BLOCKS;
        @Nullable
        private String modId = null;

        private Builder(Supplier<? extends Block> storageBlock, Supplier<? extends Item> sourceItem) {
            this.storageBlock = storageBlock;
            this.sourceItem = sourceItem;
        }

        public Builder unpackedCategory(RecipeCategory category) {
            this.unpackedCategory = category;
            return this;
        }

        public Builder packedCategory(RecipeCategory category) {
            this.packedCategory = category;
            return this;
        }

        public Builder modId(String modId) {
            this.modId = modId;
            return this;
        }

        public void build() {
            ENTRIES.add(new Entry(
                    storageBlock,
                    sourceItem,
                    unpackedCategory,
                    packedCategory,
                    modId
            ));
        }
    }
}
