package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Supplier;

public class HoardingBlockStateProvider extends BlockStateProvider {

    public HoardingBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, Hoarding.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Birch Crates
        birchCrate(HoardingBlocks.ALLIUM_CRATE);
        birchCrate(HoardingBlocks.AZURE_BLUET_CRATE);
        birchCrate(HoardingBlocks.BLUE_ORCHID_CRATE);
        birchCrate(HoardingBlocks.CORNFLOWER_CRATE);
        birchCrate(HoardingBlocks.DANDELION_CRATE);
        birchCrate(HoardingBlocks.LILY_CRATE);
        birchCrate(HoardingBlocks.OXEYE_DAISY_CRATE);
        birchCrate(HoardingBlocks.POPPY_CRATE);
        birchCrate(HoardingBlocks.ORANGE_TULIP_CRATE);
        birchCrate(HoardingBlocks.PINK_TULIP_CRATE);
        birchCrate(HoardingBlocks.RED_TULIP_CRATE);
        birchCrate(HoardingBlocks.WHITE_TULIP_CRATE);
        birchCrate(HoardingBlocks.TORCHFLOWER_CRATE);

        // Oak Crates
        oakCrate(HoardingBlocks.APPLE_CRATE);
        oakCrate(HoardingBlocks.GOLDEN_APPLE_CRATE);
        oakCrate(HoardingBlocks.POTATO_CRATE);
        oakCrate(HoardingBlocks.BAKED_POTATO_CRATE);
        oakCrate(HoardingBlocks.POISONOUS_POTATO_CRATE);
        oakCrate(HoardingBlocks.BEETROOT_CRATE);
        oakCrate(HoardingBlocks.BROWN_MUSHROOM_CRATE);
        oakCrate(HoardingBlocks.RED_MUSHROOM_CRATE);
        oakCrate(HoardingBlocks.CARROT_CRATE);
        oakCrate(HoardingBlocks.GOLDEN_CARROT_CRATE);
        oakCrate(HoardingBlocks.SWEET_BERRIES_CRATE);
        oakCrate(HoardingBlocks.GLOW_BERRIES_CRATE);
        oakCrate(HoardingBlocks.COOKIE_CRATE);
        oakCrate(HoardingBlocks.BREAD_CRATE);

        // Spruce Crates
        spruceCrate(HoardingBlocks.BEEF_CRATE);
        spruceCrate(HoardingBlocks.COOKED_BEEF_CRATE);
        spruceCrate(HoardingBlocks.CHICKEN_CRATE);
        spruceCrate(HoardingBlocks.COOKED_CHICKEN_CRATE);
        spruceCrate(HoardingBlocks.MUTTON_CRATE);
        spruceCrate(HoardingBlocks.COOKED_MUTTON_CRATE);
        spruceCrate(HoardingBlocks.RABBIT_CRATE);
        spruceCrate(HoardingBlocks.COOKED_RABBIT_CRATE);
        spruceCrate(HoardingBlocks.RABBIT_FOOT_CRATE);
        spruceCrate(HoardingBlocks.PORKCHOP_CRATE);
        spruceCrate(HoardingBlocks.COOKED_PORKCHOP_CRATE);

        // Iron Crates
        ironCrate(HoardingBlocks.ENDER_EYE_CRATE);
        ironCrate(HoardingBlocks.ENDER_PEARL_CRATE);
        ironCrate(HoardingBlocks.ROTTEN_FLESH_CRATE);
        ironCrate(HoardingBlocks.SPIDER_EYE_CRATE);
        ironCrate(HoardingBlocks.FERMENTED_SPIDER_EYE_CRATE);

        // Crimson Crates
        crimsonCrate(HoardingBlocks.CRIMSON_FUNGUS_CRATE);
        crimsonCrate(HoardingBlocks.WARPED_FUNGUS_CRATE);
        crimsonCrate(HoardingBlocks.NETHER_WART_CRATE);
        crimsonCrate(HoardingBlocks.WITHER_ROSE_CRATE);

        // End Stone Crates
        endStoneCrate(HoardingBlocks.CHORUS_FRUIT_CRATE);
        endStoneCrate(HoardingBlocks.POPPED_CHORUS_FRUIT_CRATE);

