package org.smirnovav.moex_lib.jsonparseclasses.candles;

public class Candles {

    private CandlesData candles;

    public Candles(CandlesData candles) {
        this.candles = candles;
    }

    public CandlesData getCandles() {
        return candles;
    }

    public void setCandles(CandlesData candles) {
        this.candles = candles;
    }
}
