package com.mrbysco.heads.datagen.server;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.registry.HeadReg;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class HeadBlockTags extends BlockTagsProvider {
	public HeadBlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider, Heads.MOD_ID);
	}

	public static final List<String> knownHeads = new ArrayList<>();

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.addHead(Blocks.CREEPER_HEAD, "creeper");
		this.addHead(Blocks.CREEPER_WALL_HEAD, "creeper");
		this.addHead(Blocks.DRAGON_HEAD, "dragon");
		this.addHead(Blocks.DRAGON_WALL_HEAD, "dragon");
		this.addHead(Blocks.PLAYER_HEAD, "player");
		this.addHead(Blocks.PLAYER_WALL_HEAD, "player");
		this.addHead(Blocks.SKELETON_SKULL, "skeleton");
		this.addHead(Blocks.SKELETON_WALL_SKULL, "skeleton");
		this.addHead(Blocks.WITHER_SKELETON_SKULL, "wither_skeleton");
		this.addHead(Blocks.WITHER_SKELETON_WALL_SKULL, "wither_skeleton");
		this.addHead(Blocks.ZOMBIE_HEAD, "zombie");
		this.addHead(Blocks.ZOMBIE_WALL_HEAD, "zombie");

		HeadsRegistry.headList.forEach(this::addHead);
	}

	private void addHead(HeadReg headRegObject) {
		this.addHead(headRegObject.getHead().get(), headRegObject.getMobName());
		this.addHead(headRegObject.getWallHead().get(), headRegObject.getMobName());
	}

	private void addHead(Block block, String mobName) {
		TagKey<Block> headTag = commonTag("skulls/" + mobName);
		if (!knownHeads.contains("skulls/" + mobName)) {
			knownHeads.add("skulls/" + mobName);
			this.tag(Tags.Blocks.SKULLS).addTag(headTag);
		}
		this.tag(headTag).add(block);
	}

	private static TagKey<Block> commonTag(String name) {
		return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
	}
}
