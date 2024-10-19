package org.smirnovav.moex_lib.collectors;


public class Quote {

    /**
     * Массив с тикерами котировки.
     */
    private String[] ticker;

    /**
     * Массив с таймфреймом котировки.
     */
    private int[] timeframe;

    /**
     * Массив с датами котировки
     */
    private int[] date;

    /**
     * Массив со временем котировки
     */
    private String[] time;

    /**
     * Массив ценами открытия котировки.
     */
    private double[] open;

    /**
     * Массив с наибольшими значениями цены свеч котировки.
     */
    private double[] high;

    /**
     * Массив с наименьшими значениями цены свеч котировки.
     */
    private double[] low;

    /**
     * Массив с ценами закрытия свеч котировки.
     */
    private double[] close;

    /**
     * Массив с объёмами свеч котировки
     */
    private long[] volume;

    /**
     * Количество знаков после запятой в котировке
     */
    private int decimals;

    /**
     * Заголовок файла котировки для вывода
     */
    private static final String quoteHeader = "<TICKER>,<PER>,<DATE>,<TIME>,<OPEN>,<HIGH>,<LOW>,<CLOSE>,<VOL>";


    public Quote(String[] ticker, int[] timeframe, int[] date, String[] time, double[] open, double[] high, double[] low,
                 double[] close, long[] volume, int decimals) {
        this.ticker = ticker;
        this.timeframe = timeframe;
        this.date = date;
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.decimals = decimals;
    }

    public String[] getTicker() {
        return ticker;
    }

    public int[] getTimeframe() {
        return timeframe;
    }

    public int[] getDate() {
        return date;
    }

    public String[] getTime() {
        return time;
    }

    public double[] getOpen() {
        return open;
    }

    public double[] getHigh() {
        return high;
    }

    public double[] getLow() {
        return low;
    }

    public double[] getClose() {
        return close;
    }

    public long[] getVolume() {
        return volume;
    }

    public String getHeader() {
        return quoteHeader;
    }

    public int getDecimals() {
        return decimals;
    }
}
