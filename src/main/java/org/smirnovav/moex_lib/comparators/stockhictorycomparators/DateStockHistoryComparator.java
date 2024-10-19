package org.smirnovav.moex_lib.comparators.stockhictorycomparators;

import org.smirnovav.moex_lib.collectors.stock.StockDayHistoryInfo;

import java.util.Comparator;

public class DateStockHistoryComparator implements Comparator<StockDayHistoryInfo> {
    @Override
    public int compare(StockDayHistoryInfo candle1, StockDayHistoryInfo candle2) {
        return Long.compare(candle1.getTradeDate().getTimeInMillis(), candle2.getTradeDate().getTimeInMillis());
    }
}
