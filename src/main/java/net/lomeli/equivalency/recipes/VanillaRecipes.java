package net.lomeli.equivalency.recipes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.common.ObfuscationReflectionHelper;

import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.lib.ModVars;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import net.minecraftforge.oredict.OreDictionary;

public class VanillaRecipes {
    public static final int WILDCARD = Short.MAX_VALUE;

    public static void loadRecipes(ItemStack transmutationStone) {
        // 8 Glass Panes -> 3 Glass Blocks
        TransmutationHelper.addRecipe((new ItemStack(Block.glass, 3)), transmutationStone, new Object[] { Block.thinGlass,
                Block.thinGlass, Block.thinGlass, Block.thinGlass, Block.thinGlass, Block.thinGlass, Block.thinGlass,
                Block.thinGlass });

        // 1 Coal -> 2 RedStone
        TransmutationHelper.addRecipe(Item.coal, transmutationStone, new Object[] { Item.redstone, Item.redstone });
        // 2 RedStone -> 1 Coal
        TransmutationHelper.addRecipe(new ItemStack(Item.redstone, 2), transmutationStone, new Object[] { (new ItemStack(
                Item.coal, 1, WILDCARD)) });

        // 8 Coal -> 1 Lapis
        TransmutationHelper.addRecipe((new ItemStack(Item.dyePowder, 1, 4)), transmutationStone, new Object[] {
                (new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)),
                (new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)),
                (new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)),
                (new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)) });
        // 2 Lapis -> 16 Coal
        TransmutationHelper.addRecipe(new ItemStack(Item.coal, 16), transmutationStone, new Object[] {
                (new ItemStack(Item.dyePowder, 1, 4)), (new ItemStack(Item.dyePowder, 1, 4)) });

        if(ModVars.emeraldTransmute) {
            // 8 Gold Ingot -> 1 Emerald
            TransmutationHelper.addRecipe(Item.emerald, transmutationStone, new Object[] { Item.ingotGold, Item.ingotGold,
                    Item.ingotGold, Item.ingotGold, Item.ingotGold, Item.ingotGold, Item.ingotGold, Item.ingotGold });

            // 1 Emerald -> 8 Gold Ingot
            TransmutationHelper.addRecipe(new ItemStack(Item.ingotGold, 8), transmutationStone, new Object[] { Item.emerald });
        }else {
            ItemStack cactusGreen = new ItemStack(Item.dyePowder, 1, 2);
            TransmutationHelper.addRecipe(Item.emerald, transmutationStone, new Object[] { Item.diamond, cactusGreen,
                    cactusGreen, cactusGreen });
        }

        if(ModVars.glowStone) {
            // 1 Redstone Block -> 1 Glowstone dust
            TransmutationHelper.addRecipe(Item.glowstone, transmutationStone, new Object[] { Block.blockRedstone });

            // 1 Glowstone dust -> 1 Redstone Block
            TransmutationHelper.addRecipe(Block.blockRedstone, transmutationStone, new Object[] { Item.glowstone });
        }

        // 2 Glowstone block -> 36 redstone dust
        TransmutationHelper.addRecipe(new ItemStack(Item.redstone, 64), transmutationStone, new Object[] { Block.glowStone,
                Block.glowStone });

        TransmutationHelper.addRecipe(Item.ingotIron, transmutationStone, new Object[] { Item.netherQuartz, Item.netherQuartz,
                Item.netherQuartz, Item.netherQuartz });

        TransmutationHelper.addRecipe(new ItemStack(Item.netherQuartz, 4), transmutationStone, new Object[] { Item.ingotIron,
                Item.ingotIron, Item.ingotIron });

        // 5 Blaze rods -> 1 Diamond Disabled due to exploit
        if(ModVars.blazeTransmute)
            TransmutationHelper.addRecipe(Item.diamond, transmutationStone, new Object[] { Item.blazeRod, Item.blazeRod,
                    Item.blazeRod, Item.blazeRod, Item.blazeRod });

        for(int i = 0; i < 16; i++) {
            if(i == 15)
                TransmutationHelper.addRecipe(new ItemStack(Block.carpet, 1, 0), transmutationStone, new ItemStack(Block.carpet,
                        1, 15));
            else
                TransmutationHelper.addRecipe(new ItemStack(Block.carpet, 1, (i + 1)), transmutationStone, new ItemStack(
                        Block.carpet, 1, i));
        }
        
        TransmutationHelper.addRecipe(new ItemStack(Block.stainedClay), transmutationStone, new ItemStack(Block.hardenedClay));

        for(int i = 0; i < 16; i++) {
            if(i == 15)
                TransmutationHelper.addRecipe(new ItemStack(Block.hardenedClay), transmutationStone, new ItemStack(
                        Block.stainedClay, 1, 15));
            else
                TransmutationHelper.addRecipe(new ItemStack(Block.stainedClay, 1, (i + 1)), transmutationStone, new ItemStack(
                        Block.stainedClay, 1, i));
        }
        
        TransmutationHelper.addRecipe(new ItemStack(Block.melon), transmutationStone, new ItemStack(Block.pumpkin));
        TransmutationHelper.addRecipe(new ItemStack(Block.pumpkin), transmutationStone, new ItemStack(Block.melon));
        TransmutationHelper.addRecipe(new ItemStack(Item.pumpkinSeeds), transmutationStone, new ItemStack(Item.melonSeeds));
        TransmutationHelper.addRecipe(new ItemStack(Item.melonSeeds), transmutationStone, new ItemStack(Item.pumpkinSeeds));

        oldRecipes(transmutationStone);
    }

    private static ItemStack anyCoal = new ItemStack(Item.coal, 1, OreDictionary.WILDCARD_VALUE);
    private static ItemStack anyWood = new ItemStack(Block.wood, 1, OreDictionary.WILDCARD_VALUE);
    private static ItemStack anyPlank = new ItemStack(Block.planks, 1, OreDictionary.WILDCARD_VALUE);
    private static ItemStack anySandStone = new ItemStack(Block.sandStone, 1, OreDictionary.WILDCARD_VALUE);
    private static ItemStack dyeBoneMeal = new ItemStack(Item.dyePowder, 1, 15);

    public static void oldRecipes(ItemStack transmutationStone) {
        TransmutationHelper.addRecipe(Item.flint, transmutationStone, new Object[] { Block.cobblestone, Block.cobblestone,
                Block.cobblestone, Block.cobblestone });
        TransmutationHelper.addRecipe(new ItemStack(Block.cobblestone, 4), transmutationStone, Item.flint);

        TransmutationHelper.addRecipe(Block.gravel, transmutationStone, new Object[] { Block.dirt, Block.dirt, Block.dirt,
                Block.dirt });
        TransmutationHelper.addRecipe(new ItemStack(Block.dirt, 4), transmutationStone, Block.gravel);

        /* 4 Sand <-> 1 Sandstone */
        // Vanilla Recipes exist to make SandStone from 4 Sand
        TransmutationHelper.addRecipe(new ItemStack(Block.sand, 4), transmutationStone, anySandStone);

        /* 2 Sticks -> Wood Plank */
        TransmutationHelper.addRecipe(Block.planks, transmutationStone, new Object[] { Item.stick, Item.stick });
        // Vanilla recipe exists to make sticks from planks

        /* 4 Wood Planks -> Wood Block */
        TransmutationHelper.addRecipe(Block.wood, transmutationStone, new Object[] { anyPlank, anyPlank, anyPlank, anyPlank });
        // Vanilla recipes exist to make planks from any wood log

        /* 4 Gravel/Sandstone/Flint -> 1 Clay Ball, 1 Clay Ball -> 4 Gravel */
        TransmutationHelper.addRecipe(Item.clay, transmutationStone, new Object[] { Block.gravel, Block.gravel, Block.gravel,
                Block.gravel });
        TransmutationHelper.addRecipe(Item.clay, transmutationStone, new Object[] { anySandStone, anySandStone, anySandStone,
                anySandStone });
        TransmutationHelper.addRecipe(Item.clay, transmutationStone, new Object[] { Item.flint, Item.flint, Item.flint,
                Item.flint });
        TransmutationHelper.addRecipe(new ItemStack(Block.gravel, 4), transmutationStone, Item.clay);

        /* 2 Wood Log <-> 1 Obsidian */
        TransmutationHelper.addRecipe(Block.obsidian, transmutationStone, new Object[] { anyWood, anyWood });
        TransmutationHelper.addRecipe(new ItemStack(Block.wood, 2), transmutationStone, Block.obsidian);

        /* 4 Clay Ball <-> 1 Clay Block */
        // Vanilla recipe exists to make clay blocks from clay balls
        TransmutationHelper.addRecipe(new ItemStack(Item.clay, 4), transmutationStone, Block.blockClay);

        /* 4 Obsidian/Clay Block -> 1 Iron Ingot, Iron Ingot -> Clay Block */
        TransmutationHelper.addRecipe(Item.ingotIron, transmutationStone, new Object[] { Block.obsidian, Block.obsidian,
                Block.obsidian, Block.obsidian });
        TransmutationHelper.addRecipe(Item.ingotIron, transmutationStone, new Object[] { Block.blockClay, Block.blockClay,
                Block.blockClay, Block.blockClay });
        TransmutationHelper.addRecipe(new ItemStack(Block.blockClay, 4), transmutationStone, Item.ingotIron);

        /* 8 Iron Ingot <-> 1 Gold Ingot */
        TransmutationHelper.addRecipe(Item.ingotGold, transmutationStone, new Object[] { Item.ingotIron, Item.ingotIron,
                Item.ingotIron, Item.ingotIron, Item.ingotIron, Item.ingotIron, Item.ingotIron, Item.ingotIron });
        TransmutationHelper.addRecipe(new ItemStack(Item.ingotIron, 8), transmutationStone, Item.ingotGold);

        /* 4 Gold Ingot <-> 1 Diamond */
        TransmutationHelper.addRecipe(Item.diamond, transmutationStone, new Object[] { Item.ingotGold, Item.ingotGold,
                Item.ingotGold, Item.ingotGold });
        TransmutationHelper.addRecipe(new ItemStack(Item.ingotGold, 4), transmutationStone, Item.diamond);

        /* 8 Iron Block <-> 1 Gold Block */
        TransmutationHelper.addRecipe(Block.blockGold, transmutationStone, new Object[] { Block.blockIron, Block.blockIron,
                Block.blockIron, Block.blockIron, Block.blockIron, Block.blockIron, Block.blockIron, Block.blockIron });
        TransmutationHelper.addRecipe(new ItemStack(Block.blockIron, 8), transmutationStone, Block.blockGold);

        /* 4 Gold Block <-> 1 Diamond Block */
        TransmutationHelper.addRecipe(Block.blockDiamond, transmutationStone, new Object[] { Block.blockGold, Block.blockGold,
                Block.blockGold, Block.blockGold });
        TransmutationHelper.addRecipe(new ItemStack(Block.blockGold, 4), transmutationStone, Block.blockDiamond);

        /* 1 Ender Pearl <-> 4 Iron Ingot */
        TransmutationHelper.addRecipe(Item.enderPearl, transmutationStone, new Object[] { Item.ingotIron, Item.ingotIron,
                Item.ingotIron, Item.ingotIron });
        TransmutationHelper.addRecipe(new ItemStack(Item.ingotIron, 4), transmutationStone, Item.enderPearl);

        for(int i = 0; i < 16; i++) {
            if(i == 15)
                TransmutationHelper.addRecipe(new ItemStack(Item.dyePowder, 1, 0), transmutationStone, dyeBoneMeal);
            else
                TransmutationHelper.addRecipe(new ItemStack(Item.dyePowder, 1, (i + 1)), transmutationStone, new ItemStack(
                        Item.dyePowder, 1, i));
        }

        for(int i = 0; i < 16; i++) {
            if(i == 15)
                TransmutationHelper.addRecipe(new ItemStack(Block.cloth, 1, 0), transmutationStone, new ItemStack(Block.cloth, 1,
                        15));
            else
                TransmutationHelper.addRecipe(new ItemStack(Block.cloth, 1, (i + 1)), transmutationStone, new ItemStack(
                        Block.cloth, 1, i));
        }

        for(int i = 0; i < 4; i++) {
            if(i == 3)
                TransmutationHelper.addRecipe(new ItemStack(Block.wood, 1, 0), transmutationStone,
                        new ItemStack(Block.wood, 1, 3));
            else
                TransmutationHelper.addRecipe(new ItemStack(Block.wood, 1, (i + 1)), transmutationStone, new ItemStack(
                        Block.wood, 1, i));
        }

        for(int i = 0; i < 4; i++) {
            if(i == 3)
                TransmutationHelper.addRecipe(new ItemStack(Block.sapling, 1, 0), transmutationStone, new ItemStack(
                        Block.sapling, 1, 3));
            else
                TransmutationHelper.addRecipe(new ItemStack(Block.sapling, 1, (i + 1)), transmutationStone, new ItemStack(
                        Block.sapling, 1, i));
        }

        for(int i = 0; i < 4; i++) {
            if(i == 3)
                TransmutationHelper.addRecipe(new ItemStack(Block.leaves, 1, 0), transmutationStone, new ItemStack(Block.leaves,
                        1, 3));
            else
                TransmutationHelper.addRecipe(new ItemStack(Block.leaves, 1, (i + 1)), transmutationStone, new ItemStack(
                        Block.leaves, 1, i));
        }

        for(int i = 0; i < 4; i++) {
            if(i == 3)
                TransmutationHelper.addRecipe(new ItemStack(Block.woodSingleSlab, 1, 0), transmutationStone, new ItemStack(
                        Block.woodSingleSlab, 1, 3));
            else
                TransmutationHelper.addRecipe(new ItemStack(Block.woodSingleSlab, 1, (i + 1)), transmutationStone, new ItemStack(
                        Block.woodSingleSlab, 1, i));
        }

        for(int i = 0; i < 4; i++) {
            if(i == 3)
                TransmutationHelper.addRecipe(new ItemStack(Block.stoneBrick, 1, 0), transmutationStone, new ItemStack(
                        Block.stoneBrick, 1, 3));
            else
                TransmutationHelper.addRecipe(new ItemStack(Block.stoneBrick, 1, (i + 1)), transmutationStone, new ItemStack(
                        Block.stoneBrick, 1, i));
        }

        for(int i = 0; i < 4; i++) {
            if(i == 3)
                TransmutationHelper.addRecipe(new ItemStack(Block.planks, 1, 0), transmutationStone, new ItemStack(Block.planks,
                        1, 3));
            else
                TransmutationHelper.addRecipe(new ItemStack(Block.planks, 1, (i + 1)), transmutationStone, new ItemStack(
                        Block.planks, 1, i));
        }
    }

    @SuppressWarnings("rawtypes")
    public static void smelting(ItemStack transmutationStone) {
        Map furnaceMap = FurnaceRecipes.smelting().getSmeltingList();
        Map furnaceMetaMap = ObfuscationReflectionHelper.getPrivateValue(FurnaceRecipes.class, FurnaceRecipes.smelting(),
                "metaSmeltingList");

        Iterator iterFurnaceKeyMap = furnaceMap.keySet().iterator();
        Iterator iterFurnaceMetaKeyMap = furnaceMetaMap.keySet().iterator();

        Integer furnaceMapKey;
        List furnaceMetaMapKey;

        ItemStack unSmeltedStack;

        while(iterFurnaceKeyMap.hasNext()) {
            furnaceMapKey = (Integer) iterFurnaceKeyMap.next();
            unSmeltedStack = new ItemStack(furnaceMapKey, 1, 0);

            TransmutationHelper.addSmeltingRecipe(unSmeltedStack, transmutationStone, anyCoal);
        }

        while(iterFurnaceMetaKeyMap.hasNext()) {
            furnaceMetaMapKey = (List) iterFurnaceMetaKeyMap.next();
            unSmeltedStack = new ItemStack((Integer) furnaceMetaMapKey.get(0), 1, (Integer) furnaceMetaMapKey.get(1));

            TransmutationHelper.addSmeltingRecipe(unSmeltedStack, transmutationStone, anyCoal);
        }
    }
}
