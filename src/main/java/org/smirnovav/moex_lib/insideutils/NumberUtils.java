package org.smirnovav.moex_lib.insideutils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {
    private NumberUtils() {
    }

    public static String getRoundingStringNumber(double number, int decimals) {
        BigDecimal bdNumber = new BigDecimal(number);
        BigDecimal roundingBdNumber = bdNumber.setScale(decimals, RoundingMode.HALF_UP);
        if (decimals == 0) {
            return roundingBdNumber.toString();
        } else {
            return roundingBdNumber.stripTrailingZeros().toString();
        }
    }

//    public static String exceptNull(String strNumber) {
//        if (strNumber.isEmpty()) {
//            return "0";
//        } else {
//            return strNumber;
//        }
//    }
}
