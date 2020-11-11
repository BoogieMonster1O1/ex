package io.github.boogiemonster1o1.registerme;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterMeHooks {
	private static final Predicate<Field> FIELD_PREDICATE = field -> Modifier.isStatic(field.getModifiers())
			&& Modifier.isPublic(field.getModifiers())
			&& Modifier.isFinal(field.getModifiers())
			&& field.isAnnotationPresent(RegistryEntry.class);

	public static void registerItems(Class<?> clazz) {
		register(clazz, Registry.ITEM, Item.class);
	}

	public static void registerBlocks(Class<?> clazz) {
		register(clazz, Registry.BLOCK, Block.class);
	}

	private static <T> void register(Class<?> clazz, Registry<T> registry, Class<T> componentType) {
		RegisterMe registerMe = clazz.getAnnotation(RegisterMe.class);
		Arrays.stream(clazz.getFields())
				.filter(FIELD_PREDICATE.and(field -> field.getType() == componentType))
				.forEach(field -> {
					try {
						//noinspection unchecked
						T item = (T) field.get(null);
						Registry.register(registry, new Identifier(registerMe.namespace(), field.getAnnotation(RegistryEntry.class).value()), item);
					} catch (IllegalAccessException e) {
						throw new AssertionError();
					}
				});
	}
}
