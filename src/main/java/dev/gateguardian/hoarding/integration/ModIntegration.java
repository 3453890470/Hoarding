package dev.gateguardian.hoarding.integration;

import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.integration.arsnouveau.HoardingArsNouveauBlocks;
import dev.gateguardian.hoarding.integration.botania.HoardingBotaniaBlocks;
import lombok.experimental.UtilityClass;
import net.minecraftforge.fml.ModList;

@UtilityClass
public class ModIntegration {

    public final String BOTANIA_MOD_ID = "botania";
    public final String ARS_NOUVEAU_MOD_ID = "ars_nouveau";

    public void init() {
        if (isBotaniaLoaded()) {
            Hoarding.LOGGER.info("Botania detected - registering integration blocks");
            HoardingBotaniaBlocks.init();
        }

        if (isArsNouveauLoaded()) {
            Hoarding.LOGGER.info("Ars Nouveau detected - registering integration blocks");
            HoardingArsNouveauBlocks.init();
        }
    }

    public boolean isBotaniaLoaded() {
        return ModList.get().isLoaded(BOTANIA_MOD_ID);
    }

    public boolean isArsNouveauLoaded() {
        return ModList.get().isLoaded(ARS_NOUVEAU_MOD_ID);
    }
}