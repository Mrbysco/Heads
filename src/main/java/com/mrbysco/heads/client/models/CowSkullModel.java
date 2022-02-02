package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class CowSkullModel extends HeadModelBase {
	public CowSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createCowHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 8.0F, 6.0F)
				.texOffs(22, 0).addBox("right_horn", -5.0F, -9.0F, 0.0F, 1.0F, 3.0F, 1.0F)
				.texOffs(22, 0).addBox("left_horn", 4.0F, -9.0F, -0.0F, 1.0F, 3.0F, 1.0F),
				PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createCowHead();
		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}
