package net.lomeli.equivalency.recipes;

import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

import net.lomeli.lomlib.util.ItemUtil;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;

public class TFRecipes {
    public static String ThermalItemClass = "thermalfoundation.item.TFItems";
    public static ItemStack copperIngot = ItemUtil.getItem("ingotCopper", ThermalItemClass);
    public static ItemStack tinIngot = ItemUtil.getItem("ingotTin", ThermalItemClass);
    public static ItemStack silverIngot = ItemUtil.getItem("ingotSilver", ThermalItemClass);
    public static ItemStack leadIngot = ItemUtil.getItem("ingotLead", ThermalItemClass);
    public static ItemStack electrumIngot = ItemUtil.getItem("ingotElectrum", ThermalItemClass);
    public static ItemStack invarIngot = ItemUtil.getItem("ingotInvar", ThermalItemClass);
    public static ItemStack ingotNickel = ItemUtil.getItem("ingotNickel", ThermalItemClass);

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
