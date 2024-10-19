package org.smirnovav.moex_lib.collectors.futures;

import org.smirnovav.moex_lib.collectors.MarketData;
import org.smirnovav.moex_lib.insideutils.DateTimeUtils;
import org.smirnovav.moex_lib.insideutils.NumberUtils;

import java.util.Calendar;
import java.util.Date;

public class FuturesMarketData extends MarketData{
    private int quantity; // Объем выраженный в лотах
    private double settlePrice; // Расчетная цена
    private double settleToPrevSettle; // Разница текущей установленной цены к предыдущей
    private int openPosition; // Количество открытых позиций
    private double settleToPrevSettlePrc; // Разница текущей установленной цены к предыдущей в процентах
    private Calendar tradeDate; // Дата сделки
    private double oiChange; // ???
    private double swapRate; // ???

    public FuturesMarketData(String secId, String boardId, double bid, double offer, double offerDepth, double offerDeptht,
                             double spread, double open, double low, double high, double last, double lastChange,
                             int numTrades, int volToday, double valToday, double valTodayUsd, double lastChangePrcnt,
                             int bidDepth, int bidDeptht, int numOffers, int numBids, Calendar time, String seqNum,
                             Calendar sysTime, Calendar updateTime, double openPeriodPrice, double lastToPrevPrice,
                             int quantity, double settlePrice, double settleToPrevSettle, int openPosition,
                             double settleToPrevSettlePrc, Calendar tradeDate, double oiChange, double swapRate) {
        super(secId, boardId, bid, offer, offerDepth, offerDeptht, spread, open, low, high, last, lastChange, numTrades,
                volToday, valToday, valTodayUsd, lastChangePrcnt, bidDepth, bidDeptht, numOffers, numBids, time, seqNum,
                sysTime, updateTime, openPeriodPrice, lastToPrevPrice);
        this.quantity = quantity;
        this.settlePrice = settlePrice;
        this.settleToPrevSettle = settleToPrevSettle;
        this.openPosition = openPosition;
        this.settleToPrevSettlePrc = settleToPrevSettlePrc;
        this.tradeDate = tradeDate;
        this.oiChange = oiChange;
        this.swapRate = swapRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSettlePrice() {
        return settlePrice;
    }

    public double getSettleToPrevSettle() {
        return settleToPrevSettle;
    }

    public int getOpenPosition() {
        return openPosition;
    }

    public double getSettleToPrevSettlePrc() {
        return settleToPrevSettlePrc;
    }

    public Calendar getTradeDate() {
        return tradeDate;
    }

    public double getOiChange() {
        return oiChange;
    }

    public double getSwapRate() {
        return swapRate;
    }

    @Override
    public String toString() {
        return  "Краткий код = " + getSecId() + "\n" +
                "Идентификатор режима торгов = " + getBoardId() + "\n" +
                "Спрос = " + getBid() + "\n" +
                "Предложение = " + getOffer() + "\n" +
                "Объем заявок на продажу по лучшей котировке, выраженный в лотах = " + getOfferDepth() + "\n" +
                "Объем всех заявок на продажу в очереди торговой системы, выраженный в лотах = " + getOfferDeptht() + "\n" +
                "Разница между ценой покупки и ценой продажи = " + getSpread() + "\n" +
                "Цена открытия = " + getOpen() + "\n" +
                "Минимальная цена = " + getLow() + "\n" +
                "Максимальная цена = " + getHigh() + "\n" +
                "Последняя цена = " + getLast() + "\n" +
                "Изменение цены последней сделки по отношению к цене последней сделки предыдущего дня = " + getLastChange() + "\n" +
                "Количество сделок за торговый день = " + getNumTrades() + "\n" +
                "Объем сделок за сегодня в количестве ценных бумаг = " + getVolToday() + "\n" +
                "Объем сделок за сегодня в валюте расчетов = " + NumberUtils.getRoundingStringNumber(getValToday(), 2) + "\n" +
                "Объем сделок за сегодня в долларах США = " + NumberUtils.getRoundingStringNumber(getValTodayUsd(), 2) + "\n" +
                "Изменение цены последней сделки по отношению к цене последней сделки предыдущего дня в процентах = " + getLastChangePrcnt() + "\n" +
                "Объем заявок на покупку по лучшей котировке, выраженный в лотах = " + getBidDepth() + "\n" +
                "Объем всех заявок на покупку в очереди торговой системы, выраженный в лотах = " + getBidDeptht() + "\n" +
                "Количество заявок на продажу в очереди торговой системы = " + getNumOffers() + "\n" +
                "Количество заявок на покупку в очереди торговой системы = " + getNumBids() + "\n" +
                "Время заключения последней сделки = " + DateTimeUtils.calendarToFormattedTime(getTime()) + "\n" +
                "Некий 14-значный номер обозначающий дату и время последней сделки в формате yyyyMMddhhmmss = " + getSeqNum() + "\n" +
                "Системное время = " + DateTimeUtils.calendarToDateTime(getSysTime()) + "\n" +
                "Время обновления = " + DateTimeUtils.calendarToFormattedTime(getUpdateTime()) + "\n" +
                "Цена предторгового периода или аукциона открытия = " + getOpenPeriodPrice() + "\n" +
                "LASTTOPREVPRICE = " + getLastToPrevPrice() + "\n" +
                "Объем выраженный в лотах = " + quantity + "\n" +
                "Расчетная цена = " + settlePrice + "\n" +
                "Разница текущей установленной цены к предыдущей = " + settleToPrevSettle + "\n" +
                "Количество открытых позиций = " + openPosition + "\n" +
                "Разница текущей установленной цены к предыдущей в процентах = " + settleToPrevSettlePrc + "\n" +
                "Дата сделки = " + DateTimeUtils.calendarToDateWithDash(tradeDate) + "\n" +
                "OICHANGE = " + oiChange + "\n" +
                "SWAPRATE = " + swapRate + "\n";
    }
}
