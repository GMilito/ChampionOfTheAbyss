package com.gmilito.championoftheabyssmod.systems.portal;

import java.util.Random;

public enum PortalTier {
    COMMON,
    UNSTABLE,
    ANCIENT,
    ABYSSAL,
    ECLIPSE;
    
    private static final Random RANDOM = new Random();

    public static PortalTier getRandomTier() {
        double roll = RANDOM.nextDouble(); // número entre 0.0 y 1.0

        if (roll < 0.50) return COMMON;
        else if (roll < 0.75) return UNSTABLE;
        else if (roll < 0.90) return ANCIENT;
        else if (roll < 0.98) return ABYSSAL;
        else return ECLIPSE;
    }
}