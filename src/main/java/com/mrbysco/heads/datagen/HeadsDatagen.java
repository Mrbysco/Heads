package com.mrbysco.heads.datagen;

import com.mrbysco.heads.datagen.client.HeadLanguageProvider;
import com.mrbysco.heads.datagen.client.HeadLootProvider;
import com.mrbysco.heads.datagen.client.HeadSoundProvider;
import com.mrbysco.heads.datagen.client.HeadsModelProvider;
import com.mrbysco.heads.datagen.server.HeadBlockTags;
import com.mrbysco.heads.datagen.server.HeadItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class HeadsDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(true, new HeadLootProvider(packOutput, lookupProvider));
		generator.addProvider(true, new HeadBlockTags(packOutput, lookupProvider));
		generator.addProvider(true, new HeadItemTagsProvider(packOutput, lookupProvider));

		generator.addProvider(true, new HeadLanguageProvider(packOutput));
		generator.addProvider(true, new HeadsModelProvider(packOutput));
		generator.addProvider(true, new HeadSoundProvider(packOutput));

	}
}
