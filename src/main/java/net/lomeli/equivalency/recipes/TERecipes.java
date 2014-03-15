package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.lib.ModVars;

import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

import thermalexpansion.item.TEItems;

public class TERecipes {
    public static String ThermalItemClass = "thermalexpansion.item.TEItems";
    public static ItemStack copperIngot = TEItems.ingotCopper;
    public static ItemStack tinIngot = TEItems.ingotTin;
    public static ItemStack silverIngot = TEItems.ingotSilver;
    public static ItemStack leadIngot = TEItems.ingotLead;
    public static ItemStack electrumIngot = TEItems.ingotElectrum;
    public static ItemStack invarIngot = TEItems.ingotInvar;
    public static ItemStack ingotNickel = TEItems.ingotNickel;

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);
        OreDictionary.registerOre("ingotLead", leadIngot);

        // 3 Lead = 1 Electrum
        TransmutationHelper.addRecipe(electrumIngot, "ingotLead", "ingotLead", "ingotLead");
        // 1 Electrum = 3 Lead
        TransmutationHelper.addRecipe(new ItemStack(leadIngot.getItem(), 3, leadIngot.getItemDamage()), "ingotElectrum");

        TransmutationHelper.addRecipe(new ItemStack(invarIngot.getItem(), 3, invarIngot.getItemDamage()), "ingotNickel", "ingotNickel");

        TransmutationHelper.addRecipe(new ItemStack(ingotNickel.getItem(), 2, ingotNickel.getItemDamage()), "ingotInvar", "ingotInvar", "ingotInvar");

        TransmutationHelper.addRecipe(ingotNickel, "ingotLead", "ingotLead");

        TransmutationHelper.addRecipe(new ItemStack(leadIngot.getItem(), 2, leadIngot.getItemDamage()), "ingotNickel");
    }
}
