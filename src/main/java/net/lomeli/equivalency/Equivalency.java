package net.lomeli.equivalency;

import java.util.logging.Level;

import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.core.CommonProxy;
import net.lomeli.equivalency.lib.ModVars;
import net.lomeli.equivalency.recipes.AppliedEnergisticsRecipes;
import net.lomeli.equivalency.recipes.ArsMagicaRecipes;
import net.lomeli.equivalency.recipes.ForestryRecipes;
import net.lomeli.equivalency.recipes.IC2Recipes;
import net.lomeli.equivalency.recipes.DartCraftRecipes;
import net.lomeli.equivalency.recipes.ProjectRedRecipes;
import net.lomeli.equivalency.recipes.RailCraftRecipes;
import net.lomeli.equivalency.recipes.TConstructRecipes;
import net.lomeli.equivalency.recipes.TERecipes;
import net.lomeli.equivalency.recipes.ThaumCraftRecipes;
import net.lomeli.equivalency.recipes.UniversalRecipes;
import net.lomeli.equivalency.recipes.VanillaRecipes;

import net.lomeli.lomlib.util.LogHelper;
import net.lomeli.lomlib.util.ModLoaded;
import net.lomeli.lomlib.util.UpdateHelper;
import net.lomeli.lomlib.util.XMLConfiguration;
import net.lomeli.lomlib.util.XMLConfiguration.ConfigEnum;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModVars.MOD_ID, name = ModVars.MOD_NAME, version = ModVars.VERSION, dependencies = "required-after:LomLibCore;required-after:EE3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Equivalency {
    public static TransmutationHelper instance;
    public int numberInstalled;
    private boolean checkUpdate;

    public static LogHelper logger = new LogHelper(ModVars.MOD_NAME);
    public static UpdateHelper updater = new UpdateHelper();

    @SidedProxy(clientSide = ModVars.CLIENT, serverSide = ModVars.COMMON)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        XMLConfiguration config = new XMLConfiguration(event.getSuggestedConfigurationFile());

        config.loadXml();

        ModVars.emeraldTransmute = config.getBoolean("defaultEmeraldTransmute", true, ModVars.emeraldDesc,
                ConfigEnum.GENERAL_CONFIG);
        ModVars.blazeTransmute = config.getBoolean("blazeTransmute", false, ModVars.blazeDesc, ConfigEnum.GENERAL_CONFIG);
        ModVars.cQTransmute = config.getBoolean("cqTransmute", true, ModVars.cQDesc, ConfigEnum.GENERAL_CONFIG);
        ModVars.steelTransmute = config.getBoolean("steelTransmute", true, "Disables steel transmutation",
                ConfigEnum.GENERAL_CONFIG);
        ModVars.quratzRecipe = config.getBoolean("enableAEQuratzRecipe", true, ConfigEnum.GENERAL_CONFIG);
        ModVars.ic2Recipe = config.getBoolean("ic2Uranium", true, "Disable Uranium transmutations if they cause you to crash.",
                ConfigEnum.GENERAL_CONFIG);
        ModVars.glowStone = config.getBoolean("glowredstone", true, "Enables glowstone to redstone transmutation",
                ConfigEnum.GENERAL_CONFIG);
        checkUpdate = config.getBoolean("updateCheck", true, "Check for Updates", ConfigEnum.GENERAL_CONFIG);

        config.saveXML();

        if (checkUpdate) {
            try {
                updater.check(ModVars.MOD_NAME, ModVars.UPDATE_XML, ModVars.MAJOR, ModVars.MINOR, ModVars.REVISION);
            }catch (Exception e) {
            }
        }

        proxy.registerTickHandler();
    }

    @Mod.EventHandler
    public void main(FMLInitializationEvent event) {
        if (ModLoaded.isModInstalled(ModVars.EE3_ID, true)) {
            numberInstalled = 0;
            ModVars.limitRecipes = false;
            logger.log(Level.INFO, "Getting transmutation stones");
            TransmutationHelper.addStones();
        }
    }

    @Mod.EventHandler
    public void postLoad(FMLPostInitializationEvent event) {
        if (ModLoaded.isModInstalled(ModVars.EE3_ID)) {
            if (!TransmutationHelper.transmutationStones.isEmpty()) {
                logger.log(Level.INFO, "Loading Vanilla Recipes.");
                VanillaRecipes.loadRecipes();

                logger.log(Level.INFO, "Searching for additional mods and loading additional recipes.");
                if (ModLoaded.isModInstalled(ModVars.IC2_ID))
                    numberInstalled++;
                if (ModLoaded.isModInstalled(ModVars.TE_ID))
                    numberInstalled++;
                if (ModLoaded.isModInstalled(ModVars.FORESTRY_ID))
                    numberInstalled++;
                if (ModLoaded.isModInstalled(ModVars.MM_ID))
                    numberInstalled++;
                if (ModLoaded.isModInstalled(ModVars.TINKER_ID))
                    numberInstalled++;

                if (numberInstalled > 1)
                    ModVars.limitRecipes = true;

                if (ModLoaded.isModInstalled(ModVars.IC2_ID))
                    IC2Recipes.loadRecipes(ModVars.IC2_ID);

                if (ModLoaded.isModInstalled(ModVars.TE_ID))
                    TERecipes.loadRecipes(ModVars.TE_ID);

                if (ModLoaded.isModInstalled(ModVars.FORESTRY_ID))
                    ForestryRecipes.loadRecipes(ModVars.FORESTRY_ID);

                if (ModLoaded.isModInstalled(ModVars.DART_ID))
                    DartCraftRecipes.loadRecipes(ModVars.DART_ID);

                if (ModLoaded.isModInstalled(ModVars.TC_ID))
                    ThaumCraftRecipes.loadRecipes(ModVars.TC_ID);

                if (ModLoaded.isModInstalled(ModVars.RC_ID))
                    RailCraftRecipes.loadRecipes(ModVars.RC_ID);

                if (ModLoaded.isModInstalled(ModVars.AE_ID))
                    AppliedEnergisticsRecipes.loadRecipes(ModVars.AE_ID);

                if (ModLoaded.isModInstalled(ModVars.TINKER_ID))
                    TConstructRecipes.loadRecipes(ModVars.TINKER_ID);

                if (ModLoaded.isModInstalled(ModVars.ARS_ID))
                    ArsMagicaRecipes.loadRecipes(ModVars.ARS_ID);

                if (ModLoaded.isModInstalled(ModVars.PRED_ID))
                    ProjectRedRecipes.loadRecipes(ModVars.PRED_ID);

                UniversalRecipes.loadRecipes();

                VanillaRecipes.smelting();
            }
        }
    }

    public static void loadModRecipes(String modName) {
        logger.log(Level.INFO, "Loading " + modName + " recipes...");
    }
}
