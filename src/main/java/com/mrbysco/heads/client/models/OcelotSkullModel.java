package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class OcelotSkullModel extends HeadModelBase {
	public OcelotSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createOcelotHead(CubeDeformation cubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
						.addBox("main", -2.5F, -4.0F, -1.0F, 5.0F, 4.0F, 5.0F, cubeDeformation)
						.addBox("nose", -1.5F, -2.0F, -2.0F, 3, 2, 2, cubeDeformation, 0, 24)
						.addBox("ear1", -2.0F, -5.0F, 2.0F, 1, 1, 2, cubeDeformation, 0, 10)
						.addBox("ear2", 1.0F, -5.0F, 2.0F, 1, 1, 2, cubeDeformation, 6, 10),
				PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createOcelotHead(CubeDeformation.NONE);
		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}
