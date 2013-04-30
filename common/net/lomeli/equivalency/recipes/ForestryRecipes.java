package net.lomeli.equivalency.recipes;

import forestry.api.core.ItemInterface;

import net.lomeli.equivalency.helper.TransmutationHelper;
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
		
		// 3 Copper Ingot -> Tin Ingot
		TransmutationHelper.addRecipe(tinIngot, transmutationStone, 
			new Object[]{ copperIngot, copperIngot, copperIngot });
		// 1 Tin Ingot -> 3 Copper Ingot
		TransmutationHelper.addRecipe(new ItemStack(copperIngot.getItem(), 3), transmutationStone, 
			new Object[]{ tinIngot });
		
		// 1 Bronze Ingot -> 2 Tin Ingot
		TransmutationHelper.addRecipe(new ItemStack(tinIngot.getItem(), 2), transmutationStone, 
			new Object[]{ bronzeIngot });
		// 2 Tin Ingot -> 1 Bronze Ingot
		TransmutationHelper.addRecipe(bronzeIngot, transmutationStone, 
			new Object[]{tinIngot, tinIngot});
	}
}
