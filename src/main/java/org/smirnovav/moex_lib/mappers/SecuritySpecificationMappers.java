package org.smirnovav.moex_lib.mappers;

import org.smirnovav.moex_lib.collectors.SecuritySpecification;
import org.smirnovav.moex_lib.collectors.futures.FuturesBoardSpecification;
import org.smirnovav.moex_lib.collectors.futures.FuturesMarketData;
import org.smirnovav.moex_lib.collectors.stock.StockBoardSpecification;
import org.smirnovav.moex_lib.collectors.stock.StockMarketData;
import org.smirnovav.moex_lib.insideutils.DateTimeUtils;
import org.smirnovav.moex_lib.jsonparseclasses.securities.Description;
import org.smirnovav.moex_lib.jsonparseclasses.securities.MarketDataRaw;
import org.smirnovav.moex_lib.jsonparseclasses.securities.SecuritiesRaw;

import java.util.List;

public class SecuritySpecificationMappers {
    private SecuritySpecificationMappers() {
    }

//    public static SecuritySpecification descriptionToSequritySpecification(Description description) {
//        List<List<String>> data = description.getDescriptionData().getData();
//        System.out.println(data);
//        SecuritySpecification specification = new SecuritySpecification(null, data.get(0).get(2),
//                data.get(1).get(2), data.get(2).get(2), data.get(3).get(2), data.get(4).get(2),
//                DateTimeUtils.stringDateWithDashesToCalendar(data.get(5).get(2)),
//                DateTimeUtils.stringDateWithDashesToCalendar(data.get(6).get(2)),
//                DateTimeUtils.stringDateWithDashesToCalendar(data.get(7).get(2)), data.get(8).get(2),
//                data.get(9).get(2), Integer.parseInt(data.get(10).get(2)), data.get(11).get(2),
//                data.get(12).get(2), data.get(13).get(2), data.get(14).get(2), data.get(15).get(2), data.get(16).get(2),
//                data.get(17).get(2), data.get(18).get(2), Integer.parseInt(data.get(19).get(2)));
//        specification.setSecurityBoards(description.getBoards().getData());
//        return specification;
//    }
    public static SecuritySpecification descriptionToSequritySpecification(Description description) {
        SecuritySpecification specification = new SecuritySpecification();
        for (List<String> list : description.getDescriptionData().getData()) {
            switch (list.get(0)) {
                case "SECID" :
                    specification.setSecId(list.get(2));
                    break;
                case "NAME" :
                    specification.setName(list.get(2));
                    break;
                case "SHORTNAME" :
                    specification.setShortName(list.get(2));
                    break;
                case "ISIN" :
                    specification.setIsin(list.get(2));
                    break;
                case "REGNUMBER" :
                    specification.setRegnumber(list.get(2));
                    break;
                case "ISSUESIZE" :
                    specification.setIssueSize(Long.parseLong(list.get(2)));
                    break;
                case "FACEVALUE" :
                    specification.setFaceValue(Integer.parseInt(list.get(2)));
                    break;
                case "FACEUNIT" :
                    specification.setFaceUnit(list.get(2));
                    break;
                case "ISSUEDATE" :
                    specification.setIssueDate(DateTimeUtils.stringDateTimeWithDashesToCalendar(list.get(2)));
                    break;
                case "LATNAME" :
                    specification.setLatName(list.get(2));
                    break;
                case "LISTLEVEL" :
                    specification.setListLevel(Integer.parseInt(list.get(2)));
                    break;
                case "ISQUALIFIEDINVESTORS" :
                    specification.setQualifiedInvestors(list.get(2).equals("1"));
                    break;
                case "MORNINGSESSION" :
                    specification.setMorningSession(list.get(2).equals("1"));
                    break;
                case "EVENINGSESSION" :
                    specification.setEveningSession(list.get(2).equals("1"));
                    break;
                case "DELIVERYTYPE" :
                    specification.setDeliveryType(list.get(2));
                    break;
                case "FRSTTRADE" :
                    specification.setFirstTrade(DateTimeUtils.stringDateTimeWithDashesToCalendar(list.get(2)));
                    break;
                case "LSTTRADE" :
                    specification.setLastTrade(DateTimeUtils.stringDateTimeWithDashesToCalendar(list.get(2)));
                    break;
                case "LSTDELDATE" :
                    specification.setLastDeleteDate(DateTimeUtils.stringDateTimeWithDashesToCalendar(list.get(2)));
                    break;
                case "ASSETCODE" :
                    specification.setAssetCode(list.get(2));
                    break;
                case "EXECTYPE" :
                    specification.setExecType(list.get(2));
                    break;
                case "LOTSIZE" :
                    specification.setLotSize(Integer.parseInt(list.get(2)));
                    break;
                case "CONTRACTNAME" :
                    specification.setContractName(list.get(2));
                    break;
                case "GROUPTYPE" :
                    specification.setGroupType(list.get(2));
                    break;
                case "UNIT" :
                    specification.setUnit(list.get(2));
                    break;
                case "EXPIRATIONCLRSESS" :
                    specification.setExpirationClrSess(list.get(2));
                    break;
                case "TYPENAME" :
                    specification.setTypeName(list.get(2));
                    break;
                case "GROUP" :
                    specification.setGroup(list.get(2));
                    break;
                case "TYPE" :
                    specification.setType(list.get(2));
                    break;
                case "GROUPNAME" :
                    specification.setGroupName(list.get(2));
                    break;
                case "EMITTER_ID" :
                    specification.setEmitterId(Integer.parseInt(list.get(2)));
                    break;
            }
        }
        specification.setSecurityBoards(description.getBoards().getData());
        return specification;
    }

