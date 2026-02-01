package dev.gateguardian.hoarding.integration.botania;

import dev.gateguardian.hoarding.common.registry.HoardingBlocks;
import lombok.experimental.UtilityClass;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import vazkii.botania.common.block.BotaniaBlocks;

@UtilityClass
public class HoardingBotaniaBlocks {

    public final RegistryObject<Block> WHITE_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("white_mystical_flower_crate");
    public final RegistryObject<Block> ORANGE_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("orange_mystical_flower_crate");
    public final RegistryObject<Block> MAGENTA_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("magenta_mystical_flower_crate");
    public final RegistryObject<Block> LIGHT_BLUE_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("light_blue_mystical_flower_crate");
    public final RegistryObject<Block> YELLOW_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("yellow_mystical_flower_crate");
    public final RegistryObject<Block> LIME_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("lime_mystical_flower_crate");
    public final RegistryObject<Block> PINK_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("pink_mystical_flower_crate");
    public final RegistryObject<Block> GRAY_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("gray_mystical_flower_crate");
    public final RegistryObject<Block> LIGHT_GRAY_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("light_gray_mystical_flower_crate");
    public final RegistryObject<Block> CYAN_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("cyan_mystical_flower_crate");
    public final RegistryObject<Block> PURPLE_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("purple_mystical_flower_crate");
    public final RegistryObject<Block> BLUE_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("blue_mystical_flower_crate");
    public final RegistryObject<Block> BROWN_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("brown_mystical_flower_crate");
    public final RegistryObject<Block> GREEN_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("green_mystical_flower_crate");
    public final RegistryObject<Block> RED_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("red_mystical_flower_crate");
    public final RegistryObject<Block> BLACK_MYSTICAL_FLOWER_CRATE = mysticalFlowerCrate("black_mystical_flower_crate");

    public void init() {

    }

    private RegistryObject<Block> mysticalFlowerCrate(String name) {
        return HoardingBlocks.block(name, () -> new Block(
                BlockBehaviour.Properties.copy(BotaniaBlocks.livingwoodPlanks)
        ));
    }
}
