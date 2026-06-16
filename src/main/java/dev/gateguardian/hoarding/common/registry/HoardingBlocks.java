package dev.gateguardian.hoarding.common.registry;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.common.block.HorizontalFacingBlock;
import dev.gateguardian.hoarding.common.block.HotFoodBlock;
import dev.gateguardian.hoarding.common.block.MobEffectBlock;
import dev.gateguardian.hoarding.common.block.NautilusBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class HoardingBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Hoarding.MOD_ID);

    // =================================================================
    // 主世界 (Overworld)
    // =================================================================

    //region === 主世界 · 白桦木箱子 (Birch Crates — 花/材料类) ===
    public static final DeferredBlock<Block> ALLIUM_CRATE = birchCrate("allium_crate");
    public static final DeferredBlock<Block> AZURE_BLUET_CRATE = birchCrate("azure_bluet_crate");
    public static final DeferredBlock<Block> BLUE_ORCHID_CRATE = birchCrate("blue_orchid_crate");
    public static final DeferredBlock<Block> CORNFLOWER_CRATE = birchCrate("cornflower_crate");
    public static final DeferredBlock<Block> DANDELION_CRATE = birchCrate("dandelion_crate");
    public static final DeferredBlock<Block> LILY_CRATE = birchCrate("lily_crate");
    public static final DeferredBlock<Block> OXEYE_DAISY_CRATE = birchCrate("oxeye_daisy_crate");
    public static final DeferredBlock<Block> POPPY_CRATE = birchCrate("poppy_crate");
    public static final DeferredBlock<Block> ORANGE_TULIP_CRATE = birchCrate("orange_tulip_crate");
    public static final DeferredBlock<Block> PINK_TULIP_CRATE = birchCrate("pink_tulip_crate");
    public static final DeferredBlock<Block> RED_TULIP_CRATE = birchCrate("red_tulip_crate");
    public static final DeferredBlock<Block> WHITE_TULIP_CRATE = birchCrate("white_tulip_crate");
    public static final DeferredBlock<Block> TORCHFLOWER_CRATE = birchCrate("torchflower_crate");
    //endregion

    //region === 主世界 · 橡木箱子 (Oak Crates — 食材/蘑菇类) ===
    public static final DeferredBlock<Block> APPLE_CRATE = oakCrate("apple_crate");
    public static final DeferredBlock<Block> GOLDEN_APPLE_CRATE = oakCrate("golden_apple_crate");
    public static final DeferredBlock<Block> POTATO_CRATE = oakCrate("potato_crate");
    public static final DeferredBlock<Block> BAKED_POTATO_CRATE = oakCrate("baked_potato_crate", HotFoodBlock::new);
    public static final DeferredBlock<Block> POISONOUS_POTATO_CRATE = oakCrate("poisonous_potato_crate");
    public static final DeferredBlock<Block> BEETROOT_CRATE = oakCrate("beetroot_crate");
    public static final DeferredBlock<Block> BROWN_MUSHROOM_CRATE = oakCrate("brown_mushroom_crate");
    public static final DeferredBlock<Block> RED_MUSHROOM_CRATE = oakCrate("red_mushroom_crate");
    public static final DeferredBlock<Block> CARROT_CRATE = oakCrate("carrot_crate");
    public static final DeferredBlock<Block> GOLDEN_CARROT_CRATE = oakCrate("golden_carrot_crate");
    public static final DeferredBlock<Block> SWEET_BERRIES_CRATE = oakCrate("sweet_berries_crate");
    public static final DeferredBlock<Block> GLOW_BERRIES_CRATE = oakCrate("glow_berries_crate");
    public static final DeferredBlock<Block> COOKIE_CRATE = oakCrate("cookie_crate", HotFoodBlock::new);
    public static final DeferredBlock<Block> BREAD_CRATE = oakCrate("bread_crate", HotFoodBlock::new);
    //endregion

    //region === 主世界 · 云杉木箱子 (Spruce Crates — 肉类) ===
    public static final DeferredBlock<Block> BEEF_CRATE = spruceCrate("beef_crate");
    public static final DeferredBlock<Block> COOKED_BEEF_CRATE = spruceCrate("cooked_beef_crate", HotFoodBlock::new);
    public static final DeferredBlock<Block> CHICKEN_CRATE = spruceCrate("chicken_crate");
    public static final DeferredBlock<Block> COOKED_CHICKEN_CRATE = spruceCrate("cooked_chicken_crate", HotFoodBlock::new);
    public static final DeferredBlock<Block> MUTTON_CRATE = spruceCrate("mutton_crate");
    public static final DeferredBlock<Block> COOKED_MUTTON_CRATE = spruceCrate("cooked_mutton_crate", HotFoodBlock::new);
    public static final DeferredBlock<Block> RABBIT_CRATE = spruceCrate("rabbit_crate");
    public static final DeferredBlock<Block> COOKED_RABBIT_CRATE = spruceCrate("cooked_rabbit_crate", HotFoodBlock::new);
    public static final DeferredBlock<Block> RABBIT_FOOT_CRATE = spruceCrate("rabbit_foot_crate");
    public static final DeferredBlock<Block> PORKCHOP_CRATE = spruceCrate("porkchop_crate");
    public static final DeferredBlock<Block> COOKED_PORKCHOP_CRATE = spruceCrate("cooked_porkchop_crate", HotFoodBlock::new);
    //endregion
    //region === 下界 · 绯红菌箱子 (Crimson Crates) ===
    public static final DeferredBlock<Block> CRIMSON_FUNGUS_CRATE = crimsonCrate("crimson_fungus_crate");
    public static final DeferredBlock<Block> WARPED_FUNGUS_CRATE = crimsonCrate("warped_fungus_crate");
    public static final DeferredBlock<Block> NETHER_WART_CRATE = crimsonCrate("nether_wart_crate");
    public static final DeferredBlock<Block> WITHER_ROSE_CRATE = crimsonCrate("wither_rose_crate",
            props -> new MobEffectBlock(props, MobEffects.WITHER));
    //endregion

    //region === 主世界 · 铁箱子 (Iron Crates) ===
    public static final DeferredBlock<Block> ENDER_EYE_CRATE = ironCrate("ender_eye_crate");
    public static final DeferredBlock<Block> ENDER_PEARL_CRATE = ironCrate("ender_pearl_crate");
    public static final DeferredBlock<Block> ROTTEN_FLESH_CRATE = ironCrate("rotten_flesh_crate");
    public static final DeferredBlock<Block> SPIDER_EYE_CRATE = ironCrate("spider_eye_crate");
    public static final DeferredBlock<Block> FERMENTED_SPIDER_EYE_CRATE = ironCrate("fermented_spider_eye_crate");
    //endregion

    //region === 主世界 · 木桶 (Barrels) ===
    public static final DeferredBlock<Block> COD_BARREL = barrel("cod_barrel");
    public static final DeferredBlock<Block> COOKED_COD_BARREL = barrel("cooked_cod_barrel", HotFoodBlock::new);
    public static final DeferredBlock<Block> SALMON_BARREL = barrel("salmon_barrel");
    public static final DeferredBlock<Block> COOKED_SALMON_BARREL = barrel("cooked_salmon_barrel", HotFoodBlock::new);
    public static final DeferredBlock<Block> INK_SAC_BARREL = barrel("ink_sac_barrel");
    public static final DeferredBlock<Block> GLOW_INK_SAC_BARREL = barrel("glow_ink_sac_barrel");
    public static final DeferredBlock<Block> PUFFER_FISH_BARREL = barrel(
            "pufferfish_barrel",
            props -> new MobEffectBlock(props, MobEffects.POISON)
    );
    public static final DeferredBlock<Block> TROPICAL_FISH_BARREL = barrel("tropical_fish_barrel");
    //endregion

    //region === 主世界 · 染料桶 (Buckets) ===
    public static final DeferredBlock<Block> WHITE_DYE_BUCKET = bucket("white_dye_bucket");
    public static final DeferredBlock<Block> ORANGE_DYE_BUCKET = bucket("orange_dye_bucket");
    public static final DeferredBlock<Block> MAGENTA_DYE_BUCKET = bucket("magenta_dye_bucket");
    public static final DeferredBlock<Block> LIGHT_BLUE_DYE_BUCKET = bucket("light_blue_dye_bucket");
    public static final DeferredBlock<Block> YELLOW_DYE_BUCKET = bucket("yellow_dye_bucket");
    public static final DeferredBlock<Block> LIME_DYE_BUCKET = bucket("lime_dye_bucket");
    public static final DeferredBlock<Block> PINK_DYE_BUCKET = bucket("pink_dye_bucket");
    public static final DeferredBlock<Block> GRAY_DYE_BUCKET = bucket("gray_dye_bucket");
    public static final DeferredBlock<Block> LIGHT_GRAY_DYE_BUCKET = bucket("light_gray_dye_bucket");
    public static final DeferredBlock<Block> CYAN_DYE_BUCKET = bucket("cyan_dye_bucket");
    public static final DeferredBlock<Block> PURPLE_DYE_BUCKET = bucket("purple_dye_bucket");
    public static final DeferredBlock<Block> BLUE_DYE_BUCKET = bucket("blue_dye_bucket");
    public static final DeferredBlock<Block> BROWN_DYE_BUCKET = bucket("brown_dye_bucket");
    public static final DeferredBlock<Block> GREEN_DYE_BUCKET = bucket("green_dye_bucket");
    public static final DeferredBlock<Block> RED_DYE_BUCKET = bucket("red_dye_bucket");
    public static final DeferredBlock<Block> BLACK_DYE_BUCKET = bucket("black_dye_bucket");
    //endregion

    //region === 主世界 · 架子 (Racks) ===
    public static final DeferredBlock<Block> EGG_RACK = rack("egg_rack");
    public static final DeferredBlock<Block> TURTLE_EGG_RACK = rack("turtle_egg_rack");
    public static final DeferredBlock<Block> BOTTLE_RACK = rack("bottle_rack");
    //endregion

    //region === 主世界 · 袋子 (Sacks) ===
    public static final DeferredBlock<Block> SUGAR_BAG = bag("sugar_bag");
    public static final DeferredBlock<Block> GUNPOWDER_BAG = bag("gunpowder_bag");
    public static final DeferredBlock<Block> COCOA_BEANS_BAG = bag("cocoa_beans_bag");
    public static final DeferredBlock<Block> FEATHER_BAG = bag("feather_bag");
    //endregion

    //region === 主世界 · 种子袋 (Seed Bags) ===
    public static final DeferredBlock<Block> WHEAT_SEEDS_BAG = bag("wheat_seeds_bag");
    public static final DeferredBlock<Block> BEETROOT_SEEDS_BAG = bag("beetroot_seeds_bag");
    public static final DeferredBlock<Block> MELON_SEEDS_BAG = bag("melon_seeds_bag");
    public static final DeferredBlock<Block> PUMPKIN_SEEDS_BAG = bag("pumpkin_seeds_bag");
    public static final DeferredBlock<Block> TORCHFLOWER_SEEDS_BAG = bag("torchflower_seeds_bag");
    //endregion

    //region === 主世界 · 压缩方块 (Compressed Blocks) ===
    public static final DeferredBlock<Block> FLINT_BLOCK = block(
            "flint_block",
            () -> BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.STONE).requiresCorrectToolForDrops(),
            Block::new
    );
    public static final DeferredBlock<RotatedPillarBlock> LEATHER_BLOCK = block(
            "leather_block",
            () -> BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOL),
            RotatedPillarBlock::new
    );
    public static final DeferredBlock<RotatedPillarBlock> CACTUS_BUNDLE = block(
            "cactus_bundle",
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS),
            RotatedPillarBlock::new
    );
    public static final DeferredBlock<RotatedPillarBlock> SUGARCANE_BUNDLE = block(
            "sugarcane_bundle",
            () -> BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD),
            RotatedPillarBlock::new
    );
    public static final DeferredBlock<RotatedPillarBlock> STICK_BUNDLE = block(
            "stick_bundle",
            () -> BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD),
            RotatedPillarBlock::new
    );
    public static final DeferredBlock<RotatedPillarBlock> GLISTERING_MELON = block(
            "glistering_melon",
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MELON),
            RotatedPillarBlock::new
    );
    public static final DeferredBlock<RotatedPillarBlock> SPOOL = block(
            "spool",
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL),
            RotatedPillarBlock::new
    );
    public static final DeferredBlock<RotatedPillarBlock> BONE_PILE = block(
            "bone_pile",
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK),
            RotatedPillarBlock::new
    );
    public static final DeferredBlock<HorizontalFacingBlock> BOOK_PILE = block(
            "book_pile",
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF),
            HorizontalFacingBlock::new
    );
    public static final DeferredBlock<HorizontalFacingBlock> PAPER_STACK = block(
            "paper_stack",
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL),
            HorizontalFacingBlock::new
    );
    public static final DeferredBlock<HorizontalFacingBlock> SCUTE_BLOCK = block(
            "scute_block",
            () -> BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOL),
            HorizontalFacingBlock::new
    );
    public static final DeferredBlock<HorizontalFacingBlock> PHANTOM_MEMBRANE_BLOCK = block(
            "phantom_membrane_block",
            () -> BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOL),
            HorizontalFacingBlock::new
    );
    public static final DeferredBlock<Block> NAUTILUS_BLOCK = block(
            "nautilus_block",
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).strength(2.0F, 3.0F).sound(SoundType.BONE_BLOCK),
            NautilusBlock::new
    );
    //endregion

    // =================================================================
    // 下界 (Nether)
    // =================================================================


    //region === 下界 · 绯红菌袋子 (Crimson Bags) ===
    public static final DeferredBlock<Block> BLAZE_POWDER_BAG = bag("blaze_powder_bag");
    //endregion

    //region === 下界 · 压缩方块 (Compressed Blocks) ===
    public static final DeferredBlock<Block> NETHER_STAR_BLOCK = block(
            "nether_star_block",
            () -> BlockBehaviour.Properties.of().strength(50.0F, 1200.0F).sound(SoundType.METAL).requiresCorrectToolForDrops(),
            Block::new
    );
    public static final DeferredBlock<RotatedPillarBlock> BLAZE_ROD_BUNDLE = block(
            "blaze_rod_bundle",
            () -> BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).lightLevel(state -> 10),
            RotatedPillarBlock::new
    );
    public static final DeferredBlock<HorizontalFacingBlock> MAGMA_CREAM_BLOCK = block(
            "magma_cream_block",
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SLIME_BLOCK).strength(2.0F, 3.0F).sound(SoundType.SLIME_BLOCK).lightLevel(state -> 10),
            HorizontalFacingBlock::new
    );
    //endregion

    // =================================================================
    // 末地 (End)
    // =================================================================

    //region === 末地 · 末地石箱子 (End Stone Crates) ===
    public static final DeferredBlock<Block> CHORUS_FRUIT_CRATE = endStoneCrate("chorus_fruit_crate");
    public static final DeferredBlock<Block> POPPED_CHORUS_FRUIT_CRATE = endStoneCrate("popped_chorus_fruit_crate");
    //endregion

    // =================================================================
    // 其他 (Other) — 目前无不属于以上三类的方块
    // =================================================================

    // =================================================================
    // 注册入口
    // =================================================================

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    /** 3-arg block registration — MC 26.1.2 requires this form so that DeferredRegister can set block ID on Properties */
    public static <T extends Block> DeferredBlock<T> block(String name, Supplier<BlockBehaviour.Properties> properties, Function<BlockBehaviour.Properties, T> factory) {
        DeferredBlock<T> block = BLOCKS.registerBlock(name, factory, properties);
        // MC 26.1.2: BlockItem needs item ID set in Properties before construction.
        // 使用 registerSimpleBlockItem 自动处理 ID 设置，并将 BlockItem 加入创造模式标签页
        var blockItem = HoardingItems.ITEMS.registerSimpleBlockItem(name, block, () -> new Item.Properties());
        HoardingItems.CREATIVE_MODE_TAB_ITEMS.offer(blockItem);
        return block;
    }

    // === Crates ===
    private static DeferredBlock<Block> birchCrate(String name) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS), Block::new);
    }
    private static DeferredBlock<Block> birchCrate(String name, Function<BlockBehaviour.Properties, Block> factory) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS), factory);
    }

    private static DeferredBlock<Block> oakCrate(String name) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), Block::new);
    }
    private static DeferredBlock<Block> oakCrate(String name, Function<BlockBehaviour.Properties, Block> factory) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), factory);
    }

    private static DeferredBlock<Block> spruceCrate(String name) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), Block::new);
    }
    private static DeferredBlock<Block> spruceCrate(String name, Function<BlockBehaviour.Properties, Block> factory) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), factory);
    }

    private static DeferredBlock<Block> crimsonCrate(String name) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), Block::new);
    }
    private static DeferredBlock<Block> crimsonCrate(String name, Function<BlockBehaviour.Properties, Block> factory) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), factory);
    }

    // Iron Crates (use iron block properties)
    private static DeferredBlock<Block> ironCrate(String name) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), Block::new);
    }

    // End Stone Crates
    private static DeferredBlock<Block> endStoneCrate(String name) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE), Block::new);
    }

    // Barrels
    private static DeferredBlock<Block> barrel(String name) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), Block::new);
    }
    private static DeferredBlock<Block> barrel(String name, Function<BlockBehaviour.Properties, Block> factory) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), factory);
    }

    // Buckets (use iron properties)
    private static DeferredBlock<Block> bucket(String name) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), Block::new);
    }

    // Racks
    private static DeferredBlock<Block> rack(String name) {
        return block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), Block::new);
    }

    // Bags
    private static DeferredBlock<Block> bag(String name) {
        return bag(name, HorizontalFacingBlock::new);
    }
    private static DeferredBlock<Block> bag(String name, Function<BlockBehaviour.Properties, HorizontalFacingBlock> factory) {
        return (DeferredBlock<Block>) (DeferredBlock<?>) block(name, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL), factory);
    }
}
