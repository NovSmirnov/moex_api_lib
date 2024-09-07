package org.smirnovav.moex_lib.collectors.stock;

import org.smirnovav.moex_lib.collectors.SecurityBoardSpecification;
import org.smirnovav.moex_lib.insideutils.DateTimeUtils;
import org.smirnovav.moex_lib.insideutils.NumberUtils;

import java.util.Calendar;

public class StockBoardSpecification extends SecurityBoardSpecification {
    private int lotSize; // Размер лота
    private int faceValue; // Номинальная стоимость
    private String status; // Статус
    private String boardName; // Название режима торгов
    private String remarks; // Примечание
    private String marketCode; // Код рынка
    private String instrId; // Идентификатор группы инструментов
    private String sectorId; // Сектор
    private double prevWaPrice; // Оценка предыдущего дня
    private String faceUnit; // Валюта номинала
    private Calendar prevDate; // Дата последних торгов
    private long issueSize; // Объем выпуска
    private String isin; // ISIN
    private String regNumber; // Регистрационный номер
    private double prevLegalClosePrice; // Цена закрытия предыдущего дня
    private String currencyId; // Валюта расчетов
    private int listLevel; // Уровень листинга
    private Calendar settleDate; // Дата расчетов

    public StockBoardSpecification(String secId, String boardId, String shortName, String secName, int decimals,
                                   double minStep, String latName, String secType, double prevPrice, int lotSize,
                                   int faceValue, String status, String boardName, String remarks, String marketCode,
                                   String instrId, String sectorId, double prevWaPrice, String faceUnit,
                                   Calendar prevDate, long issueSize, String isin, String regNumber,
                                   double prevLegalClosePrice, String currencyId, int listLevel, Calendar settleDate) {
        super(secId, boardId, shortName, secName, decimals, minStep, latName, secType, prevPrice);
        this.lotSize = lotSize;
        this.faceValue = faceValue;
        this.status = status;
        this.boardName = boardName;
        this.remarks = remarks;
        this.marketCode = marketCode;
        this.instrId = instrId;
        this.sectorId = sectorId;
        this.prevWaPrice = prevWaPrice;
        this.faceUnit = faceUnit;
        this.prevDate = prevDate;
        this.issueSize = issueSize;
        this.isin = isin;
        this.regNumber = regNumber;
        this.prevLegalClosePrice = prevLegalClosePrice;
        this.currencyId = currencyId;
        this.listLevel = listLevel;
        this.settleDate = settleDate;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getInstrId() {
        return instrId;
    }

    public void setInstrId(String instrId) {
        this.instrId = instrId;
    }

    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    public double getPrevWaPrice() {
        return prevWaPrice;
    }

    public void setPrevWaPrice(double prevWaPrice) {
        this.prevWaPrice = prevWaPrice;
    }

    public String getFaceUnit() {
        return faceUnit;
    }

    public void setFaceUnit(String faceUnit) {
        this.faceUnit = faceUnit;
    }

    public Calendar getPrevDate() {
        return prevDate;
    }

    public void setPrevDate(Calendar prevDate) {
        this.prevDate = prevDate;
    }

    public long getIssueSize() {
        return issueSize;
    }

    public void setIssueSize(long issueSize) {
        this.issueSize = issueSize;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public double getPrevLegalClosePrice() {
        return prevLegalClosePrice;
    }

    public void setPrevLegalClosePrice(double prevLegalClosePrice) {
        this.prevLegalClosePrice = prevLegalClosePrice;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public int getListLevel() {
        return listLevel;
    }

    public void setListLevel(int listLevel) {
        this.listLevel = listLevel;
    }

    public Calendar getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Calendar settleDate) {
        this.settleDate = settleDate;
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
                "Размер лота = " + lotSize + "\n" +
                "Номинальная стоимость = " + faceValue + "\n" +
                "Статус = " + status + "\n" +
                "Название режима торгов = " + boardName + "\n" +
                "Примечание = " + remarks + "\n" +
                "Код рынка = " + marketCode + "\n" +
                "Идентификатор группы инструментов = " + instrId + "\n" +
                "Сектор = " + sectorId + "\n" +
                "Оценка предыдущего дня = " + NumberUtils.getRoundingStringNumber(prevWaPrice, getDecimals()) + "\n" +
                "Валюта номинала = " + faceUnit + "\n" +
                "Дата последних торгов = " + DateTimeUtils.calendarToDateWithDash(prevDate) + "\n" +
                "Объем выпуска = " + issueSize + "\n" +
                "ISIN = " + isin + "\n" +
                "Регистрационный номер = " + regNumber + "\n" +
                "Цена закрытия предыдущего дня = " + NumberUtils.getRoundingStringNumber(prevLegalClosePrice, getDecimals()) + "\n" +
                "Валюта расчетов = " + currencyId + "\n" +
                "Уровень листинга = " + listLevel + "\n" +
                "Дата расчетов = " + DateTimeUtils.calendarToDateWithDash(settleDate);
    }
}
