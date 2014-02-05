package net.lomeli.equivalency.recipes;

import net.lomeli.lomlib.item.ItemUtil;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;

public class ProjectRedRecipes {
    private static ItemStack prItem = ItemUtil.getItem("itemComponent", "mrtjp.projectred.ProjectRedCore");

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);

        TransmutationHelper.addRecipe(new ItemStack(prItem.getItem(), 1, 37), Block.blockNetherQuartz);

        TransmutationHelper.addRecipe(Block.blockNetherQuartz, "gemPeridot");
        TransmutationHelper.addRecipe(Block.blockNetherQuartz, "gemRuby");
        TransmutationHelper.addRecipe(Block.blockNetherQuartz, "gemSapphire");

        TransmutationHelper.addRecipe(new ItemStack(prItem.getItem(), 1, 37), "gemPeridot");
        TransmutationHelper.addRecipe(new ItemStack(prItem.getItem(), 1, 38), "gemRuby");
        TransmutationHelper.addRecipe(new ItemStack(prItem.getItem(), 1, 39), "gemSapphire");
    }
}
