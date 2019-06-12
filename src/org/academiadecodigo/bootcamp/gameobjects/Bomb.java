package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Bomb extends GameObject{

    private boolean usingBomb;
    private int timeUntilExplosion;
    private int hidingBomb;


    public Bomb(Map map){
        super(new Picture(0,0,"bomb.png"), map, new Location(0,0,map));
        getImage().grow(40,40);
        hidingBomb = - 20;
    }

    protected void dropBomb(int cols, int rows) {
        if (!usingBomb) {
            int oldCol = getLocation().getCols();
            int oldRow = getLocation().getRows();
            getLocation().changeLocation(cols, rows);
            usingBomb = true;
            timeUntilExplosion = 10;
            getImage().translate(getMap().cellsToPixel(getLocation().getCols() - oldCol), getMap().cellsToPixel(getLocation().getRows() - oldRow));
            getImage().draw();
        }
    }

    public void countDown(){
        if (usingBomb){
            if (timeUntilExplosion > 0){
                timeUntilExplosion--;
            } else if (timeUntilExplosion == 0){
                explodingBomb();
            }
        }
    }

    protected void explodingBomb(){
        int oldCol = getLocation().getCols();
        int oldRow = getLocation().getRows();
        getLocation().changeLocation(hidingBomb, hidingBomb);
        usingBomb = false;
        getImage().translate(getMap().cellsToPixel(getLocation().getCols()-oldCol), getMap().cellsToPixel(getLocation().getRows()-oldRow));
    }

}
