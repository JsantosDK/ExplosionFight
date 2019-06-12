package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    private Picture image;
    private Map map;
    private Location location;
    private CollisionDetector collisionDetector;

    public GameObject(Picture image, Map map, Location location) {
        this.image = image;
        this.map = map;
        this.location = location;
    }

    public Picture getImage() {
        return image;
    }

    public Map getMap(){
        return map;
    }

    public Location getLocation() {
        return location;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }
}