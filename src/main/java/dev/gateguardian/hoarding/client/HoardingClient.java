package dev.gateguardian.hoarding.client;

import dev.gateguardian.hoarding.Hoarding;
//import dev.gateguardian.hoarding.client.particle.SteamParticle;
import dev.gateguardian.hoarding.common.registry.HoardingParticleTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = Hoarding.MOD_ID, value = Dist.CLIENT)
public final class HoardingClient {

    // TODO: MC 26.1.2 — 粒子系统已变更新 API，待 SteamParticle 重写后恢复（参见 SteamParticle.java 的 TODO）
    //@SubscribeEvent
    //public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
    //    event.registerSpriteSet(HoardingParticleTypes.STEAM.get(), SteamParticle.Provider::new);
    //}
}
