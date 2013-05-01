package net.lomeli.equivalency.mods.ic2;

import net.lomeli.equivalency.lib.Strings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;

public class IC2ItemAPI 
{
	public static final String ITEM_LOC = "ic2.core.Ic2Items";
    
    public static ItemStack getItem(String itemString, int meta)
    {
        ItemStack item = null;

        try
        {
            String itemClass = ITEM_LOC;
            Object obj = Class.forName(itemClass).getField(itemString)
                    .get(null);
            if (obj instanceof Item)
            {
                item = new ItemStack((Item) obj, 1, meta);
            } else if (obj instanceof ItemStack)
            {
                item = (ItemStack) obj;
            }
        } catch (Exception ex)
        {
            FMLLog.warning("[" + Strings.MOD_NAME + "] Could not retrieve item identified by: "
                    + itemString);
        }
        return item;
    }

    public static ItemStack getItem(String itemString)
    {
        ItemStack item = null;

        try
        {
            String itemClass = ITEM_LOC;
            Object obj = Class.forName(itemClass).getField(itemString)
                    .get(null);
            if (obj instanceof Item)
            {
                item = new ItemStack((Item) obj);
            } else if (obj instanceof ItemStack)
            {
                item = (ItemStack) obj;
            }
        } catch (Exception ex)
        {
            FMLLog.warning("[" + Strings.MOD_NAME + "] Could not retrieve item identified by: "
                    + itemString);
        }
        return item;
    }

}
