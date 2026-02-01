package dev.gateguardian.hoarding.client;

import dev.gateguardian.hoarding.client.particle.SteamParticle;
import dev.gateguardian.hoarding.common.Hoarding;
import dev.gateguardian.hoarding.common.registry.HoardingParticleTypes;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public final class HoardingClient extends Hoarding {

    public HoardingClient(FMLJavaModLoadingContext context) {
        super(context);
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::registerParticleProviders);
    }

    private void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(HoardingParticleTypes.STEAM.get(), SteamParticle.Provider::new);
    }
}
