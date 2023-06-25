package SeaBattle.Ships;

import SeaBattle.Guns.AbstractGun;

public class Galleon extends AbstractShip{

    private AbstractGun gun1;
    private AbstractGun gun2;
    private AbstractGun gun3;
    private  String name = "Galleon";
    private int health;
    public int price;
    public int numberOfGuns;

    public Galleon() {
        this.health = 200;
        this.price = 1000;
        this.numberOfGuns = 3;
    }


    public void setGun1(AbstractGun gun1) {
        this.gun1 = gun1;
    }

    public void setGun2(AbstractGun gun2) {
        this.gun2 = gun2;
    }

    public void setGun3(AbstractGun gun3) {
        this.gun3 = gun3;
    }

    public AbstractGun getGun1() {
        return gun1;
    }

    public AbstractGun getGun2() {
        return gun2;
    }

    public AbstractGun getGun3() {
        return gun3;
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public void shoot() {

    }
    @Override
    public void setHealth(int health) {
        this.health = health;
    }
    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getNumberOfGuns() {
        return this.numberOfGuns;
    }
}
