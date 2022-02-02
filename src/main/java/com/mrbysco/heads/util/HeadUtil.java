package com.mrbysco.heads.util;

import com.mrbysco.heads.registry.HeadTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class HeadUtil {
	public static ItemStack getStackForEntity(LivingEntity livingEntity, DamageSource damageSource) {
		if(livingEntity.isBaby())
			return ItemStack.EMPTY;

		HeadTypes headType = HeadTypes.getMatchingHead(livingEntity);
		if(headType != null) {
			Entity source = damageSource.getDirectEntity();
			ItemStack headStack = new ItemStack(headType.getHeadItem());
			double dropRate = headType.getDropRate();
			if((headType.canDropFromCreeperExplosion() && source instanceof Creeper creeper && creeper.canDropMobsSkull()) ||
					(livingEntity instanceof Player && dropRate > 0 && (dropRate == 1 || livingEntity.getRandom().nextDouble() <= dropRate))) {
				return headStack;
			}
		}

		return ItemStack.EMPTY;
	}
}
