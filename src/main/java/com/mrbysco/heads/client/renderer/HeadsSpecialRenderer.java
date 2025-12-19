package com.mrbysco.heads.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrbysco.heads.client.ber.HeadsBlockRenderer;
import com.mrbysco.heads.registry.HeadTypes;
import net.minecraft.client.model.object.skull.SkullModelBase;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.SkullBlock;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

public class HeadsSpecialRenderer implements NoDataSpecialModelRenderer {
	private final SkullModelBase model;
	private final SkullModelBase model2;
	private final float animation;
	private final RenderType renderType;
	private final RenderType renderType2;

	public HeadsSpecialRenderer(SkullModelBase model, @Nullable SkullModelBase model2, float animation,
	                            RenderType renderType, @Nullable RenderType renderType2) {
		this.model = model;
		this.model2 = model2;
		this.animation = animation;
		this.renderType = renderType;
		this.renderType2 = renderType2;
	}

	@Override
	public void submit(
			ItemDisplayContext displayContext, PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight,
			int packedOverlay, boolean hasFoil, int outlineColor
	) {
		HeadsBlockRenderer.submitSkull(null, 180.0F, this.animation, poseStack, nodeCollector,
				packedLight, this.model, this.renderType, outlineColor, null);

		if (this.model2 != null && this.renderType2 != null) {
			HeadsBlockRenderer.submitSkull(null, 180.0F, this.animation, poseStack, nodeCollector,
					packedLight, this.model2, this.renderType2, outlineColor, null);
		}
	}

	@Override
	public void getExtents(Consumer<Vector3fc> output) {
		PoseStack posestack = new PoseStack();
		posestack.translate(0.5F, 0.0F, 0.5F);
		posestack.scale(-1.0F, -1.0F, 1.0F);
		SkullModelBase.State skullmodelbase$state = new SkullModelBase.State();
		skullmodelbase$state.animationPos = this.animation;
		skullmodelbase$state.yRot = 180.0F;
		this.model.setupAnim(skullmodelbase$state);
		this.model.root().getExtentsForGui(posestack, output);
		if (this.model2 != null) {
			this.model2.setupAnim(skullmodelbase$state);
			this.model2.root().getExtentsForGui(posestack, output);
		}
	}

	public record Unbaked(SkullBlock.Type kind, Optional<Identifier> textureOverride,
	                      Optional<Identifier> textureOverride2,
	                      float animation) implements SpecialModelRenderer.Unbaked {
		public static final MapCodec<HeadsSpecialRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec(
				instance -> instance.group(
								HeadTypes.CODEC.fieldOf("kind").forGetter(HeadsSpecialRenderer.Unbaked::kind),
								Identifier.CODEC.optionalFieldOf("texture").forGetter(HeadsSpecialRenderer.Unbaked::textureOverride),
								Identifier.CODEC.optionalFieldOf("texture2").forGetter(HeadsSpecialRenderer.Unbaked::textureOverride2),
								Codec.FLOAT.optionalFieldOf("animation", 0.0F).forGetter(HeadsSpecialRenderer.Unbaked::animation)
						)
						.apply(instance, HeadsSpecialRenderer.Unbaked::new)
		);

		public Unbaked(HeadTypes type) {
			this(type, Optional.empty(), Optional.empty(), 0.0F);
		}

		public Unbaked(HeadTypes type, Identifier texture2) {
			this(type, Optional.empty(), Optional.of(texture2), 0.0F);
		}

		@Override
		public MapCodec<HeadsSpecialRenderer.Unbaked> type() {
			return MAP_CODEC;
		}

		@Nullable
		@Override
		public SpecialModelRenderer<?> bake(SpecialModelRenderer.BakingContext context) {
			if (this.kind instanceof HeadTypes headType) {
				SkullModelBase skullmodelbase = HeadsBlockRenderer.createModel(context.entityModelSet(), this.kind);

				Identifier skullLocation = this.textureOverride
						.<Identifier>map(location -> location.withPath(path -> "textures/entity/" + path + ".png"))
						.orElse(null);


				SkullModelBase skullmodelbase2 = null;
				RenderType rendertype2 = null;
				if (headType.isMultiModel()) {
					skullmodelbase2 = HeadsBlockRenderer.createModel(context.entityModelSet(), headType, true);
					Identifier skull2Location = this.textureOverride2
							.orElse(null);

					if (skull2Location != null) {
						rendertype2 = SkullBlockRenderer.getSkullRenderType(this.kind, skull2Location);
					}
				}

				if (skullmodelbase == null) {
					return null;
				} else {
					RenderType rendertype = SkullBlockRenderer.getSkullRenderType(this.kind, skullLocation);
					return new HeadsSpecialRenderer(skullmodelbase, skullmodelbase2, this.animation,
							rendertype, rendertype2);
				}
			}
			return null;
		}
	}
}
