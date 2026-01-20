package dev.gateguardian.hoarding;

import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import dev.gateguardian.hoarding.common.registry.HoardingCreativeModeTabs;
import dev.gateguardian.hoarding.common.registry.HoardingItems;
import dev.gateguardian.hoarding.data.Datagen;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Hoarding.MOD_ID)
public class Hoarding {

    public static final String MOD_ID = "hoarding";
    public static final String MOD_NAME = "Hoarding";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public Hoarding(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(Datagen::init);
        modEventBus.addListener(this::addCreative);

        HoardingItems.init(modEventBus);
        HoardingBlocks.init(modEventBus);
        HoardingCreativeModeTabs.init(modEventBus);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == HoardingCreativeModeTabs.HOARDING_MAIN_TAB.getKey())
            HoardingItems.CREATIVE_TAB_ITEMS.forEach(event::accept);
    }
}
