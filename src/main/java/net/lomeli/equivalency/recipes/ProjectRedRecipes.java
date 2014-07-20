package net.lomeli.equivalency.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.FMLLog;

import net.lomeli.lomlib.util.ItemUtil;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;

public class ProjectRedRecipes {

    private static ItemStack prItem;

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);

        try {
            prItem = getItem("itemPart", "mrtjp.projectred.ProjectRedCore");
            if (prItem == null)
                prItem = ItemUtil.getItem("itemPart", "mrtjp.projectred.ProjectRedCore");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (prItem != null) {
            OreDictionary.registerOre("gemRuby", new ItemStack(prItem.getItem(), 1, 37));
            OreDictionary.registerOre("gemSapphire", new ItemStack(prItem.getItem(), 1, 38));
            OreDictionary.registerOre("gemPeridot", new ItemStack(prItem.getItem(), 1, 39));

            TransmutationHelper.addRecipe(new ItemStack(prItem.getItem(), 1, 37), Blocks.quartz_block);

            TransmutationHelper.addRecipe(Blocks.quartz_block, "gemPeridot");
            TransmutationHelper.addRecipe(Blocks.quartz_block, "gemSapphire");
            TransmutationHelper.addRecipe(Blocks.quartz_block, "gemRuby");

            TransmutationHelper.addRecipe(new ItemStack(prItem.getItem(), 1, 37), "gemPeridot");
            TransmutationHelper.addRecipe(new ItemStack(prItem.getItem(), 1, 38), "gemRuby");
            TransmutationHelper.addRecipe(new ItemStack(prItem.getItem(), 1, 39), "gemSapphire");
        }
    }

    @SuppressWarnings("all")
    private static ItemStack getItem(String itemString, String itemClassLoc) {
        ItemStack item = null;

        try {
            String itemClass = itemClassLoc;
            Object obj = Class.forName(itemClass).getMethod(itemString).invoke(null, null);
            if (obj instanceof Item)
                item = new ItemStack((Item) obj);
            else if (obj instanceof Block)
                item = new ItemStack((Block) obj);
            else if (obj instanceof ItemStack)
                item = (ItemStack) obj;

        } catch (Exception ex) {
            FMLLog.warning("Could not retrieve item identified by: " + itemString);
        }
        return item;
    }
}
