package com.polyvalord.extcaves.world.placers;

import com.mojang.serialization.Codec;
import com.polyvalord.extcaves.blocks.basic.BlockTallCeilingWL;

import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;

public class PlacerDoubleCeiling extends BlockPlacer
{
	public static final Codec<PlacerDoubleCeiling> field_236443_b_;
	public static final PlacerDoubleCeiling field_236444_c_ = new PlacerDoubleCeiling();

	protected BlockPlacerType<?> func_230368_a_() 
	{
		return BlockPlacerType.DOUBLE_PLANT;
	}

	public void func_225567_a_(IWorld p_225567_1_, BlockPos p_225567_2_, BlockState p_225567_3_, Random p_225567_4_) 
	{
		((BlockTallCeilingWL) p_225567_3_.getBlock()).placeAt(p_225567_1_, p_225567_2_, 2);
	}

	static 
	{
		field_236443_b_ = Codec.unit(() -> 
		{
			return field_236444_c_;
		});
	}
	
}