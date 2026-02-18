package dev.gateguardian.hoarding.common.block;

import dev.gateguardian.hoarding.common.registry.HoardingParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class HotFoodBlock extends Block {

    public HotFoodBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 1.0;
            double z = pos.getZ() + 0.5;
            level.addParticle(HoardingParticleTypes.STEAM.get(), x, y, z, 0.0, 0.08, 0.0);
        }
    }
}
