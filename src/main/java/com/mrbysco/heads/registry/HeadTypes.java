package com.mrbysco.heads.registry;

import com.mrbysco.heads.block.HeadBlock;
import com.mrbysco.heads.config.HeadConfig;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Variant;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Predicate;
import java.util.function.Supplier;

public enum HeadTypes implements HeadBlock.Type {
	//	ALLAY((entity) -> entity.getType() == EntityType.ALLAY, HeadConfig.COMMON.allay.dropRate::get, HeadConfig.COMMON.allay.enableCreeperDrop::get),
	AXOLOTL_BLUE((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.BLUE, HeadConfig.COMMON.axolotl.dropRate::get, HeadConfig.COMMON.axolotl.enableCreeperDrop::get),
	AXOLOTL_CYAN((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.CYAN, HeadConfig.COMMON.axolotl.dropRate::get, HeadConfig.COMMON.axolotl.enableCreeperDrop::get),
	AXOLOTL_GOLD((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.GOLD, HeadConfig.COMMON.axolotl.dropRate::get, HeadConfig.COMMON.axolotl.enableCreeperDrop::get),
	AXOLOTL_LUCY((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.LUCY, HeadConfig.COMMON.axolotl.dropRate::get, HeadConfig.COMMON.axolotl.enableCreeperDrop::get),
	AXOLOTL_WILD((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.WILD, HeadConfig.COMMON.axolotl.dropRate::get, HeadConfig.COMMON.axolotl.enableCreeperDrop::get),
	BAT((entity) -> entity.getType() == EntityType.BAT, HeadConfig.COMMON.bat.dropRate::get, HeadConfig.COMMON.bat.enableCreeperDrop::get),
	BEE((entity) -> entity.getType() == EntityType.BEE, HeadConfig.COMMON.bee.dropRate::get, HeadConfig.COMMON.bee.enableCreeperDrop::get),
	BLAZE((entity) -> entity.getType() == EntityType.BLAZE, HeadConfig.COMMON.blaze.dropRate::get, HeadConfig.COMMON.blaze.enableCreeperDrop::get),
	CAT_ALL_BLACK((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.ALL_BLACK, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAT_BLACK((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.BLACK, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAT_BRITISH_SHORTHAIR((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.BRITISH_SHORTHAIR, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAT_CALICO((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.CALICO, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAT_JELLIE((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.JELLIE, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAT_PERSIAN((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.PERSIAN, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAT_RAGDOLL((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.RAGDOLL, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAT_RED((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.RED, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAT_SIAMESE((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.SIAMESE, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAT_TABBY((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.TABBY, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAT_WHITE((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.WHITE, HeadConfig.COMMON.cat.dropRate::get, HeadConfig.COMMON.cat.enableCreeperDrop::get),
	CAVE_SPIDER((entity) -> entity.getType() == EntityType.CAVE_SPIDER, HeadConfig.COMMON.caveSpider.dropRate::get, HeadConfig.COMMON.caveSpider.enableCreeperDrop::get),
	CHICKEN((entity) -> entity.getType() == EntityType.CHICKEN, HeadConfig.COMMON.chicken.dropRate::get, HeadConfig.COMMON.chicken.enableCreeperDrop::get),
	COD((entity) -> entity.getType() == EntityType.COD, HeadConfig.COMMON.cod.dropRate::get, HeadConfig.COMMON.cod.enableCreeperDrop::get),
	COW((entity) -> entity.getType() == EntityType.COW, HeadConfig.COMMON.cow.dropRate::get, HeadConfig.COMMON.cow.enableCreeperDrop::get),
	DOLPHIN((entity) -> entity.getType() == EntityType.DOLPHIN, HeadConfig.COMMON.dolphin.dropRate::get, HeadConfig.COMMON.dolphin.enableCreeperDrop::get),
	DONKEY((entity) -> entity.getType() == EntityType.DONKEY, HeadConfig.COMMON.donkey.dropRate::get, HeadConfig.COMMON.donkey.enableCreeperDrop::get),
	DROWNED((entity) -> entity.getType() == EntityType.DROWNED, HeadConfig.COMMON.drowned.dropRate::get, HeadConfig.COMMON.drowned.enableCreeperDrop::get),
	ENDERMAN((entity) -> entity.getType() == EntityType.ENDERMAN, HeadConfig.COMMON.enderman.dropRate::get, HeadConfig.COMMON.enderman.enableCreeperDrop::get),
	ENDERMITE((entity) -> entity.getType() == EntityType.ENDERMITE, HeadConfig.COMMON.endermite.dropRate::get, HeadConfig.COMMON.endermite.enableCreeperDrop::get),
	EVOKER((entity) -> entity.getType() == EntityType.EVOKER, HeadConfig.COMMON.evoker.dropRate::get, HeadConfig.COMMON.evoker.enableCreeperDrop::get),
	FOX((entity) -> entity.getType() == EntityType.FOX && ((Fox) entity).getVariant() == Fox.Type.RED, HeadConfig.COMMON.fox.dropRate::get, HeadConfig.COMMON.fox.enableCreeperDrop::get),
	FOX_SNOW((entity) -> entity.getType() == EntityType.FOX && ((Fox) entity).getVariant() == Fox.Type.SNOW, HeadConfig.COMMON.fox.dropRate::get, HeadConfig.COMMON.fox.enableCreeperDrop::get),
	GHAST((entity) -> entity.getType() == EntityType.GHAST, HeadConfig.COMMON.ghast.dropRate::get, HeadConfig.COMMON.ghast.enableCreeperDrop::get),
	GLOW_SQUID((entity) -> entity.getType() == EntityType.GLOW_SQUID, HeadConfig.COMMON.glowSquid.dropRate::get, HeadConfig.COMMON.glowSquid.enableCreeperDrop::get),
	GOAT((entity) -> entity.getType() == EntityType.GOAT, HeadConfig.COMMON.goat.dropRate::get, HeadConfig.COMMON.goat.enableCreeperDrop::get),
	HOGLIN((entity) -> entity.getType() == EntityType.HOGLIN, HeadConfig.COMMON.hoglin.dropRate::get, HeadConfig.COMMON.hoglin.enableCreeperDrop::get),
	HORSE_BLACK((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.BLACK, HeadConfig.COMMON.horse.dropRate::get, HeadConfig.COMMON.horse.enableCreeperDrop::get),
	HORSE_BROWN((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.BROWN, HeadConfig.COMMON.horse.dropRate::get, HeadConfig.COMMON.horse.enableCreeperDrop::get),
	HORSE_CHESTNUT((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.CHESTNUT, HeadConfig.COMMON.horse.dropRate::get, HeadConfig.COMMON.horse.enableCreeperDrop::get),
	HORSE_CREAMY((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.CREAMY, HeadConfig.COMMON.horse.dropRate::get, HeadConfig.COMMON.horse.enableCreeperDrop::get),
	HORSE_DARKBROWN((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.DARK_BROWN, HeadConfig.COMMON.horse.dropRate::get, HeadConfig.COMMON.horse.enableCreeperDrop::get),
	HORSE_GRAY((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.GRAY, HeadConfig.COMMON.horse.dropRate::get, HeadConfig.COMMON.horse.enableCreeperDrop::get),
	HORSE_SKELETON((entity) -> entity.getType() == EntityType.SKELETON_HORSE, HeadConfig.COMMON.horseSkeleton.dropRate::get, HeadConfig.COMMON.horseSkeleton.enableCreeperDrop::get),
	HORSE_UNDEAD((entity) -> entity.getType() == EntityType.ZOMBIE_HORSE, HeadConfig.COMMON.horseUndead.dropRate::get, HeadConfig.COMMON.horseUndead.enableCreeperDrop::get),
	HORSE_WHITE((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.WHITE, HeadConfig.COMMON.horse.dropRate::get, HeadConfig.COMMON.horse.enableCreeperDrop::get),
	HUSK((entity) -> entity.getType() == EntityType.HUSK, HeadConfig.COMMON.husk.dropRate::get, HeadConfig.COMMON.husk.enableCreeperDrop::get),
	ILLUSIONER((entity) -> entity.getType() == EntityType.ILLUSIONER, HeadConfig.COMMON.illusioner.dropRate::get, HeadConfig.COMMON.illusioner.enableCreeperDrop::get),
	IRON_GOLEM((entity) -> entity.getType() == EntityType.IRON_GOLEM, HeadConfig.COMMON.ironGolem.dropRate::get, HeadConfig.COMMON.ironGolem.enableCreeperDrop::get),
	MAGMA_CUBE((entity) -> entity.getType() == EntityType.MAGMA_CUBE, HeadConfig.COMMON.magmaCube.dropRate::get, HeadConfig.COMMON.magmaCube.enableCreeperDrop::get),
	MULE((entity) -> entity.getType() == EntityType.MULE, HeadConfig.COMMON.mule.dropRate::get, HeadConfig.COMMON.mule.enableCreeperDrop::get),
	MOOSHROOM_BROWN((entity) -> entity.getType() == EntityType.MOOSHROOM && ((MushroomCow) entity).getVariant() == MushroomCow.MushroomType.BROWN, HeadConfig.COMMON.mooshroom.dropRate::get, HeadConfig.COMMON.mooshroom.enableCreeperDrop::get),
	MOOSHROOM_RED((entity) -> entity.getType() == EntityType.MOOSHROOM && ((MushroomCow) entity).getVariant() == MushroomCow.MushroomType.RED, HeadConfig.COMMON.mooshroom.dropRate::get, HeadConfig.COMMON.mooshroom.enableCreeperDrop::get),
	OCELOT((entity) -> entity.getType() == EntityType.OCELOT, HeadConfig.COMMON.ocelot.dropRate::get, HeadConfig.COMMON.ocelot.enableCreeperDrop::get),
	PIG((entity) -> entity.getType() == EntityType.PIG, HeadConfig.COMMON.pig.dropRate::get, HeadConfig.COMMON.pig.enableCreeperDrop::get),
	PIGLIN((entity) -> entity.getType() == EntityType.PIGLIN, HeadConfig.COMMON.piglin.dropRate::get, HeadConfig.COMMON.piglin.enableCreeperDrop::get),
	PIGLIN_BRUTE((entity) -> entity.getType() == EntityType.PIGLIN_BRUTE, HeadConfig.COMMON.piglinBrute.dropRate::get, HeadConfig.COMMON.piglinBrute.enableCreeperDrop::get),
	PILLAGER((entity) -> entity.getType() == EntityType.PILLAGER, HeadConfig.COMMON.pillager.dropRate::get, HeadConfig.COMMON.pillager.enableCreeperDrop::get),
	SALMON((entity) -> entity.getType() == EntityType.SALMON, HeadConfig.COMMON.salmon.dropRate::get, HeadConfig.COMMON.salmon.enableCreeperDrop::get),
	SHEEP_BLACK((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BLACK, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_BLUE((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BLUE, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_BROWN((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BROWN, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_CYAN((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.CYAN, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_GRAY((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.GRAY, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_GREEN((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.GREEN, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_LIGHT_BLUE((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIGHT_BLUE, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_LIGHT_GRAY((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIGHT_GRAY, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_LIME((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIME, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_MAGENTA((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.MAGENTA, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_ORANGE((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.ORANGE, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_PINK((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.PINK, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_PURPLE((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.PURPLE, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_RED((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.RED, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_SHAVEN((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && sheep.isSheared(), HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_WHITE((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.WHITE, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SHEEP_YELLOW((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.YELLOW, HeadConfig.COMMON.sheep.dropRate::get, HeadConfig.COMMON.sheep.enableCreeperDrop::get),
	SILVERFISH((entity) -> entity.getType() == EntityType.SILVERFISH, HeadConfig.COMMON.silverfish.dropRate::get, HeadConfig.COMMON.silverfish.enableCreeperDrop::get),
	SLIME((entity) -> entity.getType() == EntityType.SLIME, HeadConfig.COMMON.slime.dropRate::get, HeadConfig.COMMON.slime.enableCreeperDrop::get),
	SNOW_GOLEM((entity) -> entity.getType() == EntityType.SNOW_GOLEM, HeadConfig.COMMON.snowGolem.dropRate::get, HeadConfig.COMMON.snowGolem.enableCreeperDrop::get),
	SPIDER((entity) -> entity.getType() == EntityType.SPIDER, HeadConfig.COMMON.spider.dropRate::get, HeadConfig.COMMON.spider.enableCreeperDrop::get),
	SQUID((entity) -> entity.getType() == EntityType.SQUID, HeadConfig.COMMON.squid.dropRate::get, HeadConfig.COMMON.squid.enableCreeperDrop::get),
	STRAY((entity) -> entity.getType() == EntityType.STRAY, HeadConfig.COMMON.stray.dropRate::get, HeadConfig.COMMON.stray.enableCreeperDrop::get),
	TURTLE((entity) -> entity.getType() == EntityType.TURTLE, HeadConfig.COMMON.turtle.dropRate::get, HeadConfig.COMMON.turtle.enableCreeperDrop::get),
	VILLAGER((entity) -> entity.getType() == EntityType.VILLAGER, HeadConfig.COMMON.villager.dropRate::get, HeadConfig.COMMON.villager.enableCreeperDrop::get),
	VINDICATOR((entity) -> entity.getType() == EntityType.VINDICATOR, HeadConfig.COMMON.vindicator.dropRate::get, HeadConfig.COMMON.vindicator.enableCreeperDrop::get),
	WANDERING_TRADER((entity) -> entity.getType() == EntityType.WANDERING_TRADER, HeadConfig.COMMON.wanderingTrader.dropRate::get, HeadConfig.COMMON.wanderingTrader.enableCreeperDrop::get),
	WITCH((entity) -> entity.getType() == EntityType.WITCH, HeadConfig.COMMON.witch.dropRate::get, HeadConfig.COMMON.witch.enableCreeperDrop::get),
	WOLF((entity) -> entity.getType() == EntityType.WOLF, HeadConfig.COMMON.wolf.dropRate::get, HeadConfig.COMMON.wolf.enableCreeperDrop::get),
	ZOGLIN((entity) -> entity.getType() == EntityType.ZOGLIN, HeadConfig.COMMON.zoglin.dropRate::get, HeadConfig.COMMON.zoglin.enableCreeperDrop::get),
	ZOMBIE_VILLAGER((entity) -> entity.getType() == EntityType.ZOMBIE_VILLAGER, HeadConfig.COMMON.zombieVillager.dropRate::get, HeadConfig.COMMON.zombieVillager.enableCreeperDrop::get),
	ZOMBIFIED_PIGLIN((entity) -> entity.getType() == EntityType.ZOMBIFIED_PIGLIN, HeadConfig.COMMON.zombifiedPiglin.dropRate::get, HeadConfig.COMMON.zombifiedPiglin.enableCreeperDrop::get);

	private final Predicate<LivingEntity> entityPredicate;
	private final Supplier<Double> dropRate;
	private final Supplier<Boolean> creeperExplosion;

	HeadTypes(Predicate<LivingEntity> entityPredicate, Supplier<Double> dropRateSupplier, Supplier<Boolean> creeperExplosionSupplier) {
		this.entityPredicate = entityPredicate;
		this.dropRate = dropRateSupplier;
		this.creeperExplosion = creeperExplosionSupplier;
	}

	public Predicate<LivingEntity> getEntityPredicate() {
		return entityPredicate;
	}

	public double getDropRate() {
		return dropRate.get();
	}

	public boolean canDropFromCreeperExplosion() {
		return creeperExplosion.get();
	}

	@Nullable
	public static HeadTypes getMatchingHead(@Nonnull LivingEntity livingEntity) {
		for (HeadTypes headType : values()) {
			if (headType.getEntityPredicate().test(livingEntity)) {
				return headType;
			}
		}
		return null;
	}

	public Item getHeadItem() {
		return HeadsRegistry.headMap.get(this).getHeadItem().get();
	}
}
