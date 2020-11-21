
package com.mthree.models;

import java.util.HashMap;
import java.util.Map;

public enum Conditions {
    AT(1),
    IX(2),
    PT(3),
    UT(4),
    C(5);

    private int value;
    private static Map map = new HashMap<>();

    private Conditions(int value) {
        this.value = value;
    }

    static {
        for (Conditions pageType : Conditions.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static Conditions valueOf(int pageType) {
        return (Conditions) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}