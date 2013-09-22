package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.helper.TransmutationHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import thermalexpansion.api.item.ItemRegistry;

public class TERecipes {
    public static ItemStack copperIngot = ItemRegistry
            .getItem("ingotCopper", 1);
    public static ItemStack tinIngot = ItemRegistry.getItem("ingotTin", 1);
    public static ItemStack silverIngot = ItemRegistry
            .getItem("ingotSilver", 1);
    public static ItemStack leadIngot = ItemRegistry.getItem("ingotLead", 1);
    public static ItemStack electrumIngot = ItemRegistry.getItem(
            "ingotElectrum", 1);
    public static ItemStack invarIngot = ItemRegistry.getItem("ingotInvar", 1);
    public static ItemStack ingotNickel = ItemRegistry
            .getItem("ingotNickel", 1);

    public static void loadRecipes(ItemStack transmutationStone, String modName) {
        Equivalency.loadModRecipes(modName);
        OreDictionary.registerOre("ingotLead", leadIngot);

        // 3 Lead = 1 Electrum
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(electrumIngot,
                transmutationStone, "ingotLead", "ingotLead", "ingotLead"));
        // 1 Electrum = 3 Lead
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
                leadIngot.getItem(), 3, leadIngot.getItemDamage()),
                transmutationStone, "ingotElectrum"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
                invarIngot.getItem(), 3, invarIngot.getItemDamage()),
                transmutationStone, "ingotNickel", "ingotNickel"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
                ingotNickel.getItem(), 2, ingotNickel.getItemDamage()),
                transmutationStone, "ingotInvar", "ingotInvar", "ingotInvar"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(ingotNickel,
                transmutationStone, "ingotLead", "ingotLead"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
                leadIngot.getItem(), 2, leadIngot.getItemDamage()),
                transmutationStone, "ingotNickel"));

        if (!Equivalency.limitRecipes) {
            UniversalRecipes.copperTin(copperIngot, tinIngot,
                    transmutationStone);
            UniversalRecipes.leadSilver(leadIngot, silverIngot,
                    transmutationStone);
        }
    }
}
