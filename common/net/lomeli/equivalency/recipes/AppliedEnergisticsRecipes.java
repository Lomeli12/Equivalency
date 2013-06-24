package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.helper.TransmutationHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import appeng.api.Blocks;
import appeng.api.Materials;

public class AppliedEnergisticsRecipes 
{
	public static void loadRecipes(ItemStack transmutationStone)
	{
		ItemStack iron;
		
		if(Equivalency.cQTransmute)
			iron = new ItemStack(Item.ingotIron);
		else
			iron = new ItemStack(Block.blockIron);
		
		// 1 Quartz Crystal -> 10 Quartz Dust
		TransmutationHelper.addRecipe(new ItemStack(Materials.matQuartzDust.getItem(), 10, 7), 
			transmutationStone, new Object[]{ Materials.matQuartz });
		
		// 5 Quartz Dust -> 1 Iron Ingot
		TransmutationHelper.addRecipe(new ItemStack(Item.ingotIron), 
			transmutationStone, new Object[]{ Materials.matQuartzDust, Materials.matQuartzDust,
			Materials.matQuartzDust, Materials.matQuartzDust, Materials.matQuartzDust});
		
		// 2 Iron -> 1 Quartz Crystal
		TransmutationHelper.addRecipe(new ItemStack(Materials.matQuartz.getItem(), 1, 6), transmutationStone,
			new Object[]{ iron, iron});
		
		// 1 Quartz Crystal -> 2 Iron
		TransmutationHelper.addRecipe(new ItemStack(iron.getItem(), 2), transmutationStone,
			new Object[]{ Materials.matQuartz });
		
		int k = Blocks.blkCable_Colored.length;
		
		for(int j = 0; j < k; j++)
		{
			if(j == (k-1))
				TransmutationHelper.addRecipe(Blocks.blkCable_Colored[0], transmutationStone,
					new Object[]{ Blocks.blkCable_Colored[j] });
			else
				TransmutationHelper.addRecipe(Blocks.blkCable_Colored[j + 1], transmutationStone,
					new Object[]{ Blocks.blkCable_Colored[j] });
		}
	}
}
