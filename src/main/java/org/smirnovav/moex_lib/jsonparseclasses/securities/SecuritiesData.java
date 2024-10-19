package org.smirnovav.moex_lib.jsonparseclasses.securities;



public class SecuritiesData {
    private SecuritiesRaw securities;
    private MarketDataRaw marketdata;

    public SecuritiesData(SecuritiesRaw securities, MarketDataRaw marketdata) {
        this.securities = securities;
        this.marketdata = marketdata;
    }

    public SecuritiesRaw getSecurities() {
        return securities;
    }

    public void setSecurities(SecuritiesRaw securities) {
        this.securities = securities;
    }

    public MarketDataRaw getMarketdata() {
        return marketdata;
    }

    public void setMarketdata(MarketDataRaw marketdata) {
        this.marketdata = marketdata;
    }

    //    public List<Futures> getFutures() {
//        List<Futures> list = new ArrayList<>();
//        List<List<String>> data = securities.getData();
//        for (int i = 0; i < data.size(); i++) {
//            Futures entity = new Futures(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2), data.get(i).get(3),
//                    data.get(i).get(4), data.get(i).get(5), data.get(i).get(6), data.get(i).get(7), data.get(i).get(8),
//                    data.get(i).get(9), data.get(i).get(10), data.get(i).get(11), data.get(i).get(12), data.get(i).get(13),
//                    data.get(i).get(14), data.get(i).get(15), data.get(i).get(16), data.get(i).get(17), data.get(i).get(18),
//                    data.get(i).get(19), data.get(i).get(20), data.get(i).get(21), data.get(i).get(22), data.get(i).get(23),
//                    data.get(i).get(24));
//            list.add(entity);
//        }
//        return list;
//    }
//    public List<MarketData> getMarketDataEntitys() {
//        List<MarketData> list = new ArrayList<>();
//        List<List<String>> data = marketdata.getData();
//        for (int i = 0; i < data.size(); i++) {
//            MarketData entity = new MarketData(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2), data.get(i).get(3),
//                    data.get(i).get(4), data.get(i).get(5), data.get(i).get(6), data.get(i).get(7), data.get(i).get(8),
//                    data.get(i).get(9), data.get(i).get(10), data.get(i).get(11), data.get(i).get(12), data.get(i).get(13),
//                    data.get(i).get(14), data.get(i).get(15), data.get(i).get(16), data.get(i).get(17), data.get(i).get(18),
//                    data.get(i).get(19), data.get(i).get(20), data.get(i).get(21), data.get(i).get(22), data.get(i).get(23),
//                    data.get(i).get(24), data.get(i).get(25), data.get(i).get(26), data.get(i).get(27), data.get(i).get(28),
//                    data.get(i).get(29), data.get(i).get(30), data.get(i).get(31), data.get(i).get(32));
//            list.add(entity);
//        }
//        return list;
//    }

}
