package SeaBattle.Guns;

public class ShipGunOfThe18thCentury extends AbstractGun{
    private String name = "ShipGunOfThe18thCentury";
    private int attackRange;
    private int damage;
    private int price;
    private double accuracy;

    public ShipGunOfThe18thCentury() {
        this.attackRange = 8;
        this.damage = 16;
        this.price = 400;
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
