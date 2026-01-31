package dev.gateguardian.hoarding.generator;

import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.generator.provider.*;
import lombok.experimental.UtilityClass;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@UtilityClass
@Mod.EventBusSubscriber(modid = Hoarding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {

    @SubscribeEvent
    public void bootstrap(GatherDataEvent event) {
        var generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        var lookup = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new HoardingLanguageProvider(output));
        generator.addProvider(event.includeClient(), new HoardingItemModelProvider(output, helper));
        generator.addProvider(event.includeClient(), new HoardingBlockStateProvider(output, helper));

        generator.addProvider(event.includeServer(), new HoardingLootProvider(output));
        generator.addProvider(event.includeServer(), new HoardingRecipeProvider(output));
    }
}
