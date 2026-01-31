package dev.gateguardian.hoarding.common;

import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import dev.gateguardian.hoarding.common.registry.HoardingCreativeModeTabs;
import dev.gateguardian.hoarding.common.registry.HoardingItems;
import dev.gateguardian.hoarding.integration.ModIntegration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hoarding {

    public static final String MOD_ID = "hoarding";
    public static final String MOD_NAME = "Hoarding";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public Hoarding(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::addItemsToCreativeModeTab);
        HoardingItems.bootstrap(modEventBus);
        HoardingBlocks.bootstrap(modEventBus);
        HoardingCreativeModeTabs.bootstrap(modEventBus);
        ModIntegration.bootstrap(context);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private void addItemsToCreativeModeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(HoardingCreativeModeTabs.MAIN.getKey())) {
            HoardingItems.CREATIVE_MODE_TAB_ITEMS.forEach(event::accept);
        }
    }
}
