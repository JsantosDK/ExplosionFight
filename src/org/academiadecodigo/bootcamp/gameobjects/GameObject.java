package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    private Picture image;
    private Map map;

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
