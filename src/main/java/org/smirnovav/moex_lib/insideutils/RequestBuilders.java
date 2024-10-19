package org.smirnovav.moex_lib.insideutils;

import org.smirnovav.moex_lib.collectors.SecuritySpecification;
import org.smirnovav.moex_lib.enums.Engines;
import org.smirnovav.moex_lib.utils.SecurityUtils;

import java.util.Calendar;

public class RequestBuilders {

    public static String candlesJsonRequest(String secId, String engine, String market, Calendar firstDateTime,
                                            Calendar lastDateTime, int intervalInMinutes) {
        return  "http://iss.moex.com/iss/engines/" + engine + "/markets/" + market + "/securities/" + secId + "/candles.json" +
                "?from=" + DateTimeUtils.calendarToDateTime(firstDateTime) + "&till=" +
                DateTimeUtils.calendarToDateTime(lastDateTime) + "&interval=" + intervalInMinutes;
    }

    public static String candlesJsonRequest(String secId, Calendar firstDateTime,
                                            Calendar lastDateTime, int intervalInMinutes) {
        SecuritySpecification securitySpecification = SecurityUtils.getSecuritySpecification(secId);
        String engine = securitySpecification.getPrimaryEngine();
        String market = securitySpecification.getPrimaryMarket();
        return  "http://iss.moex.com/iss/engines/" + engine + "/markets/" + market + "/securities/" + secId + "/candles.json" +
                "?from=" + DateTimeUtils.calendarToDateTime(firstDateTime) + "&till=" +
                DateTimeUtils.calendarToDateTime(lastDateTime) + "&interval=" + intervalInMinutes;
    }

    public static String primaryBoardSecSpecificationRequest(String secId) {
        SecuritySpecification securitySpecification = SecurityUtils.getSecuritySpecification(secId);
        String engine = securitySpecification.getPrimaryEngine();
        String market = securitySpecification.getPrimaryMarket();
        String primaryBoard = securitySpecification.getPrimaryBoard();
        return  "http://iss.moex.com/iss/engines/" + engine + "/markets/" + market + "/boards/" + primaryBoard +
                "/securities/" + secId + ".json";

    }

    public static String dayHistoryRequest(String secId, Calendar firstDate, Calendar lastDate) {
        SecuritySpecification spec = SecurityUtils.getSecuritySpecification(secId);
        String engine = spec.getPrimaryEngine();
        String market = spec.getPrimaryMarket();
        String primaryBoard = spec.getPrimaryBoard();
        return  "http://iss.moex.com/iss/history/engines/" + engine + "/markets/" + market + "/boards/" + primaryBoard +
                "/securities/" + secId + "/candles" + ".json" + "?from=" + DateTimeUtils.calendarToDateWithDash(firstDate) +
                "&till=" + DateTimeUtils.calendarToDateWithDash(lastDate);
    }

    public static String getSecuritiesFullInfoGetRequest(Engines typeOfSec, int rowPosition, boolean isTrading) {
        int isTradingInt = 0;
        if (isTrading) {
            isTradingInt = 1;
        }
        String url = "http://iss.moex.com/iss/securities.json?group_by=type&group_by_filter=";
        return url + typeOfSec.getName() + "&start=" + rowPosition + "&is_trading=" + isTradingInt;
    }

    /**
     * Создает URL для запроса 100 кратких кодов фьючерсов начиная с определенной позиции
     * @param rowPosition Позиция, с которой необходимо производить запрос данных
     * @param isTrading Если true, то отбираются только торгующиеся фьючерсы, если false - то только неторгующиеся
     * @return URL для запроса 100 кратких кодов фьючерсов начиная с определенной позиции
     */
    public static String getFuturesRequest(int rowPosition, boolean isTrading) {
        int isTradingInt = 0;
        if (isTrading) {
            isTradingInt = 1;
        }
        String url = "http://iss.moex.com/iss/securities.json?group_by=type&group_by_filter=";
        return url + "futures" + "&start=" + rowPosition + "&is_trading=" + isTradingInt;
    }

    /**
     * Создает URL для запроса 100 кратких кодов фьючерсов начиная с определенной позиции
     * @param rowPosition Позиция, с которой необходимо производить запрос данных
     * @return URL для запроса 100 кратких кодов фьючерсов начиная с определенной позиции
     */
    public static String getFuturesRequest(int rowPosition) {
        String url = "http://iss.moex.com/iss/securities.json?group_by=type&group_by_filter=";
        return url + "futures" + "&start=" + rowPosition;
    }

    /**
     * Создает URL для запроса 100 кратких кодов акций начиная с определенной позиции
     * @param rowPosition Позиция, с которой необходимо производить запрос данных
     * @param isTrading Если true, то отбираются только торгующиеся акции, если false - то только неторгующиеся
     * @return URL для запроса 100 кратких кодов акций начиная с определенной позиции
     */
    public static String getStockRequest(int rowPosition, boolean isTrading) {
        int isTradingInt = 0;
        if (isTrading) {
            isTradingInt = 1;
        }
        String url = "http://iss.moex.com/iss/securities.json?group_by=type&group_by_filter=";
        return url + "common_share" + "&start=" + rowPosition + "&is_trading=" + isTradingInt;
    }

    /**
     * Создает URL для запроса 100 кратких кодов акций начиная с определенной позиции
     * @param rowPosition Позиция, с которой необходимо производить запрос данных
     * @return URL для запроса 100 кратких кодов акций начиная с определенной позиции
     */
    public static String getStockRequest(int rowPosition) {
        String url = "http://iss.moex.com/iss/securities.json?group_by=type&group_by_filter=";
        return url + "common_share" + "&start=" + rowPosition;
    }







}
