package org.silvercatcher.reforged.items.others;

import org.silvercatcher.reforged.ReforgedMod;
import org.silvercatcher.reforged.items.ExtendedItem;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemBulletBlunderbuss extends ExtendedItem {
	
	public ItemBulletBlunderbuss() {
		
		setMaxStackSize(64);
		setUnlocalizedName("blunderbuss_bullet");
		
		setCreativeTab(ReforgedMod.tabReforged);
	}

	@Override
	public void registerRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack(this, 8),
				" h ",
				" g ",
				" p ",
				'h', new ItemStack(Blocks.gravel),
				'g', Items.gunpowder,
				'p', Items.paper);
	}


	@Override
	public float getHitDamage() {
		return 0;
	}
}