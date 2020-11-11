package io.github.boogiemonster1o1.exnihilosuperesse;

import blue.endless.jankson.Jankson;
import io.github.boogiemonster1o1.exnihilosuperesse.data.HammerDataReloadListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.loader.api.FabricLoader;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class ExNihiloSuperesse {
	public static final String MODID = "ex-nihilo-superesse";
	public static final String MOD_NAME = FabricLoader.getInstance().getModContainer(MODID).get().getMetadata().getName();
	public static final String VERSION = FabricLoader.getInstance().getModContainer(MODID).get().getMetadata().getVersion().getFriendlyString();
	public static final Logger LOGGER = LogManager.getLogger();
	public static final Jankson JANKSON = Jankson.builder().build();
	public static final HammerDataReloadListener HAMMER_DATA = new HammerDataReloadListener();
}
