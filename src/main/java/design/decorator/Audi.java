package design.decorator;

/**
 * 奥迪车
 */
public class Audi implements Car {

    @Override
    public void didi() {
        System.out.println("[Audi] Didi from Audi car.");
    }
}
