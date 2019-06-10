package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.position.GridPosition;

public abstract class Player extends GameObject {

    private int health;
    private boolean availableBomb;
    private Bomb bomb;
    private GridPosition gridPosition; //Not being used so far;

    public Player(GridPosition grid){
        super(grid);
        bomb = new Bomb(grid, this);
        availableBomb = true;
        health = 3;
    }

    public void dropBomb(){
        bomb.dropBomb(this);
        bomb.setPos(this.getPos());
        availableBomb = false;
    }

    protected void newBomb(boolean bomb){
        availableBomb = true;
    }

    public Bomb getBomb() {
        return bomb;
    }

}
