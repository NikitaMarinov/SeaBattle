package SeaBattle.Ships;

import SeaBattle.Guns.AbstractGun;


public class Caravel extends AbstractShip{
    private AbstractGun gun;
    private  String name = "Caravel";
    private int health;
    public int price;
    public int numberOfGuns;

    public Caravel() {
        this.health = 100;
        this.price = 300;
        this.numberOfGuns = 1;
    }

    public void setGun1(AbstractGun gun) {this.gun = gun;}

    @Override
    public void setGun2(AbstractGun gun) {

    }
    @Override
    public void setGun3(AbstractGun gun) {

    }
    @Override
    public AbstractGun getGun1() {return gun;}
    @Override
    public AbstractGun getGun2() {
        return null;
    }
    @Override
    public AbstractGun getGun3() {
        return null;
    }
    @Override
    public String getName() {return name;}
    @Override
    public void shoot() {
        if(gun == null){
            System.out.println("You need to buy a gun!");
        }
    }
    @Override
    public int getHealth() {
        return this.health;
    }
    @Override
    public void setHealth(int health) {
        this.health = health;
    }
    public int getPrice() {
        return this.price;
    }
    @Override
    public int getNumberOfGuns() {
        return this.numberOfGuns;
    }
}
