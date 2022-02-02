package com.mrbysco.heads.client;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.client.models.AxolotlSkullModel;
import com.mrbysco.heads.client.models.BatSkullModel;
import com.mrbysco.heads.client.models.BeeSkullModel;
import com.mrbysco.heads.client.models.ChickenSkullModel;
import com.mrbysco.heads.client.models.CowSkullModel;
import com.mrbysco.heads.client.models.EndermanSkullModel;
import com.mrbysco.heads.client.models.EndermiteSkullModel;
import com.mrbysco.heads.client.models.FoxSkullModel;
import com.mrbysco.heads.client.models.GoatSkullModel;
import com.mrbysco.heads.client.models.HeadModelBase;
import com.mrbysco.heads.client.models.HorseSkullModel;
import com.mrbysco.heads.client.models.IronGolemSkullModel;
import com.mrbysco.heads.client.models.MagmaCubeSkullModel;
import com.mrbysco.heads.client.models.MooshroomSkullModel;
import com.mrbysco.heads.client.models.OcelotSkullModel;
import com.mrbysco.heads.client.models.PigSkullModel;
import com.mrbysco.heads.client.models.PiglinSkullModel;
import com.mrbysco.heads.client.models.SheepSkullFurModel;
import com.mrbysco.heads.client.models.SheepSkullModel;
import com.mrbysco.heads.client.models.SilverfishSkullModel;
import com.mrbysco.heads.client.models.SlimeSkullModel;
import com.mrbysco.heads.client.models.SpiderSkullModel;
import com.mrbysco.heads.client.models.SquidSkullModel;
import com.mrbysco.heads.client.models.TurtleSkullModel;
import com.mrbysco.heads.client.models.VillagerSkullModel;
import com.mrbysco.heads.client.models.WitchSkullModel;
import com.mrbysco.heads.client.models.WolfSkullModel;
import com.mrbysco.heads.registry.HeadTypes;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Bus.MOD, modid = Heads.MOD_ID)
public class ClientHandler {
	public static final ModelLayerLocation AXOLOTL = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "axolotl"), "head");
	public static final ModelLayerLocation BAT = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "bat"), "head");
	public static final ModelLayerLocation BEE = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "bee"), "head");
	public static final ModelLayerLocation BLAZE = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "blaze"), "head");
	public static final ModelLayerLocation BROWN_MOOSHROOM = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "brown_mooshroom"), "head");
	public static final ModelLayerLocation CAT = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "cat"), "head");
	public static final ModelLayerLocation CAVE_SPIDER = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "cave_spider"), "head");
	public static final ModelLayerLocation CHICKEN = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "chicken"), "head");
	public static final ModelLayerLocation COW = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "cow"), "head");
	public static final ModelLayerLocation DONKEY = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "donkey"), "head");
	public static final ModelLayerLocation ENDERMAN = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "enderman"), "head");
	public static final ModelLayerLocation ENDERMITE = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "endermite"), "head");
	public static final ModelLayerLocation FOX = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "fox"), "head");
	public static final ModelLayerLocation GOAT = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "goat"), "head");
	public static final ModelLayerLocation GHAST = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "ghast"), "head");
	public static final ModelLayerLocation GLOW_SQUID = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "glow_squid"), "head");
	public static final ModelLayerLocation HORSE = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "horse"), "head");
	public static final ModelLayerLocation IRON_GOLEM = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "iron_golem"), "head");
	public static final ModelLayerLocation MAGMA_CUBE = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "magma_cube"), "head");
	public static final ModelLayerLocation OCELOT = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "ocelot"), "head");
	public static final ModelLayerLocation PIG = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "pig"), "head");
	public static final ModelLayerLocation PIGLIN = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "piglin"), "head");
	public static final ModelLayerLocation PIGLIN_BRUTE = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "piglin_brute"), "head");
	public static final ModelLayerLocation RED_MOOSHROOM = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "red_mooshroom"), "head");
	public static final ModelLayerLocation SHEEP = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "sheep"), "head");
	public static final ModelLayerLocation SHEEP_FUR = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "sheep_fur"), "head");
	public static final ModelLayerLocation SILVERFISH = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "silverfish"), "head");
	public static final ModelLayerLocation SLIME = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "slime"), "head");
	public static final ModelLayerLocation SNOW_GOLEM = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "snow_golem"), "head");
	public static final ModelLayerLocation SPIDER = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "spider"), "head");
	public static final ModelLayerLocation SQUID = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "squid"), "head");
	public static final ModelLayerLocation TURTLE = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "turtle"), "head");
	public static final ModelLayerLocation VILLAGER = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "villager"), "head");
	public static final ModelLayerLocation WANDERING_TRADER = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "wandering_trader"), "head");
	public static final ModelLayerLocation WITCH = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "witch"), "head");
	public static final ModelLayerLocation WOLF = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "wolf"), "head");
	public static final ModelLayerLocation ZOMBIE_VILLAGER = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "zombie_villager"), "head");
	public static final ModelLayerLocation ZOMBIFIED_PIGLIN = new ModelLayerLocation(new ResourceLocation(Heads.MOD_ID, "zombified_piglin"), "skull");

	@SubscribeEvent
	static void clientSetupEvent(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.AXOLOTL_LUCY, new ResourceLocation("textures/entity/axolotl/axolotl_lucy.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.AXOLOTL_WILD, new ResourceLocation("textures/entity/axolotl/axolotl_wild.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.AXOLOTL_GOLD, new ResourceLocation("textures/entity/axolotl/axolotl_gold.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.AXOLOTL_CYAN, new ResourceLocation("textures/entity/axolotl/axolotl_cyan.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.AXOLOTL_BLUE, new ResourceLocation("textures/entity/axolotl/axolotl_blue.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.BAT, new ResourceLocation("textures/entity/bat.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.BEE, new ResourceLocation("textures/entity/bee/bee.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.BLAZE, new ResourceLocation("textures/entity/blaze.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.BROWN_MOOSHROOM, new ResourceLocation("textures/entity/cow/brown_mooshroom.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAVE_SPIDER, new ResourceLocation("textures/entity/spider/cave_spider.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_TABBY, new ResourceLocation("textures/entity/cat/tabby.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_BLACK, new ResourceLocation("textures/entity/cat/black.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_RED, new ResourceLocation("textures/entity/cat/red.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_SIAMESE, new ResourceLocation("textures/entity/cat/siamese.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_BRITISH_SHORTHAIR, new ResourceLocation("textures/entity/cat/british_shorthair.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_CALICO, new ResourceLocation("textures/entity/cat/calico.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_PERSIAN, new ResourceLocation("textures/entity/cat/persian.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_RAGDOLL, new ResourceLocation("textures/entity/cat/ragdoll.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_WHITE, new ResourceLocation("textures/entity/cat/white.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_JELLIE, new ResourceLocation("textures/entity/cat/jellie.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CAT_ALL_BLACK, new ResourceLocation("textures/entity/cat/all_black.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CHICKEN, new ResourceLocation("textures/entity/chicken.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.COW, new ResourceLocation("textures/entity/cow/cow.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.DONKEY, new ResourceLocation("textures/entity/horse/donkey.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.ENDERMAN, new ResourceLocation("textures/entity/enderman/enderman.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.ENDERMITE, new ResourceLocation("textures/entity/endermite.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.FOX, new ResourceLocation("textures/entity/fox/fox.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.FOX_SNOW, new ResourceLocation("textures/entity/fox/snow_fox.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.GHAST, new ResourceLocation("textures/entity/ghast/ghast.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.GLOW_SQUID, new ResourceLocation("textures/entity/squid/glow_squid.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.GOAT, new ResourceLocation("textures/entity/goat/goat.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.HORSE_WHITE, new ResourceLocation("textures/entity/horse/horse_white.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.HORSE_CREAMY, new ResourceLocation("textures/entity/horse/horse_creamy.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.HORSE_CHESTNUT, new ResourceLocation("textures/entity/horse/horse_chestnut.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.HORSE_BROWN, new ResourceLocation("textures/entity/horse/horse_brown.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.HORSE_BLACK, new ResourceLocation("textures/entity/horse/horse_black.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.HORSE_GRAY, new ResourceLocation("textures/entity/horse/horse_gray.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.HORSE_DARKBROWN, new ResourceLocation("textures/entity/horse/horse_darkbrown.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.HORSE_UNDEAD, new ResourceLocation("textures/entity/horse/horse_zombie.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.HORSE_SKELETON, new ResourceLocation("textures/entity/horse/horse_skeleton.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.IRON_GOLEM, new ResourceLocation("textures/entity/iron_golem/iron_golem.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.MAGMA_CUBE, new ResourceLocation("textures/entity/slime/magmacube.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.OCELOT, new ResourceLocation("textures/entity/cat/ocelot.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.PIG, new ResourceLocation("textures/entity/pig/pig.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.PIGLIN, new ResourceLocation("textures/entity/piglin/piglin.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.PIGLIN_BRUTE, new ResourceLocation("textures/entity/piglin/piglin_brute.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.RED_MOOSHROOM, new ResourceLocation("textures/entity/cow/red_mooshroom.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.ORANGE_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.MAGENTA_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.LIGHT_BLUE_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.YELLOW_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.LIME_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.PINK_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.GRAY_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.LIGHT_GRAY_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.CYAN_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.PURPLE_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.BLUE_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.BROWN_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.GREEN_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.RED_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.BLACK_SHEEP, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.SHEEP_SHAVEN, new ResourceLocation("textures/entity/sheep/sheep.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.SILVERFISH, new ResourceLocation("textures/entity/silverfish.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.SLIME, new ResourceLocation("textures/entity/slime/slime.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.SNOW_GOLEM, new ResourceLocation("textures/entity/snow_golem.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.SPIDER, new ResourceLocation("textures/entity/spider/spider.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.SQUID, new ResourceLocation("textures/entity/squid/squid.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.TURTLE, new ResourceLocation("textures/entity/turtle/big_sea_turtle.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.VILLAGER, new ResourceLocation("textures/entity/villager/villager.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.WANDERING_TRADER, new ResourceLocation("textures/entity/wandering_trader.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.WITCH, new ResourceLocation("textures/entity/witch.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.WOLF, new ResourceLocation("textures/entity/wolf/wolf.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.ZOMBIE_VILLAGER, new ResourceLocation("textures/entity/zombie_villager/zombie_villager.png"));
			SkullBlockRenderer.SKIN_BY_TYPE.put(HeadTypes.ZOMBIFIED_PIGLIN, new ResourceLocation("textures/entity/piglin/zombified_piglin.png"));
		});
	}

	@SubscribeEvent
	static void registerLayerDefinitions(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(HeadsRegistry.HEAD.get(), SkullBlockRenderer::new);
	}

	@SubscribeEvent
	static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(AXOLOTL, AxolotlSkullModel::createSkullModel);
		event.registerLayerDefinition(BAT, BatSkullModel::createSkullModel);
		event.registerLayerDefinition(BEE, BeeSkullModel::createSkullModel);
		event.registerLayerDefinition(BLAZE, SkullModel::createMobHeadLayer);
		event.registerLayerDefinition(BROWN_MOOSHROOM, MooshroomSkullModel::createSkullModel);
		event.registerLayerDefinition(CAT, OcelotSkullModel::createSkullModel);
		event.registerLayerDefinition(CAVE_SPIDER, SpiderSkullModel::createSkullModel);
		event.registerLayerDefinition(CHICKEN, ChickenSkullModel::createSkullModel);
		event.registerLayerDefinition(COW, CowSkullModel::createSkullModel);
		event.registerLayerDefinition(DONKEY, HorseSkullModel::createDonkeySkull);
		event.registerLayerDefinition(ENDERMAN, EndermanSkullModel::createSkullModel);
		event.registerLayerDefinition(ENDERMITE, EndermiteSkullModel::createSkullModel);
		event.registerLayerDefinition(FOX, FoxSkullModel::createSkullModel);
		event.registerLayerDefinition(GOAT, GoatSkullModel::createSkullModel);
		event.registerLayerDefinition(GHAST, () -> HeadModelBase.createMobHead(32, 16));
		event.registerLayerDefinition(GLOW_SQUID, SquidSkullModel::createSkullModel);
		event.registerLayerDefinition(HORSE, HorseSkullModel::createHorseSkull);
		event.registerLayerDefinition(IRON_GOLEM, IronGolemSkullModel::createSkullModel);
		event.registerLayerDefinition(MAGMA_CUBE, MagmaCubeSkullModel::createSkullModel);
		event.registerLayerDefinition(OCELOT, OcelotSkullModel::createSkullModel);
		event.registerLayerDefinition(PIG, PigSkullModel::createSkullModel);
		event.registerLayerDefinition(PIGLIN, PiglinSkullModel::createSkullModel);
		event.registerLayerDefinition(PIGLIN_BRUTE, PiglinSkullModel::createSkullModel);
		event.registerLayerDefinition(RED_MOOSHROOM, MooshroomSkullModel::createSkullModel);
		event.registerLayerDefinition(SHEEP, SheepSkullModel::createSkullModel);
		event.registerLayerDefinition(SHEEP_FUR, SheepSkullFurModel::createSkullModel);
		event.registerLayerDefinition(SILVERFISH, SilverfishSkullModel::createSkullModel);
		event.registerLayerDefinition(SLIME, SlimeSkullModel::createSkullModel);
		event.registerLayerDefinition(SNOW_GOLEM, () -> HeadModelBase.createMobHead(64, 64));
		event.registerLayerDefinition(SPIDER, SpiderSkullModel::createSkullModel);
		event.registerLayerDefinition(SQUID, SquidSkullModel::createSkullModel);
		event.registerLayerDefinition(TURTLE, TurtleSkullModel::createSkullModel);
		event.registerLayerDefinition(VILLAGER, VillagerSkullModel::createVillagerSkullModel);
		event.registerLayerDefinition(WANDERING_TRADER, VillagerSkullModel::createVillagerSkullModel);
		event.registerLayerDefinition(WITCH, WitchSkullModel::createSkullModel);
		event.registerLayerDefinition(WOLF, WolfSkullModel::createSkullModel);
		event.registerLayerDefinition(ZOMBIE_VILLAGER, VillagerSkullModel::createVillagerSkullModel);
		event.registerLayerDefinition(ZOMBIFIED_PIGLIN, PiglinSkullModel::createSkullModel);
	}
}
