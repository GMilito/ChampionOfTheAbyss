package com.gmilito.championoftheabyssmod.core;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.Level;

public class ModDimensions {
    public static final ResourceKey<Level> DUNGEON_COMMON = ResourceKey.create(
        Registries.DIMENSION,
        ResourceLocation.fromNamespaceAndPath("championoftheabyss", "dungeon_common")
    );

    public static final ResourceKey<Level> DUNGEON_UNSTABLE = ResourceKey.create(
        Registries.DIMENSION,
        ResourceLocation.fromNamespaceAndPath("championoftheabyss", "dungeon_unstable")
    );

    public static final ResourceKey<Level> DUNGEON_ANCIENT = ResourceKey.create(
        Registries.DIMENSION,
        ResourceLocation.fromNamespaceAndPath("championoftheabyss", "dungeon_ancient")
    );

    public static final ResourceKey<Level> DUNGEON_ABYSSAL = ResourceKey.create(
        Registries.DIMENSION,
        ResourceLocation.fromNamespaceAndPath("championoftheabyss", "dungeon_abyssal")
    );

    public static final ResourceKey<Level> DUNGEON_ECLIPSE = ResourceKey.create(
        Registries.DIMENSION,
        ResourceLocation.fromNamespaceAndPath("championoftheabyss", "dungeon_eclipse")
    );
}

