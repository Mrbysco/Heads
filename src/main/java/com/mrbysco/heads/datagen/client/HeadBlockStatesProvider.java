package com.mrbysco.heads.datagen.client;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class HeadBlockStatesProvider extends BlockStateProvider {
	public HeadBlockStatesProvider(PackOutput packOutput, ExistingFileHelper helper) {
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
