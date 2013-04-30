package net.lomeli.equivalency.recipes;

import net.minecraft.item.ItemStack;
import net.lomeli.equivalency.helper.TransmutationHelper;
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
		
		// 3 Copper Ingot -> Tin Ingot
		TransmutationHelper.addRecipe(tinIngot, transmutationStone, 
			new Object[]{ copperIngot.getItem(), copperIngot, copperIngot });
		
		// 1 Tin Ingot -> 3 Copper Ingot
		TransmutationHelper.addRecipe(new ItemStack(copperIngot.getItem(), 3), transmutationStone, 
			new Object[]{ tinIngot });
	}
}
