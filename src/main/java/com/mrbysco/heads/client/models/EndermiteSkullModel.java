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

public class EndermiteSkullModel extends SkullModelBase {
	private static final int[][] BODY_SIZES = new int[][]{{4, 3, 2}, {6, 4, 5}, {3, 3, 1}, {1, 2, 1}};
	private static final int[][] BODY_TEXS = new int[][]{{0, 0}, {0, 5}, {0, 14}, {0, 18}};
	private final ModelPart root;
	private final ModelPart[] bodyParts;

	public EndermiteSkullModel(ModelPart root) {
		this.root = root;
		this.bodyParts = new ModelPart[2];

		for (int i = 0; i < 2; ++i) {
			this.bodyParts[i] = root.getChild(createSegmentName(i));
		}
	}

	private static String createSegmentName(int id) {
		return "segment" + id;
	}

	public static MeshDefinition createEndermiteHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		float f = -3.5F;

		for (int i = 0; i < 2; ++i) {
			partdefinition.addOrReplaceChild(createSegmentName(i), CubeListBuilder.create()
							.texOffs(BODY_TEXS[i][0], BODY_TEXS[i][1]).addBox((float) BODY_SIZES[i][0] * -0.5F, 3.0f, ((float) BODY_SIZES[i][2] * -0.5F) + 1.5F, (float) BODY_SIZES[i][0], (float) BODY_SIZES[i][1], (float) BODY_SIZES[i][2]),
					PartPose.offset(0.0F, (-3 - (float) (BODY_SIZES[i][1])), f));
			if (i < 3) {
				f += (float) (BODY_SIZES[i][2] + BODY_SIZES[i + 1][2]) * 0.5F;
			}
		}

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createEndermiteHead();
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(float mouthAnimation, float yRot, float xRot) {
		this.root.yRot = yRot * ((float) Math.PI / 180F);
		this.root.xRot = xRot * ((float) Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
