package com.mthree.daos;

import com.mthree.models.Symbols;
import com.mthree.models.Trade;

import java.util.ArrayList;

public interface TradeDAO {

    double openPrice(ArrayList<Trade> trades, Symbols sym);
    double closePrice(ArrayList<Trade> trades, Symbols sym);
    double avgPriceExcludingOpenClose(ArrayList<Trade> trades, Symbols sym);
    double vwap(ArrayList<Trade> trades, Symbols sym); //Volume Weighted Average Price
    double vwapExcludingReportedTrades(ArrayList<Trade> trades, Symbols sym);

    ArrayList<Trade> getTrades();

}
