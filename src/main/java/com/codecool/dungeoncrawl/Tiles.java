package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static { //1st: col 2nd: row
        tileMap.put("empty1", new Tile(0, 0));
        tileMap.put("empty2", new Tile(0, 0));
        tileMap.put("wall1", new Tile(10, 17));
        tileMap.put("wall2", new Tile(6, 2));
        tileMap.put("floor1", new Tile(2, 0));
        tileMap.put("floor2", new Tile(5, 0));
        tileMap.put("decor1", new Tile(3, 15));
        tileMap.put("decor2", new Tile(14, 10));
        tileMap.put("column1", new Tile(12, 17));
        tileMap.put("column2", new Tile(1, 1));
        tileMap.put("exit1", new Tile(2, 6));
        tileMap.put("exit2", new Tile(2, 6));
        tileMap.put("player", new Tile(27, 0));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("goliath", new Tile(30, 6));
        tileMap.put("sword", new Tile(3, 29));
        tileMap.put("key", new Tile(16, 23));
        tileMap.put("bread", new Tile(15, 28));
        tileMap.put("grave1", new Tile(0, 15));
        tileMap.put("grave2", new Tile(1, 14));
        tileMap.put("closedDoor1", new Tile(11, 11));
        tileMap.put("closedDoor2", new Tile(11, 11));
        tileMap.put("openDoor1", new Tile(12, 11));
        tileMap.put("openDoor2", new Tile(12, 11));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y, int canvasX, int canvasY) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                canvasX * TILE_WIDTH, canvasY * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
