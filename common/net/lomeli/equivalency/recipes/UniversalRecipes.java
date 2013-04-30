package net.lomeli.equivalency.recipes;

import java.util.ArrayList;
import java.util.List;

import net.lomeli.equivalency.helper.TransmutationHelper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UniversalRecipes 
{
	public static List<ItemStack> ingotCopper = new ArrayList<ItemStack>();
	public static List<ItemStack> ingotTin = new ArrayList<ItemStack>();
	public static List<ItemStack> ingotBronze = new ArrayList<ItemStack>();
	public static List<ItemStack> ingotSilver = new ArrayList<ItemStack>();
	public static List<ItemStack> ingotLead = new ArrayList<ItemStack>();
	public static List<ItemStack> uranium = new ArrayList<ItemStack>();

	public static void loadRecipes(ItemStack transmutationStone)
	{
		try
		{
			if(tinIngot() != null && copperIngot() != null)
			{
				// 3 Copper Ingot -> Tin Ingot
				TransmutationHelper.addRecipe(tinIngot(), transmutationStone, 
					new Object[]{ copperIngot(), copperIngot(), copperIngot() });
				// 1 Tin Ingot -> 3 Copper Ingot
				TransmutationHelper.addRecipe(new ItemStack(copperIngot().getItem(), 3), transmutationStone, 
					new Object[]{ tinIngot() });
				
				if(bronzeIngot() != null)
				{
					// 1 Bronze Ingot -> 2 Tin Ingot
					TransmutationHelper.addRecipe(new ItemStack(tinIngot().getItem(), 2), transmutationStone, 
						new Object[]{ bronzeIngot() });
					// 2 Tin Ingot -> 1 Bronze Ingot
					TransmutationHelper.addRecipe(bronzeIngot(), transmutationStone, 
						new Object[]{tinIngot(), tinIngot()});
					if(uraniumDrop() != null)
					{
						// 7 Bronze -> 1 Uranium
						TransmutationHelper.addRecipe(uraniumDrop(), transmutationStone, 
							new Object[]{bronzeIngot(), bronzeIngot(), bronzeIngot(), bronzeIngot(),
							bronzeIngot(), bronzeIngot(), bronzeIngot()});
						// 1 Uranium -> 7 Bronze
						TransmutationHelper.addRecipe(new ItemStack(bronzeIngot().getItem(), 7), 
						transmutationStone, new Object[]{ uraniumDrop() });
					}
				}
			}
						
			if(uraniumDrop() != null)
			{
				// 2 Uranium -> 1 Diamond
				TransmutationHelper.addRecipe(Item.diamond, transmutationStone, 
					new Object[]{uraniumDrop(), uraniumDrop()});
				// 2 Diamond -> 4 Uranium
				TransmutationHelper.addRecipe(new ItemStack(uraniumDrop().getItem(), 4), transmutationStone, 
						new Object[]{Item.diamond, Item.diamond});
			}
			if(silverIngot() != null && leadIngot() != null)
			{
				// 2 Silver Ingot -> 1 Lead Ingot
				TransmutationHelper.addRecipe(new ItemStack(silverIngot().getItem(), 2), 
					transmutationStone, new Object[]{ leadIngot() });
				// 1 Lead -> 2 Silver Ingot
				TransmutationHelper.addRecipe(leadIngot(), transmutationStone, 
					new Object[]{ silverIngot(), silverIngot() });
			}
		}
		catch(Exception e){}
	}
	
	public static ItemStack silverIngot()
	{
		for(ItemStack ingot: ingotSilver)
		{
			if(ingot != null)
			{
				return ingot;
			}
			else
				return null;
		}
		return null;
	}
	
	public static ItemStack tinIngot()
	{
		for(ItemStack ingot: ingotTin)
		{
			if(ingot != null)
			{
				return ingot;
			}
			else
				return null;
		}
		return null;
	}
	
	public static ItemStack copperIngot()
	{
		for(ItemStack ingot: ingotCopper)
		{
			if(ingot != null)
			{
				return ingot;
			}
			else
				return null;
		}
		return null;
	}
	
	public static ItemStack bronzeIngot()
	{
		for(ItemStack ingot: ingotBronze)
		{
			if(ingot != null)
			{
				return ingot;
			}
			else
				return null;
		}
		return null;
	}
	
	public static ItemStack leadIngot()
	{
		for(ItemStack ingot: ingotLead)
		{
			if(ingot != null)
			{
				return ingot;
			}
			else
				return null;
		}
		return null;
	}
	
	public static ItemStack uraniumDrop()
	{
		for(ItemStack ingot: uranium)
		{
			if(ingot != null)
			{
				return ingot;
			}
			else
				return null;
		}
		return null;
	}
}
