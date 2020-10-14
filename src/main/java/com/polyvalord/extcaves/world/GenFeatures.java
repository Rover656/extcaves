package com.polyvalord.extcaves.world;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.polyvalord.extcaves.blocks.RegBlocks;
import com.polyvalord.extcaves.config.Config;

import com.polyvalord.extcaves.world.placers.PlacerDoubleCeiling;
import com.polyvalord.extcaves.world.placers.PlacerDoubleGround;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class GenFeatures {
//    // Helper class
//    private static class CountRangeConfig {
//        int count;
//        int bottomOffset;
//        int topOffset;
//        int maximum;
//
//        public CountRangeConfig(int count, int bottomOffset, int topOffset, int maximum) {
//            this.count = count;
//            this.bottomOffset = bottomOffset;
//            this.topOffset = topOffset;
//            this.maximum = maximum;
//        }
//    }

    // structures

    // TODO: Redo structures

    // dungeons

    private static final int DUNGEON_COBBLESTONE_CHANCE = 1 + (10 - Config.spawnrate_structure_dungeons_cobblestone.get());
    private static final ChanceConfig PLACEMENT_DUNGEON_COBBLESTONE = new ChanceConfig(DUNGEON_COBBLESTONE_CHANCE);
    private static final int DUNGEON_TALL_COBBLESTONE_CHANCE = 1 + (10 - Config.spawnrate_structure_dungeons_tall_cobblestone.get());
    private static final ChanceConfig PLACEMENT_DUNGEON_TALL_COBBLESTONE = new ChanceConfig(DUNGEON_TALL_COBBLESTONE_CHANCE);
    private static final int DUNGEON_ICE_CHANCE = 1 + (10 - Config.spawnrate_structure_dungeons_ice.get());
    private static final ChanceConfig PLACEMENT_DUNGEON_ICE = new ChanceConfig(DUNGEON_ICE_CHANCE);
    private static final int DUNGEON_LAVASTONE_CHANCE = 1 + (10 - Config.spawnrate_structure_dungeons_lavastone.get());
    private static final ChanceConfig PLACEMENT_DUNGEON_LAVASTONE = new ChanceConfig(DUNGEON_LAVASTONE_CHANCE);
    private static final int DUNGEON_TALL_LAVASTONE_CHANCE = 1 + (10 - Config.spawnrate_structure_dungeons_tall_lavastone.get());
    private static final ChanceConfig PLACEMENT_DUNGEON_TALL_LAVASTONE = new ChanceConfig(DUNGEON_TALL_LAVASTONE_CHANCE);

    // cabins

    private static final int CABIN_OAK_CHANCE = 1 + (10 - Config.spawnrate_structure_cabins_oak.get());
    private static final ChanceConfig PLACEMENT_CABIN_OAK = new ChanceConfig(CABIN_OAK_CHANCE);
    private static final int CABIN_COBBLESTONE_CHANCE = 1 + (10 - Config.spawnrate_structure_cabins_cobblestone.get());
    private static final ChanceConfig PLACEMENT_CABIN_COBBLESTONE = new ChanceConfig(CABIN_COBBLESTONE_CHANCE);
    private static final int CABIN_BRICKS_CHANCE = 1 + (10 - Config.spawnrate_structure_cabins_bricks.get());
    private static final ChanceConfig PLACEMENT_CABIN_BRICKS = new ChanceConfig(CABIN_BRICKS_CHANCE);
    private static final int CABIN_SPRUCE_CHANCE = 1 + (10 - Config.spawnrate_structure_cabins_spruce.get());
    private static final ChanceConfig PLACEMENT_CABIN_SPRUCE = new ChanceConfig(CABIN_SPRUCE_CHANCE);
    private static final int CABIN_JUNGLE_CHANCE = 1 + (10 - Config.spawnrate_structure_cabins_jungle.get());
    private static final ChanceConfig PLACEMENT_CABIN_JUNGLE = new ChanceConfig(CABIN_JUNGLE_CHANCE);
    private static final int CABIN_ACACIA_CHANCE = 1 + (10 - Config.spawnrate_structure_cabins_acacia.get());
    private static final ChanceConfig PLACEMENT_CABIN_ACACIA = new ChanceConfig(CABIN_ACACIA_CHANCE);

    private static final Set<Biome.Category> IN_OVERWORLD = ImmutableSet.of(
            Biome.Category.BEACH, Biome.Category.DESERT, Biome.Category.EXTREME_HILLS, Biome.Category.FOREST,
            Biome.Category.ICY, Biome.Category.JUNGLE, Biome.Category.MESA, Biome.Category.MUSHROOM,
            Biome.Category.OCEAN, Biome.Category.PLAINS, Biome.Category.RIVER, Biome.Category.SAVANNA,
            Biome.Category.SWAMP, Biome.Category.TAIGA);

    private static final Set<Biome.Category> IN_HUMID = ImmutableSet.of(
            Biome.Category.JUNGLE, Biome.Category.MUSHROOM, Biome.Category.SWAMP);

    private static final Set<Biome.Category> IN_DRY = ImmutableSet.of(
            Biome.Category.DESERT, Biome.Category.MESA, Biome.Category.SAVANNA);

    private static final Set<Biome.Category> IN_COLD = ImmutableSet.of(
            Biome.Category.ICY, Biome.Category.TAIGA);

    // Spread config
    public static final int SPREAD_I = 8;
    public static final int SPREAD_J = 16;
    public static final int SPREAD_K = 4;

    // ====================
    // Rock placement config
    // ====================

    // Flint
    private static final BlockClusterFeatureConfig CONFIG_FLINT = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_flint.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(8)
            .blacklist(ImmutableSet.of(Blocks.GRASS_BLOCK.getDefaultState()))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    // Stone cluster features
    private static final BlockClusterFeatureConfig CONFIG_ROCK_PEBBLE_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_pebble_stone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.oldstone, RegBlocks.brokenstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCKPILE_TWO_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rockpile_two_stone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.oldstone, RegBlocks.brokenstone))
            .xSpread(SPREAD_J).ySpread(SPREAD_J).zSpread(SPREAD_J)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCKPILE_THREE_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rockpile_three_stone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(16)
            .whitelist(ImmutableSet.of(RegBlocks.oldstone, RegBlocks.brokenstone))
            .xSpread(SPREAD_J).ySpread(SPREAD_J).zSpread(SPREAD_J)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALGAMITE_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalagmite_stone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64)
            .whitelist(ImmutableSet.of(RegBlocks.oldstone, RegBlocks.brokenstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALACTITE_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalactite_stone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64)
            .whitelist(ImmutableSet.of(RegBlocks.oldstone, RegBlocks.brokenstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALGAMITE_TALL_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalagmite_tall_stone.getDefaultState()), PlacerDoubleGround.field_236444_c_)).tries(64)
            .whitelist(ImmutableSet.of(RegBlocks.oldstone, RegBlocks.brokenstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALACTITE_TALL_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalactite_tall_stone.getDefaultState()), PlacerDoubleCeiling.field_236444_c_)).tries(64)
            .whitelist(ImmutableSet.of(RegBlocks.oldstone, RegBlocks.brokenstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    // Sediment Stone
    private static final BlockClusterFeatureConfig CONFIG_ROCK_PEBBLE_SEDIMENT_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_pebble_sedimentstone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(16)
            .whitelist(ImmutableSet.of(RegBlocks.sedimentstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCKPILE_TWO_SEDIMENT_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rockpile_two_sedimentstone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(16)
            .whitelist(ImmutableSet.of(RegBlocks.sedimentstone))
            .xSpread(SPREAD_J).ySpread(SPREAD_J).zSpread(SPREAD_J)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCKPILE_THREE_SEDIMENT_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rockpile_three_sedimentstone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(8)
            .whitelist(ImmutableSet.of(RegBlocks.sedimentstone))
            .xSpread(SPREAD_J).ySpread(SPREAD_J).zSpread(SPREAD_J)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALGAMITE_SEDIMENT_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalagmite_sedimentstone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.sedimentstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALACTITE_SEDIMENT_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalactite_sedimentstone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.sedimentstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALAGMITE_TALL_SEDIMENT_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalagmite_tall_sedimentstone.getDefaultState()), PlacerDoubleGround.field_236444_c_)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.sedimentstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALACTITE_TALL_SEDIMENT_STONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalactite_tall_sedimentstone.getDefaultState()), PlacerDoubleCeiling.field_236444_c_)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.sedimentstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    // Lava stone
    private static final BlockClusterFeatureConfig CONFIG_ROCK_PEBBLE_LAVASTONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_pebble_lavastone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(16)
            .whitelist(ImmutableSet.of(RegBlocks.lavastone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCKPILE_TWO_LAVASTONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rockpile_two_lavastone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(16)
            .whitelist(ImmutableSet.of(RegBlocks.lavastone))
            .xSpread(SPREAD_J).ySpread(SPREAD_J).zSpread(SPREAD_J)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCKPILE_THREE_LAVASTONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rockpile_three_lavastone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(8)
            .whitelist(ImmutableSet.of(RegBlocks.lavastone))
            .xSpread(SPREAD_J).ySpread(SPREAD_J).zSpread(SPREAD_J)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALAGMITE_LAVASTONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalagmite_lavastone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.lavastone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALACTITE_LAVASTONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalactite_lavastone.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.lavastone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALAGMITE_TALL_LAVASTONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalagmite_tall_lavastone.getDefaultState()), PlacerDoubleGround.field_236444_c_)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.lavastone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALACTITE_TALL_LAVASTONE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalactite_tall_lavastone.getDefaultState()), PlacerDoubleCeiling.field_236444_c_)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.lavastone))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();
    
    // Packed ice
    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALAGMITE_PACKED_ICE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalagmite_packed_ice.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(Blocks.PACKED_ICE))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALACTITE_PACKED_ICE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalactite_packed_ice.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(Blocks.PACKED_ICE))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALAGMITE_TALL_PACKED_ICE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalagmite_tall_packed_ice.getDefaultState()), PlacerDoubleGround.field_236444_c_)).tries(32)
            .whitelist(ImmutableSet.of(Blocks.PACKED_ICE))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_ROCK_STALACTITE_TALL_PACKED_ICE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.rock_stalactite_tall_packed_ice.getDefaultState()), PlacerDoubleCeiling.field_236444_c_)).tries(32)
            .whitelist(ImmutableSet.of(Blocks.PACKED_ICE))
            .xSpread(SPREAD_I).ySpread(SPREAD_I).zSpread(SPREAD_I)
            .func_227317_b_().build();

    // Mushrooms
    private static final BlockClusterFeatureConfig CONFIG_MUSHROOM_SWEETSHROOM = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.mushroom_sweetshroom.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64)
            .blacklist(ImmutableSet.of(Blocks.PACKED_ICE.getDefaultState(), RegBlocks.dirtstone.getDefaultState(),
                    RegBlocks.marlstone.getDefaultState()))
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_MUSHROOM_GOLDISHROOM = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.mushroom_goldishroom.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(16)
            .blacklist(ImmutableSet.of(Blocks.PACKED_ICE.getDefaultState(), RegBlocks.dirtstone.getDefaultState(),
                    RegBlocks.marlstone.getDefaultState()))
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_MUSHROOM_SHINYSHROOM = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.mushroom_shinyshroom.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(16)
            .blacklist(ImmutableSet.of(Blocks.PACKED_ICE.getDefaultState(), RegBlocks.dirtstone.getDefaultState(),
                    RegBlocks.marlstone.getDefaultState()))
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_MUSHROOM_LUMISHROOM = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.mushroom_lumishroom.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64)
            .blacklist(ImmutableSet.of(Blocks.PACKED_ICE.getDefaultState(), RegBlocks.dirtstone.getDefaultState(),
                    RegBlocks.marlstone.getDefaultState()))
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_MUSHROOM_FLUOSHROOM = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.mushroom_fluoshroom.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64)
            .whitelist(ImmutableSet.of(Blocks.DIRT, RegBlocks.dirtstone))
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_MUSHROOM_ROCKSHROOM = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.mushroom_rockshroom.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(16)
            .blacklist(ImmutableSet.of(Blocks.PACKED_ICE.getDefaultState(), RegBlocks.dirtstone.getDefaultState(),
                    RegBlocks.marlstone.getDefaultState()))
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    // Moss
    private static final BlockClusterFeatureConfig CONFIG_MOSS_DRY = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.moss_dry.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(8)
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_MOSS_FIRE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.moss_fire.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(16)
            .whitelist(ImmutableSet.of(RegBlocks.lavastone))
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_MOSS_FROZEN = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.moss_frozen.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(Blocks.PACKED_ICE))
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_MOSS_HANGING_ROOTS = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.moss_hanging_roots.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(8)
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_MOSS_HUMID_GROUND = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.moss_humid_ground.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.dirtstone, Blocks.DIRT))
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    private static final BlockClusterFeatureConfig CONFIG_MOSS_HUMID_CEILING = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.moss_humid_ceiling.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32)
            .whitelist(ImmutableSet.of(RegBlocks.dirtstone, Blocks.DIRT))
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    // Vines
    private static final BlockClusterFeatureConfig CONFIG_CAVE_VINE = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegBlocks.cave_vine_end.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(8)
            .xSpread(SPREAD_I).ySpread(SPREAD_K).zSpread(SPREAD_I)
            .func_227317_b_().build();

    // Configured features
    public static final ConfiguredFeature<?, ?> OLD_STONE = topSolidRangeConfig(configureOre(RegBlocks.oldstone.getDefaultState(), Config.patch_size_oldstone.get()), Config.spawnrate_block_oldstone.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> BROKEN_STONE = topSolidRangeConfig(configureOre(RegBlocks.brokenstone.getDefaultState(), Config.patch_size_brokenstone.get()), Config.spawnrate_block_brokenstone.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> SEDIMENT_STONE = topSolidRangeConfig(configureOre(RegBlocks.sedimentstone.getDefaultState(), Config.patch_size_sedimentstone.get()), Config.spawnrate_block_sedimentstone.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> LAVASTONE = topSolidRangeConfig(configureOre(RegBlocks.lavastone.getDefaultState(), Config.patch_size_lavastone.get()), Config.spawnrate_block_lavastone.get(), 0, 0, 15);
    public static final ConfiguredFeature<?, ?> DIRT = topSolidRangeConfig(configureOre(Blocks.DIRT.getDefaultState(), Config.patch_size_dirt.get()), Config.spawnrate_block_dirt.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> DIRTSTONE = topSolidRangeConfig(configureOre(RegBlocks.dirtstone.getDefaultState(), Config.patch_size_dirtstone.get()), Config.spawnrate_block_dirtstone.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> MARLSTONE = topSolidRangeConfig(configureOre(RegBlocks.dirtstone.getDefaultState(), Config.patch_size_marlstone.get()), Config.spawnrate_block_marlstone.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> PACKED_ICE = topSolidRangeConfig(configureOre(Blocks.PACKED_ICE.getDefaultState(), Config.patch_size_packed_ice.get()), Config.spawnrate_block_packed_ice.get(), 16, 16, 64);

    public static final ConfiguredFeature<?, ?> FLINT = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_FLINT), Config.spawnrate_rock_flints.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> PEBBLE_STONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCK_PEBBLE_STONE), Config.spawnrate_rock_pebbles.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> PEBBLE_SEDIMENT_STONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCK_PEBBLE_SEDIMENT_STONE), Config.spawnrate_rock_pebbles.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> PEBBLE_LAVASTONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCK_PEBBLE_LAVASTONE), Config.spawnrate_rock_pebbles.get(), 0, 0, 15);

    public static final ConfiguredFeature<?, ?> ROCKPILE_TWO_STONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCKPILE_TWO_STONE), Config.spawnrate_rock_rockpiles.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> ROCKPILE_THREE_STONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCKPILE_THREE_STONE), Config.spawnrate_rock_rockpiles.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> ROCKPILE_TWO_SEDIMENT_STONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCKPILE_TWO_SEDIMENT_STONE), Config.spawnrate_rock_rockpiles.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> ROCKPILE_THREE_SEDIMENT_STONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCKPILE_THREE_SEDIMENT_STONE), Config.spawnrate_rock_rockpiles.get(), 16, 16, 64);
    public static final ConfiguredFeature<?, ?> ROCKPILE_TWO_LAVASTONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCKPILE_TWO_LAVASTONE), Config.spawnrate_rock_rockpiles.get(), 0, 0, 15);
    public static final ConfiguredFeature<?, ?> ROCKPILE_THREE_LAVASTONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCKPILE_THREE_LAVASTONE), Config.spawnrate_rock_rockpiles.get(), 0, 0, 15);

    public static final ConfiguredFeature<?, ?> STALGAMITE_STONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCK_STALGAMITE_STONE), Config.spawnrate_rock_stalagmites.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> STALGAMITE_TALL_STONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCK_STALGAMITE_TALL_STONE), Config.spawnrate_rock_stalagmites.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> STALACTITE_STONE = topSolidRangeConfig(RegFeatures.patch_ceiling.withConfiguration(CONFIG_ROCK_STALACTITE_STONE), Config.spawnrate_rock_stalactites.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> STALACTITE_TALL_STONE = topSolidRangeConfig(RegFeatures.patch_ceiling.withConfiguration(CONFIG_ROCK_STALACTITE_TALL_STONE), Config.spawnrate_rock_stalactites.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> STALGAMITE_SEDIMENT_STONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCK_STALGAMITE_SEDIMENT_STONE), Config.spawnrate_rock_stalagmites.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> STALGAMITE_TALL_SEDIMENT_STONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCK_STALAGMITE_TALL_SEDIMENT_STONE), Config.spawnrate_rock_stalagmites.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> STALACTITE_SEDIMENT_STONE = topSolidRangeConfig(RegFeatures.patch_ceiling.withConfiguration(CONFIG_ROCK_STALACTITE_SEDIMENT_STONE), Config.spawnrate_rock_stalactites.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> STALACTITE_TALL_SEDIMENT_STONE = topSolidRangeConfig(RegFeatures.patch_ceiling.withConfiguration(CONFIG_ROCK_STALACTITE_TALL_SEDIMENT_STONE), Config.spawnrate_rock_stalactites.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> STALGAMITE_LAVASTONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCK_STALAGMITE_LAVASTONE), Config.spawnrate_rock_stalagmites.get(), 0, 0, 15);
    public static final ConfiguredFeature<?, ?> STALGAMITE_TALL_LAVASTONE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_ROCK_STALAGMITE_TALL_LAVASTONE), Config.spawnrate_rock_stalagmites.get(), 0, 0, 15);
    public static final ConfiguredFeature<?, ?> STALACTITE_LAVASTONE = topSolidRangeConfig(RegFeatures.patch_ceiling.withConfiguration(CONFIG_ROCK_STALACTITE_LAVASTONE), Config.spawnrate_rock_stalactites.get(), 0, 0, 15);
    public static final ConfiguredFeature<?, ?> STALACTITE_TALL_LAVASTONE = topSolidRangeConfig(RegFeatures.patch_ceiling.withConfiguration(CONFIG_ROCK_STALACTITE_TALL_LAVASTONE), Config.spawnrate_rock_stalactites.get(), 0, 0, 15);

    public static final ConfiguredFeature<?, ?> MUSHROOM_SWEETSHROOM = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MUSHROOM_SWEETSHROOM), Config.spawnrate_mushroom_sweetshroom.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> MUSHROOM_GOLDISHROOM = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MUSHROOM_GOLDISHROOM), Config.spawnrate_mushroom_goldishroom.get(), 16, 16, 32);
    public static final ConfiguredFeature<?, ?> MUSHROOM_SHINYSHROOM = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MUSHROOM_SHINYSHROOM), Config.spawnrate_mushroom_shinyshroom.get(), 0, 0, 15);
    public static final ConfiguredFeature<?, ?> MUSHROOM_LUMISHROOM = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MUSHROOM_LUMISHROOM), Config.spawnrate_mushroom_lumishroom.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> MUSHROOM_FLUOSHROOM = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MUSHROOM_FLUOSHROOM), Config.spawnrate_mushroom_fluoshroom.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> MUSHROOM_ROCKSHROOM = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MUSHROOM_ROCKSHROOM), Config.spawnrate_mushroom_rockshroom.get(), 0, 0, 15);

    public static final ConfiguredFeature<?, ?> MOSS_DRY = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MOSS_DRY), Config.spawnrate_moss_dry.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> MOSS_FIRE = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MOSS_FIRE), Config.spawnrate_moss_fire.get(), 0, 0, 15);
    public static final ConfiguredFeature<?, ?> MOSS_FROZEN = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MOSS_FROZEN), Config.spawnrate_moss_frozen.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> MOSS_HANGING_ROOTS = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MOSS_HANGING_ROOTS), Config.spawnrate_moss_hanging_roots.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> MOSS_HUMID_GROUND = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MOSS_HUMID_GROUND), Config.spawnrate_moss_dry.get(), 16, 16, 54);
    public static final ConfiguredFeature<?, ?> MOSS_HUMID_CEILING = topSolidRangeConfig(RegFeatures.patch_ground.withConfiguration(CONFIG_MOSS_HUMID_CEILING), Config.spawnrate_moss_dry.get(), 16, 16, 54);

    public static ConfiguredFeature<?, ?> VINE = topSolidRangeConfig(RegFeatures.patch_ceiling.withConfiguration(CONFIG_CAVE_VINE), Config.spawnrate_cave_vine.get(), 16, 16, 54);

    private static ConfiguredFeature<?,?> configureOre(BlockState state, int patchSize) {
        return Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, state, patchSize));
    }

    private static ConfiguredFeature<?, ?> topSolidRangeConfig(ConfiguredFeature<?, ?> feature, int count, int bottomOffset, int topOffset, int maximum) {
        // TODO: Determine the distance?
//        return feature.withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(bottomOffset, topOffset, maximum)).func_242728_a().func_242731_b(count));
        return feature.withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(bottomOffset, topOffset, maximum)).func_242731_b(count));
    }

    // Configured Structures TODO: Go via the structure system

    public static final ConfiguredFeature<?, ?> COBBLESTONE_DUNGEON = RegFeatures.structure_dungeon_cobblestone.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_DUNGEON_COBBLESTONE));
    public static final ConfiguredFeature<?, ?> TALL_COBBLESTONE_DUNGEON = RegFeatures.structure_dungeon_tall_lavastone.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_DUNGEON_TALL_LAVASTONE));
    public static final ConfiguredFeature<?, ?> ICE_DUNGEON = RegFeatures.structure_dungeon_ice.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_DUNGEON_ICE));
    public static final ConfiguredFeature<?, ?> LAVASTONE_DUNGEON = RegFeatures.structure_dungeon_cobblestone.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_DUNGEON_LAVASTONE));
    public static final ConfiguredFeature<?, ?> TALL_LAVASTONE_DUNGEON = RegFeatures.structure_dungeon_tall_lavastone.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_DUNGEON_TALL_LAVASTONE));

    public static final ConfiguredFeature<?, ?> OAK_CABIN = RegFeatures.structure_cabin_oak.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_CABIN_OAK));
    public static final ConfiguredFeature<?, ?> COBBLESTONE_CABIN = RegFeatures.structure_cabin_cobblestone.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_CABIN_COBBLESTONE));
    public static final ConfiguredFeature<?, ?> BRICKS_CABIN = RegFeatures.structure_cabin_bricks.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_CABIN_BRICKS));
    public static final ConfiguredFeature<?, ?> SPRUCE_CABIN = RegFeatures.structure_cabin_spruce.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_CABIN_SPRUCE));
    public static final ConfiguredFeature<?, ?> JUNGLE_CABIN = RegFeatures.structure_cabin_jungle.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_CABIN_JUNGLE));
    public static final ConfiguredFeature<?, ?> ACACIA_CABIN = RegFeatures.structure_cabin_acacia.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242898_b.configure(PLACEMENT_CABIN_ACACIA));

    /**
     *
     * @param event
     */
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (IN_OVERWORLD.contains(event.getCategory())) {
            // Structures
            if (Config.gen_structure_dungeons.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, COBBLESTONE_DUNGEON);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, TALL_COBBLESTONE_DUNGEON);

                if (IN_COLD.contains(event.getCategory())) {
                    generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, ICE_DUNGEON);
                }

                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, LAVASTONE_DUNGEON);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, TALL_LAVASTONE_DUNGEON);
            }

            if (Config.gen_structure_cabins.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, OAK_CABIN);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, COBBLESTONE_CABIN);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, BRICKS_CABIN);

                if (event.getCategory() == Biome.Category.TAIGA) {
                    generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, SPRUCE_CABIN);
                }

                if (event.getCategory() == Biome.Category.JUNGLE) {
                    generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, JUNGLE_CABIN);
                }

                if (event.getCategory() == Biome.Category.SAVANNA) {
                    generation.withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, ACACIA_CABIN);
                }
            }

            // Blocks
            if (Config.gen_block_oldstone.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, OLD_STONE);
            }

            if (Config.gen_block_brokenstone.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BROKEN_STONE);
            }

            if (Config.gen_block_sedimentstone.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SEDIMENT_STONE);
            }

            if (Config.gen_block_lavastone.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, LAVASTONE);
            }

            if (IN_HUMID.contains(event.getCategory())) {
                if (Config.gen_block_dirt.get()) {
                    generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, DIRT);
                }

                if (Config.gen_block_dirtstone.get()) {
                    generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, DIRTSTONE);
                }
            }

            if (IN_DRY.contains(event.getCategory()) && Config.gen_block_marlstone.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, MARLSTONE);
            }

            if (IN_COLD.contains(event.getCategory()) && Config.gen_block_packed_ice.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, PACKED_ICE);
            }

            // Rocks
            if (Config.gen_rock_flints.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FLINT);
            }

            if (Config.gen_rock_pebbles.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, PEBBLE_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, PEBBLE_SEDIMENT_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, PEBBLE_LAVASTONE);
            }

            if (Config.gen_rock_rockpiles.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ROCKPILE_TWO_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ROCKPILE_THREE_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ROCKPILE_TWO_SEDIMENT_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ROCKPILE_THREE_SEDIMENT_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ROCKPILE_TWO_LAVASTONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ROCKPILE_THREE_LAVASTONE);
            }

            if (Config.gen_rock_stalagmites.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALGAMITE_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALGAMITE_TALL_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALGAMITE_SEDIMENT_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALGAMITE_TALL_SEDIMENT_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALGAMITE_LAVASTONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALGAMITE_TALL_LAVASTONE);
            }

            if (Config.gen_rock_stalactites.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALACTITE_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALACTITE_TALL_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALACTITE_SEDIMENT_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALACTITE_TALL_SEDIMENT_STONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALACTITE_LAVASTONE);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, STALACTITE_TALL_LAVASTONE);
            }

            if (Config.gen_mushrooms.get()) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, MUSHROOM_SWEETSHROOM);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, MUSHROOM_GOLDISHROOM);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, MUSHROOM_SHINYSHROOM);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, MUSHROOM_LUMISHROOM);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, MUSHROOM_ROCKSHROOM);

                if (IN_HUMID.contains(event.getCategory())) {
                    generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, MUSHROOM_FLUOSHROOM);
                }
            }

            if (Config.gen_mosses.get()) {
                generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MOSS_DRY);
                generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MOSS_FIRE);
                generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MOSS_HANGING_ROOTS);

                if (IN_HUMID.contains(event.getCategory())) {
                    generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MOSS_HUMID_GROUND);
                    generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MOSS_HUMID_CEILING);
                }

                if (IN_COLD.contains(event.getCategory())) {
                    generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MOSS_FROZEN);
                }
            }

            if (Config.gen_vines.get()) {
                generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, VINE);
            }
        }
    }
}
