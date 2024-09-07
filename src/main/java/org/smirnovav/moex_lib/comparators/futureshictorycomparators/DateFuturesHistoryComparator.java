package org.smirnovav.moex_lib.comparators.futureshictorycomparators;

import org.smirnovav.moex_lib.collectors.futures.FuturesDayHistoryInfo;

import java.util.Comparator;

public class DateFuturesHistoryComparator implements Comparator<FuturesDayHistoryInfo> {
    @Override
    public int compare(FuturesDayHistoryInfo candle1, FuturesDayHistoryInfo candle2) {
        return Long.compare(candle1.getTradeDate().getTimeInMillis(), candle2.getTradeDate().getTimeInMillis());
    }
}
