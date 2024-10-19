package org.smirnovav.moex_lib.collectors;

public class SecurityBoardSpecification {

    private String secId; //Краткий код
    private String boardId; // Board на бирже
    private String shortName; // Краткое наименование
    private String secName; //Полное имя бумаги
    private int decimals; //Количество знаков после запятой
    private double minStep; //Шаг цены
    private String latName; // Английское имя бумаги
    private String secType; //База краткого кода
    private double prevPrice; //Последняя цена

    public SecurityBoardSpecification(String secId, String boardId, String shortName, String secName, int decimals, double minStep, String latName, String secType, double prevPrice) {
        this.secId = secId;
        this.boardId = boardId;
        this.shortName = shortName;
        this.secName = secName;
        this.decimals = decimals;
        this.minStep = minStep;
        this.latName = latName;
        this.secType = secType;
        this.prevPrice = prevPrice;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    public double getMinStep() {
        return minStep;
    }

    public void setMinStep(double minStep) {
        this.minStep = minStep;
    }

    public String getLatName() {
        return latName;
    }

    public void setLatName(String latName) {
        this.latName = latName;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public double getPrevPrice() {
        return prevPrice;
    }

    public void setPrevPrice(double prevPrice) {
        this.prevPrice = prevPrice;
    }
}
