package org.smirnovav.moex_lib.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.smirnovav.moex_lib.collectors.Candle;
import org.smirnovav.moex_lib.collectors.Quote;
import org.smirnovav.moex_lib.collectors.SecuritySpecification;
import org.smirnovav.moex_lib.collectors.futures.FuturesBoardSpecification;
import org.smirnovav.moex_lib.collectors.futures.FuturesComplexInfo;
import org.smirnovav.moex_lib.collectors.futures.FuturesDayHistoryInfo;
import org.smirnovav.moex_lib.collectors.futures.FuturesMarketData;
import org.smirnovav.moex_lib.collectors.stock.StockBoardSpecification;
import org.smirnovav.moex_lib.collectors.stock.StockComplexInfo;
import org.smirnovav.moex_lib.collectors.stock.StockDayHistoryInfo;
import org.smirnovav.moex_lib.collectors.stock.StockMarketData;
import org.smirnovav.moex_lib.comparators.futureshictorycomparators.DateFuturesHistoryComparator;
import org.smirnovav.moex_lib.comparators.stockhictorycomparators.DateStockHistoryComparator;
import org.smirnovav.moex_lib.insideutils.HistoryUtils;
import org.smirnovav.moex_lib.insideutils.RequestBuilders;
import org.smirnovav.moex_lib.jsonparseclasses.history.MoexHistory;
import org.smirnovav.moex_lib.jsonparseclasses.securities.Description;
import org.smirnovav.moex_lib.jsonparseclasses.securities.SecuritiesData;
import org.smirnovav.moex_lib.mappers.CandleMappers;
import org.smirnovav.moex_lib.mappers.HistoryMappers;
import org.smirnovav.moex_lib.mappers.SecuritySpecificationMappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class SecurityUtils {
    private SecurityUtils() {
    }

    /**
     * Возвращает спецификацию ценной бумаги (объект класса SecuritySpecification)
     * @param secId Краткий код инструмента (вида GZU4)
     * @return Спецификацию ценной бумаги (объект класса SecuritySpecification)
     */
    public static SecuritySpecification getSecuritySpecification(String secId) {
        String forUrl = "http://iss.moex.com/iss/securities/" + secId +".json";
        SecuritySpecification securitySpecification = null;
        try {
            URL url = new URL(forUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String json = reader.lines().collect(Collectors.joining());
            connection.disconnect();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = new TypeToken<Description>(){}.getType();
            Description description = gson.fromJson(json, type);
            securitySpecification = SecuritySpecificationMappers.descriptionToSequritySpecification(description);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return securitySpecification;
    }

    /**
     * Возвращает котировку указанного инструмента (акции или фьючерса) за указанный временной период со свечами нужного интервала
     * @param secId Краткий код инструмента (вида GZU4)
     * @param firstDateTime Дата и время (до минуты) начала первой свечи, с которой скачивается котировка
     * @param lastDateTime Дата и время (до минуты) начала последней свечи, до которой скачивается котировка, эта свеча не включается в котировку
     * @param interval Интервал (период, таймфрейм) в минутах
     * @return Котировку указанного инструмента (акции или фьючерса) за указанный временной период со свечами нужного интервала
     */
    public static Quote getQuote(String secId, Calendar firstDateTime, Calendar lastDateTime, int interval) {
        SecuritySpecification specification = getSecuritySpecification(secId);
        List<Candle> candleList = HistoryUtils.getCandles(specification, firstDateTime, lastDateTime, interval);
        return CandleMappers.candlesListToQuote(candleList, specification.getPrimaryDecimals());
    }

    /**
     * Возвращает информацию о фьючерсе, состоящую из спецификации и текущих рыночных данных
     * @param secId Краткий код инструмента
     * @return Информацию о фьючерсе, состоящую из спецификации и текущих рыночных данных
     */
    public static FuturesComplexInfo getFuturesComplexInfo(String secId) {
        String forUrl = RequestBuilders.primaryBoardSecSpecificationRequest(secId);
        String[] separatedUrl = forUrl.split("/");
        if (!separatedUrl[5].equals("futures")) {
            throw new IllegalArgumentException("Инструмент не является фьючерсом");
        }
        try {
            URL url = new URL(forUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String json = reader.lines().collect(Collectors.joining());
            connection.disconnect();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = new TypeToken<SecuritiesData>(){}.getType();
            SecuritiesData data = gson.fromJson(json, type);
            FuturesMarketData marketData = SecuritySpecificationMappers.marketDataRawToFuturesMarketData(data.getMarketdata());
            FuturesBoardSpecification specification = SecuritySpecificationMappers.securitiesRawToFuturesBoardSpec(data.getSecurities());
            return new FuturesComplexInfo(specification, marketData);
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "Невозможно получить данные о искомом фьючерсе, проверьте подключение" +
                    " или правильность написания идентификатора");
            e.printStackTrace();
        }
        System.out.println("\u001B[31m" + "Возвращены нулевые значения");

        return new FuturesComplexInfo(null, null);
    }

    /**
     * Возвращает информацию об акции, состоящую из спецификации и текущих рыночных данных
     * @param secId Краткий код инструмента
     * @return Информацию об акции, состоящую из спецификации и текущих рыночных данных
     */
    public static StockComplexInfo getStockComplexInfo(String secId) {
        String forUrl = RequestBuilders.primaryBoardSecSpecificationRequest(secId);
        String[] separatedUrl = forUrl.split("/");
        if (!separatedUrl[5].equals("stock")) {
            throw new IllegalArgumentException("Инструмент не является акцией");
        }
        try {
            URL url = new URL(forUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String json = reader.lines().collect(Collectors.joining());
            connection.disconnect();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = new TypeToken<SecuritiesData>(){}.getType();
            SecuritiesData data = gson.fromJson(json, type);
            StockMarketData marketData = SecuritySpecificationMappers.marketDataRawToStockMarketData(data.getMarketdata());
            StockBoardSpecification specification = SecuritySpecificationMappers.securitiesRawToStockBoardSpec(data.getSecurities());
            return new StockComplexInfo(specification, marketData);
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "Невозможно получить данные о искомом фьючерсе, проверьте подключение" +
                    " или правильность написания идентификатора");
            e.printStackTrace();
        }
        System.out.println("\u001B[31m" + "Возвращены нулевые значения");

        return new StockComplexInfo(null, null);
    }

    /**
     * Возвращает список объектов содержащих исторические данные по инструменту за определенную дату отсортированный в хронологическом порядке список
     * Инструментом являются фьючерсы
     * @param secID Краткий код инструмента
     * @param firstDate Певая дата диапазона дат
     * @param lastDate Последняя дата диапазона дат
     * @return Список объектов содержащих исторические данные по инструменту за определенную дату отсортированный в хронологическом порядке список
     */
    public static List<FuturesDayHistoryInfo> getFuturesDailyHistory(String secID, Calendar firstDate, Calendar lastDate) {
        if (lastDate.compareTo(firstDate) >= 0) {
            MoexHistory moexHistory = HistoryUtils.getRawHistory(secID, firstDate, lastDate);
            List<FuturesDayHistoryInfo> futuresDayHistoryInfoList = new ArrayList<>();
            assert moexHistory != null;
            for (List<String> candle : moexHistory.getHistory().getData()) {
                FuturesDayHistoryInfo info = HistoryMappers.dayDataToFuturesDayHistory(candle);
                futuresDayHistoryInfoList.add(info);
            }
            futuresDayHistoryInfoList.sort(new DateFuturesHistoryComparator());
            return futuresDayHistoryInfoList;
        } else {
            System.out.println("Неправильная хронология дат");
            return null;
        }
    }

    /**
     * Возвращает список объектов содержащих исторические данные по инструменту за определенную дату отсортированный в хронологическом порядке список
     * Инструментом являются акции
     * @param secID Краткий код инструмента
     * @param firstDate Певая дата диапазона дат
     * @param lastDate Последняя дата диапазона дат
     * @return Список объектов содержащих исторические данные по инструменту за определенную дату отсортированный в хронологическом порядке список
     */
    public static List<StockDayHistoryInfo> getStockDailyHistory(String secID, Calendar firstDate, Calendar lastDate) {
        if (lastDate.compareTo(firstDate) >= 0) {
            MoexHistory moexHistory = HistoryUtils.getRawHistory(secID, firstDate, lastDate);
            List<StockDayHistoryInfo> stockDayHistoryInfoList = new ArrayList<>();
            assert moexHistory != null;
            for (List<String> candle : moexHistory.getHistory().getData()) {
                StockDayHistoryInfo info = HistoryMappers.dayDataToStockDayHistory(candle);
                stockDayHistoryInfoList.add(info);
            }
            stockDayHistoryInfoList.sort(new DateStockHistoryComparator());
            return stockDayHistoryInfoList;
        } else {
            System.out.println("Неправильная хронология дат");
            return null;
        }
    }

    /**
     * Возвращает множество коротких кодов фьючерсов торгуемых на Московской бирже в данный момент
     * @return Множество строк коротких кодов фьючерсов торгуемых на Московской бирже в данный момент
     */
    public static Set<String> getAllTradingFutures() {
        Set<String> tickerSet = new HashSet<>();
        try {
            for (int i = 0; i < 15000; i+=100) {
                String forUrl = RequestBuilders.getFuturesRequest(i, true);
                URL url = new URL(forUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String json = reader.lines().collect(Collectors.joining());
                connection.disconnect();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Type type = new TypeToken<SecuritiesData>(){}.getType();
                SecuritiesData sec = gson.fromJson(json, type);
                List<List<String>> data = sec.getSecurities().getData();
                for (List<String> line : data) {
                    tickerSet.add(line.get(1));
                }
                System.out.print(i);
                System.out.print("\r");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickerSet;
    }

    /**
     * Возвращает множество коротких кодов акций торгуемых на Московской бирже в данный момент
     * @return Множество строк коротких кодов акций торгуемых на Московской бирже в данный момент
     */
    public static Set<String> getAllTradingStocks() {
        Set<String> tickerSet = new HashSet<>();
        try {
            for (int i = 0; i < 15000; i+=100) {
                String forUrl = RequestBuilders.getStockRequest(i, true);
                URL url = new URL(forUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String json = reader.lines().collect(Collectors.joining());
                connection.disconnect();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Type type = new TypeToken<SecuritiesData>(){}.getType();
                SecuritiesData sec = gson.fromJson(json, type);
                List<List<String>> data = sec.getSecurities().getData();
                for (List<String> line : data) {
                    tickerSet.add(line.get(1));
                }
                System.out.print(i);
                System.out.print("\r");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickerSet;
    }


}