        // Barrels
        barrel(HoardingBlocks.COD_BARREL);
        barrel(HoardingBlocks.COOKED_COD_BARREL);
        barrel(HoardingBlocks.SALMON_BARREL);
        barrel(HoardingBlocks.COOKED_SALMON_BARREL);
        barrel(HoardingBlocks.INK_SAC_BARREL);
        barrel(HoardingBlocks.GLOW_INK_SAC_BARREL);
        barrel(HoardingBlocks.PUFFER_FISH_BARREL);
        barrel(HoardingBlocks.TROPICAL_FISH_BARREL);

        // Buckets
        bucket(HoardingBlocks.BLACK_DYE_BUCKET);
        bucket(HoardingBlocks.RED_DYE_BUCKET);
        bucket(HoardingBlocks.GREEN_DYE_BUCKET);
        bucket(HoardingBlocks.BROWN_DYE_BUCKET);
        bucket(HoardingBlocks.BLUE_DYE_BUCKET);
        bucket(HoardingBlocks.PURPLE_DYE_BUCKET);
        bucket(HoardingBlocks.CYAN_DYE_BUCKET);
        bucket(HoardingBlocks.LIGHT_GRAY_DYE_BUCKET);
        bucket(HoardingBlocks.GRAY_DYE_BUCKET);
        bucket(HoardingBlocks.PINK_DYE_BUCKET);
        bucket(HoardingBlocks.LIME_DYE_BUCKET);
        bucket(HoardingBlocks.YELLOW_DYE_BUCKET);
        bucket(HoardingBlocks.LIGHT_BLUE_DYE_BUCKET);
        bucket(HoardingBlocks.MAGENTA_DYE_BUCKET);
        bucket(HoardingBlocks.ORANGE_DYE_BUCKET);
        bucket(HoardingBlocks.WHITE_DYE_BUCKET);

        // Racks
        rack(HoardingBlocks.EGG_RACK);
        rack(HoardingBlocks.TURTLE_EGG_RACK);
        rack(HoardingBlocks.BOTTLE_RACK);

        // Sacks
        sack(HoardingBlocks.SUGAR_BAG);
        sack(HoardingBlocks.GUNPOWDER_BAG);
        sack(HoardingBlocks.COCOA_BEANS_BAG);
        sack(HoardingBlocks.FEATHER_BAG);

        // Seed Bags
        seedBag(HoardingBlocks.WHEAT_SEEDS_BAG);
        seedBag(HoardingBlocks.BEETROOT_SEEDS_BAG);
        seedBag(HoardingBlocks.MELON_SEEDS_BAG);
        seedBag(HoardingBlocks.PUMPKIN_SEEDS_BAG);
        seedBag(HoardingBlocks.TORCHFLOWER_SEEDS_BAG);

        // Crimson Bags
        crimsonBag(HoardingBlocks.BLAZE_POWDER_BAG);

        // Compressed Blocks
        simpleBlockWithItem(HoardingBlocks.FLINT_BLOCK);
        simpleBlockWithItem(HoardingBlocks.NETHER_STAR_BLOCK);

        axisBlock(HoardingBlocks.LEATHER_BLOCK.get());
        simpleBlockItem(HoardingBlocks.LEATHER_BLOCK);

        axisBlock(HoardingBlocks.CACTUS_BUNDLE.get());
        simpleBlockItem(HoardingBlocks.CACTUS_BUNDLE);

        axisBlock(HoardingBlocks.SUGARCANE_BUNDLE.get());
        simpleBlockItem(HoardingBlocks.SUGARCANE_BUNDLE);

        axisBlock(HoardingBlocks.STICK_BUNDLE.get());
        simpleBlockItem(HoardingBlocks.STICK_BUNDLE);

        axisBlock(HoardingBlocks.BLAZE_ROD_BUNDLE.get());
        simpleBlockItem(HoardingBlocks.BLAZE_ROD_BUNDLE);

        axisBlock(HoardingBlocks.GLISTERING_MELON.get());
        simpleBlockItem(HoardingBlocks.GLISTERING_MELON);

        axisBlock(HoardingBlocks.SPOOL.get());
        simpleBlockItem(HoardingBlocks.SPOOL);

        axisBlock(HoardingBlocks.BONE_PILE.get());
        simpleBlockItem(HoardingBlocks.BONE_PILE);

