package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.helper.TransmutationHelper;

import net.lomeli.magiks.api.ItemAPI;
import net.lomeli.magiks.api.BlockAPI;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagiksRecipes 
{
	public static ItemStack copperIngot = ItemAPI.getItem("ingotCopper");
	public static ItemStack tinIngot = ItemAPI.getItem("ingotTin");
	public static ItemStack silverIngot = ItemAPI.getItem("ingotSilver");
	public static ItemStack stamaticIngot = ItemAPI.getItem("ingotStamatic");
	public static ItemStack igniousIngot = ItemAPI.getItem("ingotIgnious");
	public static ItemStack neoniteGem = ItemAPI.getItem("neoniteGem");
	
	public static ItemStack neoniteBlock = BlockAPI.getBlock("neoniteBlock");
	public static ItemStack manceryBrick = BlockAPI.getBlock("manceryBrick");
	public static ItemStack manceryBlock = BlockAPI.getBlock("manceryBlock");
	public static ItemStack stamaticBlock = BlockAPI.getBlock("stamaticBlock");
	public static ItemStack igniousBlock = BlockAPI.getBlock("igniousBlock");
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		TransmutationHelper.addRecipe(igniousIngot, transmutationStone, new Object[]
			{ stamaticIngot, stamaticIngot, stamaticIngot, stamaticIngot });
		
		TransmutationHelper.addRecipe(new ItemStack(stamaticIngot.getItem(), 4),
			transmutationStone, new Object[]{ igniousIngot });
		
		TransmutationHelper.addRecipe(igniousBlock, transmutationStone, new Object[]
				{ stamaticBlock, stamaticBlock, stamaticBlock, stamaticBlock });
			
			TransmutationHelper.addRecipe(new ItemStack(stamaticBlock.getItem(), 4),
				transmutationStone, new Object[]{ igniousBlock });
		
		TransmutationHelper.addRecipe(manceryBlock, transmutationStone, new Object[]{manceryBrick});
		TransmutationHelper.addRecipe(manceryBrick, transmutationStone, new Object[]{manceryBlock});
		
		TransmutationHelper.addRecipe(neoniteGem, transmutationStone, new Object[]
			{ Item.emerald, Item.emerald });
		TransmutationHelper.addRecipe(new ItemStack(Item.emerald, 2), transmutationStone, new Object[]{neoniteGem});
		
		TransmutationHelper.addRecipe(neoniteBlock, transmutationStone, new Object[]
			{ Block.blockEmerald, Block.blockEmerald });
		TransmutationHelper.addRecipe(new ItemStack(Block.blockEmerald, 2), transmutationStone, new Object[]
			{ neoniteBlock });

		if(!Equivalency.limitRecipes)
		{
			UniversalRecipes.copperTin(copperIngot, tinIngot, transmutationStone);
		}
	}
}
