package org.smirnovav.moex_lib.collectors;

import org.smirnovav.moex_lib.insideutils.DateTimeUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Класс содержащий спецификацию бумаги, в том числе, информацию о режимах торгов (подходит для торговых систем stock и futures)
 */
public class SecuritySpecification {
    private List<SecurityBoard> boards; // Режимы торгов
    private String secId; // Краткий код (GZU4)
    private String name; // Наименование серии инструмента (Фьючерсный контракт GAZR-9.24)
    private String shortName; // Краткое наименование контракта (GAZR-9.24)
    private String isin; // ISIN код
    private String regnumber; // Номер государственной регистрации
    private long issueSize; // Объем выпуска
    private double faceValue; // Номинальная стоимость
    private String faceUnit; // Валюта номинала
    private Calendar issueDate; // Дата начала торгов
    private String latName; // Английское наименование (GAZR-9.24)
    private int listLevel; // Уровень листинга
    private boolean isQualifiedInvestors; // Бумаги для квалифицированных инвесторов
    private boolean morningSession; // Допуск к утренней дополнительной торговой сессии
    private boolean eveningSession; // Допуск к вечерней дополнительной торговой сессии
    private String deliveryType; // Исполнение (Поставка ценных бумаг путем заключения сделки в Секции фондового рынка в порядке, предусмотренном Правилами проведения торгов на фондовом рынке ПАО Московская Биржа (до 19.12.2016 – ЗАО «ФБ ММВБ»), по цене, равной результату деления РЦ Контракта, определенной по итогам вечернего Расчетного периода последнего дня заключения Контракта, на лот Контракта.)
    private Calendar firstTrade; // Начало обращения
    private Calendar lastTrade; // Последний день обращения
    private Calendar lastDeleteDate; // Дата исполнения
    private String assetCode; // Код базового актива (GAZR)
    private String execType; // Тип контракта (Поставочный)
    private int lotSize; // Лот
    private String contractName; // Наименование контракта (Фьючерсный контракт на обыкновенные акции ПАО «Газпром»)
    private String groupType; // Группа контрактов (Акции)
    private String unit; // Котировка (в рублях за лот)
    private String expirationClrSess; // Клиринг исполнения (Основной)
    private String typeName; // Вид контракта (Фьючерс)
    private String group; // Код типа инструмента (futures_forts)
    private String type; // Тип бумаги (futures)
    private String groupName; // Тип инструмента (Фьючерсы)
    private int emitterId; // Код эмитента (711)

    public SecuritySpecification(List<SecurityBoard> boards, String secId, String name, String shortName, String latName,
                                 String deliveryType, Calendar firstTrade, Calendar lastTrade, Calendar lastDeleteDate,
                                 String assetCode, String execType, int lotSize, String contractName, String groupType,
                                 String unit, String expirationClrSess, String typeName, String group, String type,
                                 String groupName, int emitterId) {
        this.boards = boards;
        this.secId = secId;
        this.name = name;
        this.shortName = shortName;
        this.latName = latName;
        this.deliveryType = deliveryType;
        this.firstTrade = firstTrade;
        this.lastTrade = lastTrade;
        this.lastDeleteDate = lastDeleteDate;
        this.assetCode = assetCode;
        this.execType = execType;
        this.lotSize = lotSize;
        this.contractName = contractName;
        this.groupType = groupType;
        this.unit = unit;
        this.expirationClrSess = expirationClrSess;
        this.typeName = typeName;
        this.group = group;
        this.type = type;
        this.groupName = groupName;
        this.emitterId = emitterId;
    }

    public SecuritySpecification() {

    }

    public List<SecurityBoard> getBoards() {
        return boards;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public long getIssueSize() {
        return issueSize;
    }

    public void setIssueSize(long issueSize) {
        this.issueSize = issueSize;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }

    public String getFaceUnit() {
        return faceUnit;
    }

    public void setFaceUnit(String faceUnit) {
        this.faceUnit = faceUnit;
    }

    public Calendar getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Calendar issueDate) {
        this.issueDate = issueDate;
    }

    public String getLatName() {
        return latName;
    }

    public void setLatName(String latName) {
        this.latName = latName;
    }

    public int getListLevel() {
        return listLevel;
    }

    public void setListLevel(int listLevel) {
        this.listLevel = listLevel;
    }

    public boolean isQualifiedInvestors() {
        return isQualifiedInvestors;
    }

    public void setQualifiedInvestors(boolean qualifiedInvestors) {
        isQualifiedInvestors = qualifiedInvestors;
    }

    public boolean isMorningSession() {
        return morningSession;
    }

    public void setMorningSession(boolean morningSession) {
        this.morningSession = morningSession;
    }

    public boolean isEveningSession() {
        return eveningSession;
    }

