package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.gameobjects.Player;
import org.academiadecodigo.bootcamp.gameobjects.PlayerOne;
import org.academiadecodigo.bootcamp.gameobjects.PlayerTwo;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.Clip;

public class Game {

    private Map map;
    private Player playerOne;
    private Player playerTwo;
    private KeyboardManager keyboardManager;
    private int delay;
    private CollisionDetector collisionDetector;
    private Picture login;
    private Sound sound;


    Game(int delay) {
        map = new Map();
        playerOne = new PlayerOne(map);
        playerTwo = new PlayerTwo(map);
        collisionDetector = new CollisionDetector(playerOne, playerTwo);
        keyboardManager = new KeyboardManager(playerOne,playerTwo, collisionDetector);
        this.delay = delay;
        sound = new Sound();
    }

    public void init() {
        keyboardManager.keyboardInit();
        login = new Picture(-140, -140, "resources/start.png");
        login.grow(-150, -150);
        login.draw();
        sound.playSound("/resources/ingameSong.wav");

    }

    public void loading(){
        login.delete();
        map.getBackground().draw();
        playerOne.getImage().draw();
        playerTwo.getImage().draw();
        playerOne.setCollisionDetector(collisionDetector);
        playerTwo.setCollisionDetector(collisionDetector);
    }


    public void start() throws InterruptedException {
        while (!collisionDetector.isGameOver()) {
            Thread.sleep(delay);
            if (keyboardManager.isGameStart()) {
                loading();
            }
            playerOne.coolDown();
            playerTwo.coolDown();
        }
        end();
    }

    public void end() throws InterruptedException {
        Thread.sleep(800);
        map.getBackground().delete();
        playerOne.getImage().delete();
        playerTwo.getImage().delete();
        if (collisionDetector.isLoser() instanceof PlayerOne) {
            playerTwo.getWinnerScreen().draw();
            sound.stopMusic();
            sound.playSound("/resources/mortywins.wav");
        } else {
            playerOne.getWinnerScreen().draw();
            sound.stopMusic();
            sound.playSound("/resources/rickwins.wav");

        }
    }
}
