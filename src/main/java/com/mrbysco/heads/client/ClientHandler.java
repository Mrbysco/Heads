package com.mrbysco.heads.client;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.client.ber.HeadsBlockRenderer;
import com.mrbysco.heads.client.models.AllaySkullModel;
import com.mrbysco.heads.client.models.AxolotlSkullModel;
import com.mrbysco.heads.client.models.BatSkullModel;
import com.mrbysco.heads.client.models.BeeSkullModel;
import com.mrbysco.heads.client.models.ChickenSkullModel;
import com.mrbysco.heads.client.models.CodSkullModel;
import com.mrbysco.heads.client.models.CowSkullModel;
import com.mrbysco.heads.client.models.DolphinSkullModel;
import com.mrbysco.heads.client.models.EndermanSkullModel;
import com.mrbysco.heads.client.models.EndermiteSkullModel;
import com.mrbysco.heads.client.models.FoxSkullModel;
import com.mrbysco.heads.client.models.GoatSkullModel;
import com.mrbysco.heads.client.models.HeadModelBase;
import com.mrbysco.heads.client.models.HoglinSkullModel;
import com.mrbysco.heads.client.models.HorseSkullModel;
import com.mrbysco.heads.client.models.IllagerSkullModel;
import com.mrbysco.heads.client.models.IronGolemSkullModel;
import com.mrbysco.heads.client.models.LayeredSkullModel;
import com.mrbysco.heads.client.models.MagmaCubeSkullModel;
import com.mrbysco.heads.client.models.MooshroomSkullModel;
import com.mrbysco.heads.client.models.OcelotSkullModel;
import com.mrbysco.heads.client.models.PigSkullModel;
import com.mrbysco.heads.client.models.PiglinSkullModel;
import com.mrbysco.heads.client.models.SalmonSkullModel;
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
import com.mrbysco.heads.client.renderer.HeadsSpecialRenderer;
import com.mrbysco.heads.registry.HeadReg;
import com.mrbysco.heads.registry.HeadTypes;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterSpecialBlockModelRendererEvent;
import net.neoforged.neoforge.client.event.RegisterSpecialModelRendererEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = Heads.MOD_ID)
public class ClientHandler {
	public static final ModelLayerLocation ALLAY = new ModelLayerLocation(Heads.modLoc("allay"), "head");
	public static final ModelLayerLocation AXOLOTL = new ModelLayerLocation(Heads.modLoc("axolotl"), "head");
	public static final ModelLayerLocation BAT = new ModelLayerLocation(Heads.modLoc("bat"), "head");
	public static final ModelLayerLocation BEE = new ModelLayerLocation(Heads.modLoc("bee"), "head");
	public static final ModelLayerLocation BLAZE = new ModelLayerLocation(Heads.modLoc("blaze"), "head");
	public static final ModelLayerLocation CAT = new ModelLayerLocation(Heads.modLoc("cat"), "head");
	public static final ModelLayerLocation CAVE_SPIDER = new ModelLayerLocation(Heads.modLoc("cave_spider"), "head");
	public static final ModelLayerLocation CHICKEN = new ModelLayerLocation(Heads.modLoc("chicken"), "head");
	public static final ModelLayerLocation COD = new ModelLayerLocation(Heads.modLoc("cod"), "head");
	public static final ModelLayerLocation COW = new ModelLayerLocation(Heads.modLoc("cow"), "head");
	public static final ModelLayerLocation DOLPHIN = new ModelLayerLocation(Heads.modLoc("dolphin"), "head");
	public static final ModelLayerLocation DONKEY = new ModelLayerLocation(Heads.modLoc("donkey"), "head");
	public static final ModelLayerLocation DROWNED = new ModelLayerLocation(Heads.modLoc("drowned"), "head");
	public static final ModelLayerLocation ENDERMAN = new ModelLayerLocation(Heads.modLoc("enderman"), "head");
	public static final ModelLayerLocation ENDERMITE = new ModelLayerLocation(Heads.modLoc("endermite"), "head");
	public static final ModelLayerLocation EVOKER = new ModelLayerLocation(Heads.modLoc("evoker"), "head");
	public static final ModelLayerLocation FOX = new ModelLayerLocation(Heads.modLoc("fox"), "head");
	public static final ModelLayerLocation GHAST = new ModelLayerLocation(Heads.modLoc("ghast"), "head");
	public static final ModelLayerLocation GLOW_SQUID = new ModelLayerLocation(Heads.modLoc("glow_squid"), "head");
	public static final ModelLayerLocation GOAT = new ModelLayerLocation(Heads.modLoc("goat"), "head");
	public static final ModelLayerLocation HOGLIN = new ModelLayerLocation(Heads.modLoc("hoglin"), "head");
	public static final ModelLayerLocation HORSE = new ModelLayerLocation(Heads.modLoc("horse"), "head");
	public static final ModelLayerLocation HUSK = new ModelLayerLocation(Heads.modLoc("husk"), "head");
	public static final ModelLayerLocation ILLUSIONER = new ModelLayerLocation(Heads.modLoc("illusioner"), "head");
	public static final ModelLayerLocation IRON_GOLEM = new ModelLayerLocation(Heads.modLoc("iron_golem"), "head");
	public static final ModelLayerLocation MAGMA_CUBE = new ModelLayerLocation(Heads.modLoc("magma_cube"), "head");
	public static final ModelLayerLocation MULE = new ModelLayerLocation(Heads.modLoc("mule"), "head");
	public static final ModelLayerLocation MOOSHROOM_BROWN = new ModelLayerLocation(Heads.modLoc("brown_mooshroom"), "head");
	public static final ModelLayerLocation MOOSHROOM_RED = new ModelLayerLocation(Heads.modLoc("red_mooshroom"), "head");
	public static final ModelLayerLocation OCELOT = new ModelLayerLocation(Heads.modLoc("ocelot"), "head");
	public static final ModelLayerLocation PIG = new ModelLayerLocation(Heads.modLoc("pig"), "head");
	public static final ModelLayerLocation PIGLIN_BRUTE = new ModelLayerLocation(Heads.modLoc("piglin_brute"), "head");
	public static final ModelLayerLocation PILLAGER = new ModelLayerLocation(Heads.modLoc("pillager"), "head");
	public static final ModelLayerLocation SALMON = new ModelLayerLocation(Heads.modLoc("salmon"), "head");
	public static final ModelLayerLocation SHEEP = new ModelLayerLocation(Heads.modLoc("sheep"), "head");
	public static final ModelLayerLocation SHEEP_FUR = new ModelLayerLocation(Heads.modLoc("sheep_fur"), "head");
	public static final ModelLayerLocation SILVERFISH = new ModelLayerLocation(Heads.modLoc("silverfish"), "head");
	public static final ModelLayerLocation SLIME = new ModelLayerLocation(Heads.modLoc("slime"), "head");
	public static final ModelLayerLocation SNOW_GOLEM = new ModelLayerLocation(Heads.modLoc("snow_golem"), "head");
	public static final ModelLayerLocation SPIDER = new ModelLayerLocation(Heads.modLoc("spider"), "head");
	public static final ModelLayerLocation SQUID = new ModelLayerLocation(Heads.modLoc("squid"), "head");
	public static final ModelLayerLocation STRAY = new ModelLayerLocation(Heads.modLoc("stray"), "head");
	public static final ModelLayerLocation TURTLE = new ModelLayerLocation(Heads.modLoc("turtle"), "head");
	public static final ModelLayerLocation VILLAGER = new ModelLayerLocation(Heads.modLoc("villager"), "head");
	public static final ModelLayerLocation VINDICATOR = new ModelLayerLocation(Heads.modLoc("vindicator"), "head");
	public static final ModelLayerLocation WANDERING_TRADER = new ModelLayerLocation(Heads.modLoc("wandering_trader"), "head");
	public static final ModelLayerLocation WITCH = new ModelLayerLocation(Heads.modLoc("witch"), "head");
	public static final ModelLayerLocation WOLF = new ModelLayerLocation(Heads.modLoc("wolf"), "head");
	public static final ModelLayerLocation ZOGLIN = new ModelLayerLocation(Heads.modLoc("zoglin"), "head");
	public static final ModelLayerLocation ZOMBIE_VILLAGER = new ModelLayerLocation(Heads.modLoc("zombie_villager"), "head");
	public static final ModelLayerLocation ZOMBIFIED_PIGLIN = new ModelLayerLocation(Heads.modLoc("zombified_piglin"), "skull");

