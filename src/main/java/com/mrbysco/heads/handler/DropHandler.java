package com.mrbysco.heads.handler;

import com.mrbysco.heads.util.HeadUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

public class DropHandler {
	public static void onLivingDrop(LivingDropsEvent event) {
		final LivingEntity livingEntity = event.getEntity();
		final Level level = livingEntity.level();

		final int lootLevel = EnchantmentHelper.getEnchantmentLevel(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), livingEntity);
		ItemStack headStack = HeadUtil.getStackForEntity(livingEntity, event.getSource(), lootLevel);
		if (!headStack.isEmpty()) {
			event.getDrops().add(new ItemEntity(livingEntity.level(), livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), headStack));
		}
	}
}
