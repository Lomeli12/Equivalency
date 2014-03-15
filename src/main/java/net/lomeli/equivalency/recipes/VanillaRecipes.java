package net.lomeli.equivalency.recipes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.common.ObfuscationReflectionHelper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.lib.ModVars;

public class VanillaRecipes {
    public static final int WILDCARD = Short.MAX_VALUE;

    public static void loadRecipes() {
        // 8 Glass Panes -> 3 Glass Blocks
        TransmutationHelper.addRecipe((new ItemStack(Block.glass, 3)), new Object[] { Block.thinGlass, Block.thinGlass,
                Block.thinGlass, Block.thinGlass, Block.thinGlass, Block.thinGlass, Block.thinGlass, Block.thinGlass });

        // 1 Coal -> 2 RedStone
        TransmutationHelper.addRecipe(Item.coal, new Object[] { Item.redstone, Item.redstone });
        // 2 RedStone -> 1 Coal
        TransmutationHelper.addRecipe(new ItemStack(Item.redstone, 2), new Object[] { (new ItemStack(Item.coal, 1, WILDCARD)) });

        // 8 Coal -> 1 Lapis
        TransmutationHelper.addRecipe((new ItemStack(Item.dyePowder, 1, 4)), new Object[] {
                (new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)),
                (new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)),
                (new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)),
                (new ItemStack(Item.coal, 1, WILDCARD)), (new ItemStack(Item.coal, 1, WILDCARD)) });
        // 2 Lapis -> 16 Coal
        TransmutationHelper.addRecipe(new ItemStack(Item.coal, 16), new Object[] { (new ItemStack(Item.dyePowder, 1, 4)),
                (new ItemStack(Item.dyePowder, 1, 4)) });

        if (ModVars.emeraldTransmute) {
            // 8 Gold Ingot -> 1 Emerald
            TransmutationHelper.addRecipe(Item.emerald, new Object[] { Item.ingotGold, Item.ingotGold, Item.ingotGold,
                    Item.ingotGold, Item.ingotGold, Item.ingotGold, Item.ingotGold, Item.ingotGold });

            // 1 Emerald -> 8 Gold Ingot
            TransmutationHelper.addRecipe(new ItemStack(Item.ingotGold, 8), new Object[] { Item.emerald });
        }else {
            ItemStack cactusGreen = new ItemStack(Item.dyePowder, 1, 2);
            TransmutationHelper.addRecipe(Item.emerald, new Object[] { Item.diamond, cactusGreen, cactusGreen, cactusGreen });
        }

        if (ModVars.glowStone) {
            // 1 Redstone Block -> 1 Glowstone dust
            TransmutationHelper.addRecipe(Item.glowstone, new Object[] { Block.blockRedstone });

            // 1 Glowstone dust -> 1 Redstone Block
            TransmutationHelper.addRecipe(Block.blockRedstone, new Object[] { Item.glowstone });
        }

        // 2 Glowstone block -> 36 redstone dust
        TransmutationHelper.addRecipe(new ItemStack(Item.redstone, 64), new Object[] { Block.glowStone, Block.glowStone });

        TransmutationHelper.addRecipe(Item.ingotIron, new Object[] { Item.netherQuartz, Item.netherQuartz, Item.netherQuartz,
                Item.netherQuartz });

        TransmutationHelper.addRecipe(new ItemStack(Item.netherQuartz, 4), new Object[] { Item.ingotIron, Item.ingotIron,
                Item.ingotIron });

        // 5 Blaze rods -> 1 Diamond Disabled due to exploit
        if (ModVars.blazeTransmute)
            TransmutationHelper.addRecipe(Item.diamond, new Object[] { Item.blazeRod, Item.blazeRod, Item.blazeRod,
                    Item.blazeRod, Item.blazeRod });

        for (int i = 0; i < 16; i++) {
            if (i == 15) {
                TransmutationHelper.addRecipe(new ItemStack(Block.hardenedClay), new ItemStack(Block.stainedClay, 1, 15));
                TransmutationHelper.addRecipe(new ItemStack(Block.carpet, 1, 0), new ItemStack(Block.carpet, 1, 15));
                TransmutationHelper.addRecipe(new ItemStack(Block.cloth, 1, 0), new ItemStack(Block.cloth, 1, 15));
            } else {
                TransmutationHelper.addRecipe(new ItemStack(Block.carpet, 1, (i + 1)), new ItemStack(Block.carpet, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Block.stainedClay, 1, (i + 1)), new ItemStack(Block.stainedClay, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Block.cloth, 1, (i + 1)), new ItemStack(Block.cloth, 1, i));
            }
            if (i == 14)
                TransmutationHelper.addRecipe(new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Item.dyePowder, 1, 14));
            else
                TransmutationHelper.addRecipe(new ItemStack(Item.dyePowder, 1, (i + 1)), new ItemStack(Item.dyePowder, 1, i));
        }

        TransmutationHelper.addRecipe(new ItemStack(Block.stainedClay), new ItemStack(Block.hardenedClay));
        TransmutationHelper.addRecipe(new ItemStack(Block.melon), new ItemStack(Block.pumpkin));
        TransmutationHelper.addRecipe(new ItemStack(Block.pumpkin), new ItemStack(Block.melon));
        TransmutationHelper.addRecipe(new ItemStack(Item.pumpkinSeeds), new ItemStack(Item.melonSeeds));
        TransmutationHelper.addRecipe(new ItemStack(Item.melonSeeds), new ItemStack(Item.pumpkinSeeds));
        
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                TransmutationHelper.addRecipe(new ItemStack(Block.wood, 1, 0), new ItemStack(Block.wood, 1, 3));
                TransmutationHelper.addRecipe(new ItemStack(Block.sapling, 1, 0), new ItemStack(Block.sapling, 1, 3));
                TransmutationHelper.addRecipe(new ItemStack(Block.leaves, 1, 0), new ItemStack(Block.leaves, 1, 3));
                TransmutationHelper.addRecipe(new ItemStack(Block.woodSingleSlab, 1, 0), new ItemStack(Block.woodSingleSlab, 1, 3));
                TransmutationHelper.addRecipe(new ItemStack(Block.stoneBrick, 1, 0), new ItemStack(Block.stoneBrick, 1, 3));
                TransmutationHelper.addRecipe(new ItemStack(Block.planks, 1, 0), new ItemStack(Block.planks, 1, 3));
            } else {
                TransmutationHelper.addRecipe(new ItemStack(Block.wood, 1, (i + 1)), new ItemStack(Block.wood, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Block.sapling, 1, (i + 1)), new ItemStack(Block.sapling, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Block.leaves, 1, (i + 1)), new ItemStack(Block.leaves, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Block.woodSingleSlab, 1, (i + 1)), new ItemStack(Block.woodSingleSlab, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Block.stoneBrick, 1, (i + 1)), new ItemStack(Block.stoneBrick, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Block.planks, 1, (i + 1)), new ItemStack(Block.planks, 1, i));
            }
        }
    }

    private static ItemStack anyCoal = new ItemStack(Item.coal, 1, WILDCARD);

    @SuppressWarnings("rawtypes")
    public static void smelting() {
        for (ItemStack transmutationStone : TransmutationHelper.transmutationStones) {
            Map furnaceMap = FurnaceRecipes.smelting().getSmeltingList();
            Map furnaceMetaMap = ObfuscationReflectionHelper.getPrivateValue(FurnaceRecipes.class, FurnaceRecipes.smelting(),
                    "metaSmeltingList");

            Iterator iterFurnaceKeyMap = furnaceMap.keySet().iterator();
            Iterator iterFurnaceMetaKeyMap = furnaceMetaMap.keySet().iterator();

            Integer furnaceMapKey;
            List furnaceMetaMapKey;

            ItemStack unSmeltedStack;

            while (iterFurnaceKeyMap.hasNext()) {
                furnaceMapKey = (Integer) iterFurnaceKeyMap.next();
                unSmeltedStack = new ItemStack(furnaceMapKey, 1, 0);

                TransmutationHelper.addSmeltingRecipe(unSmeltedStack, transmutationStone, anyCoal);
            }

            while (iterFurnaceMetaKeyMap.hasNext()) {
                furnaceMetaMapKey = (List) iterFurnaceMetaKeyMap.next();
                unSmeltedStack = new ItemStack((Integer) furnaceMetaMapKey.get(0), 1, (Integer) furnaceMetaMapKey.get(1));

                TransmutationHelper.addSmeltingRecipe(unSmeltedStack, transmutationStone, anyCoal);
            }
        }
    }
}
