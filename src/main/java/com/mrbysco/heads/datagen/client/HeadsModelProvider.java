package com.mrbysco.heads.datagen.client;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.registry.HeadReg;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public class HeadsModelProvider extends ModelProvider {
	public HeadsModelProvider(PackOutput packOutput) {
		super(packOutput, Heads.MOD_ID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		ResourceLocation resourcelocation = ModelLocationUtils.decorateItemModelLocation("template_skull");
		for (HeadReg reg : HeadsRegistry.headList) {
			blockModels.createHead(reg.getHead().get(), reg.getWallHead().get(), reg.getHeadType(), resourcelocation);
		}
	}

//	private void makeHorse(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 45, 0)
//				.translation(0, 0, 0)
//				.scale(0.625F, 0.625F, 0.625F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(0.625F, 0.625F, 0.625F).end();
//	}
//
//	private void makeGoat(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 45, 0)
//				.translation(0, 0, 0)
//				.scale(0.625F, 0.625F, 0.625F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(0.625F, 0.625F, 0.625F).end();
//	}
//
//	private void makeMooshroom(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 45, 0)
//				.translation(0, 0, 0)
//				.scale(0.875F, 0.875F, 0.875F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(0.875F, 0.875F, 0.875F).end();
//	}
//
//	private void makeWitchHead(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 40, 0)
//				.translation(0, 1F, 0)
//				.scale(0.625F, 0.625F, 0.625F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(0.625F, 0.625F, 0.625F).end();
//	}
//
//	private void makeVillagerHead(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 40, 0)
//				.translation(0, 3, 0)
//				.scale(0.875F, 0.875F, 0.875F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(0.875F, 0.875F, 0.875F).end();
//	}
//
//	private void makeHoglinHead(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 40, 0)
//				.translation(0, 3, 0)
//				.scale(0.625F, 0.625F, 0.625F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(0.875F, 0.875F, 0.875F).end();
//	}
//
//	private void makeChickenHead(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 40, 0)
//				.translation(1.5F, 3.5F, 0)
//				.scale(1.25F, 1.25F, 1.25F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(1.25F, 1.25F, 1.25F).end();
//	}
//
//	private void makeEndermiteHead(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 40, 0)
//				.translation(1.5F, 4.5F, 0)
//				.scale(1.5F, 1.5F, 1.5F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(1.5F, 1.5F, 1.5F).end();
//	}
//
//	private void makeAxolotlHead(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 40, 0)
//				.translation(1.5F, 3.5F, 0)
//				.scale(1.5F, 1.5F, 1.5F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(1.5F, 1.5F, 1.5F).end();
//	}
//
//	private void makeBatHead(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 40, 0)
//				.translation(1.5F, 3.5F, 0)
//				.scale(1.5F, 1.5F, 1.5F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(1.5F, 1.5F, 1.5F).end();
//	}
//
//	private void makeFishHead(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 40, 0)
//				.translation(3.5F, 3.5F, 0)
//				.scale(1.5F, 1.5F, 1.5F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(1.5F, 1.5F, 1.5F).end();
//	}
//
//	private void makeOcelotHead(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 40, 0)
//				.translation(1.5F, 4.5F, 0)
//				.scale(1.25F, 1.25F, 1.25F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(1.25F, 1.25F, 1.25F).end();
//	}
//
//	private void makeWolfHead(Block block) {
//		getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
//				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/template_skull")))
//				.transforms().transform(ItemDisplayContext.GUI)
//				.rotation(30, 40, 0)
//				.translation(1, 3.5F, 0)
//				.scale(1.125F, 1.125F, 1.125F).end()
//				.transform(ItemDisplayContext.FIXED)
//				.rotation(0, 180, 0)
//				.translation(0, 4, 0)
//				.scale(1.125F, 1.125F, 1.125F).end();
//	}
//
//	private void makeHead(Block block) {
//		withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(), mcLoc("item/template_skull"));
//	}
}
