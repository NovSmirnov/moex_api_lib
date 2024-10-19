package org.smirnovav.moex_lib.collectors;

import java.util.Calendar;

public abstract class MarketData {

    private String secId;
    private String boardId;
    private double bid; // Спрос
    private double offer; // Предложение
    private double offerDepth; // Объем заявок на продажу по лучшей котировке, выраженный в лотах
    private double offerDeptht; // Объем всех заявок на продажу в очереди торговой системы, выраженный в лотах
    private double spread; // Разница между ценой покупки и ценой продажи
    private double open; // Цена открытия
    private double low; // Минимальная цена
    private double high; // Максимальная цена
    private double last; // Последняя цена
    private double lastChange; // Изменение цены последней сделки по отношению к цене последней сделки предыдущего дня
    private int numTrades; // Количество сделок за торговый день
    private int volToday; // Объем сделок за сегодня в количестве ценных бумаг
    private double valToday; // Объем сделок за сегодня в валюте расчетов
    private double valTodayUsd; // Объем сделок за сегодня в долларах США
    private double lastChangePrcnt; // Изменение цены последней сделки по отношению к цене последней сделки предыдущего дня в процентах
    private int bidDepth; // Объем заявок на покупку по лучшей котировке, выраженный в лотах
    private int bidDeptht; // Объем всех заявок на покупку в очереди торговой системы, выраженный в лотах
    private int numOffers; // Количество заявок на продажу в очереди торговой системы
    private int numBids; // Количество заявок на покупку в очереди торговой системы
    private Calendar time; // Время заключения последней сделки
    private String seqNum; // Некий 14-значный номер обозначающий дату и время последней сделки в формате yyyyMMddhhmmss
    private Calendar sysTime; // Системное время
    private Calendar updateTime; // Время обновления
    private double openPeriodPrice; // Цена предторгового периода или аукциона открытия
    private double lastToPrevPrice; // ???

    public MarketData(String secId, String boardId, double bid, double offer, double offerDepth, double offerDeptht,
                      double spread, double open, double low, double high, double last, double lastChange,
                      int numTrades, int volToday, double valToday, double valTodayUsd, double lastChangePrcnt,
                      int bidDepth, int bidDeptht, int numOffers, int numBids, Calendar time, String seqNum,
                      Calendar sysTime, Calendar updateTime, double openPeriodPrice, double lastToPrevPrice) {
        this.secId = secId;
        this.boardId = boardId;
        this.bid = bid;
        this.offer = offer;
        this.offerDepth = offerDepth;
        this.offerDeptht = offerDeptht;
        this.spread = spread;
        this.open = open;
        this.low = low;
        this.high = high;
        this.last = last;
        this.lastChange = lastChange;
        this.numTrades = numTrades;
        this.volToday = volToday;
        this.valToday = valToday;
        this.valTodayUsd = valTodayUsd;
        this.lastChangePrcnt = lastChangePrcnt;
        this.bidDepth = bidDepth;
        this.bidDeptht = bidDeptht;
        this.numOffers = numOffers;
        this.numBids = numBids;
        this.time = time;
        this.seqNum = seqNum;
        this.sysTime = sysTime;
        this.updateTime = updateTime;
        this.openPeriodPrice = openPeriodPrice;
        this.lastToPrevPrice = lastToPrevPrice;
    }

    public String getSecId() {
        return secId;
    }

    public String getBoardId() {
        return boardId;
    }

    public double getBid() {
        return bid;
    }

    public double getOffer() {
        return offer;
    }

    public double getOfferDepth() {
        return offerDepth;
    }

    public double getOfferDeptht() {
        return offerDeptht;
    }

    public double getSpread() {
        return spread;
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

    public double getLast() {
        return last;
    }

    public double getLastChange() {
        return lastChange;
    }

    public int getNumTrades() {
        return numTrades;
    }

    public int getVolToday() {
        return volToday;
    }

    public double getValToday() {
        return valToday;
    }

    public double getValTodayUsd() {
        return valTodayUsd;
    }

    public double getLastChangePrcnt() {
        return lastChangePrcnt;
    }

    public int getBidDepth() {
        return bidDepth;
    }

    public int getBidDeptht() {
        return bidDeptht;
    }

    public int getNumOffers() {
        return numOffers;
    }

    public int getNumBids() {
        return numBids;
    }

    public Calendar getTime() {
        return time;
    }

    public String getSeqNum() {
        return seqNum;
    }

    public Calendar getSysTime() {
        return sysTime;
    }

    public Calendar getUpdateTime() {
        return updateTime;
    }

    public double getOpenPeriodPrice() {
        return openPeriodPrice;
    }

    public double getLastToPrevPrice() {
        return lastToPrevPrice;
    }

    @Override
    public String toString() {
        return "MarketData{" +
                "secId='" + secId + '\'' +
                ", boardId='" + boardId + '\'' +
                ", bid=" + bid +
                ", offer=" + offer +
                ", offerDepth=" + offerDepth +
                ", offerDeptht=" + offerDeptht +
                ", spread=" + spread +
                ", open=" + open +
                ", low=" + low +
                ", high=" + high +
                ", last=" + last +
                ", lastChange=" + lastChange +
                ", numTrades=" + numTrades +
                ", volToday=" + volToday +
                ", valToday=" + valToday +
                ", valTodayUsd=" + valTodayUsd +
                ", lastChangePrcnt=" + lastChangePrcnt +
                ", bidDepth=" + bidDepth +
                ", bidDeptht=" + bidDeptht +
                ", numOffers=" + numOffers +
                ", numBids=" + numBids +
                ", time=" + time +
                ", seqNum='" + seqNum + '\'' +
                ", sysTime=" + sysTime +
                ", updateTime=" + updateTime +
                ", openPeriodPrice=" + openPeriodPrice +
                ", lastToPrevPrice=" + lastToPrevPrice +
                '}';
    }
}
