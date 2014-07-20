package net.lomeli.equivalency.core.handler;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

import net.lomeli.equivalency.api.TransmutationHelper;

public class CraftingHandler {

    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
        IInventory craftMatrix = event.craftMatrix;
        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            ItemStack itemstack = craftMatrix.getStackInSlot(i);
            if (itemstack != null && isTransmutationStone(itemstack)) {
                ItemStack damaged = new ItemStack(itemstack.getItem(), 2, itemstack.getItemDamage() + 1);
                if (itemstack.hasTagCompound())
                    damaged.readFromNBT(itemstack.getTagCompound());
                if (damaged.getItemDamage() >= damaged.getMaxDamage())
                    damaged.stackSize--;
                if (damaged != null)
                    craftMatrix.setInventorySlotContents(i, damaged);
                break;
            }
        }
    }

    public boolean isTransmutationStone(ItemStack stack) {
        if (stack != null) {
            for (int i = 0; i < TransmutationHelper.transmutationStones.size(); i++) {
                ItemStack item = TransmutationHelper.transmutationStones.get(i);
                if (item != null && item.getItem() == stack.getItem())
                    return true;
            }
        }
        return false;
    }
}
