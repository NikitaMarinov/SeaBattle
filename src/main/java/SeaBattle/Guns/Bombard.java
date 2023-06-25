package SeaBattle.Guns;


public class Bombard extends AbstractGun{

    private String name = "Bombard";
    private int attackRange;
    private int damage;
    private int price;
    private double accuracy;

    public Bombard() {
        this.attackRange = 5;
        this.damage = 10;
        this.price = 100;
        this.accuracy = 0.5;
    }



    @Override
    public String getName() {
        return name;
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
}
