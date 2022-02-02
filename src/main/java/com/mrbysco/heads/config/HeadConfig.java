package com.mrbysco.heads.config;

import com.mrbysco.heads.Heads;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

public class HeadConfig {
	public static class Common {
		public final BooleanValue axolotlEnableCreeperDrop;
		public final BooleanValue batEnableCreeperDrop;
		public final BooleanValue beeEnableCreeperDrop;
		public final BooleanValue blazeEnableCreeperDrop;
		public final BooleanValue catEnableCreeperDrop;
		public final BooleanValue caveSpiderEnableCreeperDrop;
		public final BooleanValue chickenEnableCreeperDrop;
		public final BooleanValue cowEnableCreeperDrop;
		public final BooleanValue donkeyEnableCreeperDrop;
		public final BooleanValue endermanEnableCreeperDrop;
		public final BooleanValue endermiteEnableCreeperDrop;
		public final BooleanValue foxEnableCreeperDrop;
		public final BooleanValue ghastEnableCreeperDrop;
		public final BooleanValue glowSquidEnableCreeperDrop;
		public final BooleanValue goatEnableCreeperDrop;
		public final BooleanValue horseEnableCreeperDrop;
		public final BooleanValue horseSkeletonEnableCreeperDrop;
		public final BooleanValue horseUndeadEnableCreeperDrop;
		public final BooleanValue ironGolemEnableCreeperDrop;
		public final BooleanValue magmaCubeEnableCreeperDrop;
		public final BooleanValue mooshroomEnableCreeperDrop;
		public final BooleanValue ocelotEnableCreeperDrop;
		public final BooleanValue pigEnableCreeperDrop;
		public final BooleanValue piglinEnableCreeperDrop;
		public final BooleanValue piglinBruteEnableCreeperDrop;
		public final BooleanValue sheepEnableCreeperDrop;
		public final BooleanValue silverfishEnableCreeperDrop;
		public final BooleanValue slimeEnableCreeperDrop;
		public final BooleanValue snowGolemEnableCreeperDrop;
		public final BooleanValue spiderEnableCreeperDrop;
		public final BooleanValue squidEnableCreeperDrop;
		public final BooleanValue turtleEnableCreeperDrop;
		public final BooleanValue villagerEnableCreeperDrop;
		public final BooleanValue wanderingTraderEnableCreeperDrop;
		public final BooleanValue witchEnableCreeperDrop;
		public final BooleanValue wolfEnableCreeperDrop;
		public final BooleanValue zombieVillagerEnableCreeperDrop;
		public final BooleanValue zombifiedPiglinEnableCreeperDrop;

		public final DoubleValue axolotlDropRate;
		public final DoubleValue batDropRate;
		public final DoubleValue beeDropRate;
		public final DoubleValue blazeDropRate;
		public final DoubleValue catDropRate;
		public final DoubleValue caveSpiderDropRate;
		public final DoubleValue chickenDropRate;
		public final DoubleValue cowDropRate;
		public final DoubleValue donkeyDropRate;
		public final DoubleValue endermanDropRate;
		public final DoubleValue endermiteDropRate;
		public final DoubleValue foxDropRate;
		public final DoubleValue ghastDropRate;
		public final DoubleValue glowSquidDropRate;
		public final DoubleValue goatDropRate;
		public final DoubleValue horseDropRate;
		public final DoubleValue horseSkeletonDropRate;
		public final DoubleValue horseUndeadDropRate;
		public final DoubleValue ironGolemDropRate;
		public final DoubleValue magmaCubeDropRate;
		public final DoubleValue mooshroomDropRate;
		public final DoubleValue ocelotDropRate;
		public final DoubleValue pigDropRate;
		public final DoubleValue piglinDropRate;
		public final DoubleValue piglinBruteDropRate;
		public final DoubleValue sheepDropRate;
		public final DoubleValue silverfishDropRate;
		public final DoubleValue slimeDropRate;
		public final DoubleValue snowGolemDropRate;
		public final DoubleValue spiderDropRate;
		public final DoubleValue squidDropRate;
		public final DoubleValue turtleDropRate;
		public final DoubleValue villagerDropRate;
		public final DoubleValue wanderingTraderDropRate;
		public final DoubleValue witchDropRate;
		public final DoubleValue wolfDropRate;
		public final DoubleValue zombieVillagerDropRate;
		public final DoubleValue zombifiedPiglinDropRate;

