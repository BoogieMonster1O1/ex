package io.github.boogiemonster1o1.exnihilosuperesse.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import blue.endless.jankson.api.SyntaxError;
import io.github.boogiemonster1o1.exnihilosuperesse.ExNihiloSuperesse;
import io.github.cottonmc.jankson.JanksonOps;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;

public class HammerDataReloadListener implements SimpleSynchronousResourceReloadListener {
	private final List<HammerRecipe> hammerRecipes = new ArrayList<>();

	public static void init() {
		ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(ExNihiloSuperesse.HAMMER_DATA);
	}

	public ItemStack getOutput(Block block) {
		ItemStack ret = this.hammerRecipes.stream().collect(Collectors.toMap(HammerRecipe::getInput, HammerRecipe::getOutput)).get(block);
		return ret != null ? ret.copy() : ItemStack.EMPTY;
	}

	public Set<Block> getEffectiveBlocks() {
		return this.hammerRecipes.stream().map(HammerRecipe::getInput).collect(Collectors.toSet());
	}

	@Override
	public Identifier getFabricId() {
		return new Identifier(ExNihiloSuperesse.MODID, "hammer_data_reload_listener");
	}

	@Override
	public void apply(ResourceManager manager) {
		manager.findResources("ens_data/hammer_recipes", (str) -> str.endsWith(".json") || str.endsWith(".json5")).forEach(id -> {
			try {
				HammerRecipe recipe = JanksonOps.INSTANCE.withParser(HammerRecipe.CODEC).apply(ExNihiloSuperesse.JANKSON.load(manager.getResource(id).getInputStream())).getOrThrow(false, System.err::println);
				this.hammerRecipes.add(recipe);
			} catch (IOException e) {
				ExNihiloSuperesse.LOGGER.error("Exception fetching resource " + id.toString(), e);
			} catch (SyntaxError e) {
				ExNihiloSuperesse.LOGGER.error("Hammer recipe in " + id.toString() + " is not valid json! Skipping", e);
			} catch (RuntimeException e) {
				ExNihiloSuperesse.LOGGER.error("Caught an unexpected error while deserializing {}", id.toString());
				ExNihiloSuperesse.LOGGER.error("This usually happens if there is a schema error");
				ExNihiloSuperesse.LOGGER.error("Skipping {}", id.toString());
				ExNihiloSuperesse.LOGGER.error("Error: ", e);
			}
		});
	}
}
