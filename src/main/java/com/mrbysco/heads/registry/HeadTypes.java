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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.function.Predicate;
import java.util.function.Supplier;

public enum HeadTypes implements HeadBlock.Type {
	//	ALLAY((entity) -> entity.getType() == EntityType.ALLAY, HeadConfig.COMMON.allay.dropRate, HeadConfig.COMMON.allay.enableCreeperDrop),
	AXOLOTL_BLUE((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.BLUE, HeadConfig.COMMON.axolotl.dropRate, HeadConfig.COMMON.axolotl.enableCreeperDrop),
	AXOLOTL_CYAN((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.CYAN, HeadConfig.COMMON.axolotl.dropRate, HeadConfig.COMMON.axolotl.enableCreeperDrop),
	AXOLOTL_GOLD((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.GOLD, HeadConfig.COMMON.axolotl.dropRate, HeadConfig.COMMON.axolotl.enableCreeperDrop),
	AXOLOTL_LUCY((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.LUCY, HeadConfig.COMMON.axolotl.dropRate, HeadConfig.COMMON.axolotl.enableCreeperDrop),
	AXOLOTL_WILD((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.WILD, HeadConfig.COMMON.axolotl.dropRate, HeadConfig.COMMON.axolotl.enableCreeperDrop),
	BAT((entity) -> entity.getType() == EntityType.BAT, HeadConfig.COMMON.bat.dropRate, HeadConfig.COMMON.bat.enableCreeperDrop),
	BEE((entity) -> entity.getType() == EntityType.BEE, HeadConfig.COMMON.bee.dropRate, HeadConfig.COMMON.bee.enableCreeperDrop),
	BLAZE((entity) -> entity.getType() == EntityType.BLAZE, HeadConfig.COMMON.blaze.dropRate, HeadConfig.COMMON.blaze.enableCreeperDrop),
	CAT_ALL_BLACK((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.ALL_BLACK, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAT_BLACK((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.BLACK, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAT_BRITISH_SHORTHAIR((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.BRITISH_SHORTHAIR, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAT_CALICO((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.CALICO, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAT_JELLIE((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.JELLIE, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAT_PERSIAN((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.PERSIAN, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAT_RAGDOLL((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.RAGDOLL, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAT_RED((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.RED, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAT_SIAMESE((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.SIAMESE, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAT_TABBY((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.TABBY, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAT_WHITE((entity) -> entity.getType() == EntityType.CAT && BuiltInRegistries.CAT_VARIANT.getResourceKey(((Cat) entity).getVariant()).orElse(null) == CatVariant.WHITE, HeadConfig.COMMON.cat.dropRate, HeadConfig.COMMON.cat.enableCreeperDrop),
	CAVE_SPIDER((entity) -> entity.getType() == EntityType.CAVE_SPIDER, HeadConfig.COMMON.caveSpider.dropRate, HeadConfig.COMMON.caveSpider.enableCreeperDrop),
	CHICKEN((entity) -> entity.getType() == EntityType.CHICKEN, HeadConfig.COMMON.chicken.dropRate, HeadConfig.COMMON.chicken.enableCreeperDrop),
	COD((entity) -> entity.getType() == EntityType.COD, HeadConfig.COMMON.cod.dropRate, HeadConfig.COMMON.cod.enableCreeperDrop),
	COW((entity) -> entity.getType() == EntityType.COW, HeadConfig.COMMON.cow.dropRate, HeadConfig.COMMON.cow.enableCreeperDrop),
	DOLPHIN((entity) -> entity.getType() == EntityType.DOLPHIN, HeadConfig.COMMON.dolphin.dropRate, HeadConfig.COMMON.dolphin.enableCreeperDrop),
	DONKEY((entity) -> entity.getType() == EntityType.DONKEY, HeadConfig.COMMON.donkey.dropRate, HeadConfig.COMMON.donkey.enableCreeperDrop),
	DROWNED((entity) -> entity.getType() == EntityType.DROWNED, HeadConfig.COMMON.drowned.dropRate, HeadConfig.COMMON.drowned.enableCreeperDrop),
	ENDERMAN((entity) -> entity.getType() == EntityType.ENDERMAN, HeadConfig.COMMON.enderman.dropRate, HeadConfig.COMMON.enderman.enableCreeperDrop),
	ENDERMITE((entity) -> entity.getType() == EntityType.ENDERMITE, HeadConfig.COMMON.endermite.dropRate, HeadConfig.COMMON.endermite.enableCreeperDrop),
	EVOKER((entity) -> entity.getType() == EntityType.EVOKER, HeadConfig.COMMON.evoker.dropRate, HeadConfig.COMMON.evoker.enableCreeperDrop),
	FOX((entity) -> entity.getType() == EntityType.FOX && ((Fox) entity).getVariant() == Fox.Type.RED, HeadConfig.COMMON.fox.dropRate, HeadConfig.COMMON.fox.enableCreeperDrop),
	FOX_SNOW((entity) -> entity.getType() == EntityType.FOX && ((Fox) entity).getVariant() == Fox.Type.SNOW, HeadConfig.COMMON.fox.dropRate, HeadConfig.COMMON.fox.enableCreeperDrop),
	GHAST((entity) -> entity.getType() == EntityType.GHAST, HeadConfig.COMMON.ghast.dropRate, HeadConfig.COMMON.ghast.enableCreeperDrop),
	GLOW_SQUID((entity) -> entity.getType() == EntityType.GLOW_SQUID, HeadConfig.COMMON.glowSquid.dropRate, HeadConfig.COMMON.glowSquid.enableCreeperDrop),
	GOAT((entity) -> entity.getType() == EntityType.GOAT, HeadConfig.COMMON.goat.dropRate, HeadConfig.COMMON.goat.enableCreeperDrop),
	HOGLIN((entity) -> entity.getType() == EntityType.HOGLIN, HeadConfig.COMMON.hoglin.dropRate, HeadConfig.COMMON.hoglin.enableCreeperDrop),
	HORSE_BLACK((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.BLACK, HeadConfig.COMMON.horse.dropRate, HeadConfig.COMMON.horse.enableCreeperDrop),
	HORSE_BROWN((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.BROWN, HeadConfig.COMMON.horse.dropRate, HeadConfig.COMMON.horse.enableCreeperDrop),
	HORSE_CHESTNUT((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.CHESTNUT, HeadConfig.COMMON.horse.dropRate, HeadConfig.COMMON.horse.enableCreeperDrop),
	HORSE_CREAMY((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.CREAMY, HeadConfig.COMMON.horse.dropRate, HeadConfig.COMMON.horse.enableCreeperDrop),
	HORSE_DARKBROWN((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.DARK_BROWN, HeadConfig.COMMON.horse.dropRate, HeadConfig.COMMON.horse.enableCreeperDrop),
	HORSE_GRAY((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.GRAY, HeadConfig.COMMON.horse.dropRate, HeadConfig.COMMON.horse.enableCreeperDrop),
	HORSE_SKELETON((entity) -> entity.getType() == EntityType.SKELETON_HORSE, HeadConfig.COMMON.horseSkeleton.dropRate, HeadConfig.COMMON.horseSkeleton.enableCreeperDrop),
	HORSE_UNDEAD((entity) -> entity.getType() == EntityType.ZOMBIE_HORSE, HeadConfig.COMMON.horseUndead.dropRate, HeadConfig.COMMON.horseUndead.enableCreeperDrop),
	HORSE_WHITE((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.WHITE, HeadConfig.COMMON.horse.dropRate, HeadConfig.COMMON.horse.enableCreeperDrop),
	HUSK((entity) -> entity.getType() == EntityType.HUSK, HeadConfig.COMMON.husk.dropRate, HeadConfig.COMMON.husk.enableCreeperDrop),
	ILLUSIONER((entity) -> entity.getType() == EntityType.ILLUSIONER, HeadConfig.COMMON.illusioner.dropRate, HeadConfig.COMMON.illusioner.enableCreeperDrop),
	IRON_GOLEM((entity) -> entity.getType() == EntityType.IRON_GOLEM, HeadConfig.COMMON.ironGolem.dropRate, HeadConfig.COMMON.ironGolem.enableCreeperDrop),
	MAGMA_CUBE((entity) -> entity.getType() == EntityType.MAGMA_CUBE, HeadConfig.COMMON.magmaCube.dropRate, HeadConfig.COMMON.magmaCube.enableCreeperDrop),
	MULE((entity) -> entity.getType() == EntityType.MULE, HeadConfig.COMMON.mule.dropRate, HeadConfig.COMMON.mule.enableCreeperDrop),
	MOOSHROOM_BROWN((entity) -> entity.getType() == EntityType.MOOSHROOM && ((MushroomCow) entity).getVariant() == MushroomCow.MushroomType.BROWN, HeadConfig.COMMON.mooshroom.dropRate, HeadConfig.COMMON.mooshroom.enableCreeperDrop),
	MOOSHROOM_RED((entity) -> entity.getType() == EntityType.MOOSHROOM && ((MushroomCow) entity).getVariant() == MushroomCow.MushroomType.RED, HeadConfig.COMMON.mooshroom.dropRate, HeadConfig.COMMON.mooshroom.enableCreeperDrop),
	OCELOT((entity) -> entity.getType() == EntityType.OCELOT, HeadConfig.COMMON.ocelot.dropRate, HeadConfig.COMMON.ocelot.enableCreeperDrop),
	PIG((entity) -> entity.getType() == EntityType.PIG, HeadConfig.COMMON.pig.dropRate, HeadConfig.COMMON.pig.enableCreeperDrop),
	PIGLIN((entity) -> entity.getType() == EntityType.PIGLIN, HeadConfig.COMMON.piglin.dropRate, HeadConfig.COMMON.piglin.enableCreeperDrop),
	PIGLIN_BRUTE((entity) -> entity.getType() == EntityType.PIGLIN_BRUTE, HeadConfig.COMMON.piglinBrute.dropRate, HeadConfig.COMMON.piglinBrute.enableCreeperDrop),
	PILLAGER((entity) -> entity.getType() == EntityType.PILLAGER, HeadConfig.COMMON.pillager.dropRate, HeadConfig.COMMON.pillager.enableCreeperDrop),
	SALMON((entity) -> entity.getType() == EntityType.SALMON, HeadConfig.COMMON.salmon.dropRate, HeadConfig.COMMON.salmon.enableCreeperDrop),
	SHEEP_BLACK((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BLACK, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_BLUE((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BLUE, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_BROWN((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BROWN, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_CYAN((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.CYAN, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_GRAY((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.GRAY, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_GREEN((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.GREEN, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_LIGHT_BLUE((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIGHT_BLUE, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_LIGHT_GRAY((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIGHT_GRAY, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_LIME((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIME, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_MAGENTA((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.MAGENTA, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_ORANGE((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.ORANGE, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_PINK((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.PINK, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_PURPLE((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.PURPLE, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_RED((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.RED, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_SHAVEN((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && sheep.isSheared(), HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_WHITE((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.WHITE, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SHEEP_YELLOW((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.YELLOW, HeadConfig.COMMON.sheep.dropRate, HeadConfig.COMMON.sheep.enableCreeperDrop),
	SILVERFISH((entity) -> entity.getType() == EntityType.SILVERFISH, HeadConfig.COMMON.silverfish.dropRate, HeadConfig.COMMON.silverfish.enableCreeperDrop),
	SLIME((entity) -> entity.getType() == EntityType.SLIME, HeadConfig.COMMON.slime.dropRate, HeadConfig.COMMON.slime.enableCreeperDrop),
	SNOW_GOLEM((entity) -> entity.getType() == EntityType.SNOW_GOLEM, HeadConfig.COMMON.snowGolem.dropRate, HeadConfig.COMMON.snowGolem.enableCreeperDrop),
	SPIDER((entity) -> entity.getType() == EntityType.SPIDER, HeadConfig.COMMON.spider.dropRate, HeadConfig.COMMON.spider.enableCreeperDrop),
	SQUID((entity) -> entity.getType() == EntityType.SQUID, HeadConfig.COMMON.squid.dropRate, HeadConfig.COMMON.squid.enableCreeperDrop),
	STRAY((entity) -> entity.getType() == EntityType.STRAY, HeadConfig.COMMON.stray.dropRate, HeadConfig.COMMON.stray.enableCreeperDrop),
	TURTLE((entity) -> entity.getType() == EntityType.TURTLE, HeadConfig.COMMON.turtle.dropRate, HeadConfig.COMMON.turtle.enableCreeperDrop),
	VILLAGER((entity) -> entity.getType() == EntityType.VILLAGER, HeadConfig.COMMON.villager.dropRate, HeadConfig.COMMON.villager.enableCreeperDrop),
	VINDICATOR((entity) -> entity.getType() == EntityType.VINDICATOR, HeadConfig.COMMON.vindicator.dropRate, HeadConfig.COMMON.vindicator.enableCreeperDrop),
	WANDERING_TRADER((entity) -> entity.getType() == EntityType.WANDERING_TRADER, HeadConfig.COMMON.wanderingTrader.dropRate, HeadConfig.COMMON.wanderingTrader.enableCreeperDrop),
	WITCH((entity) -> entity.getType() == EntityType.WITCH, HeadConfig.COMMON.witch.dropRate, HeadConfig.COMMON.witch.enableCreeperDrop),
	WOLF((entity) -> entity.getType() == EntityType.WOLF, HeadConfig.COMMON.wolf.dropRate, HeadConfig.COMMON.wolf.enableCreeperDrop),
	ZOGLIN((entity) -> entity.getType() == EntityType.ZOGLIN, HeadConfig.COMMON.zoglin.dropRate, HeadConfig.COMMON.zoglin.enableCreeperDrop),
	ZOMBIE_VILLAGER((entity) -> entity.getType() == EntityType.ZOMBIE_VILLAGER, HeadConfig.COMMON.zombieVillager.dropRate, HeadConfig.COMMON.zombieVillager.enableCreeperDrop),
	ZOMBIFIED_PIGLIN((entity) -> entity.getType() == EntityType.ZOMBIFIED_PIGLIN, HeadConfig.COMMON.zombifiedPiglin.dropRate, HeadConfig.COMMON.zombifiedPiglin.enableCreeperDrop);

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
	public static HeadTypes getMatchingHead(@NotNull LivingEntity livingEntity) {
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

	@Override
	public String getSerializedName() {
		return name().toLowerCase(Locale.ROOT);
	}
}
