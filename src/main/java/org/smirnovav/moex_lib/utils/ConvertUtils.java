package org.smirnovav.moex_lib.utils;

import org.smirnovav.moex_lib.collectors.Quote;
import org.smirnovav.moex_lib.collectors.futures.FuturesDayHistoryInfo;
import org.smirnovav.moex_lib.collectors.stock.StockDayHistoryInfo;
import org.smirnovav.moex_lib.insideutils.DateTimeUtils;

import java.util.List;

public class ConvertUtils {
    private ConvertUtils() {
    }

    /**
     * Конвертирует исторические данные по фьючерсу в котировку с дневным таймфреймом
     * @param futuresHistory Хронологически упорядоченный список дневных исторических данных по фьючерсу
     * @return Котировку инструмента с дневным таймфреймом
     */
    public static Quote getDayQuoteFromFuturesHistory(List<FuturesDayHistoryInfo> futuresHistory) {
        String[] ticker = new String[futuresHistory.size()];
        int[] timeframe = new int[futuresHistory.size()];
        int[] date = new int[futuresHistory.size()];
        String[] time = new String[futuresHistory.size()];
        double[] open = new double[futuresHistory.size()];
        double[] high = new double[futuresHistory.size()];
        double[] low = new double[futuresHistory.size()];
        double[] close = new double[futuresHistory.size()];
        long[] volume = new long[futuresHistory.size()];
        for (int i = 0; i < futuresHistory.size(); i++) {
            ticker[i] = futuresHistory.get(i).getSecId();
            timeframe[i] = 1440;
            date[i] = Integer.parseInt(DateTimeUtils.calendarToDate(futuresHistory.get(i).getTradeDate()));
            time[i] = "120000";
            open[i] = futuresHistory.get(i).getOpen();
            high[i] = futuresHistory.get(i).getHigh();
            low[i] = futuresHistory.get(i).getLow();
            close[i] = futuresHistory.get(i).getClose();
            volume[i] = futuresHistory.get(i).getVolume();
        }
        int decimals = SecurityUtils.getSecuritySpecification(ticker[0]).getPrimaryDecimals();
        return new Quote(ticker, timeframe, date, time, open, high, low, close, volume, decimals);
    }

    /**
     * Конвертирует исторические данные по акции в котировку с дневным таймфреймом
     * @param stockHistory Хронологически упорядоченный список дневных исторических данных по акции
     * @return Котировку инструмента с дневным таймфреймом
     */
    public static Quote getDayQuoteFromStockHistory(List<StockDayHistoryInfo> stockHistory) {
        String[] ticker = new String[stockHistory.size()];
        int[] timeframe = new int[stockHistory.size()];
        int[] date = new int[stockHistory.size()];
        String[] time = new String[stockHistory.size()];
        double[] open = new double[stockHistory.size()];
        double[] high = new double[stockHistory.size()];
        double[] low = new double[stockHistory.size()];
        double[] close = new double[stockHistory.size()];
        long[] volume = new long[stockHistory.size()];
        for (int i = 0; i < stockHistory.size(); i++) {
            ticker[i] = stockHistory.get(i).getSecId();
            timeframe[i] = 1440;
            date[i] = Integer.parseInt(DateTimeUtils.calendarToDate(stockHistory.get(i).getTradeDate()));
            time[i] = "120000";
            open[i] = stockHistory.get(i).getOpen();
            high[i] = stockHistory.get(i).getHigh();
            low[i] = stockHistory.get(i).getLow();
            close[i] = stockHistory.get(i).getClose();
            volume[i] = stockHistory.get(i).getVolume();
        }
        int decimals = SecurityUtils.getSecuritySpecification(ticker[0]).getPrimaryDecimals();
        return new Quote(ticker, timeframe, date, time, open, high, low, close, volume, decimals);
    }
}
