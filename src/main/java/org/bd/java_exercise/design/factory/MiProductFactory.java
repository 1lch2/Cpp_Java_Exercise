package org.bd.java_exercise.design.factory;

public class MiProductFactory implements ProductFactory {

    @Override
    public PhoneProduct makePhone() {
        System.out.println("Mi factory making phone.");
        return new MiPhone();
    }

    @Override
    public RouterProduct makeRouter() {
        System.out.println("Mi factory making router.");
        return new MiRouter();
    }
}
