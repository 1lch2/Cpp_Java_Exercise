package org.bd.java_exercise.design.singleton;

/**
 * 饿汉式单例
 */
public class EagerSingleton {

    /** Initialize singleton on creation */
    private static final EagerSingleton instance = new EagerSingleton();

    /** private constructor */
    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
