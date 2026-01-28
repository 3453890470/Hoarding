package dev.gateguardian.hoarding;

import dev.gateguardian.hoarding.client.HoardingClient;
import dev.gateguardian.hoarding.common.Hoarding;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Hoarding.MOD_ID)
public class Bootstrap {

    public Bootstrap(FMLJavaModLoadingContext context) {
        DistExecutor.unsafeRunForDist(
                () -> () -> new HoardingClient(context),
                () -> () -> new Hoarding(context)
        );
    }
}
