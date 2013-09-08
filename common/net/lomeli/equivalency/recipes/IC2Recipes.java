package net.lomeli.equivalency.recipes;

import java.util.logging.Level;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.helper.TransmutationHelper;

import ic2.api.item.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IC2Recipes {
	public static final String ITEM_LOC = "ic2.core.Ic2Items";
	public static ItemStack copperIngot = Items.getItem("copperIngot");
	public static ItemStack tinIngot = Items.getItem("tinIngot");
	public static ItemStack bronzeIngot  = Items.getItem("bronzeIngot");
	public static ItemStack uraniumDrop;
	public static ItemStack stickyResin = Items.getItem("resin");
	public static ItemStack refinedIronIngot = Items.getItem("refinedIronIngot");
	public static ItemStack machineBlock = Items.getItem("machine");
	
	public static void loadRecipes(ItemStack transmutationStone, String modName){
		Equivalency.loadModRecipes(modName);
		boolean canGetUranium = false;
		
		try{
			uraniumDrop = Items.getItem("Uran238");
			canGetUranium = true;
		}catch(Exception e){
			Equivalency.logger.log(Level.SEVERE, "Could not get IC2 Uranium, disabling recipes!");
			canGetUranium = false;
		}
		
		// 3 Resin -> Leather
		TransmutationHelper.addRecipe(Item.leather, transmutationStone, new Object[]
			{ stickyResin, stickyResin, stickyResin });
		// Leather -> 3 Resin
		TransmutationHelper.addRecipe(new ItemStack(stickyResin.getItem(), 3), transmutationStone, new Object[]
			{ Item.leather });
            
        if(canGetUranium)
        	UniversalRecipes.uraniumDiamond(uraniumDrop, transmutationStone);
		
		if(!Equivalency.limitRecipes){
			UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
			UniversalRecipes.bronzeTin(bronzeIngot, tinIngot, transmutationStone);
			
			if(canGetUranium)
				UniversalRecipes.uraniumDiamond(uraniumDrop, transmutationStone);
		}
	}
}
