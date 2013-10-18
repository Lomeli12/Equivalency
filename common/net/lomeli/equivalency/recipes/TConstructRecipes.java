package net.lomeli.equivalency.recipes;

import tconstruct.library.TConstructRegistry;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class TConstructRecipes {
    public static ItemStack aluminum = TConstructRegistry.getItemStack("ingotAluminum");
    public static ItemStack aluminumBrass = TConstructRegistry.getItemStack("ingotAluminumBrass");
    public static ItemStack cobalt = TConstructRegistry.getItemStack("ingotCobalt");
    public static ItemStack ardite = TConstructRegistry.getItemStack("ingotArdite");
    public static ItemStack manyullyn = TConstructRegistry.getItemStack("ingotManyullyn");
    public static ItemStack alumite = TConstructRegistry.getItemStack("ingotAlumite");
    public static ItemStack copper = TConstructRegistry.getItemStack("ingotCopper");
    public static ItemStack tin = TConstructRegistry.getItemStack("ingotTin");
    public static ItemStack bronze = TConstructRegistry.getItemStack("ingotBronze");

    public static void loadRecipes(ItemStack transmutationStone, String modName) {
        Equivalency.loadModRecipes(modName);

        TransmutationHelper.addRecipe(alumite, transmutationStone, new Object[] { Block.blockGold, Block.blockGold });
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(Block.blockGold, 2), transmutationStone,
                "ingotAlumite"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(aluminumBrass, transmutationStone, "ingotCopper", "ingotCopper",
                "ingotCopper", "ingotCopper", "ingotCopper"));
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(copper.getItem(), 5, copper.getItemDamage()),
                transmutationStone, "ingotAluminumBrass"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(cobalt, transmutationStone, "ingotAlumite", "ingotAlumite",
                "ingotAlumite", "ingotAlumite"));
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(alumite.getItem(), 4, alumite.getItemDamage()),
                transmutationStone, "ingotCobalt"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(ardite, transmutationStone, "ingotAlumite", "ingotAlumite"));
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(alumite.getItem(), 2, alumite.getItemDamage()),
                transmutationStone, "ingotArdite"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(manyullyn.getItem(), 2, manyullyn.getItemDamage()),
                transmutationStone, "ingotCobalt", "ingotCobalt", "ingotCobalt", "ingotCobalt"));
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(cobalt.getItem(), 2, cobalt.getItemDamage()),
                transmutationStone, "ingotManyullyn"));

        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(manyullyn.getItem(), 2, manyullyn.getItemDamage()),
                transmutationStone, "ingotArdite", "ingotArdite", "ingotArdite", "ingotArdite", "ingotArdite", "ingotArdite",
                "ingotArdite", "ingotArdite"));
        TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(ardite.getItem(), 8, ardite.getItemDamage()),
                transmutationStone, "ingotManyullyn", "ingotManyullyn"));

        if(!Equivalency.limitRecipes) {
            UniversalRecipes.bronzeTin(bronze, tin, transmutationStone);
            UniversalRecipes.copperTin(copper, tin, transmutationStone);
            TransmutationHelper.addRecipe(new ShapelessOreRecipe(OreDictionary.getOres("ingotNaturalAluminum").get(0),
                    transmutationStone, "ingotTin", "ingotTin", "ingotTin"));
            TransmutationHelper.addRecipe(new ShapelessOreRecipe(new ItemStack(
                    OreDictionary.getOres("ingotTin").get(0).getItem(), 3, OreDictionary.getOres("ingotTin").get(0)
                            .getItemDamage()), transmutationStone, "ingotNaturalAluminum"));
        }
    }
}
