package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.integration.arsnouveau.HoardingArsNouveauBlocks;
import dev.gateguardian.hoarding.integration.botania.HoardingBotaniaBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Supplier;

import static dev.gateguardian.hoarding.common.registry.HoardingBlocks.*;

public class HoardingBlockStateProvider extends BlockStateProvider {

    public HoardingBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, Hoarding.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Birch Crates
        birchCrate(ALLIUM_CRATE);
        birchCrate(AZURE_BLUET_CRATE);
        birchCrate(BLUE_ORCHID_CRATE);
        birchCrate(CORNFLOWER_CRATE);
        birchCrate(DANDELION_CRATE);
        birchCrate(LILY_CRATE);
        birchCrate(OXEYE_DAISY_CRATE);
        birchCrate(POPPY_CRATE);
        birchCrate(ORANGE_TULIP_CRATE);
        birchCrate(PINK_TULIP_CRATE);
        birchCrate(RED_TULIP_CRATE);
        birchCrate(WHITE_TULIP_CRATE);
        birchCrate(TORCHFLOWER_CRATE);

        // Oak Crates
        oakCrate(APPLE_CRATE);
        oakCrate(GOLDEN_APPLE_CRATE);
        oakCrate(POTATO_CRATE);
        oakCrate(BAKED_POTATO_CRATE);
        oakCrate(POISONOUS_POTATO_CRATE);
        oakCrate(BEETROOT_CRATE);
        oakCrate(BROWN_MUSHROOM_CRATE);
        oakCrate(RED_MUSHROOM_CRATE);
        oakCrate(CARROT_CRATE);
        oakCrate(GOLDEN_CARROT_CRATE);
        oakCrate(SWEET_BERRIES_CRATE);
        oakCrate(GLOW_BERRIES_CRATE);
        oakCrate(COOKIE_CRATE);
        oakCrate(BREAD_CRATE);

        // Spruce Crates
        spruceCrate(BEEF_CRATE);
        spruceCrate(COOKED_BEEF_CRATE);
        spruceCrate(CHICKEN_CRATE);
        spruceCrate(COOKED_CHICKEN_CRATE);
        spruceCrate(MUTTON_CRATE);
        spruceCrate(COOKED_MUTTON_CRATE);
        spruceCrate(RABBIT_CRATE);
        spruceCrate(COOKED_RABBIT_CRATE);
        spruceCrate(RABBIT_FOOT_CRATE);
        spruceCrate(PORKCHOP_CRATE);
        spruceCrate(COOKED_PORKCHOP_CRATE);

        // Iron Crates
        ironCrate(ENDER_EYE_CRATE);
        ironCrate(ENDER_PEARL_CRATE);
        ironCrate(ROTTEN_FLESH_CRATE);
        ironCrate(SPIDER_EYE_CRATE);
        ironCrate(FERMENTED_SPIDER_EYE_CRATE);

        // Crimson Crates
        crimsonCrate(CRIMSON_FUNGUS_CRATE);
        crimsonCrate(WARPED_FUNGUS_CRATE);
        crimsonCrate(NETHER_WART_CRATE);
        crimsonCrate(WITHER_ROSE_CRATE);

        // End Stone Crates
        endStoneCrate(CHORUS_FRUIT_CRATE);
        endStoneCrate(POPPED_CHORUS_FRUIT_CRATE);

        // Barrels
        barrel(COD_BARREL);
        barrel(COOKED_COD_BARREL);
        barrel(SALMON_BARREL);
        barrel(COOKED_SALMON_BARREL);
        barrel(INK_SAC_BARREL);
        barrel(GLOW_INK_SAC_BARREL);
        barrel(PUFFER_FISH_BARREL);
        barrel(TROPICAL_FISH_BARREL);

        // Buckets
        bucket(BLACK_DYE_BUCKET);
        bucket(RED_DYE_BUCKET);
        bucket(GREEN_DYE_BUCKET);
        bucket(BROWN_DYE_BUCKET);
        bucket(BLUE_DYE_BUCKET);
        bucket(PURPLE_DYE_BUCKET);
        bucket(CYAN_DYE_BUCKET);
        bucket(LIGHT_GRAY_DYE_BUCKET);
        bucket(GRAY_DYE_BUCKET);
        bucket(PINK_DYE_BUCKET);
        bucket(LIME_DYE_BUCKET);
        bucket(YELLOW_DYE_BUCKET);
        bucket(LIGHT_BLUE_DYE_BUCKET);
        bucket(MAGENTA_DYE_BUCKET);
        bucket(ORANGE_DYE_BUCKET);
        bucket(WHITE_DYE_BUCKET);

        // Racks
        rack(EGG_RACK);
        rack(TURTLE_EGG_RACK);
        rack(BOTTLE_RACK);

        // Sacks
        sack(SUGAR_BAG);
        sack(GUNPOWDER_BAG);
        sack(COCOA_BEANS_BAG);
        sack(FEATHER_BAG);

        // Seed Bags
        seedBag(WHEAT_SEEDS_BAG);
        seedBag(BEETROOT_SEEDS_BAG);
        seedBag(MELON_SEEDS_BAG);
        seedBag(PUMPKIN_SEEDS_BAG);
        seedBag(TORCHFLOWER_SEEDS_BAG);

        // Crimson Bags
        crimsonBag(BLAZE_POWDER_BAG);

        // Compressed Blocks
        simpleBlockWithItem(FLINT_BLOCK);
        simpleBlockWithItem(NETHER_STAR_BLOCK);

        axisBlock(LEATHER_BLOCK.get());
        simpleBlockItem(LEATHER_BLOCK);

