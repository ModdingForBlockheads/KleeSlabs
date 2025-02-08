package net.blay09.mods.kleeslabs.converter;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;

public class DefaultSlabConverter implements SlabConverter {

    public static final SlabConverter INSTANCE = new DefaultSlabConverter();

    @Override
    public BlockState getSingleSlab(BlockState state, Level level, BlockPos pos, Player player, SlabType slabType) {
        if (state.hasProperty(BlockStateProperties.SLAB_TYPE)) {
            return state.setValue(BlockStateProperties.SLAB_TYPE, slabType);
        }
        return state;
    }

    @Override
    public boolean isDoubleSlab(BlockState state) {
        return state.hasProperty(BlockStateProperties.SLAB_TYPE) && state.getValue(BlockStateProperties.SLAB_TYPE) == SlabType.DOUBLE;
    }

}
