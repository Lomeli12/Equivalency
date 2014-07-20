package net.lomeli.equivalency;

import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.lomeli.lomlib.util.LogHelper;
import net.lomeli.lomlib.util.ModLoaded;
import net.lomeli.lomlib.util.UpdateHelper;

import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.core.handler.CraftingHandler;
import net.lomeli.equivalency.lib.ModVars;
import net.lomeli.equivalency.recipes.*;

@Mod(modid = ModVars.MOD_ID, name = ModVars.MOD_NAME, version = ModVars.VERSION, dependencies = "required-after:LomLib;required-after:EE3")
public class Equivalency {
    public static TransmutationHelper instance;
    public static LogHelper logger = new LogHelper(ModVars.MOD_NAME);
    public static UpdateHelper updater = new UpdateHelper(ModVars.MOD_ID);
    private boolean checkUpdate;

    public static void loadModRecipes(String modName) {
        logger.logInfo("Loading " + modName + " recipes...");
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();

        ModVars.emeraldTransmute = config.getBoolean("defaultEmeraldTransmute", Configuration.CATEGORY_GENERAL, true, ModVars.emeraldDesc);
        ModVars.blazeTransmute = config.getBoolean("blazeTransmute", Configuration.CATEGORY_GENERAL, false, ModVars.blazeDesc);
        ModVars.cQTransmute = config.getBoolean("cqTransmute", Configuration.CATEGORY_GENERAL, true, ModVars.cQDesc);
        ModVars.steelTransmute = config.getBoolean("steelTransmute", Configuration.CATEGORY_GENERAL, true, "Disables steel transmutation");
        ModVars.quratzRecipe = config.getBoolean("enableAEQuratzRecipe", Configuration.CATEGORY_GENERAL, true, "Disable Applied Energistics Quartz recipes");
        ModVars.ic2Recipe = config.getBoolean("ic2Uranium", Configuration.CATEGORY_GENERAL, true, "Disable Uranium transmutations if they cause you to crash.");
        ModVars.glowStone = config.getBoolean("glowredstone", Configuration.CATEGORY_GENERAL, true, "Enables glowstone to redstone transmutation");
        checkUpdate = config.getBoolean("updateCheck", Configuration.CATEGORY_GENERAL, true, "Check for Updates");

        config.save();

        if (checkUpdate) {
            try {
                updater.check(ModVars.UPDATE_XML, ModVars.MAJOR, ModVars.MINOR, ModVars.REVISION);
            } catch (Exception e) {
            }
        }
    }

    @Mod.EventHandler
    public void main(FMLInitializationEvent event) {
        if (ModLoaded.isModInstalled(ModVars.EE3_ID, true)) {
            logger.logInfo("Getting transmutation stones");
            TransmutationHelper.addStones();
            FMLCommonHandler.instance().bus().register(new CraftingHandler());
        }
    }

    @Mod.EventHandler
    public void postLoad(FMLPostInitializationEvent event) {
        if (ModLoaded.isModInstalled(ModVars.EE3_ID)) {
            if (!TransmutationHelper.transmutationStones.isEmpty()) {
                logger.logInfo("Loading Vanilla Recipes.");
                VanillaRecipes.loadRecipes();

                logger.logInfo("Searching for additional mods and loading additional recipes.");
                if (ModLoaded.isModInstalled(ModVars.IC2_ID))
                    IC2Recipes.loadRecipes(ModVars.IC2_ID);

                //if (ModLoaded.isModInstalled(ModVars.TF_ID))
                //    TFRecipes.loadRecipes(ModVars.TF_ID);

                //if (ModLoaded.isModInstalled(ModVars.FORESTRY_ID))
                //    ForestryRecipes.loadRecipes(ModVars.FORESTRY_ID);

                //if (ModLoaded.isModInstalled(ModVars.DART_ID))
                //    DartCraftRecipes.loadRecipes(ModVars.DART_ID);

                //if (ModLoaded.isModInstalled(ModVars.TC_ID))
                //    ThaumCraftRecipes.loadRecipes(ModVars.TC_ID);

                //if (ModLoaded.isModInstalled(ModVars.RC_ID))
                //    RailCraftRecipes.loadRecipes(ModVars.RC_ID);

                if (ModLoaded.isModInstalled(ModVars.AE_ID))
                    AppliedEnergisticsRecipes.loadRecipes(ModVars.AE_ID);

                if (ModLoaded.isModInstalled(ModVars.TINKER_ID))
                    TConstructRecipes.loadRecipes(ModVars.TINKER_ID);

                //if (ModLoaded.isModInstalled(ModVars.ARS_ID))
                //    ArsMagicaRecipes.loadRecipes(ModVars.ARS_ID);

                //if (ModLoaded.isModInstalled(ModVars.PRED_ID))
                //    ProjectRedRecipes.loadRecipes(ModVars.PRED_ID);

                UniversalRecipes.loadRecipes();

                //VanillaRecipes.smelting();
            }
        }
    }
}
