package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.object.skull.SkullModelBase;

public class HeadModelBase extends SkullModelBase {
	protected final ModelPart head;

	public HeadModelBase(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
	}

	public static MeshDefinition createHeadModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
		return meshdefinition;
	}

	public static LayerDefinition createMobHead(int textureWidthIn, int textureHeightIn) {
		MeshDefinition meshdefinition = createHeadModel();
		return LayerDefinition.create(meshdefinition, textureWidthIn, textureHeightIn);
	}

	@Override
	public void setupAnim(State renderState) {
		super.setupAnim(renderState);
		this.head.yRot = renderState.yRot * ((float) Math.PI / 180F);
		this.head.xRot = renderState.xRot * ((float) Math.PI / 180F);
	}
}
