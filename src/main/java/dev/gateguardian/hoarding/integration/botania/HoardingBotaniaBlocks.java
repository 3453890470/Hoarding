/**
 * Botania 整合方块 — 16色神秘花板条箱
 *
 * == 状态说明 ==
 * 这些方块通过 HoardingBlocks.BLOCKS.registerBlock() 注册（纯 NeoForge API），
 * 因此不需要 Botania 在 classpath 上就能编译通过。
 *
 * == TODO: 26.1.2 兼容后 ==
 * 恢复步骤：
 * 1. 解除 ModIntegration.java 中 Botania 检测代码的注释（搜索 [TODO-BOTANIA]）
 * 2. 解除 StorageBlocks.java 中 addBotaniaEntries() 的注释（搜索 [TODO-BOTANIA]）
 * 3. 确保 libs.versions.toml 中 botania 版本已填好
 * 4. 确保 build.gradle 中 compileOnly libs.botania 已取消注释
 */
package dev.gateguardian.hoarding.integration.botania;

import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import net.minecraft.world.level.block.Block;

import java.util.List;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public final class HoardingBotaniaBlocks {

    // Mystical Flower Crates - 16 colors
    public static final DeferredBlock<Block> WHITE_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("white_mystical_flower_crate");
    public static final DeferredBlock<Block> ORANGE_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("orange_mystical_flower_crate");
    public static final DeferredBlock<Block> MAGENTA_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("magenta_mystical_flower_crate");
    public static final DeferredBlock<Block> LIGHT_BLUE_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("light_blue_mystical_flower_crate");
    public static final DeferredBlock<Block> YELLOW_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("yellow_mystical_flower_crate");
    public static final DeferredBlock<Block> LIME_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("lime_mystical_flower_crate");
    public static final DeferredBlock<Block> PINK_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("pink_mystical_flower_crate");
    public static final DeferredBlock<Block> GRAY_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("gray_mystical_flower_crate");
    public static final DeferredBlock<Block> LIGHT_GRAY_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("light_gray_mystical_flower_crate");
    public static final DeferredBlock<Block> CYAN_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("cyan_mystical_flower_crate");
    public static final DeferredBlock<Block> PURPLE_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("purple_mystical_flower_crate");
    public static final DeferredBlock<Block> BLUE_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("blue_mystical_flower_crate");
    public static final DeferredBlock<Block> BROWN_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("brown_mystical_flower_crate");
    public static final DeferredBlock<Block> GREEN_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("green_mystical_flower_crate");
    public static final DeferredBlock<Block> RED_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("red_mystical_flower_crate");
    public static final DeferredBlock<Block> BLACK_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("black_mystical_flower_crate");

    public static final List<DeferredBlock<Block>> ALL_CRATES = List.of(
            WHITE_MYSTICAL_FLOWER_CRATE,
            ORANGE_MYSTICAL_FLOWER_CRATE,
            MAGENTA_MYSTICAL_FLOWER_CRATE,
            LIGHT_BLUE_MYSTICAL_FLOWER_CRATE,
            YELLOW_MYSTICAL_FLOWER_CRATE,
            LIME_MYSTICAL_FLOWER_CRATE,
            PINK_MYSTICAL_FLOWER_CRATE,
            GRAY_MYSTICAL_FLOWER_CRATE,
            LIGHT_GRAY_MYSTICAL_FLOWER_CRATE,
            CYAN_MYSTICAL_FLOWER_CRATE,
            PURPLE_MYSTICAL_FLOWER_CRATE,
            BLUE_MYSTICAL_FLOWER_CRATE,
            BROWN_MYSTICAL_FLOWER_CRATE,
            GREEN_MYSTICAL_FLOWER_CRATE,
            RED_MYSTICAL_FLOWER_CRATE,
            BLACK_MYSTICAL_FLOWER_CRATE
    );

    private HoardingBotaniaBlocks() {}

    public static void init() {
        // Static initialization triggers registration via HoardingBlocks.BLOCKS.registerBlock
    }

    private static DeferredBlock<Block> mysticalFlowerCrate(String name) {
        return HoardingBlocks.BLOCKS.registerBlock(
                name,
                Block::new,
                BlockBehaviour.Properties.of().strength(2.0F, 3.0F)
        );
    }
}
