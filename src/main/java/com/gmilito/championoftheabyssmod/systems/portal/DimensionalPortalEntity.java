package com.gmilito.championoftheabyssmod.systems.portal;


import com.gmilito.championoftheabyssmod.core.ModEntities;
import com.gmilito.championoftheabyssmod.entities.portals.AbstractPortalEntity;
import com.gmilito.championoftheabyssmod.systems.portal.PortalTier;
import com.gmilito.championoftheabyssmod.systems.portal.PortalManager;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DimensionalPortalEntity extends AbstractPortalEntity {

    private final PortalTier tier;

    public DimensionalPortalEntity(EntityType<?> type, Level level, PortalTier tier) {
        super(type, level);
        this.tier = tier;
    }

    public DimensionalPortalEntity(EntityType<? extends DimensionalPortalEntity> type, Level level) {
        super(type, level);
        this.tier = PortalTier.COMMON; // tier por defecto (puede cambiar luego)
    }

    public DimensionalPortalEntity(Level level, PortalTier tier) {
        this(ModEntities.PORTAL.get(), level, tier);
    }

    @Override
    protected void teleport(ServerPlayer player) {
        PortalManager.teleportToTier(player, tier);
    }

    @Override
    protected void spawnParticles() {
        switch (tier) {
            case COMMON -> level().addParticle(ParticleTypes.PORTAL, getX(), getY() + 1, getZ(), 0, 0.05, 0);
            case UNSTABLE -> level().addParticle(ParticleTypes.SOUL_FIRE_FLAME, getX(), getY() + 1, getZ(), 0, 0.05, 0);
            case ANCIENT -> level().addParticle(ParticleTypes.END_ROD, getX(), getY() + 1, getZ(), 0, 0.05, 0);
            case ABYSSAL -> level().addParticle(ParticleTypes.DRAGON_BREATH, getX(), getY() + 1, getZ(), 0, 0.05, 0);
            case ECLIPSE -> level().addParticle(ParticleTypes.WITCH, getX(), getY() + 1, getZ(), 0, 0.05, 0);
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return super.getAddEntityPacket(); // Usa el de AbstractPortalEntity
    }

    public PortalTier getTier() {
        return tier;
    }
}
