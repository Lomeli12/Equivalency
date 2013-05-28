package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.helper.TransmutationHelper;
import net.minecraft.item.ItemStack;

import thermalexpansion.api.item.ItemRegistry;

public class TERecipes 
{
	public static ItemStack copperIngot = ItemRegistry.getItem("ingotCopper", 1);
	public static ItemStack tinIngot = ItemRegistry.getItem("ingotTin", 1);
	public static ItemStack silverIngot = ItemRegistry.getItem("ingotSilver", 1);
	public static ItemStack leadIngot = ItemRegistry.getItem("ingotLead", 1);
	public static ItemStack electrumIngot = ItemRegistry.getItem("ingotElectrum", 1);
	public static ItemStack invarIngot = ItemRegistry.getItem("ingotInvar", 1);
	
	public static void loadRecipes(ItemStack transmutationStone)
	{	
		// 3 Lead = 1 Electrum
		TransmutationHelper.addRecipe(electrumIngot, transmutationStone,
			new Object[]{ leadIngot, leadIngot, leadIngot});
		// 1 Electrum = 3 Lead
		TransmutationHelper.addRecipe(new ItemStack(leadIngot.getItem(), 3, 67), transmutationStone,
				new Object[]{ electrumIngot});
		
		if(!Equivalency.limitRecipes)
		{
			UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
			UniversalRecipes.leadSilver(leadIngot, silverIngot, transmutationStone);
		}
	}
}
