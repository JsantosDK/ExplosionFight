package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bootcamp.Map;

public abstract class Player extends GameObject{

    private Weapon weapon;
    private Picture winnerScreen;

    public Player(Picture playerImage, Picture winnerScreen, Map map){
        super(playerImage, map, new Location(map));
        this.winnerScreen = winnerScreen;
        winnerScreen.grow(-150,-150);
        getImage().translate(map.cellsToPixel(getLocation().getCols()), map.cellsToPixel(getLocation().getRows()));
        weapon = new Bomb(map);
    }

    public void dropBomb(){
        weapon.setUpWeapon(getLocation().getCols(), getLocation().getRows());
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Picture getWinnerScreen() {
        return winnerScreen;
    }
}