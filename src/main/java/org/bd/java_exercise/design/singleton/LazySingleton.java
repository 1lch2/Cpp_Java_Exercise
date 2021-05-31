package org.bd.java_exercise.design.singleton;

/**
 * 懒汉式单例
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    /**
     * 线程安全的初始化方法
     * <p>仅在第一次调用时初始化
     * 保证了多线程下的安全，但是效率较差</p>
     *
     * @return 单例对象
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
