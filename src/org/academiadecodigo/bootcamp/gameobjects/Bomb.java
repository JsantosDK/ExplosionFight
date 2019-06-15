package org.academiadecodigo.bootcamp.gameobjects;
import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Bomb extends Weapon {

    private Explosion explosion;

    public Bomb(Map map){
        super(new Picture(14,-11,"erlenmeyer.png"), map, new Location(0,0,map));
        getImage().grow(-15,-15);
        explosion = new Explosion();
    }

    protected void useWeapon(){
        explosion.explode(getLocation().getCols(),getLocation().getRows());
        getImage().translate(-getImage().getX() + 30, -getImage().getY() );
        super.useWeapon();
    }

    public void clearField() {
        explosion.reset();
    }

    private class Explosion {
        private Picture[] explosions;
        private int explosionReset;
        private boolean bombArmed;
        private int usedImages;
        private int colsCenter;
        private int rowsCenter;
        private int minLengthCols;
        private int maxLengthCols;
        private int minLengthRows;
        private int maxLengthRows;

        public Explosion(){
            explosions = new Picture[9];
            explosions[0] = new Picture(0, 0, "explosion1.png");
            explosions[1] = new Picture(0, 0, "explosion1.png");
            explosions[2] = new Picture(0, 0, "explosion1.png");
            explosions[3] = new Picture(0, 0, "explosion1.png");
            explosions[4] = new Picture(0, 0, "explosion1.png");
            explosions[5] = new Picture(0, 0, "explosion1.png");
            explosions[6] = new Picture(0, 0, "explosion1.png");
            explosions[7] = new Picture(0, 0, "explosion1.png");
            explosions[8] = new Picture(0, 0, "explosion1.png");
        }

        private void explode(int cols, int rows) {
            if (cols - 2 > 0) { minLengthCols = cols - 2; } else { minLengthCols = 1; }
            if (cols + 2 < getMap().getWidth()-1) { maxLengthCols = cols + 2; } else { maxLengthCols = getMap().getWidth()-1; }
            if (rows - 2 > 0) { minLengthRows = rows - 2; } else { minLengthRows = 1; }
            if (rows + 2 < getMap().getHeight()-1) { maxLengthRows = rows + 2; } else { maxLengthRows = getMap().getHeight()-1; }
            colsCenter = cols;
            rowsCenter = rows;

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
            explosionReset = 15;
            bombArmed = true;
        }

        private void reset() {
            if (bombArmed) {
                getCollisionDetector().checkDamage(colsCenter, minLengthCols,maxLengthCols,rowsCenter,minLengthRows,maxLengthRows, WeaponType.BOMB);
                if (explosionReset != 0) {
                    explosionReset--;
                } else {
                    for (int i = usedImages-1; i >= 0 ; i-- ){
                        explosions[i].translate(-explosions[i].getX(), -explosions[i].getY());
                        explosions[i].delete();
                    }
                    usedImages = 0;
                    bombArmed = false;
                }
            }
        }
    }
}