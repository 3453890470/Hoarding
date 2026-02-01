package dev.gateguardian.hoarding.integration.arsnouveau;

import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import lombok.experimental.UtilityClass;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class HoardingArsNouveauBlocks {

    public final Map<Block, Item> STORAGE_BLOCK_LOOKUP = new HashMap<>(4);

    public final RegistryObject<Block> MAGEBLOOM_CRATE = archwoodCrate("magebloom_crate");
    public final RegistryObject<Block> SOURCEBERRY_CRATE = archwoodCrate("sourceberry_crate");

    public void init() {

    }

    private RegistryObject<Block> archwoodCrate(String name) {
        return HoardingBlocks.block(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    }
}
