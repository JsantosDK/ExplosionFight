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

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void moveUp(Player player) {
        Location whereto = player.getLocation();
        if (whereto.getRows() - 1 > 0) {
            player.setLocation(whereto.getCols(), whereto.getRows() - 1);
            player.getImage().translate(0, map.rowsToY(-1));
        }
    }

    public void moveDown(Player player) {
        Location whereto = player.getLocation();
        if (whereto.getRows() + 1 < map.getHeight()) {
            player.setLocation(whereto.getCols(), whereto.getRows() + 1);
            player.getImage().translate(0, map.rowsToY(1));
        }
    }

    public void moveLeft(Player player) {
        Location whereto = player.getLocation();
        if (whereto.getCols() - 1 > 0) {
            player.setLocation(whereto.getCols() - 1, whereto.getRows());
            player.getImage().translate(map.columnsToX(-1), 0);
        }
    }

    public void moveRight(Player player) {
        Location whereto = player.getLocation();
        if (whereto.getCols() + 1 < map.getWidth()) {
            player.setLocation(whereto.getCols() + 1, whereto.getRows());
            player.getImage().translate(map.columnsToX(+1), 0);
        }
    }

    public int locationColumnToX(int cols){
        return map.columnsToX(cols);
    }

    public int locationRowsToY(int rows){
        return map.rowsToY(rows);
    }
}
