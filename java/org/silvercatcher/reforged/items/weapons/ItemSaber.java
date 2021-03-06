package org.silvercatcher.reforged.items.weapons;


import org.silvercatcher.reforged.ReforgedMod;
import org.silvercatcher.reforged.items.ItemExtension;
import org.silvercatcher.reforged.material.MaterialDefinition;
import org.silvercatcher.reforged.material.MaterialManager;

import com.google.common.collect.Multimap;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemSaber extends ItemSword implements ItemExtension {

	protected final MaterialDefinition materialDefinition;
	
	public ItemSaber(ToolMaterial material) {
		
		super(material);
		
		materialDefinition = MaterialManager.getMaterialDefinition(material);
		
		setUnlocalizedName(materialDefinition.getPrefixedName("saber"));
		
		setCreativeTab(ReforgedMod.tabReforged);
		setMaxStackSize(1);
		setMaxDamage(materialDefinition.getMaxUses());
	}


	@Override
	public void registerRecipes() {
		
		GameRegistry.addRecipe(new ItemStack(this),
				" b ",
				"b  ",
				"s  ",
				'b', materialDefinition.getRepairMaterial(),
				's', Items.stick);
	}

	@Override
	public float getHitDamage() {
		
		return materialDefinition.getDamageVsEntity() + 3.5f;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		return ItemExtension.super.getAttributeModifiers(stack);
	}
	
	@Override
	public int getItemEnchantability(ItemStack stack) {
		return materialDefinition.getEnchantability();
	}
}
