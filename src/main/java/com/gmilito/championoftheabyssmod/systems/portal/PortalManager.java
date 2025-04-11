package com.gmilito.championoftheabyssmod.systems.portal;


import com.gmilito.championoftheabyssmod.core.ModDimensions;
import com.gmilito.championoftheabyssmod.systems.portal.PortalTier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

public class PortalManager {

    public static void teleportToTier(ServerPlayer player, PortalTier tier) {
        ResourceKey<Level> targetDimension = switch (tier) {
            case COMMON -> ModDimensions.DUNGEON_COMMON;
            case UNSTABLE -> ModDimensions.DUNGEON_UNSTABLE;
            case ANCIENT -> ModDimensions.DUNGEON_ANCIENT;
            case ABYSSAL -> ModDimensions.DUNGEON_ABYSSAL;
            case ECLIPSE -> ModDimensions.DUNGEON_ECLIPSE;
        };

        ServerLevel targetLevel = player.server.getLevel(targetDimension);
        if (targetLevel != null) {
            BlockPos spawnPos = targetLevel.getSharedSpawnPos();
            player.teleportTo(targetLevel, spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, player.getYRot(), player.getXRot());
        }
    }
}
