package net.lomeli.equivalency.recipes;

import cpw.mods.fml.common.registry.GameRegistry;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.helper.TransmutationHelper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class DartCraftRecipes {

    public static ItemStack forceGem = OreDictionary.getOres("gemForce").get(0);// getDartCraftItems("gemForce");
    public static ItemStack forceStick = GameRegistry.findItemStack(
            "DartCraft", "item.stickForce", 1);
    public static ItemStack ingotForce = OreDictionary.getOres("ingotForce")
            .get(0);
    public static ItemStack claw = OreDictionary.getOres("itemClaw").get(0);

    public static ItemStack forceLog = GameRegistry.findItemStack("DartCraft",
            "block.logForce", 1);

    public static void loadRecipes(ItemStack transmutationStone, String modName) {
        Equivalency.loadModRecipes(modName);
        // 1 Force Gem <=> 4 Redstone
        TransmutationHelper.addRecipe(forceGem, transmutationStone,
                new Object[] { Item.redstone, Item.redstone, Item.redstone,
                        Item.redstone });
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
                Item.redstone, 4), transmutationStone, "gemForce"));

        // 2 Force Logs <=> 8 Force Sticks
        TransmutationHelper.addRecipe(new ItemStack(forceStick.getItem(), 8),
                transmutationStone, new Object[] { forceLog, forceLog });
        TransmutationHelper.addRecipe(new ItemStack(forceLog.getItem(), 2,
                forceLog.getItemDamage()), transmutationStone, new Object[] {
                forceStick, forceStick, forceStick, forceStick, forceStick,
                forceStick, forceStick, forceStick });

        // 4 Force Gem <=> 6 Force Ingot
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
                ingotForce.getItem(), 6, ingotForce.getItemDamage()),
                transmutationStone, "gemForce", "gemForce", "gemForce",
                "gemForce"));
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
                forceGem.getItem(), 4, forceGem.getItemDamage()),
                transmutationStone, "ingotForce", "ingotForce", "ingotForce",
                "ingotForce", "ingotForce", "ingotForce"));

        // 4 Claw <=> 2 Flint
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
                Item.flint, 2), transmutationStone, "itemClaw", "itemClaw",
                "itemClaw", "itemClaw"));
        TransmutationHelper.addRecipe(new ItemStack(claw.getItem(), 4),
                transmutationStone, new Object[] { Item.flint, Item.flint });
    }
}
