package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.helper.TransmutationHelper;

import net.lomeli.lomlib.item.ItemUtil;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IC2Recipes 
{
	public static final String ITEM_LOC = "ic2.core.Ic2Items";
	public static ItemStack copperIngot = ItemUtil.getItem("copperIngot", ITEM_LOC);
	public static ItemStack tinIngot = ItemUtil.getItem("tinIngot", ITEM_LOC);
	public static ItemStack bronzeIngot  = ItemUtil.getItem("bronzeIngot", ITEM_LOC);
	public static ItemStack uraniumDrop = ItemUtil.getItem("uraniumDrop", ITEM_LOC);
	public static ItemStack stickyResin = ItemUtil.getItem("resin", ITEM_LOC);
	public static ItemStack refinedIronIngot = ItemUtil.getItem("refinedIronIngot", ITEM_LOC);
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		UniversalRecipes.ingotBronze.add(bronzeIngot);
		UniversalRecipes.ingotCopper.add(copperIngot);
		UniversalRecipes.ingotTin.add(tinIngot);
		UniversalRecipes.uranium.add(uraniumDrop);
		
		// 3 Resin -> Leather
		TransmutationHelper.addRecipe(Item.leather, transmutationStone, new Object[]
			{ stickyResin, stickyResin, stickyResin });
		// Leather -> 3 Resin
		TransmutationHelper.addRecipe(new ItemStack(stickyResin.getItem(), 3), transmutationStone, new Object[]
			{ Item.leather });
		
		if(!Equivalency.limitRecipes)
		{
			UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
			UniversalRecipes.bronzeTin(bronzeIngot, tinIngot, transmutationStone);
			UniversalRecipes.uraniumDiamond(uraniumDrop, transmutationStone);
		}
	}
}
