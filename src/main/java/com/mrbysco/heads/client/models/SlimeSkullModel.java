package com.mrbysco.heads.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class SlimeSkullModel extends SkullModelBase {
	private static final ResourceLocation SLIME_LOCATION = new ResourceLocation("textures/entity/slime/slime.png");
	protected final ModelPart root;
	protected final ModelPart cube;
	protected final ModelPart cubeOuter;

	public SlimeSkullModel(ModelPart root) {
		this.root = root;
		this.cube = root.getChild("cube");
		this.cubeOuter = root.getChild("cube_outer");
	}

	public static MeshDefinition createSlimeModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cube = partdefinition.addOrReplaceChild("cube", CubeListBuilder.create()
				.texOffs(0, 16).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.ZERO);
		cube.addOrReplaceChild("right_eye", CubeListBuilder.create()
				.texOffs(32, 0).addBox(-3.25F, -6.0F, -3.5F, 2.0F, 2.0F, 2.0F), PartPose.ZERO);
		cube.addOrReplaceChild("left_eye", CubeListBuilder.create()
				.texOffs(32, 4).addBox(1.25F, -6.0F, -3.5F, 2.0F, 2.0F, 2.0F), PartPose.ZERO);
		cube.addOrReplaceChild("mouth", CubeListBuilder.create()
				.texOffs(32, 8).addBox(0.0F, -3.0F, -3.5F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);

		partdefinition.addOrReplaceChild("cube_outer", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createSlimeModel();
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(float mouthAnimation, float yRot, float xRot) {
		this.cube.yRot = yRot * ((float)Math.PI / 180F);
		this.cube.xRot = xRot * ((float)Math.PI / 180F);

		this.cubeOuter.yRot = yRot * ((float)Math.PI / 180F);
		this.cubeOuter.xRot = xRot * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.cube.render(poseStack, vertexConsumer, packedLightIn, packedOverlayIn, red, green, blue, alpha);

		Minecraft minecraft = Minecraft.getInstance();
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		final RenderType renderType = RenderType.entityTranslucent(SLIME_LOCATION);
		VertexConsumer slimeConsumer = bufferSource.getBuffer(renderType);
		this.cubeOuter.render(poseStack, slimeConsumer, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		bufferSource.endBatch(renderType);
	}
}
