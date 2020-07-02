package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.util.RandomUtil;

public abstract class AIPatrol extends AI {

    private Integer direction = 0;
    private Integer step = 0;

    public AIPatrol(Cell cell) {
        super(cell);
    }

    @Override
    public void move(int dx, int dy) {
        Actor player = getPlayerNearby();
        if (player != null) {
            fight(player);
        } else {
            if (step == 2) {
                direction++;
                step = 0;
                if (direction == 4) {
                    direction = 0;
                }
            }
            Cell nextCell = getCell();
            switch (direction) {
                case 0:
                    nextCell = getCell().getNeighbor(0, 1);
                    break;
                case 1:
                    nextCell = getCell().getNeighbor(1, 0);
                    break;
                case 2:
                    nextCell = getCell().getNeighbor(0, -1);
                    break;
                case 3:
                    nextCell = getCell().getNeighbor(-1, 0);
                    break;
            }
            if (nextCell.canMoveThrough() && nextCell.getActor() == null) {
                getCell().setActor(null);
                nextCell.setActor(this);
                setCell(nextCell);
                step++;
            }
        }
    }

}