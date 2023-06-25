package SeaBattle.Ships;

import SeaBattle.Guns.AbstractGun;

public class EnemyShipLevel2 extends AbstractEnemyShip{
    private int X;
    private int Y;
    private AbstractGun gun;

    private int health;

    public EnemyShipLevel2() {
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
    public AbstractGun getGun() {return gun;}
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
