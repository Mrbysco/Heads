package com.mrbysco.heads.datagen.server;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.registry.HeadReg;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class HeadItemTagsProvider extends ItemTagsProvider {
	public HeadItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), Heads.MOD_ID, existingFileHelper);
	}

	public static final List<String> knownHeads = new ArrayList<>();

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
		TagKey<Item> headTag = commonTag("skulls/" + mobName);
		if (!knownHeads.contains("skulls/" + mobName)) {
			knownHeads.add("skulls/" + mobName);
			this.tag(ItemTags.SKULLS).addTag(headTag);
		}
		this.tag(headTag).add(item);
	}

	private static TagKey<Item> commonTag(String name) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
	}
}
