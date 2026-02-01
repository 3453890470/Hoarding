package dev.gateguardian.hoarding.common.registry;

import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.common.block.HorizontalFacingBlock;
import dev.gateguardian.hoarding.common.block.HotFoodBlock;
import dev.gateguardian.hoarding.common.block.MobEffectBlock;
import dev.gateguardian.hoarding.common.block.NautilusBlock;
import lombok.experimental.UtilityClass;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

@UtilityClass
public class HoardingBlocks {

    public final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Hoarding.MOD_ID);

    //region Birch Crates
    public final RegistryObject<Block> ALLIUM_CRATE = birchCrate("allium_crate");
    public final RegistryObject<Block> AZURE_BLUET_CRATE = birchCrate("azure_bluet_crate");
    public final RegistryObject<Block> BLUE_ORCHID_CRATE = birchCrate("blue_orchid_crate");
    public final RegistryObject<Block> CORNFLOWER_CRATE = birchCrate("cornflower_crate");
    public final RegistryObject<Block> DANDELION_CRATE = birchCrate("dandelion_crate");
    public final RegistryObject<Block> LILY_CRATE = birchCrate("lily_crate");
    public final RegistryObject<Block> OXEYE_DAISY_CRATE = birchCrate("oxeye_daisy_crate");
    public final RegistryObject<Block> POPPY_CRATE = birchCrate("poppy_crate");
    public final RegistryObject<Block> ORANGE_TULIP_CRATE = birchCrate("orange_tulip_crate");
    public final RegistryObject<Block> PINK_TULIP_CRATE = birchCrate("pink_tulip_crate");
    public final RegistryObject<Block> RED_TULIP_CRATE = birchCrate("red_tulip_crate");
    public final RegistryObject<Block> WHITE_TULIP_CRATE = birchCrate("white_tulip_crate");
    public final RegistryObject<Block> TORCHFLOWER_CRATE = birchCrate("torchflower_crate");
    //endregion Birch Crates

    //region Oak Crates
    public final RegistryObject<Block> APPLE_CRATE = oakCrate("apple_crate");
    public final RegistryObject<Block> GOLDEN_APPLE_CRATE = oakCrate("golden_apple_crate");
    public final RegistryObject<Block> POTATO_CRATE = oakCrate("potato_crate");
    public final RegistryObject<Block> BAKED_POTATO_CRATE = oakCrate("baked_potato_crate", HotFoodBlock::new);
    public final RegistryObject<Block> POISONOUS_POTATO_CRATE = oakCrate("poisonous_potato_crate");
    public final RegistryObject<Block> BEETROOT_CRATE = oakCrate("beetroot_crate");
    public final RegistryObject<Block> BROWN_MUSHROOM_CRATE = oakCrate("brown_mushroom_crate");
    public final RegistryObject<Block> RED_MUSHROOM_CRATE = oakCrate("red_mushroom_crate");
    public final RegistryObject<Block> CARROT_CRATE = oakCrate("carrot_crate");
    public final RegistryObject<Block> GOLDEN_CARROT_CRATE = oakCrate("golden_carrot_crate");
    public final RegistryObject<Block> SWEET_BERRIES_CRATE = oakCrate("sweet_berries_crate");
    public final RegistryObject<Block> GLOW_BERRIES_CRATE = oakCrate("glow_berries_crate");
    public final RegistryObject<Block> COOKIE_CRATE = oakCrate("cookie_crate");
    public final RegistryObject<Block> BREAD_CRATE = oakCrate("bread_crate");
    //endregion Oak Crates

    //region Spruce Crates
    public final RegistryObject<Block> BEEF_CRATE = spruceCrate("beef_crate");
    public final RegistryObject<Block> COOKED_BEEF_CRATE = spruceCrate("cooked_beef_crate", HotFoodBlock::new);
    public final RegistryObject<Block> CHICKEN_CRATE = spruceCrate("chicken_crate");
    public final RegistryObject<Block> COOKED_CHICKEN_CRATE = spruceCrate("cooked_chicken_crate", HotFoodBlock::new);
    public final RegistryObject<Block> MUTTON_CRATE = spruceCrate("mutton_crate");
    public final RegistryObject<Block> COOKED_MUTTON_CRATE = spruceCrate("cooked_mutton_crate", HotFoodBlock::new);
    public final RegistryObject<Block> RABBIT_CRATE = spruceCrate("rabbit_crate");
    public final RegistryObject<Block> COOKED_RABBIT_CRATE = spruceCrate("cooked_rabbit_crate", HotFoodBlock::new);
    public final RegistryObject<Block> RABBIT_FOOT_CRATE = spruceCrate("rabbit_foot_crate");
    public final RegistryObject<Block> PORKCHOP_CRATE = spruceCrate("porkchop_crate");
    public final RegistryObject<Block> COOKED_PORKCHOP_CRATE = spruceCrate("cooked_porkchop_crate", HotFoodBlock::new);
    //endregion Spruce Crates

    //region Iron Crates
    public final RegistryObject<Block> ENDER_EYE_CRATE = ironCrate("ender_eye_crate");
    public final RegistryObject<Block> ENDER_PEARL_CRATE = ironCrate("ender_pearl_crate");
    public final RegistryObject<Block> ROTTEN_FLESH_CRATE = ironCrate("rotten_flesh_crate");
    public final RegistryObject<Block> SPIDER_EYE_CRATE = ironCrate("spider_eye_crate");
    public final RegistryObject<Block> FERMENTED_SPIDER_EYE_CRATE = ironCrate("fermented_spider_eye_crate");
    //endregion Iron Crates

    //region Crimson Crates
    public final RegistryObject<Block> CRIMSON_FUNGUS_CRATE = crimsonCrate("crimson_fungus_crate");
    public final RegistryObject<Block> WARPED_FUNGUS_CRATE = crimsonCrate("warped_fungus_crate");
    public final RegistryObject<Block> NETHER_WART_CRATE = crimsonCrate("nether_wart_crate");
    public final RegistryObject<Block> WITHER_ROSE_CRATE = crimsonCrate(
            "wither_rose_crate",
            props -> new MobEffectBlock(props, MobEffects.WITHER)
    );
    //endregion Crimson Crates

    //region End Stone Crates
    public final RegistryObject<Block> CHORUS_FRUIT_CRATE = endStoneCrate("chorus_fruit_crate");
    public final RegistryObject<Block> POPPED_CHORUS_FRUIT_CRATE = endStoneCrate("popped_chorus_fruit_crate");
    //endregion End Stone Crates

    //region Barrels
    public final RegistryObject<Block> COD_BARREL = barrel("cod_barrel");
    public final RegistryObject<Block> COOKED_COD_BARREL = barrel("cooked_cod_barrel", HotFoodBlock::new);
    public final RegistryObject<Block> SALMON_BARREL = barrel("salmon_barrel");
    public final RegistryObject<Block> COOKED_SALMON_BARREL = barrel("cooked_salmon_barrel", HotFoodBlock::new);
    public final RegistryObject<Block> INK_SAC_BARREL = barrel("ink_sac_barrel");
    public final RegistryObject<Block> GLOW_INK_SAC_BARREL = barrel("glow_ink_sac_barrel");
    public final RegistryObject<Block> PUFFER_FISH_BARREL = barrel(
            "pufferfish_barrel",
            props -> new MobEffectBlock(props, MobEffects.POISON)
    );
    public final RegistryObject<Block> TROPICAL_FISH_BARREL = barrel("tropical_fish_barrel");
    //endregion Barrels

    //region Buckets
    public final RegistryObject<Block> WHITE_DYE_BUCKET = bucket("white_dye_bucket");
    public final RegistryObject<Block> ORANGE_DYE_BUCKET = bucket("orange_dye_bucket");
    public final RegistryObject<Block> MAGENTA_DYE_BUCKET = bucket("magenta_dye_bucket");
    public final RegistryObject<Block> LIGHT_BLUE_DYE_BUCKET = bucket("light_blue_dye_bucket");
    public final RegistryObject<Block> YELLOW_DYE_BUCKET = bucket("yellow_dye_bucket");
    public final RegistryObject<Block> LIME_DYE_BUCKET = bucket("lime_dye_bucket");
    public final RegistryObject<Block> PINK_DYE_BUCKET = bucket("pink_dye_bucket");
    public final RegistryObject<Block> GRAY_DYE_BUCKET = bucket("gray_dye_bucket");
    public final RegistryObject<Block> LIGHT_GRAY_DYE_BUCKET = bucket("light_gray_dye_bucket");
    public final RegistryObject<Block> CYAN_DYE_BUCKET = bucket("cyan_dye_bucket");
    public final RegistryObject<Block> PURPLE_DYE_BUCKET = bucket("purple_dye_bucket");
    public final RegistryObject<Block> BLUE_DYE_BUCKET = bucket("blue_dye_bucket");
    public final RegistryObject<Block> BROWN_DYE_BUCKET = bucket("brown_dye_bucket");
    public final RegistryObject<Block> GREEN_DYE_BUCKET = bucket("green_dye_bucket");
    public final RegistryObject<Block> RED_DYE_BUCKET = bucket("red_dye_bucket");
    public final RegistryObject<Block> BLACK_DYE_BUCKET = bucket("black_dye_bucket");
    //endregion Buckets

    //region Racks
    public final RegistryObject<Block> EGG_RACK = rack("egg_rack");
    public final RegistryObject<Block> TURTLE_EGG_RACK = rack("turtle_egg_rack");
    public final RegistryObject<Block> BOTTLE_RACK = rack("bottle_rack");
    //endregion Racks

    //region Sacks
    public final RegistryObject<Block> SUGAR_BAG = bag("sugar_bag");
    public final RegistryObject<Block> GUNPOWDER_BAG = bag("gunpowder_bag");
    public final RegistryObject<Block> COCOA_BEANS_BAG = bag("cocoa_beans_bag");
    public final RegistryObject<Block> FEATHER_BAG = bag("feather_bag");
    //endregion Sacks

    //region Seed Bags
    public final RegistryObject<Block> WHEAT_SEEDS_BAG = bag("wheat_seeds_bag");
    public final RegistryObject<Block> BEETROOT_SEEDS_BAG = bag("beetroot_seeds_bag");
    public final RegistryObject<Block> MELON_SEEDS_BAG = bag("melon_seeds_bag");
    public final RegistryObject<Block> PUMPKIN_SEEDS_BAG = bag("pumpkin_seeds_bag");
    public final RegistryObject<Block> TORCHFLOWER_SEEDS_BAG = bag("torchflower_seeds_bag");
    //endregion Seed Bags

    //region Crimson Bags
    public final RegistryObject<Block> BLAZE_POWDER_BAG = bag("blaze_powder_bag");
    //endregion Crimson Bags

    //region Compressed Blocks
    public final RegistryObject<Block> FLINT_BLOCK = block(
            "flint_block",
            () -> new Block(Block.Properties.copy(Blocks.COBBLESTONE)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.STONE)
            )
    );
    public final RegistryObject<Block> NETHER_STAR_BLOCK = block(
            "nether_star_block",
            () -> new Block(Block.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .strength(50.0F, 1200.0F)
                    .sound(SoundType.METAL)
            )
    );
    public final RegistryObject<RotatedPillarBlock> LEATHER_BLOCK = block(
            "leather_block",
            () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.WHITE_WOOL)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOL)
            )
    );
    public final RegistryObject<RotatedPillarBlock> CACTUS_BUNDLE = block(
            "cactus_bundle",
            () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.CACTUS))
    );
    public final RegistryObject<RotatedPillarBlock> SUGARCANE_BUNDLE = block(
            "sugarcane_bundle",
            () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
            )
    );
    public final RegistryObject<RotatedPillarBlock> STICK_BUNDLE = block(
            "stick_bundle",
            () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
            )
    );
    public final RegistryObject<RotatedPillarBlock> BLAZE_ROD_BUNDLE = block(
            "blaze_rod_bundle",
            () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.END_ROD)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .lightLevel((state) -> 10)
            )
    );
    public final RegistryObject<RotatedPillarBlock> GLISTERING_MELON = block(
            "glistering_melon",
            () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.MELON))
    );
    public final RegistryObject<RotatedPillarBlock> SPOOL = block(
            "spool",
            () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.WHITE_WOOL))
    );
    public final RegistryObject<RotatedPillarBlock> BONE_PILE = block(
            "bone_pile",
            () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.BONE_BLOCK))
    );
    public final RegistryObject<Block> BOOK_PILE = block(
            "book_pile",
            () -> new HorizontalFacingBlock(Block.Properties.copy(Blocks.BOOKSHELF))
    );
    public final RegistryObject<Block> PAPER_STACK = block(
            "paper_stack",
            () -> new HorizontalFacingBlock(Block.Properties.copy(Blocks.WHITE_WOOL))
    );
    public final RegistryObject<Block> SCUTE_BLOCK = block(
            "scute_block",
            () -> new HorizontalFacingBlock(Block.Properties.copy(Blocks.WHITE_WOOL)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOL))
    );
    public final RegistryObject<Block> PHANTOM_MEMBRANE_BLOCK = block(
            "phantom_membrane_block",
            () -> new HorizontalFacingBlock(Block.Properties.copy(Blocks.WHITE_WOOL)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOL))
    );
    public final RegistryObject<Block> MAGMA_CREAM_BLOCK = block(
            "magma_cream_block",
            () -> new HorizontalFacingBlock(Block.Properties.copy(Blocks.SLIME_BLOCK)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.SLIME_BLOCK)
                    .lightLevel((state) -> 10))
    );
    public final RegistryObject<Block> NAUTILUS_BLOCK = block(
            "nautilus_block",
            () -> new NautilusBlock(Block.Properties.copy(Blocks.BONE_BLOCK)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.BONE_BLOCK))
    );
    //endregion Compressed Blocks

    public void init(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }

    public <T extends Block> RegistryObject<T> block(String name, Supplier<T> supplier) {
        RegistryObject<T> block = REGISTER.register(name, supplier);
        HoardingItems.item(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private RegistryObject<Block> birchCrate(String name) {
        return block(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    }

    private RegistryObject<Block> oakCrate(String name) {
        return oakCrate(name, Block::new);
    }

    private RegistryObject<Block> oakCrate(String name, Function<BlockBehaviour.Properties, Block> blockFactory) {
        return block(name, () -> blockFactory.apply(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    }

    private RegistryObject<Block> spruceCrate(String name) {
        return spruceCrate(name, Block::new);
    }

    private RegistryObject<Block> spruceCrate(String name, Function<BlockBehaviour.Properties, Block> blockFactory) {
        return block(name, () -> blockFactory.apply(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    }

    private RegistryObject<Block> crimsonCrate(String name) {
        return crimsonCrate(name, Block::new);
    }

    private RegistryObject<Block> crimsonCrate(String name, Function<BlockBehaviour.Properties, Block> blockFactory) {
        return block(name, () -> blockFactory.apply(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    }

    private RegistryObject<Block> ironCrate(String name) {
        return block(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    }

    private RegistryObject<Block> endStoneCrate(String name) {
        return block(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    }

    private RegistryObject<Block> barrel(String name) {
        return barrel(name, Block::new);
    }

    private RegistryObject<Block> barrel(String name, Function<BlockBehaviour.Properties, Block> blockFactory) {
        return block(name, () -> blockFactory.apply(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    }

    private RegistryObject<Block> bucket(String name) {
        return block(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    }

    private RegistryObject<Block> rack(String name) {
        return block(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    }

    private RegistryObject<Block> bag(String name) {
        return bag(name, HorizontalFacingBlock::new);
    }

    private RegistryObject<Block> bag(String name, Function<BlockBehaviour.Properties, HorizontalFacingBlock> blockFactory) {
        return block(name, () -> blockFactory.apply(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    }
}
