package org.bd.java_exercise.design.factory;

public class HuaweiProductFactory implements ProductFactory {

    @Override
    public PhoneProduct makePhone() {
        System.out.println("Huawei factory making phone.");
        return new HuaweiPhone();
    }

    @Override
    public RouterProduct makeRouter() {
        System.out.println("Huawei factory making router.");
        return new HuaweiRouter();
    }
}
