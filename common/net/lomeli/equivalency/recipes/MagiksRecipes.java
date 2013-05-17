package net.lomeli.equivalency.recipes;

//import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.helper.TransmutationHelper;
//import net.lomeli.equivalency.mods.AddonThermalExpansion;
//import net.lomeli.equivalency.mods.ic2.AddonIC2;

import net.lomeli.magiks.api.ItemAPI;

import net.minecraft.item.ItemStack;

//import net.minecraftforge.oredict.OreDictionary;

public class MagiksRecipes 
{
	//public static ItemStack copperIngot = ItemAPI.getItem("ingotCopper");
	//public static ItemStack tinIngot = ItemAPI.getItem("ingotTin");
	//public static ItemStack silverIngot = ItemAPI.getItem("ingotSilver");
	public static ItemStack stamaticIngot = ItemAPI.getItem("ingotStamatic");
	public static ItemStack igniousIngot = ItemAPI.getItem("ingotIgnious");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		TransmutationHelper.addRecipe(stamaticIngot.getItem(), transmutationStone,
			new Object[]{ igniousIngot.getItem(), igniousIngot.getItem(), 
			igniousIngot.getItem(), igniousIngot.getItem()});
		
		TransmutationHelper.addRecipe(new ItemStack(igniousIngot.getItem(), 4), transmutationStone,
			new Object[]{ stamaticIngot.getItem() });
		
		/*UniversalRecipes.ingotCopper.add(copperIngot);
		UniversalRecipes.ingotTin.add(tinIngot);
		UniversalRecipes.ingotSilver.add(silverIngot);
		
		OreDictionary.registerOre("ingotCopper", copperIngot);
		OreDictionary.registerOre("ingotTin", tinIngot);
		OreDictionary.registerOre("ingotSilver", silverIngot);*/
		
		/*if(!Equivalency.limitRecipes)
		{
			UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
		}
		
		if(AddonThermalExpansion.checkTE())
			UniversalRecipes.leadSilver(TERecipes.leadIngot, silverIngot, transmutationStone);
			
		if(AddonIC2.checkIC2())
			UniversalRecipes.bronzeTin(IC2Recipes.bronzeIngot, tinIngot, transmutationStone);*/
	}
}
