package org.bd.java_exercise.design.run;

import org.bd.java_exercise.design.proxy.Automobile;
import org.bd.java_exercise.design.proxy.AutomobileProxy;
import org.bd.java_exercise.design.proxy.Vehicle;

public class RunProxyPattern {

    public static void main(String[] args) {
        Vehicle car = new AutomobileProxy(new Automobile());
        car.move();
    }
}
