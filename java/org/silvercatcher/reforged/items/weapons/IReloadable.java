package org.silvercatcher.reforged.items.weapons;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IReloadable {

	NBTTagCompound initReloadTags(ItemStack stack);
	
	int getReloadTotal();
	
	int getReloadDone(ItemStack stack);
}
