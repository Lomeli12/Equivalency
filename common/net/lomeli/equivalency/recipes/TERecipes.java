package net.lomeli.equivalency.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import thermalexpansion.api.item.ItemRegistry;

public class TERecipes 
{
	public static ItemStack copperIngot = ItemRegistry.getItem("ingotCopper", 1);
	public static ItemStack tinIngot = ItemRegistry.getItem("ingotTin", 1);
	public static ItemStack silverIngot = ItemRegistry.getItem("ingotSilver", 1);
	public static ItemStack leadIngot = ItemRegistry.getItem("ingotLead", 1);
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		UniversalRecipes.ingotCopper.add(copperIngot);
		UniversalRecipes.ingotTin.add(tinIngot);
		UniversalRecipes.ingotSilver.add(silverIngot);
		UniversalRecipes.ingotLead.add(leadIngot);
		
		OreDictionary.registerOre("ingotCopper", copperIngot);
		OreDictionary.registerOre("ingotTin", tinIngot);
		OreDictionary.registerOre("ingotSilver", silverIngot);
		OreDictionary.registerOre("ingotLead", leadIngot);
		
		UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
		UniversalRecipes.leadSilver(leadIngot, silverIngot, transmutationStone);
	}
}
