package org.smirnovav.moex_lib.collectors.stock;

import java.util.Calendar;

public class StockDayHistoryInfo {
    private String boardId; // Режим торгов
    private Calendar tradeDate; //Дата проведения торгов
    private String shortName; // Краткое наименование
    private String secId; // Краткий код
    private double open; //Цена открытия
    private double low; // Наименьшая цена
    private double high; // Наибольшая цена
    private double close; // Цена закрытия
    private double legalClosePrice;
//    private double openPositionValue; // Стоимость всех открытых позиций в рублях
    private double value; // Объём торгов в рублях
    private long volume; // Количество сделок
//    private long openPosition; // Количество открытых позиций
    private double waPrice; // Средневзвешенная цена
    private double numTrades; // Количество сделок за торговый день
    private double marketPrice2; // Рыночная цена 2
    private double marketPrice3; // Рыночная цена 3
    private double admittedQuote; // Признаваемая котировка
    private double mp2ValTrd; //  ??
    private double getMarketPrice3TradesValue; // ??
    private double admittedValue; // ??
    private double waval; // ??
    private int tradingSession; // Торговая сессия
    private String currencyId; // Идентификатор валюты
    private double trendClsPr; // ??

    public StockDayHistoryInfo(String boardId, Calendar tradeDate, String shortName, String secId, double open,
                               double low, double high, double close, double legalClosePrice,
                               double value, long volume, double waPrice, double numTrades,
                               double marketPrice2, double marketPrice3, double admittedQuote, double mp2ValTrd,
                               double getMarketPrice3TradesValue, double admittedValue, double waval, int tradingSession,
                               String currencyId, double trendClsPr) {
        this.boardId = boardId;
        this.tradeDate = tradeDate;
        this.shortName = shortName;
        this.secId = secId;
        this.open = open;
        this.low = low;
        this.high = high;
        this.close = close;
        this.legalClosePrice = legalClosePrice;
        this.value = value;
        this.volume = volume;
        this.waPrice = waPrice;
        this.numTrades = numTrades;
        this.marketPrice2 = marketPrice2;
        this.marketPrice3 = marketPrice3;
        this.admittedQuote = admittedQuote;
        this.mp2ValTrd = mp2ValTrd;
        this.getMarketPrice3TradesValue = getMarketPrice3TradesValue;
        this.admittedValue = admittedValue;
        this.waval = waval;
        this.tradingSession = tradingSession;
        this.currencyId = currencyId;
        this.trendClsPr = trendClsPr;
    }

    public String getBoardId() {
        return boardId;
    }

    public Calendar getTradeDate() {
        return tradeDate;
    }

    public String getShortName() {
        return shortName;
    }

    public String getSecId() {
        return secId;
    }

    public double getOpen() {
        return open;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }

    public double getClose() {
        return close;
    }

    public double getLegalClosePrice() {
        return legalClosePrice;
    }


    public double getValue() {
        return value;
    }

    public long getVolume() {
        return volume;
    }


    public double getWaPrice() {
        return waPrice;
    }

    public double getNumTrades() {
        return numTrades;
    }

    public double getMarketPrice2() {
        return marketPrice2;
    }

    public double getMarketPrice3() {
        return marketPrice3;
    }

    public double getAdmittedQuote() {
        return admittedQuote;
    }

    public double getMp2ValTrd() {
        return mp2ValTrd;
    }

    public double getGetMarketPrice3TradesValue() {
        return getMarketPrice3TradesValue;
    }

    public double getAdmittedValue() {
        return admittedValue;
    }

    public double getWaval() {
        return waval;
    }

    public int getTradingSession() {
        return tradingSession;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public double getTrendClsPr() {
        return trendClsPr;
    }
}
