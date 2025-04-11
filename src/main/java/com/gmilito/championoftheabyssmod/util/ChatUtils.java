package com.gmilito.championoftheabyssmod.util;

import com.gmilito.championoftheabyssmod.systems.portal.PortalTier;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ChatUtils {

    public static void sendPortalMessage(ServerPlayer player, PortalTier tier, BlockPos pos) {
        String message = String.format("§6¡Un portal de tipo §e%s§6 ha aparecido en §b[%d, %d, %d]§6!",
                tier.name(), pos.getX(), pos.getY(), pos.getZ());
        player.sendSystemMessage(Component.literal(message));
    }

    public static void sendInfo(ServerPlayer player, String message) {
        player.sendSystemMessage(Component.literal("§7[§3Abyss§7] §f" + message));
    }
}
