package dev.gateguardian.hoarding.generator;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import dev.gateguardian.hoarding.generator.provider.HoardingLootProvider;
import dev.gateguardian.hoarding.generator.provider.HoardingRecipeProvider;
import net.minecraft.data.loot.LootTableProvider;
import dev.gateguardian.hoarding.generator.provider.HoardingModelProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = Hoarding.MOD_ID)
public class DataGenerator {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Client event) {
        StorageBlocks.init();

        event.createProvider((output, lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(
                        lookup -> HoardingLootProvider.create(lookupProvider.join()),
                        LootContextParamSets.BLOCK
                )),
                lookupProvider
        ));

        event.createProvider(HoardingRecipeProvider.Runner::new);

        event.createProvider(HoardingModelProvider::new);
    }
}
