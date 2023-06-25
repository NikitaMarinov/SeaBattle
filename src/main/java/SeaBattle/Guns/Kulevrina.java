package SeaBattle.Guns;

import java.security.PublicKey;

public class Kulevrina extends AbstractGun {
    private String name = "Kulevrina";

    private int attackRange;
    private int damage;
    private int price;
    private double accuracy;

    public Kulevrina() {
        this.attackRange = 6;
        this.damage = 12;
        this.price = 200;
        this.accuracy = 0.6;
    }

    @Override
    public int getAttackRange() {
        return this.attackRange;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public double getAccuracy() {
        return this.accuracy;
    }


    @Override
    public String getName() {
        return name;
    }
}
