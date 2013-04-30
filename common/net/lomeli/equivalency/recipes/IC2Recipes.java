package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.lomeli.equivalency.ic2.IC2ItemAPI;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IC2Recipes 
{
	public static ItemStack copperIngot = IC2ItemAPI.getItem("copperIngot");
	public static ItemStack tinIngot = IC2ItemAPI.getItem("tinIngot");
	public static ItemStack bronzeIngot  = IC2ItemAPI.getItem("bronzeIngot");
	public static ItemStack uraniumDrop = IC2ItemAPI.getItem("uraniumDrop");
	public static ItemStack stickyResin = IC2ItemAPI.getItem("resin");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		UniversalRecipes.ingotCopper.add(copperIngot);
		UniversalRecipes.ingotTin.add(tinIngot);
		UniversalRecipes.ingotBronze.add(bronzeIngot);
		UniversalRecipes.uranium.add(uraniumDrop);
		
		// Resin -> leather
		TransmutationHelper.addRecipe(Item.leather, transmutationStone, new Object[]
			{ stickyResin });
		// leather -> Resin
		TransmutationHelper.addRecipe(stickyResin, transmutationStone, new Object[]
			{ Item.leather });
		
		// 3 Copper Ingot -> Tin Ingot
		TransmutationHelper.addRecipe(tinIngot, transmutationStone, 
			new Object[]{ copperIngot, copperIngot, copperIngot });
		// 1 Tin Ingot -> 3 Copper Ingot
		TransmutationHelper.addRecipe(new ItemStack(copperIngot.getItem(), 3), transmutationStone, 
			new Object[]{ tinIngot });
		
		// 7 Bronze -> 1 Uranium
		TransmutationHelper.addRecipe(uraniumDrop, transmutationStone, 
			new Object[]{bronzeIngot, bronzeIngot, bronzeIngot, bronzeIngot,
			bronzeIngot, bronzeIngot, bronzeIngot});
		// 1 Uranium -> 7 Bronze
		TransmutationHelper.addRecipe(new ItemStack(bronzeIngot.getItem(), 7), 
			transmutationStone, new Object[]{ uraniumDrop });
		
		// 2 Uranium -> 1 Diamond
		TransmutationHelper.addRecipe(Item.diamond, transmutationStone, 
			new Object[]{uraniumDrop, uraniumDrop});
	}
}
