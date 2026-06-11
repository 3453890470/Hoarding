package dev.gateguardian.hoarding.common.registry;

import dev.gateguardian.hoarding.Hoarding;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Function;
import java.util.function.Supplier;

public class HoardingItems {

    public static final Queue<DeferredItem<Item>> CREATIVE_MODE_TAB_ITEMS = new ArrayDeque<>(128);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Hoarding.MOD_ID);

    // MC 26.1.2: Item.Properties needs item ID set before construction.
    // Use registerItem(name, Item::new, () -> props) which calls properties.setId(...) internally.
    public static final DeferredItem<Item> PUMPKIN_SLICE = ITEMS.registerItem("pumpkin_slice",
            Item::new,
            () -> new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(2f)
                    .build()
            )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    /** Register an item with the correct MC 26.1.2 pattern (properties supplier, ID auto-set) */
    public static DeferredItem<Item> item(String name, Supplier<Item.Properties> properties, Function<Item.Properties, Item> factory) {
        DeferredItem<Item> item = ITEMS.registerItem(name, factory, properties);
        CREATIVE_MODE_TAB_ITEMS.offer(item);
        return item;
    }

    /** Legacy support for callers that create items directly (e.g. BlockItem construction).
     *  Only works if the Item constructor doesn't require item ID in properties. */
    public static DeferredItem<Item> item(String name, Supplier<Item> supplier) {
        DeferredItem<Item> item = ITEMS.register(name, supplier);
        CREATIVE_MODE_TAB_ITEMS.offer(item);
        return item;
    }
}
