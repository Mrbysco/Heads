package com.mrbysco.heads.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class HorseSkullModel extends SkullModelBase {
	protected final ModelPart root;
	protected final ModelPart head;

	public HorseSkullModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head_parts");
	}

	public static MeshDefinition createHorseHead(CubeDeformation cubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartPose pose = PartPose.rotation(0.45F, 0, 0);

		PartDefinition head_parts = partdefinition.addOrReplaceChild("head_parts", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition head = head_parts.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 35).addBox("neck", -2.0F, -10.0F, -1.0F, 4.0F, 12.0F, 7.0F)
				.texOffs(0, 13).addBox(-3.0F, -15.0F, -1.0F, 6.0F, 5.0F, 7.0F, cubeDeformation), pose);
		head_parts.addOrReplaceChild("mane", CubeListBuilder.create()
				.texOffs(56, 36).addBox(-1.0F, -15.0F, 6.0F, 2.0F, 16.0F, 2.0F, cubeDeformation), pose);
		head_parts.addOrReplaceChild("upper_mouth", CubeListBuilder.create()
				.texOffs(0, 25).addBox(-2.0F, -15.0F, -6.0F, 4.0F, 5.0F, 5.0F, cubeDeformation), pose);
		head.addOrReplaceChild("left_ear", CubeListBuilder.create()
				.texOffs(19, 16).addBox(0.55F, -17.0F, 5.0F, 2.0F, 3.0F, 1.0F,
						new CubeDeformation(-0.001F)), PartPose.ZERO);
		head.addOrReplaceChild("right_ear", CubeListBuilder.create()
				.texOffs(19, 16).addBox(-2.55F, -17.0F, 5.0F, 2.0F, 3.0F, 1.0F,
						new CubeDeformation(-0.001F)), PartPose.ZERO);


		return meshdefinition;
	}

	public static LayerDefinition createMuleSkull() {
		MeshDefinition meshdefinition = createHorseHead(CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.getChild("head_parts").getChild("head");
		CubeListBuilder ear = CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 7.0F, 1.0F);
		head.addOrReplaceChild("left_ear", ear, PartPose.offsetAndRotation(1.25F, -16.0F, 3.0F, 0.2617994F, 0.0F, 0.2617994F));
		head.addOrReplaceChild("right_ear", ear, PartPose.offsetAndRotation(-1.25F, -16.0F, 3.0F, 0.2617994F, 0.0F, -0.2617994F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createDonkeySkull() {
		MeshDefinition meshdefinition = createHorseHead(CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.getChild("head_parts").getChild("head");
		CubeListBuilder ear = CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 7.0F, 1.0F);
		head.addOrReplaceChild("left_ear", ear, PartPose.offsetAndRotation(1.25F, -16.0F, 3.0F, 0.2617994F, 0.0F, 0.2617994F));
		head.addOrReplaceChild("right_ear", ear, PartPose.offsetAndRotation(-1.25F, -16.0F, 3.0F, 0.2617994F, 0.0F, -0.2617994F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createHorseSkull() {
		MeshDefinition meshdefinition = createHorseHead(CubeDeformation.NONE);
		return LayerDefinition.create(meshdefinition, 64, 64);
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
