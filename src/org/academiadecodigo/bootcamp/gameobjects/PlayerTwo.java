package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerTwo extends Player {

    public PlayerTwo(Map map){
        super(new Picture(-36,-39,"resources/morty.png"), new Picture(-140,-140,"resources/mortywins.png"), map);
        getImage().grow(-50,-50);
    }
}
