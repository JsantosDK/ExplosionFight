package org.academiadecodigo.bootcamp.gameobjects;
import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Bomb extends Weapon {

    private boolean usingBomb;
    private int timeUntilExplosion;
    private Explosion explosion;

    public Bomb(Map map){
        super(new Picture(0,0,"bomb.png"), map, new Location(0,0,map));
        getImage().grow(15,15);
        explosion = new Explosion();
    }

    protected void setUpWeapon(int cols, int rows) {
        if (!usingBomb) {
            getLocation().changeLocation(cols, rows);
            usingBomb = true;
            timeUntilExplosion = 5;
            getImage().translate(getMap().cellsToPixel(cols) + 30, getMap().cellsToPixel(rows) + 30);
            getImage().draw();
        }
    }

    public void countDown(){
        if (usingBomb){
            if (timeUntilExplosion > 0){
                timeUntilExplosion--;
            } else if (timeUntilExplosion == 0){
                useWeapon();
            }
        }
    }

    protected void useWeapon(){
        explosion.explode(getLocation().getCols(),getLocation().getRows());
        getLocation().changeLocation(0, 0);
        usingBomb = false;
        getImage().translate(-getImage().getX() - 15, -getImage().getY()-15);
        getImage().delete();
    }

    public void clearField() {
        explosion.reset();
    }

    private class Explosion {
        private Picture[] explosions;
        private int explosionReset;
        private boolean bombArmed;
        private int usedImages;
        private int minLengthCols;
        private int maxLengthCols;
        private int minLengthRows;
        private int maxLengthRows;

        public Explosion(){
            explosions = new Picture[9];
            explosions[0] = new Picture(0, 0, "explosion1.png");
            explosions[1] = new Picture(0, 0, "explosion2.png");
            explosions[2] = new Picture(0, 0, "explosion3.png");
            explosions[3] = new Picture(0, 0, "explosion4.png");
            explosions[4] = new Picture(0, 0, "explosion5.png");
            explosions[5] = new Picture(0, 0, "explosion6.png");
            explosions[6] = new Picture(0, 0, "explosion7.png");
            explosions[7] = new Picture(0, 0, "explosion8.png");
            explosions[8] = new Picture(0, 0, "explosion9.png");
        }

        private void explode(int cols, int rows) {
            if (cols - 2 > 0) { minLengthCols = cols - 2; } else { minLengthCols = 1; }
            if (cols + 2 < getMap().getWidth()-1) { maxLengthCols = cols + 2; } else { maxLengthCols = getMap().getWidth()-1; }
            if (rows - 2 > 0) { minLengthRows = rows - 2; } else { minLengthRows = 1; }
            if (rows + 2 < getMap().getHeight()-1) { maxLengthRows = rows + 2; } else { maxLengthRows = getMap().getHeight()-1; }

            for (int i = minLengthCols; i <= maxLengthCols; i++) {
                explosions[usedImages].translate(getMap().cellsToPixel(i), getMap().cellsToPixel(rows));
                explosions[usedImages].draw();
                usedImages++;
            }
            for (int i = minLengthRows; i <= maxLengthRows; i++) {
                if (rows == i){continue;}
                explosions[usedImages].translate(getMap().cellsToPixel(cols), getMap().cellsToPixel(i));
                explosions[usedImages].draw();
                usedImages++;
            }
            explosionReset = 5;
            bombArmed = true;
        }

        private void reset() {
            if (bombArmed) {
                checkDamage();
                if (explosionReset != 0) {
                    explosionReset--;
                } else {
                    for (int i = usedImages-1; i >= 0 ; i-- ){
                        explosions[i].translate(-explosions[i].getX(), -explosions[i].getY());
                        explosions[i].delete();
                    }
                    usedImages =0;
                }
            }
        }

        private void checkDamage(){
            getCollisionDetector().checkDamage(minLengthCols,maxLengthCols,minLengthRows,maxLengthCols, Bomb.this);
        }
    }
}