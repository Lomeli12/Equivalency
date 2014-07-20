package net.lomeli.equivalency.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;

//import am2.items.ItemsCommonProxy;

public class ArsMagicaRecipes {
    private static ItemStack sunStone = OreDictionary.getOres("gemSunstone").get(0);
    private static ItemStack moonStone = OreDictionary.getOres("gemMoonstone").get(0);

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);

        for (int i = 0; i < 9; i++) {
            //if (i == 8)
            //    TransmutationHelper.addRecipe(ItemsCommonProxy.rune, new ItemStack(ItemsCommonProxy.rune, 1, i));
            //else
            //    TransmutationHelper.addRecipe(new ItemStack(ItemsCommonProxy.rune, 1, i + 1), new ItemStack(ItemsCommonProxy.rune, 1, i));
        }

        TransmutationHelper.addRecipe(sunStone, Items.diamond, Items.diamond, Items.diamond);
        TransmutationHelper.addRecipe(moonStone, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl);
    }
}
