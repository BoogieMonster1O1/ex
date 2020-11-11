package io.github.boogiemonster1o1.exnihilosuperesse.item;

import io.github.boogiemonster1o1.exnihilosuperesse.ExNihiloSuperesse;
import io.github.boogiemonster1o1.registerme.RegisterMe;
import io.github.boogiemonster1o1.registerme.RegistryEntry;

import net.minecraft.block.Blocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

@SuppressWarnings("unused")
@RegisterMe(ExNihiloSuperesse.MODID)
public class ModItems {
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(ExNihiloSuperesse.MODID, "itemgroup"), ModItems::getIt);
	@RegistryEntry("oak_seed")
	public static final Item OAK_SEED = new BlockItem(Blocks.OAK_SAPLING, getSettings());

	@RegistryEntry("spruce_seed")
	public static final Item SPRUCE_SEED = new BlockItem(Blocks.SPRUCE_SAPLING, getSettings());

	@RegistryEntry("birch_seed")
	public static final Item BIRCH_SEED = new BlockItem(Blocks.BIRCH_SAPLING, getSettings());

	@RegistryEntry("jungle_seed")
	public static final Item JUNGLE_SEED = new BlockItem(Blocks.JUNGLE_SAPLING, getSettings());

	@RegistryEntry("acacia_seed")
	public static final Item ACACIA_SEED = new BlockItem(Blocks.ACACIA_SAPLING, getSettings());

	@RegistryEntry("dark_oak_seed")
	public static final Item DARK_OAK_SEED = new BlockItem(Blocks.BIRCH_SAPLING, getSettings());

	@RegistryEntry("sugarcane_seed")
	public static final Item SUGARCANE_SEED = new BlockItem(Blocks.SUGAR_CANE, getSettings());

	@RegistryEntry("cactus_seed")
	public static final Item CACTUS_SEED = new BlockItem(Blocks.CACTUS, getSettings());

	@RegistryEntry("carrot_seed")
	public static final Item CARROT_SEED = new AliasedBlockItem(Blocks.CARROTS, getSettings());

	@RegistryEntry("potato_seed")
	public static final Item POTATO_SEED = new AliasedBlockItem(Blocks.POTATOES, getSettings());

	@RegistryEntry("wooden_hammer")
	public static final Item WOODEN_HAMMER = new HammerItem(ToolMaterials.WOOD, getSettings());

	@RegistryEntry("stone_hammer")
	public static final Item STONE_HAMMER = new HammerItem(ToolMaterials.STONE, getSettings());

	@RegistryEntry("iron_hammer")
	public static final Item IRON_HAMMER = new HammerItem(ToolMaterials.IRON, getSettings());

	@RegistryEntry("gold_hammer")
	public static final Item GOLD_HAMMER = new HammerItem(ToolMaterials.GOLD, getSettings());

	@RegistryEntry("diamond_hammer")
	public static final Item DIAMOND_HAMMER = new HammerItem(ToolMaterials.DIAMOND, getSettings());

	@RegistryEntry("netherite_hammer")
	public static final Item NETHERITE_HAMMER = new HammerItem(ToolMaterials.NETHERITE, getSettings());

	@RegistryEntry("silkworm")
	public static final Item SILKWORM = new SilkwormItem(getSettings());

	@RegistryEntry("cooked_silkworm")
	public static final Item COOKED_SILKWORM = new Item(getSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.5F).build()));

	private static ItemStack getIt() {
		return new ItemStack(OAK_SEED);
	}

	private static Settings getSettings() {
		return new Item.Settings().group(ITEM_GROUP);
	}
}
