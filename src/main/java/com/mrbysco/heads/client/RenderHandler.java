package com.mrbysco.heads.client;

import com.mrbysco.heads.registry.HeadTypes;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

@EventBusSubscriber(Dist.CLIENT)
public class RenderHandler {
	@SubscribeEvent
	public static <T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> void onArmorRender(RenderLivingEvent.Pre<T, S, M> event) {
		if (event.getRenderState() instanceof HumanoidRenderState humanoidRenderState) {
			if (humanoidRenderState.wornHeadType instanceof HeadTypes) {
				if (event.getRenderer().getModel() instanceof HeadedModel headedModel) {
					if (event.getRenderer().getModel() instanceof HumanoidModel<?> humanoidModel) {
						headedModel.getHead().visible = false;
						humanoidModel.hat.visible = false;
					} else {
						headedModel.getHead().visible = false;
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static <T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> void onArmorRenderPost(RenderLivingEvent.Post<T, S, M> event) {
		if (event.getRenderState() instanceof HumanoidRenderState humanoidRenderState) {
			if (!(humanoidRenderState.wornHeadType instanceof HeadTypes)) {
				if (event.getRenderer().getModel() instanceof HeadedModel headedModel) {
					if (event.getRenderer().getModel() instanceof HumanoidModel<?> humanoidModel) {
						headedModel.getHead().visible = true;
						humanoidModel.hat.visible = true;
					} else {
						headedModel.getHead().visible = true;
					}
				}
			}
		}
	}
}