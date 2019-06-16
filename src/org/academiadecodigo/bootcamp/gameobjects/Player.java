package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bootcamp.Map;

public abstract class Player extends GameObject{

    private Weapon weapon;
    private Bomb bomb;
    private LightningBolt lightningBolt;
    private AtomicBomb atomicBomb;
    private Picture winnerScreen;

    public Player(Picture playerImage, Picture winnerScreen, Map map){
        super(playerImage, map, new Location(map));
        this.winnerScreen = winnerScreen;
        winnerScreen.grow(-150,-150);
        getImage().translate(map.cellsToPixel(getLocation().getCols()), map.cellsToPixel(getLocation().getRows()));
        bomb = new Bomb(map);
        lightningBolt = new LightningBolt(map);
        atomicBomb = new AtomicBomb(map);
        weapon = bomb;
    }

    public void dropBomb(){
        if (getWeapon().getTimeUntilExplosion() == 0) {
            double weaponOdds = Math.random();
            if (weaponOdds < 0.4) {
                weapon = bomb;
                weapon.setCollisionDetector(getCollisionDetector());
            } else if (weaponOdds < 0.65) {
                weapon = lightningBolt;
                weapon.setCollisionDetector(getCollisionDetector());
            } else {
                weapon = atomicBomb;
                weapon.setCollisionDetector(getCollisionDetector());
            }
        }
        weapon.setUpWeapon(getLocation().getCols(), getLocation().getRows());
    }

    public void coolDown(){
        bomb.countDown();
        bomb.clearField();
        lightningBolt.countDown();
        lightningBolt.clearField();
        atomicBomb.countDown();
        atomicBomb.clearField();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Picture getWinnerScreen() {
        return winnerScreen;
    }
}