package com.rotatingmind.battleship;

import java.util.HashMap;
import java.util.Map;

public enum ShipType {
    SINGLE_HIT_DESTROYABLE("P"),
    TWO_HIT_DESTROYABLE("Q");

    private final String name;

    private static final Map<String, ShipType> SHIPTYPE_MAP;

    static {
        SHIPTYPE_MAP = new HashMap<>();
        for (ShipType shipType : values()) {
            SHIPTYPE_MAP.put(shipType.name, shipType);
        }
    }

    ShipType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ShipType getByName(String name) {
        return SHIPTYPE_MAP.get(name);
    }
}
