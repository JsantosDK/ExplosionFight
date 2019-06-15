package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Explosion extends GameObject{

    public Explosion(Map map, Bomb bomb) {
        super(new Picture(33,30,"resources/explosion.png"), map, new Location(0,0,map));

            /*for (int i =  bomb.getLocation().getCols() -2; i < bomb.getLocation().getCols() +2 ; i++) {
                for (int j = bomb.getLocation().getRows() -2; j < bomb.getLocation().getRows() +2 ; j++) {



            }*/
        }



    }

