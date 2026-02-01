package dev.gateguardian.hoarding.common.registry;


import dev.gateguardian.hoarding.common.Hoarding;
import lombok.experimental.UtilityClass;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@UtilityClass
public class HoardingParticleTypes {

    public final DeferredRegister<ParticleType<?>> REGISTER = DeferredRegister.create(Registries.PARTICLE_TYPE, Hoarding.MOD_ID);

    public final RegistryObject<SimpleParticleType> STEAM = REGISTER.register("steam", () -> new SimpleParticleType(false));

    public void init(IEventBus bus) {
        REGISTER.register(bus);
    }
}
