package net.lomeli.equivalency.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.lib.ModVars;

import ic2.api.item.IC2Items;

public class IC2Recipes {
    public static final String ITEM_LOC = "ic2.core.Ic2Items";
    public static ItemStack copperIngot = IC2Items.getItem("copperIngot");
    public static ItemStack tinIngot = IC2Items.getItem("tinIngot");
    public static ItemStack bronzeIngot = IC2Items.getItem("bronzeIngot");
    public static ItemStack uraniumDrop;
    public static ItemStack stickyResin = IC2Items.getItem("resin");
    public static ItemStack refinedIronIngot = IC2Items.getItem("refinedIronIngot");
    public static ItemStack machineBlock = IC2Items.getItem("machine");

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);

        if (ModVars.ic2Recipe) {
            try {
                uraniumDrop = IC2Items.getItem("Uran238");
            } catch (Exception e) {
                Equivalency.logger.logError("Could not get IC2 Uranium, disabling recipes!");
            }
        }
        // 3 Resin -> Leather
        TransmutationHelper.addRecipe(Items.leather, new Object[]{stickyResin, stickyResin});
        // Leather -> 3 Resin
        TransmutationHelper.addRecipe(new ItemStack(stickyResin.getItem(), 2), new Object[]{Items.leather});
    }
}
