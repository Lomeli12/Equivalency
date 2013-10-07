package net.lomeli.equivalency.helper;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;

import net.lomeli.lomlib.item.ItemUtil;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

public class TransmutationHelper {
    public static final String ITEM_LOC = "com.pahimar.ee3.item.ModItems";
    public static final int WILDCARD = Short.MAX_VALUE;

    public static List<ItemStack> transmutationStones = new ArrayList<ItemStack>();

    public static void addStones() {
        transmutationStones.add(new ItemStack(ItemUtil.getItem("miniumStone", ITEM_LOC).getItem(), 1, WILDCARD));
        transmutationStones.add(new ItemStack(ItemUtil.getItem("philStone", ITEM_LOC).getItem(), 1, WILDCARD));
    }

    public static void addRecipe(ItemStack output, ItemStack transmutationStone, Object... input) {
        Object[] inputs = new Object[input.length + 1];
        System.arraycopy(input, 0, inputs, 0, input.length);
        inputs[input.length] = new ItemStack(transmutationStone.getItem(), 1, WILDCARD);

        GameRegistry.addShapelessRecipe(output, inputs);
    }

    public static void addRecipe(IRecipe recipe) {
        GameRegistry.addRecipe(recipe);
    }

    public static void addRecipe(Item output, ItemStack transmutationStone, Object... input) {
        addRecipe(new ItemStack(output), transmutationStone, input);
    }

    public static void addRecipe(Block output, ItemStack transmutationStone, Object... input) {
        addRecipe(new ItemStack(output), transmutationStone, input);
    }

    // Copied from EE3 for easier recipe registering.
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

        if(result.stackSize * 7 <= result.getItem().getItemStackLimit())
            GameRegistry.addShapelessRecipe(new ItemStack(result.getItem(), result.stackSize * 7, result.getItemDamage()), list);
        else
            GameRegistry.addShapelessRecipe(
                    new ItemStack(result.getItem(), result.getItem().getItemStackLimit(), result.getItemDamage()), list);
    }

}
