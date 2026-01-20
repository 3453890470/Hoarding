package dev.gateguardian.hoarding.data;

import dev.gateguardian.hoarding.data.provider.*;
import net.minecraftforge.data.event.GatherDataEvent;

public class Datagen {
    public static void init(GatherDataEvent event) {
        var gen = event.getGenerator();
        var packOutput = gen.getPackOutput();
        var helper = event.getExistingFileHelper();
        gen.addProvider(event.includeClient(), new HoardingLanguageProvider(packOutput));
        gen.addProvider(event.includeClient(), new HoardingModelProvider(packOutput, helper));
        gen.addProvider(event.includeClient(), new HoardingBlockStateProvider(packOutput, helper));

        gen.addProvider(event.includeServer(), new HoardingLootProvider(packOutput));
    }
}
