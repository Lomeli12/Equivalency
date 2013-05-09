package net.lomeli.equivalency.recipes;

import forestry.api.core.ItemInterface;

import net.lomeli.equivalency.Equivalency;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

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
		
		OreDictionary.registerOre("ingotCopper", copperIngot);
		OreDictionary.registerOre("ingotTin", tinIngot);
		OreDictionary.registerOre("ingotBronze", bronzeIngot);
		
		if(!Equivalency.limitRecipes)
		{
			UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
			UniversalRecipes.bronzeTin(bronzeIngot, tinIngot, transmutationStone);
		}
	}
}
