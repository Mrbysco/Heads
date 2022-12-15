package com.mrbysco.heads.registry;

import com.mrbysco.heads.Heads;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class HeadTabs {

	private static CreativeModeTab TAB_HEADS;

	@SubscribeEvent
	public void registerCreativeTabs(final CreativeModeTabEvent.Register event) {
		TAB_HEADS = event.registerCreativeModeTab(new ResourceLocation(Heads.MOD_ID, "tab"), builder ->
				builder.icon(() -> new ItemStack(HeadsRegistry.WITCH.getHead().get()))
						.title(Component.translatable("itemGroup.heads"))
						.displayItems((features, output, hasPermissions) -> {
							List<ItemStack> stacks = HeadsRegistry.ITEMS.getEntries().stream().map(reg -> new ItemStack(reg.get())).toList();
							output.acceptAll(stacks);
						}));
	}
}
