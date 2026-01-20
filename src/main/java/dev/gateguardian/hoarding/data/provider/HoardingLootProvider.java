package dev.gateguardian.hoarding.data.provider;

import com.google.common.collect.Iterables;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HoardingLootProvider extends LootTableProvider {

    public HoardingLootProvider(PackOutput pOutput) {
        super(pOutput, HoardingBlocks.BLOCKS.getEntries().stream().map(RegistryObject::getId).collect(Collectors.toSet()), List.of(new SubProviderEntry(Block::new, LootContextParamSets.BLOCK)));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @NotNull ValidationContext context) {
        map.forEach((key, value) -> value.validate(context));
    }

    public static class Block extends BlockLootSubProvider {

        protected Block() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void generate() {
            HoardingBlocks.BLOCKS.getEntries().forEach(block -> dropSelf(block.get()));
        }

        @NotNull
        @Override
        protected Iterable<net.minecraft.world.level.block.Block> getKnownBlocks() {
            return Iterables.transform(HoardingBlocks.BLOCKS.getEntries(), RegistryObject::get);
        }
    }
}
