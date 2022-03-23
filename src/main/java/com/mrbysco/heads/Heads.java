package com.mrbysco.heads;

import com.mrbysco.heads.client.RenderHandler;
import com.mrbysco.heads.config.HeadConfig;
import com.mrbysco.heads.handler.DropHandler;
import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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
		HeadsRegistry.BLOCK_ENTITIES.register(eventBus);

		MinecraftForge.EVENT_BUS.addListener(DropHandler::onLivingDrop);

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			MinecraftForge.EVENT_BUS.addListener(EventPriority.LOWEST, RenderHandler::onArmorRender);
		});
	}
}
