package design.run;

import design.decorator.Audi;
import design.decorator.Car;
import design.decorator.PaintDecorator;

public class RunDecoratorPattern {

    public static void main(String[] args) {
        // Decorate an Audi car with paint decorator.
        Car car = new PaintDecorator(new Audi());
        car.didi();
    }
}
