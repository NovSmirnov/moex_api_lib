package org.smirnovav.moex_lib.enums;

public enum Engines {
    STOCK(1, "stock", "Фондовый рынок и рынок депозитов"),
//    STATE(2, "state", "Рынок ГЦБ (размещение)"),
//    CURRENCY(3, "currency", "Валютный рынок"),
    FUTURES(4, "futures", "Срочный рынок"),
//    COMMODITY(5, "commodity", "Товарный рынок"),
//    INTERVENTIONS(6, "interventions", "Товарные интервенции"),
//    OFFBOARD(7, "offboard", "ОТС-система"),
//    AGRO(9, "agro", "Агро"),
//    OTC(1012, "otc", "ОТС с ЦК"),
//    QUOTES(1282, "quotes", "Квоты"),
//    MONEY(1326, "money", "Денежный рынок")
    ;
    private final int id;
    private final String name;
    private final String title;

    Engines(int id, String name, String title) {
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
