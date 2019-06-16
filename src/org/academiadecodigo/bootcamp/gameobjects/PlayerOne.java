package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerOne extends Player {

    public PlayerOne(Map map){
        super(new Picture(-36,-39,"resources/rick.png"), new Picture(-140,-140,"resources/rickwins.png"), map);
        getImage().grow(-50,-50);
    }


}
