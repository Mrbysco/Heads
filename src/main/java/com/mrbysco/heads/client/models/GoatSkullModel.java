package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class GoatSkullModel extends HeadModelBase {

	public GoatSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createGoatHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(2, 61).addBox("right ear", -5.5F, -10.0F, -1.0F, 3.0F, 2.0F, 1.0F)
				.texOffs(2, 61).mirror().addBox("left ear", 2.5F, -10.0F, -1.0F, 3.0F, 2.0F, 1.0F)
				.texOffs(23, 52).addBox("goatee", -0F, -2.0F, -5.0F, 0.0F, 7.0F, 5.0F),
				PartPose.ZERO);
		head.addOrReplaceChild("left_horn", CubeListBuilder.create()
				.texOffs(12, 55).addBox(0.49F, -15.0F, -1.0F, 2.0F, 7.0F, 2.0F),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("right_horn", CubeListBuilder.create()
				.texOffs(12, 55).addBox(-2.49F, -15.0F, -1.0F, 2.0F, 7.0F, 2.0F),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create()
				.texOffs(34, 46).addBox(-2.5F, -7.0F, -1.0F, 5.0F, 7.0F, 10.0F),
				PartPose.rotation(0.9599F, 0.0F, 0.0F));

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createGoatHead();
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
