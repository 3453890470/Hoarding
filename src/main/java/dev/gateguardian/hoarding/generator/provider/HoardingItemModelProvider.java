package dev.gateguardian.hoarding.generator.provider;

import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.common.registry.HoardingItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class HoardingItemModelProvider extends ItemModelProvider {

    public HoardingItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, Hoarding.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        basicItem(HoardingItems.PUMPKIN_SLICE.getId());
    }
}
