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
import net.minecraft.resources.ResourceLocation;

public class LayeredSkullModel extends HeadModelBase {
	private final RenderType OUTER_LAYER;
	protected final ModelPart hat;

	public LayeredSkullModel(ModelPart root, ResourceLocation layer) {
		super(root);
		this.hat = root.getChild("hat");
		this.OUTER_LAYER = RenderType.entityCutoutNoCullZOffset(layer);
	}

	public static MeshDefinition createHumanoidHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 16).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.5F)), PartPose.ZERO);

		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F,
						new CubeDeformation(0.25F)), PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createHumanoidHead();
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createSkullModel(int width, int height) {
		MeshDefinition meshdefinition = createHumanoidHead();
		return LayerDefinition.create(meshdefinition, width, height);
	}

	@Override
	public void setupAnim(float mouthAnimation, float yRot, float xRot) {
		super.setupAnim(mouthAnimation, yRot, xRot);
		this.hat.yRot = yRot * ((float) Math.PI / 180F);
		this.hat.xRot = xRot * ((float) Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		super.renderToBuffer(poseStack, vertexConsumer, packedLightIn, packedOverlayIn, red, green, blue, alpha);

		Minecraft minecraft = Minecraft.getInstance();
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		VertexConsumer cutoutConsumer = bufferSource.getBuffer(OUTER_LAYER);
		this.hat.render(poseStack, cutoutConsumer, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		bufferSource.endBatch(OUTER_LAYER);
	}
}
