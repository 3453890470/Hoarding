package dev.gateguardian.hoarding.common.config;

import dev.gateguardian.hoarding.Hoarding;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.ModConfigSpec;

public class HoardingConfig {
    public static ModConfigSpec SPEC;

    // Botania integration
    public static ModConfigSpec.BooleanValue ENABLE_BOTANIA_INTEGRATION;

    // Ars Nouveau integration
    public static ModConfigSpec.BooleanValue ENABLE_ARS_NOUVEAU_INTEGRATION;

    static {
        var builder = new ModConfigSpec.Builder();

        builder.push("integration");

        ENABLE_BOTANIA_INTEGRATION = builder
                .comment(
                        "Enable Botania integration (blocks + recipes).",
                        "If Botania mod is not installed, blocks are still registered (can be obtained via /give).",
                        "Default: " + isModLoaded("botania") + " (follows mod availability)"
                )
                .translation("hoarding.config.enableBotaniaIntegration")
                .define("enableBotaniaIntegration", isModLoaded("botania"));

        ENABLE_ARS_NOUVEAU_INTEGRATION = builder
                .comment(
                        "Enable Ars Nouveau integration (blocks + recipes).",
                        "If Ars Nouveau mod is not installed, blocks are still registered (can be obtained via /give).",
                        "Default: " + isModLoaded("ars_nouveau")
                )
                .translation("hoarding.config.enableArsNouveauIntegration")
                .define("enableArsNouveauIntegration", isModLoaded("ars_nouveau"));

        builder.pop();

        SPEC = builder.build();
    }

    private static boolean isModLoaded(String modId) {
        return ModList.get() != null && ModList.get().isLoaded(modId);
    }
}
