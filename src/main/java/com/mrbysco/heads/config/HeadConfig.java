package com.mrbysco.heads.config;

import com.mrbysco.heads.Heads;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

public class HeadConfig {
	public static class Common {
		public final HeadInfo axolotl;
		public final HeadInfo bat;
		public final HeadInfo bee;
		public final HeadInfo blaze;
		public final HeadInfo cat;
		public final HeadInfo caveSpider;
		public final HeadInfo chicken;
		public final HeadInfo cod;
		public final HeadInfo cow;
		public final HeadInfo dolphin;
		public final HeadInfo donkey;
		public final HeadInfo drowned;
		public final HeadInfo enderman;
		public final HeadInfo endermite;
		public final HeadInfo evoker;
		public final HeadInfo fox;
		public final HeadInfo ghast;
		public final HeadInfo glowSquid;
		public final HeadInfo goat;
		public final HeadInfo hoglin;
		public final HeadInfo horse;
		public final HeadInfo horseSkeleton;
		public final HeadInfo horseUndead;
		public final HeadInfo husk;
		public final HeadInfo illusioner;
		public final HeadInfo ironGolem;
		public final HeadInfo magmaCube;
		public final HeadInfo mule;
		public final HeadInfo mooshroom;
		public final HeadInfo ocelot;
		public final HeadInfo pig;
		public final HeadInfo piglin;
		public final HeadInfo piglinBrute;
		public final HeadInfo pillager;
		public final HeadInfo salmon;
		public final HeadInfo sheep;
		public final HeadInfo silverfish;
		public final HeadInfo slime;
		public final HeadInfo snowGolem;
		public final HeadInfo spider;
		public final HeadInfo squid;
		public final HeadInfo stray;
		public final HeadInfo turtle;
		public final HeadInfo villager;
		public final HeadInfo vindicator;
		public final HeadInfo wanderingTrader;
		public final HeadInfo witch;
		public final HeadInfo wolf;
		public final HeadInfo zoglin;
		public final HeadInfo zombieVillager;
		public final HeadInfo zombifiedPiglin;

		Common(ModConfigSpec.Builder builder) {
			axolotl = new HeadInfo(builder, "Axolotl", 0.025);
			bat = new HeadInfo(builder, "Bat", 0.025);
			bee = new HeadInfo(builder, "Bee", 0.025);
			blaze = new HeadInfo(builder, "Blaze", 0.025);
			cat = new HeadInfo(builder, "Cat", 0.025);
			caveSpider = new HeadInfo(builder, "Cave Spider", 0.025);
			chicken = new HeadInfo(builder, "Chicken", 0.025);
			cod = new HeadInfo(builder, "Cod", 0.025);
			cow = new HeadInfo(builder, "Cow", 0.025);
			dolphin = new HeadInfo(builder, "Dolphin", 0.025);
			donkey = new HeadInfo(builder, "Donkey", 0.025);
			drowned = new HeadInfo(builder, "Drowned", 0.025);
			enderman = new HeadInfo(builder, "Enderman", 0.025);
			endermite = new HeadInfo(builder, "Endermite", 0.025);
			evoker = new HeadInfo(builder, "Evoker", 0.025);
			fox = new HeadInfo(builder, "Fox", 0.025);
			ghast = new HeadInfo(builder, "Ghast", 0.025);
			glowSquid = new HeadInfo(builder, "Glow Squid", 0.025);
			goat = new HeadInfo(builder, "Goat", 0.025);
			hoglin = new HeadInfo(builder, "Hoglin", 0.025);
			horse = new HeadInfo(builder, "Gorse", 0.025);
			horseSkeleton = new HeadInfo(builder, "Skeleton Horse", 0.025);
			horseUndead = new HeadInfo(builder, "Undead Horse", 0.025);
			husk = new HeadInfo(builder, "Husk", 0.025);
			illusioner = new HeadInfo(builder, "Illusioner", 0.025);
			ironGolem = new HeadInfo(builder, "Iron Golem", 0.025);
			magmaCube = new HeadInfo(builder, "Magma Cube", 0.025);
			mule = new HeadInfo(builder, "Mule", 0.025);
			mooshroom = new HeadInfo(builder, "Mooshroom", 0.025);
			ocelot = new HeadInfo(builder, "Ocelot", 0.025);
			pig = new HeadInfo(builder, "Pig", 0.025);
			piglin = new HeadInfo(builder, "Piglin", 0.025);
			piglinBrute = new HeadInfo(builder, "Piglin Brute", 0.025);
			pillager = new HeadInfo(builder, "Pillager", 0.025);
			salmon = new HeadInfo(builder, "Salmon", 0.025);
			sheep = new HeadInfo(builder, "Sheep", 0.025);
			silverfish = new HeadInfo(builder, "Silverfish", 0.025);
			slime = new HeadInfo(builder, "Slime", 0.025);
			snowGolem = new HeadInfo(builder, "Snow Golem", 0.025);
			spider = new HeadInfo(builder, "Spider", 0.025);
			squid = new HeadInfo(builder, "Squid", 0.025);
			stray = new HeadInfo(builder, "Stray", 0.025);
			turtle = new HeadInfo(builder, "Turtle", 0.025);
			villager = new HeadInfo(builder, "Villager", 0.025);
			vindicator = new HeadInfo(builder, "Vindicator", 0.025);
			wanderingTrader = new HeadInfo(builder, "Wandering Trader", 0.025);
			witch = new HeadInfo(builder, "Witch", 0.025);
			wolf = new HeadInfo(builder, "Wolf", 0.025);
			zoglin = new HeadInfo(builder, "Zoglin", 0.025);
			zombieVillager = new HeadInfo(builder, "Zombie Villager", 0.025);
			zombifiedPiglin = new HeadInfo(builder, "Zombified Piglin", 0.025);
		}
	}

	public static final ModConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfigEvent.Loading configEvent) {
		Heads.LOGGER.debug("Loaded Head's config file {}", configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
		Heads.LOGGER.warn("Head's config just got changed on the file system!");
	}
}
