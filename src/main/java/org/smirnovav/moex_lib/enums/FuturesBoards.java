package org.smirnovav.moex_lib.enums;

public enum FuturesBoards {
    RFUD(101, 45, "RFUD", "Фьючерсы", true);

    private final int id;
    private final int boardGroupId;
    private final String boardId;
    private final String title;
    private final boolean isTraded;

    FuturesBoards(int id, int boardGroupId, String boardId, String title, boolean isTraded) {
        this.id = id;
        this.boardGroupId = boardGroupId;
        this.boardId = boardId;
        this.title = title;
        this.isTraded = isTraded;
    }

    public int getId() {
        return id;
    }

    public int getBoardGroupId() {
        return boardGroupId;
    }

    public String getBoardId() {
        return boardId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isTraded() {
        return isTraded;
    }
}
