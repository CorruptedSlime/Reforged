package org.silvercatcher.reforged.render;

import org.lwjgl.opengl.GL11;
import org.silvercatcher.reforged.ReforgedReferences.Textures;
import org.silvercatcher.reforged.entities.EntityJavelin;
import org.silvercatcher.reforged.models.ModelJavelin;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderJavelin extends Render
{
	protected ModelBase model = new ModelJavelin();
	
	public RenderJavelin(RenderManager renderManager) {
		super(renderManager);
		this.model = new ModelJavelin();
	}


	@Override
	public void doRender(Entity Javelin, double x, double y, double z, float yaw, float partialTicks) {
		super.doRender(Javelin, x, y, z, yaw, partialTicks);
		renderEntityModel(Javelin, x, y, z, yaw, partialTicks);
	}

	public void renderEntityModel(Entity Javelin, double x, double y, double z, float yaw, float partialTicks) {
		EntityJavelin J = (EntityJavelin) Javelin;
		GL11.glPushMatrix();
		float scale = 1;
		bindTexture(getEntityTexture(J));
		GL11.glTranslated(x, y, z);
		GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(yaw + 90, 0, partialTicks, 0);
		model.render(J, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0475F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return Textures.JAVELIN;
	}
}