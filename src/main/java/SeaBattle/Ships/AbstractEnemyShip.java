package SeaBattle.Ships;

import SeaBattle.Guns.AbstractGun;

import java.util.PrimitiveIterator;

public abstract class AbstractEnemyShip {
    private  String name;
    private int health;


    public abstract void setGun(AbstractGun gun);
    public abstract AbstractGun getGun( );
    public abstract void setX(int X);
    public abstract void setY(int Y);
    public abstract int getX();
    public abstract int getY();
    public abstract int getHealth();


    public abstract String toString();
    public abstract void setHealth(int health);
}
