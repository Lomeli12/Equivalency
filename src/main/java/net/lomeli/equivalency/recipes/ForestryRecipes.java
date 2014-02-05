package net.lomeli.equivalency.recipes;

import net.lomeli.lomlib.item.ItemUtil;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.lib.ModVars;

import net.minecraft.item.ItemStack;

public class ForestryRecipes {
    private static final String itemClass = "forestry.core.config.ForestryItem";
    public static ItemStack copperIngot = ItemUtil.getItem("ingotCopper", itemClass);
    public static ItemStack tinIngot = ItemUtil.getItem("ingotTin", itemClass);
    public static ItemStack bronzeIngot = ItemUtil.getItem("ingotBronze", itemClass);

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);
        if (!ModVars.limitRecipes) {
            UniversalRecipes.copperTin(copperIngot, tinIngot);
            UniversalRecipes.bronzeTin(bronzeIngot, tinIngot);
        }
    }
}
