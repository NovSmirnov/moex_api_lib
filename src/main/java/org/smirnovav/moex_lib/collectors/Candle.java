package org.smirnovav.moex_lib.collectors;


import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Предназначен для хранения свечи (бара) котировки
 */
public class Candle {
    private final String ticker;
    private final int timeframe;
    private final Calendar dateTime;
    private final double open;
    private final double high;
    private final double low;
    private final double close;
    private final long volume;

    public Candle(String ticker, int timeframe, Calendar dateTime, double open, double high, double low,
                  double close, long volume) {
        this.ticker = ticker;
        this.timeframe = timeframe;
        this.dateTime = dateTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public String getTicker() {
        return ticker;
    }

    public int getTimeframe() {
        return timeframe;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public long getVolume() {
        return volume;
    }

}
