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

import java.util.Arrays;

public class SilverfishSkullModel extends SkullModelBase {
	private final ModelPart root;
	private final ModelPart[] bodyParts = new ModelPart[3];
	private final ModelPart[] bodyLayers = new ModelPart[2];
	private static final int[][] BODY_SIZES = new int[][]{{3, 2, 2}, {4, 3, 2}, {6, 4, 3}, {3, 3, 3}, {2, 2, 3}, {2, 1, 2}, {1, 1, 2}};
	private static final int[][] BODY_TEXS = new int[][]{{0, 0}, {0, 4}, {0, 9}, {0, 16}, {0, 22}, {11, 0}, {13, 4}};

	public SilverfishSkullModel(ModelPart root) {
		this.root = root;
		Arrays.setAll(this.bodyParts, (i) -> root.getChild(getSegmentName(i)));
		Arrays.setAll(this.bodyLayers, (i) -> root.getChild(getLayerName(i)));
	}

	private static String getLayerName(int id) {
		return "layer" + id;
	}

	private static String getSegmentName(int id) {
		return "segment" + id;
	}


	public static MeshDefinition createEndermiteHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		float[] afloat = new float[7];
		float f = -3.5F;

		for(int i = 0; i < 3; ++i) {
			partdefinition.addOrReplaceChild(getSegmentName(i), CubeListBuilder.create()
					.texOffs(BODY_TEXS[i][0], BODY_TEXS[i][1]).addBox((float)BODY_SIZES[i][0] * -0.5F, 0.0F, ((float)BODY_SIZES[i][2] * -0.5F) + 1.5F, (float)BODY_SIZES[i][0], (float)BODY_SIZES[i][1], (float)BODY_SIZES[i][2]), PartPose.offset(0.0F, (float)(24 - BODY_SIZES[i][1]), f));
			afloat[i] = f;
			if (i < 6) {
				f += (float)(BODY_SIZES[i][2] + BODY_SIZES[i + 1][2]) * 0.5F;
			}
		}

		partdefinition.addOrReplaceChild(getLayerName(0), CubeListBuilder.create()
				.texOffs(20, 0).addBox(-5.0F, 0.0F, ((float)BODY_SIZES[2][2] * -0.5F) + 1.5F, 10.0F, 8.0F, (float)BODY_SIZES[2][2]), PartPose.offset(0.0F, 16.0F, afloat[2]));
		partdefinition.addOrReplaceChild(getLayerName(1), CubeListBuilder.create()
				.texOffs(20, 11).addBox(-3.0F, 0.0F, ((float)BODY_SIZES[4][2] * -0.5F) + 1.5F, 6.0F, 4.0F, (float)BODY_SIZES[4][2]), PartPose.offset(0.0F, 20.0F, afloat[4]));

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createEndermiteHead();
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(float mouthAnimation, float yRot, float xRot) {
		this.root.yRot = yRot * ((float)Math.PI / 180F);
		this.root.xRot = xRot * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		poseStack.translate(0, -1.5F, 0);
		this.root.render(poseStack, vertexConsumer, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
