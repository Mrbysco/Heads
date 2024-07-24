package com.mrbysco.heads.client;

import com.mrbysco.heads.Heads;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

public class RenderHandler {
	public static void onArmorRender(RenderLivingEvent.Pre<? extends LivingEntity, ? extends EntityModel<? extends LivingEntity>> event) {
		final ItemStack headStack = event.getEntity().getItemBySlot(EquipmentSlot.HEAD);
		final ResourceLocation headLocation = BuiltInRegistries.ITEM.getKey(headStack.getItem());
		final boolean isWearingHead = (headLocation != null && headLocation.getNamespace().equals(Heads.MOD_ID));
		if (!isWearingHead) return;
		if (event.getRenderer().getModel() instanceof HeadedModel headedModel) {
			if (event.getRenderer().getModel() instanceof HumanoidModel<?> humanoidModel) {
				headedModel.getHead().visible = false;
				humanoidModel.hat.visible = false;
			} else {
				headedModel.getHead().visible = false;
			}
		}
	}

	public static void onArmorRenderPost(RenderLivingEvent.Post<? extends LivingEntity, ? extends EntityModel<? extends LivingEntity>> event) {
		final ItemStack headStack = event.getEntity().getItemBySlot(EquipmentSlot.HEAD);
		final ResourceLocation headLocation = BuiltInRegistries.ITEM.getKey(headStack.getItem());
		final boolean isWearingHead = (headLocation != null && headLocation.getNamespace().equals(Heads.MOD_ID));
		if (isWearingHead) return;
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