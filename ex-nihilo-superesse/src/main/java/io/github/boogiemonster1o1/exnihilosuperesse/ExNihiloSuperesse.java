package io.github.boogiemonster1o1.exnihilosuperesse;

import net.fabricmc.loader.api.FabricLoader;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class ExNihiloSuperesse {
	public static final String MODID = "ex-nihilo-superesse";
	public static final String MOD_NAME = FabricLoader.getInstance().getModContainer("ex-nihilo-superesse").get().getMetadata().getName();
	public static final String VERSION = FabricLoader.getInstance().getModContainer("ex-nihilo-superesse").get().getMetadata().getVersion().getFriendlyString();
}
