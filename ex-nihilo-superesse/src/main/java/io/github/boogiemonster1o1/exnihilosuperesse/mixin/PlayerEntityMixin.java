package io.github.boogiemonster1o1.exnihilosuperesse.mixin;

import io.github.boogiemonster1o1.exnihilosuperesse.item.HammerItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	@Shadow @Final public PlayerInventory inventory;

	@ModifyVariable(method = "getBlockBreakingSpeed", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/entity/player/PlayerInventory;getBlockBreakingSpeed(Lnet/minecraft/block/BlockState;)F"), ordinal = 0)
	public float modifyBreakSpeed(float original) {
		Item e = this.inventory.main.get(this.inventory.selectedSlot).getItem();
		if (e instanceof HammerItem) {
			return ((HammerItem) e).getMaterial().getMiningSpeedMultiplier();
		}
		return original;
	}
}
