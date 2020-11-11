package io.github.boogiemonster1o1.exnihilosuperesse.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class InfestedLeavesBlock extends Block {
	public InfestedLeavesBlock(Settings settings) {
		super(settings);
	}

	@Override
	public boolean hasRandomTicks(BlockState state) {
		return true;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		super.randomTick(state, world, pos, random);
	}
}
