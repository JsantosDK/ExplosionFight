package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bootcamp.Map;

public abstract class Player extends GameObject{

    private int health;
    private Weapon weapon;

    public Player(Picture image, Map map){
        super(image, map, new Location(map));
        getImage().translate(map.cellsToPixel(getLocation().getCols()), map.cellsToPixel(getLocation().getRows()));
        //getImage().draw();
        weapon = new Bomb(map);
    }

    public void dropBomb(){
        weapon.setUpWeapon(getLocation().getCols(), getLocation().getRows());
    }

    public Weapon getWeapon() {
        return weapon;
    }

}