package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bootcamp.Map;

public abstract class Player extends GameObject{

    private int health;
    private boolean availableBomb;
    private Location location;
    private Bomb bomb;

    public Player(Picture image, Map map){
        super(image, map);
        location = new Location(map);
        getImage().translate(map.columnsToX(getLocation().getCols()), map.rowsToY(getLocation().getRows()));
        getImage().draw();
        bomb = new Bomb(map);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(int cols, int rows) {
       location.setCols(cols);
       location.setRows(rows);
    }

    public void dropBomb(){
        bomb.dropBomb(location.getCols(), location.getRows());
    }

    public void bomb2(){
        bomb.explodingBomb();
    }
}
