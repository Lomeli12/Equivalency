package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.helper.TransmutationHelper;
import net.lomeli.equivalency.mods.ic2.IC2ItemAPI;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class IC2Recipes 
{
	public static ItemStack copperIngot = IC2ItemAPI.getItem("copperIngot");
	public static ItemStack tinIngot = IC2ItemAPI.getItem("tinIngot");
	public static ItemStack bronzeIngot  = IC2ItemAPI.getItem("bronzeIngot");
	public static ItemStack uraniumDrop = IC2ItemAPI.getItem("uraniumDrop");
	public static ItemStack stickyResin = IC2ItemAPI.getItem("resin");
	public static ItemStack refinedIronIngot = IC2ItemAPI.getItem("refinedIronIngot");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		UniversalRecipes.ingotCopper.add(copperIngot);
		UniversalRecipes.ingotTin.add(tinIngot);
		UniversalRecipes.ingotBronze.add(bronzeIngot);
		UniversalRecipes.uranium.add(uraniumDrop);
		
		OreDictionary.registerOre("ingotCopper", copperIngot);
		OreDictionary.registerOre("ingotTin", tinIngot);
		OreDictionary.registerOre("ingotBronze", bronzeIngot);
		
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
