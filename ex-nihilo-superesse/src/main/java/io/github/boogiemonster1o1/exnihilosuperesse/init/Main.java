package io.github.boogiemonster1o1.exnihilosuperesse.init;

import io.github.boogiemonster1o1.exnihilosuperesse.data.HammerDataReloadListener;
import io.github.boogiemonster1o1.exnihilosuperesse.item.ModItems;
import io.github.boogiemonster1o1.registerme.RegisterMeHooks;

import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
	@Override
	public void onInitialize() {
		RegisterMeHooks.registerItems(ModItems.class);
		HammerDataReloadListener.init();
	}
}