	@SubscribeEvent
	public static void registerSpecialModelRenderers(RegisterSpecialModelRendererEvent event) {
		event.register(Heads.modLoc("head"), HeadsSpecialRenderer.Unbaked.MAP_CODEC);
	}

	@SubscribeEvent
	static void registerLayerDefinitions(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(HeadsRegistry.HEAD.get(), HeadsBlockRenderer::new);
	}

	@SubscribeEvent
	static void registerSpecialBlockModelRenderer(RegisterSpecialBlockModelRendererEvent event) {
		for (HeadReg reg : HeadsRegistry.headList) {
			event.register(reg.getHead().get(), new HeadsSpecialRenderer.Unbaked(reg.getHeadType()));
			event.register(reg.getWallHead().get(), new HeadsSpecialRenderer.Unbaked(reg.getHeadType()));
		}
	}

	@SubscribeEvent
	static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ALLAY, AllaySkullModel::createSkullModel);
		event.registerLayerDefinition(AXOLOTL, AxolotlSkullModel::createSkullModel);
		event.registerLayerDefinition(BAT, BatSkullModel::createSkullModel);
		event.registerLayerDefinition(BEE, BeeSkullModel::createSkullModel);
		event.registerLayerDefinition(BLAZE, SkullModel::createMobHeadLayer);
		event.registerLayerDefinition(CAT, OcelotSkullModel::createSkullModel);
		event.registerLayerDefinition(CAVE_SPIDER, SpiderSkullModel::createSkullModel);
		event.registerLayerDefinition(CHICKEN, ChickenSkullModel::createSkullModel);
		event.registerLayerDefinition(COD, CodSkullModel::createSkullModel);
		event.registerLayerDefinition(COW, CowSkullModel::createSkullModel);
		event.registerLayerDefinition(DOLPHIN, DolphinSkullModel::createSkullModel);
		event.registerLayerDefinition(DONKEY, HorseSkullModel::createDonkeySkull);
		event.registerLayerDefinition(DROWNED, LayeredSkullModel::createSkullModel);
		event.registerLayerDefinition(ENDERMAN, EndermanSkullModel::createSkullModel);
		event.registerLayerDefinition(ENDERMITE, EndermiteSkullModel::createSkullModel);
		event.registerLayerDefinition(EVOKER, IllagerSkullModel::createIllagerSkullModel);
		event.registerLayerDefinition(FOX, FoxSkullModel::createSkullModel);
		event.registerLayerDefinition(GHAST, () -> HeadModelBase.createMobHead(32, 16));
		event.registerLayerDefinition(GLOW_SQUID, SquidSkullModel::createSkullModel);
		event.registerLayerDefinition(GOAT, GoatSkullModel::createSkullModel);
		event.registerLayerDefinition(HOGLIN, HoglinSkullModel::createSkullModel);
		event.registerLayerDefinition(HORSE, HorseSkullModel::createHorseSkull);
		event.registerLayerDefinition(HUSK, SkullModel::createHumanoidHeadLayer);
		event.registerLayerDefinition(ILLUSIONER, IllagerSkullModel::createIllagerSkullModel);
		event.registerLayerDefinition(IRON_GOLEM, IronGolemSkullModel::createSkullModel);
		event.registerLayerDefinition(MAGMA_CUBE, MagmaCubeSkullModel::createSkullModel);
		event.registerLayerDefinition(MULE, HorseSkullModel::createMuleSkull);
		event.registerLayerDefinition(MOOSHROOM_BROWN, MooshroomSkullModel::createSkullModel);
		event.registerLayerDefinition(MOOSHROOM_RED, MooshroomSkullModel::createSkullModel);
		event.registerLayerDefinition(OCELOT, OcelotSkullModel::createSkullModel);
		event.registerLayerDefinition(PIG, PigSkullModel::createSkullModel);
		event.registerLayerDefinition(PIGLIN_BRUTE, PiglinSkullModel::createSkullModel);
		event.registerLayerDefinition(PILLAGER, IllagerSkullModel::createIllagerSkullModel);
		event.registerLayerDefinition(SALMON, SalmonSkullModel::createSkullModel);
		event.registerLayerDefinition(SHEEP, SheepSkullModel::createSkullModel);
		event.registerLayerDefinition(SHEEP_FUR, SheepSkullFurModel::createSkullModel);
		event.registerLayerDefinition(SILVERFISH, SilverfishSkullModel::createSkullModel);
		event.registerLayerDefinition(SLIME, SlimeSkullModel::createSkullModel);
		event.registerLayerDefinition(SNOW_GOLEM, () -> HeadModelBase.createMobHead(64, 64));
		event.registerLayerDefinition(SPIDER, SpiderSkullModel::createSkullModel);
		event.registerLayerDefinition(SQUID, SquidSkullModel::createSkullModel);
		event.registerLayerDefinition(STRAY, () -> LayeredSkullModel.createSkullModel(64, 32));
		event.registerLayerDefinition(TURTLE, TurtleSkullModel::createSkullModel);
		event.registerLayerDefinition(VILLAGER, VillagerSkullModel::createVillagerSkullModel);
		event.registerLayerDefinition(VINDICATOR, IllagerSkullModel::createIllagerSkullModel);
		event.registerLayerDefinition(WANDERING_TRADER, VillagerSkullModel::createVillagerSkullModel);
		event.registerLayerDefinition(WITCH, WitchSkullModel::createSkullModel);
		event.registerLayerDefinition(WOLF, WolfSkullModel::createSkullModel);
		event.registerLayerDefinition(ZOGLIN, HoglinSkullModel::createSkullModel);
		event.registerLayerDefinition(ZOMBIE_VILLAGER, VillagerSkullModel::createVillagerSkullModel);
		event.registerLayerDefinition(ZOMBIFIED_PIGLIN, PiglinSkullModel::createSkullModel);
	}

	@SubscribeEvent
	static void registerSkullModel(EntityRenderersEvent.CreateSkullModels event) {
		event.registerSkullModel(HeadTypes.ALLAY, (entityModelSet) -> new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.ALLAY)), ResourceLocation.withDefaultNamespace("textures/entity/allay/allay.png"));
		event.registerSkullModel(HeadTypes.AXOLOTL_BLUE, (entityModelSet) -> new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.AXOLOTL)), ResourceLocation.withDefaultNamespace("textures/entity/axolotl/axolotl_blue.png"));
		event.registerSkullModel(HeadTypes.AXOLOTL_CYAN, (entityModelSet) -> new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.AXOLOTL)), ResourceLocation.withDefaultNamespace("textures/entity/axolotl/axolotl_cyan.png"));
		event.registerSkullModel(HeadTypes.AXOLOTL_GOLD, (entityModelSet) -> new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.AXOLOTL)), ResourceLocation.withDefaultNamespace("textures/entity/axolotl/axolotl_gold.png"));
		event.registerSkullModel(HeadTypes.AXOLOTL_LUCY, (entityModelSet) -> new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.AXOLOTL)), ResourceLocation.withDefaultNamespace("textures/entity/axolotl/axolotl_lucy.png"));
		event.registerSkullModel(HeadTypes.AXOLOTL_WILD, (entityModelSet) -> new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.AXOLOTL)), ResourceLocation.withDefaultNamespace("textures/entity/axolotl/axolotl_wild.png"));
		event.registerSkullModel(HeadTypes.BAT, (entityModelSet) -> new BatSkullModel(entityModelSet.bakeLayer(ClientHandler.BAT)), ResourceLocation.withDefaultNamespace("textures/entity/bat.png"));
		event.registerSkullModel(HeadTypes.BEE, (entityModelSet) -> new BeeSkullModel(entityModelSet.bakeLayer(ClientHandler.BEE)), ResourceLocation.withDefaultNamespace("textures/entity/bee/bee.png"));
		event.registerSkullModel(HeadTypes.BLAZE, (entityModelSet) -> new SkullModel(entityModelSet.bakeLayer(ClientHandler.BLAZE)), ResourceLocation.withDefaultNamespace("textures/entity/blaze.png"));
		event.registerSkullModel(HeadTypes.CAT_ALL_BLACK, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/all_black.png"));
		event.registerSkullModel(HeadTypes.CAT_BLACK, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/black.png"));
		event.registerSkullModel(HeadTypes.CAT_BRITISH_SHORTHAIR, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/british_shorthair.png"));
		event.registerSkullModel(HeadTypes.CAT_CALICO, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/calico.png"));
		event.registerSkullModel(HeadTypes.CAT_JELLIE, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/jellie.png"));
		event.registerSkullModel(HeadTypes.CAT_PERSIAN, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/persian.png"));
		event.registerSkullModel(HeadTypes.CAT_RAGDOLL, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/ragdoll.png"));
		event.registerSkullModel(HeadTypes.CAT_RED, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/red.png"));
		event.registerSkullModel(HeadTypes.CAT_SIAMESE, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/siamese.png"));
		event.registerSkullModel(HeadTypes.CAT_TABBY, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/tabby.png"));
		event.registerSkullModel(HeadTypes.CAT_WHITE, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.CAT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/white.png"));
		event.registerSkullModel(HeadTypes.CAVE_SPIDER, (entityModelSet) -> new SpiderSkullModel(entityModelSet.bakeLayer(ClientHandler.CAVE_SPIDER)), ResourceLocation.withDefaultNamespace("textures/entity/spider/cave_spider.png"));
		event.registerSkullModel(HeadTypes.CHICKEN, (entityModelSet) -> new ChickenSkullModel(entityModelSet.bakeLayer(ClientHandler.CHICKEN)), ResourceLocation.withDefaultNamespace("textures/entity/chicken.png"));
		event.registerSkullModel(HeadTypes.COD, (entityModelSet) -> new CodSkullModel(entityModelSet.bakeLayer(ClientHandler.COD)), ResourceLocation.withDefaultNamespace("textures/entity/fish/cod.png"));
		event.registerSkullModel(HeadTypes.COW, (entityModelSet) -> new CowSkullModel(entityModelSet.bakeLayer(ClientHandler.COW)), ResourceLocation.withDefaultNamespace("textures/entity/cow/temperate_cow.png"));
		event.registerSkullModel(HeadTypes.DOLPHIN, (entityModelSet) -> new DolphinSkullModel(entityModelSet.bakeLayer(ClientHandler.DOLPHIN)), ResourceLocation.withDefaultNamespace("textures/entity/dolphin.png"));
		event.registerSkullModel(HeadTypes.DONKEY, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.DONKEY)), ResourceLocation.withDefaultNamespace("textures/entity/horse/donkey.png"));
		event.registerSkullModel(HeadTypes.DROWNED, (entityModelSet) -> new LayeredSkullModel(entityModelSet.bakeLayer(ClientHandler.DROWNED), ResourceLocation.withDefaultNamespace("textures/entity/zombie/drowned_outer_layer.png")), ResourceLocation.withDefaultNamespace("textures/entity/zombie/drowned.png"));
		event.registerSkullModel(HeadTypes.ENDERMAN, (entityModelSet) -> new EndermanSkullModel(entityModelSet.bakeLayer(ClientHandler.ENDERMAN)), ResourceLocation.withDefaultNamespace("textures/entity/enderman/enderman.png"));
		event.registerSkullModel(HeadTypes.ENDERMITE, (entityModelSet) -> new EndermiteSkullModel(entityModelSet.bakeLayer(ClientHandler.ENDERMITE)), ResourceLocation.withDefaultNamespace("textures/entity/endermite.png"));
		event.registerSkullModel(HeadTypes.EVOKER, (entityModelSet) -> new IllagerSkullModel(entityModelSet.bakeLayer(ClientHandler.EVOKER)), ResourceLocation.withDefaultNamespace("textures/entity/illager/evoker.png"));
		event.registerSkullModel(HeadTypes.FOX, (entityModelSet) -> new FoxSkullModel(entityModelSet.bakeLayer(ClientHandler.FOX)), ResourceLocation.withDefaultNamespace("textures/entity/fox/fox.png"));
		event.registerSkullModel(HeadTypes.FOX_SNOW, (entityModelSet) -> new FoxSkullModel(entityModelSet.bakeLayer(ClientHandler.FOX)), ResourceLocation.withDefaultNamespace("textures/entity/fox/snow_fox.png"));
		event.registerSkullModel(HeadTypes.GHAST, (entityModelSet) -> new HeadModelBase(entityModelSet.bakeLayer(ClientHandler.GHAST)), ResourceLocation.withDefaultNamespace("textures/entity/ghast/ghast.png"));
		event.registerSkullModel(HeadTypes.GLOW_SQUID, (entityModelSet) -> new SquidSkullModel(entityModelSet.bakeLayer(ClientHandler.GLOW_SQUID), true), ResourceLocation.withDefaultNamespace("textures/entity/squid/glow_squid.png"));
		event.registerSkullModel(HeadTypes.GOAT, (entityModelSet) -> new GoatSkullModel(entityModelSet.bakeLayer(ClientHandler.GOAT)), ResourceLocation.withDefaultNamespace("textures/entity/goat/goat.png"));
		event.registerSkullModel(HeadTypes.HOGLIN, (entityModelSet) -> new HoglinSkullModel(entityModelSet.bakeLayer(ClientHandler.HOGLIN)), ResourceLocation.withDefaultNamespace("textures/entity/hoglin/hoglin.png"));
		event.registerSkullModel(HeadTypes.HORSE_BLACK, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)), ResourceLocation.withDefaultNamespace("textures/entity/horse/horse_black.png"));
		event.registerSkullModel(HeadTypes.HORSE_BROWN, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)), ResourceLocation.withDefaultNamespace("textures/entity/horse/horse_brown.png"));
		event.registerSkullModel(HeadTypes.HORSE_CHESTNUT, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)), ResourceLocation.withDefaultNamespace("textures/entity/horse/horse_chestnut.png"));
		event.registerSkullModel(HeadTypes.HORSE_CREAMY, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)), ResourceLocation.withDefaultNamespace("textures/entity/horse/horse_creamy.png"));
		event.registerSkullModel(HeadTypes.HORSE_DARKBROWN, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)), ResourceLocation.withDefaultNamespace("textures/entity/horse/horse_darkbrown.png"));
		event.registerSkullModel(HeadTypes.HORSE_GRAY, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)), ResourceLocation.withDefaultNamespace("textures/entity/horse/horse_gray.png"));
		event.registerSkullModel(HeadTypes.HORSE_SKELETON, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)), ResourceLocation.withDefaultNamespace("textures/entity/horse/horse_skeleton.png"));
		event.registerSkullModel(HeadTypes.HORSE_UNDEAD, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)), ResourceLocation.withDefaultNamespace("textures/entity/horse/horse_zombie.png"));
		event.registerSkullModel(HeadTypes.HORSE_WHITE, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.HORSE)), ResourceLocation.withDefaultNamespace("textures/entity/horse/horse_white.png"));
		event.registerSkullModel(HeadTypes.HUSK, (entityModelSet) -> new SkullModel(entityModelSet.bakeLayer(ClientHandler.HUSK)), ResourceLocation.withDefaultNamespace("textures/entity/zombie/husk.png"));
		event.registerSkullModel(HeadTypes.ILLUSIONER, (entityModelSet) -> new IllagerSkullModel(entityModelSet.bakeLayer(ClientHandler.ILLUSIONER)), ResourceLocation.withDefaultNamespace("textures/entity/illager/illusioner.png"));
		event.registerSkullModel(HeadTypes.IRON_GOLEM, (entityModelSet) -> new IronGolemSkullModel(entityModelSet.bakeLayer(ClientHandler.IRON_GOLEM)), ResourceLocation.withDefaultNamespace("textures/entity/iron_golem/iron_golem.png"));
		event.registerSkullModel(HeadTypes.MAGMA_CUBE, (entityModelSet) -> new MagmaCubeSkullModel(entityModelSet.bakeLayer(ClientHandler.MAGMA_CUBE)), ResourceLocation.withDefaultNamespace("textures/entity/slime/magmacube.png"));
		event.registerSkullModel(HeadTypes.MULE, (entityModelSet) -> new HorseSkullModel(entityModelSet.bakeLayer(ClientHandler.MULE)), ResourceLocation.withDefaultNamespace("textures/entity/horse/mule.png"));
		event.registerSkullModel(HeadTypes.MOOSHROOM_BROWN, (entityModelSet) -> new MooshroomSkullModel(entityModelSet.bakeLayer(ClientHandler.MOOSHROOM_BROWN), false), ResourceLocation.withDefaultNamespace("textures/entity/cow/brown_mooshroom.png"));
		event.registerSkullModel(HeadTypes.MOOSHROOM_RED, (entityModelSet) -> new MooshroomSkullModel(entityModelSet.bakeLayer(ClientHandler.MOOSHROOM_RED), true), ResourceLocation.withDefaultNamespace("textures/entity/cow/red_mooshroom.png"));
		event.registerSkullModel(HeadTypes.OCELOT, (entityModelSet) -> new OcelotSkullModel(entityModelSet.bakeLayer(ClientHandler.OCELOT)), ResourceLocation.withDefaultNamespace("textures/entity/cat/ocelot.png"));
		event.registerSkullModel(HeadTypes.PIG, (entityModelSet) -> new PigSkullModel(entityModelSet.bakeLayer(ClientHandler.PIG)), ResourceLocation.withDefaultNamespace("textures/entity/pig/temperate_pig.png"));
		event.registerSkullModel(HeadTypes.PIGLIN_BRUTE, (entityModelSet) -> new PiglinSkullModel(entityModelSet.bakeLayer(ClientHandler.PIGLIN_BRUTE)), ResourceLocation.withDefaultNamespace("textures/entity/piglin/piglin_brute.png"));
		event.registerSkullModel(HeadTypes.PILLAGER, (entityModelSet) -> new IllagerSkullModel(entityModelSet.bakeLayer(ClientHandler.PILLAGER)), ResourceLocation.withDefaultNamespace("textures/entity/illager/pillager.png"));
		event.registerSkullModel(HeadTypes.SALMON, (entityModelSet) -> new SalmonSkullModel(entityModelSet.bakeLayer(ClientHandler.SALMON)), ResourceLocation.withDefaultNamespace("textures/entity/fish/salmon.png"));
		event.registerSkullModel(HeadTypes.SHEEP_BLACK, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_BLUE, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_BROWN, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_CYAN, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_GRAY, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_GREEN, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_LIGHT_BLUE, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_LIGHT_GRAY, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_LIME, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_MAGENTA, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_ORANGE, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_PINK, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_PURPLE, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_RED, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_SHAVEN, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_WHITE, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SHEEP_YELLOW, (entityModelSet) -> new SheepSkullModel(entityModelSet.bakeLayer(ClientHandler.SHEEP)), ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		event.registerSkullModel(HeadTypes.SILVERFISH, (entityModelSet) -> new SilverfishSkullModel(entityModelSet.bakeLayer(ClientHandler.SILVERFISH)), ResourceLocation.withDefaultNamespace("textures/entity/silverfish.png"));
		event.registerSkullModel(HeadTypes.SLIME, (entityModelSet) -> new SlimeSkullModel(entityModelSet.bakeLayer(ClientHandler.SLIME)), ResourceLocation.withDefaultNamespace("textures/entity/slime/slime.png"));
		event.registerSkullModel(HeadTypes.SNOW_GOLEM, (entityModelSet) -> new HeadModelBase(entityModelSet.bakeLayer(ClientHandler.SNOW_GOLEM)), ResourceLocation.withDefaultNamespace("textures/entity/snow_golem.png"));
		event.registerSkullModel(HeadTypes.SPIDER, (entityModelSet) -> new SpiderSkullModel(entityModelSet.bakeLayer(ClientHandler.SPIDER)), ResourceLocation.withDefaultNamespace("textures/entity/spider/spider.png"));
		event.registerSkullModel(HeadTypes.SQUID, (entityModelSet) -> new SquidSkullModel(entityModelSet.bakeLayer(ClientHandler.SQUID), false), ResourceLocation.withDefaultNamespace("textures/entity/squid/squid.png"));
		event.registerSkullModel(HeadTypes.STRAY, (entityModelSet) -> new LayeredSkullModel(entityModelSet.bakeLayer(ClientHandler.STRAY), ResourceLocation.withDefaultNamespace("textures/entity/skeleton/stray_overlay.png")), ResourceLocation.withDefaultNamespace("textures/entity/skeleton/stray.png"));
		event.registerSkullModel(HeadTypes.TURTLE, (entityModelSet) -> new TurtleSkullModel(entityModelSet.bakeLayer(ClientHandler.TURTLE)), ResourceLocation.withDefaultNamespace("textures/entity/turtle/big_sea_turtle.png"));
		event.registerSkullModel(HeadTypes.VILLAGER, (entityModelSet) -> new VillagerSkullModel(entityModelSet.bakeLayer(ClientHandler.VILLAGER)), ResourceLocation.withDefaultNamespace("textures/entity/villager/villager.png"));
		event.registerSkullModel(HeadTypes.VINDICATOR, (entityModelSet) -> new IllagerSkullModel(entityModelSet.bakeLayer(ClientHandler.VINDICATOR)), ResourceLocation.withDefaultNamespace("textures/entity/illager/vindicator.png"));
		event.registerSkullModel(HeadTypes.WANDERING_TRADER, (entityModelSet) -> new VillagerSkullModel(entityModelSet.bakeLayer(ClientHandler.WANDERING_TRADER)), ResourceLocation.withDefaultNamespace("textures/entity/wandering_trader.png"));
		event.registerSkullModel(HeadTypes.WITCH, (entityModelSet) -> new WitchSkullModel(entityModelSet.bakeLayer(ClientHandler.WITCH)), ResourceLocation.withDefaultNamespace("textures/entity/witch.png"));
		event.registerSkullModel(HeadTypes.WOLF, (entityModelSet) -> new WolfSkullModel(entityModelSet.bakeLayer(ClientHandler.WOLF)), ResourceLocation.withDefaultNamespace("textures/entity/wolf/wolf.png"));
		event.registerSkullModel(HeadTypes.ZOGLIN, (entityModelSet) -> new HoglinSkullModel(entityModelSet.bakeLayer(ClientHandler.ZOGLIN)), ResourceLocation.withDefaultNamespace("textures/entity/hoglin/zoglin.png"));
		event.registerSkullModel(HeadTypes.ZOMBIE_VILLAGER, (entityModelSet) -> new VillagerSkullModel(entityModelSet.bakeLayer(ClientHandler.ZOMBIE_VILLAGER)), ResourceLocation.withDefaultNamespace("textures/entity/zombie_villager/zombie_villager.png"));
		event.registerSkullModel(HeadTypes.ZOMBIFIED_PIGLIN, (entityModelSet) -> new PiglinSkullModel(entityModelSet.bakeLayer(ClientHandler.ZOMBIFIED_PIGLIN)), ResourceLocation.withDefaultNamespace("textures/entity/piglin/zombified_piglin.png"));
	}
}
