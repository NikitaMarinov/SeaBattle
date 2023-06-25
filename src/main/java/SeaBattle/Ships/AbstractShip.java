package SeaBattle.Ships;

import SeaBattle.Guns.AbstractGun;


public abstract class AbstractShip {
    private  String name;
    private int health;
    public int price;
    public int numberOfGuns;

    public abstract String getName();
    public abstract void shoot();
    public abstract int getHealth();
    public abstract void setHealth(int health);
    public abstract int getPrice();
    public abstract int getNumberOfGuns();
    public abstract void setGun1(AbstractGun gun);
    public abstract void setGun2(AbstractGun gun);
    public abstract void setGun3(AbstractGun gun);
    public abstract AbstractGun getGun1();
    public abstract AbstractGun getGun2();
    public abstract AbstractGun getGun3();
}
