package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;

public class ThaumCraftRecipes 
{
	public static ItemStack windShard = ItemApi.getItem("itemShard", 0);
	public static ItemStack fireShard = ItemApi.getItem("itemShard", 1);
	public static ItemStack waterShard = ItemApi.getItem("itemShard", 2);
	public static ItemStack earthShard = ItemApi.getItem("itemShard", 3);
	public static ItemStack visShard = ItemApi.getItem("itemShard", 4);
	public static ItemStack dullShard = ItemApi.getItem("itemShard", 5);
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		// Wind Shard -> Fire Shard -> Water Shard -> Earth Shard -> repeat
		TransmutationHelper.addRecipe(fireShard, transmutationStone, 
			new Object[]{ windShard });
		TransmutationHelper.addRecipe(waterShard, transmutationStone, 
			new Object[]{ fireShard });
		TransmutationHelper.addRecipe(earthShard, transmutationStone, 
			new Object[]{ waterShard });
		TransmutationHelper.addRecipe(windShard, transmutationStone, 
			new Object[]{ earthShard });
		
		// 3 Dull Shards -> 1 Vis Shard
		TransmutationHelper.addRecipe(visShard, transmutationStone,
			new Object[]{ dullShard, dullShard, dullShard });
		// 1 Vis Shard -> Dull Shard
		TransmutationHelper.addRecipe(new ItemStack(dullShard.getItem(), 3, 5), transmutationStone,
			new Object[]{ visShard });
	}
}