    public static FuturesBoardSpecification securitiesRawToFuturesBoardSpec(SecuritiesRaw securitiesRaw) {
        List<String> data = securitiesRaw.getData().get(0);
        return new FuturesBoardSpecification(
                data.get(0), data.get(1), data.get(2), data.get(3), Integer.parseInt(data.get(5)),
                Double.parseDouble(data.get(6)), data.get(10), data.get(9), Double.parseDouble(data.get(19)),
                Double.parseDouble(data.get(4)), DateTimeUtils.dateWithDashToCalendar(data.get(7)),
                DateTimeUtils.dateWithDashToCalendar(data.get(8)), data.get(11), Integer.parseInt(data.get(12)),
                Integer.parseInt(data.get(13)), Double.parseDouble(data.get(14)), Double.parseDouble(data.get(15)),
                Double.parseDouble(data.get(16)), Double.parseDouble(data.get(17)), Double.parseDouble(data.get(18)),
                DateTimeUtils.stringDateTimeWithDashesToCalendar(data.get(20)), Double.parseDouble(data.get(21)), Double.parseDouble(data.get(22)),
                Double.parseDouble(data.get(23)), Double.parseDouble(data.get(24))
                );

    }
    public static StockBoardSpecification securitiesRawToStockBoardSpec(SecuritiesRaw securitiesRaw) {
        List<String> data = securitiesRaw.getData().get(0);
        return new StockBoardSpecification(
                data.get(0), data.get(1), data.get(2), data.get(9), Integer.parseInt(data.get(8)),
                Double.parseDouble(data.get(14)), data.get(20), data.get(24), Double.parseDouble(data.get(3)),
                Integer.parseInt(data.get(4)), Integer.parseInt(data.get(5)),
                data.get(6), data.get(7), data.get(10),
                data.get(11), data.get(12), data.get(13),
                Double.parseDouble(data.get(15)), data.get(16), DateTimeUtils.dateWithDashToCalendar(data.get(17)),
                Long.parseLong(data.get(18)), data.get(19), data.get(21),
                Double.parseDouble(data.get(22)), data.get(23), Integer.parseInt(data.get(25)), DateTimeUtils.dateWithDashToCalendar(data.get(26))
                );
    }

