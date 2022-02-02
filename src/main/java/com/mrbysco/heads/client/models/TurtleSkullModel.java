package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class TurtleSkullModel extends HeadModelBase {

	public TurtleSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createTurtleHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(3, 0).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 5.0F, 6.0F), PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createTurtleHead();
		return LayerDefinition.create(meshdefinition, 128, 64);
	}
}
