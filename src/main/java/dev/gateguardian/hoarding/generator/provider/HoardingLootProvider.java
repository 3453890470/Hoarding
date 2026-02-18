package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class HoardingLootProvider extends LootTableProvider {

    public HoardingLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Set.of(), List.of(new SubProviderEntry(BlockProvider::new, LootContextParamSets.BLOCK)), lookupProvider);
    }

    static class BlockProvider extends BlockLootSubProvider {

        protected BlockProvider(HolderLookup.Provider lookup) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookup);
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
