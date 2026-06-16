package dev.gateguardian.hoarding.common.registry;

import dev.gateguardian.hoarding.Hoarding;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoardingCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Hoarding.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main_tab", () -> 
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(HoardingItems.PUMPKIN_SLICE.get()))
                    .displayItems((params, output) -> {
                        output.accept(HoardingItems.PUMPKIN_SLICE.get());
                        for (DeferredItem<? extends Item> item : HoardingItems.CREATIVE_MODE_TAB_ITEMS) {
                            output.accept(item.get());
                        }
                    })
                    .title(Component.translatable("itemGroup.hoarding.main"))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
