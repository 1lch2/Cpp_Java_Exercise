package org.bd.java_exercise.design.decorator;

public class PaintDecorator extends Decorator {

    public PaintDecorator(Car car) {
        super(car);
    }

    @Override
    public void didi() {
        System.out.println("[Paint] Car painted.");
        super.didi();
    }
}
