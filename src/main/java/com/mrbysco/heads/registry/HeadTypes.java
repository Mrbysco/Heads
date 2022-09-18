package com.mrbysco.heads.registry;

import com.mrbysco.heads.block.HeadBlock;
import com.mrbysco.heads.config.HeadConfig;
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
	AXOLOTL_LUCY((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.LUCY,
			HeadConfig.COMMON.axolotlDropRate::get, HeadConfig.COMMON.axolotlEnableCreeperDrop::get),
	AXOLOTL_WILD((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.WILD,
			HeadConfig.COMMON.axolotlDropRate::get, HeadConfig.COMMON.axolotlEnableCreeperDrop::get),
	AXOLOTL_GOLD((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.GOLD,
			HeadConfig.COMMON.axolotlDropRate::get, HeadConfig.COMMON.axolotlEnableCreeperDrop::get),
	AXOLOTL_CYAN((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.CYAN,
			HeadConfig.COMMON.axolotlDropRate::get, HeadConfig.COMMON.axolotlEnableCreeperDrop::get),
	AXOLOTL_BLUE((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.BLUE,
			HeadConfig.COMMON.axolotlDropRate::get, HeadConfig.COMMON.axolotlEnableCreeperDrop::get),
	BAT((entity) -> entity.getType() == EntityType.BAT,
			HeadConfig.COMMON.batDropRate::get, HeadConfig.COMMON.batEnableCreeperDrop::get),
	BEE((entity) -> entity.getType() == EntityType.BEE,
			HeadConfig.COMMON.beeDropRate::get, HeadConfig.COMMON.beeEnableCreeperDrop::get),
	BLACK_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BLACK,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	BLAZE((entity) -> entity.getType() == EntityType.BLAZE,
			HeadConfig.COMMON.blazeDropRate::get, HeadConfig.COMMON.blazeEnableCreeperDrop::get),
	BLUE_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BLUE,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	BROWN_MOOSHROOM((entity) -> entity.getType() == EntityType.MOOSHROOM && ((MushroomCow) entity).getMushroomType() == MushroomCow.MushroomType.BROWN,
			HeadConfig.COMMON.mooshroomDropRate::get, HeadConfig.COMMON.mooshroomEnableCreeperDrop::get),
	CAT_TABBY((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.TABBY,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_BLACK((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.BLACK,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_RED((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.RED,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_SIAMESE((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.SIAMESE,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_BRITISH_SHORTHAIR((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.BRITISH_SHORTHAIR,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_CALICO((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.CALICO,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_PERSIAN((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.PERSIAN,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_RAGDOLL((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.RAGDOLL,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_WHITE((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.WHITE,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_JELLIE((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.JELLIE,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_ALL_BLACK((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatVariant() == CatVariant.ALL_BLACK,
			HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	BROWN_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BROWN,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	CAVE_SPIDER((entity) -> entity.getType() == EntityType.CAVE_SPIDER,
			HeadConfig.COMMON.caveSpiderDropRate::get, HeadConfig.COMMON.caveSpiderEnableCreeperDrop::get),
	CHICKEN((entity) -> entity.getType() == EntityType.CHICKEN,
			HeadConfig.COMMON.chickenDropRate::get, HeadConfig.COMMON.chickenEnableCreeperDrop::get),
	COW((entity) -> entity.getType() == EntityType.COW,
			HeadConfig.COMMON.cowDropRate::get, HeadConfig.COMMON.cowEnableCreeperDrop::get),
	CYAN_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.CYAN,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	DONKEY((entity) -> entity.getType() == EntityType.DONKEY,
			HeadConfig.COMMON.donkeyDropRate::get, HeadConfig.COMMON.donkeyEnableCreeperDrop::get),
	ENDERMAN((entity) -> entity.getType() == EntityType.ENDERMAN,
			HeadConfig.COMMON.endermanDropRate::get, HeadConfig.COMMON.endermanEnableCreeperDrop::get),
	ENDERMITE((entity) -> entity.getType() == EntityType.ENDERMITE,
			HeadConfig.COMMON.endermiteDropRate::get, HeadConfig.COMMON.endermiteEnableCreeperDrop::get),
	FOX((entity) -> entity.getType() == EntityType.FOX && ((Fox) entity).getFoxType() == Fox.Type.RED,
			HeadConfig.COMMON.foxDropRate::get, HeadConfig.COMMON.foxEnableCreeperDrop::get),
	FOX_SNOW((entity) -> entity.getType() == EntityType.FOX && ((Fox) entity).getFoxType() == Fox.Type.SNOW,
			HeadConfig.COMMON.foxDropRate::get, HeadConfig.COMMON.foxEnableCreeperDrop::get),
	GHAST((entity) -> entity.getType() == EntityType.GHAST,
			HeadConfig.COMMON.ghastDropRate::get, HeadConfig.COMMON.ghastEnableCreeperDrop::get),
	GLOW_SQUID((entity) -> entity.getType() == EntityType.GLOW_SQUID,
			HeadConfig.COMMON.glowSquidDropRate::get, HeadConfig.COMMON.glowSquidEnableCreeperDrop::get),
	GOAT((entity) -> entity.getType() == EntityType.GOAT,
			HeadConfig.COMMON.goatDropRate::get, HeadConfig.COMMON.goatEnableCreeperDrop::get),
	GRAY_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.GRAY,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	GREEN_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.GREEN,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	HORSE_WHITE((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.WHITE,
			HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_CREAMY((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.CREAMY,
			HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_CHESTNUT((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.CHESTNUT,
			HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_BROWN((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.BROWN,
			HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_BLACK((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.BLACK,
			HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_GRAY((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.GRAY,
			HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_DARKBROWN((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.DARKBROWN,
			HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_UNDEAD((entity) -> entity.getType() == EntityType.ZOMBIE_HORSE,
			HeadConfig.COMMON.horseUndeadDropRate::get, HeadConfig.COMMON.horseUndeadEnableCreeperDrop::get),
	HORSE_SKELETON((entity) -> entity.getType() == EntityType.SKELETON_HORSE,
			HeadConfig.COMMON.horseSkeletonDropRate::get, HeadConfig.COMMON.horseSkeletonEnableCreeperDrop::get),
	IRON_GOLEM((entity) -> entity.getType() == EntityType.IRON_GOLEM,
			HeadConfig.COMMON.ironGolemDropRate::get, HeadConfig.COMMON.ironGolemEnableCreeperDrop::get),
	LIGHT_BLUE_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIGHT_BLUE,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	LIGHT_GRAY_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIGHT_GRAY,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	LIME_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIME,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	MAGENTA_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.MAGENTA,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	MAGMA_CUBE((entity) -> entity.getType() == EntityType.MAGMA_CUBE,
			HeadConfig.COMMON.magmaCubeDropRate::get, HeadConfig.COMMON.magmaCubeEnableCreeperDrop::get),
	OCELOT((entity) -> entity.getType() == EntityType.OCELOT,
			HeadConfig.COMMON.ocelotDropRate::get, HeadConfig.COMMON.ocelotEnableCreeperDrop::get),
	ORANGE_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.ORANGE,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	PIG((entity) -> entity.getType() == EntityType.PIG,
			HeadConfig.COMMON.pigDropRate::get, HeadConfig.COMMON.pigEnableCreeperDrop::get),
	PIGLIN((entity) -> entity.getType() == EntityType.PIGLIN,
			HeadConfig.COMMON.piglinDropRate::get, HeadConfig.COMMON.piglinEnableCreeperDrop::get),
	PIGLIN_BRUTE((entity) -> entity.getType() == EntityType.PIGLIN_BRUTE,
			HeadConfig.COMMON.piglinBruteDropRate::get, HeadConfig.COMMON.piglinBruteEnableCreeperDrop::get),
	PINK_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.PINK,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	PURPLE_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.PURPLE,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	RED_MOOSHROOM((entity) -> entity.getType() == EntityType.MOOSHROOM && ((MushroomCow) entity).getMushroomType() == MushroomCow.MushroomType.RED,
			HeadConfig.COMMON.mooshroomDropRate::get, HeadConfig.COMMON.mooshroomEnableCreeperDrop::get),
	RED_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.RED,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.WHITE,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	SHEEP_SHAVEN((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && sheep.isSheared(),
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	SILVERFISH((entity) -> entity.getType() == EntityType.SILVERFISH,
			HeadConfig.COMMON.silverfishDropRate::get, HeadConfig.COMMON.silverfishEnableCreeperDrop::get),
	SLIME((entity) -> entity.getType() == EntityType.SLIME,
			HeadConfig.COMMON.slimeDropRate::get, HeadConfig.COMMON.slimeEnableCreeperDrop::get),
	SNOW_GOLEM((entity) -> entity.getType() == EntityType.SNOW_GOLEM,
			HeadConfig.COMMON.snowGolemDropRate::get, HeadConfig.COMMON.snowGolemEnableCreeperDrop::get),
	SPIDER((entity) -> entity.getType() == EntityType.SPIDER,
			HeadConfig.COMMON.spiderDropRate::get, HeadConfig.COMMON.spiderEnableCreeperDrop::get),
	SQUID((entity) -> entity.getType() == EntityType.SQUID,
			HeadConfig.COMMON.squidDropRate::get, HeadConfig.COMMON.squidEnableCreeperDrop::get),
	TURTLE((entity) -> entity.getType() == EntityType.TURTLE,
			HeadConfig.COMMON.turtleDropRate::get, HeadConfig.COMMON.turtleEnableCreeperDrop::get),
	VILLAGER((entity) -> entity.getType() == EntityType.VILLAGER,
			HeadConfig.COMMON.villagerDropRate::get, HeadConfig.COMMON.villagerEnableCreeperDrop::get),
	WANDERING_TRADER((entity) -> entity.getType() == EntityType.WANDERING_TRADER,
			HeadConfig.COMMON.wanderingTraderDropRate::get, HeadConfig.COMMON.wanderingTraderEnableCreeperDrop::get),
	WITCH((entity) -> entity.getType() == EntityType.WITCH,
			HeadConfig.COMMON.witchDropRate::get, HeadConfig.COMMON.witchEnableCreeperDrop::get),
	WOLF((entity) -> entity.getType() == EntityType.WOLF,
			HeadConfig.COMMON.wolfDropRate::get, HeadConfig.COMMON.wolfEnableCreeperDrop::get),
	YELLOW_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.YELLOW,
			HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	ZOMBIE_VILLAGER((entity) -> entity.getType() == EntityType.ZOMBIE_VILLAGER,
			HeadConfig.COMMON.zombieVillagerDropRate::get, HeadConfig.COMMON.zombieVillagerEnableCreeperDrop::get),
	ZOMBIFIED_PIGLIN((entity) -> entity.getType() == EntityType.ZOMBIFIED_PIGLIN,
			HeadConfig.COMMON.zombifiedPiglinDropRate::get, HeadConfig.COMMON.zombifiedPiglinEnableCreeperDrop::get);

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
