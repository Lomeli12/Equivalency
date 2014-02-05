package net.lomeli.equivalency.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

import am2.items.ItemsCommonProxy;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;

public class ArsMagicaRecipes {
    private static ItemStack sunStone = OreDictionary.getOres("gemSunstone").get(0);
    private static ItemStack moonStone = OreDictionary.getOres("gemMoonstone").get(0);

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);

        for (int i = 0; i < 9; i++) {
            if (i == 8)
                TransmutationHelper.addRecipe(ItemsCommonProxy.rune, new ItemStack(ItemsCommonProxy.rune, 1, i));
            else
                TransmutationHelper.addRecipe(new ItemStack(ItemsCommonProxy.rune, 1, i + 1), new ItemStack(ItemsCommonProxy.rune, 1, i));
        }

        TransmutationHelper.addRecipe(sunStone, Item.diamond, Item.diamond, Item.diamond);
        TransmutationHelper.addRecipe(moonStone, Item.enderPearl, Item.enderPearl, Item.enderPearl, Item.enderPearl);
    }
}
