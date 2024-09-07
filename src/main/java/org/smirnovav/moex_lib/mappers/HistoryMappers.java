package org.smirnovav.moex_lib.mappers;

import org.smirnovav.moex_lib.collectors.futures.FuturesDayHistoryInfo;
import org.smirnovav.moex_lib.collectors.stock.StockDayHistoryInfo;
import org.smirnovav.moex_lib.insideutils.DateTimeUtils;

import java.util.List;

public class HistoryMappers {
    private HistoryMappers() {
    }

    public static FuturesDayHistoryInfo dayDataToFuturesDayHistory(List<String> dayData) {
        for (int i = 0; i < dayData.size(); i++) {
            if (dayData.get(i) == null) {
                dayData.set(i, "0");
            }
        }
        return new FuturesDayHistoryInfo(dayData.get(0), DateTimeUtils.dateWithDashToCalendar(dayData.get(1)),
                dayData.get(2), Double.parseDouble(dayData.get(3)), Double.parseDouble(dayData.get(4)),
                Double.parseDouble(dayData.get(5)), Double.parseDouble(dayData.get(6)), Double.parseDouble(dayData.get(7)),
                Double.parseDouble(dayData.get(8)), Long.parseLong(dayData.get(9)), Long.parseLong(dayData.get(10)),
                Double.parseDouble(dayData.get(11)), Double.parseDouble(dayData.get(12)), Double.parseDouble(dayData.get(13)),
                Double.parseDouble(dayData.get(14)), Double.parseDouble(dayData.get(15)), Double.parseDouble(dayData.get(16)),
                Double.parseDouble(dayData.get(17)));
    }

    public static StockDayHistoryInfo dayDataToStockDayHistory(List<String> dayData) {
        for (int i = 0; i < dayData.size(); i++) {
            if (dayData.get(i) == null) {
                dayData.set(i, "0");
            }
        }
        return new StockDayHistoryInfo(dayData.get(0), DateTimeUtils.dateWithDashToCalendar(dayData.get(1)),
                dayData.get(2), dayData.get(3), Double.parseDouble(dayData.get(6)),
                Double.parseDouble(dayData.get(7)), Double.parseDouble(dayData.get(8)), Double.parseDouble(dayData.get(11)),
                Double.parseDouble(dayData.get(9)), Double.parseDouble(dayData.get(5)), Long.parseLong(dayData.get(12)),
                Double.parseDouble(dayData.get(10)), Double.parseDouble(dayData.get(4)), Double.parseDouble(dayData.get(13)),
                Double.parseDouble(dayData.get(14)), Double.parseDouble(dayData.get(15)), Double.parseDouble(dayData.get(16)),
                Double.parseDouble(dayData.get(17)), Double.parseDouble(dayData.get(18)), Double.parseDouble(dayData.get(19)),
                Integer.parseInt(dayData.get(20)), dayData.get(21), Double.parseDouble(dayData.get(22)));
    }



}
