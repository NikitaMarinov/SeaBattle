package SeaBattle.Guns;

public class ShipGunOfThe19thCentury extends AbstractGun{
    private String name = "ShipGunOfThe19thCentury";
    private int attackRange;
    private int damage;
    private int price;
    private double accuracy;

    public ShipGunOfThe19thCentury() {
        this.attackRange = 10;
        this.damage = 20;
        this.price = 700;
        this.accuracy = 0.8;
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
