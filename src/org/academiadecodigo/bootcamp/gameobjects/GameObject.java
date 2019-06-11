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

    public GameObject(Picture image, Map map) {
        this.image = image;
        this.map = map;
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

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }
}

    /*
    private boolean status;
    private CollisionDetector collisionDetector;
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }
*/
