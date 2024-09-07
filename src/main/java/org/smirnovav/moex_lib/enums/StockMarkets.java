package org.smirnovav.moex_lib.enums;

public enum StockMarkets {
    INDEX(5, "index", "Индексы фондового рынка"),
    SHARES(1, "shares", "Рынок акций"),
    BONDS(2, "bonds", "Рынок облигаций"),
    NDM(4, "ndm", "Режим переговорных сделок"),
    OTC(29, "otc", "ОТС"),
    CCP(27, "ccp", "РЕПО с ЦК"),
    DEPOSIT(35, "deposit", "Депозиты с ЦК"),
    REPO(3, "repo", "Рынок сделок РЕПО"),
    QNV(28, "qnv", "Квал. инвесторы"),
    MAMC(36, "mamc", "Мультивалютный рынок смешанных активов"),
    FOREIGNSHARES(47, "foreignshares", "Иностранные ц.б."),
    FOREIGNNDM(49, "foreignndm", "Иностранные ц.б. РПС"),
    MOEXBOARD(33, "moexboard", "MOEX Board"),
    GCC(46, "gcc", "РЕПО с ЦК с КСУ"),
    CREDIT(54, "credit", "Рынок кредитов"),
    NONRESNDM(1015, "nonresndm", "Режим переговорных сделок (нерезиденты)"),
    NONRESREPO(1017, "nonresrepo", "Рынок РЕПО (нерезиденты)"),
    NONRESCCP(1019, "nonresccp", "Рынок РЕПО с ЦК (нерезиденты)"),
    STANDARD(23, "standard", "Standard"),
    CLASSICA(25, "classica", "Classica");


    private final int id;
    private final String name;
    private final String title;

    StockMarkets(int id, String name, String title) {
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
