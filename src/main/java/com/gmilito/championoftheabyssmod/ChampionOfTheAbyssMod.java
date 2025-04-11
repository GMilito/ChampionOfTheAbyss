package com.gmilito.championoftheabyssmod;

import com.gmilito.championoftheabyssmod.events.PortalSpawnerEvent;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(ChampionOfTheAbyssMod.MOD_ID)
public class ChampionOfTheAbyssMod {
    public static final String MOD_ID = "championoftheabyssmod";

    public ChampionOfTheAbyssMod() {
        MinecraftForge.EVENT_BUS.register(PortalSpawnerEvent.class);

        System.out.println("Champion of the Abyss Mod loaded!");
    }
}
