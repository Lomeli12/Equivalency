package net.lomeli.equivalency;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.lomeli.equivalency.lib.Strings;
import net.lomeli.equivalency.recipes.AppliedEnergisticsRecipes;
import net.lomeli.equivalency.recipes.ForestryRecipes;
import net.lomeli.equivalency.recipes.IC2Recipes;
import net.lomeli.equivalency.recipes.MagiksRecipes;
import net.lomeli.equivalency.recipes.RailCraftRecipes;
import net.lomeli.equivalency.recipes.TERecipes;
import net.lomeli.equivalency.recipes.ThaumCraftRecipes;
import net.lomeli.equivalency.recipes.UniversalRecipes;
import net.lomeli.equivalency.recipes.VanillaRecipes;

import net.lomeli.lomlib.util.ModLoaded;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid=Strings.MOD_ID, name=Strings.MOD_NAME, 
	version=Strings.VERSION, dependencies="required-after:LomLib@[1.0.1,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Equivalency 
{
	public static boolean limitRecipes = false;
	public static int numberInstalled = 0;
	
	@Init
	public void main(FMLInitializationEvent event)
	{
		if(ModLoaded.isModInstalled(Strings.EE3_ID))
		{
			TransmutationHelper.addStones();
			for(ItemStack transmutationStone : TransmutationHelper.transmutationStones)
			{
				VanillaRecipes.loadRecipes(transmutationStone);
			}
		}
    }
	
	@PostInit
    public void postLoad(FMLPostInitializationEvent event)
    {
		if(ModLoaded.isModInstalled(Strings.EE3_ID))
		{
			for(ItemStack transmutationStone : TransmutationHelper.transmutationStones)
			{
				ModLoaded.isModInstalled(Strings.IC2_ID);
				ModLoaded.isModInstalled(Strings.TE_ID);
				ModLoaded.isModInstalled(Strings.FORESTRY_ID);
				ModLoaded.isModInstalled(Strings.MM_ID);
				
				if(numberInstalled > 1)
					limitRecipes = true;
				
				if(ModLoaded.isModInstalled(Strings.IC2_ID))
					IC2Recipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.TE_ID))
					TERecipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.FORESTRY_ID))
					ForestryRecipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.MM_ID, "MechroMagiks"))
					MagiksRecipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.TC_ID))
					ThaumCraftRecipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.RC_ID))
					RailCraftRecipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.AE_ID))
					AppliedEnergisticsRecipes.loadRecipes(transmutationStone);
				
				if(limitRecipes)
					UniversalRecipes.loadRecipes(transmutationStone);
				
			}
		}
	}
}
