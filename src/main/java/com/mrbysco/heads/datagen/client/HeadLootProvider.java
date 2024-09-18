package com.mrbysco.heads.datagen.client;

import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class HeadLootProvider extends LootTableProvider {
	public HeadLootProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, Set.of(), List.of(
				new SubProviderEntry(HeadLootProvider.HeadsBlockTables::new, LootContextParamSets.BLOCK)
		), lookupProvider);
	}

	public static final List<Item> RESISTANT = new ArrayList<>();

	public static class HeadsBlockTables extends BlockLootSubProvider {
		protected HeadsBlockTables(HolderLookup.Provider provider) {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
		}

		@Override
		protected void generate() {
			HeadsRegistry.headList.forEach(headReg -> this.dropSkull(headReg.getHead().get()));
		}

		private void dropSkull(Block block) {
			RESISTANT.add(block.asItem());
			this.add(block, HeadLootProvider::createSingleItemTable);
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return HeadsRegistry.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get())::iterator;
		}
	}

	protected static <T extends ConditionUserBuilder<T>> T applyExplosionCondition(ItemLike itemLike, ConditionUserBuilder<T> conditionUserBuilder) {
		return !RESISTANT.contains(itemLike.asItem()) ? conditionUserBuilder.when(ExplosionCondition.survivesExplosion()) : conditionUserBuilder.unwrap();
	}

	protected static LootTable.Builder createSingleItemTable(ItemLike itemLike) {
		return LootTable.lootTable().withPool(applyExplosionCondition(itemLike, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))));
	}

	@Override
	protected void validate(WritableRegistry<LootTable> writableregistry, ValidationContext validationcontext, ProblemReporter.Collector problemreporter$collector) {
		super.validate(writableregistry, validationcontext, problemreporter$collector);
	}
}