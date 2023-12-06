package com.mrbysco.heads.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;

public class MooshroomSkullModel extends CowSkullModel {
	private final BlockState mushroomState;
	private float yRot = 0.0F;

	public MooshroomSkullModel(ModelPart root, boolean red) {
		super(root);
		mushroomState = red ? Blocks.RED_MUSHROOM.defaultBlockState() : Blocks.BROWN_MUSHROOM.defaultBlockState();
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		super.renderToBuffer(poseStack, vertexConsumer, packedLightIn, packedOverlayIn, red, green, blue, alpha);

		Minecraft minecraft = Minecraft.getInstance();
		BlockRenderDispatcher blockrenderdispatcher = minecraft.getBlockRenderer();
		poseStack.translate(0.0D, -1F, 0.05D);
		poseStack.mulPose(Axis.YP.rotationDegrees(-78.0F));
		poseStack.scale(-1.0F, -1.0F, 1.0F);
		poseStack.translate(-0.5D, -0.5D, -0.5D);
		poseStack.mulPose(Axis.YP.rotationDegrees(yRot * ((float) Math.PI / 180F)));

		blockrenderdispatcher.renderSingleBlock(mushroomState, poseStack, minecraft.renderBuffers().bufferSource(), packedLightIn, packedOverlayIn, ModelData.EMPTY, RenderType.cutout());
	}

	@Override
	public void setupAnim(float mouthAnimation, float yRot, float xRot) {
		super.setupAnim(mouthAnimation, yRot, xRot);
		this.yRot = yRot;
	}
}
