package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.gameobjects.*;

public class CollisionDetector {

    private GameObject[] gameObject;
    private Player[] players;
    private boolean gameOver;
    private Player loser;

    public CollisionDetector(Player player1, Player player2){
        gameObject = new GameObject[4];
        gameObject[0] = player1;
        gameObject[1] = player1.getWeapon();
        gameObject[2] = player2;
        gameObject[3] = player2.getWeapon();
        players = new Player[2];
        players[0] = player1;
        players[1] = player2;
    }

    public boolean checkCollision(int col, int row){
        for ( int i = 0; i < gameObject.length; i++){
            if (col == gameObject[i].getLocation().getCols() && row == gameObject[i].getLocation().getRows()){
                return true;
            }
        }
        return false;
    }

    public void checkDamage(int colsCenter,int minCols, int maxCols,int rowsCenter ,int minRows, int maxRows, WeaponType weaponType){
        for (Player player : players) {
            switch (weaponType) {
                case BOMB:
                    if (player.getLocation().getCols() >= minCols && player.getLocation().getCols() <= maxCols && player.getLocation().getRows() == rowsCenter) {
                        System.out.println("Player one died.");
                        loser = player;
                        gameOver = true;
                    } else if (player.getLocation().getRows() >= minRows && player.getLocation().getRows() <= maxRows && player.getLocation().getCols() == colsCenter) {
                        System.out.println("Player one died too.");
                        loser = player;
                        gameOver = true;
                    }
                    break;

                case LIGHTNINGBOLT:
                    if (player.getLocation().getRows() >= minRows && player.getLocation().getRows() <= maxRows && player.getLocation().getCols() == colsCenter) {
                        System.out.println("Player one died too.");
                        loser = player;
                        gameOver = true;
                    }
                    break;
                default:
                    System.out.println("Survived.");
            }
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }
    public Player isLoser(){
        return loser;
    }

}