package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Bomb extends GameObject{

    private boolean usingBomb;
    private Player player;
    private int timeUntilExplosition;


    public Bomb(Map map, Player player){
        super(new Picture(0,0,"bomb.png"), map);
        setLocation( new Location(0,0,map));
        this.player = player;
    }

    protected void dropBomb(int cols, int rows) {
        if (!usingBomb) {
            int oldCol = getLocation().getCols();
            int oldRow = getLocation().getRows();
            getLocation().setCols(cols);
            getLocation().setRows(rows);
            usingBomb = true;
            timeUntilExplosition = 10;
            getImage().translate(getMap().cellsToPixel(getLocation().getCols() - oldCol), getMap().cellsToPixel(getLocation().getRows() - oldRow));
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
        int oldCol = getLocation().getCols();
        int oldRow = getLocation().getRows();
        getLocation().setCols(-20);
        getLocation().setRows(-20);
        usingBomb = false;
        getImage().translate(getMap().cellsToPixel(getLocation().getCols()-oldCol), getMap().cellsToPixel(getLocation().getRows()-oldRow));
        getImage().delete();
    }

}
