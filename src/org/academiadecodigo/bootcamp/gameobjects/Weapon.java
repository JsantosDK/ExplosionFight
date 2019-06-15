package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Weapon extends GameObject{

    private boolean usingBomb;
    private int timeUntilExplosion;

    public Weapon(Picture image, Map map, Location location) {
        super(image, map, location);
    }

    protected void setUpWeapon(int cols, int rows) {
        if (!usingBomb) {
            getLocation().changeLocation(cols, rows);
            usingBomb = true;
            timeUntilExplosion = 50;
            getImage().translate(getMap().cellsToPixel(cols) , getMap().cellsToPixel(rows) );
            getImage().draw();
        }
    }

    public void countDown(){
        if (usingBomb){
            if (timeUntilExplosion > 0){
                timeUntilExplosion--;
            } else if (timeUntilExplosion == 0){
                useWeapon();
            }
        }
    }

    protected void useWeapon(){
        getLocation().changeLocation(0, 0);
        usingBomb = false;
        getImage().delete();
    }

    public abstract void clearField();

}