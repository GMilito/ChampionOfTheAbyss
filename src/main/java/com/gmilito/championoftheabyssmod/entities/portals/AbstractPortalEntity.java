package com.gmilito.championoftheabyssmod.entities.portals;


import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.entity.PartEntity;
import net.minecraftforge.network.NetworkHooks;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractPortalEntity extends Entity {

    protected AbstractPortalEntity(EntityType<?> type, Level level) {
        super(type, level);
        this.noPhysics = true;
    }

    @Override
    protected void defineSynchedData() {
        // No data needed here by default
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
    }

    @Override
    public void tick() {
        super.tick();
        if (level().isClientSide) {
            spawnParticles();
        } else {
            checkForPlayers();
        }
    }

    protected void checkForPlayers() {
        List<Player> players = level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(1));
        for (Player player : players) {
            if (player instanceof ServerPlayer serverPlayer && canTeleport(serverPlayer)) {
                teleport(serverPlayer);
            }
        }
    }

    protected boolean canTeleport(ServerPlayer player) {
        return true; // podrías agregar lógica extra como cooldown o requerimientos
    }

    protected abstract void teleport(ServerPlayer player);

    protected abstract void spawnParticles();

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public boolean isInvisible() {
        return true;
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }
}
