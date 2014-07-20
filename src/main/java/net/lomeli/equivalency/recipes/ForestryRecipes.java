package net.lomeli.equivalency.recipes;

import java.lang.reflect.Method;

import net.minecraft.item.ItemStack;

import net.lomeli.equivalency.Equivalency;

public class ForestryRecipes {
    public static ItemStack copperIngot = getForestryItem("ingotCopper");
    public static ItemStack tinIngot = getForestryItem("ingotTin");
    public static ItemStack bronzeIngot = getForestryItem("ingotBronze");

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);
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
            Equivalency.logger.logWarning("Could not retrieve Forestry item identified by: " + ident);
        }
        return item;
    }
}
