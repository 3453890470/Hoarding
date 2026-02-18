package dev.gateguardian.hoarding.client;

import dev.gateguardian.hoarding.Hoarding;
import dev.gateguardian.hoarding.client.particle.SteamParticle;
import dev.gateguardian.hoarding.common.registry.HoardingParticleTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = Hoarding.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class HoardingClient {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(HoardingParticleTypes.STEAM.get(), SteamParticle.Provider::new);
    }
}
