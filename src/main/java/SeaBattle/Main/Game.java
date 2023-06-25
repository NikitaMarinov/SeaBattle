package SeaBattle.Main;

import SeaBattle.Guns.*;
import SeaBattle.Ocean.Ocean;
import SeaBattle.Players.Player;
import SeaBattle.Ships.*;
import SeaBattle.Shop.Shop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private Player player;
    private Ocean ocean;
    private AnnotationConfigApplicationContext context;
    private Shop shop;
    private ArrayList<AbstractEnemyShip> list;
    private int initialShop = 1;
    private boolean exitGame = true;
    private int attackPlayer = 0;
    private int victory;
    private int defeat;


    public Game(){
    }
    public Game(Ocean ocean, AnnotationConfigApplicationContext context,Player player,Shop shop) {
        this.ocean = ocean;
        this.context = context;
        this.player = player;
        this.shop = shop;
    }



    public void Start(){
        boolean lose = false;
        boolean exit = true;
        boolean win = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose game difficulty(1-3):");
        System.out.println(" 1) Easy\n 2) Normal\n 3) Hard");

        int difficulty;
        do {
            difficulty = scanner.nextInt();
        }while (difficulty < 0 || difficulty > 3);


        do {
            System.out.println("Generating of enemy ships...\n\n\n\n\n\n");

            char[][] o = ocean.getOcean();
            Random rand = new Random();
            list = new ArrayList<>();

            switch (difficulty) {
                case 1 -> IntStream.range(0, 5)
                        .mapToObj(i -> {
                            AbstractEnemyShip abstractEnemyShip = context.getBean("enemyShipLevel1", EnemyShipLevel1.class);
                            abstractEnemyShip.setGun(context.getBean("bombard", Bombard.class));
                            setCoordinates(abstractEnemyShip);
                            return abstractEnemyShip;
                        })
                        .forEach(list::add);

                case 2 -> IntStream.range(0, 7)
                        .mapToObj(i -> {
                            AbstractEnemyShip abstractEnemyShip = context.getBean("enemyShipLevel2", EnemyShipLevel2.class);
                            abstractEnemyShip.setGun(context.getBean("kulevrina", Kulevrina.class));
                            setCoordinates(abstractEnemyShip);
                            return abstractEnemyShip;
                        })
                        .forEach(list::add);

                case 3 -> IntStream.range(0, 10)
                        .mapToObj(i -> {
                            AbstractEnemyShip abstractEnemyShip = context.getBean("enemyShipLevel3", EnemyShipLevel3.class);
                            abstractEnemyShip.setGun(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                            setCoordinates(abstractEnemyShip);
                            return abstractEnemyShip;
                        })
                        .forEach(list::add);
            }

            if (this.initialShop == 1) {

                System.out.println("Nice... To start Playing, you need to buy Ship and Gun!");
                shop.printNoShop();
                System.out.print("Select a ship(6-8): ");

                int buy;
                do {

                    do {
                        buy = scanner.nextInt();
                    } while (buy < 6 || buy > 8);

                    switch (buy) {
                        case 6 -> {
                            player.setShip(context.getBean("caravel", Caravel.class));
                            player.setMoney(player.getMoney() - context.getBean("caravel", Caravel.class).getPrice());
                        }

                        case 7 -> {
                            if (player.getMoney() >= 700) {
                                player.setShip(context.getBean("frigate", Frigate.class));
                                player.setMoney(player.getMoney() - context.getBean("frigate", Frigate.class).getPrice());

                            } else {
                                System.out.println("Your balance is not enough");
                            }
                        }

                        case 8 -> {
                            if (player.getMoney() >= 1100) {
                                player.setShip(context.getBean("galleon", Galleon.class));
                                player.setMoney(player.getMoney() - context.getBean("galleon", Galleon.class).getPrice());
                            } else {
                                System.out.println("Your balance is not enough");
                            }
                        }

                    }
                } while (player.getShip() == null);

                printPlayerInfo(player);

                System.out.print("Okay... Select a gun(1-5): ");
                do {

                    do {
                        buy = scanner.nextInt();
                    } while (buy < 1 || buy > 5);

                    switch (buy) {
                        case 1 -> {
                            player.getShip().setGun1(context.getBean("bombard", Bombard.class));
                            player.setMoney(player.getMoney() - context.getBean("bombard", Bombard.class).getPrice());
                        }

                        case 2, 3, 4, 5 -> System.out.println("Your balance is not enough");

                    }
                } while (player.getShip().getGun1() == null);

                this.initialShop = 0;
            }


            player.setY(ocean.getLength() / 2);
            player.setX(ocean.getWidth() - 1);
            o[ocean.getLength() - 1][ocean.getWidth() / 2] = 'P';
            reset();
            ocean.print();
            printMenu();

            do {
                int menu;

                do {
                    menu = scanner.nextInt();
                } while (menu < 1 || menu > 7);

                switch (menu) {
                    case 1:
                        System.out.print("Enter the number of miles(0 - EXIT): ");
                        boolean successful = true;
                        do {
                            int miles;

                            do {
                                miles = scanner.nextInt();
                                if (miles < 0 || miles > 5) {
                                    System.out.println("Enter a number greater than 0, and lower than 5");
                                }
                            } while (miles < 0 || miles > 5);

                            if (miles == 0) break;
                            if (player.getX() - miles > 0) {
                                if(o[player.getX() - miles][player.getY()] == 'X'){
                                    System.out.println("This place is busy!");
                                    break;
                                }

                                player.setX(player.getX() - miles);
                                successful = false;
                            } else {
                                System.out.println("Do not go beyond the map!");
                            }
                        } while (successful);
                        newCoordinates(o);
                        reset();
                        break;

                    case 2:
                        System.out.print("Enter the number of miles(0 - EXIT): ");
                        successful = true;
                        do {

                            int miles;

                            do {
                                miles = scanner.nextInt();
                                if (miles < 0 || miles > 5) {
                                    System.out.println("Enter a number greater than 0, and lower than 5");
                                }
                            } while (miles < 0 || miles > 5);
                            if (miles == 0) break;
                            if (player.getX() + miles < ocean.getWidth()) {
                                if(o[player.getX() + miles][player.getY()] == 'X'){
                                    System.out.println("This place is busy!");
                                    break;
                                }
                                player.setX(player.getX() + miles);
                                successful = false;
                            }
                            else {
                                System.out.println("Do not go beyond the map!");
                            }
                        } while (successful);
                        newCoordinates(o);
                        reset();
                        break;
                    case 3:
                        System.out.print("Enter the number of miles(0 - EXIT): ");
                        successful = true;
                        do {

                            int miles;

                            do {
                                miles = scanner.nextInt();
                                if (miles < 0 || miles > 5) {
                                    System.out.println("Enter a number greater than 0, and lower than 5");
                                }
                            } while (miles < 0 || miles > 5);
                            if (miles == 0) break;
                            if (player.getY() + miles < ocean.getLength()) {
                                if(o[player.getX()][player.getY() + miles] == 'X'){
                                    System.out.println("This place is busy!");
                                    break;
                                }
                                player.setY(player.getY() + miles);
                                successful = false;
                            } else {
                                System.out.println("Do not go beyond the map!");
                            }
                        } while (successful);
                        newCoordinates(o);
                        reset();
                        break;
                    case 4:
                        System.out.print("Enter the number of miles(0 - EXIT): ");
                        successful = true;
                        do {
                            int miles;
                            do {
                                miles = scanner.nextInt();
                                if (miles < 0 || miles > 5) {
                                    System.out.println("Enter a number greater than 0, and lower than 5");
                                }
                            } while (miles < 0 || miles > 5);
                            if (miles == 0) break;
                            if (player.getY() - miles > 0) {
                                if(o[player.getX()][player.getY()] == 'X'){
                                    System.out.println("This place is busy!");
                                    break;
                                }
                                player.setY(player.getY() - miles);
                                successful = false;
                            } else {
                                System.out.println("Do not go beyond the map!");
                            }
                        } while (successful);
                        newCoordinates(o);
                        reset();
                        break;
                    case 5:
                        boolean ex = true;
                        do {
                            reset();
                            printPlayerInfo(player);
                            ocean.print();
                            attackPlayer++;

                            String shipName = player.getShip().getName();
                            int attackRange = 0;

                            switch (shipName) {
                                case "Caravel" -> attackRange = player.getShip().getGun1().getAttackRange();
                                case "Frigate" -> {
                                    if (player.getShip().getGun1() != null) {
                                        attackRange = player.getShip().getGun1().getAttackRange();
                                    }
                                    if (player.getShip().getGun2() != null) {
                                        attackRange = Math.max(attackRange, player.getShip().getGun2().getAttackRange());

                                    }
                                }
                                case "Galleon" -> {
                                    if (player.getShip().getGun1() != null) {
                                        attackRange = player.getShip().getGun1().getAttackRange();
                                    }
                                    if (player.getShip().getGun2() != null) {
                                        attackRange = Math.max(attackRange, player.getShip().getGun2().getAttackRange());
                                    }
                                    if (player.getShip().getGun3() != null) {
                                        attackRange = Math.max(attackRange, player.getShip().getGun3().getAttackRange());
                                    }
                                }
                            }
                            System.out.println("Attack range: " + attackRange);
                            System.out.println("   Enemies we can attack:");
                            int X;
                            int Y;
                            int playerX = player.getX();
                            int playerY = player.getY();
                            ArrayList<AbstractEnemyShip> enemyShipsInRange;

                            int finalAttackRange = attackRange;
                            enemyShipsInRange = list.stream()
                                    .filter(ship -> {
                                        int distance = (int) Math.sqrt(Math.pow(ship.getX() - playerX, 2) + Math.pow(ship.getY() - playerY, 2));
                                        return distance < finalAttackRange && distance != 0;
                                    })
                                    .collect(Collectors.toCollection(ArrayList::new));

                            System.out.println("---------------------------");
                            enemyShipsInRange.stream()
                                    .map(AbstractEnemyShip::toString)
                                    .forEach(System.out::println);
                            System.out.print("Enter the coordinates of the enemy ship we are attacking:(through space) (200 :" +
                                    " 200 - EXIT):");
                            boolean exist = true;
                            int flag = 0;

                            do {
                                do {

                                    if (flag > 0) {
                                        System.out.println("You went beyond the world!");
                                    }

                                    X = scanner.nextInt();
                                    Y = scanner.nextInt();
                                    flag++;

                                    if(X == 200 && Y == 200){
                                        break;
                                    }

                                } while ((X < 0 || X > ocean.getLength()) || (Y < 0 || Y > ocean.getWidth()));

                                if(X !=200 && Y != 200) {

                                    if (o[X][Y] == 'X') {

                                        int finalX = X;
                                        int finalY = Y;
                                        boolean shipFound = enemyShipsInRange.stream()
                                                .anyMatch(ship -> ship.getX() == finalX && ship.getY() == finalY);

                                        if (shipFound) {
                                            exist = false;
                                        } else {
                                            System.out.println("We can't reach this ship!");
                                            flag = 0;
                                        }

                                    } else {
                                        System.out.println("There is no ship at these coordinated, please, enter new coordinates:");
                                        flag = 0;

                                    }
                                } else {
                                    flag = 0;
                                    exist = false;
                                }

                            } while (exist);
                            int attackX = X;
                            int attackY = Y;
                            if(X !=200 && Y != 200) {
                                int chance1;
                                int chance2;
                                int chance3;
                                String shipClass = player.getShip().getName();

                                switch (shipClass) {
                                    case "Caravel" -> {

                                        if (player.getShip().getGun1() != null) {
                                            chance1 = (int) (player.getShip().getGun1().getAccuracy() * 10);
                                            boolean hit1 = new Random().nextInt(10) + 1 < chance1;

                                            if (hit1) {
                                                enemyShipsInRange.stream()
                                                        .filter(ship -> ship.getX() == attackY && ship.getY() == attackY)
                                                        .findFirst()
                                                        .ifPresent(ship -> {
                                                            ship.setHealth(ship.getHealth() - player.getShip().getGun1().getDamage());
                                                            if (ship.getHealth() <= 0) {
                                                                o[attackX][attackY] = '_';
                                                                list.remove(ship);
                                                                player.setMoney(player.getMoney() + 300);
                                                            }
                                                        });
                                            } else {
                                                System.out.println("Miss!");
                                            }
                                        }
                                    }
                                    case "Frigate" -> {

                                        if (player.getShip().getGun1() != null) {
                                            chance1 = (int) (player.getShip().getGun1().getAccuracy() * 10);
                                            boolean hit1 = new Random().nextInt(10) + 1 < chance1;

                                            if (hit1) {
                                                enemyShipsInRange.stream()
                                                        .filter(ship -> ship.getX() == attackX && ship.getY() == attackY)
                                                        .findFirst()
                                                        .ifPresent(ship -> {
                                                            ship.setHealth(ship.getHealth() - player.getShip().getGun1().getDamage());
                                                            if (ship.getHealth() <= 0) {
                                                                o[attackX][attackY] = '_';
                                                                list.remove(ship);
                                                                player.setMoney(player.getMoney() + 300);
                                                            }
                                                        });
                                            } else {
                                                System.out.println("Miss!");
                                            }
                                        }

                                        if (player.getShip().getGun2() != null) {
                                            chance2 = (int) (player.getShip().getGun2().getAccuracy() * 10);
                                            boolean hit2 = new Random().nextInt(10) + 1 < chance2;

                                            if (hit2) {
                                                enemyShipsInRange.stream()
                                                        .filter(ship -> ship.getX() == attackY && ship.getY() == attackY)
                                                        .findFirst()
                                                        .ifPresent(ship -> {
                                                            ship.setHealth(ship.getHealth() - player.getShip().getGun2().getDamage());
                                                            if (ship.getHealth() <= 0) {
                                                                o[attackX][attackY] = '_';
                                                                list.remove(ship);
                                                                player.setMoney(player.getMoney() + 300);
                                                            }
                                                        });
                                            } else {
                                                System.out.println("Miss!");
                                            }
                                        }
                                    }
                                    case "Galleon" -> {

                                        if (player.getShip().getGun1() != null) {
                                            chance1 = (int) (player.getShip().getGun1().getAccuracy() * 10);
                                            boolean hit1 = new Random().nextInt(10) + 1 < chance1;

                                            if (hit1) {
                                                enemyShipsInRange.stream()
                                                        .filter(ship -> ship.getX() == attackY && ship.getY() == attackY)
                                                        .findFirst()
                                                        .ifPresent(ship -> {
                                                            ship.setHealth(ship.getHealth() - player.getShip().getGun1().getDamage());
                                                            if (ship.getHealth() <= 0) {
                                                                o[attackX][attackY] = '_';
                                                                list.remove(ship);
                                                                player.setMoney(player.getMoney() + 300);
                                                            }
                                                        });
                                            } else {
                                                System.out.println("Miss!");
                                            }
                                        }

                                        if (player.getShip().getGun2() != null) {
                                            chance2 = (int) (player.getShip().getGun2().getAccuracy() * 10);
                                            boolean hit2 = new Random().nextInt(10) + 1 < chance2;

                                            if (hit2) {
                                                enemyShipsInRange.stream()
                                                        .filter(ship -> ship.getX() == attackY && ship.getY() == attackY)
                                                        .findFirst()
                                                        .ifPresent(ship -> {
                                                            ship.setHealth(ship.getHealth() - player.getShip().getGun2().getDamage());
                                                            if (ship.getHealth() <= 0) {
                                                                o[attackX][attackY] = '_';
                                                                list.remove(ship);
                                                                player.setMoney(player.getMoney() + 300);
                                                            }
                                                        });
                                            } else {
                                                System.out.println("Miss!");
                                            }
                                        }
                                        if (player.getShip().getGun3() != null) {
                                            chance3 = (int) (player.getShip().getGun3().getAccuracy() * 10);
                                            boolean hit3 = new Random().nextInt(10) + 1 < chance3;


                                            if (hit3) {
                                                enemyShipsInRange.stream()
                                                        .filter(ship -> ship.getX() == attackX && ship.getY() == attackY)
                                                        .findFirst()
                                                        .ifPresent(ship ->{
                                                            ship.setHealth(ship.getHealth() - player.getShip().getGun3().getDamage());
                                                            if(ship.getHealth() <= 0){
                                                                o[attackX][attackY] = '_';
                                                                list.remove(ship);
                                                                player.setMoney(player.getMoney() + 300);
                                                            }
                                                        });

                                            } else {
                                            System.out.println("Miss!");
                                        }
                                        }
                                    }
                                }
                            }
                            if(X !=200 && Y != 200) {

                                if(attackPlayer == 3){
                                    if(difficulty == 1){
                                        int hit = (int) enemyShipsInRange.stream()
                                                        .filter(ship -> rand.nextInt(10) + 1 <= 3)
                                                                .count();
                                        player.getShip().setHealth(player.getShip().getHealth() - hit* 3 );
                                        attackPlayer = 0;
                                        if(player.getShip().getHealth() <=0){
                                            defeat++;
                                            lose = true;
                                            refreshHP();
                                            list.clear();
                                            win = false;
                                            break;
                                        }
                                    }
                                    if(difficulty == 2){
                                        int hit = (int) enemyShipsInRange.stream()
                                                .filter(ship -> rand.nextInt(10) + 1 <= 3)
                                                .count();

                                        player.getShip().setHealth(player.getShip().getHealth() - hit * 4);
                                        attackPlayer = 0;
                                        if(player.getShip().getHealth() <=0){
                                            defeat++;
                                            lose = true;
                                            refreshHP();
                                            list.clear();
                                            win = false;
                                            break;
                                        }
                                    }

                                    if(difficulty == 3){
                                        int hit = (int) enemyShipsInRange.stream()
                                                        .filter(ship -> rand.nextInt(10) + 1 <= 3)
                                                                .count();

                                        player.getShip().setHealth(player.getShip().getHealth() - hit * 5 );
                                        attackPlayer = 0;

                                        if(player.getShip().getHealth() <=0){
                                            defeat++;
                                            lose = true;
                                            refreshHP();
                                            win = false;
                                            list.clear();
                                            break;
                                        }
                                    }
                                    attackPlayer = 0;
                                }

                                System.out.print("One more time?(0 - NO  1 - YES):");
                                int num;
                                do {
                                    num = scanner.nextInt();
                                } while (num < 0 || num > 1);
                                if (num == 0) {
                                    ex = false;
                                }
                            } else {
                                ex = false;
                            }
                            reset();
                        }while (ex);

                        break;
                    case 6:
                        shop.buySomething();
                        reset();
                        break;
                    case 7:
                        exit = false;
                        break;
                }


                if (exit) {
                    printPlayerInfo(player);
                    ocean.print();
                    printMenu();

                    if (list.size() == 0 && win) {
                        System.out.println("YOU WIN THE ROUND!");
                        exit = false;
                        victory++;
                    }
                    if(lose){
                        System.out.println("YOU LOST THE ROUND!");
                        exit = false;
                        lose = false;
                        ocean.clearOcean();
                        win = true;

                    }
                } else {
                    System.out.println("Goodbye!");
                }


            } while (exit);
            System.out.println("New round(1) or exit the game(0)?");
            exit = true;
            int check;
            do {
                check = scanner.nextInt();
            } while (check < 0 || check > 1);
            if(check == 0)
                exitGame = true;
        }while(exitGame);
    }




    private void newCoordinates(char[][] o){
        IntStream.range(0, ocean.getLength())
                .forEach(i -> IntStream.range(0, ocean.getWidth())
                        .filter(j -> o[i][j] == 'P')
                        .forEach(j -> o[i][j] = '_'));

        o[player.getX()][player.getY()] = 'P';
    }
    private void printMenu(){
        System.out.println("            Menu            ");
        System.out.println("-----------------------------------");
        System.out.println("    1) Move forward(max 5 steps)");
          System.out.print("    2) Move backward(max 5 steps)");
        System.out.println("                --------------------------------------------------------------------------------------------");
          System.out.print("    3) Move to the right(max 5 steps)");
        System.out.println("             Your balance: " + player.getMoney() + "  Your HP: " + player.getShip().getHealth() + "   Your ship: " + player.getShip().getName() + "    Victories:   " +victory + "   Defeats:   " + defeat);
          System.out.print("    4) Move to the left(max 5 steps)");
        System.out.println("             --------------------------------------------------------------------------------------------");
        System.out.println("    5) Attack");
        System.out.println("    6) Shop");
        System.out.println("    7) Left the game");

    }
    public void reset(){
        for (int i = 0; i < 30; i++) {
            System.out.println(" ");
        }
    }
    private void refreshHP(){
        if(player.getShip().getName().equals("Caravel")){
            player.getShip().setHealth(100);
        }
        if(player.getShip().getName().equals("Frigate")){
            player.getShip().setHealth(150);
        }
        if(player.getShip().getName().equals("Galleon")){
            player.getShip().setHealth(200);
        }
    }
    public void printPlayerInfo(Player player){
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.print("Your balance: " + player.getMoney() + "  Your HP: " + player.getShip().getHealth() + "   Your ship: "  );
        if (player.getShip() != null) {
            System.out.print(player.getShip().getName());
        } else {
            System.out.print("  null");
        }

        if(player.getShip() == null){
            System.out.println("Your gun 1: null" );
        }
        else {
            String name = player.getShip().getName();


            switch (name) {
                case "Caravel" -> {
                    if (player.getShip() == null || player.getShip().getGun1() == null) {
                        System.out.print("  Your gun 1: null");
                    } else {
                        System.out.print("  Your gun 1: " + player.getShip().getGun1().getName());
                    }
                }
                case "Frigate" -> {
                    if (player.getShip() == null) {
                        System.out.print("  Your gun 1: null");
                        System.out.print("  Your gun 2: null");
                    } else {
                        if (player.getShip().getGun1() != null) {
                            System.out.print("  Your gun 1: " + player.getShip().getGun1().getName());
                        } else {
                            System.out.print("  Your gun 1: null");
                        }

                        if (player.getShip().getGun2() != null) {
                            System.out.print("  Your gun 2: " + player.getShip().getGun2().getName());
                        } else {
                            System.out.print("  Your gun 2: null");
                        }
                    }
                }
                case "Galleon" -> {
                    if (player.getShip() == null) {
                        System.out.print("  Your gun 1: null");
                        System.out.print("  Your gun 2: null");
                        System.out.print("  Your gun 3: null");
                    } else {
                        if (player.getShip().getGun1() != null) {
                            System.out.print("  Your gun 1: " + player.getShip().getGun1().getName());
                        } else {
                            System.out.print("  Your gun 1: null");
                        }

                        if (player.getShip().getGun2() != null) {
                            System.out.print("  Your gun 2: " + player.getShip().getGun2().getName());
                        } else {
                            System.out.print("  Your gun 2: null");
                        }

                        if (player.getShip().getGun3() != null) {
                            System.out.print(" Your gun 3: " + player.getShip().getGun3().getName());
                        } else {
                            System.out.print(" Your gun 3: null");
                        }
                    }
                }
            }
        }
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private AbstractEnemyShip setCoordinates(AbstractEnemyShip abstractEnemyShip){
        Random rand = new Random();
        char[][] o = ocean.getOcean();

        int X;
        int Y;
        do {
            X = rand.nextInt(ocean.getLength());
            Y = rand.nextInt(ocean.getWidth());
        } while (o[X][Y] != '_');
        o[X][Y] = 'X';
        abstractEnemyShip.setX(X);
        abstractEnemyShip.setY(Y);

        return abstractEnemyShip;
    }

}



