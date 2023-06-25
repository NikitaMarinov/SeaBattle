package SeaBattle.Players;

import SeaBattle.Ships.AbstractShip;

public class Player {
    private int X;
    private int Y;
    public int money = 400;
    public AbstractShip ship;
    public int getMoney() {
        return money;
    }
    public AbstractShip getShip() {
        return ship;
    }
    public void setShip(AbstractShip ship) {
        this.ship = ship;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void setX(int x) {
        X = x;
    }
    public void setY(int y) {
        Y = y;
    }
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
}
