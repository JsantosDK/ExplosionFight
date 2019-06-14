package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Weapon extends GameObject{

    public Weapon(Picture image, Map map, Location location) {
        super(image, map, location);
    }

    protected abstract void setUpWeapon(int cols, int rows);

    public abstract void countDown();

    protected abstract void useWeapon();

    public abstract void clearField();

}