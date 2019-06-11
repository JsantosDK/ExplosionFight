package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Bomb extends GameObject{

    private boolean usingBomb;
    private Location location;
    private Player player;
    private int timeUntilExplosition;


    public Bomb(Map map, Player player){
        super(new Picture(0,0,"bomb.png"), map);
        location = new Location(0,0,map);
        this.player = player;
    }

    protected void dropBomb(int cols, int rows) {
        if (!usingBomb) {
            int oldCol = location.getCols();
            int oldRow = location.getRows();
            location.setCols(cols);
            location.setRows(rows);
            usingBomb = true;
            timeUntilExplosition = 10;
            getImage().translate(getMap().cellsToPixel(location.getCols() - oldCol), getMap().cellsToPixel(location.getRows() - oldRow));
            getImage().draw();
        }
    }

    public void countDown(){
        if (usingBomb){
            if (timeUntilExplosition > 0){
                timeUntilExplosition--;
            } else if (timeUntilExplosition == 0){
                explodingBomb();
            }
        }
    }


    protected void explodingBomb(){
        int oldCol = location.getCols();
        int oldRow = location.getRows();
        location.setCols(-20);
        location.setRows(-20);
        usingBomb = false;
        getImage().translate(getMap().cellsToPixel(location.getCols()-oldCol), getMap().cellsToPixel(location.getRows()-oldRow));
        getImage().delete();
    }

}
