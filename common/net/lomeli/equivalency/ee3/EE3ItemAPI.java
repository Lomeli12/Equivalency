package net.lomeli.equivalency.ee3;

import net.lomeli.equivalency.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;

public class EE3ItemAPI 
{
	public static final String BLOCKS_LOC = "com.pahimar.ee3.block.ModBlocks";
	public static final String ITEM_LOC = "com.pahimar.ee3.item.ModItems";
	
	
	public static ItemStack getBlock(String itemString, int meta)
    {
        ItemStack item = null;

        try
        {
            String itemClass = BLOCKS_LOC;
            Object obj = Class.forName(itemClass).getField(itemString)
                    .get(null);
            if (obj instanceof Block)
            {
                item = new ItemStack((Block) obj, 1, meta);
            } else if (obj instanceof ItemStack)
            {
                item = (ItemStack) obj;
            }
        } catch (Exception ex)
        {
            FMLLog.warning("[" + Strings.MOD_NAME + "] Could not retrieve block identified by: "
                    + itemString);
        }
        return item;
    }

    public static ItemStack getBlock(String itemString)
    {
        ItemStack item = null;

        try
        {
            String itemClass = BLOCKS_LOC;
            Object obj = Class.forName(itemClass).getField(itemString)
                    .get(null);
            if (obj instanceof Block)
            {
                item = new ItemStack((Block) obj);
            } else if (obj instanceof ItemStack)
            {
                item = (ItemStack) obj;
            }
        } catch (Exception ex)
        {
            FMLLog.warning("[" + Strings.MOD_NAME + "] Could not retrieve block identified by: "
                    + itemString);
        }
        return item;
    }
    
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
