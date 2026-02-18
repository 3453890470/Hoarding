package dev.gateguardian.hoarding.generator;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.generator.data.StorageBlocks;
import dev.gateguardian.hoarding.generator.provider.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Hoarding.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerator {

    @SubscribeEvent
    public static void bootstrap(GatherDataEvent event) {
        StorageBlocks.init();
        var generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        var helper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new HoardingLanguageProvider(output));
        generator.addProvider(event.includeClient(), new HoardingItemModelProvider(output, helper));
        generator.addProvider(event.includeClient(), new HoardingBlockStateProvider(output, helper));

        generator.addProvider(event.includeServer(), new HoardingLootProvider(output, lookupProvider));
        generator.addProvider(event.includeServer(), new HoardingRecipeProvider(output, lookupProvider));
        BlockTagsProvider blockTagsProvider = new HoardingBlockTagsProvider(output, lookupProvider, helper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(
                event.includeServer(),
                new HoardingItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), helper)
        );
    }
}
