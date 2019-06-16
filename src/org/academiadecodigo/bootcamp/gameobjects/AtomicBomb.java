package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class AtomicBomb extends Weapon {

    private Explosion explosion;

    public AtomicBomb(Map map) {
        super(new Picture(14, -8, "resources/Flask2.png"), map, new Location(0, 0, map));
        getImage().grow(-18,-18);
        explosion = new Explosion();
    }

    protected void useWeapon() {
        explosion.explode(getLocation().getCols(), getLocation().getRows());
        getImage().translate(-getImage().getX() + 30, -getImage().getY() + 8);
        super.useWeapon();
    }

    @Override
    public void clearField() {
        explosion.reset();
    }

    private class Explosion {
        private Picture[] explosions;
        private int explosionReset;
        private boolean atomicBombArmed;
        private int blastRadius;
        private int usedImages;
        private int colsCenter;
        private int rowsCenter;
        private int minLengthCols;
        private int maxLengthCols;
        private int minLengthRows;
        private int maxLengthRows;

        public Explosion() {
            explosions = new Picture[25];
            explosions[0] = new Picture(5, 0, "resources/explosion3.png");
            explosions[1] = new Picture(5, 0, "resources/explosion3.png");
            explosions[2] = new Picture(5, 0, "resources/explosion3.png");
            explosions[3] = new Picture(5, 0, "resources/explosion3.png");
            explosions[4] = new Picture(5, 0, "resources/explosion3.png");
            explosions[5] = new Picture(5, 0, "resources/explosion3.png");
            explosions[6] = new Picture(5, 0, "resources/explosion3.png");
            explosions[7] = new Picture(5, 0, "resources/explosion3.png");
            explosions[8] = new Picture(5, 0, "resources/explosion3.png");
            explosions[9] = new Picture(5, 0, "resources/explosion3.png");
            explosions[10] = new Picture(5, 0, "resources/explosion3.png");
            explosions[11] = new Picture(5, 0, "resources/explosion3.png");
            explosions[12] = new Picture(5, 0, "resources/explosion3.png");
            explosions[13] = new Picture(5, 0, "resources/explosion3.png");
            explosions[14] = new Picture(5, 0, "resources/explosion3.png");
            explosions[15] = new Picture(5, 0, "resources/explosion3.png");
            explosions[16] = new Picture(5, 0, "resources/explosion3.png");
            explosions[17] = new Picture(5, 0, "resources/explosion3.png");
            explosions[18] = new Picture(5, 0, "resources/explosion3.png");
            explosions[19] = new Picture(5, 0, "resources/explosion3.png");
            explosions[20] = new Picture(5, 0, "resources/explosion3.png");
            explosions[21] = new Picture(5, 0, "resources/explosion3.png");
            explosions[22] = new Picture(5, 0, "resources/explosion3.png");
            explosions[23] = new Picture(5, 0, "resources/explosion3.png");
            explosions[24] = new Picture(5, 0, "resources/explosion3.png");
            blastRadius = 2;
            for (Picture atomicBomb : explosions) {
                atomicBomb.grow(-200,-200);
                atomicBomb.translate(-205,-195);
            }
        }

        private void explode(int cols, int rows) {
            if (cols - blastRadius > 0) { minLengthCols = cols - blastRadius; } else { minLengthCols = 1; }
            if (cols + blastRadius < getMap().getWidth() - 1) { maxLengthCols = cols + blastRadius; } else { maxLengthCols = getMap().getWidth() - 1; }
            if (rows - blastRadius > 0) { minLengthRows = rows - blastRadius; } else { minLengthRows = 1; }
            if (rows + blastRadius < getMap().getHeight()-1) { maxLengthRows = rows + blastRadius; } else { maxLengthRows = getMap().getHeight() - 1; }
            colsCenter = cols;
            rowsCenter = rows;

            for (int i = minLengthRows; i <= maxLengthRows; i++) {
                 for (int j = minLengthCols; j <= maxLengthCols; j++) {
                    explosions[usedImages].translate(getMap().cellsToPixel(j)-15, getMap().cellsToPixel(i)-15);
                    explosions[usedImages].draw();
                    usedImages++;
                }
            }
            explosionReset = 15;
            atomicBombArmed = true;
        }

        private void reset() {
            if (atomicBombArmed) {
                getCollisionDetector().checkDamage(colsCenter, minLengthCols, maxLengthCols, rowsCenter, minLengthRows, maxLengthRows, WeaponType.ATOMICBOMB);
                if (explosionReset != 0) {
                    explosionReset--;
                } else {
                    for (int i = usedImages - 1; i >= 0; i--) {
                        explosions[i].translate(-explosions[i].getX(), -explosions[i].getY());
                        explosions[i].delete();
                    }
                    usedImages = 0;
                    atomicBombArmed = false;
                }
            }
        }
    }
}
