package org.smirnovav.moex_lib.jsonparseclasses.securities;

public class Description {
    private DescriptionData description;
    private Boards boards;

    public Description(DescriptionData description, Boards boards) {
        this.description = description;
        this.boards = boards;
    }

    public DescriptionData getDescriptionData() {
        return description;
    }

    public Boards getBoards() {
        return boards;
    }
}
