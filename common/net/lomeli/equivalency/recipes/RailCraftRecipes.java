package net.lomeli.equivalency.recipes;

import java.util.List;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.lomeli.equivalency.lib.Strings;

import net.lomeli.lomlib.util.ModLoaded;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RailCraftRecipes 
{	
	public static List<ItemStack> steelIngot = OreDictionary.getOres("ingotSteel");
	public static List<ItemStack> coalCoke = OreDictionary.getOres("fuelCoke");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		for(ItemStack steel : steelIngot)
		{
			if(ModLoaded.isModInstalled(Strings.IC2_ID))
			{
				// 2 Refined Iron -> 2 Steel
				TransmutationHelper.addRecipe(new ItemStack(steel.getItem(), 2, steel.getItemDamage()), 
					transmutationStone, new Object[]{ IC2Recipes.refinedIronIngot, IC2Recipes.refinedIronIngot });
				// 2 Steel -> 2 Refined Iron
				TransmutationHelper.addRecipe(
					new ItemStack(IC2Recipes.refinedIronIngot.getItem(), 2, 
					IC2Recipes.refinedIronIngot.getItemDamage()), transmutationStone, new Object[]{ 
					steel, steel});
			}
		}
		for(ItemStack coke : coalCoke)
		{
			// 4 Coal/CharCoal -> 1 Coal Coke
			TransmutationHelper.addRecipe(coke, transmutationStone,
				new Object[]{ (new ItemStack(Item.coal, 1, 1)), (new ItemStack(Item.coal, 1, 1)),
				(new ItemStack(Item.coal, 1, 1)), (new ItemStack(Item.coal, 1, 1)) });
			// 1 Coal Coke -> 4 Coal/CharCoal
			TransmutationHelper.addRecipe(new ItemStack(Item.coal, 4, 1), transmutationStone,
				new Object[]{ coke });
		}
	}
}
