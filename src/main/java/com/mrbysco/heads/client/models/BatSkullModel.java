package com.mrbysco.heads.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BatSkullModel extends HeadModelBase {
	public BatSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createBatHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-3.0F, -6.0F, 2.0F, 6.0F, 6.0F, 6.0F), PartPose.ZERO);
		head.addOrReplaceChild("right_ear", CubeListBuilder.create()
				.texOffs(24, 0).addBox(-4.0F, -10.0F, 2.0F, 3.0F, 4.0F, 1.0F), PartPose.ZERO);
		head.addOrReplaceChild("left_ear", CubeListBuilder.create()
				.texOffs(24, 0).mirror().addBox(1.0F, -10.0F, 2.0F, 3.0F, 4.0F, 1.0F), PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createBatHead();
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		poseStack.scale(0.5F, 0.5F, 0.5F);
		super.renderToBuffer(poseStack, vertexConsumer, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(float mouthAnimation, float yRot, float xRot) {
		super.setupAnim(mouthAnimation, yRot, xRot);
	}
}
