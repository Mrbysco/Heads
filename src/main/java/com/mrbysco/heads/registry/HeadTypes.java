package com.mrbysco.heads.registry;

import com.mrbysco.heads.block.HeadBlock;
import com.mrbysco.heads.config.HeadConfig;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cat;
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
			HeadsRegistry.AXOLOTL_LUCY_HEAD_ITEM, HeadConfig.COMMON.axolotlDropRate::get, HeadConfig.COMMON.axolotlEnableCreeperDrop::get),
	AXOLOTL_WILD((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.WILD,
			HeadsRegistry.AXOLOTL_WILD_HEAD_ITEM, HeadConfig.COMMON.axolotlDropRate::get, HeadConfig.COMMON.axolotlEnableCreeperDrop::get),
	AXOLOTL_GOLD((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.GOLD,
			HeadsRegistry.AXOLOTL_GOLD_HEAD_ITEM, HeadConfig.COMMON.axolotlDropRate::get, HeadConfig.COMMON.axolotlEnableCreeperDrop::get),
	AXOLOTL_CYAN((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.CYAN,
			HeadsRegistry.AXOLOTL_CYAN_HEAD_ITEM, HeadConfig.COMMON.axolotlDropRate::get, HeadConfig.COMMON.axolotlEnableCreeperDrop::get),
	AXOLOTL_BLUE((entity) -> entity.getType() == EntityType.AXOLOTL && ((Axolotl) entity).getVariant() == Axolotl.Variant.BLUE,
			HeadsRegistry.AXOLOTL_BLUE_HEAD_ITEM, HeadConfig.COMMON.axolotlDropRate::get, HeadConfig.COMMON.axolotlEnableCreeperDrop::get),
	BAT((entity) -> entity.getType() == EntityType.BAT,
			HeadsRegistry.BAT_HEAD_ITEM, HeadConfig.COMMON.batDropRate::get, HeadConfig.COMMON.batEnableCreeperDrop::get),
	BEE((entity) -> entity.getType() == EntityType.BEE,
			HeadsRegistry.BAT_HEAD_ITEM, HeadConfig.COMMON.beeDropRate::get, HeadConfig.COMMON.beeEnableCreeperDrop::get),
	BLACK_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BLACK,
			HeadsRegistry.BLACK_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	BLAZE((entity) -> entity.getType() == EntityType.BLAZE,
			HeadsRegistry.BLAZE_HEAD_ITEM, HeadConfig.COMMON.blazeDropRate::get, HeadConfig.COMMON.blazeEnableCreeperDrop::get),
	BLUE_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BLUE,
			HeadsRegistry.BLUE_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	BROWN_MOOSHROOM((entity) -> entity.getType() == EntityType.MOOSHROOM && ((MushroomCow) entity).getMushroomType() == MushroomCow.MushroomType.BROWN,
			HeadsRegistry.BROWN_MOOSHROOM_HEAD_ITEM, HeadConfig.COMMON.mooshroomDropRate::get, HeadConfig.COMMON.mooshroomEnableCreeperDrop::get),
	CAT_TABBY((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 0,
			HeadsRegistry.CAT_TABBY_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_BLACK((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 1,
			HeadsRegistry.CAT_BLACK_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_RED((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 2,
			HeadsRegistry.CAT_RED_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_SIAMESE((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 3,
			HeadsRegistry.CAT_SIAMESE_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_BRITISH_SHORTHAIR((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 4,
			HeadsRegistry.CAT_BRITISH_SHORTHAIR_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_CALICO((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 5,
			HeadsRegistry.CAT_CALICO_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_PERSIAN((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 6,
			HeadsRegistry.CAT_PERSIAN_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_RAGDOLL((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 7,
			HeadsRegistry.CAT_RAGDOLL_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_WHITE((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 8,
			HeadsRegistry.CAT_WHITE_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_JELLIE((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 9,
			HeadsRegistry.CAT_JELLIE_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	CAT_ALL_BLACK((entity) -> entity.getType() == EntityType.CAT && ((Cat) entity).getCatType() == 10,
			HeadsRegistry.CAT_ALL_BLACK_HEAD_ITEM, HeadConfig.COMMON.catDropRate::get, HeadConfig.COMMON.catEnableCreeperDrop::get),
	BROWN_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BROWN,
			HeadsRegistry.BROWN_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	CAVE_SPIDER((entity) -> entity.getType() == EntityType.CAVE_SPIDER,
			HeadsRegistry.CAVE_SPIDER_HEAD_ITEM, HeadConfig.COMMON.caveSpiderDropRate::get, HeadConfig.COMMON.caveSpiderEnableCreeperDrop::get),
	CHICKEN((entity) -> entity.getType() == EntityType.CHICKEN,
			HeadsRegistry.CHICKEN_HEAD_ITEM, HeadConfig.COMMON.chickenDropRate::get, HeadConfig.COMMON.chickenEnableCreeperDrop::get),
	COW((entity) -> entity.getType() == EntityType.COW,
			HeadsRegistry.COW_HEAD_ITEM, HeadConfig.COMMON.cowDropRate::get, HeadConfig.COMMON.cowEnableCreeperDrop::get),
	CYAN_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.CYAN,
			HeadsRegistry.CYAN_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	DONKEY((entity) -> entity.getType() == EntityType.DONKEY,
			HeadsRegistry.DONKEY_HEAD_ITEM, HeadConfig.COMMON.donkeyDropRate::get, HeadConfig.COMMON.donkeyEnableCreeperDrop::get),
	ENDERMAN((entity) -> entity.getType() == EntityType.ENDERMAN,
			HeadsRegistry.ENDERMAN_HEAD_ITEM, HeadConfig.COMMON.endermanDropRate::get, HeadConfig.COMMON.endermanEnableCreeperDrop::get),
	ENDERMITE((entity) -> entity.getType() == EntityType.ENDERMITE,
			HeadsRegistry.ENDERMITE_HEAD_ITEM, HeadConfig.COMMON.endermiteDropRate::get, HeadConfig.COMMON.endermiteEnableCreeperDrop::get),
	FOX((entity) -> entity.getType() == EntityType.FOX && ((Fox) entity).getFoxType() == Fox.Type.RED,
			HeadsRegistry.FOX_HEAD_ITEM, HeadConfig.COMMON.foxDropRate::get, HeadConfig.COMMON.foxEnableCreeperDrop::get),
	FOX_SNOW((entity) -> entity.getType() == EntityType.FOX && ((Fox) entity).getFoxType() == Fox.Type.SNOW,
			HeadsRegistry.FOX_SNOW_HEAD_ITEM, HeadConfig.COMMON.foxDropRate::get, HeadConfig.COMMON.foxEnableCreeperDrop::get),
	GHAST((entity) -> entity.getType() == EntityType.GHAST,
			HeadsRegistry.GHAST_HEAD_ITEM, HeadConfig.COMMON.ghastDropRate::get, HeadConfig.COMMON.ghastEnableCreeperDrop::get),
	GLOW_SQUID((entity) -> entity.getType() == EntityType.GLOW_SQUID,
			HeadsRegistry.GLOW_SQUID_HEAD_ITEM, HeadConfig.COMMON.glowSquidDropRate::get, HeadConfig.COMMON.glowSquidEnableCreeperDrop::get),
	GOAT((entity) -> entity.getType() == EntityType.GOAT,
			HeadsRegistry.GOAT_HEAD_ITEM, HeadConfig.COMMON.goatDropRate::get, HeadConfig.COMMON.goatEnableCreeperDrop::get),
	GRAY_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.GRAY,
			HeadsRegistry.GRAY_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	GREEN_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.GREEN,
			HeadsRegistry.GREEN_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	HORSE_WHITE((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.WHITE,
			HeadsRegistry.HORSE_WHITE_HEAD_ITEM, HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_CREAMY((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.CREAMY,
			HeadsRegistry.HORSE_CREAMY_HEAD_ITEM, HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_CHESTNUT((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.CHESTNUT,
			HeadsRegistry.HORSE_CHESTNUT_HEAD_ITEM, HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_BROWN((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.BROWN,
			HeadsRegistry.HORSE_BROWN_HEAD_ITEM, HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_BLACK((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.BLACK,
			HeadsRegistry.HORSE_BLACK_HEAD_ITEM, HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_GRAY((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.GRAY,
			HeadsRegistry.HORSE_GRAY_HEAD_ITEM, HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_DARKBROWN((entity) -> entity.getType() == EntityType.HORSE && ((Horse) entity).getVariant() == Variant.DARKBROWN,
			HeadsRegistry.HORSE_DARKBROWN_HEAD_ITEM, HeadConfig.COMMON.horseDropRate::get, HeadConfig.COMMON.horseEnableCreeperDrop::get),
	HORSE_UNDEAD((entity) -> entity.getType() == EntityType.ZOMBIE_HORSE,
			HeadsRegistry.HORSE_UNDEAD_HEAD_ITEM, HeadConfig.COMMON.horseUndeadDropRate::get, HeadConfig.COMMON.horseUndeadEnableCreeperDrop::get),
	HORSE_SKELETON((entity) -> entity.getType() == EntityType.SKELETON_HORSE,
			HeadsRegistry.HORSE_SKELETON_HEAD_ITEM, HeadConfig.COMMON.horseSkeletonDropRate::get, HeadConfig.COMMON.horseSkeletonEnableCreeperDrop::get),
	IRON_GOLEM((entity) -> entity.getType() == EntityType.IRON_GOLEM,
			HeadsRegistry.IRON_GOLEM_HEAD_ITEM, HeadConfig.COMMON.ironGolemDropRate::get, HeadConfig.COMMON.ironGolemEnableCreeperDrop::get),
	LIGHT_BLUE_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.BLUE,
			HeadsRegistry.BLUE_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	LIGHT_GRAY_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIGHT_GRAY,
			HeadsRegistry.LIGHT_GRAY_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	LIME_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.LIME,
			HeadsRegistry.LIME_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	MAGENTA_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.MAGENTA,
			HeadsRegistry.MAGENTA_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	MAGMA_CUBE((entity) -> entity.getType() == EntityType.MAGMA_CUBE,
			HeadsRegistry.MAGMA_CUBE_HEAD_ITEM, HeadConfig.COMMON.magmaCubeDropRate::get, HeadConfig.COMMON.magmaCubeEnableCreeperDrop::get),
	OCELOT((entity) -> entity.getType() == EntityType.OCELOT,
			HeadsRegistry.OCELOT_HEAD_ITEM, HeadConfig.COMMON.ocelotDropRate::get, HeadConfig.COMMON.ocelotEnableCreeperDrop::get),
	ORANGE_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.ORANGE,
			HeadsRegistry.ORANGE_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	PIG((entity) -> entity.getType() == EntityType.PIG,
			HeadsRegistry.PIG_HEAD_ITEM, HeadConfig.COMMON.pigDropRate::get, HeadConfig.COMMON.pigEnableCreeperDrop::get),
	PIGLIN((entity) -> entity.getType() == EntityType.PIGLIN,
			HeadsRegistry.PIGLIN_HEAD_ITEM, HeadConfig.COMMON.piglinDropRate::get, HeadConfig.COMMON.piglinEnableCreeperDrop::get),
	PIGLIN_BRUTE((entity) -> entity.getType() == EntityType.PIGLIN_BRUTE,
			HeadsRegistry.PIGLIN_BRUTE_HEAD_ITEM, HeadConfig.COMMON.piglinBruteDropRate::get, HeadConfig.COMMON.piglinBruteEnableCreeperDrop::get),
	PINK_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.PINK,
			HeadsRegistry.PINK_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	PURPLE_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.PURPLE,
			HeadsRegistry.PURPLE_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	RED_MOOSHROOM((entity) -> entity.getType() == EntityType.MOOSHROOM && ((MushroomCow) entity).getMushroomType() == MushroomCow.MushroomType.RED,
			HeadsRegistry.RED_MOOSHROOM_HEAD_ITEM, HeadConfig.COMMON.mooshroomDropRate::get, HeadConfig.COMMON.mooshroomEnableCreeperDrop::get),
	RED_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.RED,
			HeadsRegistry.RED_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.WHITE,
			HeadsRegistry.SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	SHEEP_SHAVEN((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && sheep.isSheared(),
			HeadsRegistry.SHEEP_SHAVEN_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	SILVERFISH((entity) -> entity.getType() == EntityType.SILVERFISH,
			HeadsRegistry.SILVERFISH_HEAD_ITEM, HeadConfig.COMMON.silverfishDropRate::get, HeadConfig.COMMON.silverfishEnableCreeperDrop::get),
	SLIME((entity) -> entity.getType() == EntityType.SLIME,
			HeadsRegistry.SLIME_HEAD_ITEM, HeadConfig.COMMON.slimeDropRate::get, HeadConfig.COMMON.slimeEnableCreeperDrop::get),
	SNOW_GOLEM((entity) -> entity.getType() == EntityType.SNOW_GOLEM,
			HeadsRegistry.SNOW_GOLEM_HEAD_ITEM, HeadConfig.COMMON.snowGolemDropRate::get, HeadConfig.COMMON.snowGolemEnableCreeperDrop::get),
	SPIDER((entity) -> entity.getType() == EntityType.SPIDER,
			HeadsRegistry.SPIDER_HEAD_ITEM, HeadConfig.COMMON.spiderDropRate::get, HeadConfig.COMMON.spiderEnableCreeperDrop::get),
	SQUID((entity) -> entity.getType() == EntityType.SQUID,
			HeadsRegistry.SQUID_HEAD_ITEM, HeadConfig.COMMON.squidDropRate::get, HeadConfig.COMMON.squidEnableCreeperDrop::get),
	TURTLE((entity) -> entity.getType() == EntityType.TURTLE,
			HeadsRegistry.TURTLE_HEAD_ITEM, HeadConfig.COMMON.turtleDropRate::get, HeadConfig.COMMON.turtleEnableCreeperDrop::get),
	VILLAGER((entity) -> entity.getType() == EntityType.VILLAGER,
			HeadsRegistry.VILLAGER_HEAD_ITEM, HeadConfig.COMMON.villagerDropRate::get, HeadConfig.COMMON.villagerEnableCreeperDrop::get),
	WANDERING_TRADER((entity) -> entity.getType() == EntityType.WANDERING_TRADER,
			HeadsRegistry.WANDERING_TRADER_HEAD_ITEM, HeadConfig.COMMON.wanderingTraderDropRate::get, HeadConfig.COMMON.wanderingTraderEnableCreeperDrop::get),
	WITCH((entity) -> entity.getType() == EntityType.WITCH,
			HeadsRegistry.WITCH_HEAD_ITEM, HeadConfig.COMMON.witchDropRate::get, HeadConfig.COMMON.witchEnableCreeperDrop::get),
	WOLF((entity) -> entity.getType() == EntityType.WOLF,
			HeadsRegistry.WOLF_HEAD_ITEM, HeadConfig.COMMON.wolfDropRate::get, HeadConfig.COMMON.wolfEnableCreeperDrop::get),
	YELLOW_SHEEP((entity) -> entity.getType() == EntityType.SHEEP && entity instanceof Sheep sheep && !sheep.isSheared() && sheep.getColor() == DyeColor.YELLOW,
			HeadsRegistry.YELLOW_SHEEP_HEAD_ITEM, HeadConfig.COMMON.sheepDropRate::get, HeadConfig.COMMON.sheepEnableCreeperDrop::get),
	ZOMBIE_VILLAGER((entity) -> entity.getType() == EntityType.ZOMBIE_VILLAGER,
			HeadsRegistry.ZOMBIE_VILLAGER_HEAD_ITEM, HeadConfig.COMMON.zombieVillagerDropRate::get, HeadConfig.COMMON.zombieVillagerEnableCreeperDrop::get),
	ZOMBIFIED_PIGLIN((entity) -> entity.getType() == EntityType.ZOMBIFIED_PIGLIN,
			HeadsRegistry.ZOMBIFIED_PIGLIN_SKULL_ITEM, HeadConfig.COMMON.zombifiedPiglinDropRate::get, HeadConfig.COMMON.zombifiedPiglinEnableCreeperDrop::get);

	private final Predicate<LivingEntity> entityPredicate;
	private final Supplier<Item> headItem;
	private final Supplier<Double> dropRate;
	private final Supplier<Boolean> creeperExplosion;

	HeadTypes(Predicate<LivingEntity> entityPredicate, Supplier<Item> headItemSupplier, Supplier<Double> dropRateSupplier, Supplier<Boolean> creeperExplosionSupplier) {
		this.entityPredicate = entityPredicate;
		this.headItem = headItemSupplier;
		this.dropRate = dropRateSupplier;
		this.creeperExplosion = creeperExplosionSupplier;
	}

	public Predicate<LivingEntity> getEntityPredicate() {
		return entityPredicate;
	}

	public Item getHeadItem() {
		return headItem.get();
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
}
