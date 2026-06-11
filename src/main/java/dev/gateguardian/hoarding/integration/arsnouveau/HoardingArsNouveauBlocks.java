/**
 * Ars Nouveau 整合方块 — 魔幻花板条箱、源浆果板条箱
 *
 * == 状态说明 ==
 * 这些方块通过 HoardingBlocks.BLOCKS.registerBlock() 注册（纯 NeoForge API），
 * 因此不需要 Ars Nouveau 在 classpath 上就能编译通过。
 *
 * == TODO: 26.1.2 兼容后 ==
 * 恢复步骤：
 * 1. 解除 ModIntegration.java 中 Ars 检测代码的注释（搜索 [TODO-ARS]）
 * 2. 解除 StorageBlocks.java 中 addArsNouveauEntries() 的注释（搜索 [TODO-ARS]）
 * 3. 确保 libs.versions.toml 中 ars-nouveau 版本已填好
 * 4. 确保 build.gradle 中 compileOnly libs.ars.nouveau 已取消注释
 */
package dev.gateguardian.hoarding.integration.arsnouveau;

import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import net.minecraft.world.level.block.Block;

import java.util.List;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public final class HoardingArsNouveauBlocks {

    public static final DeferredBlock<Block> MAGEBLOOM_CRATE = crate("magebloom_crate");
    public static final DeferredBlock<Block> SOURCEBERRY_CRATE = crate("sourceberry_crate");

    public static final List<DeferredBlock<Block>> ALL_CRATES = List.of(MAGEBLOOM_CRATE, SOURCEBERRY_CRATE);

    private HoardingArsNouveauBlocks() {}

    public static void init() {
        // Static initialization triggers registration via HoardingBlocks.BLOCKS.registerBlock
    }

    private static DeferredBlock<Block> crate(String name) {
        return HoardingBlocks.BLOCKS.registerBlock(
                name,
                Block::new,
                BlockBehaviour.Properties.of().strength(2.0F, 3.0F)
        );
    }
}
