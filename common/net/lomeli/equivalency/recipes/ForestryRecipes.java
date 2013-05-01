package net.lomeli.equivalency.recipes;

import forestry.api.core.ItemInterface;

import net.minecraft.item.ItemStack;

public class ForestryRecipes 
{
	public static ItemStack copperIngot = ItemInterface.getItem("ingotCopper");
	public static ItemStack tinIngot = ItemInterface.getItem("ingotTin");
	public static ItemStack bronzeIngot  = ItemInterface.getItem("ingotBronze");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		UniversalRecipes.ingotCopper.add(copperIngot);
		UniversalRecipes.ingotTin.add(tinIngot);
		UniversalRecipes.ingotBronze.add(bronzeIngot);
		
		UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
		
		UniversalRecipes.bronzeTin(bronzeIngot, tinIngot, transmutationStone);
	}
}
