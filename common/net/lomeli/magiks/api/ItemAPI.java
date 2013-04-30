package net.lomeli.magiks.api;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;

/**
 * Used to gain access to items in the mod. Thanks to Azanor and his Thaumcraft
 * API, of which this API is based off of.
 * 
 * This gets the items by the name I gave the block class. For example, Neonite
 * Gem is:
 * 
 * public static item neoniteGem;
 * 
 * so, when using this api, I would do:
 * 
 * ItemAPI.getItem("neoniteGem", 1);
 * 
 * You can check the item names in com.lomeli.magiks.items.ModItemsMagiks in the
 * mod's source: https://github.com/Lomeli12/MechroMagiks
 * 
 * @author Anthony
 * 
 */
public class ItemAPI
{
    public static ItemStack getItem(String itemString, int meta)
    {
        ItemStack item = null;

        try
        {
            String itemClass = "net.lomeli.magiks.items.ModItemsMagiks";
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
            FMLLog.warning("[MechroMagik] Could not retrieve item identified by: "
                    + itemString);
        }
        return item;
    }

    public static ItemStack getItem(String itemString)
    {
        ItemStack item = null;

        try
        {
            String itemClass = "net.lomeli.magiks.items.ModItemsMagiks";
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
            FMLLog.warning("[MechroMagik] Could not retrieve item identified by: "
                    + itemString);
        }
        return item;
    }
}
