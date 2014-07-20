package net.lomeli.equivalency.recipes;

import appeng.api.AEApi;
import appeng.api.definitions.Materials;
import appeng.api.definitions.Parts;
import appeng.api.util.AEColor;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import net.lomeli.lomlib.util.ModLoaded;

import net.lomeli.equivalency.Equivalency;
import net.lomeli.equivalency.api.TransmutationHelper;
import net.lomeli.equivalency.lib.ModVars;

public class AppliedEnergisticsRecipes {
    public static void loadRecipes(String modName) {
        Equivalency.loadModRecipes(modName);
        Materials mat = AEApi.instance().materials();
        Parts parts = AEApi.instance().parts();

        if (ModVars.quratzRecipe) {
            if (ModLoaded.isModInstalled("IC2")) {
                TransmutationHelper.addRecipe(new ItemStack(mat.materialCertusQuartzDust.item(), 4, 7), new Object[]{mat.materialCertusQuartzCrystal.item(), mat.materialCertusQuartzCrystal.item()});
            } else {
                TransmutationHelper.addRecipe(new ItemStack(mat.materialCertusQuartzDust.item(), 6, 7), new Object[]{mat.materialCertusQuartzCrystal.item(), mat.materialCertusQuartzCrystal.item()});
            }
        }

        // 5 Quartz Dust -> 1 Iron Ingot
        TransmutationHelper.addRecipe(new ItemStack(Items.iron_ingot), new Object[]{mat.materialCertusQuartzDust.item(), mat.materialCertusQuartzDust.item(), mat.materialCertusQuartzDust.item(),
                mat.materialCertusQuartzDust.item(), mat.materialCertusQuartzDust.item()});

        // 5 Iron -> 1 Quartz Crystal
        TransmutationHelper.addRecipe(new ItemStack(mat.materialCertusQuartzCrystal.item(), 1, 6), new Object[]{Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot,
                Items.iron_ingot});

        // 1 Quartz Crystal -> 5 Iron
        TransmutationHelper.addRecipe(new ItemStack(Items.iron_ingot, 5), new Object[]{mat.materialCertusQuartzCrystal.item()});

        for (int j = 0; j < 17; j++) {
            if (j == 16)
                TransmutationHelper.addRecipe(parts.partCableGlass.item(getColorFromInt(0)), new Object[]{parts.partCableGlass.item(getColorFromInt(j))});
            else
                TransmutationHelper.addRecipe(parts.partCableGlass.item(getColorFromInt(j + 1)), new Object[]{parts.partCableGlass.item(getColorFromInt(j))});
        }
    }

    private static AEColor getColorFromInt(int i) {
        switch (i) {
            case 0:
                return AEColor.White;
            case 1:
                return AEColor.Orange;
            case 2:
                return AEColor.Magenta;
            case 3:
                return AEColor.LightBlue;
            case 4:
                return AEColor.Yellow;
            case 5:
                return AEColor.Lime;
            case 6:
                return AEColor.Pink;
            case 7:
                return AEColor.Gray;
            case 8:
                return AEColor.LightGray;
            case 9:
                return AEColor.Cyan;
            case 10:
                return AEColor.Purple;
            case 11:
                return AEColor.Blue;
            case 12:
                return AEColor.Brown;
            case 13:
                return AEColor.Green;
            case 14:
                return AEColor.Red;
            case 15:
                return AEColor.Black;
            case 16:
                return AEColor.Transparent;
            default:
                return AEColor.Purple;
        }
    }
}
