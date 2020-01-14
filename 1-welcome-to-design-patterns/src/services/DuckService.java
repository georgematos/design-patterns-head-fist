package services;

import entities.DecoyDuck;
import entities.MallardDuck;
import entities.RedheadDuck;
import entities.RubberDuck;
import entities.behaviors.flying.FlyNoWay;
import entities.behaviors.flying.FlyWithWings;
import entities.behaviors.quacking.Quack;
import entities.behaviors.quacking.Squeak;

public final class DuckService {
    public static MallardDuck getMallardDuck() {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.setFlyBehavior(new FlyWithWings());
        mallardDuck.setQuackBehavior(new Quack());
        return mallardDuck;
    }

    public static RedheadDuck getRedheadDuck() {
        RedheadDuck redheadDuck = new RedheadDuck();
        redheadDuck.setFlyBehavior(new FlyWithWings());
        redheadDuck.setQuackBehavior(new Quack());
        return redheadDuck;
    }

    public static RubberDuck getRubberDuck() {
        RubberDuck redheadDuck = new RubberDuck();
        redheadDuck.setFlyBehavior(new FlyNoWay());
        redheadDuck.setQuackBehavior(new Squeak());
        return redheadDuck;
    }

    public static DecoyDuck getDecoyDuck() {
        DecoyDuck decoyDuck = new DecoyDuck();
        decoyDuck.setFlyBehavior(new FlyNoWay());
        decoyDuck.setQuackBehavior(new Squeak());
        return decoyDuck;
    }
}