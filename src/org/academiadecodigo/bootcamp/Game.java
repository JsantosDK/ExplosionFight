package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.gameobjects.Player;
import org.academiadecodigo.bootcamp.gameobjects.PlayerOne;
import org.academiadecodigo.bootcamp.gameobjects.PlayerTwo;
import org.academiadecodigo.simplegraphics.pictures.Picture;



public class Game {

    private Map map;
    private Player playerOne;
    private Player playerTwo;
    private KeyboardManager keyboardManager;
    private int delay;
    private CollisionDetector collisionDetector;

    Game(int delay) {
        map = new Map(new Picture(10,10,"floor.png"));
        playerOne = new PlayerOne(new Picture(0,0,"morty.png"), map);
        playerTwo = new PlayerTwo(new Picture(0,0,"rick.png"), map);
        collisionDetector = new CollisionDetector(playerOne, playerTwo);
        keyboardManager = new KeyboardManager(playerOne,playerTwo);
        this.delay = delay;
    }

    public void init() {
        keyboardManager.keyboardInit();
        }


    public void start() throws InterruptedException {

        playerOne.setCollisionDetector(collisionDetector);
        playerTwo.setCollisionDetector(collisionDetector);

        while (true) {
            Thread.sleep(delay);
            playerOne.getBomb().countDown();
            playerTwo.getBomb().countDown();

        }

    }



}
