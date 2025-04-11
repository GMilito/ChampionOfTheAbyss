package com.gmilito.championoftheabyssmod.events;

import com.gmilito.championoftheabyssmod.systems.portal.PortalSpawner;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PortalSpawnerEvent {

    private static int tickCounter = 0;

    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {
        // Solo ejecutar en el lado del servidor y al final del tick
        if (event.phase != TickEvent.Phase.END) return;
        if (event.level.isClientSide()) return;

        tickCounter++;
        if (tickCounter >= 100) { // Cada 5 minutos
            tickCounter = 0;

            ServerLevel level = (ServerLevel) event.level;
            if (!level.players().isEmpty()) {
                Player randomPlayer = level.players().get(level.random.nextInt(level.players().size()));
                PortalSpawner.trySpawnRandomPortal(level, randomPlayer.blockPosition());
            }
        }
    }
}
