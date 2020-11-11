package io.github.boogiemonster1o1.exnihilosuperrese.test;

import com.google.gson.GsonBuilder;
import com.mojang.serialization.JsonOps;
import org.junit.jupiter.api.Test;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ItemStackSerializationTest {
	@Test
	public void serialize() {
		ItemStack stack = new ItemStack(Items.GRAVEL);
		System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(ItemStack.CODEC.encodeStart( JsonOps.INSTANCE, stack).getOrThrow(false, System.err::println)));
	}
}
