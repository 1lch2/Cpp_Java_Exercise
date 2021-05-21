package org.bd.java_exercise.design.run;

import org.bd.java_exercise.design.decorator.Audi;
import org.bd.java_exercise.design.decorator.Car;
import org.bd.java_exercise.design.decorator.PaintDecorator;

public class RunDecoratorPattern {

    public static void main(String[] args) {
        // Decorate an Audi car with paint decorator.
        Car car = new PaintDecorator(new Audi());
        car.didi();
    }
}
