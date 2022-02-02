package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class FoxSkullModel extends HeadModelBase {

	public FoxSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createFoxHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(1, 5).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 6.0F, 6.0F), PartPose.ZERO);
		head.addOrReplaceChild("right_ear", CubeListBuilder.create()
				.texOffs(8, 1).addBox(-4.0F, -8.0F, -1.0F, 2.0F, 2.0F, 1.0F), PartPose.ZERO);
		head.addOrReplaceChild("left_ear", CubeListBuilder.create()
				.texOffs(15, 1).addBox(2.0F, -8.0F, -1.0F, 2.0F, 2.0F, 1.0F), PartPose.ZERO);
		head.addOrReplaceChild("nose", CubeListBuilder.create()
				.texOffs(6, 18).addBox(-2.0F, -1.99F, -5.0F, 4.0F, 2.0F, 3.0F), PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createFoxHead();
		return LayerDefinition.create(meshdefinition, 48, 32);
	}
}
