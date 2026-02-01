package dev.gateguardian.hoarding.common.registry;

import dev.gateguardian.hoarding.common.Hoarding;
import lombok.experimental.UtilityClass;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Supplier;

@UtilityClass
public class HoardingItems {

    public final Queue<RegistryObject<Item>> CREATIVE_MODE_TAB_ITEMS = new ArrayDeque<>(128);
    public final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Hoarding.MOD_ID);

    public final RegistryObject<Item> PUMPKIN_SLICE = item("pumpkin_slice", () -> new Item(
            new Item.Properties().food(new FoodProperties.Builder()
                    .alwaysEat()
                    .nutrition(1)
                    .saturationMod(2f)
                    .build()
            )
    ));

    public void init(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }

    public RegistryObject<Item> item(final String name, final Supplier<Item> supplier) {
        RegistryObject<Item> block = REGISTER.register(name, supplier);
        CREATIVE_MODE_TAB_ITEMS.offer(block);
        return block;
    }
}
