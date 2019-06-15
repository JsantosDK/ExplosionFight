package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Bomb extends GameObject {

    private boolean usingBomb;
    private int timeUntilExplosion;
    private int hidingBomb;
    private Explosion[] explosions;



    public Bomb(Map map) {
        super(new Picture(33, 30, "bomb.png"), map, new Location(0, 0, map));
        getImage().grow(20, 20);
        hidingBomb = -20;
        explosions = new Explosion[10];
        for (int i = 0; i < 10; i++) {
            explosions[i] = new Explosion(map,this);


        }

    }

    protected void dropBomb(int cols, int rows) {
        if (!usingBomb) {
            int oldCol = getLocation().getCols();
            int oldRow = getLocation().getRows();
            getLocation().updateLocation(cols, rows);
            usingBomb = true;
            timeUntilExplosion = 10;
            getImage().translate(getMap().cellsToPixel(getLocation().getCols() - oldCol), getMap().cellsToPixel(getLocation().getRows() - oldRow));
            getImage().draw();


        }
    }

    public void countDown() {
        if (usingBomb) {
            if (timeUntilExplosion > 0) {
                timeUntilExplosion--;
            } else if (timeUntilExplosion == 0) {
                explode();
            }
        }
    }

    protected void explode() {
        int oldCol = getLocation().getCols();
        int oldRow = getLocation().getRows();
        getLocation().updateLocation(hidingBomb, hidingBomb);
        callExplosion(oldCol,oldRow);
        usingBomb = false;
        getImage().translate(getMap().cellsToPixel(getLocation().getCols() - oldCol), getMap().cellsToPixel(getLocation().getRows() - oldRow));
        callExplosion(oldCol, oldRow);
    }

    protected void callExplosion(int cols, int rows) {
        int count = 0;

       for (int i =  cols -2; i < cols + 3 ; i++) {
            if( i > 0 && i < getMap().getWidth()) {
                explosions[count].getImage().translate(getMap().cellsToPixel(getLocation().getCols() - i), getMap().cellsToPixel(getLocation().getRows()));
                explosions[count].getImage().draw();
                explosions[count].getLocation().updateLocation(i,rows);
                count++;
            }


                for (int j = rows -2; j < rows + 3 ; j++) {
                    if (j < 0 && j > getMap().getHeight()) {
                        explosions[count].getImage().translate(getMap().cellsToPixel(getLocation().getCols()), getMap().cellsToPixel(getLocation().getRows() - j));
                        explosions[count++].getImage().draw();
                        explosions[count].getLocation().updateLocation(cols, j);
                        count++;
                    }

                }

        }

    }
}
