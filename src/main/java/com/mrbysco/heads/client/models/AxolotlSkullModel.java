package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class AxolotlSkullModel extends HeadModelBase {

	public AxolotlSkullModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createAxolotlHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		CubeDeformation cubedeformation = new CubeDeformation(0.001F);
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 1).addBox(-4.0F, -5.0F, 3.0F, 8.0F, 5.0F, 5.0F, cubedeformation), PartPose.ZERO);
		CubeListBuilder topGills = CubeListBuilder.create()
				.texOffs(3, 37).addBox(-4.0F, -5.0F, 8.0F, 8.0F, 3.0F, 0.0F, cubedeformation);
		CubeListBuilder leftGills = CubeListBuilder.create()
				.texOffs(0, 40).addBox(-3.0F, -7.0F, 8.0F, 3.0F, 7.0F, 0.0F, cubedeformation);
		CubeListBuilder rightGills = CubeListBuilder.create()
				.texOffs(11, 40).addBox(0.0F, -7.0F, 8.0F, 3.0F, 7.0F, 0.0F, cubedeformation);
		head.addOrReplaceChild("top_gills", topGills, PartPose.offset(0.0F, -3.0F, -1.0F));
		head.addOrReplaceChild("left_gills", leftGills, PartPose.offset(-4.0F, 0.0F, -1.0F));
		head.addOrReplaceChild("right_gills", rightGills, PartPose.offset(4.0F, 0.0F, -1.0F));

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createAxolotlHead();
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
