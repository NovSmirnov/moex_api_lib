package org.smirnovav.moex_lib.collectors;

import java.util.Calendar;

public class MoexCandle {
    private double open;
    private double close;
    private double high;
    private double low;
    private double value;
    private long volume;
    private String begin;
    private String end;

    public MoexCandle(double open, double close, double high, double low, double value, long volume, String begin, String end) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.value = value;
        this.volume = volume;
        this.begin = begin;
        this.end = end;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return open + "," + high + "," + low + "," + close + "," + value + "," + volume + "," + begin + "," + end;
    }
}
