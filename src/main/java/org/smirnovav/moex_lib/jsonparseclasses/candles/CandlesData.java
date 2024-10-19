package org.smirnovav.moex_lib.jsonparseclasses.candles;

import java.util.List;

public class CandlesData {

    private List<List<String>> data;
    private List<String> columns;

    public CandlesData(List<String> columns, List<List<String>> data) {
        this.columns = columns;
        this.data = data;
    }

        public List<String> getColumns() {
        return columns;
    }

    public List<List<String>> getData() {
        return data;
    }
}
