package com.mrbysco.heads;

import com.mrbysco.heads.client.RenderHandler;
import com.mrbysco.heads.config.HeadConfig;
import com.mrbysco.heads.handler.DropHandler;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Heads.MOD_ID)
public class Heads {
	public static final String MOD_ID = "heads";
	public static final Logger LOGGER = LogManager.getLogger();

	public Heads(IEventBus eventBus, Dist dist, ModContainer container) {
		container.registerConfig(Type.COMMON, HeadConfig.commonSpec);
		eventBus.register(HeadConfig.class);

		HeadsRegistry.BLOCKS.register(eventBus);
		HeadsRegistry.ITEMS.register(eventBus);
		HeadsRegistry.CREATIVE_MODE_TABS.register(eventBus);
		HeadsRegistry.BLOCK_ENTITIES.register(eventBus);

		NeoForge.EVENT_BUS.addListener(DropHandler::onLivingDrop);

		if (dist.isClient()) {
			NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, RenderHandler::onArmorRender);
			container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
		}
	}
}
