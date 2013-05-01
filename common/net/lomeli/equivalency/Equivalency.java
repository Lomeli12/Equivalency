package net.lomeli.equivalency;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.lomeli.equivalency.lib.Strings;
import net.lomeli.equivalency.mods.AddonForestry;
import net.lomeli.equivalency.mods.AddonMechroMagiks;
import net.lomeli.equivalency.mods.AddonRailCraft;
import net.lomeli.equivalency.mods.AddonThaumCraft;
import net.lomeli.equivalency.mods.AddonThermalExpansion;
import net.lomeli.equivalency.mods.ee3.AddonEE3;
import net.lomeli.equivalency.mods.ic2.AddonIC2;
import net.lomeli.equivalency.recipes.ForestryRecipes;
import net.lomeli.equivalency.recipes.IC2Recipes;
import net.lomeli.equivalency.recipes.MagiksRecipes;
import net.lomeli.equivalency.recipes.RailCraftRecipes;
import net.lomeli.equivalency.recipes.TERecipes;
import net.lomeli.equivalency.recipes.ThaumCraftRecipes;
import net.lomeli.equivalency.recipes.UniversalRecipes;
import net.lomeli.equivalency.recipes.VanillaRecipes;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid=Strings.MOD_ID, name=Strings.MOD_NAME, version=Strings.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Equivalency 
{
	@Init
	public void main(FMLInitializationEvent event)
	{
		if(AddonEE3.checkEE3())
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
		if(AddonEE3.checkEE3())
		{
			TransmutationHelper.addStones();
			for(ItemStack transmutationStone : TransmutationHelper.transmutationStones)
			{
				if(AddonIC2.checkIC2())
					IC2Recipes.loadRecipes(transmutationStone);
				
				if(AddonThermalExpansion.checkTE())
					TERecipes.loadRecipes(transmutationStone);
				
				if(AddonForestry.checkForestry())
					ForestryRecipes.loadRecipes(transmutationStone);
				
				if(AddonMechroMagiks.checkMM())
					MagiksRecipes.loadRecipes(transmutationStone);
				
				if(AddonThaumCraft.checkThaumCraft())
					ThaumCraftRecipes.loadRecipes(transmutationStone);
				
				if(AddonRailCraft.checkRailcraft())
					RailCraftRecipes.loadRecipes(transmutationStone);
				
				if(AddonIC2.checkIC2() || AddonThermalExpansion.checkTE() 
						|| AddonForestry.checkForestry() || AddonMechroMagiks.checkMM())
					UniversalRecipes.loadRecipes(transmutationStone);
			}
		}
	}
}
