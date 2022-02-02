package com.mrbysco.heads.registry;

import com.mrbysco.heads.Heads;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class HeadTabs {
	public static final CreativeModeTab TAB_HEADS = new CreativeModeTab(Heads.MOD_ID) {
		public ItemStack makeIcon() {
			return new ItemStack(HeadsRegistry.WITCH_HEAD.get());
		}
	};
}
