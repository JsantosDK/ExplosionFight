package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.car.GameObject;
import org.academiadecodigo.bootcamp.car.Player;
import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;


    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(SimpleGfxGrid.PADDING + grid.getCellSize() * super.getCol(), SimpleGfxGrid.PADDING + grid.getCellSize() * super.getRow(), grid.getCellSize(), grid.getCellSize());
        show();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        rectangle = new Rectangle(SimpleGfxGrid.PADDING + grid.getCellSize() * col, SimpleGfxGrid.PADDING  + grid.getCellSize() * row, grid.getCellSize(), grid.getCellSize());
        show();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.draw();
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * //@see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, GameObject player) {
        int initialCol = simpleGfxGrid.columnToX(player.getPos().getCol());
        int initialRow = simpleGfxGrid.rowToY(player.getPos().getRow());

        super.moveInDirection(direction, player);

        int currentCol = simpleGfxGrid.columnToX(player.getPos().getCol());
        int currentRow = simpleGfxGrid.rowToY(player.getPos().getRow());
        rectangle.translate(currentCol - initialCol, currentRow - initialRow);
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        //throw new UnsupportedOperationException();
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        super.setColor(color);
    }
}
