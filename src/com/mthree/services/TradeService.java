package com.mthree.services;

import com.mthree.daos.TradeDAO;
import com.mthree.models.Conditions;
import com.mthree.models.Symbols;
import com.mthree.models.Trade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TradeService implements TradeDAO {

    private ArrayList<Trade> trades;

    public TradeService(){
       populate();
    }

    private void populate() {
        Random rand = new Random();
        Trade trade;
        trades = new ArrayList<>();

        for(int i = 0; i < 200; i++){

            long minDay = LocalDate.of(2020, 9, 1).toEpochDay();
            long maxDay = LocalDate.of(2020, 9, 15).toEpochDay();
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

            LocalTime time1 = LocalTime.of(8, 0, 0);
            LocalTime time2 = LocalTime.of(15, 0, 0);
            int secondOfDayTime1 = time1.toSecondOfDay();
            int secondOfDayTime2 = time2.toSecondOfDay();
            int randomSecondOfDay = secondOfDayTime1 + rand.nextInt(secondOfDayTime2-secondOfDayTime1);
            LocalTime randomLocalTime = LocalTime.ofSecondOfDay(randomSecondOfDay);

            LocalDateTime ldt = LocalDateTime.of(randomDate, randomLocalTime);

            trade = new Trade(Symbols.valueOf(rand.nextInt(6) + 1), rand.nextDouble() * 100, rand.nextInt(50), ldt, Conditions.valueOf(rand.nextInt(5) + 1));
            trades.add(trade);
        }
    }

    public ArrayList<Trade> getTrades() {
        return trades;
    }

    @Override
    public double openPrice(ArrayList<Trade> trades, Symbols sym) {
        Trade returnPriceTrade = trades.get(0);
        LocalDateTime soonest = returnPriceTrade.getLDT();

        for(Trade trade : trades){
            if(trade.getSym().equals(sym) && soonest.isAfter(trade.getLDT())){
                soonest = trade.getLDT();
                returnPriceTrade = trade;
            }
        }
        return returnPriceTrade.getPrice();
    }

    @Override
    public double closePrice(ArrayList<Trade> trades, Symbols sym) {
        Trade returnPriceTrade = trades.get(0);
        LocalDateTime latest = returnPriceTrade.getLDT();

        for(Trade trade : trades){
            if(trade.getSym().equals(sym) && latest.isBefore(trade.getLDT())){
                latest = trade.getLDT();
                returnPriceTrade = trade;
            }
        }
        return returnPriceTrade.getPrice();
    }

    @Override
    public double avgPriceExcludingOpenClose(ArrayList<Trade> trades, Symbols sym) {
        double sum = 0;
        for(Trade trade : trades){
            if(trade.getSym().equals(sym)){
                sum += trade.getPrice();
            }
        }

        return (sum-closePrice(trades, sym)-openPrice(trades, sym))/(trades.size()-2);
    }

    @Override
    public double vwap(ArrayList<Trade> trades, Symbols sym) {

        double sumP = 0;
        int sumV = 0;
        for(Trade trade : trades){
            if(trade.getSym().equals(sym)){
                sumP += trade.getPrice()*trade.getSize();
                sumV += trade.getSize();
            }
        }
        return sumP/sumV;
    }

    @Override
    public double vwapExcludingReportedTrades(ArrayList<Trade> trades, Symbols sym) {

        double sumP = 0;
        int sumV = 0;
        for(Trade trade : trades){
            if(trade.getSym().equals(sym) &&  trade.getCond() != Conditions.C ){
                sumP += trade.getPrice()*trade.getSize();
                sumV += trade.getSize();
            }
        }
        return sumP/sumV;
    }
}
