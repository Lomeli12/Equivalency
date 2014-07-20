package net.lomeli.equivalency.recipes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import cpw.mods.fml.common.ObfuscationReflectionHelper;

import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.lib.ModVars;

public class VanillaRecipes {
    public static final int WILDCARD = Short.MAX_VALUE;
    private static ItemStack anyCoal = new ItemStack(Items.coal, 1, WILDCARD);

    public static void loadRecipes() {
        // 8 Glass Panes -> 3 Glass Blocks
        TransmutationHelper.addRecipe((new ItemStack(Blocks.glass, 3)), new Object[]{Blocks.glass_pane, Blocks.glass_pane,
                Blocks.glass_pane, Blocks.glass_pane, Blocks.glass_pane, Blocks.glass_pane, Blocks.glass_pane, Blocks.glass_pane});

        // 1 Coal -> 2 RedStone
        TransmutationHelper.addRecipe(Items.coal, new Object[]{Items.redstone, Items.redstone});
        // 2 RedStone -> 1 Coal
        TransmutationHelper.addRecipe(new ItemStack(Items.redstone, 2), new Object[]{(new ItemStack(Items.coal, 1, WILDCARD))});

        // 8 Coal -> 1 Lapis
        TransmutationHelper.addRecipe((new ItemStack(Items.dye, 1, 4)), new Object[]{
                (new ItemStack(Items.coal, 1, WILDCARD)), (new ItemStack(Items.coal, 1, WILDCARD)),
                (new ItemStack(Items.coal, 1, WILDCARD)), (new ItemStack(Items.coal, 1, WILDCARD)),
                (new ItemStack(Items.coal, 1, WILDCARD)), (new ItemStack(Items.coal, 1, WILDCARD)),
                (new ItemStack(Items.coal, 1, WILDCARD)), (new ItemStack(Items.coal, 1, WILDCARD))});
        // 2 Lapis -> 16 Coal
        TransmutationHelper.addRecipe(new ItemStack(Items.coal, 16), new Object[]{(new ItemStack(Items.dye, 1, 4)),
                (new ItemStack(Items.dye, 1, 4))});

        if (ModVars.emeraldTransmute) {
            // 8 Gold Ingot -> 1 Emerald
            TransmutationHelper.addRecipe(Items.emerald, new Object[]{Items.gold_ingot, Items.gold_ingot, Items.gold_ingot,
                    Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot});

            // 1 Emerald -> 8 Gold Ingot
            TransmutationHelper.addRecipe(new ItemStack(Items.gold_ingot, 8), new Object[]{Items.emerald});
        } else {
            ItemStack cactusGreen = new ItemStack(Items.dye, 1, 2);
            TransmutationHelper.addRecipe(Items.emerald, new Object[]{Items.diamond, cactusGreen, cactusGreen, cactusGreen});
        }

        if (ModVars.glowStone) {
            // 1 Redstone Blocks -> 1 Glowstone dust
            TransmutationHelper.addRecipe(Items.glowstone_dust, new Object[]{Blocks.redstone_block});

            // 1 Glowstone dust -> 1 Redstone Blocks
            TransmutationHelper.addRecipe(Blocks.redstone_block, new Object[]{Items.glowstone_dust});
        }

        // 2 Glowstone block -> 36 redstone dust
        TransmutationHelper.addRecipe(new ItemStack(Items.redstone, 64), new Object[]{Blocks.glowstone, Blocks.glowstone});

        TransmutationHelper.addRecipe(Items.iron_ingot, new Object[]{Items.quartz, Items.quartz, Items.quartz,
                Items.quartz});

        TransmutationHelper.addRecipe(new ItemStack(Items.quartz, 4), new Object[]{Items.iron_ingot, Items.iron_ingot,
                Items.iron_ingot});

        // 5 Blaze rods -> 1 Diamond Disabled due to exploit
        if (ModVars.blazeTransmute)
            TransmutationHelper.addRecipe(Items.diamond, new Object[]{Items.blaze_rod, Items.blaze_rod, Items.blaze_rod,
                    Items.blaze_rod, Items.blaze_rod});

        for (int i = 0; i < 16; i++) {
            if (i == 15) {
                TransmutationHelper.addRecipe(new ItemStack(Blocks.hardened_clay), new ItemStack(Blocks.stained_hardened_clay, 1, 15));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.carpet, 1, 0), new ItemStack(Blocks.carpet, 1, 15));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.wool, 1, 0), new ItemStack(Blocks.wool, 1, 15));
            } else {
                TransmutationHelper.addRecipe(new ItemStack(Blocks.carpet, 1, (i + 1)), new ItemStack(Blocks.carpet, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, (i + 1)), new ItemStack(Blocks.stained_hardened_clay, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.wool, 1, (i + 1)), new ItemStack(Blocks.wool, 1, i));
            }
            if (i == 14)
                TransmutationHelper.addRecipe(new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14));
            else
                TransmutationHelper.addRecipe(new ItemStack(Items.dye, 1, (i + 1)), new ItemStack(Items.dye, 1, i));
        }

        TransmutationHelper.addRecipe(new ItemStack(Blocks.stained_hardened_clay), new ItemStack(Blocks.hardened_clay));
        TransmutationHelper.addRecipe(new ItemStack(Blocks.melon_block), new ItemStack(Blocks.pumpkin));
        TransmutationHelper.addRecipe(new ItemStack(Blocks.pumpkin), new ItemStack(Blocks.melon_block));
        TransmutationHelper.addRecipe(new ItemStack(Items.pumpkin_seeds), new ItemStack(Items.melon_seeds));
        TransmutationHelper.addRecipe(new ItemStack(Items.melon_seeds), new ItemStack(Items.pumpkin_seeds));

        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                TransmutationHelper.addRecipe(new ItemStack(Blocks.log, 1, 0), new ItemStack(Blocks.log, 1, 3));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.sapling, 1, 0), new ItemStack(Blocks.sapling, 1, 3));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.leaves, 1, 0), new ItemStack(Blocks.leaves, 1, 3));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.wooden_slab, 1, 0), new ItemStack(Blocks.wooden_slab, 1, 3));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 3));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.planks, 1, 0), new ItemStack(Blocks.planks, 1, 3));
            } else {
                TransmutationHelper.addRecipe(new ItemStack(Blocks.log, 1, (i + 1)), new ItemStack(Blocks.log, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.sapling, 1, (i + 1)), new ItemStack(Blocks.sapling, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.leaves, 1, (i + 1)), new ItemStack(Blocks.leaves, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.wooden_slab, 1, (i + 1)), new ItemStack(Blocks.wooden_slab, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.stonebrick, 1, (i + 1)), new ItemStack(Blocks.stonebrick, 1, i));
                TransmutationHelper.addRecipe(new ItemStack(Blocks.planks, 1, (i + 1)), new ItemStack(Blocks.planks, 1, i));
            }
        }
    }

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
                //unSmeltedStack = new ItemStack(furnaceMapKey, 1, 0);

                //TransmutationHelper.addSmeltingRecipe(unSmeltedStack, transmutationStone, anyCoal);
            }

            while (iterFurnaceMetaKeyMap.hasNext()) {
                furnaceMetaMapKey = (List) iterFurnaceMetaKeyMap.next();
                //unSmeltedStack = new ItemStack((Integer) furnaceMetaMapKey.get(0), 1, (Integer) furnaceMetaMapKey.get(1));

                //TransmutationHelper.addSmeltingRecipe(unSmeltedStack, transmutationStone, anyCoal);
            }
        }
    }
}
