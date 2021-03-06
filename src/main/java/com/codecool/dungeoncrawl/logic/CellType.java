package com.codecool.dungeoncrawl.logic;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    COLUMN("column"),
    DECOR("decor"),
    EXIT("exit"),
    GRAVE("grave"),
    OPEN_DOOR("openDoor"),
    CLOSED_DOOR("closedDoor"),
    START_POINT("startPoint");

    private final String tileName;
    private int style;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName + getStyle();
    }

    public int getStyle() { return style; }

    public void setStyle(int style) { this.style = style; }
}
