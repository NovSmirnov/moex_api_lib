package org.smirnovav.moex_lib.enums;

public enum SecurityTypes {

    CURRENCY_OTCINDICES(1347, "currency_otcindices", "Валютные внебиржевые индексы"),
    CURRENCY_INDEX(75, "currency_index", "Валютный фиксинг"),
    COMMON_SHARE(3, "common_share", "Акция обыкновенная"),
    PREFERRED_SHARE(1, "preferred_share", "Акция привилегированная"),
    DEPOSITARY_RECEIPT(51, "depositary_receipt", "Депозитарная расписка"),
    CURRENCY(5, "currency", "Валюта"),
    CURRENCY_BASKET(50, "currency_basket", "Бивалютная корзина"),
    FUTURES(6, "futures", "Фьючерс"),
    FUTURES_SPREAD(1337, "futures_spread", "Календарный спред"),
    FUTURES_COLLATERAL(1338, "futures_collateral", "Коллатеральный инструмент"),
    STATE_INDEX(46, "state_index", "Индекс ГЦБ"),
    COMMODITY_FUTURES(48, "commodity_futures", "Стандартный контракт АО НТБ"),
    OFZ_BOND(54, "ofz_bond", "Государственная облигация");


    private final int id;
    private final String name;
    private final String title;

    SecurityTypes(int id, String name, String title) {
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
