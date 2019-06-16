package org.academiadecodigo.bootcamp.gameobjects;

import org.academiadecodigo.bootcamp.Location;
import org.academiadecodigo.bootcamp.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class LightningBolt extends Weapon {


    private Explosion explosion;

    public LightningBolt(Map map) {
        super(new Picture(14, -8, "Flask1.png"), map, new Location(0, 0, map));
        getImage().grow(-18, -18);
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
        private boolean lightningBoltArmed;
        private int usedImages;
        private int colsCenter;
        private int rowsCenter;
        private int minLengthCols;
        private int maxLengthCols;
        private int minLengthRows;
        private int maxLengthRows;

        public Explosion() {
            explosions = new Picture[9];
            explosions[0] = new Picture(5, 0, "explosion2.png");
            explosions[1] = new Picture(5, 0, "explosion2.png");
            explosions[2] = new Picture(5, 0, "explosion2.png");
            explosions[3] = new Picture(5, 0, "explosion2.png");
            explosions[4] = new Picture(5, 0, "explosion2.png");
            explosions[5] = new Picture(5, 0, "explosion2.png");
            explosions[6] = new Picture(5, 0, "explosion2.png");
            explosions[7] = new Picture(5, 0, "explosion2.png");
            explosions[8] = new Picture(5, 0, "explosion2.png");
            for (Picture lightning : explosions) {
                lightning.grow(-5,-5);
                lightning.translate(-8,-8);
            }
        }

        private void explode(int cols, int rows) {
            minLengthCols = cols;
            maxLengthCols = cols;
            minLengthRows = 1;
            maxLengthRows = 9;
            colsCenter = cols;
            rowsCenter = rows;

            for (int i = minLengthRows; i <= maxLengthRows; i++) {
                explosions[usedImages].translate(getMap().cellsToPixel(cols)+10, getMap().cellsToPixel(i));
                explosions[usedImages].draw();
                usedImages++;
            }
            explosionReset = 15;
            lightningBoltArmed = true;
        }

        private void reset() {
            if (lightningBoltArmed) {
                getCollisionDetector().checkDamage(colsCenter, minLengthCols, maxLengthCols, rowsCenter, minLengthRows, maxLengthRows, WeaponType.LIGHTNINGBOLT);
                if (explosionReset != 0) {
                    explosionReset--;
                } else {
                    for (int i = usedImages - 1; i >= 0; i--) {
                        explosions[i].translate(-explosions[i].getX(), -explosions[i].getY());
                        explosions[i].delete();
                    }
                    usedImages = 0;
                    lightningBoltArmed = false;
                }
            }
        }
    }
}
