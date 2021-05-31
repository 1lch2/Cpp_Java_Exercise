package org.bd.java_exercise.design.singleton;

/**
 * 静态内部类单例
 */
public class StaticNestedSingleton {

    private static class SingletonHolder {
        private static final StaticNestedSingleton INSTANCE = new StaticNestedSingleton();
    }

    private StaticNestedSingleton() {}

    public static StaticNestedSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
