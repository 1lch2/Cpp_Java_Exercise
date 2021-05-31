package org.bd.java_exercise.design.singleton;

/**
 * 静态内部类单例
 */
public class StaticNestedSingleton {

    /**
     * Inner static class will not be initialized when outer class is loaded.
     * <p>This ensures thread security as well as the uniqueness of the singleton.</p>
     */
    private static class SingletonHolder {
        private static final StaticNestedSingleton INSTANCE = new StaticNestedSingleton();
    }

    private StaticNestedSingleton() {}

    /**
     * SingletonHolder class will be loaded by JVM only if this method is called.
     *
     * @return the singleton
     */
    public static StaticNestedSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
