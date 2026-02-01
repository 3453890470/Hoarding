package dev.gateguardian.hoarding.common.registry;

import dev.gateguardian.hoarding.common.Hoarding;
import lombok.experimental.UtilityClass;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@UtilityClass
public class HoardingCreativeModeTabs {

    public final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Hoarding.MOD_ID);

    public final RegistryObject<CreativeModeTab> MAIN = REGISTER.register("main_tab", () -> CreativeModeTab.builder()
            .icon(() -> HoardingItems.PUMPKIN_SLICE.get().getDefaultInstance())
            .displayItems((params, output) -> output.accept(HoardingItems.PUMPKIN_SLICE.get()))
            .title(Component.translatable("itemGroup.hoarding.main"))
            .build());

    public void init(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
