package com.mrbysco.heads.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class HeadModelBase extends SkullModelBase {
	protected final ModelPart root;
	protected final ModelPart head;

	public HeadModelBase(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
	}

	public static MeshDefinition createHeadModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
		return meshdefinition;
	}

	public static LayerDefinition createMobHead(int textureWidthIn, int textureHeightIn) {
		MeshDefinition meshdefinition = createHeadModel();
		return LayerDefinition.create(meshdefinition, textureWidthIn, textureHeightIn);
	}

	@Override
	public void setupAnim(float mouthAnimation, float yRot, float xRot) {
		this.head.yRot = yRot * ((float) Math.PI / 180F);
		this.head.xRot = xRot * ((float) Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