		Common(ForgeConfigSpec.Builder builder) {
			builder.comment("Drop Rate")
					.push("DropRate");

			axolotlEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Axolotl head")
					.define("axolotlEnableCreeperDrop", true);

			batEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Bat head")
					.define("batEnableCreeperDrop", true);

			beeEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Bee head")
					.define("beeEnableCreeperDrop", true);

			blazeEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Blaze head")
					.define("blazeEnableCreeperDrop", true);

			catEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Cat head")
					.define("catEnableCreeperDrop", true);

			caveSpiderEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Cave Spider head")
					.define("caveSpiderEnableCreeperDrop", true);

			chickenEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Chicken head")
					.define("chickenEnableCreeperDrop", true);

			cowEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Cow head")
					.define("cowEnableCreeperDrop", true);

			donkeyEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Donkey head")
					.define("donkeyEnableCreeperDrop", true);

			endermanEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Enderman head")
					.define("endermanEnableCreeperDrop", true);

			endermiteEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Endermite head")
					.define("endermiteEnableCreeperDrop", true);

			foxEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Fox head")
					.define("foxEnableCreeperDrop", true);

			ghastEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Ghast head")
					.define("ghastEnableCreeperDrop", true);

			glowSquidEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Glow Squid head")
					.define("glowSquidEnableCreeperDrop", true);

			goatEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Goat head")
					.define("goatEnableCreeperDrop", true);

			horseEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Horse head")
					.define("horseEnableCreeperDrop", true);

			horseSkeletonEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Skeleton Horse head")
					.define("horseSkeletonEnableCreeperDrop", true);

			horseUndeadEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Zombie Horse head")
					.define("horseUndeadEnableCreeperDrop", true);

			ironGolemEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Iron Golem head")
					.define("ironGolemEnableCreeperDrop", true);

			magmaCubeEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Magma Cube head")
					.define("magmaCubeEnableCreeperDrop", true);

			mooshroomEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Mooshroom head")
					.define("mooshroomEnableCreeperDrop", true);

			ocelotEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Ocelot head")
					.define("ocelotEnableCreeperDrop", true);

			pigEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Pig head")
					.define("pigEnableCreeperDrop", true);

			piglinEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Piglin head")
					.define("piglinEnableCreeperDrop", true);

			piglinBruteEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Piglin Brute head")
					.define("piglinBruteEnableCreeperDrop", true);

			sheepEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Sheep head")
					.define("sheepEnableCreeperDrop", true);

			silverfishEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Silverfish head")
					.define("silverfishEnableCreeperDrop", true);

			slimeEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Slime head")
					.define("slimeEnableCreeperDrop", true);

			snowGolemEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Snow Golem head")
					.define("snowGolemEnableCreeperDrop", true);

			spiderEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Spider head")
					.define("spiderEnableCreeperDrop", true);

			squidEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Squid head")
					.define("squidEnableCreeperDrop", true);

			turtleEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Turtle head")
					.define("turtleEnableCreeperDrop", true);

			villagerEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Villager head")
					.define("villagerEnableCreeperDrop", true);

			wanderingTraderEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Wandering Trader head")
					.define("wanderingTraderEnableCreeperDrop", true);

			witchEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Witch head")
					.define("witchEnableCreeperDrop", true);

			wolfEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Wolf head")
					.define("wolfEnableCreeperDrop", true);

			zombieVillagerEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Zombie Villager head")
					.define("zombieVillagerEnableCreeperDrop", true);

			zombifiedPiglinEnableCreeperDrop = builder
					.comment("Enable charged creeper explosion to drop a Zombified Piglin head")
					.define("zombifiedPiglinEnableCreeperDrop", true);

			builder.pop();
			builder.comment("Drop Rate")
					.push("DropRate");

			axolotlDropRate = builder
					.comment("Defines the drop rate for the Axolotl heads (0 to disable) [Default: 0.025]")
					.defineInRange("axolotlDropRate", 0.025, 0, 1);
			
			batDropRate = builder
					.comment("Defines the drop rate for the Bat head (0 to disable) [Default: 0.025]")
					.defineInRange("batDropRate", 0.025, 0, 1);
			
			beeDropRate = builder
					.comment("Defines the drop rate for the Bee head (0 to disable) [Default: 0.025]")
					.defineInRange("beeDropRate", 0.025, 0, 1);
			
			blazeDropRate = builder
					.comment("Defines the drop rate for the Blaze head (0 to disable) [Default: 0.025]")
					.defineInRange("blazeDropRate", 0.025, 0, 1);

			catDropRate = builder
					.comment("Defines the drop rate for the Cat heads (0 to disable) [Default: 0.025]")
					.defineInRange("catDropRate", 0.025, 0, 1);

			caveSpiderDropRate = builder
					.comment("Defines the drop rate for the Cave Spider head (0 to disable) [Default: 0.025]")
					.defineInRange("caveSpiderDropRate", 0.025, 0, 1);

			chickenDropRate = builder
					.comment("Defines the drop rate for the Chicken head (0 to disable) [Default: 0.025]")
					.defineInRange("chickenDropRate", 0.025, 0, 1);

			cowDropRate = builder
					.comment("Defines the drop rate for the Cow head (0 to disable) [Default: 0.025]")
					.defineInRange("cowDropRate", 0.025, 0, 1);

			donkeyDropRate = builder
					.comment("Defines the drop rate for the Donkey head (0 to disable) [Default: 0.025]")
					.defineInRange("donkeyDropRate", 0.025, 0, 1);

			endermanDropRate = builder
					.comment("Defines the drop rate for the Enderman head (0 to disable) [Default: 0.025]")
					.defineInRange("endermanDropRate", 0.025, 0, 1);

			endermiteDropRate = builder
					.comment("Defines the drop rate for the Endermite head (0 to disable) [Default: 0.025]")
					.defineInRange("endermiteDropRate", 0.025, 0, 1);

			foxDropRate = builder
					.comment("Defines the drop rate for the Fox heads (0 to disable) [Default: 0.025]")
					.defineInRange("foxDropRate", 0.025, 0, 1);

			ghastDropRate = builder
					.comment("Defines the drop rate for the Ghast head (0 to disable) [Default: 0.025]")
					.defineInRange("ghastDropRate", 0.025, 0, 1);

			glowSquidDropRate = builder
					.comment("Defines the drop rate for the Glow Squid head (0 to disable) [Default: 0.025]")
					.defineInRange("glowSquidDropRate", 0.025, 0, 1);

			goatDropRate = builder
					.comment("Defines the drop rate for the Goat head (0 to disable) [Default: 0.025]")
					.defineInRange("goatDropRate", 0.025, 0, 1);

			horseDropRate = builder
					.comment("Defines the drop rate for the Horse heads (0 to disable) [Default: 0.025]")
					.defineInRange("horseDropRate", 0.025, 0, 1);

			horseSkeletonDropRate = builder
					.comment("Defines the drop rate for the Skeleton Horse head (0 to disable) [Default: 0.025]")
					.defineInRange("horseSkeletonDropRate", 0.025, 0, 1);

			horseUndeadDropRate = builder
					.comment("Defines the drop rate for the Zombie Horse head (0 to disable) [Default: 0.025]")
					.defineInRange("horseUndeadDropRate", 0.025, 0, 1);

			ironGolemDropRate = builder
					.comment("Defines the drop rate for the Iron Golem head (0 to disable) [Default: 0.025]")
					.defineInRange("ironGolemDropRate", 0.025, 0, 1);

			magmaCubeDropRate = builder
					.comment("Defines the drop rate for the Magma Cube head (0 to disable) [Default: 0.025]")
					.defineInRange("magmaCubeDropRate", 0.025, 0, 1);

			mooshroomDropRate = builder
					.comment("Defines the drop rate for the Mooshroom heads (0 to disable) [Default: 0.025]")
					.defineInRange("mooshroomDropRate", 0.025, 0, 1);

			ocelotDropRate = builder
					.comment("Defines the drop rate for the Ocelot head (0 to disable) [Default: 0.025]")
					.defineInRange("ocelotDropRate", 0.025, 0, 1);

			pigDropRate = builder
					.comment("Defines the drop rate for the Pig head (0 to disable) [Default: 0.025]")
					.defineInRange("pigDropRate", 0.025, 0, 1);

			piglinDropRate = builder
					.comment("Defines the drop rate for the Piglin head (0 to disable) [Default: 0.025]")
					.defineInRange("piglinDropRate", 0.025, 0, 1);

			piglinBruteDropRate = builder
					.comment("Defines the drop rate for the Piglin Brute head (0 to disable) [Default: 0.025]")
					.defineInRange("piglinBruteDropRate", 0.025, 0, 1);

			sheepDropRate = builder
					.comment("Defines the drop rate for the Sheep heads (0 to disable) [Default: 0.025]")
					.defineInRange("sheepDropRate", 0.025, 0, 1);

			silverfishDropRate = builder
					.comment("Defines the drop rate for the Silverfish head (0 to disable) [Default: 0.025]")
					.defineInRange("silverfishDropRate", 0.025, 0, 1);

			slimeDropRate = builder
					.comment("Defines the drop rate for the Slime head (0 to disable) [Default: 0.025]")
					.defineInRange("slimeDropRate", 0.025, 0, 1);

			snowGolemDropRate = builder
					.comment("Defines the drop rate for the Snow Golem head (0 to disable) [Default: 0.025]")
					.defineInRange("snowGolemDropRate", 0.025, 0, 1);

			spiderDropRate = builder
					.comment("Defines the drop rate for the Spider head (0 to disable) [Default: 0.025]")
					.defineInRange("spiderDropRate", 0.025, 0, 1);

			squidDropRate = builder
					.comment("Defines the drop rate for the Squid head (0 to disable) [Default: 0.025]")
					.defineInRange("squidDropRate", 0.025, 0, 1);

			turtleDropRate = builder
					.comment("Defines the drop rate for the Turtle head (0 to disable) [Default: 0.025]")
					.defineInRange("turtleDropRate", 0.025, 0, 1);

			villagerDropRate = builder
					.comment("Defines the drop rate for the Villager head (0 to disable) [Default: 0.025]")
					.defineInRange("villagerDropRate", 0.025, 0, 1);

			wanderingTraderDropRate = builder
					.comment("Defines the drop rate for the Wandering Trader head (0 to disable) [Default: 0.025]")
					.defineInRange("wanderingTraderDropRate", 0.025, 0, 1);

			witchDropRate = builder
					.comment("Defines the drop rate for the Witch head (0 to disable) [Default: 0.025]")
					.defineInRange("witchDropRate", 0.025, 0, 1);

			wolfDropRate = builder
					.comment("Defines the drop rate for the Wolf head (0 to disable) [Default: 0.025]")
					.defineInRange("wolfDropRate", 0.025, 0, 1);

			zombieVillagerDropRate = builder
					.comment("Defines the drop rate for the Zombie Villager head (0 to disable) [Default: 0.025]")
					.defineInRange("zombieVillagerDropRate", 0.025, 0, 1);

			zombifiedPiglinDropRate = builder
					.comment("Defines the drop rate for the Zombified Piglin head (0 to disable) [Default: 0.025]")
					.defineInRange("zombifiedPiglinDropRate", 0.025, 0, 1);

			builder.pop();
		}
	}

	public static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfigEvent.Loading configEvent) {
		Heads.LOGGER.debug("Loaded Head's config file {}", configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
		Heads.LOGGER.debug("Head's config just got changed on the file system!");
	}
}
