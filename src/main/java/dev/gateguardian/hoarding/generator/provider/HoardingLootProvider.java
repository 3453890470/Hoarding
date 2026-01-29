package dev.gateguardian.hoarding.generator.provider;

import com.google.common.collect.Iterables;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class HoardingLootProvider extends LootTableProvider {

    public HoardingLootProvider(PackOutput output) {
        super(
                output,
                HoardingBlocks.REGISTER.getEntries().stream()
                        .map(RegistryObject::getId)
                        .collect(Collectors.toSet()),
                List.of(new SubProviderEntry(BlockProvider::new, LootContextParamSets.BLOCK))
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext context) {
        map.forEach((key, value) -> value.validate(context));
    }

    static class BlockProvider extends BlockLootSubProvider {

        protected BlockProvider() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void generate() {
            HoardingBlocks.REGISTER.getEntries().forEach(block -> dropSelf(block.get()));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Iterables.transform(
                    HoardingBlocks.REGISTER.getEntries(),
                    obj -> Objects.requireNonNull(obj, "RegistryObject cannot be null").get()
            );
        }
    }
}
