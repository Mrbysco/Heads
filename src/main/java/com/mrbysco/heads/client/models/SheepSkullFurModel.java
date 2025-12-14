package com.mrbysco.heads.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

public class SheepSkullFurModel extends SkullModelBase {
	private static final ResourceLocation SHEEP_FUR_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep_fur.png");
	private final ModelPart root;
	protected final ModelPart head;
	protected final DyeColor color;

	public SheepSkullFurModel(ModelPart root, DyeColor color) {
		super(root);
		this.root = root;
		this.head = root.getChild("head");

		this.color = color;
	}

	public static MeshDefinition createSheepHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-3.0F, -6.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.6F)),
				PartPose.ZERO);

		return meshdefinition;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createSheepHead();
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(State renderState) {
		super.setupAnim(renderState);
		this.head.yRot = renderState.yRot * (float) (Math.PI / 180.0);
		this.head.xRot = renderState.xRot * (float) (Math.PI / 180.0);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, int color) {
		Minecraft minecraft = Minecraft.getInstance();
		RenderType renderType = RenderType.entityCutoutNoCullZOffset(SHEEP_FUR_LOCATION);
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		VertexConsumer furConsumer = bufferSource.getBuffer(renderType);

		this.root.render(poseStack, furConsumer, packedLightIn, packedOverlayIn, this.color.getTextureDiffuseColor());
	}
}
