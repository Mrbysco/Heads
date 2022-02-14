package com.mrbysco.heads.handler;

import com.mrbysco.heads.util.HeadUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class DropHandler {
	public static void onLivingDrop(LivingDropsEvent event) {
		LivingEntity livingEntity = event.getEntityLiving();
		ItemStack headStack = HeadUtil.getStackForEntity(livingEntity, event.getSource(), event.getLootingLevel());
		if(!headStack.isEmpty()) {
			event.getDrops().add(new ItemEntity(livingEntity.level, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), headStack));
		}
	}
}
