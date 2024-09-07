package org.smirnovav.moex_lib.collectors.futures;

import org.smirnovav.moex_lib.collectors.SecurityBoardSpecification;
import org.smirnovav.moex_lib.insideutils.DateTimeUtils;
import org.smirnovav.moex_lib.insideutils.NumberUtils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FuturesBoardSpecification extends SecurityBoardSpecification {
    private double prevSettlePrice; // Расчётная цена предыдущего дня
    private Calendar lastTradeDate; //Последний день торгов
    private Calendar lastDelDate; // Дата исполнения
    private String assetCode; // База краткого наименования контракта (GAZR)
    private int prevOpenPosition; // Количество открытых позициций
    private int lotVolume; // Лот (Единиц базового актива)
    private double initialMargin; //Гарантийное обеспечение
    private double highLimit; //Верхний лимит
    private double lowLimit; //Нижний лимит
    private double stepPrice; //Шаг цены
    private double lastSettlePrice; //Расчётная цена последнего клиринга
    private Calendar imTime; //Время и дата последней цены
    private double buySellFee; //Сбор за регистрацию сделки
    private double scalperFee; //Сбор за скальперскую сделку
    private double negotiatedFee; //Сбор за адресную сделку
    private double exerciseFee; //Клиринговая комиссия за исполенние контракта

    public FuturesBoardSpecification(String secId, String boardId, String shortName, String secName, int decimals,
                                     double minStep, String latName, String secType, double prevPrice,
                                     double prevSettlePrice, Calendar lastTradeDate, Calendar lastDelDate,
                                     String assetCode, int prevOpenPosition, int lotVolume, double initialMargin,
                                     double highLimit, double lowLimit, double stepPrice, double lastSettlePrice,
                                     Calendar imTime, double buySellFee, double scalperFee, double negotiatedFee, double exerciseFee) {
        super(secId, boardId, shortName, secName, decimals, minStep, latName, secType, prevPrice);
        this.prevSettlePrice = prevSettlePrice;
        this.lastTradeDate = lastTradeDate;
        this.lastDelDate = lastDelDate;
        this.assetCode = assetCode;
        this.prevOpenPosition = prevOpenPosition;
        this.lotVolume = lotVolume;
        this.initialMargin = initialMargin;
        this.highLimit = highLimit;
        this.lowLimit = lowLimit;
        this.stepPrice = stepPrice;
        this.lastSettlePrice = lastSettlePrice;
        this.imTime = imTime;
        this.buySellFee = buySellFee;
        this.scalperFee = scalperFee;
        this.negotiatedFee = negotiatedFee;
        this.exerciseFee = exerciseFee;
    }

    public double getPrevSettlePrice() {
        return prevSettlePrice;
    }

    public void setPrevSettlePrice(double prevSettlePrice) {
        this.prevSettlePrice = prevSettlePrice;
    }

    public Calendar getLastTradeDate() {
        return lastTradeDate;
    }

    public void setLastTradeDate(Calendar lastTradeDate) {
        this.lastTradeDate = lastTradeDate;
    }

    public Calendar getLastDelDate() {
        return lastDelDate;
    }

    public void setLastDelDate(Calendar lastDelDate) {
        this.lastDelDate = lastDelDate;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public int getPrevOpenPosition() {
        return prevOpenPosition;
    }

    public void setPrevOpenPosition(int prevOpenPosition) {
        this.prevOpenPosition = prevOpenPosition;
    }

    public int getLotVolume() {
        return lotVolume;
    }

    public void setLotVolume(int lotVolume) {
        this.lotVolume = lotVolume;
    }

    public double getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(double initialMargin) {
        this.initialMargin = initialMargin;
    }

    public double getHighLimit() {
        return highLimit;
    }

    public void setHighLimit(double highLimit) {
        this.highLimit = highLimit;
    }

    public double getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(double lowLimit) {
        this.lowLimit = lowLimit;
    }

    public double getStepPrice() {
        return stepPrice;
    }

    public void setStepPrice(double stepPrice) {
        this.stepPrice = stepPrice;
    }

    public double getLastSettlePrice() {
        return lastSettlePrice;
    }

    public void setLastSettlePrice(double lastSettlePrice) {
        this.lastSettlePrice = lastSettlePrice;
    }

    public Calendar getImTime() {
        return imTime;
    }

    public void setImTime(Calendar imTime) {
        this.imTime = imTime;
    }

    public double getBuySellFee() {
        return buySellFee;
    }

    public void setBuySellFee(double buySellFee) {
        this.buySellFee = buySellFee;
    }

    public double getScalperFee() {
        return scalperFee;
    }

    public void setScalperFee(double scalperFee) {
        this.scalperFee = scalperFee;
    }

    public double getNegotiatedFee() {
        return negotiatedFee;
    }

    public void setNegotiatedFee(double negotiatedFee) {
        this.negotiatedFee = negotiatedFee;
    }

    public double getExerciseFee() {
        return exerciseFee;
    }

    public void setExerciseFee(double exerciseFee) {
        this.exerciseFee = exerciseFee;
    }

    private static Calendar stringToDate(String date) {
        return new GregorianCalendar(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)),
                Integer.parseInt(date.substring(8, 10)));
    }

    @Override
    public String toString() {
        return  "Краткий код бумаги = " + getSecId() + "\n" +
                "Режим торгов = " + getBoardId() + "\n" +
                "Краткое наименование бумаги = " + getShortName() + "\n" +
                "Полное имя бумаги = " + getSecName() + "\n" +
                "Количество знаков после запятой = " + getDecimals() + "\n" +
                "Минимальный шаг цены= " + getMinStep() + "\n" +
                "Английское наименование бумаги = " + getLatName() + "\n" +
                "База краткого кода = " + getSecType() + "\n" +
                "Последняя цена = " + NumberUtils.getRoundingStringNumber(getPrevPrice(), getDecimals()) + "\n" +
                "Предыдущая расчетная цена = " + NumberUtils.getRoundingStringNumber(prevSettlePrice, getDecimals()) + "\n" +
                "Последний день обращения = " + DateTimeUtils.calendarToDateWithDash(lastTradeDate) + "\n" +
                "Дата исполнения = " + DateTimeUtils.calendarToDateWithDash(lastDelDate) + "\n" +
                "Код базового актива = " + assetCode + "\n" +
                "Открытые позиции предыдущего дня = " + prevOpenPosition + "\n" +
                "Лот (Единиц базового актива) = " + lotVolume + "\n" +
                "Гарантийное обеспечение = " + initialMargin + "\n" +
                "Верхний лимит = " + NumberUtils.getRoundingStringNumber(highLimit, getDecimals()) + "\n" +
                "Нижний лимит = " + NumberUtils.getRoundingStringNumber(lowLimit, getDecimals()) + "\n" +
                "Шаг цены = " + stepPrice + "\n" +
                "Расчётная цена последнего клиринга = " + NumberUtils.getRoundingStringNumber(lastSettlePrice, getDecimals()) + "\n" +
                "Время и дата последней цены = " + DateTimeUtils.calendarToDateTime(imTime) + "\n" +
                "Сбор за регистрацию сделки = " + buySellFee + "\n" +
                "Сбор за скальперскую сделку = " + scalperFee + "\n" +
                "Сбор за адресную сделку = " + negotiatedFee + "\n" +
                "Клиринговая комиссия за исполенние контракта = " + exerciseFee;
    }
}
