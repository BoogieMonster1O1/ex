package io.github.boogiemonster1o1.exnihilosuperesse.mixin;

import io.github.boogiemonster1o1.exnihilosuperesse.ExNihiloSuperesse;
import io.github.boogiemonster1o1.exnihilosuperesse.item.HammerItem;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(Block.class)
public abstract class BlockMixin {
	@Shadow
	public static void dropStack(World world, BlockPos pos, ItemStack stack) {
	}

	/** @reason modifies the drops if the item being used is a hammer */
	@Inject(method = "dropStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)V", at = @At("HEAD"), cancellable = true)
	private static void modifyDrops(BlockState state, World world, BlockPos pos, @Nullable BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfo ci) {
		if (!world.isClient() && stack.getItem() instanceof HammerItem) {
			ItemStack newStack = ExNihiloSuperesse.HAMMER_DATA.getOutput(state.getBlock());
			if (newStack != ItemStack.EMPTY) {
				dropStack(world, pos, newStack);
				state.onStacksDropped((ServerWorld) world, pos, newStack);
				ci.cancel();
			}
		}
	}
}
