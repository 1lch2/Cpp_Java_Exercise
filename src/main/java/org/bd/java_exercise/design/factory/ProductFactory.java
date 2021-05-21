package org.bd.java_exercise.design.factory;

/**
 * 抽象产品工厂
 */
public interface ProductFactory {

    PhoneProduct makePhone();
    RouterProduct makeRouter();
}
