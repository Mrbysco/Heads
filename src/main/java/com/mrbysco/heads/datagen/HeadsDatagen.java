package com.mrbysco.heads.datagen;

import com.mrbysco.heads.datagen.client.HeadBlockStatesProvider;
import com.mrbysco.heads.datagen.client.HeadItemModelsProvider;
import com.mrbysco.heads.datagen.client.HeadLanguageProvider;
import com.mrbysco.heads.datagen.client.HeadLootProvider;
import com.mrbysco.heads.datagen.client.HeadSoundProvider;
import com.mrbysco.heads.datagen.server.HeadBlockTags;
import com.mrbysco.heads.datagen.server.HeadItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class HeadsDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper helper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		if (event.includeServer()) {
			generator.addProvider(event.includeServer(), new HeadLootProvider(packOutput, lookupProvider));
			BlockTagsProvider blockProvider;
			generator.addProvider(event.includeServer(), blockProvider = new HeadBlockTags(packOutput, lookupProvider, helper));
			generator.addProvider(event.includeServer(), new HeadItemTagsProvider(packOutput, lookupProvider, blockProvider, helper));
		}
		if (event.includeClient()) {
			generator.addProvider(event.includeClient(), new HeadLanguageProvider(packOutput));
			generator.addProvider(event.includeClient(), new HeadItemModelsProvider(packOutput, helper));
			generator.addProvider(event.includeClient(), new HeadBlockStatesProvider(packOutput, helper));
			generator.addProvider(event.includeClient(), new HeadSoundProvider(packOutput, helper));
		}
	}
}
