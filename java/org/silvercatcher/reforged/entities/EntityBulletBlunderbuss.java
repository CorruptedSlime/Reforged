package org.silvercatcher.reforged.entities;

import java.util.Random;

import org.silvercatcher.reforged.ReforgedRegistry;
import org.silvercatcher.reforged.items.weapons.ItemBlunderbuss;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBulletBlunderbuss extends EntityThrowable {


	public EntityBulletBlunderbuss(World worldIn) {
		super(worldIn);
	}
	
	public EntityBulletBlunderbuss(World worldIn, EntityLivingBase throwerIn, ItemStack stack) {
		
		super(worldIn, throwerIn);
		this.setPositionAndRotation(throwerIn.posX, throwerIn.posY + throwerIn.getEyeHeight(), throwerIn.posZ, throwerIn.rotationYaw, throwerIn.rotationPitch);
		float randomNumX = rand.nextInt(21);
		float randomNumY = rand.nextInt(21);
		float randomNumZ = rand.nextInt(21);
		if(rand.nextBoolean()) {
			randomNumX = 0 - randomNumX;
		}
		if(rand.nextBoolean()) {
			randomNumY = 0 - randomNumY;
		}
		if(rand.nextBoolean()) {
			randomNumZ = 0 - randomNumZ;
		}
		this.motionX += randomNumX / 100;
		this.motionY += randomNumY / 100;
		this.motionZ += randomNumZ / 100;
	}

	@Override
	protected void onImpact(MovingObjectPosition target) {
		//Target is entity or block?
		if(target.entityHit == null) {
			//It's a block
		} else {
			//It's an entity
			target.entityHit.attackEntityFrom(ReforgedRegistry.blunderbussDamage, 4);
		}
		setDead();
	}
	
	@Override
	protected float getGravityVelocity() {
		return 0.005f;
	}
}
