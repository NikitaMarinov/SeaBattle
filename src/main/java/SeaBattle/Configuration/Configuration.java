package SeaBattle.Configuration;

import SeaBattle.Guns.*;
import SeaBattle.Main.Game;
import SeaBattle.Ocean.Ocean;
import SeaBattle.Players.Player;
import SeaBattle.Ships.*;
import SeaBattle.Shop.Shop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import java.util.Scanner;

@org.springframework.context.annotation.Configuration
@ComponentScan("SeaBattle")
public class Configuration {

    @Bean
    public Ocean ocean() {
        System.out.println("                        Welcome dear player!");
        System.out.println("-------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("Enter the length and width(N x N) of the ocean (0 - 200): ");
            n = scanner.nextInt();
        } while (n < 0 || n > 200);



        return new Ocean(n, n);
    }

    @Bean
    public Game game(Ocean ocean,AnnotationConfigApplicationContext applicationContext,Player player,Shop shop) {
        return new Game(ocean,applicationContext,player,shop);
    }

    @Bean
    public Bombard bombard() {
        return new Bombard();
    }

    @Bean
    public Kulevrina kulevrina() {
        return new Kulevrina();
    }

    @Bean
    public ShipGunOfThe17thCentury shipGunOfThe17thCentury() {
        return new ShipGunOfThe17thCentury();
    }

    @Bean
    public ShipGunOfThe18thCentury shipGunOfThe18thCentury() {
        return new ShipGunOfThe18thCentury();
    }

    @Bean
    public ShipGunOfThe19thCentury shipGunOfThe19thCentury() {
        return new ShipGunOfThe19thCentury();
    }

    @Bean
    @Scope("prototype")
    public Caravel caravel() {
        return new Caravel();
    }

    @Bean
    @Scope("prototype")
    public Frigate frigate() {
        return new Frigate();
    }

    @Bean
    @Scope("prototype")
    public Galleon galleon() {
        return new Galleon();
    }

    @Bean
    @Scope("prototype")
    public EnemyShipLevel1 enemyShipLevel1() {
        return new EnemyShipLevel1();
    }

    @Bean
    @Scope("prototype")
    public EnemyShipLevel2 enemyShipLevel2() {
        return new EnemyShipLevel2();
    }

    @Bean
    @Scope("prototype")
    public EnemyShipLevel3 enemyShipLevel3() {
        return new EnemyShipLevel3();
    }

    @Bean
    public Player player(){
        return new Player();
    }
    @Bean
    public Shop shop(AnnotationConfigApplicationContext context,Player player){return new Shop(context,player);}
}
