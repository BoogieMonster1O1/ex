package io.github.boogiemonster1o1.exnihilosuperesse.item;

import java.util.function.Consumer;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HammerItem extends ToolItem {
	public HammerItem(ToolMaterial material, Settings settings) {
		super(material, settings);
	}

	@Override
	public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
		if (state.getHardness(world, pos) != 0.0F) {
			stack.damage(1, miner, entity -> entity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
		}
		return true;
	}
}
