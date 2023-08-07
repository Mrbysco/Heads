package com.mrbysco.heads.client;

import com.mrbysco.heads.Heads;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class RenderHandler {
	public static void onArmorRender(RenderLivingEvent event) {
		final ItemStack headStack = event.getEntity().getItemBySlot(EquipmentSlot.HEAD);
		final ResourceLocation headLocation = ForgeRegistries.ITEMS.getKey(headStack.getItem());
		final boolean isWearingHead = (headLocation != null && headLocation.getNamespace().equals(Heads.MOD_ID));
		if (event.getRenderer().getModel() instanceof HeadedModel headedModel) {
			if (event.getRenderer().getModel() instanceof HumanoidModel<?> humanoidModel) {
				headedModel.getHead().visible = !isWearingHead;
				humanoidModel.hat.visible = !isWearingHead;
			} else {
				headedModel.getHead().visible = !isWearingHead;
			}
		}
	}
}