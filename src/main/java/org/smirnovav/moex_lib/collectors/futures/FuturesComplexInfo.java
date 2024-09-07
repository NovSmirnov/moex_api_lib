package org.smirnovav.moex_lib.collectors.futures;

public class FuturesComplexInfo {
    private FuturesBoardSpecification specification;
    private FuturesMarketData marketData;

    public FuturesComplexInfo(FuturesBoardSpecification specification, FuturesMarketData marketData) {
        this.specification = specification;
        this.marketData = marketData;
    }

    public FuturesBoardSpecification getSpecification() {
        return specification;
    }

    public FuturesMarketData getMarketData() {
        return marketData;
    }
}
