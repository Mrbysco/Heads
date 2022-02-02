package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class WolfSkullModel extends HeadModelBase {

	public WolfSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createWolfHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
		head.addOrReplaceChild("real_head", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-3.0F, -6.0F, 0.0F, 6.0F, 6.0F, 4.0F)
				.texOffs(16, 14).addBox(-3.0F, -8.0F, 3.0F, 2.0F, 2.0F, 1.0F)
				.texOffs(16, 14).addBox(1.0F, -8.0F, 3.0F, 2.0F, 2.0F, 1.0F)
				.texOffs(0, 10).addBox(-1.5F, -3.0F, -4.0F, 3.0F, 3.0F, 4.0F), PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createWolfHead();
		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}
