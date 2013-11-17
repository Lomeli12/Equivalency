package net.lomeli.equivalency.recipes;

import forestry.api.core.ItemInterface;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.lib.ModVars;

import net.minecraft.item.ItemStack;

public class ForestryRecipes {
    public static ItemStack copperIngot = ItemInterface.getItem("ingotCopper");
    public static ItemStack tinIngot = ItemInterface.getItem("ingotTin");
    public static ItemStack bronzeIngot = ItemInterface.getItem("ingotBronze");

    public static void loadRecipes(ItemStack transmutationStone, String modName) {
        Equivalency.loadModRecipes(modName);
        if(!ModVars.limitRecipes) {
            UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
            UniversalRecipes.bronzeTin(bronzeIngot, tinIngot, transmutationStone);
        }
    }
}
