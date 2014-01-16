package net.lomeli.equivalency.recipes;

//import net.lomeli.lomlib.item.ItemUtil;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.lib.ModVars;

import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import thermalexpansion.item.TEItems;

public class TERecipes {
    public static String ThermalItemClass = "thermalexpansion.item.TEItems";
    public static ItemStack copperIngot = TEItems.ingotCopper;//ItemUtil.getItem("ingotCopper", ThermalItemClass);
    public static ItemStack tinIngot = TEItems.ingotTin;//ItemUtil.getItem("ingotTin", ThermalItemClass);
    public static ItemStack silverIngot = TEItems.ingotSilver;//ItemUtil.getItem("ingotSilver", ThermalItemClass);
    public static ItemStack leadIngot = TEItems.ingotLead;//ItemUtil.getItem("ingotLead", ThermalItemClass);
    public static ItemStack electrumIngot = TEItems.ingotElectrum;//ItemUtil.getItem("ingotElectrum", ThermalItemClass);
    public static ItemStack invarIngot = TEItems.ingotInvar;//ItemUtil.getItem("ingotInvar", ThermalItemClass);
    public static ItemStack ingotNickel = TEItems.ingotNickel;//ItemUtil.getItem("ingotNickel", ThermalItemClass);

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);
        OreDictionary.registerOre("ingotLead", leadIngot);

        // 3 Lead = 1 Electrum
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(electrumIngot, "ingotLead", "ingotLead", "ingotLead"));
        // 1 Electrum = 3 Lead
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(leadIngot.getItem(), 3, leadIngot.getItemDamage()), "ingotElectrum"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(invarIngot.getItem(), 3, invarIngot.getItemDamage()), "ingotNickel", "ingotNickel"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(ingotNickel.getItem(), 2, ingotNickel.getItemDamage()), "ingotInvar", "ingotInvar",
                "ingotInvar"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(ingotNickel, "ingotLead", "ingotLead"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(leadIngot.getItem(), 2, leadIngot.getItemDamage()), "ingotNickel"));

        if (!ModVars.limitRecipes) {
            UniversalRecipes.copperTin(copperIngot, tinIngot);
            UniversalRecipes.leadSilver(leadIngot, silverIngot);
        }
    }
}
