package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bootcamp.Map;

public abstract class Player extends GameObject{

    private int health;
    private Bomb bomb;

    public Player(Picture image, Map map){
        super(image, map, new Location(map));
        getImage().translate(map.cellsToPixel(getLocation().getCols()), map.cellsToPixel(getLocation().getRows()));
        getImage().draw();
        bomb = new Bomb(map);
    }

    public void dropBomb(){
        bomb.dropBomb(getLocation().getCols(), getLocation().getRows());
    }

    public Bomb getBomb() {
        return bomb;
    }

}