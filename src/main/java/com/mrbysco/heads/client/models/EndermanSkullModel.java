package com.mrbysco.heads.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class EndermanSkullModel extends HeadModelBase {
	private static final RenderType ENDERMAN_EYES = RenderType.eyes(new ResourceLocation("textures/entity/enderman/enderman_eyes.png"));
	protected final ModelPart eyes;

	public EndermanSkullModel(ModelPart root) {
		super(root);
		this.eyes = root.getChild("eyes");
	}

	public static MeshDefinition createEndermanHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 16).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.5F)), PartPose.ZERO);
		head.addOrReplaceChild("top", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);

		partdefinition.addOrReplaceChild("eyes", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createEndermanHead();
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(float mouthAnimation, float yRot, float xRot) {
		super.setupAnim(mouthAnimation, yRot, xRot);
		this.eyes.yRot = yRot * ((float) Math.PI / 180F);
		this.eyes.xRot = xRot * ((float) Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		super.renderToBuffer(poseStack, vertexConsumer, packedLightIn, packedOverlayIn, red, green, blue, alpha);

		Minecraft minecraft = Minecraft.getInstance();
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		VertexConsumer eyeConsumer = bufferSource.getBuffer(ENDERMAN_EYES);
		poseStack.scale(1.01f, 1.01f, 1.01f);
		this.eyes.render(poseStack, eyeConsumer, 15728640, OverlayTexture.NO_OVERLAY, red, green, blue, alpha);
		bufferSource.endBatch(ENDERMAN_EYES);
	}
}
