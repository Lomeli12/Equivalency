package net.lomeli.equivalency.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.lomeli.equivalency.mods.AddonThermalExpansion;
import net.lomeli.equivalency.mods.ic2.AddonIC2;
import net.lomeli.magiks.api.ItemAPI;

public class MagiksRecipes 
{
	public static ItemStack copperIngot = ItemAPI.getItem("ingotCopper");
	public static ItemStack tinIngot = ItemAPI.getItem("ingotTin");
	public static ItemStack silverIngot = ItemAPI.getItem("ingotSilver");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		UniversalRecipes.ingotCopper.add(copperIngot);
		UniversalRecipes.ingotTin.add(tinIngot);
		UniversalRecipes.ingotSilver.add(silverIngot);
		
		OreDictionary.registerOre("ingotCopper", copperIngot);
		OreDictionary.registerOre("ingotTin", tinIngot);
		OreDictionary.registerOre("ingotSilver", silverIngot);
		
		UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
		
		if(AddonThermalExpansion.checkTE())
			UniversalRecipes.leadSilver(TERecipes.leadIngot, silverIngot, transmutationStone);
			
		if(AddonIC2.checkIC2())
			UniversalRecipes.bronzeTin(IC2Recipes.bronzeIngot, tinIngot, transmutationStone);
	}
}
