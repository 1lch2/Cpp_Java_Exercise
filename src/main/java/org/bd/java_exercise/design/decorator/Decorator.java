package org.bd.java_exercise.design.decorator;

/**
 * 喷漆装饰器
 */
public class Decorator implements Car {

    public Car car;

    public Decorator(Car car) {
        this.car = car;
    }

    @Override
    public void didi() {
        this.car.didi();
    }
}
