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
    private Picture login;

    Game(int delay) {
        map = new Map();
        playerOne = new PlayerOne(map);
        playerTwo = new PlayerTwo(map);
        collisionDetector = new CollisionDetector(playerOne, playerTwo);
        keyboardManager = new KeyboardManager(playerOne,playerTwo);
        this.delay = delay;
    }

    public void init() {
        keyboardManager.keyboardInit();
        login = new Picture(-140, -140, "start.png");
        login.grow(-150, -150);
        login.draw();
    }


    public void start() throws InterruptedException {
        while (!collisionDetector.isGameOver()) {
            Thread.sleep(delay);
            if (keyboardManager.isGameStart()){
                login.delete();
                map.getBackground().draw();
                playerOne.getImage().draw();
                playerTwo.getImage().draw();
                playerOne.setCollisionDetector(collisionDetector);
                playerTwo.setCollisionDetector(collisionDetector);
                playerOne.getWeapon().setCollisionDetector(collisionDetector);
                playerTwo.getWeapon().setCollisionDetector(collisionDetector);
            }
            //playerOne.getWeapon().setCollisionDetector(collisionDetector);
            //playerTwo.getWeapon().setCollisionDetector(collisionDetector);
            playerOne.getWeapon().countDown();
            playerTwo.getWeapon().countDown();
            playerOne.getWeapon().clearField();
            playerTwo.getWeapon().clearField();
        }

        System.out.println("Game Over");

    }



}
