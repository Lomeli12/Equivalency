package net.lomeli.equivalency.recipes;

import java.util.ArrayList;
import java.util.List;

import net.lomeli.equivalency.helper.TransmutationHelper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class UniversalRecipes {
	public static List<ItemStack> uranium = new ArrayList<ItemStack>();

	public static void loadRecipes(ItemStack transmutationStone){
		if(!uranium.isEmpty() && OreDictionary.getOres("uranium").isEmpty()){
			for(ItemStack uraniumDrop : uranium){
				OreDictionary.registerOre("uranium", uraniumDrop.getItem());
			}
		}
		
		if(!OreDictionary.getOres("ingotLead").isEmpty() && !OreDictionary.getOres("ingotSilver").isEmpty()){
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(
				new ItemStack(OreDictionary.getOres("ingotSilver").get(0).getItem(), 2, 
				OreDictionary.getOres("ingotSilver").get(0).getItemDamage()), 
				transmutationStone, "ingotLead", "ingotLead", "ingotLead", "ingotLead"));
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(
				new ItemStack(OreDictionary.getOres("ingotLead").get(0).getItem(), 4, 
				OreDictionary.getOres("ingotLead").get(0).getItemDamage()), 
				transmutationStone, "ingotSilver", "ingotSilver"));
		}
		
		if(!OreDictionary.getOres("ingotCopper").isEmpty() && !OreDictionary.getOres("ingotTin").isEmpty()){
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(OreDictionary.getOres("ingotTin").get(0), 
				transmutationStone, "ingotCopper", "ingotCopper", "ingotCopper"));
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
				OreDictionary.getOres("ingotCopper").get(0).getItem(), 3, 
				OreDictionary.getOres("ingotCopper").get(0).getItemDamage()), 
				transmutationStone, "ingotTin"));
		}
		
		if(!OreDictionary.getOres("ingotBronze").isEmpty() && !OreDictionary.getOres("ingotTin").isEmpty()){
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
				OreDictionary.getOres("ingotBronze").get(0).getItem(), 4, 
				OreDictionary.getOres("ingotBronze").get(0).getItemDamage()),
				transmutationStone, "ingotTin", "ingotTin"));
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(
				new ItemStack(OreDictionary.getOres("ingotTin").get(0).getItem(), 2,
				OreDictionary.getOres("ingotTin").get(0).getItemDamage()),
				transmutationStone, "ingotBronze", "ingotBronze", "ingotBronze", "ingotBronze"));
		}
		
		if(!OreDictionary.getOres("ingotBronze").isEmpty() && !OreDictionary.getOres("uranium").isEmpty()){
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(OreDictionary.getOres("uranium").get(0),
				transmutationStone, "ingotBronze", "ingotBronze", "ingotBronze", "ingotBronze",
				"ingotBronze", "ingotBronze", "ingotBronze"));
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(
				new ItemStack(OreDictionary.getOres("ingotBronze").get(0).getItem(), 7,
				OreDictionary.getOres("ingotBronze").get(0).getItemDamage()), transmutationStone, "uranium"));
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(Item.diamond, 2),
				transmutationStone, "uranium", "uranium", "uranium", "uranium"));
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(
				new ItemStack(OreDictionary.getOres("uranium").get(0).getItem(), 4, 
				OreDictionary.getOres("uranium").get(0).getItemDamage()),
				transmutationStone, Item.diamond, Item.diamond));
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(OreDictionary.getOres("uranium").get(0), 
				transmutationStone, Item.ingotGold, Item.ingotGold));
			TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(Item.ingotGold, 4),
				transmutationStone, "uranium", "uranium"));
		}
	}
	
	public static void copperTin(ItemStack copper, ItemStack tin, ItemStack transmutationStone){
		// 3 Copper Ingot -> Tin Ingot
		TransmutationHelper.addRecipe(tin, transmutationStone, 
				 copper, copper, copper);
		// 1 Tin Ingot -> 3 Copper Ingot
		TransmutationHelper.addRecipe(new ItemStack(copper.getItem(), 3), transmutationStone, 
					new Object[]{ tin });
	}
	
	public static void bronzeTin(ItemStack bronze, ItemStack tin, ItemStack transmutationStone){
		// 1 Bronze -> 2 Tin
		TransmutationHelper.addRecipe(new ItemStack(tin.getItem(), 2), transmutationStone,
			new Object[]{ bronze });
		// 2 Tin -> 1 Bronze
		TransmutationHelper.addRecipe(new ItemStack(bronze.getItem(), 4), transmutationStone,
			new Object[]{ tin, tin});
	}
	
	public static void uraniumDiamond(ItemStack uranium, ItemStack transmutationStone){
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
	
	public static void leadSilver(ItemStack leadIngot, ItemStack silverIngot, ItemStack transmutationStone){
		// 2 Silver Ingot -> 4 Lead Ingot
		TransmutationHelper.addRecipe(new ItemStack(leadIngot.getItem(), 4, leadIngot.getItemDamage()), 
			transmutationStone, new Object[]{ silverIngot, silverIngot });
		// 4 Lead -> 2 Silver Ingot
		TransmutationHelper.addRecipe(new ItemStack(silverIngot.getItem(), 2, silverIngot.getItemDamage()), 
			transmutationStone, new Object[]{ leadIngot, leadIngot, leadIngot, leadIngot });
		
	}
}
