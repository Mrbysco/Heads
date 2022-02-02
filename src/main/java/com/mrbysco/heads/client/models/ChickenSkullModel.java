package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class ChickenSkullModel extends HeadModelBase {
	public ChickenSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createChickenHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-2.0F, -6.0F,  1F, 4.0F, 6.0F, 3.0F), PartPose.ZERO);
		head.addOrReplaceChild("beak", CubeListBuilder.create()
				.texOffs(14, 0).addBox(-2.0F, -4.0F, -1F, 4.0F, 2.0F, 2.0F), PartPose.ZERO);
		head.addOrReplaceChild("red_thing", CubeListBuilder.create()
				.texOffs(14, 4).addBox(-1.0F, -2.01F, -0F, 2.0F, 2.0F, 2.0F), PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createChickenHead();
		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}
