package SeaBattle.Ships;

import SeaBattle.Guns.AbstractGun;

public class EnemyShipLevel1 extends AbstractEnemyShip{
    private int X;
    private int Y;
    AbstractGun gun;
    private int health;

    public EnemyShipLevel1() {
        this.health = 50;
    }


    public void setGun(AbstractGun gun) {this.gun = gun;}

    public AbstractGun getGun() {return gun;}
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
    public String toString() {
        return "EnemyShipLevel1 " +
                "[" + X +
                " " + Y +
                "] Health: " + this.health;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }
}
