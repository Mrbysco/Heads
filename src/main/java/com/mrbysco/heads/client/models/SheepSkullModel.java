package com.mrbysco.heads.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class SheepSkullModel extends SkullModelBase {
	protected final ModelPart head;
	protected final SheepSkullFurModel furModel;

	public SheepSkullModel(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
		this.furModel = null;
	}

	public SheepSkullModel(ModelPart root, SheepSkullFurModel furModel) {
		super(root);
		this.head = root.getChild("head");
		this.furModel = furModel;
	}

	public static MeshDefinition createSheepHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 6.0F, 8.0F),
				PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createSheepHead();
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(State state) {
		super.setupAnim(state);
		this.head.yRot = state.yRot * ((float) Math.PI / 180F);
		this.head.xRot = state.xRot * ((float) Math.PI / 180F);

		if (furModel != null) {
			furModel.setupAnim(state);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, int color) {
		this.root.render(poseStack, vertexConsumer, packedLightIn, packedOverlayIn, color);

		if (furModel != null) {
			furModel.renderToBuffer(poseStack, vertexConsumer, packedLightIn, packedOverlayIn, color);
		}
	}
}
