package org.bd.java_exercise.design.factory;

public class MiRouter implements RouterProduct {

    @Override
    public void powerOn() {
        System.out.println("Mi router running");
    }

    @Override
    public void wifiOn() {
        System.out.println("Mi router WiFi up and running.");
    }

    @Override
    public void powerOff() {
        System.out.println("Mi router power off.");
    }
}
