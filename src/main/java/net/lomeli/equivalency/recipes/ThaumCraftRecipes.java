package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import thaumcraft.api.ItemApi;

public class ThaumCraftRecipes {
    public static Item shard = ItemApi.getItem("itemShard", 1).getItem();
    public static ItemStack visShard = ItemApi.getItem("itemShard", 4);
    public static ItemStack dullShard = ItemApi.getItem("itemShard", 5);
    public static ItemStack candle = ItemApi.getBlock("blockCandle", 0);

    public static void loadRecipes(ItemStack transmutationStone, String modName) {
        Equivalency.loadModRecipes(modName);
        for(int i = 0; i < 4; i++) {
            if(i == 3)
                TransmutationHelper.addRecipe(new ItemStack(shard, 1, 0), transmutationStone, new Object[] { new ItemStack(shard,
                        1, i) });
            else
                TransmutationHelper.addRecipe(new ItemStack(shard, 1, (i + 1)), transmutationStone, new Object[] { new ItemStack(
                        shard, 1, i) });
        }

        for(int i = 0; i < 16; i++) {
            if(i == 15) {
                TransmutationHelper.addRecipe(candle, transmutationStone, new Object[] { new ItemStack(candle.getItem(), 1, i) });
            }else {
                TransmutationHelper.addRecipe(new ItemStack(candle.getItem(), 1, (i + 1)), transmutationStone,
                        new Object[] { new ItemStack(candle.getItem(), 1, i) });
            }
        }

        // 3 Dull Shards -> 1 Vis Shard
        TransmutationHelper.addRecipe(visShard, transmutationStone, new Object[] { dullShard, dullShard, dullShard });
        // 1 Vis Shard -> Dull Shard
        TransmutationHelper.addRecipe(new ItemStack(dullShard.getItem(), 3, 5), transmutationStone, new Object[] { visShard });
    }
}
