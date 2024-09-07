package org.smirnovav.moex_lib.collectors.stock;

import org.smirnovav.moex_lib.collectors.MarketData;
import org.smirnovav.moex_lib.insideutils.DateTimeUtils;
import org.smirnovav.moex_lib.insideutils.NumberUtils;

import java.util.Calendar;

public class StockMarketData extends MarketData {
    private int qty; //Объем последней сделки в лотах
    private double value; // Объем последней сделки в валюте расчетов
    private double valueUsd; // Объем последней сделки в долларах США
    private double waPrice; // Средневзвешенная цена
    private double lastCngToLastWaPrice; //
    private double wapToPrevWaPricePrcnt; //
    private double wapToPrevWaPrice; //
    private double closePrice; // Цена послеторгового периода
    private double marketPriceToday; // Рыночная цена
    private double marketPrice; // Рыночная цена предыдущего дня
    private double etfSettlePrice; //
    private String tradingStatus; // Индикатор состояния торговой сессии по инструменту
    private double lastBid; // Лучшая котировка на покупку на момент завершения нормальноо периода торгов
    private double lastOffer; // Лучшая котировка на продажу на момент завершения нормальноо периода торгов
    private double lcLosePrice; // Цена закрытия
    private double lcCurrentPrice; // Текущая цена
    private double marketPrice2; // Рыночная цена 2
    private double change; // Изменение цены последней сделки по отношению к цене последней сделки предыдущего торгового дня
    private double highBid; // Наибольшая цена спроса в течение торговой сессии
    private double lowOffer; // Наименьшая цена предложения в течение торговой сессии
    private double priceMinusPrevWaPrice; // Цена последней сделки к оценке предыдущего дня
    private double closingActionPrice; // Цена аукциона закрытия
    private int closingActionVolume; // Количество в сделках аукциона закрытия. Ожидаемое количество лотов в сделках по указанной цене послеторгового аукциона
    private long issueCapitalisation; // Капитализация выпуска
    private Calendar issueCapitalisationUpdateTime; // Время обновления капитализации выпуска
    private String etfSettleCurrency; // Расчетная валюта ETF;
    private long valTodayRur; // Объем сделок выраженных в рублях за сегодня
    private String tradingSession; // Идентификатор торговой сессии
    private long trendIssueCapitalization; // Тренд капитализации выпуска

