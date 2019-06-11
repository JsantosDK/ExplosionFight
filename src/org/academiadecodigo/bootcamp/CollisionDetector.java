package org.academiadecodigo.bootcamp;



public class CollisionDetector {
/*
    private GameObject[] gameObject;
    private Player player1;
    private Player player2;



    public CollisionDetector(Player player1, Player player2){
        gameObject = new GameObject[4];
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean checkCollision(int col, int row){
        //gameObject[0] = player1;
        gameObject[0] = player1;
        gameObject[1] = player1.getBomb();
        gameObject[2] = player2;
        gameObject[3] = player2.getBomb();

        System.out.println(gameObject[0].getPos().getCol() + " " + gameObject[0].getPos().getRow() + " " + gameObject[2].getPos().getCol() + " " + gameObject[2].getPos().getRow());
        for ( int i = 0; i < gameObject.length; i++){
            if (col == gameObject[i].getPos().getCol() && row == gameObject[i].getPos().getRow()){
                return true;
            }
        }


        return false;
    }
*/

    /*
    private Car[] cars;

    public CollisionDetector(Car[] cars) {
        this.cars = cars;
    }

    public boolean isUnSafe(GridPosition pos) {

        for (Car c : cars) {

            if (c.getPos()!= pos && c.getPos().equals(pos)) {
                return true;
            }

        }

        return false;

    }

    /**
     * Checks for collisions with specific gameobjects
     * Requires iterating the array once
     * @param gameobjects
     */

/*
    public void check(Car gameobjects) {

        for (Car ic : cars) {

            // No point in checking collisions with self
            if (ic == gameobjects) {
                continue;
            }

            if (ic.getPos().equals(gameobjects.getPos())) {
                ic.crash();
                gameobjects.crash();
            }
        }

    }
*/
}


