package net.lomeli.equivalency.recipes;

import net.lomeli.lomlib.util.ModLoaded;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.lib.ModVars;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import appeng.api.Blocks;
import appeng.api.Materials;

public class AppliedEnergisticsRecipes {
    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);

        if (ModVars.quratzRecipe) {
            if (ModLoaded.isModInstalled("IC2")) {
                TransmutationHelper
                        .addRecipe(new ItemStack(Materials.matQuartzDust.getItem(), 4, 7), new Object[] { Materials.matQuartz, Materials.matQuartz });
            } else {
                TransmutationHelper
                        .addRecipe(new ItemStack(Materials.matQuartzDust.getItem(), 6, 7), new Object[] { Materials.matQuartz, Materials.matQuartz });
            }
        }

        // 5 Quartz Dust -> 1 Iron Ingot
        TransmutationHelper.addRecipe(new ItemStack(Item.ingotIron), new Object[] { Materials.matQuartzDust, Materials.matQuartzDust, Materials.matQuartzDust,
                Materials.matQuartzDust, Materials.matQuartzDust });

        // 5 Iron -> 1 Quartz Crystal
        TransmutationHelper.addRecipe(new ItemStack(Materials.matQuartz.getItem(), 1, 6), new Object[] { Item.ingotIron, Item.ingotIron, Item.ingotIron,
                Item.ingotIron, Item.ingotIron });

        // 1 Quartz Crystal -> 5 Iron
        TransmutationHelper.addRecipe(new ItemStack(Item.ingotIron, 5), new Object[] { Materials.matQuartz });

        int k = Blocks.blkCable_Colored.length;

        for (int j = 0; j < k; j++) {
            if (j == (k - 1))
                TransmutationHelper.addRecipe(Blocks.blkCable_Colored[0], new Object[] { Blocks.blkCable_Colored[j] });
            else
                TransmutationHelper.addRecipe(Blocks.blkCable_Colored[j + 1], new Object[] { Blocks.blkCable_Colored[j] });
        }
    }
}
