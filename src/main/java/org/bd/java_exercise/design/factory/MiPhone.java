package org.bd.java_exercise.design.factory;

public class MiPhone implements PhoneProduct {

    @Override
    public void boot() {
        System.out.println("Mi phone boot up.");
    }

    @Override
    public void run() {
        System.out.println("Are U OK?");
    }

    @Override
    public void shutdown() {
        System.out.println("Mi phone shutdown.");
    }
}
