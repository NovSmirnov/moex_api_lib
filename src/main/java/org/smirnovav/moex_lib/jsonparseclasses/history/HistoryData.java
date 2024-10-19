package org.smirnovav.moex_lib.jsonparseclasses.history;


import java.util.List;

public class HistoryData {
    private List<List<String>> data;

    public HistoryData() {
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}
