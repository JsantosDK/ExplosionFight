package org.academiadecodigo.bootcamp.grid.position;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.car.GameObject;
import org.academiadecodigo.bootcamp.car.Player;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;

/**
 * Base skeleton for a grid position
 *
 * @see GridPosition
 */
public abstract class AbstractGridPosition implements GridPosition {

    private int col;
    private int row;
    private GridColor color;
    private Grid grid;
    private SimpleGfxGridPosition gridPosition;


    /**
     * Construct a new grid position at a specific column and row
     *
     * @param col   the column of the grid position
     * @param row   the row of the grid position
     * @param grid  the grid in which the position will be displayed
     */
    public AbstractGridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
        this.gridPosition = gridPosition;
        this.color = GridColor.NOCOLOR;
    }

    public Grid getGrid() {
        return grid;
    }

    /**
     * @see GridPosition#setPos(int, int)
     */
    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    /**
     * @see GridPosition#getCol()
     */
    @Override
    public int getCol() {
        return col;
    }

    /**
     * @see GridPosition#getRow()
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * @see GridPosition#getColor()
     */
    @Override
    public GridColor getColor() {
        return color;
    }

    /**
     * @see GridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        this.color = color;
        show();
    }

    /**
     * //@see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, GameObject player) {

        switch (direction) {

            case UP:
                moveUp(1);
                break;
            case DOWN:
                moveDown(1);
                break;
            case LEFT:
                moveLeft(1);
                break;
            case RIGHT:
                moveRight(1);
                break;
        }

    }

    /**
     * @see GridPosition#equals(GridPosition)
     */
    @Override
    public boolean equals(GridPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
    }

    /**
     * Moves the position up
     *
     //* @param dist the number of positions to move
     */
    public void moveUp(int dist) {
        int maxRowsUP;
        if (dist < getRow()){
            maxRowsUP = dist;
        } else {
            maxRowsUP = getRow();
        }
        setPos(getCol(), getRow() - maxRowsUP);
    }

    /**
     * Moves the position down
     *
     * @param dist the number of positions to move
     */

    public void moveDown(int dist) {

        int maxRowsDown = dist > getGrid().getRows() - (getRow() + 1) ? getGrid().getRows() - (getRow() + 1) : dist;
        setPos(getCol(), getRow() + maxRowsDown);

    }

    /**
     * Moves the position left
     *
     * @param dist the number of positions to move
     */
    public void moveLeft(int dist) {

        int maxRowsLeft = dist < getCol() ? dist : getCol();
        setPos(getCol() - maxRowsLeft, getRow());

    }

    /**
     * Moves the position right
     *
     * @param dist the number of positions to move
     */
    public void moveRight(int dist) {
        int maxRowsRight = dist > getGrid().getCols() - (getCol() + 1) ? getGrid().getCols() - (getCol() + 1) : dist;
        setPos(getCol() + maxRowsRight, getRow());
    }

    @Override
    public String toString() {
        return "GridPosition{" +
                "col=" + col +
                ", row=" + row +
                ", getColor=" + color +
                '}';
    }

}
