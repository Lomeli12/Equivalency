package net.lomeli.equivalency.api;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

/**
 * Allows people to add their own transmutations. Most people should use the apiRecipe method.
 * @author Lomeli12
 *
 */
public class TransmutationHelper {
    public static final String ITEM_LOC = "com.pahimar.ee3.item.ModItems";
    public static final int WILDCARD = Short.MAX_VALUE;

    public static List<ItemStack> transmutationStones = new ArrayList<ItemStack>();
    
    /**
     * Registers the Minium and Philosopher's Stone to Equivalency, DO NOT use for addon recipes. 
     */
    public static void addStones() {
        transmutationStones.add(new ItemStack(getItem("miniumStone", ITEM_LOC).getItem(), 1, WILDCARD));
        transmutationStones.add(new ItemStack(getItem("philStone", ITEM_LOC).getItem(), 1, WILDCARD));
    }
    /**
     * Allows one to add their own recipes. Should be use on the FMLPostInitializationEvent.
     * @param output
     * @param input
     */
    public static void apiRecipe(ItemStack output, Object... input){
        if(transmutationStones.isEmpty())
            addStones();
        
        for(ItemStack stone : transmutationStones){
            addRecipe(output, stone, input);
        }
    }

    /**
     * Used by Equvalency to add recipes. If adding custom recipe, use apiRecipe method instead.
     * @param output
     * @param transmutationStone
     * @param input
     */
    public static void addRecipe(ItemStack output, ItemStack transmutationStone, Object... input) {
        Object[] inputs = new Object[input.length + 1];
        System.arraycopy(input, 0, inputs, 0, input.length);
        inputs[input.length] = new ItemStack(transmutationStone.getItem(), 1, WILDCARD);

        GameRegistry.addShapelessRecipe(output, inputs);
    }

    /**
     * Used by Equvalency to add recipes. Only use this if you need to do OreDictionary recipes.
     * @param recipe
     */
    public static void addRecipe(IRecipe recipe) {
        GameRegistry.addRecipe(recipe);
    }

    /**
     * Used by Equvalency to add recipes. If adding custom recipe, use apiRecipe method instead.
     * @param output
     * @param transmutationStone
     * @param input
     */
    public static void addRecipe(Item output, ItemStack transmutationStone, Object... input) {
        addRecipe(new ItemStack(output), transmutationStone, input);
    }

    /**
     * Used by Equvalency to add recipes. If adding custom recipe, use apiRecipe method instead.
     * @param output
     * @param transmutationStone
     * @param input
     */
    public static void addRecipe(Block output, ItemStack transmutationStone, Object... input) {
        addRecipe(new ItemStack(output), transmutationStone, input);
    }

    /** 
     * Copied and updated from EE3 for easier recipe registering.
     * @param input
     * @param stone
     * @param fuel
     */
    public static void addSmeltingRecipe(ItemStack input, ItemStack stone, ItemStack fuel) {
        ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(input);

        if(input == null || input.getItem() == null || result == null)
            return;

        Object[] list = new Object[9];
        list[0] = stone;
        list[1] = fuel;

        for(int i = 2; i < 9; i++) {
            list[i] = new ItemStack(input.getItem(), 1, input.getItemDamage());
        }

        if(result.stackSize * 7 <= result.getItem().maxStackSize)
            GameRegistry.addShapelessRecipe(new ItemStack(result.getItem(), result.stackSize * 7, result.getItemDamage()), list);
        else
            GameRegistry.addShapelessRecipe(
                    new ItemStack(result.getItem(), result.getItem().maxStackSize, result.getItemDamage()), list);
    }
    
    private static ItemStack getItem(String itemString, String itemClassLoc) {
        ItemStack item = null;

        try {
            String itemClass = itemClassLoc;
            Object obj = Class.forName(itemClass).getField(itemString)
                    .get(null);
            if(obj instanceof Item)
                item = new ItemStack((Item) obj);
            else if(obj instanceof ItemStack)
                item = (ItemStack) obj;

        }catch(Exception ex) {
            FMLLog.warning("Could not retrieve item identified by: "
                    + itemString);
        }
        return item;
    }

}
