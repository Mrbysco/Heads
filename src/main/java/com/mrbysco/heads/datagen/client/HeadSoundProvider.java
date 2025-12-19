package com.mrbysco.heads.datagen.client;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.registry.HeadReg;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class HeadSoundProvider extends SoundDefinitionsProvider {

	public HeadSoundProvider(PackOutput packOutput) {
		super(packOutput, Heads.MOD_ID);
	}

	@Override
	public void registerSounds() {
		addSounds(definition().with(sound("entity.allay.ambient_without_item", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.allay.ambient_without_item"),
				HeadsRegistry.ALLAY
		);
		addSounds(definition().with(sound("entity.axolotl.idle_water", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.axolotl.idle_water"),
				HeadsRegistry.AXOLOTL_BLUE, HeadsRegistry.AXOLOTL_CYAN, HeadsRegistry.AXOLOTL_GOLD,
				HeadsRegistry.AXOLOTL_LUCY, HeadsRegistry.AXOLOTL_WILD
		);
		addSounds(definition().with(sound("entity.bat.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.bat.ambient"),
				HeadsRegistry.BAT
		);
		addSounds(definition().with(sound("entity.bee.loop", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.bee.loop"),
				HeadsRegistry.BEE
		);
		addSounds(definition().with(sound("entity.blaze.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.blaze.ambient"),
				HeadsRegistry.BLAZE
		);
		addSounds(definition().with(sound("entity.cat.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.cat.ambient"),
				HeadsRegistry.CAT_ALL_BLACK, HeadsRegistry.CAT_BLACK, HeadsRegistry.CAT_BRITISH_SHORTHAIR,
				HeadsRegistry.CAT_CALICO, HeadsRegistry.CAT_JELLIE, HeadsRegistry.CAT_PERSIAN,
				HeadsRegistry.CAT_RAGDOLL, HeadsRegistry.CAT_RED, HeadsRegistry.CAT_SIAMESE,
				HeadsRegistry.CAT_TABBY, HeadsRegistry.CAT_WHITE
		);
		addSounds(definition().with(sound("entity.spider.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.spider.ambient"),
				HeadsRegistry.SPIDER, HeadsRegistry.CAVE_SPIDER
		);
		addSounds(definition().with(sound("entity.chicken.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.chicken.ambient"),
				HeadsRegistry.CHICKEN
		);
		addSounds(definition().with(sound("entity.cod.flop", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.cod.flop"),
				HeadsRegistry.COD
		);
		addSounds(definition().with(sound("entity.cow.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.cow.ambient"),
				HeadsRegistry.COW, HeadsRegistry.MOOSHROOM_BROWN, HeadsRegistry.MOOSHROOM_RED
		);
		addSounds(definition().with(sound("entity.dolphin.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.dolphin.ambient"),
				HeadsRegistry.DOLPHIN
		);
		addSounds(definition().with(sound("entity.donkey.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.donkey.ambient"),
				HeadsRegistry.DONKEY
		);
		addSounds(definition().with(sound("entity.drowned.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.drowned.ambient\""),
				HeadsRegistry.DROWNED
		);
		addSounds(definition().with(sound("entity.enderman.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.enderman.ambient"),
				HeadsRegistry.ENDERMAN
		);
		addSounds(definition().with(sound("entity.endermite.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.endermite.ambient"),
				HeadsRegistry.ENDERMITE
		);
		addSounds(definition().with(sound("entity.evoker.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.evoker.ambient"),
				HeadsRegistry.EVOKER
		);
		addSounds(definition().with(sound("entity.fox.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.fox.ambient"),
				HeadsRegistry.FOX, HeadsRegistry.FOX_SNOW
		);
		addSounds(definition().with(sound("entity.ghast.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.ghast.ambient"),
				HeadsRegistry.GHAST
		);
		addSounds(definition().with(sound("entity.glow_squid.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.glow_squid.ambient"),
				HeadsRegistry.GLOW_SQUID
		);
		addSounds(definition().with(sound("entity.goat.screaming.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.goat.screaming.ambient"),
				HeadsRegistry.GOAT
		);
		addSounds(definition().with(sound("entity.hoglin.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.hoglin.ambient"),
				HeadsRegistry.HOGLIN
		);
		addSounds(definition().with(sound("entity.horse.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.horse.ambient"),
				HeadsRegistry.HORSE_BLACK, HeadsRegistry.HORSE_BROWN, HeadsRegistry.HORSE_CHESTNUT,
				HeadsRegistry.HORSE_CREAMY, HeadsRegistry.HORSE_DARKBROWN, HeadsRegistry.HORSE_GRAY,
				HeadsRegistry.HORSE_SKELETON, HeadsRegistry.HORSE_UNDEAD, HeadsRegistry.HORSE_WHITE
		);
		addSounds(definition().with(sound("entity.husk.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.husk.ambient"),
				HeadsRegistry.HUSK
		);
		addSounds(definition().with(sound("entity.illusioner.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.illusioner.ambient"),
				HeadsRegistry.ILLUSIONER
		);
		addSounds(definition().with(sound("entity.iron_golem.step", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.iron_golem.step"),
				HeadsRegistry.IRON_GOLEM
		);
		addSounds(definition().with(sound("entity.magma_cube.squish", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.magma_cube.squish"),
				HeadsRegistry.MAGMA_CUBE
		);
		addSounds(definition().with(sound("entity.slime.squish", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.slime.squish"),
				HeadsRegistry.SLIME
		);
		addSounds(definition().with(sound("entity.mule.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.mule.ambient"),
				HeadsRegistry.MULE
		);
		addSounds(definition().with(sound("entity.ocelot.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.ocelot.ambient"),
				HeadsRegistry.OCELOT
		);
		addSounds(definition().with(sound("entity.pig.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.pig.ambient"),
				HeadsRegistry.PIG
		);
		addSounds(definition().with(sound("entity.piglin_brute.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.piglin_brute.ambient"),
				HeadsRegistry.PIGLIN_BRUTE
		);
		addSounds(definition().with(sound("entity.pillager.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.pillager.ambient"),
				HeadsRegistry.PILLAGER
		);
		addSounds(definition().with(sound("entity.salmon.flop", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.salmon.flop"),
				HeadsRegistry.SALMON
		);
		addSounds(definition().with(sound("entity.sheep.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.sheep.ambient"),
				HeadsRegistry.SHEEP_BLACK, HeadsRegistry.SHEEP_BLUE, HeadsRegistry.SHEEP_BROWN,
				HeadsRegistry.SHEEP_CYAN, HeadsRegistry.SHEEP_GRAY, HeadsRegistry.SHEEP_GREEN,
				HeadsRegistry.SHEEP_LIGHT_BLUE, HeadsRegistry.SHEEP_LIGHT_GRAY, HeadsRegistry.SHEEP_LIME,
				HeadsRegistry.SHEEP_MAGENTA, HeadsRegistry.SHEEP_ORANGE, HeadsRegistry.SHEEP_PINK,
				HeadsRegistry.SHEEP_PURPLE, HeadsRegistry.SHEEP_RED, HeadsRegistry.SHEEP_SHAVEN,
				HeadsRegistry.SHEEP_WHITE, HeadsRegistry.SHEEP_YELLOW
		);
		addSounds(definition().with(sound("entity.silverfish.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.silverfish.ambient"),
				HeadsRegistry.SILVERFISH
		);
		addSounds(definition().with(sound("entity.snow_golem.shoot", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.snow_golem.shoot"),
				HeadsRegistry.SNOW_GOLEM
		);
		addSounds(definition().with(sound("entity.squid.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.squid.ambient"),
				HeadsRegistry.SQUID
		);
		addSounds(definition().with(sound("entity.stray.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.stray.ambient"),
				HeadsRegistry.STRAY
		);
		addSounds(definition().with(sound("entity.turtle.ambient_land", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.turtle.ambient_land"),
				HeadsRegistry.TURTLE
		);
		addSounds(definition().with(sound("entity.villager.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.villager.ambient"),
				HeadsRegistry.VILLAGER
		);
		addSounds(definition().with(sound("entity.vindicator.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.vindicator.ambient"),
				HeadsRegistry.VINDICATOR
		);
		addSounds(definition().with(sound("entity.wandering_trader.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.wandering_trader.ambient"),
				HeadsRegistry.WANDERING_TRADER
		);
		addSounds(definition().with(sound("entity.witch.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.witch.ambient"),
				HeadsRegistry.WITCH
		);
		addSounds(definition().with(sound("entity.wolf.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.wolf.ambient"),
				HeadsRegistry.WOLF
		);
		addSounds(definition().with(sound("entity.zoglin.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.zoglin.ambient"),
				HeadsRegistry.ZOGLIN
		);
		addSounds(definition().with(sound("entity.zombie_villager.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.zombie_villager.ambient"),
				HeadsRegistry.ZOMBIE_VILLAGER
		);
		addSounds(definition().with(sound("entity.zombified_piglin.ambient", SoundDefinition.SoundType.EVENT))
						.subtitle("subtitles.entity.zombified_piglin.ambient"),
				HeadsRegistry.ZOMBIFIED_PIGLIN
		);
	}

	private void addSounds(SoundDefinition definition, HeadReg... headRegs) {
		for (HeadReg headReg : headRegs) {
			this.add(headReg.getImitateSound(), definition);
		}
	}

	public String modSubtitle(Identifier id) {
		return Heads.MOD_ID + ".subtitle." + id.getPath();
	}

	public Identifier mcLoc(String name) {
		return Identifier.withDefaultNamespace(name);
	}
}
