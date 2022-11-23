package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class CodSkullModel extends HeadModelBase {
	public CodSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createCodHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(11, 0).addBox(-1.0F, -4.0F, 1.0F, 2.0F, 4.0F, 3.0F),
				PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createCodHead();
		return LayerDefinition.create(meshdefinition, 32, 32);
	}
}
