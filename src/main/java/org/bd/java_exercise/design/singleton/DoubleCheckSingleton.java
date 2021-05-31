package org.bd.java_exercise.design.singleton;

/**
 * 双重检验锁单例
 */
public class DoubleCheckSingleton {

    /** 使用volatile关键字禁止JVM指令重排 */
    private volatile static DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {}

    /**
     * 使用二次检验防止生成多个实例
     * <p>在同步块内检验，防止多个线程一起进入同步块外的if</p>
     *
     * @return 单例对象
     */
    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
