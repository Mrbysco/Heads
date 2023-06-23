package com.mrbysco.heads.datagen;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.registry.HeadReg;
import com.mrbysco.heads.registry.HeadsRegistry;
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
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
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
				HeadsRegistry.headList.forEach(headReg -> this.dropSkull(headReg.getHead().get()));
			}

			private void dropSkull(Block block) {
				RESISTANT.add(block.asItem());
				this.add(block, Loots::createSingleItemTable);
			}

			@Override
			protected Iterable<Block> getKnownBlocks() {
				return HeadsRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
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
			map.forEach((name, table) -> table.validate(validationContext));
		}
	}

	static class Language extends LanguageProvider {
		public Language(PackOutput packOutput) {
			super(packOutput, Heads.MOD_ID, "en_us");
		}

		@Override
		protected void addTranslations() {
			add("itemGroup.heads", "Heads");

			this.addBlock(HeadsRegistry.AXOLOTL_BLUE.getHead(), "Axolotl Head");
			this.addBlock(HeadsRegistry.AXOLOTL_CYAN.getHead(), "Axolotl Head");
			this.addBlock(HeadsRegistry.AXOLOTL_GOLD.getHead(), "Axolotl Head");
			this.addBlock(HeadsRegistry.AXOLOTL_LUCY.getHead(), "Axolotl Head");
			this.addBlock(HeadsRegistry.AXOLOTL_WILD.getHead(), "Axolotl Head");
			this.addBlock(HeadsRegistry.BAT.getHead(), "Bat Head");
			this.addBlock(HeadsRegistry.BEE.getHead(), "Bee Head");
			this.addBlock(HeadsRegistry.BLAZE.getHead(), "Blaze Head");
			this.addBlock(HeadsRegistry.CAT_ALL_BLACK.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAT_BLACK.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAT_BRITISH_SHORTHAIR.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAT_CALICO.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAT_JELLIE.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAT_PERSIAN.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAT_RAGDOLL.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAT_RED.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAT_SIAMESE.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAT_TABBY.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAT_WHITE.getHead(), "Cat Head");
			this.addBlock(HeadsRegistry.CAVE_SPIDER.getHead(), "Cave Spider Head");
			this.addBlock(HeadsRegistry.CHICKEN.getHead(), "Chicken Head");
			this.addBlock(HeadsRegistry.COD.getHead(), "Cod Head");
			this.addBlock(HeadsRegistry.COW.getHead(), "Cow Head");
			this.addBlock(HeadsRegistry.DOLPHIN.getHead(), "Dolphin Head");
			this.addBlock(HeadsRegistry.DONKEY.getHead(), "Donkey Head");
			this.addBlock(HeadsRegistry.DROWNED.getHead(), "Drowned Head");
			this.addBlock(HeadsRegistry.ENDERMAN.getHead(), "Enderman Skull");
			this.addBlock(HeadsRegistry.ENDERMITE.getHead(), "Endermite Skull");
			this.addBlock(HeadsRegistry.EVOKER.getHead(), "Evoker Skull");
			this.addBlock(HeadsRegistry.FOX.getHead(), "Fox Skull");
			this.addBlock(HeadsRegistry.FOX_SNOW.getHead(), "Fox Skull");
			this.addBlock(HeadsRegistry.GHAST.getHead(), "Ghast Skull");
			this.addBlock(HeadsRegistry.GLOW_SQUID.getHead(), "Glow Squid Head");
			this.addBlock(HeadsRegistry.GOAT.getHead(), "Goat Head");
			this.addBlock(HeadsRegistry.HOGLIN.getHead(), "Hoglin Head");
			this.addBlock(HeadsRegistry.HORSE_BLACK.getHead(), "Horse Head");
			this.addBlock(HeadsRegistry.HORSE_BROWN.getHead(), "Horse Head");
			this.addBlock(HeadsRegistry.HORSE_CHESTNUT.getHead(), "Horse Head");
			this.addBlock(HeadsRegistry.HORSE_CREAMY.getHead(), "Horse Head");
			this.addBlock(HeadsRegistry.HORSE_DARKBROWN.getHead(), "Horse Head");
			this.addBlock(HeadsRegistry.HORSE_GRAY.getHead(), "Horse Head");
			this.addBlock(HeadsRegistry.HORSE_SKELETON.getHead(), "Skeleton Horse Head");
			this.addBlock(HeadsRegistry.HORSE_UNDEAD.getHead(), "Undead Horse Head");
			this.addBlock(HeadsRegistry.HORSE_WHITE.getHead(), "Horse Head");
			this.addBlock(HeadsRegistry.HUSK.getHead(), "Husk Head");
			this.addBlock(HeadsRegistry.ILLUSIONER.getHead(), "Illusioner Head");
			this.addBlock(HeadsRegistry.IRON_GOLEM.getHead(), "Iron Golem Head");
			this.addBlock(HeadsRegistry.MAGMA_CUBE.getHead(), "Magma Cube");
			this.addBlock(HeadsRegistry.MULE.getHead(), "Mule Head");
			this.addBlock(HeadsRegistry.MOOSHROOM_BROWN.getHead(), "Brown Mooshroom Head");
			this.addBlock(HeadsRegistry.MOOSHROOM_RED.getHead(), "Red Mooshroom Head");
			this.addBlock(HeadsRegistry.OCELOT.getHead(), "Ocelot Head");
			this.addBlock(HeadsRegistry.PIG.getHead(), "Pig Head");
			this.addBlock(HeadsRegistry.PIGLIN.getHead(), "Piglin Head");
			this.addBlock(HeadsRegistry.PIGLIN_BRUTE.getHead(), "Piglin Brute Head");
			this.addBlock(HeadsRegistry.PILLAGER.getHead(), "Pillager Head");
			this.addBlock(HeadsRegistry.SALMON.getHead(), "Salmon Head");
			this.addBlock(HeadsRegistry.SHEEP_BLACK.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_BLUE.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_BROWN.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_CYAN.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_GRAY.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_GREEN.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_LIGHT_BLUE.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_LIGHT_GRAY.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_LIME.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_MAGENTA.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_ORANGE.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_PINK.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_PURPLE.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_RED.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_SHAVEN.getHead(), "Sheep Head (Shaven)");
			this.addBlock(HeadsRegistry.SHEEP_WHITE.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SHEEP_YELLOW.getHead(), "Sheep Head");
			this.addBlock(HeadsRegistry.SILVERFISH.getHead(), "Silverfish");
			this.addBlock(HeadsRegistry.SLIME.getHead(), "Slime");
			this.addBlock(HeadsRegistry.SNOW_GOLEM.getHead(), "Snow Golem Head");
			this.addBlock(HeadsRegistry.SPIDER.getHead(), "Spider Head");
			this.addBlock(HeadsRegistry.SQUID.getHead(), "Squid Head");
			this.addBlock(HeadsRegistry.STRAY.getHead(), "Stray Head");
			this.addBlock(HeadsRegistry.TURTLE.getHead(), "Turtle Head");
			this.addBlock(HeadsRegistry.VILLAGER.getHead(), "Villager Head");
			this.addBlock(HeadsRegistry.VINDICATOR.getHead(), "Vindicator Head");
			this.addBlock(HeadsRegistry.WANDERING_TRADER.getHead(), "Wandering Trader Head");
			this.addBlock(HeadsRegistry.WITCH.getHead(), "Witch Head");
			this.addBlock(HeadsRegistry.WOLF.getHead(), "Wolf Head");
			this.addBlock(HeadsRegistry.ZOGLIN.getHead(), "Zoglin Head");
			this.addBlock(HeadsRegistry.ZOMBIE_VILLAGER.getHead(), "Zombie Villager Head");
			this.addBlock(HeadsRegistry.ZOMBIFIED_PIGLIN.getHead(), "Zombified Piglin Skull");
		}
	}

	static class BlockStates extends BlockStateProvider {
		public BlockStates(PackOutput packOutput, ExistingFileHelper helper) {
			super(packOutput, Heads.MOD_ID, helper);
		}

		@Override
		protected void registerStatesAndModels() {
			HeadsRegistry.headList.forEach(headReg -> makeHead(headReg.getHead().get(), headReg.getWallHead().get()));
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
			makeAxolotlHead(HeadsRegistry.AXOLOTL_BLUE.getHead().get());
			makeAxolotlHead(HeadsRegistry.AXOLOTL_CYAN.getHead().get());
			makeAxolotlHead(HeadsRegistry.AXOLOTL_GOLD.getHead().get());
			makeAxolotlHead(HeadsRegistry.AXOLOTL_LUCY.getHead().get());
			makeAxolotlHead(HeadsRegistry.AXOLOTL_WILD.getHead().get());
			makeBatHead(HeadsRegistry.BAT.getHead().get());
			makeChickenHead(HeadsRegistry.CHICKEN.getHead().get());
			makeEndermiteHead(HeadsRegistry.ENDERMITE.getHead().get());
			makeFishHead(HeadsRegistry.COD.getHead().get());
			makeFishHead(HeadsRegistry.SALMON.getHead().get());
			makeGoat(HeadsRegistry.GOAT.getHead().get());
			makeHead(HeadsRegistry.BEE.getHead().get());
			makeHead(HeadsRegistry.BLAZE.getHead().get());
			makeHead(HeadsRegistry.CAVE_SPIDER.getHead().get());
			makeHead(HeadsRegistry.COW.getHead().get());
			makeHead(HeadsRegistry.DOLPHIN.getHead().get());
			makeHead(HeadsRegistry.DONKEY.getHead().get());
			makeHead(HeadsRegistry.DROWNED.getHead().get());
			makeHead(HeadsRegistry.ENDERMAN.getHead().get());
			makeHead(HeadsRegistry.FOX.getHead().get());
			makeHead(HeadsRegistry.FOX_SNOW.getHead().get());
			makeHead(HeadsRegistry.GHAST.getHead().get());
			makeHead(HeadsRegistry.GLOW_SQUID.getHead().get());
			makeHead(HeadsRegistry.HUSK.getHead().get());
			makeHead(HeadsRegistry.MAGMA_CUBE.getHead().get());
			makeHead(HeadsRegistry.PIG.getHead().get());
			makeHead(HeadsRegistry.PIGLIN.getHead().get());
			makeHead(HeadsRegistry.PIGLIN_BRUTE.getHead().get());
			makeHead(HeadsRegistry.SHEEP_BLACK.getHead().get());
			makeHead(HeadsRegistry.SHEEP_BLUE.getHead().get());
			makeHead(HeadsRegistry.SHEEP_BROWN.getHead().get());
			makeHead(HeadsRegistry.SHEEP_CYAN.getHead().get());
			makeHead(HeadsRegistry.SHEEP_GRAY.getHead().get());
			makeHead(HeadsRegistry.SHEEP_GREEN.getHead().get());
			makeHead(HeadsRegistry.SHEEP_LIGHT_BLUE.getHead().get());
			makeHead(HeadsRegistry.SHEEP_LIGHT_GRAY.getHead().get());
			makeHead(HeadsRegistry.SHEEP_LIME.getHead().get());
			makeHead(HeadsRegistry.SHEEP_MAGENTA.getHead().get());
			makeHead(HeadsRegistry.SHEEP_ORANGE.getHead().get());
			makeHead(HeadsRegistry.SHEEP_PINK.getHead().get());
			makeHead(HeadsRegistry.SHEEP_PURPLE.getHead().get());
			makeHead(HeadsRegistry.SHEEP_RED.getHead().get());
			makeHead(HeadsRegistry.SHEEP_SHAVEN.getHead().get());
			makeHead(HeadsRegistry.SHEEP_WHITE.getHead().get());
			makeHead(HeadsRegistry.SHEEP_YELLOW.getHead().get());
			makeHead(HeadsRegistry.SILVERFISH.getHead().get());
			makeHead(HeadsRegistry.SLIME.getHead().get());
			makeHead(HeadsRegistry.SNOW_GOLEM.getHead().get());
			makeHead(HeadsRegistry.SPIDER.getHead().get());
			makeHead(HeadsRegistry.SQUID.getHead().get());
			makeHead(HeadsRegistry.STRAY.getHead().get());
			makeHead(HeadsRegistry.TURTLE.getHead().get());
			makeHead(HeadsRegistry.ZOMBIFIED_PIGLIN.getHead().get());
			makeHorse(HeadsRegistry.HORSE_BLACK.getHead().get());
			makeHorse(HeadsRegistry.HORSE_BROWN.getHead().get());
			makeHorse(HeadsRegistry.HORSE_CHESTNUT.getHead().get());
			makeHorse(HeadsRegistry.HORSE_CREAMY.getHead().get());
			makeHorse(HeadsRegistry.HORSE_DARKBROWN.getHead().get());
			makeHorse(HeadsRegistry.HORSE_GRAY.getHead().get());
			makeHorse(HeadsRegistry.HORSE_SKELETON.getHead().get());
			makeHorse(HeadsRegistry.HORSE_UNDEAD.getHead().get());
			makeHorse(HeadsRegistry.HORSE_WHITE.getHead().get());
			makeHorse(HeadsRegistry.MULE.getHead().get());
			makeMooshroom(HeadsRegistry.MOOSHROOM_BROWN.getHead().get());
			makeMooshroom(HeadsRegistry.MOOSHROOM_RED.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_ALL_BLACK.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_BLACK.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_BRITISH_SHORTHAIR.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_CALICO.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_JELLIE.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_PERSIAN.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_RAGDOLL.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_RED.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_SIAMESE.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_TABBY.getHead().get());
			makeOcelotHead(HeadsRegistry.CAT_WHITE.getHead().get());
			makeOcelotHead(HeadsRegistry.OCELOT.getHead().get());
			makeVillagerHead(HeadsRegistry.EVOKER.getHead().get());
			makeVillagerHead(HeadsRegistry.ILLUSIONER.getHead().get());
			makeVillagerHead(HeadsRegistry.IRON_GOLEM.getHead().get());
			makeVillagerHead(HeadsRegistry.PILLAGER.getHead().get());
			makeVillagerHead(HeadsRegistry.VILLAGER.getHead().get());
			makeVillagerHead(HeadsRegistry.VINDICATOR.getHead().get());
			makeVillagerHead(HeadsRegistry.WANDERING_TRADER.getHead().get());
			makeVillagerHead(HeadsRegistry.ZOMBIE_VILLAGER.getHead().get());
			makeWitchHead(HeadsRegistry.WITCH.getHead().get());
			makeHoglinHead(HeadsRegistry.HOGLIN.getHead().get());
			makeHoglinHead(HeadsRegistry.ZOGLIN.getHead().get());
			makeWolfHead(HeadsRegistry.WOLF.getHead().get());
		}

		private void makeHorse(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 45, 0)
					.translation(0, 0, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.625F, 0.625F, 0.625F).end();
		}

		private void makeGoat(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 45, 0)
					.translation(0, 0, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.625F, 0.625F, 0.625F).end();
		}

		private void makeMooshroom(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 45, 0)
					.translation(0, 0, 0)
					.scale(0.875F, 0.875F, 0.875F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.875F, 0.875F, 0.875F).end();
		}

		private void makeWitchHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 40, 0)
					.translation(0, 1F, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.625F, 0.625F, 0.625F).end();
		}

		private void makeVillagerHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 40, 0)
					.translation(0, 3, 0)
					.scale(0.875F, 0.875F, 0.875F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.875F, 0.875F, 0.875F).end();
		}

		private void makeHoglinHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 40, 0)
					.translation(0, 3, 0)
					.scale(0.625F, 0.625F, 0.625F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(0.875F, 0.875F, 0.875F).end();
		}

		private void makeChickenHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 3.5F, 0)
					.scale(1.25F, 1.25F, 1.25F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.25F, 1.25F, 1.25F).end();
		}

		private void makeEndermiteHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 4.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();
		}

		private void makeAxolotlHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 3.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();
		}

		private void makeBatHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 3.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();
		}

		private void makeFishHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 40, 0)
					.translation(3.5F, 3.5F, 0)
					.scale(1.5F, 1.5F, 1.5F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.5F, 1.5F, 1.5F).end();
		}

		private void makeOcelotHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 40, 0)
					.translation(1.5F, 4.5F, 0)
					.scale(1.25F, 1.25F, 1.25F).end()
					.transform(ItemDisplayContext.FIXED)
					.rotation(0, 180, 0)
					.translation(0, 4, 0)
					.scale(1.25F, 1.25F, 1.25F).end();
		}

		private void makeWolfHead(Block block) {
			getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(new UncheckedModelFile(mcLoc("item/template_skull")))
					.transforms().transform(ItemDisplayContext.GUI)
					.rotation(30, 40, 0)
					.translation(1, 3.5F, 0)
					.scale(1.125F, 1.125F, 1.125F).end()
					.transform(ItemDisplayContext.FIXED)
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
			super(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), Heads.MOD_ID, existingFileHelper);
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

			HeadsRegistry.headList.forEach(this::addHead);
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
