package net.lomeli.equivalency.recipes;

import java.util.List;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.lib.ModVars;

import net.lomeli.lomlib.util.ModLoaded;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

public class RailCraftRecipes {

    public static List<ItemStack> steelIngot = OreDictionary.getOres("ingotSteel");
    public static List<ItemStack> coalCoke = OreDictionary.getOres("fuelCoke");

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);
        for (ItemStack steel : steelIngot) {
            if (ModLoaded.isModInstalled(ModVars.IC2_ID) && ModVars.steelTransmute) {
                TransmutationHelper.addRecipe(new ItemStack(steel.getItem(), 2, steel.getItemDamage()), new Object[] { IC2Recipes.machineBlock, IC2Recipes.machineBlock,
                        IC2Recipes.machineBlock });

                TransmutationHelper.addRecipe(new ItemStack(IC2Recipes.machineBlock.getItem(), 3, IC2Recipes.machineBlock.getItemDamage()), new Object[] { steel, steel });
            }
        }
        for (ItemStack coke : coalCoke) {
            // 4 Coal/CharCoal -> 1 Coal Coke
            TransmutationHelper.addRecipe(coke, new Object[] { (new ItemStack(Item.coal, 1, 1)), (new ItemStack(Item.coal, 1, 1)), (new ItemStack(Item.coal, 1, 1)),
                    (new ItemStack(Item.coal, 1, 1)) });
            // 1 Coal Coke -> 4 Coal/CharCoal
            TransmutationHelper.addRecipe(new ItemStack(Item.coal, 4, 1), new Object[] { coke });
        }
    }
}
