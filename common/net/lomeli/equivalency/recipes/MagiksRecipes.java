package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.Equivalency;
//import net.lomeli.equivalency.helper.TransmutationHelper;
//import net.lomeli.equivalency.lib.Strings;

import net.lomeli.magiks.api.ItemAPI;

import net.minecraft.item.ItemStack;
//import net.minecraftforge.oredict.ShapelessOreRecipe;

public class MagiksRecipes 
{
	public static ItemStack copperIngot = ItemAPI.getItem("ingotCopper");
	public static ItemStack tinIngot = ItemAPI.getItem("ingotTin");
	public static ItemStack silverIngot = ItemAPI.getItem("ingotSilver");
	public static ItemStack stamaticIngot = ItemAPI.getItem("ingotStamatic");
	public static ItemStack igniousIngot = ItemAPI.getItem("ingotIgnious");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		/*TransmutationHelper.addRecipe(new ShapelessOreRecipe(stamaticIngot, transmutationStone,
			igniousIngot, igniousIngot, igniousIngot, igniousIngot));
		
		TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(igniousIngot.getItem(), 4),
			transmutationStone, stamaticIngot));*/
		
		UniversalRecipes.ingotCopper.add(copperIngot);
		UniversalRecipes.ingotTin.add(tinIngot);
		UniversalRecipes.ingotSilver.add(silverIngot);

		if(!Equivalency.limitRecipes)
		{
			UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
		}
		
		//if(ModLoaded.isModInstalled(Strings.TE_ID))
		//	UniversalRecipes.leadSilver(TERecipes.leadIngot, silverIngot, transmutationStone);
	}
}
