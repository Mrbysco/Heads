package com.mrbysco.heads;

import com.mrbysco.heads.client.RenderHandler;
import com.mrbysco.heads.config.HeadConfig;
import com.mrbysco.heads.handler.DropHandler;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Heads.MOD_ID)
public class Heads {
	public static final String MOD_ID = "heads";
	public static final Logger LOGGER = LogManager.getLogger();

	public Heads() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(Type.COMMON, HeadConfig.commonSpec);
		eventBus.register(HeadConfig.class);

		HeadsRegistry.BLOCKS.register(eventBus);
		HeadsRegistry.ITEMS.register(eventBus);
		HeadsRegistry.CREATIVE_MODE_TABS.register(eventBus);
		HeadsRegistry.BLOCK_ENTITIES.register(eventBus);

		NeoForge.EVENT_BUS.addListener(DropHandler::onLivingDrop);

		if (FMLEnvironment.dist.isClient()) {
			NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, RenderHandler::onArmorRender);
		}
	}
}
