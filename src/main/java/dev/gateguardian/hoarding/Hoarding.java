package dev.gateguardian.hoarding;

import dev.gateguardian.hoarding.common.config.HoardingConfig;
import dev.gateguardian.hoarding.common.registry.*;
import dev.gateguardian.hoarding.integration.ModIntegration;
import dev.gateguardian.hoarding.integration.botania.HoardingBotaniaBlocks;
import dev.gateguardian.hoarding.integration.arsnouveau.HoardingArsNouveauBlocks;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Hoarding.MOD_ID)
public class Hoarding {
    public static final String MOD_ID = "hoarding";
    public static final Logger LOGGER = LoggerFactory.getLogger(Hoarding.class);

    public static Identifier id(String path) {
        return Identifier.parse(MOD_ID + ":" + path);
    }

    public Hoarding(IEventBus modEventBus, ModContainer container) {
        // Register config
        container.registerConfig(ModConfig.Type.CLIENT, HoardingConfig.SPEC);

        // Register config GUI screen (enables in-game editing)
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        // Reload config-dependent visibility when config changes at runtime
        modEventBus.addListener(ModConfigEvent.Reloading.class, event -> {
            if (event.getConfig().getType() == ModConfig.Type.CLIENT) {
                ModIntegration.applyCreativeTabVisibility();
            }
        });

        HoardingBlocks.register(modEventBus);
        HoardingItems.register(modEventBus);
        HoardingCreativeModeTabs.register(modEventBus);
        HoardingParticleTypes.register(modEventBus);

        // Register blocks unconditionally (config controls visibility)
        HoardingBotaniaBlocks.init();
        HoardingArsNouveauBlocks.init();

        // Defer config-dependent init to CommonSetup
        modEventBus.addListener(this::onCommonSetup);

        LOGGER.info("Hoarding mod initialized!");
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        // Config 此时已加载，可安全读取配置值
        ModIntegration.init();
    }
}
