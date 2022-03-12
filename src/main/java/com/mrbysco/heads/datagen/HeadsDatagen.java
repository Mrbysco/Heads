package com.mrbysco.heads.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mrbysco.heads.Heads;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder.Perspective;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.mrbysco.heads.datagen.HeadsDatagen.Loots.GeOreBlockTables.RESISTANT;
import static com.mrbysco.heads.registry.HeadsRegistry.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HeadsDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(new Loots(generator));
			BlockTagsProvider provider;
			generator.addProvider(provider = new HeadBlockTags(generator, helper));
			generator.addProvider(new HeadItemTags(generator, provider, helper));
		}
		if (event.includeClient()) {
			generator.addProvider(new Language(generator));
			generator.addProvider(new ItemModels(generator, helper));
			generator.addProvider(new BlockStates(generator, helper));
		}
	}

	static class Loots extends LootTableProvider {
		public Loots(DataGenerator gen) {
			super(gen);
		}

		@Override
		protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables() {
			return ImmutableList.of(
					Pair.of(GeOreBlockTables::new, LootContextParamSets.BLOCK)
			);
		}

		public static class GeOreBlockTables extends BlockLoot {
			public static final List<Item> RESISTANT = new ArrayList<>();

			@Override
			protected void addTables() {
				this.dropSkull(AXOLOTL_LUCY_HEAD.get());
				this.dropSkull(AXOLOTL_WILD_HEAD.get());
				this.dropSkull(AXOLOTL_GOLD_HEAD.get());
				this.dropSkull(AXOLOTL_CYAN_HEAD.get());
				this.dropSkull(AXOLOTL_BLUE_HEAD.get());
				this.dropSkull(BAT_HEAD.get());
				this.dropSkull(BEE_HEAD.get());
				this.dropSkull(BLACK_SHEEP_HEAD.get());
				this.dropSkull(BLAZE_HEAD.get());
				this.dropSkull(BLUE_SHEEP_HEAD.get());
				this.dropSkull(BROWN_MOOSHROOM_HEAD.get());
				this.dropSkull(BROWN_SHEEP_HEAD.get());
				this.dropSkull(CAT_TABBY_HEAD.get());
				this.dropSkull(CAT_BLACK_HEAD.get());
				this.dropSkull(CAT_RED_HEAD.get());
				this.dropSkull(CAT_SIAMESE_HEAD.get());
				this.dropSkull(CAT_BRITISH_SHORTHAIR_HEAD.get());
				this.dropSkull(CAT_CALICO_HEAD.get());
				this.dropSkull(CAT_PERSIAN_HEAD.get());
				this.dropSkull(CAT_RAGDOLL_HEAD.get());
				this.dropSkull(CAT_WHITE_HEAD.get());
				this.dropSkull(CAT_JELLIE_HEAD.get());
				this.dropSkull(CAT_ALL_BLACK_HEAD.get());
				this.dropSkull(CAVE_SPIDER_HEAD.get());
				this.dropSkull(CHICKEN_HEAD.get());
				this.dropSkull(COW_HEAD.get());
				this.dropSkull(CYAN_SHEEP_HEAD.get());
				this.dropSkull(DONKEY_HEAD.get());
				this.dropSkull(ENDERMAN_HEAD.get());
				this.dropSkull(ENDERMITE_HEAD.get());
				this.dropSkull(FOX_HEAD.get());
				this.dropSkull(FOX_SNOW_HEAD.get());
				this.dropSkull(GHAST_HEAD.get());
				this.dropSkull(GLOW_SQUID_HEAD.get());
				this.dropSkull(GOAT_HEAD.get());
				this.dropSkull(GRAY_SHEEP_HEAD.get());
				this.dropSkull(GREEN_SHEEP_HEAD.get());
				this.dropSkull(HORSE_WHITE_HEAD.get());
				this.dropSkull(HORSE_CREAMY_HEAD.get());
				this.dropSkull(HORSE_CHESTNUT_HEAD.get());
				this.dropSkull(HORSE_BROWN_HEAD.get());
				this.dropSkull(HORSE_BLACK_HEAD.get());
				this.dropSkull(HORSE_GRAY_HEAD.get());
				this.dropSkull(HORSE_DARKBROWN_HEAD.get());
				this.dropSkull(HORSE_UNDEAD_HEAD.get());
				this.dropSkull(HORSE_SKELETON_HEAD.get());
				this.dropSkull(IRON_GOLEM_HEAD.get());
				this.dropSkull(LIGHT_BLUE_SHEEP_HEAD.get());
				this.dropSkull(LIGHT_GRAY_SHEEP_HEAD.get());
				this.dropSkull(LIME_SHEEP_HEAD.get());
				this.dropSkull(MAGENTA_SHEEP_HEAD.get());
				this.dropSkull(MAGMA_CUBE_HEAD.get());
				this.dropSkull(OCELOT_HEAD.get());
				this.dropSkull(ORANGE_SHEEP_HEAD.get());
				this.dropSkull(PIGLIN_BRUTE_HEAD.get());
				this.dropSkull(PIGLIN_HEAD.get());
				this.dropSkull(PIG_HEAD.get());
				this.dropSkull(PINK_SHEEP_HEAD.get());
				this.dropSkull(PURPLE_SHEEP_HEAD.get());
				this.dropSkull(RED_MOOSHROOM_HEAD.get());
				this.dropSkull(RED_SHEEP_HEAD.get());
				this.dropSkull(SHEEP_HEAD.get());
				this.dropSkull(SHEEP_SHAVEN_HEAD.get());
				this.dropSkull(SILVERFISH_HEAD.get());
				this.dropSkull(SLIME_HEAD.get());
				this.dropSkull(SNOW_GOLEM_HEAD.get());
				this.dropSkull(SPIDER_HEAD.get());
				this.dropSkull(SQUID_HEAD.get());
				this.dropSkull(TURTLE_HEAD.get());
				this.dropSkull(VILLAGER_HEAD.get());
				this.dropSkull(WANDERING_TRADER_HEAD.get());
				this.dropSkull(WITCH_HEAD.get());
				this.dropSkull(WOLF_HEAD.get());
				this.dropSkull(YELLOW_SHEEP_HEAD.get());
				this.dropSkull(ZOMBIE_VILLAGER_HEAD.get());
				this.dropSkull(ZOMBIFIED_PIGLIN_SKULL.get());
			}

			private void dropSkull(Block block) {
				RESISTANT.add(block.asItem());
				this.add(block, Loots::createSingleItemTable);
			}

			@Override
			protected Iterable<Block> getKnownBlocks() {
				return BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
			}
		}

		protected static <T> T applyExplosionCondition(ItemLike p_124135_, ConditionUserBuilder<T> p_124136_) {
			return !RESISTANT.contains(p_124135_.asItem()) ? p_124136_.when(ExplosionCondition.survivesExplosion()) : p_124136_.unwrap();
		}

		protected static LootTable.Builder createSingleItemTable(ItemLike p_124127_) {
			return LootTable.lootTable().withPool(applyExplosionCondition(p_124127_, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(p_124127_))));
		}

		@Override
		protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {
			map.forEach((name, table) -> LootTables.validate(validationContext, name, table));
		}
	}

	static class Language extends LanguageProvider {
		public Language(DataGenerator gen) {
			super(gen, Heads.MOD_ID, "en_us");
		}

		@Override
		protected void addTranslations() {
			add("itemGroup.heads", "Heads");

			this.addBlock(AXOLOTL_LUCY_HEAD, "Axolotl Head");
			this.addBlock(AXOLOTL_WILD_HEAD, "Axolotl Head");
			this.addBlock(AXOLOTL_GOLD_HEAD, "Axolotl Head");
			this.addBlock(AXOLOTL_CYAN_HEAD, "Axolotl Head");
			this.addBlock(AXOLOTL_BLUE_HEAD, "Axolotl Head");
			this.addBlock(BAT_HEAD, "Bat Head");
			this.addBlock(BEE_HEAD, "Bee Head");
			this.addBlock(BLACK_SHEEP_HEAD, "Sheep Head");
			this.addBlock(BLAZE_HEAD, "Blaze Head");
			this.addBlock(BLUE_SHEEP_HEAD, "Sheep Head");
			this.addBlock(BROWN_MOOSHROOM_HEAD, "Brown Mooshroom Head");
			this.addBlock(BROWN_SHEEP_HEAD, "Sheep Head");
			this.addBlock(CAT_TABBY_HEAD, "Cat Head");
			this.addBlock(CAT_BLACK_HEAD, "Cat Head");
			this.addBlock(CAT_RED_HEAD, "Cat Head");
			this.addBlock(CAT_SIAMESE_HEAD, "Cat Head");
			this.addBlock(CAT_BRITISH_SHORTHAIR_HEAD, "Cat Head");
			this.addBlock(CAT_CALICO_HEAD, "Cat Head");
			this.addBlock(CAT_PERSIAN_HEAD, "Cat Head");
			this.addBlock(CAT_RAGDOLL_HEAD, "Cat Head");
			this.addBlock(CAT_WHITE_HEAD, "Cat Head");
			this.addBlock(CAT_JELLIE_HEAD, "Cat Head");
			this.addBlock(CAT_ALL_BLACK_HEAD, "Cat Head");
			this.addBlock(CAVE_SPIDER_HEAD, "Cave Spider Head");
			this.addBlock(CHICKEN_HEAD, "Chicken Head");
			this.addBlock(COW_HEAD, "Cow Head");
			this.addBlock(CYAN_SHEEP_HEAD, "Sheep Head");
			this.addBlock(DONKEY_HEAD, "Donkey Head");
			this.addBlock(ENDERMAN_HEAD, "Enderman Skull");
			this.addBlock(ENDERMITE_HEAD, "Endermite Skull");
			this.addBlock(FOX_HEAD, "Fox Skull");
			this.addBlock(FOX_SNOW_HEAD, "Fox Skull");
			this.addBlock(GHAST_HEAD, "Ghast Skull");
			this.addBlock(GLOW_SQUID_HEAD, "Glow Squid Head");
			this.addBlock(GOAT_HEAD, "Goat Head");
			this.addBlock(GRAY_SHEEP_HEAD, "Sheep Head");
			this.addBlock(GREEN_SHEEP_HEAD, "Sheep Head");
			this.addBlock(HORSE_WHITE_HEAD, "Horse Head");
			this.addBlock(HORSE_CREAMY_HEAD, "Horse Head");
			this.addBlock(HORSE_CHESTNUT_HEAD, "Horse Head");
			this.addBlock(HORSE_BROWN_HEAD, "Horse Head");
			this.addBlock(HORSE_BLACK_HEAD, "Horse Head");
			this.addBlock(HORSE_GRAY_HEAD, "Horse Head");
			this.addBlock(HORSE_DARKBROWN_HEAD, "Horse Head");
			this.addBlock(HORSE_UNDEAD_HEAD, "Undead Horse Head");
			this.addBlock(HORSE_SKELETON_HEAD, "Skeleton Horse Head");
			this.addBlock(IRON_GOLEM_HEAD, "Iron Golem Head");
			this.addBlock(LIGHT_BLUE_SHEEP_HEAD, "Sheep Head");
			this.addBlock(LIGHT_GRAY_SHEEP_HEAD, "Sheep Head");
			this.addBlock(LIME_SHEEP_HEAD, "Sheep Head");
			this.addBlock(MAGENTA_SHEEP_HEAD, "Sheep Head");
			this.addBlock(MAGMA_CUBE_HEAD, "Magma Cube");
			this.addBlock(OCELOT_HEAD, "Ocelot Head");
			this.addBlock(ORANGE_SHEEP_HEAD, "Sheep Head");
			this.addBlock(PIGLIN_BRUTE_HEAD, "Piglin Brute Head");
			this.addBlock(PIGLIN_HEAD, "Piglin Head");
			this.addBlock(PIG_HEAD, "Pig Head");
			this.addBlock(PINK_SHEEP_HEAD, "Sheep Head");
			this.addBlock(PURPLE_SHEEP_HEAD, "Sheep Head");
			this.addBlock(RED_MOOSHROOM_HEAD, "Red Mooshroom Head");
			this.addBlock(RED_SHEEP_HEAD, "Sheep Head");
			this.addBlock(SHEEP_HEAD, "Sheep Head");
			this.addBlock(SHEEP_SHAVEN_HEAD, "Sheep Head (Shaven)");
			this.addBlock(SILVERFISH_HEAD, "Silverfish");
			this.addBlock(SLIME_HEAD, "Slime");
			this.addBlock(SNOW_GOLEM_HEAD, "Snow Golem Head");
			this.addBlock(SPIDER_HEAD, "Spider Head");
			this.addBlock(SQUID_HEAD, "Squid Head");
			this.addBlock(TURTLE_HEAD, "Turtle Head");
			this.addBlock(VILLAGER_HEAD, "Villager Head");
			this.addBlock(WANDERING_TRADER_HEAD, "Wandering Trader Head");
			this.addBlock(WITCH_HEAD, "Witch Head");
			this.addBlock(WOLF_HEAD, "Wolf Head");
			this.addBlock(YELLOW_SHEEP_HEAD, "Sheep Head");
			this.addBlock(ZOMBIE_VILLAGER_HEAD, "Zombie Villager Head");
			this.addBlock(ZOMBIFIED_PIGLIN_SKULL, "Zombified Piglin Skull");
		}
	}

	static class BlockStates extends BlockStateProvider {
		public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
			super(gen, Heads.MOD_ID, helper);
		}

		@Override
		protected void registerStatesAndModels() {
			makeHead(AXOLOTL_LUCY_HEAD.get(), AXOLOTL_LUCY_WALL_HEAD.get());
			makeHead(AXOLOTL_WILD_HEAD.get(), AXOLOTL_WILD_WALL_HEAD.get());
			makeHead(AXOLOTL_GOLD_HEAD.get(), AXOLOTL_GOLD_WALL_HEAD.get());
			makeHead(AXOLOTL_CYAN_HEAD.get(), AXOLOTL_CYAN_WALL_HEAD.get());
			makeHead(AXOLOTL_BLUE_HEAD.get(), AXOLOTL_BLUE_WALL_HEAD.get());
			makeHead(BAT_HEAD.get(), BAT_WALL_HEAD.get());
			makeHead(BEE_HEAD.get(), BEE_WALL_HEAD.get());
			makeHead(BLACK_SHEEP_HEAD.get(), BLACK_SHEEP_WALL_HEAD.get());
			makeHead(BLAZE_HEAD.get(), BLAZE_WALL_HEAD.get());
			makeHead(BLUE_SHEEP_HEAD.get(), BLUE_SHEEP_WALL_HEAD.get());
			makeHead(BROWN_MOOSHROOM_HEAD.get(), BROWN_MOOSHROOM_WALL_HEAD.get());
			makeHead(BROWN_SHEEP_HEAD.get(), BROWN_SHEEP_WALL_HEAD.get());
			makeHead(CAT_ALL_BLACK_HEAD.get(), CAT_ALL_BLACK_WALL_HEAD.get());
			makeHead(CAT_BLACK_HEAD.get(), CAT_BLACK_WALL_HEAD.get());
			makeHead(CAT_BRITISH_SHORTHAIR_HEAD.get(), CAT_BRITISH_SHORTHAIR_WALL_HEAD.get());
			makeHead(CAT_CALICO_HEAD.get(), CAT_CALICO_WALL_HEAD.get());
			makeHead(CAT_JELLIE_HEAD.get(), CAT_JELLIE_WALL_HEAD.get());
			makeHead(CAT_PERSIAN_HEAD.get(), CAT_PERSIAN_WALL_HEAD.get());
			makeHead(CAT_RAGDOLL_HEAD.get(), CAT_RAGDOLL_WALL_HEAD.get());
			makeHead(CAT_RED_HEAD.get(), CAT_RED_WALL_HEAD.get());
			makeHead(CAT_SIAMESE_HEAD.get(), CAT_SIAMESE_WALL_HEAD.get());
			makeHead(CAT_TABBY_HEAD.get(), CAT_TABBY_WALL_HEAD.get());
			makeHead(CAT_WHITE_HEAD.get(), CAT_WHITE_WALL_HEAD.get());
			makeHead(CAVE_SPIDER_HEAD.get(), CAVE_SPIDER_WALL_HEAD.get());
			makeHead(CHICKEN_HEAD.get(), CHICKEN_WALL_HEAD.get());
			makeHead(COW_HEAD.get(), COW_WALL_HEAD.get());
			makeHead(CYAN_SHEEP_HEAD.get(), CYAN_SHEEP_WALL_HEAD.get());
			makeHead(DONKEY_HEAD.get(), DONKEY_WALL_HEAD.get());
			makeHead(ENDERMAN_HEAD.get(), ENDERMAN_WALL_HEAD.get());
			makeHead(ENDERMITE_HEAD.get(), ENDERMITE_WALL_HEAD.get());
			makeHead(FOX_HEAD.get(), FOX_WALL_HEAD.get());
			makeHead(FOX_SNOW_HEAD.get(), FOX_SNOW_WALL_HEAD.get());
			makeHead(GHAST_HEAD.get(), GHAST_WALL_HEAD.get());
			makeHead(GLOW_SQUID_HEAD.get(), GLOW_SQUID_WALL_HEAD.get());
			makeHead(GOAT_HEAD.get(), GOAT_WALL_HEAD.get());
			makeHead(GRAY_SHEEP_HEAD.get(), GRAY_SHEEP_WALL_HEAD.get());
			makeHead(GREEN_SHEEP_HEAD.get(), GREEN_SHEEP_WALL_HEAD.get());
			makeHead(HORSE_WHITE_HEAD.get(), HORSE_WHITE_WALL_HEAD.get());
			makeHead(HORSE_CREAMY_HEAD.get(), HORSE_CREAMY_WALL_HEAD.get());
			makeHead(HORSE_CHESTNUT_HEAD.get(), HORSE_CHESTNUT_WALL_HEAD.get());
			makeHead(HORSE_BROWN_HEAD.get(), HORSE_BROWN_WALL_HEAD.get());
			makeHead(HORSE_BLACK_HEAD.get(), HORSE_BLACK_WALL_HEAD.get());
			makeHead(HORSE_GRAY_HEAD.get(), HORSE_GRAY_WALL_HEAD.get());
			makeHead(HORSE_DARKBROWN_HEAD.get(), HORSE_DARKBROWN_WALL_HEAD.get());
			makeHead(HORSE_UNDEAD_HEAD.get(), HORSE_UNDEAD_WALL_HEAD.get());
			makeHead(HORSE_SKELETON_HEAD.get(), HORSE_SKELETON_WALL_HEAD.get());
			makeHead(IRON_GOLEM_HEAD.get(), IRON_GOLEM_WALL_HEAD.get());
			makeHead(LIGHT_BLUE_SHEEP_HEAD.get(), LIGHT_BLUE_SHEEP_WALL_HEAD.get());
			makeHead(LIGHT_GRAY_SHEEP_HEAD.get(), LIGHT_GRAY_SHEEP_WALL_HEAD.get());
			makeHead(LIME_SHEEP_HEAD.get(), LIME_SHEEP_WALL_HEAD.get());
			makeHead(MAGENTA_SHEEP_HEAD.get(), MAGENTA_SHEEP_WALL_HEAD.get());
			makeHead(MAGMA_CUBE_HEAD.get(), MAGMA_CUBE_WALL_HEAD.get());
			makeHead(OCELOT_HEAD.get(), OCELOT_WALL_HEAD.get());
			makeHead(ORANGE_SHEEP_HEAD.get(), ORANGE_SHEEP_WALL_HEAD.get());
			makeHead(PIGLIN_BRUTE_HEAD.get(), PIGLIN_BRUTE_WALL_HEAD.get());
			makeHead(PIGLIN_HEAD.get(), PIGLIN_WALL_HEAD.get());
			makeHead(PIG_HEAD.get(), PIG_WALL_HEAD.get());
			makeHead(PINK_SHEEP_HEAD.get(), PINK_SHEEP_WALL_HEAD.get());
			makeHead(PURPLE_SHEEP_HEAD.get(), PURPLE_SHEEP_WALL_HEAD.get());
			makeHead(RED_MOOSHROOM_HEAD.get(), RED_MOOSHROOM_WALL_HEAD.get());
			makeHead(RED_SHEEP_HEAD.get(), RED_SHEEP_WALL_HEAD.get());
			makeHead(SHEEP_HEAD.get(), SHEEP_WALL_HEAD.get());
			makeHead(SHEEP_SHAVEN_HEAD.get(), SHEEP_SHAVEN_WALL_HEAD.get());
			makeHead(SILVERFISH_HEAD.get(), SILVERFISH_WALL_HEAD.get());
			makeHead(SLIME_HEAD.get(), SLIME_WALL_HEAD.get());
			makeHead(SNOW_GOLEM_HEAD.get(), SNOW_GOLEM_WALL_HEAD.get());
			makeHead(SPIDER_HEAD.get(), SPIDER_WALL_HEAD.get());
			makeHead(SQUID_HEAD.get(), SQUID_WALL_HEAD.get());
			makeHead(TURTLE_HEAD.get(), TURTLE_WALL_HEAD.get());
			makeHead(VILLAGER_HEAD.get(), VILLAGER_WALL_HEAD.get());
			makeHead(WANDERING_TRADER_HEAD.get(), WANDERING_TRADER_WALL_HEAD.get());
			makeHead(WITCH_HEAD.get(), WITCH_WALL_HEAD.get());
			makeHead(WOLF_HEAD.get(), WOLF_WALL_HEAD.get());
			makeHead(YELLOW_SHEEP_HEAD.get(), YELLOW_SHEEP_WALL_HEAD.get());
			makeHead(ZOMBIE_VILLAGER_HEAD.get(), ZOMBIE_VILLAGER_WALL_HEAD.get());
			makeHead(ZOMBIFIED_PIGLIN_SKULL.get(), ZOMBIFIED_PIGLIN_WALL_SKULL.get());
		}

		private void makeHead(Block block, Block wallBlock) {
			ModelFile model = models().getExistingFile(mcLoc("block/skull"));
			getVariantBuilder(block)
					.partialState().modelForState().modelFile(model).addModel();
			getVariantBuilder(wallBlock)
					.partialState().modelForState().modelFile(model).addModel();
		}
	}

	static class ItemModels extends ItemModelProvider {
		public ItemModels(DataGenerator gen, ExistingFileHelper helper) {
			super(gen, Heads.MOD_ID, helper);
		}

		@Override
		protected void registerModels() {
			makeAxolotlHead(AXOLOTL_LUCY_HEAD.get());
			makeAxolotlHead(AXOLOTL_WILD_HEAD.get());
			makeAxolotlHead(AXOLOTL_GOLD_HEAD.get());
			makeAxolotlHead(AXOLOTL_CYAN_HEAD.get());
			makeAxolotlHead(AXOLOTL_BLUE_HEAD.get());
			makeBatHead(BAT_HEAD.get());
			makeHead(BEE_HEAD.get());
			makeHead(BLAZE_HEAD.get());
			makeMooshroom(BROWN_MOOSHROOM_HEAD.get());
			makeOcelotHead(CAT_TABBY_HEAD.get());
			makeOcelotHead(CAT_BLACK_HEAD.get());
			makeOcelotHead(CAT_RED_HEAD.get());
			makeOcelotHead(CAT_SIAMESE_HEAD.get());
			makeOcelotHead(CAT_BRITISH_SHORTHAIR_HEAD.get());
			makeOcelotHead(CAT_CALICO_HEAD.get());
			makeOcelotHead(CAT_PERSIAN_HEAD.get());
			makeOcelotHead(CAT_RAGDOLL_HEAD.get());
			makeOcelotHead(CAT_WHITE_HEAD.get());
			makeOcelotHead(CAT_JELLIE_HEAD.get());
			makeOcelotHead(CAT_ALL_BLACK_HEAD.get());
			makeHead(CAVE_SPIDER_HEAD.get());
			makeChickenHead(CHICKEN_HEAD.get());
			makeHead(COW_HEAD.get());
			makeHead(DONKEY_HEAD.get());
			makeHead(ENDERMAN_HEAD.get());
			makeEndermiteHead(ENDERMITE_HEAD.get());
			makeHead(FOX_HEAD.get());
			makeHead(FOX_SNOW_HEAD.get());
			makeHead(GHAST_HEAD.get());
			makeHead(GLOW_SQUID_HEAD.get());
			makeGoat(GOAT_HEAD.get());
			makeHorse(HORSE_WHITE_HEAD.get());
			makeHorse(HORSE_CREAMY_HEAD.get());
			makeHorse(HORSE_CHESTNUT_HEAD.get());
			makeHorse(HORSE_BROWN_HEAD.get());
			makeHorse(HORSE_BLACK_HEAD.get());
			makeHorse(HORSE_GRAY_HEAD.get());
			makeHorse(HORSE_DARKBROWN_HEAD.get());
			makeHorse(HORSE_UNDEAD_HEAD.get());
			makeHorse(HORSE_SKELETON_HEAD.get());
			makeVillagerHead(IRON_GOLEM_HEAD.get());
			makeHead(MAGMA_CUBE_HEAD.get());
			makeOcelotHead(OCELOT_HEAD.get());
			makeHead(PIG_HEAD.get());
			makeHead(PIGLIN_BRUTE_HEAD.get());
			makeHead(PIGLIN_HEAD.get());
			makeMooshroom(RED_MOOSHROOM_HEAD.get());
			makeHead(SHEEP_HEAD.get());
			makeHead(ORANGE_SHEEP_HEAD.get());
			makeHead(MAGENTA_SHEEP_HEAD.get());
			makeHead(LIGHT_BLUE_SHEEP_HEAD.get());
			makeHead(YELLOW_SHEEP_HEAD.get());
			makeHead(LIME_SHEEP_HEAD.get());
			makeHead(PINK_SHEEP_HEAD.get());
			makeHead(GRAY_SHEEP_HEAD.get());
			makeHead(LIGHT_GRAY_SHEEP_HEAD.get());
			makeHead(CYAN_SHEEP_HEAD.get());
			makeHead(PURPLE_SHEEP_HEAD.get());
			makeHead(BLUE_SHEEP_HEAD.get());
			makeHead(BROWN_SHEEP_HEAD.get());
			makeHead(GREEN_SHEEP_HEAD.get());
			makeHead(RED_SHEEP_HEAD.get());
			makeHead(BLACK_SHEEP_HEAD.get());
			makeHead(SHEEP_SHAVEN_HEAD.get());
			makeHead(SILVERFISH_HEAD.get());
			makeHead(SLIME_HEAD.get());
			makeHead(SNOW_GOLEM_HEAD.get());
			makeHead(SPIDER_HEAD.get());
			makeHead(SQUID_HEAD.get());
			makeHead(TURTLE_HEAD.get());
			makeWolfHead(WOLF_HEAD.get());
			makeHead(ZOMBIFIED_PIGLIN_SKULL.get());
			makeVillagerHead(VILLAGER_HEAD.get());
			makeVillagerHead(WANDERING_TRADER_HEAD.get());
			makeVillagerHead(ZOMBIE_VILLAGER_HEAD.get());
			makeWitchHead(WITCH_HEAD.get());
		}

		private void makeHorse(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 45, 0)
					.translation(0, 0, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.625F, 0.625F, 0.625F).end();
		}

		private void makeGoat(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 45, 0)
					.translation(0, 0, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.625F, 0.625F, 0.625F).end();
		}

		private void makeMooshroom(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 45, 0)
					.translation(0, 0, 0)
					.scale(0.875F, 0.875F, 0.875F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.875F, 0.875F, 0.875F).end();
		}

		private void makeWitchHead(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 40, 0)
					.translation(0, 1F, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.625F, 0.625F, 0.625F).end();
		}

		private void makeVillagerHead(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 40, 0)
					.translation(0, 3, 0)
					.scale(0.875F, 0.875F, 0.875F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.875F, 0.875F, 0.875F).end();
		}

		private void makeChickenHead(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 3.5F, 0)
					.scale(1.25F, 1.25F, 1.25F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.25F, 1.25F, 1.25F).end();
		}

		private void makeEndermiteHead(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 4.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();
		}

		private void makeAxolotlHead(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 3.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();
		}

		private void makeBatHead(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 3.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();;
		}

		private void makeOcelotHead(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 4.5F, 0)
					.scale(1.25F, 1.25F, 1.25F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.25F, 1.25F, 1.25F).end();
		}

		private void makeWolfHead(Block block) {
			getBuilder(block.getRegistryName().getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(Perspective.GUI)
					.rotation(30, 40, 0)
					.translation(1, 3.5F, 0)
					.scale(1.125F, 1.125F, 1.125F).end()
					.transform(Perspective.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.125F, 1.125F, 1.125F).end();
		}

		private void makeHead(Block block) {
			withExistingParent(block.getRegistryName().getPath(), mcLoc("item/template_skull"));
		}
	}

	public static class HeadBlockTags extends BlockTagsProvider {
		public HeadBlockTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
			super(generator, Heads.MOD_ID, existingFileHelper);
		}

		@Override
		protected void addTags() {

		}
	}

	public static class HeadItemTags extends ItemTagsProvider {
		public HeadItemTags(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
			super(dataGenerator, blockTagsProvider, Heads.MOD_ID, existingFileHelper);
		}

		public static final TagKey<Item> HEADS = forgeTag("heads");

		@Override
		protected void addTags() {
			this.addHead(Items.CREEPER_HEAD, "creeper");
			this.addHead(Items.DRAGON_HEAD, "dragon");
			this.addHead(Items.PLAYER_HEAD, "player");
			this.addHead(Items.ZOMBIE_HEAD, "zombie");
			this.addHead(Items.SKELETON_SKULL, "skeleton");
			this.addHead(Items.WITHER_SKELETON_SKULL, "wither_skeleton");

			this.addHead(AXOLOTL_LUCY_HEAD_ITEM.get(), "axolotl");
			this.addHead(AXOLOTL_WILD_HEAD_ITEM.get(), "axolotl");
			this.addHead(AXOLOTL_GOLD_HEAD_ITEM.get(), "axolotl");
			this.addHead(AXOLOTL_CYAN_HEAD_ITEM.get(), "axolotl");
			this.addHead(AXOLOTL_BLUE_HEAD_ITEM.get(), "axolotl");
			this.addHead(BAT_HEAD_ITEM.get(), "bat");
			this.addHead(BEE_HEAD_ITEM.get(), "bee");
			this.addHead(BLACK_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(BLAZE_HEAD_ITEM.get(), "blaze");
			this.addHead(BLUE_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(BROWN_MOOSHROOM_HEAD_ITEM.get(), "mooshroom");
			this.addHead(BROWN_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(CAT_ALL_BLACK_HEAD_ITEM.get(), "cat");
			this.addHead(CAT_BLACK_HEAD_ITEM.get(), "cat");
			this.addHead(CAT_BRITISH_SHORTHAIR_HEAD_ITEM.get(), "cat");
			this.addHead(CAT_CALICO_HEAD_ITEM.get(), "cat");
			this.addHead(CAT_JELLIE_HEAD_ITEM.get(), "cat");
			this.addHead(CAT_PERSIAN_HEAD_ITEM.get(), "cat");
			this.addHead(CAT_RAGDOLL_HEAD_ITEM.get(), "cat");
			this.addHead(CAT_RED_HEAD_ITEM.get(), "cat");
			this.addHead(CAT_SIAMESE_HEAD_ITEM.get(), "cat");
			this.addHead(CAT_TABBY_HEAD_ITEM.get(), "cat");
			this.addHead(CAT_WHITE_HEAD_ITEM.get(), "cat");
			this.addHead(CAVE_SPIDER_HEAD_ITEM.get(), "cave_spider");
			this.addHead(CHICKEN_HEAD_ITEM.get(), "chicken");
			this.addHead(COW_HEAD_ITEM.get(), "cow");
			this.addHead(CYAN_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(DONKEY_HEAD_ITEM.get(), "horse");
			this.addHead(ENDERMAN_HEAD_ITEM.get(), "enderman");
			this.addHead(ENDERMITE_HEAD_ITEM.get(), "endermite");
			this.addHead(FOX_HEAD_ITEM.get(), "fox");
			this.addHead(FOX_SNOW_HEAD_ITEM.get(), "fox");
			this.addHead(GHAST_HEAD_ITEM.get(), "ghast");
			this.addHead(GLOW_SQUID_HEAD_ITEM.get(), "glow_squid");
			this.addHead(GOAT_HEAD_ITEM.get(), "goat");
			this.addHead(GRAY_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(GREEN_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(HORSE_BLACK_HEAD_ITEM.get(), "horse");
			this.addHead(HORSE_BROWN_HEAD_ITEM.get(), "horse");
			this.addHead(HORSE_CHESTNUT_HEAD_ITEM.get(), "horse");
			this.addHead(HORSE_CREAMY_HEAD_ITEM.get(), "horse");
			this.addHead(HORSE_DARKBROWN_HEAD_ITEM.get(), "horse");
			this.addHead(HORSE_GRAY_HEAD_ITEM.get(), "horse");
			this.addHead(HORSE_SKELETON_HEAD_ITEM.get(), "horse");
			this.addHead(HORSE_UNDEAD_HEAD_ITEM.get(), "horse");
			this.addHead(HORSE_WHITE_HEAD_ITEM.get(), "horse");
			this.addHead(IRON_GOLEM_HEAD_ITEM.get(), "iron_golem");
			this.addHead(LIGHT_BLUE_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(LIGHT_GRAY_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(LIME_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(MAGENTA_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(MAGMA_CUBE_HEAD_ITEM.get(), "magma_cube");
			this.addHead(OCELOT_HEAD_ITEM.get(), "ocelot");
			this.addHead(ORANGE_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(PIGLIN_BRUTE_HEAD_ITEM.get(), "piglin_brute");
			this.addHead(PIGLIN_HEAD_ITEM.get(), "piglin");
			this.addHead(PIG_HEAD_ITEM.get(), "pig");
			this.addHead(PINK_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(PURPLE_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(RED_MOOSHROOM_HEAD_ITEM.get(), "mooshroom");
			this.addHead(RED_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(SHEEP_SHAVEN_HEAD_ITEM.get(), "sheep");
			this.addHead(SILVERFISH_HEAD_ITEM.get(), "silverfish");
			this.addHead(SLIME_HEAD_ITEM.get(), "slime");
			this.addHead(SNOW_GOLEM_HEAD_ITEM.get(), "snow_golem");
			this.addHead(SPIDER_HEAD_ITEM.get(), "spider");
			this.addHead(SQUID_HEAD_ITEM.get(), "squid");
			this.addHead(TURTLE_HEAD_ITEM.get(), "turtle");
			this.addHead(VILLAGER_HEAD_ITEM.get(), "villager");
			this.addHead(WANDERING_TRADER_HEAD_ITEM.get(), "wandering_trader");
			this.addHead(WITCH_HEAD_ITEM.get(), "witch");
			this.addHead(WOLF_HEAD_ITEM.get(), "wolf");
			this.addHead(YELLOW_SHEEP_HEAD_ITEM.get(), "sheep");
			this.addHead(ZOMBIE_VILLAGER_HEAD_ITEM.get(), "zombie_villager");
			this.addHead(ZOMBIFIED_PIGLIN_SKULL_ITEM.get(), "zombified_piglin");
		}

		private void addHead(Item block, String mobName) {
			TagKey<Item> headTag = forgeTag("heads/" + mobName);
			this.tag(HEADS).addTag(headTag);
			this.tag(headTag).add(block.asItem());
		}

		private static TagKey<Item> forgeTag(String name) {
			return ItemTags.create(new ResourceLocation("forge", name));
		}
	}
}
