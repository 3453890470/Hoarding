package dev.gateguardian.hoarding.integration.arsnouveau;

import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import lombok.experimental.UtilityClass;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

@UtilityClass
public class HoardingArsNouveauBlocks {

    public final RegistryObject<Block> MAGEBLOOM_CRATE = archwoodCrate("magebloom_crate");
    public final RegistryObject<Block> SOURCEBERRY_CRATE = archwoodCrate("sourceberry_crate");

    public void bootstrap() {

    }

    private RegistryObject<Block> archwoodCrate(String name) {
        return HoardingBlocks.block(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    }
}
