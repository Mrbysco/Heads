package com.mrbysco.heads.datagen.client;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class HeadItemModelsProvider extends ItemModelProvider {
	public HeadItemModelsProvider(PackOutput packOutput, ExistingFileHelper helper) {
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
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
		withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(), mcLoc("item/template_skull"));
	}
}
