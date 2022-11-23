package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class DolphinSkullModel extends HeadModelBase {
	public DolphinSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createDolphinHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 7.0F, 6.0F),
				PartPose.ZERO);
		head.addOrReplaceChild("nose", CubeListBuilder.create()
				.texOffs(0, 13).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 4.0F), PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createDolphinHead();
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
