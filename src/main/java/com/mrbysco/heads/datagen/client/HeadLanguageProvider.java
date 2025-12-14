package com.mrbysco.heads.datagen.client;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.registry.HeadReg;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class HeadLanguageProvider extends LanguageProvider {
	public HeadLanguageProvider(PackOutput packOutput) {
		super(packOutput, Heads.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add("itemGroup.heads", "Heads");

		this.addHead(HeadsRegistry.ALLAY, "Allay");
		this.addHead(HeadsRegistry.AXOLOTL_BLUE, "Axolotl");
		this.addHead(HeadsRegistry.AXOLOTL_CYAN, "Axolotl");
		this.addHead(HeadsRegistry.AXOLOTL_GOLD, "Axolotl");
		this.addHead(HeadsRegistry.AXOLOTL_LUCY, "Axolotl");
		this.addHead(HeadsRegistry.AXOLOTL_WILD, "Axolotl");
		this.addHead(HeadsRegistry.BAT, "Bat");
		this.addHead(HeadsRegistry.BEE, "Bee");
		this.addHead(HeadsRegistry.BLAZE, "Blaze");
		this.addHead(HeadsRegistry.CAT_ALL_BLACK, "Cat");
		this.addHead(HeadsRegistry.CAT_BLACK, "Cat");
		this.addHead(HeadsRegistry.CAT_BRITISH_SHORTHAIR, "Cat");
		this.addHead(HeadsRegistry.CAT_CALICO, "Cat");
		this.addHead(HeadsRegistry.CAT_JELLIE, "Cat");
		this.addHead(HeadsRegistry.CAT_PERSIAN, "Cat");
		this.addHead(HeadsRegistry.CAT_RAGDOLL, "Cat");
		this.addHead(HeadsRegistry.CAT_RED, "Cat");
		this.addHead(HeadsRegistry.CAT_SIAMESE, "Cat");
		this.addHead(HeadsRegistry.CAT_TABBY, "Cat");
		this.addHead(HeadsRegistry.CAT_WHITE, "Cat");
		this.addHead(HeadsRegistry.CAVE_SPIDER, "Cave Spider");
		this.addHead(HeadsRegistry.CHICKEN, "Chicken");
		this.addHead(HeadsRegistry.COD, "Cod");
		this.addHead(HeadsRegistry.COW, "Cow");
		this.addHead(HeadsRegistry.DOLPHIN, "Dolphin");
		this.addHead(HeadsRegistry.DONKEY, "Donkey");
		this.addHead(HeadsRegistry.DROWNED, "Drowned");
		this.addHead(HeadsRegistry.ENDERMAN, "Enderman", " Skull");
		this.addHead(HeadsRegistry.ENDERMITE, "Endermite", " Skull");
		this.addHead(HeadsRegistry.EVOKER, "Evoker", " Skull");
		this.addHead(HeadsRegistry.FOX, "Fox", " Skull");
		this.addHead(HeadsRegistry.FOX_SNOW, "Fox", " Skull");
		this.addHead(HeadsRegistry.GHAST, "Ghast", " Skull");
		this.addHead(HeadsRegistry.GLOW_SQUID, "Glow Squid");
		this.addHead(HeadsRegistry.GOAT, "Goat");
		this.addHead(HeadsRegistry.HOGLIN, "Hoglin");
		this.addHead(HeadsRegistry.HORSE_BLACK, "Horse");
		this.addHead(HeadsRegistry.HORSE_BROWN, "Horse");
		this.addHead(HeadsRegistry.HORSE_CHESTNUT, "Horse");
		this.addHead(HeadsRegistry.HORSE_CREAMY, "Horse");
		this.addHead(HeadsRegistry.HORSE_DARKBROWN, "Horse");
		this.addHead(HeadsRegistry.HORSE_GRAY, "Horse");
		this.addHead(HeadsRegistry.HORSE_SKELETON, "Skeleton Horse");
		this.addHead(HeadsRegistry.HORSE_UNDEAD, "Undead Horse");
		this.addHead(HeadsRegistry.HORSE_WHITE, "Horse");
		this.addHead(HeadsRegistry.HUSK, "Husk");
		this.addHead(HeadsRegistry.ILLUSIONER, "Illusioner");
		this.addHead(HeadsRegistry.IRON_GOLEM, "Iron Golem");
		this.addHead(HeadsRegistry.MAGMA_CUBE, "Magma Cube", "");
		this.addHead(HeadsRegistry.MULE, "Mule");
		this.addHead(HeadsRegistry.MOOSHROOM_BROWN, "Brown Mooshroom");
		this.addHead(HeadsRegistry.MOOSHROOM_RED, "Red Mooshroom");
		this.addHead(HeadsRegistry.OCELOT, "Ocelot");
		this.addHead(HeadsRegistry.PIG, "Pig");
		this.addHead(HeadsRegistry.PIGLIN_BRUTE, "Piglin Brute");
		this.addHead(HeadsRegistry.PILLAGER, "Pillager");
		this.addHead(HeadsRegistry.SALMON, "Salmon");
		this.addHead(HeadsRegistry.SHEEP_BLACK, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_BLUE, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_BROWN, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_CYAN, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_GRAY, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_GREEN, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_LIGHT_BLUE, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_LIGHT_GRAY, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_LIME, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_MAGENTA, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_ORANGE, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_PINK, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_PURPLE, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_RED, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_SHAVEN, "Sheep", " Head (Shaven)");
		this.addHead(HeadsRegistry.SHEEP_WHITE, "Sheep");
		this.addHead(HeadsRegistry.SHEEP_YELLOW, "Sheep");
		this.addHead(HeadsRegistry.SILVERFISH, "Silverfish", "");
		this.addHead(HeadsRegistry.SLIME, "Slime", "");
		this.addHead(HeadsRegistry.SNOW_GOLEM, "Snow Golem");
		this.addHead(HeadsRegistry.SPIDER, "Spider");
		this.addHead(HeadsRegistry.SQUID, "Squid");
		this.addHead(HeadsRegistry.STRAY, "Stray");
		this.addHead(HeadsRegistry.TURTLE, "Turtle");
		this.addHead(HeadsRegistry.VILLAGER, "Villager");
		this.addHead(HeadsRegistry.VINDICATOR, "Vindicator");
		this.addHead(HeadsRegistry.WANDERING_TRADER, "Wandering Trader");
		this.addHead(HeadsRegistry.WITCH, "Witch");
		this.addHead(HeadsRegistry.WOLF, "Wolf");
		this.addHead(HeadsRegistry.ZOGLIN, "Zoglin");
		this.addHead(HeadsRegistry.ZOMBIE_VILLAGER, "Zombie Villager");
		this.addHead(HeadsRegistry.ZOMBIFIED_PIGLIN, "Zombified Piglin", " Skull");

		addConfig("title", "Heads Config", null);
		addMobConfig("axolotl", "Axolotl");
		addMobConfig("bat", "Bat");
		addMobConfig("bee", "Bee");
		addMobConfig("blaze", "Blaze");
		addMobConfig("cat", "Cat");
		addMobConfig("caveSpider", "Cave Spider");
		addMobConfig("chicken", "Chicken");
		addMobConfig("cod", "Cod");
		addMobConfig("cow", "Cow");
		addMobConfig("dolphin", "Dolphin");
		addMobConfig("donkey", "Donkey");
		addMobConfig("drowned", "Drowned");
		addMobConfig("enderman", "Enderman");
		addMobConfig("endermite", "Endermite");
		addMobConfig("evoker", "Evoker");
		addMobConfig("fox", "Fox");
		addMobConfig("ghast", "Ghast");
		addMobConfig("glowSquid", "Glow Squid");
		addMobConfig("goat", "Goat");
		addMobConfig("hoglin", "Hoglin");
		addMobConfig("horse", "Horse");
		addMobConfig("skeletonHorse", "Skeleton Horse");
		addMobConfig("undeadHorse", "Undead Horse");
		addMobConfig("husk", "Husk");
		addMobConfig("illusioner", "Illusioner");
		addMobConfig("ironGolem", "Iron Golem");
		addMobConfig("magmaCube", "Magma Cube");
		addMobConfig("mule", "Mule");
		addMobConfig("mooshroom", "Mooshroom");
		addMobConfig("ocelot", "Ocelot");
		addMobConfig("pig", "Pig");
		addMobConfig("piglin", "Piglin");
		addMobConfig("piglinBrute", "Piglin Brute");
		addMobConfig("pillager", "Pillager");
		addMobConfig("salmon", "Salmon");
		addMobConfig("sheep", "Sheep");
		addMobConfig("silverfish", "Silverfish");
		addMobConfig("slime", "Slime");
		addMobConfig("snowGolem", "Snow Golem");
		addMobConfig("spider", "Spider");
		addMobConfig("squid", "Squid");
		addMobConfig("stray", "Stray");
		addMobConfig("turtle", "Turtle");
		addMobConfig("villager", "Villager");
		addMobConfig("vindicator", "Vindicator");
		addMobConfig("wanderingTrader", "Wandering Trader");
		addMobConfig("witch", "Witch");
		addMobConfig("wolf", "Wolf");
		addMobConfig("zoglin", "Zoglin");
		addMobConfig("zombieVillager", "Zombie Villager");
		addMobConfig("zombifiedPiglin", "Zombified Piglin");
	}

	private void addHead(HeadReg headReg, @Nullable String mobName) {
		this.addHead(headReg, mobName, null);
	}

	private void addHead(HeadReg headReg, String mobName, @Nullable String customSuffix) {
		String suffix = customSuffix == null ? " Head" : customSuffix;
		this.addBlock(headReg.getHead(), mobName + suffix);
	}

	private void addMobConfig(String mobPath, String mobName) {
		addConfig(mobPath, mobName, mobName + " Settings");
		addConfig(mobPath + "EnableCreeperDrop", "Enable " + mobName + " Creeper drop",
				"Enable charged creeper explosion to drop a " + mobName + " head");
		addConfig(mobPath + "DropRate", mobName + " Drop Rate",
				"Defines the drop rate for the " + mobName + " head (0 to disable) [Default: 0.025]");
	}

	/**
	 * Add a subtitle to a sound event
	 *
	 * @param sound The sound event
	 * @param text  The subtitle text
	 */
	public void addSubtitle(Supplier<SoundEvent> sound, String text) {
		this.addSubtitle(sound.get(), text);
	}

	/**
	 * Add a subtitle to a sound event
	 *
	 * @param sound The sound event registry object
	 * @param text  The subtitle text
	 */
	public void addSubtitle(SoundEvent sound, String text) {
		String path = Heads.MOD_ID + ".subtitle." + sound.location().getPath();
		this.add(path, text);
	}

	/**
	 * Add the translation for a config entry
	 *
	 * @param path        The path of the config entry
	 * @param name        The name of the config entry
	 * @param description The description of the config entry (optional in case of targeting "title" or similar entries that have no tooltip)
	 */
	private void addConfig(String path, String name, @Nullable String description) {
		this.add("heads.configuration." + path, name);
		if (description != null && !description.isEmpty())
			this.add("heads.configuration." + path + ".tooltip", description);
	}
}