        ModelFile bookPileModel = models().withExistingParent(name(HoardingBlocks.BOOK_PILE.get()), Hoarding.id("cube_symmetry_north_west"))
                .texture("north", Hoarding.id("block/book_pile_side"))
                .texture("west", Hoarding.id("block/book_pile_side_2"))
                .texture("top", Hoarding.id("block/book_pile_top"))
                .texture("bottom", Hoarding.id("block/book_pile_bottom"));
        horizontalBlock(HoardingBlocks.BOOK_PILE.get(), bookPileModel);
        simpleBlockItem(HoardingBlocks.BOOK_PILE.get(), bookPileModel);

        ModelFile paperStackModel = models().withExistingParent(name(HoardingBlocks.PAPER_STACK.get()), Hoarding.id("cube_symmetry_north_west"))
                .texture("north", Hoarding.id("block/paper_stack_front"))
                .texture("west", Hoarding.id("block/paper_stack_side"))
                .texture("top", Hoarding.id("block/paper_stack_top"))
                .texture("bottom", Hoarding.id("block/paper_stack_top"));
        horizontalBlock(HoardingBlocks.PAPER_STACK.get(), paperStackModel);
        simpleBlockItem(HoardingBlocks.PAPER_STACK.get(), paperStackModel);

        ModelFile turtleScuteModel = models().withExistingParent(name(HoardingBlocks.TURTLE_SCUTE_BLOCK.get()), Hoarding.id("cube_symmetry_west"))
                .texture("north", Hoarding.id("block/turtle_scute_block_front"))
                .texture("south", Hoarding.id("block/turtle_scute_block_back"))
                .texture("west", Hoarding.id("block/turtle_scute_block_side"))
                .texture("top", Hoarding.id("block/turtle_scute_block_top"))
                .texture("bottom", Hoarding.id("block/turtle_scute_block_bottom"));
        horizontalBlock(HoardingBlocks.TURTLE_SCUTE_BLOCK.get(), turtleScuteModel);
        simpleBlockItem(HoardingBlocks.TURTLE_SCUTE_BLOCK.get(), turtleScuteModel);

        ModelFile phantomMembraneModel = models().withExistingParent(name(HoardingBlocks.PHANTOM_MEMBRANE_BLOCK.get()), Hoarding.id("cube_symmetry_west"))
                .texture("north", Hoarding.id("block/phantom_membrane_block_front"))
                .texture("south", Hoarding.id("block/phantom_membrane_block_back"))
                .texture("west", Hoarding.id("block/phantom_membrane_block_side"))
                .texture("top", Hoarding.id("block/phantom_membrane_block_top"))
                .texture("bottom", Hoarding.id("block/phantom_membrane_block_bottom"));
        horizontalBlock(HoardingBlocks.PHANTOM_MEMBRANE_BLOCK.get(), phantomMembraneModel);
        simpleBlockItem(HoardingBlocks.PHANTOM_MEMBRANE_BLOCK.get(), phantomMembraneModel);

        simpleBlockWithItem(HoardingBlocks.MAGMA_CREAM_BLOCK.get(), models().getExistingFile(Hoarding.id("block/magma_cream_block")));

