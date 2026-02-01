package dev.gateguardian.hoarding.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MobEffectBlock extends Block {

    private final MobEffect effect;
    private final int amplifier;

    public MobEffectBlock(Properties properties, MobEffect effect) {
        this(properties, effect, 0);
    }

    public MobEffectBlock(Properties properties, MobEffect effect, int amplifier) {
        super(properties);
        this.effect = effect;
        this.amplifier = amplifier;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(this.effect, 40, this.amplifier));
        }
        super.stepOn(level, pos, state, entity);
    }
}
