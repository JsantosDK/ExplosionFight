package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Map {

    private int cols;
    private int rows;
    private Picture background;
    private int cellSize;

    public Map(Picture image){
        background = image;
        background.draw();
        cellSize = 24;
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
        return cells * cellSize;
    }
}
