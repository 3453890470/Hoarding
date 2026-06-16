package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

/**
 * MC 26.1.2 BlockLootSubProvider — 所有方块自掉落
 */
public abstract class HoardingLootProvider {

    public static BlockLootSubProvider create(HolderLookup.Provider lookupProvider) {
        return new HoardingBlockLootSubProvider(lookupProvider);
    }

    private static class HoardingBlockLootSubProvider extends BlockLootSubProvider {

        protected HoardingBlockLootSubProvider(HolderLookup.Provider lookupProvider) {
            super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
        }

        @Override
        protected void generate() {
            HoardingBlocks.BLOCKS.getEntries().forEach(block -> dropSelf(block.get()));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return HoardingBlocks.BLOCKS.getEntries().stream()
                    .<Block>map(holder -> holder.get())
                    .toList();
        }
    }
}
