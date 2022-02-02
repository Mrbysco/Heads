package com.mrbysco.heads.blockentity;

import com.mrbysco.heads.registry.HeadsRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class HeadBlockEntity extends SkullBlockEntity {
	public HeadBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}

	@Override
	public BlockEntityType<?> getType() {
		return HeadsRegistry.HEAD.get();
	}
}
