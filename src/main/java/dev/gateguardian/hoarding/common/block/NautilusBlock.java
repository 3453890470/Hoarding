package dev.gateguardian.hoarding.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NautilusBlock extends HorizontalFacingBlock {

    private static final VoxelShape SHAPE_X = Block.box(0.0D, 0.0D, 1.0D, 16.0D, 16.0D, 15.0D);
    private static final VoxelShape SHAPE_Z = Block.box(1.0D, 0.0D, 0.0D, 15.0D, 16.0D, 16.0D);

    public NautilusBlock(Properties p_52591_) {
        super(p_52591_);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return facing.getAxis() == Direction.Axis.X ? SHAPE_X : SHAPE_Z;
    }
}
