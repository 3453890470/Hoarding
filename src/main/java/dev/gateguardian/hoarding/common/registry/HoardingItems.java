package dev.gateguardian.hoarding.common.registry;

import dev.gateguardian.hoarding.Hoarding;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Supplier;

public class HoardingItems {

    public static final Queue<DeferredItem<Item>> CREATIVE_MODE_TAB_ITEMS = new ArrayDeque<>(128);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Hoarding.MOD_ID);

    public static final DeferredItem<Item> PUMPKIN_SLICE = item("pumpkin_slice", () -> new Item(
            new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(2f)
                    .build()
            )
    ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static DeferredItem<Item> item(String name, Supplier<Item> supplier) {
        DeferredItem<Item> item = ITEMS.register(name, supplier);
        CREATIVE_MODE_TAB_ITEMS.offer(item);
        return item;
    }
}
