package com.mrbysco.heads.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mrbysco.heads.Heads;
import com.mrbysco.heads.registry.HeadReg;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
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
		public static final List<Item> RESISTANT = new ArrayList<>();

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

			@Override
			protected void addTables() {
				headList.forEach(headReg -> this.dropSkull(headReg.getHead().get()));
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

			this.addBlock(AXOLOTL_LUCY.getHead(), "Axolotl Head");
			this.addBlock(AXOLOTL_WILD.getHead(), "Axolotl Head");
			this.addBlock(AXOLOTL_GOLD.getHead(), "Axolotl Head");
			this.addBlock(AXOLOTL_CYAN.getHead(), "Axolotl Head");
			this.addBlock(AXOLOTL_BLUE.getHead(), "Axolotl Head");
			this.addBlock(BAT.getHead(), "Bat Head");
			this.addBlock(BEE.getHead(), "Bee Head");
			this.addBlock(BLACK_SHEEP.getHead(), "Sheep Head");
			this.addBlock(BLAZE.getHead(), "Blaze Head");
			this.addBlock(BLUE_SHEEP.getHead(), "Sheep Head");
			this.addBlock(BROWN_MOOSHROOM.getHead(), "Brown Mooshroom Head");
			this.addBlock(BROWN_SHEEP.getHead(), "Sheep Head");
			this.addBlock(CAT_TABBY.getHead(), "Cat Head");
			this.addBlock(CAT_BLACK.getHead(), "Cat Head");
			this.addBlock(CAT_RED.getHead(), "Cat Head");
			this.addBlock(CAT_SIAMESE.getHead(), "Cat Head");
			this.addBlock(CAT_BRITISH_SHORTHAIR.getHead(), "Cat Head");
			this.addBlock(CAT_CALICO.getHead(), "Cat Head");
			this.addBlock(CAT_PERSIAN.getHead(), "Cat Head");
			this.addBlock(CAT_RAGDOLL.getHead(), "Cat Head");
			this.addBlock(CAT_WHITE.getHead(), "Cat Head");
			this.addBlock(CAT_JELLIE.getHead(), "Cat Head");
			this.addBlock(CAT_ALL_BLACK.getHead(), "Cat Head");
			this.addBlock(CAVE_SPIDER.getHead(), "Cave Spider Head");
			this.addBlock(CHICKEN.getHead(), "Chicken Head");
			this.addBlock(COW.getHead(), "Cow Head");
			this.addBlock(CYAN_SHEEP.getHead(), "Sheep Head");
			this.addBlock(DONKEY.getHead(), "Donkey Head");
			this.addBlock(ENDERMAN.getHead(), "Enderman Skull");
			this.addBlock(ENDERMITE.getHead(), "Endermite Skull");
			this.addBlock(FOX.getHead(), "Fox Skull");
			this.addBlock(FOX_SNOW.getHead(), "Fox Skull");
			this.addBlock(GHAST.getHead(), "Ghast Skull");
			this.addBlock(GLOW_SQUID.getHead(), "Glow Squid Head");
			this.addBlock(GOAT.getHead(), "Goat Head");
			this.addBlock(GRAY_SHEEP.getHead(), "Sheep Head");
			this.addBlock(GREEN_SHEEP.getHead(), "Sheep Head");
			this.addBlock(HORSE_WHITE.getHead(), "Horse Head");
			this.addBlock(HORSE_CREAMY.getHead(), "Horse Head");
			this.addBlock(HORSE_CHESTNUT.getHead(), "Horse Head");
			this.addBlock(HORSE_BROWN.getHead(), "Horse Head");
			this.addBlock(HORSE_BLACK.getHead(), "Horse Head");
			this.addBlock(HORSE_GRAY.getHead(), "Horse Head");
			this.addBlock(HORSE_DARKBROWN.getHead(), "Horse Head");
			this.addBlock(HORSE_UNDEAD.getHead(), "Undead Horse Head");
			this.addBlock(HORSE_SKELETON.getHead(), "Skeleton Horse Head");
			this.addBlock(IRON_GOLEM.getHead(), "Iron Golem Head");
			this.addBlock(LIGHT_BLUE_SHEEP.getHead(), "Sheep Head");
			this.addBlock(LIGHT_GRAY_SHEEP.getHead(), "Sheep Head");
			this.addBlock(LIME_SHEEP.getHead(), "Sheep Head");
			this.addBlock(MAGENTA_SHEEP.getHead(), "Sheep Head");
			this.addBlock(MAGMA_CUBE.getHead(), "Magma Cube");
			this.addBlock(OCELOT.getHead(), "Ocelot Head");
			this.addBlock(ORANGE_SHEEP.getHead(), "Sheep Head");
			this.addBlock(PIGLIN_BRUTE.getHead(), "Piglin Brute Head");
			this.addBlock(PIGLIN.getHead(), "Piglin Head");
			this.addBlock(PIG.getHead(), "Pig Head");
			this.addBlock(PINK_SHEEP.getHead(), "Sheep Head");
			this.addBlock(PURPLE_SHEEP.getHead(), "Sheep Head");
			this.addBlock(RED_MOOSHROOM.getHead(), "Red Mooshroom Head");
			this.addBlock(RED_SHEEP.getHead(), "Sheep Head");
			this.addBlock(SHEEP.getHead(), "Sheep Head");
			this.addBlock(SHEEP_SHAVEN.getHead(), "Sheep Head (Shaven)");
			this.addBlock(SILVERFISH.getHead(), "Silverfish");
			this.addBlock(SLIME.getHead(), "Slime");
			this.addBlock(SNOW_GOLEM.getHead(), "Snow Golem Head");
			this.addBlock(SPIDER.getHead(), "Spider Head");
			this.addBlock(SQUID.getHead(), "Squid Head");
			this.addBlock(TURTLE.getHead(), "Turtle Head");
			this.addBlock(VILLAGER.getHead(), "Villager Head");
			this.addBlock(WANDERING_TRADER.getHead(), "Wandering Trader Head");
			this.addBlock(WITCH.getHead(), "Witch Head");
			this.addBlock(WOLF.getHead(), "Wolf Head");
			this.addBlock(YELLOW_SHEEP.getHead(), "Sheep Head");
			this.addBlock(ZOMBIE_VILLAGER.getHead(), "Zombie Villager Head");
			this.addBlock(ZOMBIFIED_PIGLIN.getHead(), "Zombified Piglin Skull");
		}
	}

	static class BlockStates extends BlockStateProvider {
		public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
			super(gen, Heads.MOD_ID, helper);
		}

		@Override
		protected void registerStatesAndModels() {
			headList.forEach(headReg -> makeHead(headReg.getHead().get(), headReg.getWallHead().get()));
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
			makeAxolotlHead(AXOLOTL_LUCY.getHead().get());
			makeAxolotlHead(AXOLOTL_WILD.getHead().get());
			makeAxolotlHead(AXOLOTL_GOLD.getHead().get());
			makeAxolotlHead(AXOLOTL_CYAN.getHead().get());
			makeAxolotlHead(AXOLOTL_BLUE.getHead().get());
			makeBatHead(BAT.getHead().get());
			makeHead(BEE.getHead().get());
			makeHead(BLAZE.getHead().get());
			makeMooshroom(BROWN_MOOSHROOM.getHead().get());
			makeOcelotHead(CAT_TABBY.getHead().get());
			makeOcelotHead(CAT_BLACK.getHead().get());
			makeOcelotHead(CAT_RED.getHead().get());
			makeOcelotHead(CAT_SIAMESE.getHead().get());
			makeOcelotHead(CAT_BRITISH_SHORTHAIR.getHead().get());
			makeOcelotHead(CAT_CALICO.getHead().get());
			makeOcelotHead(CAT_PERSIAN.getHead().get());
			makeOcelotHead(CAT_RAGDOLL.getHead().get());
			makeOcelotHead(CAT_WHITE.getHead().get());
			makeOcelotHead(CAT_JELLIE.getHead().get());
			makeOcelotHead(CAT_ALL_BLACK.getHead().get());
			makeHead(CAVE_SPIDER.getHead().get());
			makeChickenHead(CHICKEN.getHead().get());
			makeHead(COW.getHead().get());
			makeHead(DONKEY.getHead().get());
			makeHead(ENDERMAN.getHead().get());
			makeEndermiteHead(ENDERMITE.getHead().get());
			makeHead(FOX.getHead().get());
			makeHead(FOX_SNOW.getHead().get());
			makeHead(GHAST.getHead().get());
			makeHead(GLOW_SQUID.getHead().get());
			makeGoat(GOAT.getHead().get());
			makeHorse(HORSE_WHITE.getHead().get());
			makeHorse(HORSE_CREAMY.getHead().get());
			makeHorse(HORSE_CHESTNUT.getHead().get());
			makeHorse(HORSE_BROWN.getHead().get());
			makeHorse(HORSE_BLACK.getHead().get());
			makeHorse(HORSE_GRAY.getHead().get());
			makeHorse(HORSE_DARKBROWN.getHead().get());
			makeHorse(HORSE_UNDEAD.getHead().get());
			makeHorse(HORSE_SKELETON.getHead().get());
			makeVillagerHead(IRON_GOLEM.getHead().get());
			makeHead(MAGMA_CUBE.getHead().get());
			makeOcelotHead(OCELOT.getHead().get());
			makeHead(PIG.getHead().get());
			makeHead(PIGLIN_BRUTE.getHead().get());
			makeHead(PIGLIN.getHead().get());
			makeMooshroom(RED_MOOSHROOM.getHead().get());
			makeHead(SHEEP.getHead().get());
			makeHead(ORANGE_SHEEP.getHead().get());
			makeHead(MAGENTA_SHEEP.getHead().get());
			makeHead(LIGHT_BLUE_SHEEP.getHead().get());
			makeHead(YELLOW_SHEEP.getHead().get());
			makeHead(LIME_SHEEP.getHead().get());
			makeHead(PINK_SHEEP.getHead().get());
			makeHead(GRAY_SHEEP.getHead().get());
			makeHead(LIGHT_GRAY_SHEEP.getHead().get());
			makeHead(CYAN_SHEEP.getHead().get());
			makeHead(PURPLE_SHEEP.getHead().get());
			makeHead(BLUE_SHEEP.getHead().get());
			makeHead(BROWN_SHEEP.getHead().get());
			makeHead(GREEN_SHEEP.getHead().get());
			makeHead(RED_SHEEP.getHead().get());
			makeHead(BLACK_SHEEP.getHead().get());
			makeHead(SHEEP_SHAVEN.getHead().get());
			makeHead(SILVERFISH.getHead().get());
			makeHead(SLIME.getHead().get());
			makeHead(SNOW_GOLEM.getHead().get());
			makeHead(SPIDER.getHead().get());
			makeHead(SQUID.getHead().get());
			makeHead(TURTLE.getHead().get());
			makeWolfHead(WOLF.getHead().get());
			makeHead(ZOMBIFIED_PIGLIN.getHead().get());
			makeVillagerHead(VILLAGER.getHead().get());
			makeVillagerHead(WANDERING_TRADER.getHead().get());
			makeVillagerHead(ZOMBIE_VILLAGER.getHead().get());
			makeWitchHead(WITCH.getHead().get());
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
					.scale(1.5F, 1.5F, 1.5F).end();
			;
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

		public static final List<String> knownHeads = new ArrayList<>();
		public static final TagKey<Item> HEADS = forgeTag("heads");

		@Override
		protected void addTags() {
			this.addHead(Items.CREEPER_HEAD, "creeper");
			this.addHead(Items.DRAGON_HEAD, "dragon");
			this.addHead(Items.PLAYER_HEAD, "player");
			this.addHead(Items.ZOMBIE_HEAD, "zombie");
			this.addHead(Items.SKELETON_SKULL, "skeleton");
			this.addHead(Items.WITHER_SKELETON_SKULL, "wither_skeleton");

			headList.forEach(headReg -> addHead(headReg));
		}

		private void addHead(HeadReg headRegObject) {
			this.addHead(headRegObject.getHeadItem().get(), headRegObject.getMobName());
		}

		private void addHead(Item item, String mobName) {
			TagKey<Item> headTag = forgeTag("heads/" + mobName);
			if(!knownHeads.contains("heads/" + mobName)) {
				knownHeads.add("heads/" + mobName);
				this.tag(HEADS).addTag(headTag);
			}
			this.tag(headTag).add(item);
		}

		private static TagKey<Item> forgeTag(String name) {
			return ItemTags.create(new ResourceLocation("forge", name));
		}
	}
}
