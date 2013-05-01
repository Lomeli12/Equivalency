package net.lomeli.equivalency.recipes;

import java.util.List;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.lomeli.equivalency.mods.ic2.AddonIC2;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RailCraftRecipes 
{
	public static final int WILDCARD = Short.MAX_VALUE;
	
	public static List<ItemStack> steelIngot = OreDictionary.getOres("ingotSteel");
	public static List<ItemStack> coalCoke = OreDictionary.getOres("fuelCoke");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		for(ItemStack steel : steelIngot)
		{
			if(AddonIC2.checkIC2())
			{
				// 2 Refined Iron -> 2 Steel
				TransmutationHelper.addRecipe(new ItemStack(steel.getItem(), 2), 
					transmutationStone, new Object[]{ IC2Recipes.refinedIronIngot, IC2Recipes.refinedIronIngot });
				// 2 Steel -> 2 Refined Iron
				TransmutationHelper.addRecipe(new ItemStack(IC2Recipes.refinedIronIngot.getItem(), 2), 
					transmutationStone, new Object[]{ steel, steel });
			}
		}
		for(ItemStack coke : coalCoke)
		{
			// 2 Coal/CharCoal -> 1 Coal Coke
			TransmutationHelper.addRecipe(coke, transmutationStone,
				new Object[]{ (new ItemStack(Item.coal, 1, WILDCARD)),
				(new ItemStack(Item.coal, 1, WILDCARD)) });
			// 1 Coal Coke -> 2 Coal/CharCoal
			TransmutationHelper.addRecipe(new ItemStack(Item.coal, 2), transmutationStone,
				new Object[]{ coke });
		}
	}
}
