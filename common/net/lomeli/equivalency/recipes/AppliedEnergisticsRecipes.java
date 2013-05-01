package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.minecraft.item.ItemStack;
import appeng.api.Blocks;
import appeng.api.Materials;

public class AppliedEnergisticsRecipes 
{
	public static void loadRecipes(ItemStack transmutationStone)
	{
		TransmutationHelper.addRecipe(new ItemStack(Materials.matQuartzDust.getItem(), 4, 7), 
			transmutationStone, new Object[]{ Materials.matQuartz,  
			Materials.matQuartz, Materials.matQuartz, Materials.matQuartz});
		TransmutationHelper.addRecipe(new ItemStack(Materials.matQuartz.getItem(), 4, 6), 
			transmutationStone, new Object[]{ Materials.matQuartzDust,  
			Materials.matQuartzDust, Materials.matQuartzDust, Materials.matQuartzDust});
		
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
