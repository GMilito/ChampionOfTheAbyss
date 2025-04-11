package com.gmilito.championoftheabyssmod.core;


import com.gmilito.championoftheabyssmod.ChampionOfTheAbyssMod;
import com.gmilito.championoftheabyssmod.systems.portal.DimensionalPortalEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ChampionOfTheAbyssMod.MOD_ID);

    public static final RegistryObject<EntityType<DimensionalPortalEntity>> PORTAL = ENTITIES.register("portal",
            () -> EntityType.Builder.<DimensionalPortalEntity>of(DimensionalPortalEntity::new, MobCategory.MISC)
                    .sized(1.5f, 2.5f) // Tamaño visual del portal
                    .clientTrackingRange(64)
                    .fireImmune()
                    .noSummon()
                    .build("portal")
    );
}
