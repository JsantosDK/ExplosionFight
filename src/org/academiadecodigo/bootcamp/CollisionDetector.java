package org.academiadecodigo.bootcamp;


import org.academiadecodigo.bootcamp.gameobjects.GameObject;
import org.academiadecodigo.bootcamp.gameobjects.Player;
import org.academiadecodigo.bootcamp.gameobjects.Weapon;

import java.awt.color.ColorSpace;

public class CollisionDetector {

    private GameObject[] gameObject;
    private Player player1;
    private Player player2;



    public CollisionDetector(Player player1, Player player2){
        gameObject = new GameObject[4];
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean checkCollision(int col, int row){
        gameObject[0] = player1;
        gameObject[1] = player1.getWeapon();
        gameObject[2] = player2;
        gameObject[3] = player2.getWeapon();
        for ( int i = 0; i < gameObject.length; i++){
            if (col == gameObject[i].getLocation().getCols() && row == gameObject[i].getLocation().getRows()){
                return true;
            }
        }
        return false;
    }

    public void checkDamage(int minCols, int maxCols, int minRows, int maxRows, Weapon weapon){

    }
}


