package net.lomeli.equivalency.recipes;

import java.util.ArrayList;
import java.util.List;

import net.lomeli.equivalency.helper.TransmutationHelper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

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
			for(ItemStack copperIngot : OreDictionary.getOres("ingotCopper"))
			{
				ingotCopper.add(copperIngot);
			}
			for(ItemStack tinIngot : OreDictionary.getOres("ingotTin"))
			{
				ingotTin.add(tinIngot);
			}
			for(ItemStack bronzeIngot : OreDictionary.getOres("ingotBronze"))
			{
				ingotBronze.add(bronzeIngot);
			}
			for(ItemStack silverIngot : OreDictionary.getOres("ingotSilver"))
			{
				ingotSilver.add(silverIngot);
			}
			for(ItemStack leadIngot : OreDictionary.getOres("ingotLead"))
			{
				ingotLead.add(leadIngot);
			}
			
			if(!ingotCopper.isEmpty() && !ingotTin.isEmpty())
			{
				for(ItemStack copper : ingotCopper)
				{
					for(ItemStack tin : ingotTin)
					{
						copperTin(copper, tin, transmutationStone);
						if(!ingotBronze.isEmpty())
						{
							for(ItemStack bronze : ingotBronze)
							{
								bronzeTin(bronze, tin, transmutationStone);
								if(!uranium.isEmpty())
								{
									for(ItemStack uraniumDrop : uranium)
									{
										// 7 Bronze -> 1 Uranium
										TransmutationHelper.addRecipe(uraniumDrop, transmutationStone, 
											new Object[]{bronze, bronze, bronze, bronze,
											bronze, bronze, bronze});
										// 1 Uranium -> 7 Bronze
										TransmutationHelper.addRecipe(new ItemStack(bronze.getItem(), 7), 
											transmutationStone, new Object[]{ uraniumDrop });
										
									}
								}
							}
						}
					}
				}
			}
			if(!ingotLead.isEmpty() && !ingotSilver.isEmpty())
			{
				for(ItemStack lead : ingotLead)
				{
					
					for(ItemStack silver : ingotSilver)
					{
						leadSilver(lead, silver, transmutationStone);
					}
				}
			}
			if(!uranium.isEmpty())
			{
				for(ItemStack uraniumDrop : uranium)
				{
					uraniumDiamond(uraniumDrop, transmutationStone);
				}
			}
		}
		catch(Exception e){}
	}
	
	public static void copperTin(ItemStack copper, ItemStack tin, ItemStack transmutationStone)
	{
		// 3 Copper Ingot -> Tin Ingot
		TransmutationHelper.addRecipe(tin, transmutationStone, 
			new Object[]{ copper, copper, copper });
		// 1 Tin Ingot -> 3 Copper Ingot
		TransmutationHelper.addRecipe(new ItemStack(copper.getItem(), 3), transmutationStone, 
					new Object[]{ tin });
	}
	
	public static void bronzeTin(ItemStack bronze, ItemStack tin, ItemStack transmutationStone)
	{
		// 1 Bronze -> 2 Tin
		TransmutationHelper.addRecipe(new ItemStack(tin.getItem(), 2), transmutationStone,
			new Object[]{ bronze });
		// 2 Tin -> 1 Bronze
		TransmutationHelper.addRecipe(new ItemStack(bronze.getItem(), 1), transmutationStone,
			new Object[]{ tin, tin});
	}
	
	public static void uraniumDiamond(ItemStack uranium, ItemStack transmutationStone)
	{
		// 4 Uranium -> 2 Diamond
		TransmutationHelper.addRecipe(new ItemStack(Item.diamond, 2), transmutationStone, 
			new Object[]{uranium, uranium, uranium, uranium});
		// 2 Diamond -> 4 Uranium
		TransmutationHelper.addRecipe(new ItemStack(uranium.getItem(), 4), transmutationStone,
			new Object[]{ Item.diamond, Item.diamond });
		// 2 Gold -> 1 Uranium
		TransmutationHelper.addRecipe(uranium, transmutationStone, 
			new Object[]{ Item.ingotGold, Item.ingotGold });
		// 2 Uranium -> 4 Gold
		TransmutationHelper.addRecipe((new ItemStack(Item.ingotGold, 4)), transmutationStone,
			new Object[]{ uranium, uranium });
	}
	
	public static void leadSilver(ItemStack leadIngot, ItemStack silverIngot, ItemStack transmutationStone)
	{
		// 2 Silver Ingot -> 4 Lead Ingot
		TransmutationHelper.addRecipe(new ItemStack(leadIngot.getItem(), 4, 67), 
			transmutationStone, new Object[]{ silverIngot, silverIngot });
		// 4 Lead -> 2 Silver Ingot
		TransmutationHelper.addRecipe(new ItemStack(silverIngot.getItem(), 2, 66), 
			transmutationStone, new Object[]{ leadIngot, leadIngot, leadIngot, leadIngot });
		
	}
}