    public void setEveningSession(boolean eveningSession) {
        this.eveningSession = eveningSession;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Calendar getFirstTrade() {
        return firstTrade;
    }

    public void setFirstTrade(Calendar firstTrade) {
        this.firstTrade = firstTrade;
    }

    public Calendar getLastTrade() {
        return lastTrade;
    }

    public void setLastTrade(Calendar lastTrade) {
        this.lastTrade = lastTrade;
    }

    public Calendar getLastDeleteDate() {
        return lastDeleteDate;
    }

    public void setLastDeleteDate(Calendar lastDeleteDate) {
        this.lastDeleteDate = lastDeleteDate;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getExpirationClrSess() {
        return expirationClrSess;
    }

    public void setExpirationClrSess(String expirationClrSess) {
        this.expirationClrSess = expirationClrSess;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getEmitterId() {
        return emitterId;
    }

    public void setEmitterId(int emitterId) {
        this.emitterId = emitterId;
    }

    /**
     * Класс содержащий информацию о режиме торгов
     */
    class SecurityBoard {
        private String secId; // Краткий код (GZU4)
        private String boardId; // Идентификатор режима торгов
        private String title; // Наименование вида контракта
        private int boardGroupId; // Идентификатор группы режимов торгов
        private int marketId; // Идентификатор рынка торговой системы
        private String market; // Рынок торговой системы
        private int engineId; // Идентификатор торговой системы
        private String engine; // Торговая система
        private boolean isTraded; // Торгуется ли инструмент
        private int decimals; // Количество знаков после запятой в котировке
        private Calendar historyFrom; // Начиная с какой даты есть история по бумаге
        private Calendar historyTill; // До какой даты есть история по бумаге
        private Calendar listedFrom; // Начиная с какой даты производится листинг бумаги на площадке
        private Calendar listedTill; // До какой даты на настоящий момент времени производился/производится листинг бумаги на площадке
        private boolean isPrimary; // Является ли данный режим торгов для бумаги основным
        private String currencyId; // Идентификатор валюты

        public SecurityBoard(String secId, String boardId, String title, int boardGroupId, int marketId, String market,
                             int engineId, String engine, boolean isTraded, int decimals, Calendar historyFrom,
                             Calendar historyTill, Calendar listedFrom, Calendar listedTill, boolean isPrimary,
                             String currencyId) {
            this.secId = secId;
            this.boardId = boardId;
            this.title = title;
            this.boardGroupId = boardGroupId;
            this.marketId = marketId;
            this.market = market;
            this.engineId = engineId;
            this.engine = engine;
            this.isTraded = isTraded;
            this.decimals = decimals;
            this.historyFrom = historyFrom;
            this.historyTill = historyTill;
            this.listedFrom = listedFrom;
            this.listedTill = listedTill;
            this.isPrimary = isPrimary;
            this.currencyId = currencyId;
        }

        public String getSecId() {
            return secId;
        }

        public String getBoardId() {
            return boardId;
        }

        public String getTitle() {
            return title;
        }

        public int getBoardGroupId() {
            return boardGroupId;
        }

        public int getMarketId() {
            return marketId;
        }

        public String getMarket() {
            return market;
        }

        public int getEngineId() {
            return engineId;
        }

        public String getEngine() {
            return engine;
        }

        public boolean isTraded() {
            return isTraded;
        }

        public int getDecimals() {
            return decimals;
        }

        public Calendar getHistoryFrom() {
            return historyFrom;
        }

        public Calendar getHistoryTill() {
            return historyTill;
        }

        public Calendar getListedFrom() {
            return listedFrom;
        }

        public Calendar getListedTill() {
            return listedTill;
        }

        public boolean isPrimary() {
            return isPrimary;
        }

        public String getCurrencyId() {
            return currencyId;
        }

        @Override
        public String toString() {
            String s1 = "Краткий код = " + secId + "\n";
            String s2 = "Идентификатор режима торгов = " + boardId + "\n";
            String s3 = "Наименование вида контракта = " + title + "\n";
            String s4 = "Идентификатор группы режимов торгов = " + boardGroupId + "\n";
            String s5 = "Идентификатор рынка торговой системы = " + marketId + "\n";
            String s6 = "Рынок торговой системы = " + market + "\n";
            String s7 = "Идентификатор торговой системы = " + engineId + "\n";
            String s8 = "Торговая система = " + engine + "\n";
            String s9 = "Торгуется ли инструмент = " + isTraded + "\n";
            String s10 = "Количество знаков после запятой в котировке = " + decimals + "\n";
            String s11 = "Начиная с какой даты есть история по бумаге = " + DateTimeUtils.calendarToDateWithDash(historyFrom) + "\n";
            String s12 = "До какой даты есть история по бумаге = " + DateTimeUtils.calendarToDateWithDash(historyTill) + "\n";
            String s13 = "Начиная с какой даты производится листинг бумаги на площадке = " + DateTimeUtils.calendarToDateWithDash(listedFrom) + "\n";
            String s14 = "До какой даты на настоящий момент времени производился/производится листинг бумаги на площадке = " + DateTimeUtils.calendarToDateWithDash(listedTill) + "\n";
            String s15 = "Является ли данный режим торгов для бумаги основным = " + isPrimary + "\n";
            String s16 = "Идентификатор валюты = " + currencyId + "\n";
            return s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14 + s15 + s16;
        }
    }

    public void setSecurityBoards(List<List<String>> rawSequrityBoards) {
        List<SecurityBoard> securityBoards = new ArrayList<>();
        for (List<String> securityBoard: rawSequrityBoards) {
            securityBoards.add(new SecurityBoard(securityBoard.get(0), securityBoard.get(1), securityBoard.get(2),
                Integer.parseInt(securityBoard.get(3)), Integer.parseInt(securityBoard.get(4)),
                securityBoard.get(5), Integer.parseInt(securityBoard.get(6)), securityBoard.get(7),
                securityBoard.get(8).equals("1"), Integer.parseInt(securityBoard.get(9)),
                DateTimeUtils.stringDateTimeWithDashesToCalendar(securityBoard.get(10)),
                DateTimeUtils.stringDateTimeWithDashesToCalendar(securityBoard.get(11)),
                DateTimeUtils.stringDateTimeWithDashesToCalendar(securityBoard.get(12)),
                DateTimeUtils.stringDateTimeWithDashesToCalendar(securityBoard.get(13)),
                securityBoard.get(14).equals("1"), securityBoard.get(15)));
        }
        this.boards = securityBoards;
    }

    @Override
    public String toString() {
        String s1 = "Краткий код = " + secId + "\n";
        String s2 = "Наименование серии инструмента = " + name + "\n";
        String s3 = "Краткое наименование контракта = " + shortName + "\n";
        String s4 = "ISIN = " + isin + "\n";
        String s5 = "Номер государственной регистрации = " + regnumber + "\n";
        String s6 = "Объем выпуска = " + issueSize + "\n";
        String s7 = "Номинальная стоимость = " + faceValue + "\n";
        String s8 = "Валюта номинала = " + faceUnit + "\n";
        String s9 = "Дата начала торгов = " + DateTimeUtils.calendarToDateWithDash(issueDate) + "\n";
        String s10 = "Английское наименование = " + latName + "\n";
        String s11 = "Уровень листинга = " + listLevel + "\n";
        String s12 = "Бумаги для квалифицированных инвесторов = " + isQualifiedInvestors + "\n";
        String s13 = "Допуск к утренней дополнительной торговой сессии = " + morningSession + "\n";
        String s14 = "Допуск к вечерней дополнительной торговой сессии = " + eveningSession + "\n";
        String s15 = "Исполнение = " + deliveryType + "\n";
        String s16 = "Начало обращения = " + DateTimeUtils.calendarToDateWithDash(firstTrade) + "\n";
        String s17 = "Последний день обращения = " + DateTimeUtils.calendarToDateWithDash(lastTrade) + "\n";
        String s18 = "Дата исполнения = " + DateTimeUtils.calendarToDateWithDash(lastDeleteDate) + "\n";
        String s19 = "Код базового актива = " + assetCode + "\n";
        String s20 = "Тип контракта = " + execType + "\n";
        String s21 = "Лот = " + lotSize + "\n";
        String s22 = "Наименование контракта = " + contractName + "\n";
        String s23 = "Группа контрактов = " + groupType + "\n";
        String s24 = "Котировка = " + unit + "\n";
        String s25 = "Клиринг исполнения = " + expirationClrSess + "\n";
        String s26 = "Вид контракта = " + typeName + "\n";
        String s27 = "Код типа инструмента = " + group + "\n";
        String s28 = "Тип бумаги = " + type + "\n";
        String s29 = "Тип инструмента = " + groupName + "\n";
        String s30 = "Код эмитента = " + emitterId + "\n";
        String s31 = "\nИнструмент имеет следующие режимы торгов:\n";
        StringBuilder builder = new StringBuilder();
        if (boards != null || !boards.isEmpty()) {
            for (int i = 0; i < boards.size(); i++) {
                builder.append("Режим торгов №").append(i + 1).append(":\n").append(boards.get(i).toString()).append("\n");
                builder.append("\n");
            }
        } else {
            builder.append("Нет доступных режимов торгов");
        }
        return s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14 + s15 + s16 + s17 + s18 + s19 +
                s20 + s21 + s22 + s23 + s24 + s25 + s26 + s27 + s28 + s29 + s30 + s31 + builder;
    }

    public String getPrimaryEngine() {
        for (SecurityBoard board : boards) {
            if (board.isPrimary) {
                return board.getEngine();
            }
        }
        return null;
    }
    public String getPrimaryMarket() {
        for (SecurityBoard board : boards) {
            if (board.isPrimary) {
                return board.getMarket();
            }
        }
        return null;
    }

    public int getPrimaryDecimals() {
        for (SecurityBoard board : boards) {
            if (board.isPrimary) {
                return board.getDecimals();
            }
        }
        throw new NumberFormatException("Нет количества знаков после запятой для данного инструмента");
    }

    public String getPrimaryBoard() {
        for (SecurityBoard board : boards) {
            if (board.isPrimary) {
                return board.getBoardId();
            }
        }
        throw new NumberFormatException("Нет количества знаков после запятой для данного инструмента");
    }


}
