package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.gameobjects.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardManager implements KeyboardHandler {

    private Player player1;
    private Player player2;
    private Keyboard keyboard;
    private boolean gameStart;

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
            KeyboardEvent eventGameStart = new KeyboardEvent();
            eventGameStart.setKey(KeyboardEvent.KEY_SPACE);
            eventGameStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            this.keyboard.addEventListener(eventGameStart);
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
        if (gameStart) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_W && !player1.getCollisionDetector().checkCollision(player1.getLocation().getCols(), player1.getLocation().getRows() - 1)) {
                player1.getLocation().move(Direction.UP, player1);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_S && !player1.getCollisionDetector().checkCollision(player1.getLocation().getCols(), player1.getLocation().getRows() + 1)) {
                player1.getLocation().move(Direction.DOWN, player1);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_A && !player1.getCollisionDetector().checkCollision(player1.getLocation().getCols() - 1, player1.getLocation().getRows())) {
                player1.getLocation().move(Direction.LEFT, player1);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_D && !player1.getCollisionDetector().checkCollision(player1.getLocation().getCols() + 1, player1.getLocation().getRows())) {
                player1.getLocation().move(Direction.RIGHT, player1);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_Q) {
                player1.dropBomb();
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_I && !player1.getCollisionDetector().checkCollision(player2.getLocation().getCols(), player2.getLocation().getRows() - 1)) {
                player2.getLocation().move(Direction.UP, player2);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_K && !player1.getCollisionDetector().checkCollision(player2.getLocation().getCols(), player2.getLocation().getRows() + 1)) {
                player2.getLocation().move(Direction.DOWN, player2);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_J && !player1.getCollisionDetector().checkCollision(player2.getLocation().getCols() - 1, player2.getLocation().getRows())) {
                player2.getLocation().move(Direction.LEFT, player2);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_L && !player1.getCollisionDetector().checkCollision(player2.getLocation().getCols() + 1, player2.getLocation().getRows())) {
                player2.getLocation().move(Direction.RIGHT, player2);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_U) {
                player2.dropBomb();
            }
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE && !gameStart){
            gameStart = true;
            }
    }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
        }

    public boolean isGameStart() {
        return gameStart;
    }

}