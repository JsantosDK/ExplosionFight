package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Bomb extends GameObject{

    private boolean usingBomb;
    private Location location;


    public Bomb(Map map){
        super(new Picture(0,0,"bomb.png"), map);
        location = new Location(0,0,map);
    }

    public void dropBomb(int cols, int rows){
        int oldCol = location.getCols();
        int oldRow = location.getRows();
        location.setCols(cols);
        location.setRows(rows);
        usingBomb = true;
        getImage().translate( getMap().columnsToX(location.getCols()-oldCol), getMap().rowsToY(location.getRows()-oldRow));
        getImage().draw();
    }



    public void explodingBomb(){
        int oldCol = location.getCols();
        int oldRow = location.getRows();
        location.setCols(-20);
        location.setRows(-20);
        getImage().translate(getMap().columnsToX(location.getCols()-oldCol), getMap().rowsToY(location.getRows()-oldRow));
        getImage().draw();
    }

}
