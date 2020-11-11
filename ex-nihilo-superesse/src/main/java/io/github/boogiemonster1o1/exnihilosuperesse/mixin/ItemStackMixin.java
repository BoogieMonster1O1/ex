package io.github.boogiemonster1o1.exnihilosuperesse.mixin;

import io.github.boogiemonster1o1.exnihilosuperesse.ExNihiloSuperesse;
import io.github.boogiemonster1o1.exnihilosuperesse.item.HammerItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@Shadow public abstract Item getItem();

	@Inject(method = "isEffectiveOn", at = @At("HEAD"), cancellable = true)
	public void setEffective(BlockState state, CallbackInfoReturnable<Boolean> cir) {
		if (this.getItem() instanceof HammerItem && ExNihiloSuperesse.HAMMER_DATA.getEffectiveBlocks().contains(state.getBlock())) {
			cir.setReturnValue(Boolean.TRUE);
		}
	}
}
