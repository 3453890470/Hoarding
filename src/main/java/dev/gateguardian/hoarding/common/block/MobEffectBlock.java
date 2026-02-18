package dev.gateguardian.hoarding.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MobEffectBlock extends Block {

    public static final MapCodec<MobEffectBlock> CODEC = simpleCodec(MobEffectBlock::create);

    private final Holder<MobEffect> effect;
    private final int amplifier;

    private static MobEffectBlock create(Properties properties) {
        // Default constructor for codec - uses harmless effect
        return new MobEffectBlock(properties, Holder.direct(null), 0);
    }

    public MobEffectBlock(Properties properties, Holder<MobEffect> effect) {
        this(properties, effect, 0);
    }

    public MobEffectBlock(Properties properties, Holder<MobEffect> effect, int amplifier) {
        super(properties);
        this.effect = effect;
        this.amplifier = amplifier;
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (effect != null && entity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(this.effect, 40, this.amplifier));
        }
        super.stepOn(level, pos, state, entity);
    }
}
