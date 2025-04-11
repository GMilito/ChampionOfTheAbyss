package com.gmilito.championoftheabyssmod.systems.portal;

import com.gmilito.championoftheabyssmod.core.ModEntities;
import com.gmilito.championoftheabyssmod.util.ChatUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.Random;

public class PortalSpawner {

    private static final Random random = new Random();
    private static int portalCount = 0;

    public static void trySpawnRandomPortal(ServerLevel level, BlockPos playerPos) {
        
        if (random.nextFloat() < 0.05f) { // 5% de chance
            PortalTier tier = PortalTier.getRandomTier();

            // Aumentar el radio de aparición en base a cuántos portales ya hay (1000 + 200 * cada portal)
            int baseRange = 1000 + (portalCount * 200);
            int offsetX = random.nextInt(baseRange * 2 + 1) - baseRange;
            int offsetZ = random.nextInt(baseRange * 2 + 1) - baseRange;

            int x = playerPos.getX() + offsetX;
            int z = playerPos.getZ() + offsetZ;
            int y = level.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);

            BlockPos spawnPos = new BlockPos(x, y, z);
            System.out.println("Intentando spawnear un portal cerca de " + spawnPos.getCenter());

            if (!level.getBlockState(spawnPos.below()).is(Blocks.WATER) &&
                !level.getBlockState(spawnPos.below()).is(Blocks.LAVA)) {

                DimensionalPortalEntity portal = new DimensionalPortalEntity(ModEntities.PORTAL.get(), level, tier);
                portal.setPos(x + 0.5, y, z + 0.5);
                level.addFreshEntity(portal);
                portalCount++;

                // Enviar mensaje a los jugadores cercanos
                level.players().forEach(p -> {
                    if (p.distanceToSqr(x, y, z) <= 10000 * 10000) {
                        ChatUtils.sendPortalMessage(p, tier, spawnPos);
                    }
                });
            }
        }
    }
}
