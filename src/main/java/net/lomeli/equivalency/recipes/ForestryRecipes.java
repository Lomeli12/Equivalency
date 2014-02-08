package net.lomeli.equivalency.recipes;

import java.lang.reflect.Method;
import java.util.logging.Level;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.lib.ModVars;

import net.minecraft.item.ItemStack;

public class ForestryRecipes {
    public static ItemStack copperIngot = getForestryItem("ingotCopper");
    public static ItemStack tinIngot = getForestryItem("ingotTin");
    public static ItemStack bronzeIngot = getForestryItem("ingotBronze");

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);
        if (!ModVars.limitRecipes) {
            UniversalRecipes.copperTin(copperIngot, tinIngot);
            UniversalRecipes.bronzeTin(bronzeIngot, tinIngot);
        }
    }

    private static ItemStack getForestryItem(String ident) {
        ItemStack item = null;
        try {
            String itemClass = "forestry.core.config.ForestryItem";
            Object[] enums = Class.forName(itemClass).getEnumConstants();
            for (Object e : enums)
                if (e.toString().equals(ident)) {
                    Method m = e.getClass().getMethod("getItemStack", new Class[0]);
                    return (ItemStack) m.invoke(e, new Object[0]);
                }
        } catch (Exception e) {
            Equivalency.logger.log(Level.WARNING, "Could not retrieve Forestry item identified by: " + ident);
        }
        return item;
    }
}
