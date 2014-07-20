package net.lomeli.equivalency.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.registry.GameRegistry;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;

public class DartCraftRecipes {

    public static ItemStack forceGem = OreDictionary.getOres("gemForce").get(0);
    public static ItemStack forceStick = GameRegistry.findItemStack("DartCraft", "item.stickForce", 1);
    public static ItemStack ingotForce = OreDictionary.getOres("ingotForce").get(0);
    public static ItemStack claw = OreDictionary.getOres("itemClaw").get(0);

    public static ItemStack forceLog = GameRegistry.findItemStack("DartCraft", "block.logForce", 1);

    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);

        // 1 Force Gem <=> 4 Redstone
        TransmutationHelper.addRecipe(forceGem, new Object[]{Items.redstone, Items.redstone, Items.redstone, Items.redstone});
        TransmutationHelper.addRecipe(new ItemStack(Items.redstone, 4), "gemForce");

        // 2 Force Logs <=> 8 Force Sticks
        TransmutationHelper.addRecipe(new ItemStack(forceStick.getItem(), 8), new Object[]{forceLog, forceLog});
        TransmutationHelper.addRecipe(new ItemStack(forceLog.getItem(), 2, forceLog.getItemDamage()), new Object[]{forceStick, forceStick, forceStick, forceStick, forceStick,
                forceStick, forceStick, forceStick});

        // 4 Force Gem <=> 6 Force Ingot
        TransmutationHelper.addRecipe(new ItemStack(ingotForce.getItem(), 6, ingotForce.getItemDamage()), "gemForce", "gemForce", "gemForce", "gemForce");
        TransmutationHelper.addRecipe(new ItemStack(forceGem.getItem(), 4, forceGem.getItemDamage()), "ingotForce", "ingotForce", "ingotForce", "ingotForce", "ingotForce",
                "ingotForce");

        // 4 Claw <=> 2 Flint
        TransmutationHelper.addRecipe(new ItemStack(Items.flint, 2), "itemClaw", "itemClaw", "itemClaw", "itemClaw");
        TransmutationHelper.addRecipe(new ItemStack(claw.getItem(), 4), new Object[]{Items.flint, Items.flint});
    }
}