        ModelFile nautilusModel = models().getExistingFile(Hoarding.id("block/nautilus_shell_block"));
        horizontalBlock(HoardingBlocks.NAUTILUS_BLOCK.get(), nautilusModel);
        simpleBlockItem(HoardingBlocks.NAUTILUS_BLOCK.get(), nautilusModel);
    }

    private ResourceLocation key(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block), "Block is not registered!");
    }

    private String name(Block block) {
        return this.key(block).getPath();
    }

    private void birchCrate(Supplier<? extends Block> supplier) {
        String prefix = "block/crate/birch/";
        Block block = supplier.get();
        ModelFile model = models().cubeBottomTop(
                name(block),
                key(block).withPath(path -> prefix + path + "_side"),
                Hoarding.id(prefix + "bottom_birch"),
                key(block).withPath(path -> prefix + path + "_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void oakCrate(Supplier<? extends Block> supplier) {
        String prefix = "block/crate/oak/";
        Block block = supplier.get();
        ModelFile model = models().cubeBottomTop(
                name(block),
                key(block).withPath(path -> prefix + path + "_side"),
                Hoarding.id(prefix + "bottom_oak"),
                key(block).withPath(path -> prefix + path + "_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void spruceCrate(Supplier<? extends Block> supplier) {
        String prefix = "block/crate/spruce/";
        Block block = supplier.get();
        ModelFile model = models().cubeBottomTop(
                name(block),
                key(block).withPath(path -> prefix + path + "_side"),
                Hoarding.id(prefix + "bottom_spruce"),
                key(block).withPath(path -> prefix + path + "_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void ironCrate(Supplier<? extends Block> supplier) {
        String prefix = "block/crate/iron/";
        Block block = supplier.get();
        ModelFile model = models().cubeBottomTop(
                name(block),
                key(block).withPath(path -> prefix + path + "_side"),
                Hoarding.id(prefix + "bottom_iron"),
                key(block).withPath(path -> prefix + path + "_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void crimsonCrate(Supplier<? extends Block> supplier) {
        String prefix = "block/crate/others/";
        Block block = supplier.get();
        ModelFile model = models().cubeBottomTop(
                name(block),
                key(block).withPath(path -> prefix + path + "_side"),
                Hoarding.id(prefix + "bottom_crimson"),
                key(block).withPath(path -> prefix + path + "_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void endStoneCrate(Supplier<? extends Block> supplier) {
        String prefix = "block/crate/others/";
        Block block = supplier.get();
        ModelFile model = models().cubeBottomTop(
                name(block),
                key(block).withPath(path -> prefix + path + "_side"),
                Hoarding.id(prefix + "bottom_end_stone"),
                key(block).withPath(path -> prefix + path + "_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void barrel(Supplier<? extends Block> supplier) {
        String prefix = "block/barrel/";
        Block block = supplier.get();
        ModelFile model = models().cubeBottomTop(
                name(block),
                Hoarding.id(prefix + "barrel_side"),
                Hoarding.id(prefix + "barrel_bottom"),
                key(block).withPath(path -> prefix + path + "_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void bucket(Supplier<? extends Block> supplier) {
        String prefix = "block/bucket/";
        Block block = supplier.get();
        ModelFile model = models().cubeBottomTop(
                name(block),
                Hoarding.id(prefix + "bucket_side"),
                Hoarding.id(prefix + "bucket_bottom"),
                key(block).withPath(path -> prefix + path + "_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void rack(Supplier<? extends Block> supplier) {
        String prefix = "block/rack/";
        Block block = supplier.get();
        ModelFile model = models().cubeColumn(
                name(block),
                key(block).withPath(path -> prefix + path + "_side"),
                Hoarding.id(prefix + "rack_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void sack(Supplier<? extends Block> supplier) {
        String prefix = "block/bag/sack/";
        Block block = supplier.get();
        ModelFile model = models().withExistingParent(name(block), Hoarding.id("cube_symmetry_north_west"))
                .texture("north", Hoarding.id(prefix + "sack_side"))
                .texture("west", Hoarding.id(prefix + "sack_side_tied"))
                .texture("top", key(block).withPath(path -> prefix + path + "_top"))
                .texture("bottom", Hoarding.id(prefix + "sack_bottom"));
        this.horizontalBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void seedBag(Supplier<? extends Block> supplier) {
        String prefix = "block/bag/seed_bag/";
        Block block = supplier.get();
        ModelFile model = models().withExistingParent(name(block), Hoarding.id("cube_symmetry_north_west"))
                .texture("north", Hoarding.id(prefix + "seed_bag_side"))
                .texture("west", Hoarding.id(prefix + "seed_bag_side_tied"))
                .texture("top", key(block).withPath(path -> prefix + path + "_top"))
                .texture("bottom", Hoarding.id(prefix + "seed_bag_bottom"));
        this.horizontalBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void crimsonBag(Supplier<? extends Block> supplier) {
        String prefix = "block/bag/sack/";
        Block block = supplier.get();
        ModelFile model = models().withExistingParent(name(block), Hoarding.id("cube_symmetry_north_west"))
                .texture("north", Hoarding.id(prefix + "crimson_bag_side"))
                .texture("west", Hoarding.id(prefix + "crimson_bag_side_tied"))
                .texture("top", key(block).withPath(path -> prefix + path + "_top"))
                .texture("bottom", Hoarding.id(prefix + "crimson_bag_bottom"));
        this.horizontalBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void simpleBlockWithItem(Supplier<? extends Block> supplier) {
        Block block = supplier.get();
        ModelFile model = cubeAll(block);
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void simpleBlockItem(Supplier<? extends Block> supplier) {
        Block block = supplier.get();
        this.simpleBlockItem(block, new ModelFile.UncheckedModelFile(blockTexture(block)));
    }
}
