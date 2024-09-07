package org.smirnovav.moex_lib.enums;

public enum FuturesMarkets {
    MAIN(12, "main", "Срочные инструменты"),
    FORTS(22, "forts", "ФОРТС"),
    OPTIONS(24, "options", "Опционы ФОРТС"),
    FORTSIQS(37, "fortsiqs", "Фьючерсы IQS"),
    OPTIONSIQS(38, "optionsiqs", "Опционы IQS");


    private final int id;
    private final String name;
    private final String title;


    FuturesMarkets(int id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}
