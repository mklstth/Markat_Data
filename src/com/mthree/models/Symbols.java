package com.mthree.models;

import java.util.HashMap;
import java.util.Map;

public enum Symbols {
    A(1),             // Agilent Technologies
    AAPL(2),          // Apple
    BRK(3),           // Berkshire Hathaway (class A shares)
    C(4),             // Citigroup
    GOOG(5),          // Alphabet Inc.
    HOG (6);          //Harley-Davidson
//    HPQ (7),          //Hewlett-Packard
//    INTC(8),          // Intel
//    KO(9),            // The Coca-Cola Company
//    LUV(10),           //Southwest Airlines (after their main hub at Love Field)
//    MMM(11),          //Minnesota Mining and Manufacturing (3M)
//    MSFT(12),          // Microsoft
//    T(13) ,            //AT&T
//    TGT (14),          //Target Corporation
//    TXN (15),          //Texas Instruments
//    WMT (16);          //Walmart


    private int value;
    private static Map map = new HashMap<>();

    private Symbols(int value) {
        this.value = value;
    }

    static {
        for (Symbols pageType : Symbols.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static Symbols valueOf(int pageType) {
        return (Symbols) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}
