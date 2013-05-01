package net.lomeli.equivalency.recipes;

import net.minecraft.item.ItemStack;
import net.lomeli.magiks.api.ItemAPI;

public class MagiksRecipes 
{
	public static ItemStack copperIngot = ItemAPI.getItem("ingotCopper");
	public static ItemStack tinIngot = ItemAPI.getItem("ingotTin");
	public static ItemStack silverIngot = ItemAPI.getItem("ingotSilver");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		UniversalRecipes.ingotCopper.add(copperIngot);
		UniversalRecipes.ingotTin.add(tinIngot);
		UniversalRecipes.ingotSilver.add(silverIngot);
		
		UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
	}
}
