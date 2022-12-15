package com.mrbysco.heads.datagen;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.registry.HeadReg;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.mrbysco.heads.registry.HeadsRegistry.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HeadsDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper helper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		if (event.includeServer()) {
			generator.addProvider(event.includeServer(), new Loots(packOutput));
			BlockTagsProvider blockProvider;
			generator.addProvider(event.includeServer(), blockProvider = new HeadBlockTags(packOutput, lookupProvider, helper));
			generator.addProvider(event.includeServer(), new HeadItemTags(packOutput, lookupProvider, blockProvider, helper));
		}
		if (event.includeClient()) {
			generator.addProvider(event.includeClient(), new Language(packOutput));
			generator.addProvider(event.includeClient(), new ItemModels(packOutput, helper));
			generator.addProvider(event.includeClient(), new BlockStates(packOutput, helper));
		}
	}

	static class Loots extends LootTableProvider {
		public Loots(PackOutput packOutput) {
			super(packOutput, Set.of(), List.of(
					new SubProviderEntry(HeadsBlockTables::new, LootContextParamSets.BLOCK)
			));
		}

		public static final List<Item> RESISTANT = new ArrayList<>();

		public static class HeadsBlockTables extends BlockLootSubProvider {
			protected HeadsBlockTables() {
				super(Set.of(), FeatureFlags.REGISTRY.allFlags());
			}

			@Override
			protected void generate() {
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

		protected static <T extends ConditionUserBuilder<T>> T applyExplosionCondition(ItemLike itemLike, ConditionUserBuilder<T> conditionUserBuilder) {
			return !RESISTANT.contains(itemLike.asItem()) ? conditionUserBuilder.when(ExplosionCondition.survivesExplosion()) : conditionUserBuilder.unwrap();
		}

		protected static LootTable.Builder createSingleItemTable(ItemLike itemLike) {
			return LootTable.lootTable().withPool(applyExplosionCondition(itemLike, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))));
		}

		@Override
		protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {
			map.forEach((name, table) -> LootTables.validate(validationContext, name, table));
		}
	}

	static class Language extends LanguageProvider {
		public Language(PackOutput packOutput) {
			super(packOutput, Heads.MOD_ID, "en_us");
		}

		@Override
		protected void addTranslations() {
			add("itemGroup.heads", "Heads");

			this.addBlock(AXOLOTL_BLUE.getHead(), "Axolotl Head");
			this.addBlock(AXOLOTL_CYAN.getHead(), "Axolotl Head");
			this.addBlock(AXOLOTL_GOLD.getHead(), "Axolotl Head");
			this.addBlock(AXOLOTL_LUCY.getHead(), "Axolotl Head");
			this.addBlock(AXOLOTL_WILD.getHead(), "Axolotl Head");
			this.addBlock(BAT.getHead(), "Bat Head");
			this.addBlock(BEE.getHead(), "Bee Head");
			this.addBlock(BLAZE.getHead(), "Blaze Head");
			this.addBlock(CAT_ALL_BLACK.getHead(), "Cat Head");
			this.addBlock(CAT_BLACK.getHead(), "Cat Head");
			this.addBlock(CAT_BRITISH_SHORTHAIR.getHead(), "Cat Head");
			this.addBlock(CAT_CALICO.getHead(), "Cat Head");
			this.addBlock(CAT_JELLIE.getHead(), "Cat Head");
			this.addBlock(CAT_PERSIAN.getHead(), "Cat Head");
			this.addBlock(CAT_RAGDOLL.getHead(), "Cat Head");
			this.addBlock(CAT_RED.getHead(), "Cat Head");
			this.addBlock(CAT_SIAMESE.getHead(), "Cat Head");
			this.addBlock(CAT_TABBY.getHead(), "Cat Head");
			this.addBlock(CAT_WHITE.getHead(), "Cat Head");
			this.addBlock(CAVE_SPIDER.getHead(), "Cave Spider Head");
			this.addBlock(CHICKEN.getHead(), "Chicken Head");
			this.addBlock(COD.getHead(), "Cod Head");
			this.addBlock(COW.getHead(), "Cow Head");
			this.addBlock(DOLPHIN.getHead(), "Dolphin Head");
			this.addBlock(DONKEY.getHead(), "Donkey Head");
			this.addBlock(DROWNED.getHead(), "Drowned Head");
			this.addBlock(ENDERMAN.getHead(), "Enderman Skull");
			this.addBlock(ENDERMITE.getHead(), "Endermite Skull");
			this.addBlock(EVOKER.getHead(), "Evoker Skull");
			this.addBlock(FOX.getHead(), "Fox Skull");
			this.addBlock(FOX_SNOW.getHead(), "Fox Skull");
			this.addBlock(GHAST.getHead(), "Ghast Skull");
			this.addBlock(GLOW_SQUID.getHead(), "Glow Squid Head");
			this.addBlock(GOAT.getHead(), "Goat Head");
			this.addBlock(HOGLIN.getHead(), "Hoglin Head");
			this.addBlock(HORSE_BLACK.getHead(), "Horse Head");
			this.addBlock(HORSE_BROWN.getHead(), "Horse Head");
			this.addBlock(HORSE_CHESTNUT.getHead(), "Horse Head");
			this.addBlock(HORSE_CREAMY.getHead(), "Horse Head");
			this.addBlock(HORSE_DARKBROWN.getHead(), "Horse Head");
			this.addBlock(HORSE_GRAY.getHead(), "Horse Head");
			this.addBlock(HORSE_SKELETON.getHead(), "Skeleton Horse Head");
			this.addBlock(HORSE_UNDEAD.getHead(), "Undead Horse Head");
			this.addBlock(HORSE_WHITE.getHead(), "Horse Head");
			this.addBlock(HUSK.getHead(), "Husk Head");
			this.addBlock(ILLUSIONER.getHead(), "Illusioner Head");
			this.addBlock(IRON_GOLEM.getHead(), "Iron Golem Head");
			this.addBlock(MAGMA_CUBE.getHead(), "Magma Cube");
			this.addBlock(MULE.getHead(), "Mule Head");
			this.addBlock(MOOSHROOM_BROWN.getHead(), "Brown Mooshroom Head");
			this.addBlock(MOOSHROOM_RED.getHead(), "Red Mooshroom Head");
			this.addBlock(OCELOT.getHead(), "Ocelot Head");
			this.addBlock(PIG.getHead(), "Pig Head");
			this.addBlock(PIGLIN.getHead(), "Piglin Head");
			this.addBlock(PIGLIN_BRUTE.getHead(), "Piglin Brute Head");
			this.addBlock(PILLAGER.getHead(), "Pillager Head");
			this.addBlock(SALMON.getHead(), "Salmon Head");
			this.addBlock(SHEEP_BLACK.getHead(), "Sheep Head");
			this.addBlock(SHEEP_BLUE.getHead(), "Sheep Head");
			this.addBlock(SHEEP_BROWN.getHead(), "Sheep Head");
			this.addBlock(SHEEP_CYAN.getHead(), "Sheep Head");
			this.addBlock(SHEEP_GRAY.getHead(), "Sheep Head");
			this.addBlock(SHEEP_GREEN.getHead(), "Sheep Head");
			this.addBlock(SHEEP_LIGHT_BLUE.getHead(), "Sheep Head");
			this.addBlock(SHEEP_LIGHT_GRAY.getHead(), "Sheep Head");
			this.addBlock(SHEEP_LIME.getHead(), "Sheep Head");
			this.addBlock(SHEEP_MAGENTA.getHead(), "Sheep Head");
			this.addBlock(SHEEP_ORANGE.getHead(), "Sheep Head");
			this.addBlock(SHEEP_PINK.getHead(), "Sheep Head");
			this.addBlock(SHEEP_PURPLE.getHead(), "Sheep Head");
			this.addBlock(SHEEP_RED.getHead(), "Sheep Head");
			this.addBlock(SHEEP_SHAVEN.getHead(), "Sheep Head (Shaven)");
			this.addBlock(SHEEP_WHITE.getHead(), "Sheep Head");
			this.addBlock(SHEEP_YELLOW.getHead(), "Sheep Head");
			this.addBlock(SILVERFISH.getHead(), "Silverfish");
			this.addBlock(SLIME.getHead(), "Slime");
			this.addBlock(SNOW_GOLEM.getHead(), "Snow Golem Head");
			this.addBlock(SPIDER.getHead(), "Spider Head");
			this.addBlock(SQUID.getHead(), "Squid Head");
			this.addBlock(STRAY.getHead(), "Stray Head");
			this.addBlock(TURTLE.getHead(), "Turtle Head");
			this.addBlock(VILLAGER.getHead(), "Villager Head");
			this.addBlock(VINDICATOR.getHead(), "Vindicator Head");
			this.addBlock(WANDERING_TRADER.getHead(), "Wandering Trader Head");
			this.addBlock(WITCH.getHead(), "Witch Head");
			this.addBlock(WOLF.getHead(), "Wolf Head");
			this.addBlock(ZOGLIN.getHead(), "Zoglin Head");
			this.addBlock(ZOMBIE_VILLAGER.getHead(), "Zombie Villager Head");
			this.addBlock(ZOMBIFIED_PIGLIN.getHead(), "Zombified Piglin Skull");
		}
	}

	static class BlockStates extends BlockStateProvider {
		public BlockStates(PackOutput packOutput, ExistingFileHelper helper) {
			super(packOutput, Heads.MOD_ID, helper);
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
		public ItemModels(PackOutput packOutput, ExistingFileHelper helper) {
			super(packOutput, Heads.MOD_ID, helper);
		}

		@Override
		protected void registerModels() {
			makeAxolotlHead(AXOLOTL_BLUE.getHead().get());
			makeAxolotlHead(AXOLOTL_CYAN.getHead().get());
			makeAxolotlHead(AXOLOTL_GOLD.getHead().get());
			makeAxolotlHead(AXOLOTL_LUCY.getHead().get());
			makeAxolotlHead(AXOLOTL_WILD.getHead().get());
			makeBatHead(BAT.getHead().get());
			makeChickenHead(CHICKEN.getHead().get());
			makeEndermiteHead(ENDERMITE.getHead().get());
			makeFishHead(COD.getHead().get());
			makeFishHead(SALMON.getHead().get());
			makeGoat(GOAT.getHead().get());
			makeHead(BEE.getHead().get());
			makeHead(BLAZE.getHead().get());
			makeHead(CAVE_SPIDER.getHead().get());
			makeHead(COW.getHead().get());
			makeHead(DOLPHIN.getHead().get());
			makeHead(DONKEY.getHead().get());
			makeHead(DROWNED.getHead().get());
			makeHead(ENDERMAN.getHead().get());
			makeHead(FOX.getHead().get());
			makeHead(FOX_SNOW.getHead().get());
			makeHead(GHAST.getHead().get());
			makeHead(GLOW_SQUID.getHead().get());
			makeHead(HUSK.getHead().get());
			makeHead(MAGMA_CUBE.getHead().get());
			makeHead(PIG.getHead().get());
			makeHead(PIGLIN.getHead().get());
			makeHead(PIGLIN_BRUTE.getHead().get());
			makeHead(SHEEP_BLACK.getHead().get());
			makeHead(SHEEP_BLUE.getHead().get());
			makeHead(SHEEP_BROWN.getHead().get());
			makeHead(SHEEP_CYAN.getHead().get());
			makeHead(SHEEP_GRAY.getHead().get());
			makeHead(SHEEP_GREEN.getHead().get());
			makeHead(SHEEP_LIGHT_BLUE.getHead().get());
			makeHead(SHEEP_LIGHT_GRAY.getHead().get());
			makeHead(SHEEP_LIME.getHead().get());
			makeHead(SHEEP_MAGENTA.getHead().get());
			makeHead(SHEEP_ORANGE.getHead().get());
			makeHead(SHEEP_PINK.getHead().get());
			makeHead(SHEEP_PURPLE.getHead().get());
			makeHead(SHEEP_RED.getHead().get());
			makeHead(SHEEP_SHAVEN.getHead().get());
			makeHead(SHEEP_WHITE.getHead().get());
			makeHead(SHEEP_YELLOW.getHead().get());
			makeHead(SILVERFISH.getHead().get());
			makeHead(SLIME.getHead().get());
			makeHead(SNOW_GOLEM.getHead().get());
			makeHead(SPIDER.getHead().get());
			makeHead(SQUID.getHead().get());
			makeHead(STRAY.getHead().get());
			makeHead(TURTLE.getHead().get());
			makeHead(ZOMBIFIED_PIGLIN.getHead().get());
			makeHorse(HORSE_BLACK.getHead().get());
			makeHorse(HORSE_BROWN.getHead().get());
			makeHorse(HORSE_CHESTNUT.getHead().get());
			makeHorse(HORSE_CREAMY.getHead().get());
			makeHorse(HORSE_DARKBROWN.getHead().get());
			makeHorse(HORSE_GRAY.getHead().get());
			makeHorse(HORSE_SKELETON.getHead().get());
			makeHorse(HORSE_UNDEAD.getHead().get());
			makeHorse(HORSE_WHITE.getHead().get());
			makeHorse(MULE.getHead().get());
			makeMooshroom(MOOSHROOM_BROWN.getHead().get());
			makeMooshroom(MOOSHROOM_RED.getHead().get());
			makeOcelotHead(CAT_ALL_BLACK.getHead().get());
			makeOcelotHead(CAT_BLACK.getHead().get());
			makeOcelotHead(CAT_BRITISH_SHORTHAIR.getHead().get());
			makeOcelotHead(CAT_CALICO.getHead().get());
			makeOcelotHead(CAT_JELLIE.getHead().get());
			makeOcelotHead(CAT_PERSIAN.getHead().get());
			makeOcelotHead(CAT_RAGDOLL.getHead().get());
			makeOcelotHead(CAT_RED.getHead().get());
			makeOcelotHead(CAT_SIAMESE.getHead().get());
			makeOcelotHead(CAT_TABBY.getHead().get());
			makeOcelotHead(CAT_WHITE.getHead().get());
			makeOcelotHead(OCELOT.getHead().get());
			makeVillagerHead(EVOKER.getHead().get());
			makeVillagerHead(ILLUSIONER.getHead().get());
			makeVillagerHead(IRON_GOLEM.getHead().get());
			makeVillagerHead(PILLAGER.getHead().get());
			makeVillagerHead(VILLAGER.getHead().get());
			makeVillagerHead(VINDICATOR.getHead().get());
			makeVillagerHead(WANDERING_TRADER.getHead().get());
			makeVillagerHead(ZOMBIE_VILLAGER.getHead().get());
			makeWitchHead(WITCH.getHead().get());
			makeHoglinHead(HOGLIN.getHead().get());
			makeHoglinHead(ZOGLIN.getHead().get());
			makeWolfHead(WOLF.getHead().get());
		}

		private void makeHorse(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 45, 0)
					.translation(0, 0, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.625F, 0.625F, 0.625F).end();
		}

		private void makeGoat(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 45, 0)
					.translation(0, 0, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.625F, 0.625F, 0.625F).end();
		}

		private void makeMooshroom(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 45, 0)
					.translation(0, 0, 0)
					.scale(0.875F, 0.875F, 0.875F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.875F, 0.875F, 0.875F).end();
		}

		private void makeWitchHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 40, 0)
					.translation(0, 1F, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.625F, 0.625F, 0.625F).end();
		}

		private void makeVillagerHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 40, 0)
					.translation(0, 3, 0)
					.scale(0.875F, 0.875F, 0.875F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.875F, 0.875F, 0.875F).end();
		}

		private void makeHoglinHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 40, 0)
					.translation(0, 3, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.875F, 0.875F, 0.875F).end();
		}

		private void makeChickenHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 3.5F, 0)
					.scale(1.25F, 1.25F, 1.25F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.25F, 1.25F, 1.25F).end();
		}

		private void makeEndermiteHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 4.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();
		}

		private void makeAxolotlHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 3.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();
		}

		private void makeBatHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 3.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();
		}

		private void makeFishHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 40, 0)
					.translation(3.5F, 3.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();
		}

		private void makeOcelotHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 4.5F, 0)
					.scale(1.25F, 1.25F, 1.25F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.25F, 1.25F, 1.25F).end();
		}

		private void makeWolfHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(TransformType.GUI)
					.rotation(30, 40, 0)
					.translation(1, 3.5F, 0)
					.scale(1.125F, 1.125F, 1.125F).end()
					.transform(TransformType.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.125F, 1.125F, 1.125F).end();
		}

		private void makeHead(Block block) {
			withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), mcLoc("item/template_skull"));
		}
	}

	public static class HeadBlockTags extends BlockTagsProvider {
		public HeadBlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
			super(packOutput, lookupProvider, Heads.MOD_ID, existingFileHelper);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {

		}
	}

	public static class HeadItemTags extends ItemTagsProvider {
		public HeadItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
			super(packOutput, lookupProvider, blockTagsProvider, Heads.MOD_ID, existingFileHelper);
		}

		public static final List<String> knownHeads = new ArrayList<>();
		public static final TagKey<Item> HEADS = forgeTag("heads");

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			this.addHead(Items.CREEPER_HEAD, "creeper");
			this.addHead(Items.DRAGON_HEAD, "dragon");
			this.addHead(Items.PLAYER_HEAD, "player");
			this.addHead(Items.SKELETON_SKULL, "skeleton");
			this.addHead(Items.WITHER_SKELETON_SKULL, "wither_skeleton");
			this.addHead(Items.ZOMBIE_HEAD, "zombie");

			headList.forEach(this::addHead);
		}

		private void addHead(HeadReg headRegObject) {
			this.addHead(headRegObject.getHeadItem().get(), headRegObject.getMobName());
		}

		private void addHead(Item item, String mobName) {
			TagKey<Item> headTag = forgeTag("heads/" + mobName);
			if (!knownHeads.contains("heads/" + mobName)) {
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
