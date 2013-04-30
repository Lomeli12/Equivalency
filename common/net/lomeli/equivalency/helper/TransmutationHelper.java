package net.lomeli.equivalency.helper;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;

import net.lomeli.equivalency.ee3.EE3ItemAPI;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TransmutationHelper 
{
	public static final int WILDCARD = Short.MAX_VALUE;
	
	public static List<ItemStack>transmutationStones = new ArrayList<ItemStack>();
	
	public static void addStones()
	{
		transmutationStones.add(EE3ItemAPI.getItem("miniumStone"));
		transmutationStones.add(EE3ItemAPI.getItem("philStone"));
	}
	
    public static void addRecipe(ItemStack output, ItemStack transmutationStone, Object... input) 
    {
        Object[] inputs = new Object[input.length + 1];
        System.arraycopy(input, 0, inputs, 0, input.length);
        inputs[input.length] = new ItemStack(transmutationStone.getItem(), 1, WILDCARD);

        GameRegistry.addShapelessRecipe(output, inputs);
    }
    
    public static void addRecipe(Item output, ItemStack transmutationStone, Object... input)
    {
    	addRecipe(new ItemStack(output), transmutationStone, input);
    }
    
    public static void addRecipe(Block output, ItemStack transmutationStone, Object... input)
    {
    	addRecipe(new ItemStack(output), transmutationStone, input);
    }

}
