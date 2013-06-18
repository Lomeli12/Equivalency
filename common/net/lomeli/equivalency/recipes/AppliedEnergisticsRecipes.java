package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import appeng.api.Blocks;
import appeng.api.Materials;

public class AppliedEnergisticsRecipes 
{
	public static void loadRecipes(ItemStack transmutationStone)
	{
		// 4 Quartz Crystal -> 4 Quartz Dust
		TransmutationHelper.addRecipe(new ItemStack(Materials.matQuartzDust.getItem(), 4, 7), 
			transmutationStone, new Object[]{ Materials.matQuartz,  
			Materials.matQuartz, Materials.matQuartz, Materials.matQuartz});
		// 4 Quartz Dust -> 4 Quartz Crystal
		TransmutationHelper.addRecipe(new ItemStack(Materials.matQuartz.getItem(), 4, 6), 
			transmutationStone, new Object[]{ Materials.matQuartzDust,  
			Materials.matQuartzDust, Materials.matQuartzDust, Materials.matQuartzDust});
		
		// 2 Iron Ingot -> 1 Quartz Crystal
		TransmutationHelper.addRecipe(new ItemStack(Materials.matQuartz.getItem(), 1, 6), transmutationStone,
			new Object[]{ Item.ingotIron, Item.ingotIron});
		// 1 Quartz Crystal -> 2 Iron Ingot
		TransmutationHelper.addRecipe(new ItemStack(Item.ingotIron, 2), transmutationStone,
			new Object[]{ Materials.matQuartz });
		
		int k = Blocks.blkCable_Colored.length;
		
		for(int j = 0; j < k; j++)
		{
			if(j == (k-1))
			{
				TransmutationHelper.addRecipe(Blocks.blkCable_Colored[0], transmutationStone,
						new Object[]{ Blocks.blkCable_Colored[j] });
			}
			else
			{
				TransmutationHelper.addRecipe(Blocks.blkCable_Colored[j + 1], transmutationStone,
						new Object[]{ Blocks.blkCable_Colored[j] });
			}
		}
	}
}
