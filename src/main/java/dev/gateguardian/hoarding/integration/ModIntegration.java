package dev.gateguardian.hoarding.integration;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.integration.arsnouveau.HoardingArsNouveauBlocks;
import dev.gateguardian.hoarding.integration.botania.HoardingBotaniaBlocks;
import net.neoforged.fml.ModList;

public final class ModIntegration {

    public static final String BOTANIA_MOD_ID = "botania";
    public static final String ARS_NOUVEAU_MOD_ID = "ars_nouveau";

    private ModIntegration() {}

    public static void init() {
        if (isBotaniaLoaded()) {
            Hoarding.LOGGER.info("Botania detected - registering integration blocks");
            HoardingBotaniaBlocks.init();
        }

        if (isArsNouveauLoaded()) {
            Hoarding.LOGGER.info("Ars Nouveau detected - registering integration blocks");
            HoardingArsNouveauBlocks.init();
        }
    }

    public static boolean isBotaniaLoaded() {
        return ModList.get().isLoaded(BOTANIA_MOD_ID);
    }

    public static boolean isArsNouveauLoaded() {
        return ModList.get().isLoaded(ARS_NOUVEAU_MOD_ID);
    }
}
