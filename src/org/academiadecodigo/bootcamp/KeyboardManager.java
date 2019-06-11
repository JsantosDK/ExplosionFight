package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.gameobjects.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.security.Key;

public class KeyboardManager implements KeyboardHandler {

    private Player player1;
    private Player player2;
    private Keyboard keyboard;

    public KeyboardManager(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.keyboard = new Keyboard(this);
    }

        public void keyboardInit() {
            KeyboardEvent eventPlayerOneUP = new KeyboardEvent();
            eventPlayerOneUP.setKey(KeyboardEvent.KEY_W);
            eventPlayerOneUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventPlayerOneUP);
            KeyboardEvent eventPlayerOneDown = new KeyboardEvent();
            eventPlayerOneDown.setKey(KeyboardEvent.KEY_S);
            eventPlayerOneDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventPlayerOneDown);
            KeyboardEvent eventPlayerOneLeft = new KeyboardEvent();
            eventPlayerOneLeft.setKey(KeyboardEvent.KEY_A);
            eventPlayerOneLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventPlayerOneLeft);
            KeyboardEvent eventPlayerOneRight = new KeyboardEvent();
            eventPlayerOneRight.setKey(KeyboardEvent.KEY_D);
            eventPlayerOneRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventPlayerOneRight);
            KeyboardEvent eventPlayerOneBomb = new KeyboardEvent();
            eventPlayerOneBomb.setKey(KeyboardEvent.KEY_Q);
            eventPlayerOneBomb.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventPlayerOneBomb);
            KeyboardEvent eventPlayerTwoUP = new KeyboardEvent();
            eventPlayerTwoUP.setKey(KeyboardEvent.KEY_I);
            eventPlayerTwoUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventPlayerTwoUP);
            KeyboardEvent eventPlayerTwoDown = new KeyboardEvent();
            eventPlayerTwoDown.setKey(KeyboardEvent.KEY_K);
            eventPlayerTwoDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventPlayerTwoDown);
            KeyboardEvent eventPlayerTwoLeft = new KeyboardEvent();
            eventPlayerTwoLeft.setKey(KeyboardEvent.KEY_J);
            eventPlayerTwoLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventPlayerTwoLeft);
            KeyboardEvent eventPlayerTwoRight = new KeyboardEvent();
            eventPlayerTwoRight.setKey(KeyboardEvent.KEY_L);
            eventPlayerTwoRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventPlayerTwoRight);
            KeyboardEvent eventPlayerTwoBomb = new KeyboardEvent();
            eventPlayerTwoBomb.setKey(KeyboardEvent.KEY_U);
            eventPlayerTwoBomb.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventPlayerTwoBomb);
        }


        public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            player1.getLocation().moveUp(player1);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            player1.getLocation().moveDown(player1);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            player1.getLocation().moveLeft(player1);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            player1.getLocation().moveRight(player1);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_Q) {
            player1.dropBomb();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_I) {
            player2.getLocation().moveUp(player2);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_K) {
            player2.getLocation().moveDown(player2);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_J) {
            player2.getLocation().moveLeft(player2);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
            player2.getLocation().moveRight(player2);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_U) {
            player2.dropBomb();
        }



        /*


            if (keyboardEvent.getKey() == 73 && !this.player1.getCollisionDetector().checkCollision(this.player1.getPos().getCol(), this.player1.getPos().getRow() - 1)) {
                this.player1.getPos().moveInDirection(GridDirection.UP, this.player1);
            }

            if (keyboardEvent.getKey() == 75 && !this.player1.getCollisionDetector().checkCollision(this.player1.getPos().getCol(), this.player1.getPos().getRow() + 1)) {
                this.player1.getPos().moveInDirection(GridDirection.DOWN, this.player1);
            }

            if (keyboardEvent.getKey() == 74 && !this.player1.getCollisionDetector().checkCollision(this.player1.getPos().getCol() - 1, this.player1.getPos().getRow())) {
                this.player1.getPos().moveInDirection(GridDirection.LEFT, this.player1);
            }

            if (keyboardEvent.getKey() == 76 && !this.player1.getCollisionDetector().checkCollision(this.player1.getPos().getCol() + 1, this.player1.getPos().getRow())) {
                this.player1.getPos().moveInDirection(GridDirection.RIGHT, this.player1);
            }

            if (keyboardEvent.getKey() == 85) {
                this.player1.dropBomb();
            }

            if (keyboardEvent.getKey() == 87 && !this.player2.getCollisionDetector().checkCollision(this.player2.getPos().getCol(), this.player2.getPos().getRow() - 1)) {
                this.player2.getPos().moveInDirection(GridDirection.UP, this.player2);
            }

            if (keyboardEvent.getKey() == 83 && !this.player2.getCollisionDetector().checkCollision(this.player2.getPos().getCol(), this.player2.getPos().getRow() + 1)) {
                this.player2.getPos().moveInDirection(GridDirection.DOWN, this.player2);
            }

            if (keyboardEvent.getKey() == 65 && !this.player2.getCollisionDetector().checkCollision(this.player2.getPos().getCol() - 1, this.player2.getPos().getRow())) {
                this.player2.getPos().moveInDirection(GridDirection.LEFT, this.player2);
            }

            if (keyboardEvent.getKey() == 68 && !this.player2.getCollisionDetector().checkCollision(this.player2.getPos().getCol() + 1, this.player2.getPos().getRow())) {
                this.player2.getPos().moveInDirection(GridDirection.RIGHT, this.player2);
            }

            if (keyboardEvent.getKey() == 81) {
                this.player2.dropBomb();
            }
        */
        }


        public void keyReleased(KeyboardEvent keyboardEvent) {
        }
    }

