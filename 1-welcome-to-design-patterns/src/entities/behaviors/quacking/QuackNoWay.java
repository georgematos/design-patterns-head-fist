package entities.behaviors.quacking;

public class QuackNoWay implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Can't quack...");
    }

}
