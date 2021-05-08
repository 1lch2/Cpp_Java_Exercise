package design.run;

import design.proxy.Automobile;
import design.proxy.AutomobileProxy;
import design.proxy.Vehicle;

public class RunProxyPattern {

    public static void main(String[] args) {
        Vehicle car = new AutomobileProxy(new Automobile());
        car.move();
    }
}
