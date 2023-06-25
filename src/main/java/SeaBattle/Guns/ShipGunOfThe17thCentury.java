package SeaBattle.Guns;

public class ShipGunOfThe17thCentury extends AbstractGun{
    private String name = "ShipGunOfThe17thCentury";
    private int attackRange;
    private int damage;
    private int price;
    private double accuracy;

    public ShipGunOfThe17thCentury() {
        this.attackRange = 7;
        this.damage = 14;
        this.price = 300;
        this.accuracy = 0.7;
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
