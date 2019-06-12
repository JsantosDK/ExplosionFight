package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerTwo extends Player {

    public PlayerTwo(Map map){
        super(new Picture(-25,-30,"rick.png"), map);
        getImage().grow(-35,-35);
    }
}
