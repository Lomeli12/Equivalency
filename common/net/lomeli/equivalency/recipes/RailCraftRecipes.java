package net.lomeli.equivalency.recipes;

import cpw.mods.fml.common.registry.GameRegistry;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.lomeli.equivalency.mods.ic2.AddonIC2;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RailCraftRecipes 
{
	public static final int WILDCARD = Short.MAX_VALUE;
	private static final String MODID = "Railcraft";
	
	public static Item steelIngot = GameRegistry.findItem(MODID, "ingot.Steel");
	public static Item coalCoke = GameRegistry.findItem(MODID, "fuel.Coke");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		// 3 Coal/CharCoal -> 2 Coal Coke
		TransmutationHelper.addRecipe(new ItemStack(coalCoke, 2), transmutationStone,
			new Object[]{ (new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)),
			(new ItemStack(Item.coal, 1, WILDCARD)) });
		// 2 Coal Coke -> 3 Coal/CharCoal
		TransmutationHelper.addRecipe(new ItemStack(Item.coal, 3), transmutationStone,
			new Object[]{ coalCoke, coalCoke, coalCoke});
		
		if(AddonIC2.checkIC2())
		{
			// 2 Refined -> 2 Steel
			TransmutationHelper.addRecipe(new ItemStack(steelIngot, 2), 
				transmutationStone, new Object[]{ IC2Recipes.refinedIronIngot, IC2Recipes.refinedIronIngot });
			// 2 Steel -> 2 Refined Iron
			TransmutationHelper.addRecipe(new ItemStack(IC2Recipes.refinedIronIngot.getItem(), 2), 
				transmutationStone, new Object[]{ steelIngot, steelIngot });
		}
	}
}
