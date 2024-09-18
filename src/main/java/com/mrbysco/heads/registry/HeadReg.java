package com.mrbysco.heads.registry;

import com.mrbysco.heads.Heads;
import com.mrbysco.heads.block.HeadBlock;
import com.mrbysco.heads.block.WallHeadBlock;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

public class HeadReg {
	protected final String mobName;
	protected final String headName;
	protected final HeadTypes headType;
	protected final DeferredBlock<HeadBlock> HEAD;
	protected final DeferredBlock<WallHeadBlock> WALL_HEAD;
	protected final DeferredItem<StandingAndWallBlockItem> HEAD_ITEM;
	protected final DeferredHolder<SoundEvent, SoundEvent> IMITATE_SOUND;

	public String getMobName() {
		return mobName;
	}

	public String getHeadName() {
		return headName;
	}

	public DeferredBlock<HeadBlock> getHead() {
		return HEAD;
	}

	public DeferredBlock<WallHeadBlock> getWallHead() {
		return WALL_HEAD;
	}

	public DeferredItem<StandingAndWallBlockItem> getHeadItem() {
		return HEAD_ITEM;
	}

	public DeferredHolder<SoundEvent, SoundEvent> getImitateSound() {
		return IMITATE_SOUND;
	}

	public HeadReg(String mobName, String headName, String suffix, HeadTypes headType) {
		this.mobName = mobName;
		this.headName = headName;
		this.headType = headType;
		String soundLocation = "heads.block.note_block.imitate." + headName;
		this.IMITATE_SOUND = HeadsRegistry.SOUND_EVENTS.register(soundLocation, () ->
				SoundEvent.createVariableRangeEvent(Heads.modLoc(soundLocation)));
		this.HEAD = HeadsRegistry.BLOCKS.register(headName + "_" + suffix, () -> new HeadBlock(headType,
				BlockBehaviour.Properties.ofFullCopy(Blocks.ZOMBIE_HEAD).instrument(NoteBlockInstrument.CUSTOM_HEAD)
						.strength(1.0F)));
		this.WALL_HEAD = HeadsRegistry.BLOCKS.register(headName + "_wall_" + suffix, () -> new WallHeadBlock(headType,
				BlockBehaviour.Properties.ofFullCopy(Blocks.ZOMBIE_HEAD).instrument(NoteBlockInstrument.CUSTOM_HEAD)
						.strength(1.0F).lootFrom(HEAD)));
		this.HEAD_ITEM = HeadsRegistry.ITEMS.register(headName + "_" + suffix, () -> new StandingAndWallBlockItem(
				HEAD.get(), WALL_HEAD.get(), (new Item.Properties())
				.component(DataComponents.NOTE_BLOCK_SOUND, this.IMITATE_SOUND.getId())
				.rarity(Rarity.UNCOMMON), Direction.DOWN));
		HeadsRegistry.headList.add(this);
		HeadsRegistry.headMap.put(headType, this);
	}

	public HeadReg(String mobName, String suffix, HeadTypes headType) {
		this(mobName, mobName, suffix, headType);
	}
}
