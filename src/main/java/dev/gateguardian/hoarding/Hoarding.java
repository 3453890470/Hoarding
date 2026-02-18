package dev.gateguardian.hoarding;

import com.mojang.logging.LogUtils;
import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import dev.gateguardian.hoarding.common.registry.HoardingCreativeModeTabs;
import dev.gateguardian.hoarding.common.registry.HoardingItems;
import dev.gateguardian.hoarding.common.registry.HoardingParticleTypes;
import dev.gateguardian.hoarding.integration.ModIntegration;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(Hoarding.MOD_ID)
public class Hoarding {
    public static final String MOD_ID = "hoarding";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public Hoarding(IEventBus modEventBus) {
        // 注册方块
        HoardingBlocks.register(modEventBus);
        // 注册物品
        HoardingItems.register(modEventBus);
        // 注册创造模式标签页
        HoardingCreativeModeTabs.register(modEventBus);
        // 注册粒子类型
        HoardingParticleTypes.register(modEventBus);

        // 初始化整合模块
        ModIntegration.init();

        LOGGER.info("Hoarding mod initialized!");
    }
}
