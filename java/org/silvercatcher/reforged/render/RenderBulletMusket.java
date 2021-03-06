package org.silvercatcher.reforged.render;

import org.lwjgl.opengl.GL11;
import org.silvercatcher.reforged.ReforgedReferences.Textures;
import org.silvercatcher.reforged.entities.EntityBulletMusket;
import org.silvercatcher.reforged.models.ModelBulletMusket;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBulletMusket extends Render
{
	protected ModelBase model;

	public RenderBulletMusket(RenderManager renderManager) {
		super(renderManager);
		this.model = new ModelBulletMusket();
	}


	@Override
	public void doRender(Entity Bullet, double x, double y, double z, float yaw, float partialTick) {
		renderEntityModel(Bullet, x, y, z, yaw, partialTick);
	}

	public void renderEntityModel(Entity Bullet, double x, double y, double z, float yaw, float partialTick) {
		EntityBulletMusket BM = (EntityBulletMusket) Bullet;
		GL11.glPushMatrix();
		float scale = 1;
		bindTexture(getEntityTexture(BM));
		GL11.glTranslated(x, y, z);
		GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(-yaw, 0, 1F, 0);
		model.render(BM, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0475F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return Textures.BULLET_MUSKET;
	}
}