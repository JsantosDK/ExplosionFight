package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerOne extends Player {

    public PlayerOne(Map map){
        super(new Picture(-22,-35,"morty.png"), map);
        getImage().grow(-35,-35);
    }
}
