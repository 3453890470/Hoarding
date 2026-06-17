package dev.gateguardian.hoarding.integration.jei;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.common.config.HoardingConfig;
import dev.gateguardian.hoarding.integration.arsnouveau.HoardingArsNouveauBlocks;
import dev.gateguardian.hoarding.integration.botania.HoardingBotaniaBlocks;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class HoardingJeiPlugin implements IModPlugin {

    private static IJeiRuntime jeiRuntime = null;

    @Override
    public Identifier getPluginUid() {
        return Identifier.fromNamespaceAndPath(Hoarding.MOD_ID, "jei_plugin");
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime runtime) {
        jeiRuntime = runtime;
        Hoarding.LOGGER.info("Hoarding JEI plugin runtime available");
    }

    /**
     * Update JEI ingredient visibility based on current config.
     * Called when the client config changes at runtime.
     */
    public static void updateVisibility() {
        if (jeiRuntime == null) return;

        IIngredientManager ingredientManager = jeiRuntime.getIngredientManager();

        // Collect all integration block items
        List<ItemStack> botaniaItems = new ArrayList<>();
        List<ItemStack> arsItems = new ArrayList<>();

        for (var block : HoardingBotaniaBlocks.getAllBlocks()) {
            botaniaItems.add(new ItemStack(block.get()));
        }
        for (var block : HoardingArsNouveauBlocks.getAllBlocks()) {
            arsItems.add(new ItemStack(block.get()));
        }

        // Apply visibility based on config
        if (HoardingConfig.ENABLE_BOTANIA_INTEGRATION.get()) {
            ingredientManager.addIngredientsAtRuntime(VanillaTypes.ITEM_STACK, botaniaItems);
        } else {
            ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, botaniaItems);
        }

        if (HoardingConfig.ENABLE_ARS_NOUVEAU_INTEGRATION.get()) {
            ingredientManager.addIngredientsAtRuntime(VanillaTypes.ITEM_STACK, arsItems);
        } else {
            ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, arsItems);
        }

        Hoarding.LOGGER.info("JEI integration visibility updated");
    }
}
