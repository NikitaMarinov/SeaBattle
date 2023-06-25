package SeaBattle.Ships;


import SeaBattle.Guns.AbstractGun;

public class Frigate extends AbstractShip {

    private AbstractGun gun1;
    private AbstractGun gun2;
    private  String name = "Frigate";

    private int health;
    public int price;
    public int numberOfGuns;

    public Frigate() {
        this.health = 150;
        this.price = 600;
        this.numberOfGuns = 2;
    }
    @Override
    public void setGun1(AbstractGun gun1) {
        this.gun1 = gun1;
    }
    @Override
    public void setGun2(AbstractGun gun2) {
        this.gun2 = gun2;
    }
    @Override
    public void setGun3(AbstractGun gun) {}

    @Override
    public AbstractGun getGun1() {
        return gun1;
    }
    public AbstractGun getGun2() {
        return gun2;
    }
    @Override
    public AbstractGun getGun3() {return null;}


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void shoot() {

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
    public void setHealth(int health) {
        this.health = health;
    }
    @Override
    public int getNumberOfGuns() {
        return this.numberOfGuns;
    }
}
