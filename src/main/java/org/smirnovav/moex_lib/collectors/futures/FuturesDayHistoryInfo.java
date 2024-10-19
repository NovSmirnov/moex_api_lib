package org.smirnovav.moex_lib.collectors.futures;

import java.util.Calendar;

public class FuturesDayHistoryInfo {
    private String boardId; // Режим торгов
    private Calendar tradeDate; //Дата проведения торгов
    private String secId; // Краткий код
    private double open; //Цена открытия
    private double low; // Наименьшая цена
    private double high; // Наибольшая цена
    private double close; // Цена закрытия
    private double openPositionValue; // Стоимость всех открытых позиций в рублях
    private double value; // Объём торгов в рублях
    private long volume; // Количество сделок
    private long openPosition; // Количество открытых позиций
    private double settlePrice; // Расчётная цена
    private double swapRate; // ??
    private double waPrice; // Средневзвешенная цена
    private double settlePriceDay;
    private double change; // Изменение цены последней сделки по отношению к цене последней сделки предыдущего торгового дня
    private double qty; // Объем последней сделки в лотах
    private double numTrades; // Количество сделок за торговый день

    public FuturesDayHistoryInfo(String boardId, Calendar tradeDate, String secId, double open, double low, double high,
                                 double close, double openPositionValue, double value, long volume, long openPosition,
                                 double settlePrice, double swapRate, double waPrice, double settlePriceDay,
                                 double change, double qty, double numTrades) {
        this.boardId = boardId;
        this.tradeDate = tradeDate;
        this.secId = secId;
        this.open = open;
        this.low = low;
        this.high = high;
        this.close = close;
        this.openPositionValue = openPositionValue;
        this.value = value;
        this.volume = volume;
        this.openPosition = openPosition;
        this.settlePrice = settlePrice;
        this.swapRate = swapRate;
        this.waPrice = waPrice;
        this.settlePriceDay = settlePriceDay;
        this.change = change;
        this.qty = qty;
        this.numTrades = numTrades;
    }

    public String getBoardId() {
        return boardId;
    }

    public Calendar getTradeDate() {
        return tradeDate;
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

    public double getOpenPositionValue() {
        return openPositionValue;
    }

    public double getValue() {
        return value;
    }

    public long getVolume() {
        return volume;
    }

    public long getOpenPosition() {
        return openPosition;
    }

    public double getSettlePrice() {
        return settlePrice;
    }

    public double getSwapRate() {
        return swapRate;
    }

    public double getWaPrice() {
        return waPrice;
    }

    public double getSettlePriceDay() {
        return settlePriceDay;
    }

    public double getChange() {
        return change;
    }

    public double getQty() {
        return qty;
    }

    public double getNumTrades() {
        return numTrades;
    }
}
