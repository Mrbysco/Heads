package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class AllaySkullModel extends HeadModelBase {

	public AllaySkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createBeeHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F),
				PartPose.ZERO);
		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createBeeHead();
		return LayerDefinition.create(meshdefinition, 32, 32);
	}
}
