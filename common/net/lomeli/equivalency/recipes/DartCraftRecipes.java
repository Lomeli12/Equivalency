package net.lomeli.equivalency.recipes;

import cpw.mods.fml.common.FMLLog;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.helper.TransmutationHelper;
import net.lomeli.lomlib.block.BlockUtil;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class DartCraftRecipes {
	private static String dartItems  = "bluedart.item.DartItem";
	private static String dartBlocks = "bluedart.block.DartBlock";
	
	public static ItemStack forceGem = getDartCraftItems("gemForce");
	public static ItemStack forceStick = getDartCraftItems("forceStick");
	public static ItemStack ingotForce = getDartCraftItems("ingotForce");
	public static ItemStack claw = getDartCraftItems("claw");
	
	public static ItemStack forceLog = BlockUtil.getBlockFromMod("forceLog", dartBlocks);
	
	public static void loadRecipes(ItemStack transmutationStone, String modName){
		Equivalency.loadModRecipes(modName);
		//1 Force Gem <=> 4 Redstone
		TransmutationHelper.addRecipe(forceGem, transmutationStone, new Object[]{ Item.redstone, 
			Item.redstone, Item.redstone, Item.redstone});
		TransmutationHelper.addRecipe(Item.redstone, transmutationStone, new Object[]{forceGem});
		
		//2 Force Logs -> 8 Force Sticks
		TransmutationHelper.addRecipe(new ItemStack(forceStick.getItem(), 8, forceStick.getItemDamage()), 
			transmutationStone, new Object[]{ forceLog, forceLog });
		
		//4 Force Gem <=> 6 Force Ingot
		TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(ingotForce.getItem(), 6, 
			ingotForce.getItemDamage()), transmutationStone, forceGem, forceGem, forceGem, forceGem));
		TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(forceGem.getItem(), 4, 
			forceGem.getItemDamage()), transmutationStone, "ingotForce","ingotForce","ingotForce",
			"ingotForce", "ingotForce", "ingotForce"));
		
		//4 Claw <=> 2 Flint
		TransmutationHelper.addRecipe(new ItemStack(Item.flint, 2), transmutationStone, 
			new Object[]{ claw, claw, claw, claw });
		TransmutationHelper.addRecipe(new ItemStack(claw.getItem(), 4), transmutationStone, 
			new Object[]{ Item.flint, Item.flint });
	}
	
	@SuppressWarnings("rawtypes")
	public static ItemStack getDartCraftItems(String itemName){
		ItemStack item = null;
		try{
			Class dartItemClass = Class.forName(dartItems).getClass();
			Object obj = Class.forName(dartItems).getField(itemName).get(null);
			if(dartItemClass.isInstance(obj)){
				item = new ItemStack((Item)obj, 1);
			}else if(obj instanceof Item){
				item = new ItemStack((Item)obj, 1);
			}else if(obj instanceof ItemStack){
				item = (ItemStack)obj;
			}
		}catch(Exception e){
			FMLLog.warning("Could not retrieve item identified by: " + itemName);
		}
		return item;
	}
}
