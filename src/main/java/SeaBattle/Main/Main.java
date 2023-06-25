package SeaBattle.Main;

import SeaBattle.Configuration.Configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);


        Game game = context.getBean("game",Game.class);
        game.Start();



        context.close();

    }
}
