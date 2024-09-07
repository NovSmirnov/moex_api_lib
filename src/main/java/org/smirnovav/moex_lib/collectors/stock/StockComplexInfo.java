package org.smirnovav.moex_lib.collectors.stock;

public class StockComplexInfo {
    private StockBoardSpecification specification;
    private StockMarketData marketData;

    public StockComplexInfo(StockBoardSpecification specification, StockMarketData marketData) {
        this.specification = specification;
        this.marketData = marketData;
    }

    public StockBoardSpecification getSpecification() {
        return specification;
    }

    public StockMarketData getMarketData() {
        return marketData;
    }
}
