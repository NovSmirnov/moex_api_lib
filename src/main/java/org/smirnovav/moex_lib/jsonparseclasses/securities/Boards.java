package org.smirnovav.moex_lib.jsonparseclasses.securities;

import java.util.List;

public class Boards {

    private List<String> columns;
    private List<List<String>> data;

    public Boards(List<String> columns, List<List<String>> data) {
        this.columns = columns;
        this.data = data;
    }

    public List<String> getColumns() {
        return columns;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}
