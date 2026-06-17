/**
 * 整合模块入口 — 管理 Botania / Ars Nouveau 等可选 mod 的联动加载
 *
 * 联动方块始终注册（registry 中存在），但创造标签页和配方的可见性
 * 由 HoardingConfig 控制。
 */
package dev.gateguardian.hoarding.integration;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.common.config.HoardingConfig;
import dev.gateguardian.hoarding.common.registry.HoardingItems;
import dev.gateguardian.hoarding.integration.arsnouveau.HoardingArsNouveauBlocks;
import dev.gateguardian.hoarding.integration.botania.HoardingBotaniaBlocks;
import dev.gateguardian.hoarding.integration.jei.HoardingJeiPlugin;
import net.neoforged.fml.ModList;

public final class ModIntegration {

    public static final String BOTANIA_MOD_ID = "botania";
    public static final String ARS_NOUVEAU_MOD_ID = "ars_nouveau";

    private ModIntegration() {}

    public static void init() {
        // Always register integration blocks (they exist in registry regardless)
        HoardingBotaniaBlocks.init();
        HoardingArsNouveauBlocks.init();

        // Apply config: conditionally add to creative tab
        applyCreativeTabVisibility();

        Hoarding.LOGGER.info("Integration modules initialized");
    }

    public static void applyCreativeTabVisibility() {
        // Remove old integration items first, then re-add based on current config
        HoardingItems.CREATIVE_MODE_TAB_ITEMS.removeIf(item ->
            HoardingBotaniaBlocks.getAllItems().contains(item) ||
            HoardingArsNouveauBlocks.getAllItems().contains(item)
        );

        if (HoardingConfig.ENABLE_BOTANIA_INTEGRATION.get()) {
            for (var item : HoardingBotaniaBlocks.getAllItems()) {
                if (!HoardingItems.CREATIVE_MODE_TAB_ITEMS.contains(item)) {
                    HoardingItems.CREATIVE_MODE_TAB_ITEMS.offer(item);
                }
            }
            Hoarding.LOGGER.info("Botania integration blocks added to creative tab");
        }

        if (HoardingConfig.ENABLE_ARS_NOUVEAU_INTEGRATION.get()) {
            for (var item : HoardingArsNouveauBlocks.getAllItems()) {
                if (!HoardingItems.CREATIVE_MODE_TAB_ITEMS.contains(item)) {
                    HoardingItems.CREATIVE_MODE_TAB_ITEMS.offer(item);
                }
            }
            Hoarding.LOGGER.info("Ars Nouveau integration blocks added to creative tab");
        }

        // Also notify JEI to update ingredient visibility
        HoardingJeiPlugin.updateVisibility();
    }

    public static boolean isBotaniaLoaded() {
        return ModList.get() != null && ModList.get().isLoaded(BOTANIA_MOD_ID);
    }

    public static boolean isArsNouveauLoaded() {
        return ModList.get() != null && ModList.get().isLoaded(ARS_NOUVEAU_MOD_ID);
    }
}
