package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Map {

    private int cols;
    private int rows;
    private Picture background;
    private int cellSize;

    public Map(){
        background = new Picture(10,10,"floor.png");
        background.draw();
        cellSize = 105;
        cols = background.getWidth() / cellSize;
        rows = background.getHeight() / cellSize;
    }

    public int getWidth(){
        return cols;
    }

    public int getHeight(){
        return rows;
    }

    public int cellsToPixel(int cells){
        return cells * (cellSize-9);
    }
}
