package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;

public abstract class GameObject {

    private GridPosition pos;
    private Grid grid;
    private boolean status;
    private CollisionDetector collisionDetector;

    public GameObject(GridPosition pos) {
        this.pos = pos;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    public GridPosition getPos() {
        return pos;
    }

    public void setPos(GridPosition pos) {
        this.pos = pos;
    }

    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }


}