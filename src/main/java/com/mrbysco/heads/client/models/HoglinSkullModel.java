package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class HoglinSkullModel extends HeadModelBase {

	public HoglinSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createHoglinHead(CubeDeformation cubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(61, 1).addBox(-7.0F, -6.0F, -12.5F, 14.0F, 6.0F, 19.0F),
				PartPose.ZERO);
		head.addOrReplaceChild("right_ear", CubeListBuilder.create()
						.texOffs(1, 1).addBox(-6.0F, -1.0F, -2.0F, 6.0F, 1.0F, 4.0F),
				PartPose.offsetAndRotation(-6.0F, -5.0F, 1.0F, 0.0F, 0.0F, -0.6981317F));
		head.addOrReplaceChild("left_ear", CubeListBuilder.create()
						.texOffs(1, 6).addBox(0.0F, -1.0F, -2.0F, 6.0F, 1.0F, 4.0F),
				PartPose.offsetAndRotation(6.0F, -5.0F, 1.0F, 0.0F, 0.0F, 0.6981317F));
		head.addOrReplaceChild("right_horn", CubeListBuilder.create()
						.texOffs(10, 13).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 11.0F, 2.0F),
				PartPose.offset(-7.0F, -1.0F, -5.5F));
		head.addOrReplaceChild("left_horn", CubeListBuilder.create()
						.texOffs(1, 13).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 11.0F, 2.0F),
				PartPose.offset(7.0F, -1.0F, -5.5F));

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createHoglinHead(CubeDeformation.NONE);
		return LayerDefinition.create(meshdefinition, 128, 64);
	}
}
