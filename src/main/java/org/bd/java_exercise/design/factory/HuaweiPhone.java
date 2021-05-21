package org.bd.java_exercise.design.factory;

public class HuaweiPhone implements PhoneProduct {

    @Override
    public void boot() {
        System.out.println("Huawei phone booting up.");
    }

    @Override
    public void run() {
        System.out.println("Dream it possible.");
    }

    @Override
    public void shutdown() {
        System.out.println("Huawei phone shutting down.");
    }
}
