package net.lomeli.equivalency.recipes;

import tconstruct.library.TConstructRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;

public class TConstructRecipes {
    public static ItemStack aluminum = TConstructRegistry.getItemStack("ingotAluminum");
    public static ItemStack aluminumBrass = TConstructRegistry.getItemStack("ingotAluminumBrass");
    public static ItemStack cobalt = TConstructRegistry.getItemStack("ingotCobalt");
    public static ItemStack ardite = TConstructRegistry.getItemStack("ingotArdite");
    public static ItemStack manyullyn = TConstructRegistry.getItemStack("ingotManyullyn");
    public static ItemStack alumite = TConstructRegistry.getItemStack("ingotAlumite");
    public static ItemStack copper = TConstructRegistry.getItemStack("ingotCopper");
    public static ItemStack tin = TConstructRegistry.getItemStack("ingotTin");
    public static ItemStack bronze = TConstructRegistry.getItemStack("ingotBronze");

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);

        TransmutationHelper.addRecipe(alumite, new Object[]{Blocks.gold_block, Blocks.gold_block});
        TransmutationHelper.addRecipe(new ItemStack(Blocks.gold_block, 2), "ingotAlumite");

        TransmutationHelper.addRecipe(aluminumBrass, "ingotCopper", "ingotCopper", "ingotCopper", "ingotCopper", "ingotCopper");
        TransmutationHelper.addRecipe(new ItemStack(copper.getItem(), 5, copper.getItemDamage()), "ingotAluminumBrass");

        TransmutationHelper.addRecipe(cobalt, "ingotAlumite", "ingotAlumite", "ingotAlumite", "ingotAlumite");
        TransmutationHelper.addRecipe(new ItemStack(alumite.getItem(), 4, alumite.getItemDamage()), "ingotCobalt");

        TransmutationHelper.addRecipe(ardite, "ingotAlumite", "ingotAlumite");
        TransmutationHelper.addRecipe(new ItemStack(alumite.getItem(), 2, alumite.getItemDamage()), "ingotArdite");

        TransmutationHelper.addRecipe(new ItemStack(manyullyn.getItem(), 2, manyullyn.getItemDamage()), "ingotCobalt", "ingotCobalt", "ingotCobalt", "ingotCobalt");
        TransmutationHelper.addRecipe(new ItemStack(cobalt.getItem(), 2, cobalt.getItemDamage()), "ingotManyullyn");

        TransmutationHelper.addRecipe(new ItemStack(manyullyn.getItem(), 2, manyullyn.getItemDamage()), "ingotArdite", "ingotArdite", "ingotArdite", "ingotArdite", "ingotArdite",
                "ingotArdite", "ingotArdite", "ingotArdite");
        TransmutationHelper.addRecipe(new ItemStack(ardite.getItem(), 8, ardite.getItemDamage()), "ingotManyullyn", "ingotManyullyn");
    }
}
