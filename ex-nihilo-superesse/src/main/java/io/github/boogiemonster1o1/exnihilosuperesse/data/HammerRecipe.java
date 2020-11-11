package io.github.boogiemonster1o1.exnihilosuperesse.data;

import java.util.Objects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.registry.Registry;

public final class HammerRecipe {
	public static final Codec<HammerRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			Registry.BLOCK.fieldOf("input").forGetter(HammerRecipe::getInput),
			ItemStack.CODEC.fieldOf("result").forGetter(HammerRecipe::getOutput)
	).apply(instance, HammerRecipe::new));

	private final Block input;
	private final ItemStack output;

	private HammerRecipe(Block input, ItemStack output) {
		super();
		this.input = input;
		this.output = output;
	}

	public Block getInput() {
		return this.input;
	}

	public ItemStack getOutput() {
		return this.output;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		HammerRecipe that = (HammerRecipe) o;
		return Objects.equals(this.input, that.input) &&
				Objects.equals(this.output, that.output);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.input, this.output);
	}

	@Override
	public String toString() {
		return "HammerRecipe{" +
				"input=" + this.input +
				", output=" + this.getOutput().toTag(new CompoundTag()).toString()  +
				'}';
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
