package app;

import entities.*;
import entities.behaviors.flying.FlyWithRocket;
import services.DuckService;

public class App {
    public static void main(String[] args) throws Exception {
        MallardDuck mallard = DuckService.getMallardDuck();
        RedheadDuck redhead = DuckService.getRedheadDuck();
        RubberDuck rubber = DuckService.getRubberDuck();
        DecoyDuck decoy = DuckService.getDecoyDuck();

        System.out.println("Mallard Duck:");
        mallard.quack();
        mallard.swim();
        mallard.fly();
        mallard.display();

        System.out.println("-------------");
        System.out.println("Redhead Duck:");
        redhead.quack();
        redhead.swim();
        redhead.fly();
        redhead.display();

        System.out.println("-------------");
        System.out.println("Rubber Duck:");
        rubber.quack();
        rubber.swim();
        rubber.fly();
        rubber.display();

        System.out.println("-------------");
        System.out.println("Decoy Duck:");
        decoy.quack();
        decoy.swim();
        decoy.fly();
        decoy.display();

        // changing behavior of a duck at runtime
        System.out.println("------ changing fly way of mallard duck -------");
        mallard.setFlyBehavior(new FlyWithRocket());
        System.out.print("Mallard duck is ");
        mallard.fly();
    }
}