    public static FuturesMarketData marketDataRawToFuturesMarketData(MarketDataRaw marketDataRaw) {
        List<String> data = marketDataRaw.getData().get(0);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == null) {
                data.set(i, "0");
            }
        }
        return new FuturesMarketData(data.get(0), data.get(1), Double.parseDouble(data.get(2)), Double.parseDouble(data.get(3)),
                Double.parseDouble(data.get(23)), Double.parseDouble(data.get(24)), Double.parseDouble(data.get(4)),
                Double.parseDouble(data.get(5)), Double.parseDouble(data.get(6)), Double.parseDouble(data.get(7)),
                Double.parseDouble(data.get(8)), Double.parseDouble(data.get(10)), Integer.parseInt(data.get(14)),
                Integer.parseInt(data.get(15)), Double.parseDouble(data.get(16)), Double.parseDouble(data.get(17)),
                Double.parseDouble(data.get(19)), Integer.parseInt(data.get(20)), Integer.parseInt(data.get(21)),
                Integer.parseInt(data.get(25)), Integer.parseInt(data.get(22)), DateTimeUtils.stringTimeToCalendar(data.get(26)),
                data.get(28), DateTimeUtils.stringDateTimeWithDashesToCalendar(data.get(29)), DateTimeUtils.stringTimeToCalendar(data.get(18)),
                Double.parseDouble(data.get(33)), Double.parseDouble(data.get(31)), Integer.parseInt(data.get(9)),
                Double.parseDouble(data.get(11)), Double.parseDouble(data.get(12)), Integer.parseInt(data.get(13)),
                Double.parseDouble(data.get(27)), DateTimeUtils.dateWithDashToCalendar(data.get(30)),
                Double.parseDouble(data.get(32)), Double.parseDouble(data.get(34)));

    }

    public static StockMarketData marketDataRawToStockMarketData(MarketDataRaw marketDataRaw) {
        List<String> data = marketDataRaw.getData().get(0);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == null) {
                data.set(i, "0");
            }
        }
        return new StockMarketData(data.get(0), data.get(1), Double.parseDouble(data.get(2)), Double.parseDouble(data.get(4)),
                Double.parseDouble(data.get(5)), Double.parseDouble(data.get(8)), Double.parseDouble(data.get(6)),
                Double.parseDouble(data.get(9)), Double.parseDouble(data.get(10)), Double.parseDouble(data.get(11)),
                Double.parseDouble(data.get(12)), Double.parseDouble(data.get(13)), Integer.parseInt(data.get(26)),
                Integer.parseInt(data.get(27)), Double.parseDouble(data.get(28)), Double.parseDouble(data.get(29)),
                Double.parseDouble(data.get(14)), Integer.parseInt(data.get(3)), Integer.parseInt(data.get(7)),
                Integer.parseInt(data.get(39)), Integer.parseInt(data.get(38)), DateTimeUtils.stringTimeToCalendar(data.get(41)),
                data.get(46), DateTimeUtils.stringDateTimeWithDashesToCalendar(data.get(47)), DateTimeUtils.stringTimeToCalendar(data.get(32)),
                Double.parseDouble(data.get(45)), Double.parseDouble(data.get(25)), Integer.parseInt(data.get(15)),
                Double.parseDouble(data.get(16)), Double.parseDouble(data.get(17)), Double.parseDouble(data.get(18)),
                Double.parseDouble(data.get(19)), Double.parseDouble(data.get(20)), Double.parseDouble(data.get(21)),
                Double.parseDouble(data.get(22)), Double.parseDouble(data.get(23)), Double.parseDouble(data.get(24)),
                Double.parseDouble(data.get(30)), data.get(31), Double.parseDouble(data.get(33)), Double.parseDouble(data.get(34)),
                Double.parseDouble(data.get(35)), Double.parseDouble(data.get(36)), Double.parseDouble(data.get(37)),
                Double.parseDouble(data.get(40)), Double.parseDouble(data.get(42)), Double.parseDouble(data.get(43)),
                Double.parseDouble(data.get(44)), Double.parseDouble(data.get(48)), Integer.parseInt(data.get(49)),
                Long.parseLong(data.get(50)), DateTimeUtils.stringTimeToCalendar(data.get(51)), data.get(52), Long.parseLong(data.get(53)),
                data.get(54), Long.parseLong(data.get(55)));

    }

}
