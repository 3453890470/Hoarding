package dev.gateguardian.hoarding.data.provider;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.common.registry.HoardingItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class HoardingModelProvider extends ItemModelProvider {

    public HoardingModelProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, Hoarding.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        this.singleTexture(
                HoardingItems.PUMPKIN_SLICE.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated"),
                "layer0",
                Hoarding.id("item/" + HoardingItems.PUMPKIN_SLICE.getId().getPath())
        );
    }
}
