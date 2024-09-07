package org.smirnovav.moex_lib.enums;

public enum MonthSymbol {
    JANUARY("F", "01", 1),
    FEBRUARY("G", "02", 2),
    MARCH("H", "03", 3),
    APRIL("J", "04", 4),
    MAY("K", "05", 5),
    JUNE("M", "06", 6),
    JULY("N", "07", 7),
    AUGUST("Q", "08", 8),
    SEPTEMBER("U", "09", 9),
    OCTOBER("V", "10", 10),
    NOVEMBER("X", "11", 11),
    DECEMBER("Z", "12", 12);

    private String monthSymbol;
    private String monthStringNumber;
    private int monthIntNumber;

    MonthSymbol(String monthSymbol, String monthNumber, int monthIntNumber) {
        this.monthSymbol = monthSymbol;
        this.monthStringNumber = monthNumber;
        this.monthIntNumber = monthIntNumber;
    }

    public static String getMonthSymb(int monthNumber) {
        switch (monthNumber) {
            case 1, 13:
                return JANUARY.getMonthSymbol();
            case 2, 14:
                return FEBRUARY.getMonthSymbol();
            case 3, 15:
                return MARCH.getMonthSymbol();
            case 4:
                return APRIL.getMonthSymbol();
            case 5:
                return MAY.getMonthSymbol();
            case 6:
                return JUNE.getMonthSymbol();
            case 7:
                return JULY.getMonthSymbol();
            case 8:
                return AUGUST.getMonthSymbol();
            case 9:
                return SEPTEMBER.getMonthSymbol();
            case 10:
                return OCTOBER.getMonthSymbol();
            case 11:
                return NOVEMBER.getMonthSymbol();
            case 12:
                return DECEMBER.getMonthSymbol();
            default:
                return null;
        }
    }

    public String getMonthSymbol() {
        return monthSymbol;
    }

    public String getMonthStringNumber() {
        return monthStringNumber;
    }

    public int getMonthIntNumber() {
        return monthIntNumber;
    }
}
