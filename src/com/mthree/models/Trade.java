package com.mthree.models;

import java.time.LocalDateTime;

public class Trade {

//    Sym,   price,  size,   datetime,              cond
//    vod,   1.32,   1000,   2019.03.06T12:01:34,   AT
    private LocalDateTime dateTime;
    private Symbols sym;
    private double price;
    private int size;

    private Conditions cond;

    public Trade(Symbols sym, double price, int size, LocalDateTime dateTime, Conditions cond) {
        this.sym = sym;
        this.price = price;
        this.size = size;
        this.dateTime = dateTime;
        this.cond = cond;
    }

    public Conditions getCond() {
        return cond;
    }

    public Symbols getSym() {
        return sym;
    }

    public LocalDateTime getLDT() {
        return this.dateTime;
    }

    public double getPrice() {
        return this.price;
    }

    public int getSize() {
        return size;
    }
}

