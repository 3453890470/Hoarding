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
