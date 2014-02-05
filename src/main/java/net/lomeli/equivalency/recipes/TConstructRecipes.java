package net.lomeli.equivalency.recipes;

import tconstruct.library.TConstructRegistry;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.lib.ModVars;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

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

        TransmutationHelper.addRecipe(alumite, new Object[] { Block.blockGold, Block.blockGold });
        TransmutationHelper.addRecipe(new ItemStack(Block.blockGold, 2), "ingotAlumite");

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

        if (!ModVars.limitRecipes) {
            UniversalRecipes.bronzeTin(bronze, tin);
            UniversalRecipes.copperTin(copper, tin);
            TransmutationHelper.addRecipe(OreDictionary.getOres("ingotAluminum").get(0), "ingotTin", "ingotTin", "ingotTin");
            TransmutationHelper.addRecipe(new ItemStack(OreDictionary.getOres("ingotTin").get(0).getItem(), 3, OreDictionary.getOres("ingotTin").get(0).getItemDamage()),
                    "ingotAluminum");
        }
    }
}
