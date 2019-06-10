package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.bootcamp.car.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardManager implements KeyboardHandler{

    private Player player1;
    private Player player2;
    private Keyboard keyboard;

    public KeyboardManager(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        keyboard = new Keyboard(this);
    }

    public void keyboardInit() {

        // Player One
        KeyboardEvent eventPlayerOneUP = new KeyboardEvent();
        eventPlayerOneUP.setKey(KeyboardEvent.KEY_I);
        eventPlayerOneUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPlayerOneUP);

        KeyboardEvent eventPlayerOneDown = new KeyboardEvent();
        eventPlayerOneDown .setKey(KeyboardEvent.KEY_K);
        eventPlayerOneDown .setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPlayerOneDown);

        KeyboardEvent eventPlayerOneLeft = new KeyboardEvent();
        eventPlayerOneLeft.setKey(KeyboardEvent.KEY_J);
        eventPlayerOneLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPlayerOneLeft);

        KeyboardEvent eventPlayerOneRight = new KeyboardEvent();
        eventPlayerOneRight.setKey(KeyboardEvent.KEY_L);
        eventPlayerOneRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPlayerOneRight);

        KeyboardEvent eventPlayerOneBomb = new KeyboardEvent();
        eventPlayerOneBomb.setKey(KeyboardEvent.KEY_U);
        eventPlayerOneBomb.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPlayerOneBomb);

        // Player Two
        KeyboardEvent eventPlayerTwoUP = new KeyboardEvent();
        eventPlayerTwoUP.setKey(KeyboardEvent.KEY_W);
        eventPlayerTwoUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPlayerTwoUP);

        KeyboardEvent eventPlayerTwoDown = new KeyboardEvent();
        eventPlayerTwoDown .setKey(KeyboardEvent.KEY_S);
        eventPlayerTwoDown .setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPlayerTwoDown);

        KeyboardEvent eventPlayerTwoLeft = new KeyboardEvent();
        eventPlayerTwoLeft.setKey(KeyboardEvent.KEY_A);
        eventPlayerTwoLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPlayerTwoLeft);

        KeyboardEvent eventPlayerTwoRight = new KeyboardEvent();
        eventPlayerTwoRight.setKey(KeyboardEvent.KEY_D);
        eventPlayerTwoRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPlayerTwoRight);

        KeyboardEvent eventPlayerTwoBomb = new KeyboardEvent();
        eventPlayerTwoBomb.setKey(KeyboardEvent.KEY_Q);
        eventPlayerTwoBomb.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPlayerTwoBomb);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        // Player One
        if (keyboardEvent.getKey() == keyboardEvent.KEY_I && !player1.getCollisionDetector().checkCollision(player1.getPos().getCol(), player1.getPos().getRow() - 1)) {
                player1.getPos().moveInDirection(GridDirection.UP, player1);
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_K && !player1.getCollisionDetector().checkCollision(player1.getPos().getCol(), player1.getPos().getRow() + 1)) {
            player1.getPos().moveInDirection(GridDirection.DOWN,player1);
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_J && !player1.getCollisionDetector().checkCollision(player1.getPos().getCol() - 1, player1.getPos().getRow())) {
            player1.getPos().moveInDirection(GridDirection.LEFT,player1);
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_L && !player1.getCollisionDetector().checkCollision(player1.getPos().getCol() + 1, player1.getPos().getRow())) {
            player1.getPos().moveInDirection(GridDirection.RIGHT,player1);
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_U){
            player1.dropBomb();
        }

        // Player Two
        if (keyboardEvent.getKey() == keyboardEvent.KEY_W && !player2.getCollisionDetector().checkCollision(player2.getPos().getCol(), player2.getPos().getRow() - 1)) {
            player2.getPos().moveInDirection(GridDirection.UP,player2);
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_S && !player2.getCollisionDetector().checkCollision(player2.getPos().getCol(), player2.getPos().getRow() + 1)) {
            player2.getPos().moveInDirection(GridDirection.DOWN,player2);
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_A && !player2.getCollisionDetector().checkCollision(player2.getPos().getCol() - 1, player2.getPos().getRow())) {
            player2.getPos().moveInDirection(GridDirection.LEFT,player2);
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_D && !player2.getCollisionDetector().checkCollision(player2.getPos().getCol() + 1, player2.getPos().getRow())) {
            player2.getPos().moveInDirection(GridDirection.RIGHT,player2);
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_Q){
            player2.dropBomb();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }



}