package com.mrbysco.heads.client;

import com.mrbysco.heads.Heads;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;

public class RenderHandler {
	public static void onArmorRender(RenderLivingEvent event) {
		final ItemStack headStack = event.getEntity().getItemBySlot(EquipmentSlot.HEAD);
		final boolean isWearingHead = (headStack.getItem().getRegistryName() != null && headStack.getItem().getRegistryName().getNamespace().equals(Heads.MOD_ID));
		if (event.getRenderer().getModel() instanceof HeadedModel headedModel && isWearingHead) {
			if (event.getRenderer().getModel() instanceof HumanoidModel<?> humanoidModel) {
				headedModel.getHead().visible = false;
				humanoidModel.hat.visible = false;
			} else {
				headedModel.getHead().visible = !isWearingHead;
			}
		}
	}
}