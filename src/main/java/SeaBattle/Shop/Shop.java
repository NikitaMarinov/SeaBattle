package SeaBattle.Shop;

import SeaBattle.Guns.*;
import SeaBattle.Main.Game;
import SeaBattle.Players.Player;
import SeaBattle.Ships.Caravel;
import SeaBattle.Ships.Frigate;
import SeaBattle.Ships.Galleon;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Shop {

    AnnotationConfigApplicationContext context;
    Player player;
    public  Shop(AnnotationConfigApplicationContext context,Player player){
        this.context = context;
        this.player = player;
    }
    public void printNoShop(){
        System.out.println("Price list:");
        System.out.println("Guns:                                    Ships: \n" +
                "1) Bombard - 100$                        6) Caravel - 300$(One place for gun)     \n" +
                "2) Kulevrina - 200$                      7) Frigate - 600$(Two places for guns)   \n" +
                "3) ShipGunOfThe17thCentury - 300$        8) Galleon - 1000$(Three places for guns)\n" +
                "4) ShipGunOfThe18thCentury - 400$                          \n" +
                "5) ShipGunOfThe19thCentury - 700$                          \n");
    }

    public void print(){
        System.out.println("Price list:");
        System.out.println("Guns:                                    Ships: \n" +
                           "1) Bombard - 100$                        6) Caravel - 300$(One place for gun)     \n" +
                           "2) Kulevrina - 200$                      7) Frigate - 600$(Two places for guns)   \n" +
                           "3) ShipGunOfThe17thCentury - 300$        8) Galleon - 1000$(Three places for guns)\n" +
                           "4) ShipGunOfThe18thCentury - 400$        9) 10 hp - 20$                 \n" +
                           "5) ShipGunOfThe19thCentury - 700$        10) Exit                  \n");
    }

    public void buySomething(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        do {
            Game game = new Game();
            game.reset();
            game.printPlayerInfo(player);
            print();
            int buy;
            System.out.println("What do  you want to buy(1-10)?");
            do {
                buy = scanner.nextInt();
            } while (buy < 0 || buy > 10);

            switch (buy) {
                case 1 -> {
                    if (player.getMoney() >= 100) {
                        String sh = player.getShip().getName();
                        switch (sh) {
                            case "Caravel" -> {
                                AbstractGun gun;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                    player.setMoney(gun.getPrice() + player.getMoney());
                                }


                                player.getShip().setGun1(context.getBean("bombard", Bombard.class));
                                player.setMoney(player.getMoney() - 100);
                            }
                            case "Frigate" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }
                                int choose;
                                System.out.print("Choose a gun slot:");
                                do {
                                    choose = scanner.nextInt();
                                } while (choose < 1 || choose > 2);
                                if (choose == 1) {
                                    if (player.getShip().getGun1() == null) {
                                        player.getShip().setGun1(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 100);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun1(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 100);
                                    }
                                }
                                if (choose == 2) {
                                    if (player.getShip().getGun2() == null) {
                                        player.getShip().setGun2(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 100);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun2(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 100);
                                    }
                                }

                            }
                            case "Galleon" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }

                                int choose;
                                System.out.print("Choose a gun slot:");
                                do {
                                    choose = scanner.nextInt();
                                } while (choose < 1 || choose > 3);

                                if (choose == 1) {
                                    if (player.getShip().getGun1() == null) {
                                        player.getShip().setGun1(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 100);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun1(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 100);
                                    }
                                }

                                if (choose == 2) {
                                    if (player.getShip().getGun2() == null) {
                                        player.getShip().setGun2(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 100);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun2(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 100);
                                    }
                                }

                                if (choose == 3) {
                                    if (player.getShip().getGun3() == null) {
                                        player.getShip().setGun3(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 100);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun3(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 100);
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("You don't have enough money!");
                    }
                }
                case 2 -> {
                    if (player.getMoney() >= 200) {
                        String sh = player.getShip().getName();
                        switch (sh) {
                            case "Caravel" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }

                                if (player.getShip().getGun1() != null) {
                                    player.setMoney(gun.getPrice() + player.getMoney());
                                }
                                player.getShip().setGun1(context.getBean("kulevrina", Kulevrina.class));
                                player.setMoney(player.getMoney() - 200);
                            }
                            case "Frigate" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }
                                int choose;
                                System.out.print("Choose a gun slot:");
                                do {
                                    choose = scanner.nextInt();
                                } while (choose < 1 || choose > 2);
                                if (choose == 1) {
                                    if (player.getShip().getGun1() == null) {
                                        player.getShip().setGun1(context.getBean("kulevrina", Kulevrina.class));
                                        player.setMoney(player.getMoney() - 200);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun1(context.getBean("kulevrina", Kulevrina.class));
                                        player.setMoney(player.getMoney() - 200);
                                    }
                                }
                                if (choose == 2) {
                                    if (player.getShip().getGun2() == null) {
                                        player.getShip().setGun2(context.getBean("kulevrina", Kulevrina.class));
                                        player.setMoney(player.getMoney() - 200);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun2(context.getBean("kulevrina", Kulevrina.class));
                                        player.setMoney(player.getMoney() - 200);
                                    }
                                }

                            }
                            case "Galleon" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }

                                int choose;
                                System.out.print("Choose a gun slot:");
                                do {
                                    choose = scanner.nextInt();
                                } while (choose < 1 || choose > 3);

                                if (choose == 1) {
                                    if (player.getShip().getGun1() == null) {
                                        player.getShip().setGun1(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 200);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun1(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 200);
                                    }
                                }

                                if (choose == 2) {
                                    if (player.getShip().getGun2() == null) {
                                        player.getShip().setGun2(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 200);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun2(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 200);
                                    }
                                }

                                if (choose == 3) {
                                    if (player.getShip().getGun3() == null) {
                                        player.getShip().setGun3(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 200);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun3(context.getBean("bombard", Bombard.class));
                                        player.setMoney(player.getMoney() - 200);

                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("You don't have enough money!");
                    }
                }
                case 3 -> {
                    if (player.getMoney() >= 300) {
                        String sh = player.getShip().getName();
                        switch (sh) {
                            case "Caravel" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }

                                if (player.getShip().getGun1() != null) {
                                    player.setMoney(gun.getPrice() + player.getMoney());
                                }
                                player.getShip().setGun1(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                player.setMoney(player.getMoney() - 300);
                            }
                            case "Frigate" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }
                                int choose;
                                System.out.print("Choose a gun slot:");
                                do {
                                    choose = scanner.nextInt();
                                } while (choose < 1 || choose > 2);
                                if (choose == 1) {
                                    if (player.getShip().getGun1() == null) {
                                        player.getShip().setGun1(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                        player.setMoney(player.getMoney() - 300);

                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun1(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                        player.setMoney(player.getMoney() - 300);

                                    }
                                }
                                if (choose == 2) {
                                    if (player.getShip().getGun2() == null) {
                                        player.getShip().setGun2(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                        player.setMoney(player.getMoney() - 300);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun2(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                        player.setMoney(player.getMoney() - 300);

                                    }
                                }

                            }
                            case "Galleon" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }

                                int choose;
                                System.out.print("Choose a gun slot:");
                                do {
                                    choose = scanner.nextInt();
                                } while (choose < 1 || choose > 3);

                                if (choose == 1) {
                                    if (player.getShip().getGun1() == null) {
                                        player.getShip().setGun1(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                        player.setMoney(player.getMoney() - 300);

                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun1(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                        player.setMoney(player.getMoney() - 300);

                                    }
                                }

                                if (choose == 2) {
                                    if (player.getShip().getGun2() == null) {
                                        player.getShip().setGun2(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                        player.setMoney(player.getMoney() - 300);

                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun2(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                        player.setMoney(player.getMoney() - 300);

                                    }
                                }

                                if (choose == 3) {
                                    if (player.getShip().getGun3() == null) {
                                        player.getShip().setGun3(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                        player.setMoney(player.getMoney() - 300);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun3(context.getBean("shipGunOfThe17thCentury", ShipGunOfThe17thCentury.class));
                                        player.setMoney(player.getMoney() - 300);

                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("You don't have enough money!");
                    }
                }
                case 4 -> {
                    if (player.getMoney() >= 400) {
                        String sh = player.getShip().getName();
                        switch (sh) {
                            case "Caravel" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }

                                if (player.getShip().getGun1() != null) {
                                    player.setMoney(gun.getPrice() + player.getMoney());
                                }
                                player.getShip().setGun1(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                player.setMoney(player.getMoney() - 400);
                            }
                            case "Frigate" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }
                                int choose;
                                System.out.print("Choose a gun slot:");
                                do {
                                    choose = scanner.nextInt();
                                } while (choose < 1 || choose > 2);
                                if (choose == 1) {
                                    if (player.getShip().getGun1() == null) {
                                        player.getShip().setGun1(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                        player.setMoney(player.getMoney() - 400);

                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun1(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                        player.setMoney(player.getMoney() - 400);

                                    }
                                }
                                if (choose == 2) {
                                    if (player.getShip().getGun2() == null) {
                                        player.getShip().setGun2(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                        player.setMoney(player.getMoney() - 400);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun2(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                        player.setMoney(player.getMoney() - 400);

                                    }
                                }

                            }
                            case "Galleon" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }

                                int choose;
                                System.out.print("Choose a gun slot:");
                                do {
                                    choose = scanner.nextInt();
                                } while (choose < 1 || choose > 3);

                                if (choose == 1) {
                                    if (player.getShip().getGun1() == null) {
                                        player.getShip().setGun1(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                        player.setMoney(player.getMoney() - 400);

                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun1(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                        player.setMoney(player.getMoney() - 400);

                                    }
                                }

                                if (choose == 2) {
                                    if (player.getShip().getGun2() == null) {
                                        player.getShip().setGun2(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                        player.setMoney(player.getMoney() - 400);

                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun2(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                        player.setMoney(player.getMoney() - 400);

                                    }
                                }

                                if (choose == 3) {
                                    if (player.getShip().getGun3() == null) {
                                        player.getShip().setGun3(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                        player.setMoney(player.getMoney() - 400);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun3(context.getBean("shipGunOfThe18thCentury", ShipGunOfThe18thCentury.class));
                                        player.setMoney(player.getMoney() - 400);

                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("You don't have enough money!");
                    }
                }
                case 5 -> {
                    if (player.getMoney() >= 700) {
                        String sh = player.getShip().getName();
                        switch (sh) {
                            case "Caravel" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }

                                if (player.getShip().getGun1() != null) {
                                    player.setMoney(gun.getPrice() + player.getMoney());
                                }
                                player.getShip().setGun1(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                player.setMoney(player.getMoney() - 700);
                            }
                            case "Frigate" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }
                                int choose;
                                System.out.print("Choose a gun slot:");
                                do {
                                    choose = scanner.nextInt();
                                } while (choose < 1 || choose > 2);
                                if (choose == 1) {
                                    if (player.getShip().getGun1() == null) {
                                        player.getShip().setGun1(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                        player.setMoney(player.getMoney() - 700);

                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun1(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                        player.setMoney(player.getMoney() - 700);

                                    }
                                }
                                if (choose == 2) {
                                    if (player.getShip().getGun2() == null) {
                                        player.getShip().setGun2(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                        player.setMoney(player.getMoney() - 700);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun2(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                        player.setMoney(player.getMoney() - 700);

                                    }
                                }

                            }
                            case "Galleon" -> {
                                AbstractGun gun = null;
                                if (player.getShip().getGun1() != null) {
                                    gun = player.getShip().getGun1();
                                }

                                int choose;
                                System.out.print("Choose a gun slot:");
                                do {
                                    choose = scanner.nextInt();
                                } while (choose < 1 || choose > 3);

                                if (choose == 1) {
                                    if (player.getShip().getGun1() == null) {
                                        player.getShip().setGun1(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                        player.setMoney(player.getMoney() - 700);

                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun1(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                        player.setMoney(player.getMoney() - 700);

                                    }
                                }

                                if (choose == 2) {
                                    if (player.getShip().getGun2() == null) {
                                        player.getShip().setGun2(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                        player.setMoney(player.getMoney() - 700);

                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun2(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                        player.setMoney(player.getMoney() - 700);

                                    }
                                }

                                if (choose == 3) {
                                    if (player.getShip().getGun3() == null) {
                                        player.getShip().setGun3(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                        player.setMoney(player.getMoney() - 700);
                                    } else {
                                        player.setMoney(gun.getPrice() + player.getMoney());
                                        player.getShip().setGun3(context.getBean("shipGunOfThe19thCentury", ShipGunOfThe19thCentury.class));
                                        player.setMoney(player.getMoney() - 700);

                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("You don't have enough money!");
                    }
                }
                case 6 -> {
                    AbstractGun abstractGun1 = null;
                    AbstractGun abstractGun2 = null;
                    AbstractGun abstractGun3 = null;
                    int check = 0;
                    if (player.getShip().getName().equals("Frigate") || player.getShip().getName().equals("Galleon") || player.getShip().getName().equals("Caravel")) {
                        System.out.println("Are you sure you want to buy this ship(1 - YES, 2 - NO)?");
                        do {
                            check = scanner.nextInt();
                        } while (check < 1 || check > 2);
                    }
                    if (check == 1) {
                        if (player.getMoney() >= 300) {
                            if (!player.getShip().getName().equals("Caravel")) {
                                String sh = player.getShip().getName();
                                if (sh == "Caravel") {
                                    player.setMoney(player.getMoney() + 300);
                                    abstractGun1 = player.getShip().getGun1();
                                }
                                if (sh == "Frigate") {
                                    player.setMoney(player.getMoney() + 700);
                                    abstractGun1 = player.getShip().getGun1();
                                    abstractGun2 = player.getShip().getGun2();
                                }
                                if (sh == "Galleon") {
                                    player.setMoney(player.getMoney() + 1000);
                                    abstractGun1 = player.getShip().getGun1();
                                    abstractGun2 = player.getShip().getGun2();
                                    abstractGun3 = player.getShip().getGun3();

                                }
                                player.setShip(context.getBean("caravel", Caravel.class));
                                player.setMoney(player.getMoney() - 300);
                                if (abstractGun3 != null) {
                                    player.setMoney(player.getMoney() + abstractGun3.getPrice());
                                }
                                if (abstractGun1 != null) {
                                    player.getShip().setGun1(abstractGun1);
                                }
                                if (abstractGun2 != null) {
                                    player.setMoney(player.getMoney() + abstractGun2.getPrice());
                                }
                            } else {
                                System.out.println("You already have this ship.");
                            }
                        } else {
                            System.out.println("You don't have enough money");
                        }
                    } else {
                        break;
                    }


                }
                case 7 -> {
                    AbstractGun abstractGun1 = null;
                    AbstractGun abstractGun2 = null;
                    AbstractGun abstractGun3 = null;

                    int check = 0;
                    if (player.getShip().getName().equals("Galleon")) {
                        System.out.println("Are you sure you want to buy this ship(1 - YES, 2 - NO)?");
                        do {
                            check = scanner.nextInt();
                        } while (check < 1 || check > 2);
                    }
                    if (check == 1) {
                        if (player.getMoney() >= 700) {
                            String sh = player.getShip().getName();
                            if (sh.equals("Caravel")) {
                                player.setMoney(player.getMoney() + 300);
                                abstractGun1 = player.getShip().getGun1();
                            }
                            if (sh == "Frigate") {
                                player.setMoney(player.getMoney() + 700);
                                abstractGun1 = player.getShip().getGun1();
                                abstractGun2 = player.getShip().getGun2();

                            }
                            if (sh == "Galleon") {
                                player.setMoney(player.getMoney() + 1000);
                                abstractGun1 = player.getShip().getGun1();
                                abstractGun2 = player.getShip().getGun2();
                                abstractGun3 = player.getShip().getGun3();


                            }
                            if (!player.getShip().getName().equals("Frigate")) {
                                player.setShip(context.getBean("frigate", Frigate.class));
                                player.setMoney(player.getMoney() - 700);
                                if (abstractGun3 != null) {
                                    player.setMoney(player.getMoney() + abstractGun3.getPrice());
                                }
                                if (abstractGun1 != null) {
                                    player.getShip().setGun1(abstractGun1);
                                }
                                if (abstractGun2 != null) {
                                    player.getShip().setGun2(abstractGun2);
                                }
                            } else {
                                System.out.println("You already have this ship.");
                            }
                        } else {
                            System.out.println("You don't have enough money");
                        }
                    } else {
                        break;
                    }
                }
                case 8 -> {
                    AbstractGun abstractGun1 = null;
                    AbstractGun abstractGun2 = null;
                    if (player.getMoney() >= 1000) {
                        String sh = player.getShip().getName();
                        if (sh == "Caravel") {
                            player.setMoney(player.getMoney() + 300);
                            abstractGun1 = player.getShip().getGun1();
                        }
                        if (sh == "Frigate") {
                            player.setMoney(player.getMoney() + 700);
                            abstractGun1 = player.getShip().getGun1();
                            abstractGun2 = player.getShip().getGun1();

                        }
                        if (sh == "Galleon") {
                            player.setMoney(player.getMoney() + 1000);
                        }
                        if (!player.getShip().getName().equals("Galleon")) {
                            player.setShip(context.getBean("galleon", Galleon.class));
                            player.setMoney(player.getMoney() - 1000);
                            if (abstractGun1 != null) {
                                player.getShip().setGun1(abstractGun1);
                            }
                            if (abstractGun2 != null) {
                                player.getShip().setGun2(abstractGun2);
                            }

                        } else {
                            System.out.println("You already have this ship.");
                        }
                    } else {
                        System.out.println("You don't have enough money");
                    }
                }
                case 9 -> {
                    if (player.getMoney() >= 20) {
                        player.getShip().setHealth(player.getShip().getHealth() + 10);
                    } else {
                        System.out.println("You don't have enough money");
                    }
                }
                case 10 -> {
                    exit = false;
                }
            }

        }while (exit);

    }


}
