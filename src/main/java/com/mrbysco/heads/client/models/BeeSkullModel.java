package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BeeSkullModel extends HeadModelBase {

	public BeeSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createBeeHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(2, 2).addBox(-4.0F, -7.0F, -4.0F, 7.0F, 7.0F, 8.0F), PartPose.ZERO);
		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createBeeHead();
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
