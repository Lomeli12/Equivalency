package net.lomeli.equivalency;

import java.util.logging.Level;

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

import net.lomeli.lomlib.util.LogHelper;
import net.lomeli.lomlib.util.ModLoaded;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid=Strings.MOD_ID, name=Strings.MOD_NAME, 
	version=Strings.VERSION, dependencies="required-after:LomLib@[1.0.2,);required-after:EE3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Equivalency 
{
	public static boolean limitRecipes;
	public int numberInstalled;
	
	public static LogHelper logger;
	
	public static boolean emeraldTransmute;
	public static boolean blazeTransmute;
	public static boolean cQTransmute;
	
	@SuppressWarnings("static-access")
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		logger = new LogHelper(Strings.MOD_NAME);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		emeraldTransmute = config.get(config.CATEGORY_GENERAL, "defaultEmeraldTransmute", true, Strings.emeraldDesc).getBoolean(true);
		blazeTransmute = config.get(config.CATEGORY_GENERAL, "blazeTransmute", false, Strings.blazeDesc).getBoolean(false);
		cQTransmute = config.get(config.CATEGORY_GENERAL, "cqTransmute", true, Strings.cQDesc).getBoolean(true);
		
		config.save();
    }
	
	@Mod.EventHandler
	public void main(FMLInitializationEvent event)
	{
		if(ModLoaded.isModInstalled(Strings.EE3_ID))
		{
			numberInstalled = 0;
			limitRecipes = false;
			TransmutationHelper.addStones();
			logger.log(Level.INFO, "Loading Vanilla Recipes.");
			for(ItemStack transmutationStone : TransmutationHelper.transmutationStones)
			{
				VanillaRecipes.loadRecipes(transmutationStone);
			}
		}
    }
	
	@Mod.EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
		if(ModLoaded.isModInstalled(Strings.EE3_ID))
		{
			logger.log(Level.INFO, "Searching for additional mods and loading additional recipes.");
			for(ItemStack transmutationStone : TransmutationHelper.transmutationStones)
			{
				if(ModLoaded.isModInstalled(Strings.IC2_ID, false))
					numberInstalled++;
				if(ModLoaded.isModInstalled(Strings.TE_ID, false))
					numberInstalled++;
				if(ModLoaded.isModInstalled(Strings.FORESTRY_ID, false))
					numberInstalled++;
				if(ModLoaded.isModInstalled(Strings.MM_ID, false))
					numberInstalled++;
				
				if(numberInstalled > 1)
					limitRecipes = true;
				
				
				if(ModLoaded.isModInstalled(Strings.IC2_ID, false))
					IC2Recipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.TE_ID, false))
					TERecipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.FORESTRY_ID, false))
					ForestryRecipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.MM_ID, "MechroMagiks", false))
					MagiksRecipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.TC_ID, false))
					ThaumCraftRecipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.RC_ID, false))
					RailCraftRecipes.loadRecipes(transmutationStone);
				
				if(ModLoaded.isModInstalled(Strings.AE_ID, false))
					AppliedEnergisticsRecipes.loadRecipes(transmutationStone);
				
				UniversalRecipes.loadRecipes(transmutationStone);
			}
		}
	}
	
}
