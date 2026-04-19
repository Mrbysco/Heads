package com.mrbysco.heads.client.ber;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrbysco.heads.client.ClientHandler;
import com.mrbysco.heads.client.HeadBlockRenderState;
import com.mrbysco.heads.client.models.SheepSkullFurModel;
import com.mrbysco.heads.registry.HeadTypes;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.object.skull.SkullModelBase;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.blockentity.state.SkullBlockRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class HeadsBlockRenderer extends SkullBlockRenderer {
	private final EntityModelSet entityModelSet;

	public HeadsBlockRenderer(BlockEntityRendererProvider.Context context) {
		super(context);
		this.entityModelSet = context.entityModelSet();
	}

	@Override
	public SkullBlockRenderState createRenderState() {
		return new HeadBlockRenderState();
	}

	@Override
	public void extractRenderState(SkullBlockEntity blockEntity, SkullBlockRenderState renderState, float partialTick,
	                               Vec3 p_445526_, @Nullable ModelFeatureRenderer.CrumblingOverlay p_446270_) {
		super.extractRenderState(blockEntity, renderState, partialTick, p_445526_, p_446270_);
		if (renderState instanceof HeadBlockRenderState headRenderState && headRenderState.skullType instanceof HeadTypes type && type.isMultiModel()) {
			Identifier skull2Location = getOtherTexture(type);
			headRenderState.renderType2 = getSkullRenderType(type, skull2Location);
		}
	}

	@Override
	public void submit(SkullBlockRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector,
	                   CameraRenderState cameraRenderState) {
		super.submit(renderState, poseStack, nodeCollector, cameraRenderState);
		if (renderState.skullType instanceof HeadTypes type && type.isMultiModel() && renderState instanceof HeadBlockRenderState headRenderState) {
			SkullModelBase model2 = createModel(entityModelSet, type, true);
			submitSkull(
					headRenderState.animationProgress,
					poseStack,
					nodeCollector,
					headRenderState.lightCoords,
					model2,
					headRenderState.renderType2,
					0,
					headRenderState.breakProgress
			);
		}
	}

	@Nullable
	public static Identifier getOtherTexture(HeadTypes type) {
		switch (type) {
			case SHEEP_BLACK, SHEEP_BLUE, SHEEP_BROWN, SHEEP_CYAN, SHEEP_GRAY, SHEEP_GREEN, SHEEP_LIGHT_BLUE,
			     SHEEP_LIGHT_GRAY, SHEEP_LIME, SHEEP_MAGENTA, SHEEP_ORANGE, SHEEP_WHITE, SHEEP_RED, SHEEP_PURPLE,
			     SHEEP_PINK -> {
				return SheepSkullFurModel.SHEEP_FUR_LOCATION;
			}
			default -> {
				return null;
			}
		}
	}

	@Nullable
	public static SkullModelBase createModel(EntityModelSet modelSet, SkullBlock.Type type, boolean secondHead) {
		if (type instanceof HeadTypes headType) {
			return createModel(modelSet, headType, secondHead);
		}
		return null;
	}

	@Nullable
	public static SkullModelBase createModel(EntityModelSet modelSet, HeadTypes type, boolean secondHead) {
		if (type.isMultiModel() && secondHead) {
			switch (type) {
				case SHEEP_BLACK -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.BLACK);
				}
				case SHEEP_BLUE -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.BLUE);
				}
				case SHEEP_BROWN -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.BROWN);
				}
				case SHEEP_CYAN -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.CYAN);
				}
				case SHEEP_GRAY -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.GRAY);
				}
				case SHEEP_GREEN -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.GREEN);
				}
				case SHEEP_LIGHT_BLUE -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.LIGHT_BLUE);
				}
				case SHEEP_LIGHT_GRAY -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.LIGHT_GRAY);
				}
				case SHEEP_LIME -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.LIME);
				}
				case SHEEP_MAGENTA -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.MAGENTA);
				}
				case SHEEP_ORANGE -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.ORANGE);
				}
				case SHEEP_PINK -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.PINK);
				}
				case SHEEP_PURPLE -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.PURPLE);
				}
				case SHEEP_RED -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.RED);
				}
				case SHEEP_WHITE -> {
					return new SheepSkullFurModel(modelSet.bakeLayer(ClientHandler.SHEEP_FUR), DyeColor.WHITE);
				}

				default -> {
					return createModel(modelSet, type);
				}
			}
		}
		return createModel(modelSet, type);
	}
}
