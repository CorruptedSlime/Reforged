package org.silvercatcher.reforged.items.weapons;

import org.apache.commons.lang3.RandomUtils;
import org.silvercatcher.reforged.ReforgedMod;
import org.silvercatcher.reforged.items.ItemExtension;
import org.silvercatcher.reforged.material.MaterialDefinition;
import org.silvercatcher.reforged.material.MaterialManager;

import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.tools.asm.util.TraceSignatureVisitor;

public class ItemKnife extends ItemSword implements ItemExtension {

	protected final MaterialDefinition materialDefinition;
	
	public ItemKnife(ToolMaterial material) {
		
		super(material);
		
		materialDefinition = MaterialManager.getMaterialDefinition(material);
		
		setUnlocalizedName(materialDefinition.getPrefixedName("knife"));
		setMaxDamage(materialDefinition.getMaxUses());
		setMaxStackSize(1);
		setCreativeTab(ReforgedMod.tabReforged);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		
		boolean hit = super.onLeftClickEntity(stack, player, entity);
		
		if(entity instanceof EntityLiving) {
			
			EntityLiving target = (EntityLiving) entity;
			
			Vec3 look = target.getLookVec();
			Vec3 attacker = new Vec3(player.posX - target.posX,
					(player.getEntityBoundingBox().minY + player.height / 2)
					- target.posY + target.getEyeHeight(),
					player.posZ - target.posZ);
			double d0 = attacker.lengthVector();
			System.out.println(d0);
			double d1 = look.dotProduct(attacker);
			System.out.println(d1);
			
			boolean seen = d1 > 1 - 0.25 / d0;
			
			System.out.println(seen);
			
			if(seen && target.canEntityBeSeen(player)) {
				target.attackEntityFrom(DamageSource.causePlayerDamage(player), 2f);
			}
		}
		
		return hit;
	}
	
	@Override
	public void registerRecipes() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(this),
				new ItemStack(Items.stick), materialDefinition.getRepairMaterial());
	}

	@Override
	public float getHitDamage() {
		return materialDefinition.getDamageVsEntity() + 2f;
	}
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		return ItemExtension.super.getAttributeModifiers(stack);
	}
	
	@Override
	public int getItemEnchantability(ItemStack stack) {
		return materialDefinition.getEnchantability();
	}
}
