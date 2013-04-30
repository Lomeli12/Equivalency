package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VanillaRecipes 
{
	public static final int WILDCARD = Short.MAX_VALUE;
	
	public static void loadRecipes(ItemStack stone)
	{
		TransmutationHelper.addRecipe((new ItemStack(Block.glass, 3)), stone,
			new Object[]{Block.thinGlass, Block.thinGlass, Block.thinGlass,
			Block.thinGlass, Block.thinGlass, Block.thinGlass, Block.thinGlass,
			Block.thinGlass});
		
		// 1 Coal -> 2 Redstone
		TransmutationHelper.addRecipe(Item.coal, stone,
			new Object[]{Item.redstone, Item.redstone});
		// 2 Redstone -> 1 Coal
		TransmutationHelper.addRecipe(new ItemStack(Item.redstone, 2), stone,
			new Object[]{(new ItemStack(Item.coal, 1, WILDCARD))});
		
		// 7 Coal -> 1 Lapis
		TransmutationHelper.addRecipe((new ItemStack(Item.dyePowder, 1, 4)), stone,
			new Object[] { (new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)), 
			(new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)), 
			(new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)),
			(new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD))});
		// 1 Lapis -> 7 Coal
		TransmutationHelper.addRecipe(new ItemStack(Item.coal, 8), stone, 
			new Object[]{(new ItemStack(Item.dyePowder, 1, 4))});
		
		// 8 Gold Ingot -> 1 Emerald
		TransmutationHelper.addRecipe(Item.emerald, stone, new Object[]
			{ Item.ingotGold, Item.ingotGold, Item.ingotGold, Item.ingotGold,
			Item.ingotGold, Item.ingotGold, Item.ingotGold, Item.ingotGold });
		// 1 Emerald -> 8 Gold Ingot
		TransmutationHelper.addRecipe(new ItemStack(Item.ingotGold, 8), 
			stone, new Object[]{Item.emerald});
			
		// 5 Blaze rods -> 1 Diamond
		TransmutationHelper.addRecipe(Item.diamond, stone, new Object[]{
			Item.blazeRod, Item.blazeRod, Item.blazeRod, Item.blazeRod, Item.blazeRod});
	}
}