    public StockMarketData(String secId, String boardId, double bid, double offer, double offerDepth, double offerDeptht,
                           double spread, double open, double low, double high, double last, double lastChange, int numTrades,
                           int volToday, double valToday, double valTodayUsd, double lastChangePrcnt, int bidDepth,
                           int bidDeptht, int numOffers, int numBids, Calendar time, String seqNum, Calendar sysTime,
                           Calendar updateTime, double openPeriodPrice, double lastToPrevPrice, int qty, double value,
                           double valueUsd, double waPrice, double lastCngToLastWaPrice, double wapToPrevWaPricePrcnt,
                           double wapToPrevWaPrice, double closePrice, double marketPriceToday, double marketPrice,
                           double etfSettlePrice, String tradingStatus, double lastBid, double lastOffer, double lcLosePrice,
                           double lcCurrentPrice, double marketPrice2, double change, double highBid, double lowOffer,
                           double priceMinusPrevWaPrice, double closingActionPrice, int closingActionVolume, long issueCapitalisation,
                           Calendar issueCapitalisationUpdateTime, String etfSettleCurrency, long valTodayRur, String tradingSession,
                           long trendIssueCapitalization) {
        super(secId, boardId, bid, offer, offerDepth, offerDeptht, spread, open, low, high, last, lastChange, numTrades,
                volToday, valToday, valTodayUsd, lastChangePrcnt, bidDepth, bidDeptht, numOffers, numBids, time, seqNum,
                sysTime, updateTime, openPeriodPrice, lastToPrevPrice);
        this.qty = qty;
        this.value = value;
        this.valueUsd = valueUsd;
        this.waPrice = waPrice;
        this.lastCngToLastWaPrice = lastCngToLastWaPrice;
        this.wapToPrevWaPricePrcnt = wapToPrevWaPricePrcnt;
        this.wapToPrevWaPrice = wapToPrevWaPrice;
        this.closePrice = closePrice;
        this.marketPriceToday = marketPriceToday;
        this.marketPrice = marketPrice;
        this.etfSettlePrice = etfSettlePrice;
        this.tradingStatus = tradingStatus;
        this.lastBid = lastBid;
        this.lastOffer = lastOffer;
        this.lcLosePrice = lcLosePrice;
        this.lcCurrentPrice = lcCurrentPrice;
        this.marketPrice2 = marketPrice2;
        this.change = change;
        this.highBid = highBid;
        this.lowOffer = lowOffer;
        this.priceMinusPrevWaPrice = priceMinusPrevWaPrice;
        this.closingActionPrice = closingActionPrice;
        this.closingActionVolume = closingActionVolume;
        this.issueCapitalisation = issueCapitalisation;
        this.issueCapitalisationUpdateTime = issueCapitalisationUpdateTime;
        this.etfSettleCurrency = etfSettleCurrency;
        this.valTodayRur = valTodayRur;
        this.tradingSession = tradingSession;
        this.trendIssueCapitalization = trendIssueCapitalization;
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

                "Объем последней сделки в лотах = " + qty + "\n" +
                "Объем последней сделки в валюте расчетов = " + value + "\n" +
                "Объем последней сделки в долларах США = " + valueUsd + "\n" +
                "Средневзвешенная цена = " + waPrice + "\n" +
                "LASTCNGTOLASTWAPRICE = " + lastCngToLastWaPrice + "\n" +
                "WAPTOPREVWAPRICEPRCNT = " + wapToPrevWaPricePrcnt + "\n" +
                "WAPTOPREVWAPRICE = " + wapToPrevWaPrice + "\n" +
                "Цена послеторгового периода = " + closePrice + "\n" +
                "Рыночная цена = " + marketPriceToday + "\n" +
                "Рыночная цена предыдущего дня = " + marketPrice + "\n" +
                "ETFSETTLEPRICE = " + etfSettlePrice + "\n" +
                "Индикатор состояния торговой сессии по инструменту = " + tradingStatus + "\n" +
                "Лучшая котировка на покупку на момент завершения нормальноо периода торгов = " + lastBid + "\n" +
                "Лучшая котировка на продажу на момент завершения нормальноо периода торгов = " + lastOffer + "\n" +
                "Цена закрытия = " + lcLosePrice + "\n" +
                "Текущая цена = " + lcCurrentPrice + "\n" +
                "Рыночная цена 2 = " + marketPrice2 + "\n" +
                "Изменение цены последней сделки по отношению к цене последней сделки предыдущего торгового дня = " + change + "\n" +
                "Наибольшая цена спроса в течение торговой сессии = " + highBid + "\n" +
                "Наименьшая цена предложения в течение торговой сессии = " + lowOffer + "\n" +
                "Цена последней сделки к оценке предыдущего дня = " + priceMinusPrevWaPrice + "\n" +
                "Цена аукциона закрытия = " + closingActionPrice + "\n" +
                "Количество в сделках аукциона закрытия. Ожидаемое количество лотов в сделках по указанной цене послеторгового аукциона = " + closingActionVolume + "\n" +
                "Капитализация выпуска = " + issueCapitalisation + "\n" +
                "Время обновления капитализации выпуска = " + DateTimeUtils.calendarToFormattedTime(issueCapitalisationUpdateTime) + "\n" +
                "Расчетная валюта ETF = " + etfSettleCurrency + "\n" +
                "Объем сделок выраженных в рублях за сегодня = " + valTodayRur + "\n" +
                "Идентификатор торговой сессии = " + tradingSession + "\n" +
                "Тренд капитализации выпуска = " + trendIssueCapitalization;
    }

}
