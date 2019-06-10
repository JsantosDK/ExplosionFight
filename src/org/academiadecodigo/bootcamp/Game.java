package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.car.Player;
import org.academiadecodigo.bootcamp.car.Player1;
import org.academiadecodigo.bootcamp.car.Player2;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.KeyboardManager;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

/**
 * The game logic
 */
public class Game {


    /**
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Container of Cars
     */
    //private Player[] players;

    private Player playerOne;
    private Player playerTwo;

    private KeyboardManager keyboardManager;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * Constructs a new game
     //* @param gridType which grid type to use
     * @param cols number of columns in the grid
     * @param rows number of rows in the grid
     * @param delay animation delay
     */
    Game( int cols, int rows, int delay) {
        grid = new SimpleGfxGrid(cols,rows);

        playerOne = new Player1(grid.makeGridPosition());
        playerTwo = new Player2(grid.makeGridPosition());

        playerOne.setGrid(grid);
        playerTwo.setGrid(grid);

        keyboardManager = new KeyboardManager(playerOne,playerTwo);

        this.delay = delay;
    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        grid.init();
        keyboardManager.keyboardInit();
        collisionDetector = new CollisionDetector(playerOne,playerTwo);
        playerOne.setCollisionDetector(collisionDetector);
        playerTwo.setCollisionDetector(collisionDetector);
        playerOne.setPos(grid.makeGridPosition());
        playerTwo.setPos(grid.makeGridPosition());



        //collisionDetector = new CollisionDetector(cars);
            //cars[i] = CarFactory.getNewCar(grid);
            //cars[i].setCollisionDetector(collisionDetector);
            //cars[i].setGrid(grid);

        }



    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

        }

    }



}
