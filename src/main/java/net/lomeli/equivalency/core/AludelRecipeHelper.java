package net.lomeli.equivalency.core;

import net.lomeli.equivalency.api.TransmutationHelper;

import net.minecraft.item.ItemStack;

import com.pahimar.ee3.recipe.RecipesAludel;

public class AludelRecipeHelper {
    private static ItemStack alchemicalDusts = TransmutationHelper.getItem("alchemicalDust", TransmutationHelper.ITEM_LOC);
    private static ItemStack inertStone = TransmutationHelper.getItem("inertStone", TransmutationHelper.ITEM_LOC);
    private static ItemStack miniumStone = TransmutationHelper.getItem("miniumStone", TransmutationHelper.ITEM_LOC);

    public static void loadMiniumRecipe() {
        RecipesAludel.getInstance().addRecipe(new ItemStack(miniumStone.getItem(), 1, 0), inertStone, new ItemStack(alchemicalDusts.getItem(), 9, 3));
    }
}
