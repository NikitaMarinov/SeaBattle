package SeaBattle.Ships;

import SeaBattle.Guns.AbstractGun;

public class EnemyShipLevel3 extends AbstractEnemyShip{
    private int Y;
    private int X;
    private AbstractGun gun;
    private int health;

    public EnemyShipLevel3() {
        this.health = 50;
    }


    public void setX(int x) {
        X = x;
    }
    public void setY(int y) {
        Y = y;
    }
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setGun(AbstractGun gun) {this.gun = gun;}
    @Override
    public AbstractGun getGun() {return null;}
    @Override
    public String toString() {
        return "EnemyShipLevel1 " +
                "[" + X +
                " " + Y +
                "] Health" + this.health;
    }
    @Override
    public void setHealth(int health) {
        this.health = health;
    }
}
