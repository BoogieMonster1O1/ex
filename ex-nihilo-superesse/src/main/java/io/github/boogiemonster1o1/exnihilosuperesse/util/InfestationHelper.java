package io.github.boogiemonster1o1.exnihilosuperesse.util;

import net.minecraft.block.BlockState;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InfestationHelper {
	private InfestationHelper() {
	}

	public static ActionResult tryInfesting(World world, BlockPos pos) {
		if(world.isClient) {
			return ActionResult.PASS;
		}
		BlockState originalState = world.getBlockState(pos);
		return ActionResult.SUCCESS;
	}
}
