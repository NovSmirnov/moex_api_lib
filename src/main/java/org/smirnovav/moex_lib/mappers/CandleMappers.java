package org.smirnovav.moex_lib.mappers;

import org.smirnovav.moex_lib.collectors.Candle;
import org.smirnovav.moex_lib.collectors.MoexCandle;
import org.smirnovav.moex_lib.collectors.Quote;
import org.smirnovav.moex_lib.insideutils.DateTimeUtils;
import org.smirnovav.moex_lib.jsonparseclasses.candles.Candles;

import java.util.ArrayList;
import java.util.List;

public class CandleMappers {

    private CandleMappers() {
    }

    public static Quote candlesListToQuote(List<Candle> candleList, int decimals) {
        String[] ticker = new String[candleList.size()];
        int[] timeframe = new int[candleList.size()];
        int[] date = new int[candleList.size()];
        String[] time = new String[candleList.size()];
        double[] open = new double[candleList.size()];
        double[] high = new double[candleList.size()];
        double[] low = new double[candleList.size()];
        double[] close = new double[candleList.size()];
        long[] volume = new long[candleList.size()];
        for (int i = 0; i < candleList.size(); i++) {
            ticker[i] = candleList.get(i).getTicker();
            timeframe[i] = candleList.get(i).getTimeframe();
            date[i] = Integer.parseInt(DateTimeUtils.calendarToDate(candleList.get(i).getDateTime()));
            time[i] = DateTimeUtils.calendarToTime(candleList.get(i).getDateTime());
            open[i] = candleList.get(i).getOpen();
            high[i] = candleList.get(i).getHigh();
            low[i] = candleList.get(i).getLow();
            close[i] = candleList.get(i).getClose();
            volume[i] = candleList.get(i).getVolume();
        }
        return new Quote(ticker, timeframe, date, time, open, high, low, close, volume, decimals);
    }

    public static List<MoexCandle> candlesToMoexCandles(Candles candles) {
        List<MoexCandle> moexCandles = new ArrayList<>();
        for (List<String> candle : candles.getCandles().getData()) {
            moexCandles.add(stringListToMoexCandle(candle));
        }
        return moexCandles;
    }

    public static MoexCandle stringListToMoexCandle(List<String> candleStringList) {
        double open = Double.parseDouble(candleStringList.get(0));
        double close = Double.parseDouble(candleStringList.get(1));
        double high = Double.parseDouble(candleStringList.get(2));
        double low = Double.parseDouble(candleStringList.get(3));
        double value = Double.parseDouble(candleStringList.get(4));
        long volume = Long.parseLong(candleStringList.get(5));
        String begin = candleStringList.get(6);
        String end = candleStringList.get(7);
        return new MoexCandle(open, close, high, low, value, volume, begin, end);
    }

    public static Candle MoexCandleToCandle(MoexCandle moexCandle, String shortName, int interval) {
        return new Candle(shortName, interval, DateTimeUtils.stringDateTimeWithDashesToCalendar(moexCandle.getBegin()),
                moexCandle.getOpen(), moexCandle.getHigh(), moexCandle.getLow(), moexCandle.getClose(), moexCandle.getVolume());
    }



}