        axisBlock(CACTUS_BUNDLE.get());
        simpleBlockItem(CACTUS_BUNDLE);

        axisBlock(SUGARCANE_BUNDLE.get());
        simpleBlockItem(SUGARCANE_BUNDLE);

        axisBlock(STICK_BUNDLE.get());
        simpleBlockItem(STICK_BUNDLE);

        axisBlock(BLAZE_ROD_BUNDLE.get());
        simpleBlockItem(BLAZE_ROD_BUNDLE);

        axisBlock(GLISTERING_MELON.get());
        simpleBlockItem(GLISTERING_MELON);

        axisBlock(SPOOL.get());
        simpleBlockItem(SPOOL);

        axisBlock(BONE_PILE.get());
        simpleBlockItem(BONE_PILE);

        ModelFile bookPileModel = models().withExistingParent(name(BOOK_PILE.get()), Hoarding.id("cube_symmetry_north_west"))
                .texture("north", Hoarding.id("block/book_pile_side"))
                .texture("west", Hoarding.id("block/book_pile_side_2"))
                .texture("top", Hoarding.id("block/book_pile_top"))
                .texture("bottom", Hoarding.id("block/book_pile_bottom"));
        horizontalBlock(BOOK_PILE.get(), bookPileModel);
        simpleBlockItem(BOOK_PILE.get(), bookPileModel);

        ModelFile paperStackModel = models().withExistingParent(name(PAPER_STACK.get()), Hoarding.id("cube_symmetry_north_west"))
                .texture("north", Hoarding.id("block/paper_stack_front"))
                .texture("west", Hoarding.id("block/paper_stack_side"))
                .texture("top", Hoarding.id("block/paper_stack_top"))
                .texture("bottom", Hoarding.id("block/paper_stack_top"));
        horizontalBlock(PAPER_STACK.get(), paperStackModel);
        simpleBlockItem(PAPER_STACK.get(), paperStackModel);

        ModelFile scuteModel = models().withExistingParent(name(SCUTE_BLOCK.get()), Hoarding.id("cube_symmetry_west"))
                .texture("north", Hoarding.id("block/scute_block_front"))
                .texture("south", Hoarding.id("block/scute_block_back"))
                .texture("west", Hoarding.id("block/scute_block_side"))
                .texture("top", Hoarding.id("block/scute_block_top"))
                .texture("bottom", Hoarding.id("block/scute_block_bottom"));
        horizontalBlock(SCUTE_BLOCK.get(), scuteModel);
        simpleBlockItem(SCUTE_BLOCK.get(), scuteModel);

        ModelFile phantomMembraneModel = models().withExistingParent(name(PHANTOM_MEMBRANE_BLOCK.get()), Hoarding.id("cube_symmetry_west"))
                .texture("north", Hoarding.id("block/phantom_membrane_block_front"))
                .texture("south", Hoarding.id("block/phantom_membrane_block_back"))
                .texture("west", Hoarding.id("block/phantom_membrane_block_side"))
                .texture("top", Hoarding.id("block/phantom_membrane_block_top"))
                .texture("bottom", Hoarding.id("block/phantom_membrane_block_bottom"));
        horizontalBlock(PHANTOM_MEMBRANE_BLOCK.get(), phantomMembraneModel);
        simpleBlockItem(PHANTOM_MEMBRANE_BLOCK.get(), phantomMembraneModel);

        simpleBlockWithItem(MAGMA_CREAM_BLOCK.get(), models().getExistingFile(Hoarding.id("block/magma_cream_block")));

        ModelFile nautilusModel = models().getExistingFile(Hoarding.id("block/nautilus_shell_block"));
        horizontalBlock(NAUTILUS_BLOCK.get(), nautilusModel);
        simpleBlockItem(NAUTILUS_BLOCK.get(), nautilusModel);

        registerCrossModBlocks();
    }

    private void registerCrossModBlocks() {
        // Ars Nouveau integration
        archwoodCrate(HoardingArsNouveauBlocks.MAGEBLOOM_CRATE);
        archwoodCrate(HoardingArsNouveauBlocks.SOURCEBERRY_CRATE);

        // Botania integration
        mysticalFlowerCrate(HoardingBotaniaBlocks.WHITE_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.ORANGE_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.MAGENTA_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.LIGHT_BLUE_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.YELLOW_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.LIME_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.PINK_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.GRAY_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.LIGHT_GRAY_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.CYAN_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.PURPLE_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.BLUE_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.BROWN_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.GREEN_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.RED_MYSTICAL_FLOWER_CRATE);
        mysticalFlowerCrate(HoardingBotaniaBlocks.BLACK_MYSTICAL_FLOWER_CRATE);
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

    private void archwoodCrate(Supplier<? extends Block> supplier) {
        String prefix = "block/crate/ars_nouveau/";
        Block block = supplier.get();
        ModelFile model = models().cubeBottomTop(
                name(block),
                key(block).withPath(path -> prefix + path + "_side"),
                Hoarding.id(prefix + "bottom_archwood"),
                key(block).withPath(path -> prefix + path + "_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }

    private void mysticalFlowerCrate(Supplier<? extends Block> supplier) {
        String prefix = "block/crate/botania/";
        Block block = supplier.get();
        ModelFile model = models().cubeBottomTop(
                name(block),
                key(block).withPath(path -> prefix + path + "_side"),
                Hoarding.id(prefix + "bottom_livingwood"),
                key(block).withPath(path -> prefix + path + "_top")
        );
        this.simpleBlock(block, model);
        this.simpleBlockItem(block, model);
    }
}
