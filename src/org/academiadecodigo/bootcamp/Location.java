package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.gameobjects.Player;

public class Location {

    private Map map;
    private int cols;
    private int rows;

    public Location(Map map) {
        this.map = map;
        cols = (int) Math.round(map.getWidth() * Math.random());
        rows = (int) Math.round(map.getHeight() * Math.random());
    }

    public Location(int cols, int rows, Map map){
        this.cols = cols;
        this.rows = rows;
        this.map = map;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public void changeLocation(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void move(Direction direction, Player player){
        switch (direction){
            case UP:
                moveUp(player);
                break;
            case DOWN:
                moveDown(player);
                break;
            case LEFT:
                moveLeft(player);
                break;
            case RIGHT:
                moveRight(player);
                break;
        }
    }

    private void moveUp(Player player) {
        if (player.getLocation().getRows() - 1 > 0) {
            rows = player.getLocation().getRows() - 1;
            player.getImage().translate(0, map.cellsToPixel(-1));
        }
    }

    private void moveDown(Player player) {
        if (player.getLocation().getRows() + 1 < map.getHeight()) {
            rows = player.getLocation().getRows() + 1;
            player.getImage().translate(0, map.cellsToPixel(1));
        }
    }

    private void moveLeft(Player player) {
        if (player.getLocation().getCols() - 1 > 0) {
            cols = player.getLocation().getCols() - 1;
            player.getImage().translate(map.cellsToPixel(-1), 0);
        }
    }

    private void moveRight(Player player) {
        if (player.getLocation().getCols() + 1 < map.getWidth()) {
            cols = player.getLocation().getCols() + 1;
            player.getImage().translate(map.cellsToPixel(+1), 0);
        }
    }

}