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
import net.minecraft.resources.ResourceLocation;

import java.util.Arrays;

public class MagmaCubeSkullModel extends SkullModelBase {
	private static final ResourceLocation SLIME_LOCATION = new ResourceLocation("textures/entity/slime/slime.png");
	private final ModelPart root;
	private final ModelPart[] bodyCubes = new ModelPart[8];

	public MagmaCubeSkullModel(ModelPart root) {
		this.root = root;
		Arrays.setAll(this.bodyCubes, (id) -> root.getChild(getSegmentName(id)));
	}

	public static MeshDefinition createSlimeModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		for (int i = 0; i < 8; ++i) {
			int j = 0;
			int k = i;
			if (i == 2) {
				j = 24;
				k = 10;
			} else if (i == 3) {
				j = 24;
				k = 19;
			}

			partdefinition.addOrReplaceChild(getSegmentName(i), CubeListBuilder.create()
					.texOffs(j, k).addBox(-4.0F, (float) (-8 + i), -4.0F, 8.0F, 1.0F, 8.0F), PartPose.ZERO);
		}

		return meshdefinition;
	}

	private static String getSegmentName(int id) {
		return "cube" + id;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createSlimeModel();
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
