package design.proxy;

public class Automobile implements Vehicle {

    @Override
    public void move() {
        System.out.println("[Automobile] Moving.");
    }
}
