package dev.gateguardian.hoarding.data.provider;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class HoardingBlockStateProvider extends BlockStateProvider {
    public HoardingBlockStateProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, Hoarding.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(HoardingBlocks.CACTUS_BUNDLE.get(), cubeTop(HoardingBlocks.CACTUS_BUNDLE.get()));
        this.simpleBlockItem(HoardingBlocks.CACTUS_BUNDLE.get(), cubeTop(HoardingBlocks.CACTUS_BUNDLE.get()));

        this.simpleBlock(HoardingBlocks.GLISTERING_MELON.get(), cubeTop(HoardingBlocks.GLISTERING_MELON.get()));
        this.simpleBlockItem(HoardingBlocks.GLISTERING_MELON.get(), cubeTop(HoardingBlocks.GLISTERING_MELON.get()));

        this.simpleBlock(HoardingBlocks.COTTON_BAG.get(), models().cubeBottomTop(name(HoardingBlocks.COTTON_BAG.get()), Hoarding.id("block/rice_bag_side"), Hoarding.id("block/rice_bag_bottom"), blockTexture(HoardingBlocks.COTTON_BAG.get()).withSuffix("_top")));
        this.simpleBlockItem(HoardingBlocks.COTTON_BAG.get(), models().cubeBottomTop(name(HoardingBlocks.COTTON_BAG.get()), Hoarding.id("block/rice_bag_side"), Hoarding.id("block/rice_bag_bottom"), blockTexture(HoardingBlocks.COTTON_BAG.get()).withSuffix("_top")));

        this.simpleBlock(HoardingBlocks.WITHER_ROSE_CRATE.get(), models().cubeBottomTop(name(HoardingBlocks.WITHER_ROSE_CRATE.get()), blockTexture(HoardingBlocks.WITHER_ROSE_CRATE.get()).withSuffix( "_side"),  Hoarding.id("block/nether_crate_bottom"), blockTexture(HoardingBlocks.WITHER_ROSE_CRATE.get()).withSuffix("_top")));
        this.simpleBlockItem(HoardingBlocks.WITHER_ROSE_CRATE.get(), models().cubeBottomTop(name(HoardingBlocks.WITHER_ROSE_CRATE.get()), blockTexture(HoardingBlocks.WITHER_ROSE_CRATE.get()).withSuffix( "_side"),  Hoarding.id("block/nether_crate_bottom"), blockTexture(HoardingBlocks.WITHER_ROSE_CRATE.get()).withSuffix("_top")));

        this.simpleCrate(HoardingBlocks.LILY_CRATE.get());
        this.simpleCrate(HoardingBlocks.AZURE_BLUET_CRATE.get());
        this.simpleCrate(HoardingBlocks.BLUE_ORCHID_CRATE.get());
        this.simpleCrate(HoardingBlocks.DANDELION_CRATE.get());
        this.simpleCrate(HoardingBlocks.CORNFLOWER_CRATE.get());
        this.simpleCrate(HoardingBlocks.POPPY_CRATE.get());
        this.simpleCrate(HoardingBlocks.OXEYE_DAISY_CRATE.get());
        this.simpleCrate(HoardingBlocks.SOURCE_BERRY_CRATE.get());
        this.simpleCrate(HoardingBlocks.BAKED_POTATO_CRATE.get());
        this.simpleCrate(HoardingBlocks.ORANGE_TULIP_CRATE.get());
        this.simpleCrate(HoardingBlocks.PINK_TULIP_CRATE.get());
        this.simpleCrate(HoardingBlocks.RED_TULIP_CRATE.get());
        this.simpleCrate(HoardingBlocks.WHITE_TULIP_CRATE.get());
        this.simpleCrate(HoardingBlocks.ALLIUM_CRATE.get());
        this.simpleCrate(HoardingBlocks.MAGEBLOOM_CRATE.get());
    }

    public ModelFile cubeBottomTop(Block block) {
        return models().cubeBottomTop(name(block), blockTexture(block).withSuffix( "_side"), blockTexture(block).withSuffix("_bottom"), blockTexture(block).withSuffix("_top"));
    }

    public ModelFile cubeTop(Block block) {
        return models().cubeBottomTop(name(block), blockTexture(block).withSuffix( "_side"), blockTexture(block).withSuffix("_top"), blockTexture(block).withSuffix("_top"));
    }

    public void simpleCrate(Block block) {
        this.simpleBlock(block, this.simpleCrateModel(block));
        this.simpleBlockItem(block, this.simpleCrateModel(block));
    }

    public ModelFile simpleCrateModel(Block block) {
        return models().cubeBottomTop(name(block), blockTexture(block).withSuffix( "_side"), Hoarding.id("block/crate_bottom"), blockTexture(block).withSuffix("_top"));
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }
}
