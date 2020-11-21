package com.mthree.controllers;

import com.mthree.daos.TradeDAO;
import com.mthree.models.Conditions;
import com.mthree.models.Symbols;
import com.mthree.models.Trade;

import java.util.ArrayList;

public class TradeController {

    private TradeDAO tradeDAO;

    public TradeController( TradeDAO tradeDAO) {
        this.tradeDAO = tradeDAO;
    }

    public TradeDAO getTradeDAO() {
        return tradeDAO;
    }

    public double selectFromMenu(int selected, ArrayList<Trade> trades, Symbols sym) {
        double result = 0;
        switch (selected) {
            case 1:
                result = tradeDAO.openPrice(trades, sym);
                break;
            case 2:
                result = tradeDAO.closePrice(trades, sym);
                break;
            case 3:
                result = tradeDAO.avgPriceExcludingOpenClose(trades, sym);
                break;
            case 4:
                result = tradeDAO.vwap(trades, sym);
                break;
            case 5:
                result = tradeDAO.vwapExcludingReportedTrades(trades, sym);
                break;
        }
        return result;
    }
}
