package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class PigSkullModel extends HeadModelBase {

	public PigSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createPigHead(CubeDeformation cubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation)
						.texOffs(16, 16).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 3.0F, 1.0F, cubeDeformation),
				PartPose.ZERO);
		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createPigHead(CubeDeformation.NONE);
		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}
