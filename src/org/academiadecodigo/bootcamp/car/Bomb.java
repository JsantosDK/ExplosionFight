package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;

public class Bomb extends GameObject{

    private int countDown;
    private Player player;
    private SimpleGfxGrid gridPosition;

    public Bomb(GridPosition grid, Player player){
        super(grid);
        this.player = player;
        grid.setPos(0,0);
    }

    public boolean dropBomb(Player player){
        this.player = player;
        if (!isStatus()) {
            super.setStatus(true);
            countDown = 10;
            //SimpleGfxGrid().makeGridPosition(player.getPos().getCol(), player.getPos().getRow());
            return true;
        }
        return false;
    }

    public void countDown(){
        countDown--;
        System.out.println(countDown);
        if (countDown == 0){
            blownUpBomb();
        }
    }
    public void blownUpBomb(){
        player.newBomb(true);
        getGrid().makeGridPosition(-15,-15);
        super.setStatus(false);
        //SimpleGfxGrid;

    }


}
