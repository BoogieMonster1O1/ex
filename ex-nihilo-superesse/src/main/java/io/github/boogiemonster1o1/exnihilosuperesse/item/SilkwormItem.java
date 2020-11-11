package io.github.boogiemonster1o1.exnihilosuperesse.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class SilkwormItem extends Item {
	public SilkwormItem(Settings settings) {
		super(settings);
	}

	// TODO
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		//noinspection ConstantConditions
		if (!context.getPlayer().isCreative()) {
			context.getStack().decrement(1);
		}
		return super.useOnBlock(context);
	}
}
