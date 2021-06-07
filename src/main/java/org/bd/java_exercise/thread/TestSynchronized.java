package org.bd.java_exercise.thread;

/**
 * Java线程同步
 */
public class TestSynchronized {

    /** Lock object */
    private static final Object lock = new Object();

    public static void main(String[] args) {
        TestSynchronized that = new TestSynchronized();

        try {
            testSynchronized();
            that.firstRun();
            that.secondRun();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testSynchronized() throws InterruptedException {
        //* thread.run(): 在当前线程上执行传入的Runnable
        //* thread.start(): 当前线程执行结束后再开启子线程
        new Thread(() -> {
            synchronized (lock) {
                System.out.println(">>> Thread started >>>");
            }
        }).start();

        synchronized (lock) {
            System.out.println(">>> Main thread >>>");
            Thread.sleep(3000);
            System.out.println("3 seconds finished.");
        }
    }

    private synchronized void firstRun() throws InterruptedException {
        //* 方法加synchronized，锁住的对象是this
        System.out.println(">>> First to run >>>");
        Thread.sleep(3000);
        System.out.println("3 seconds finished.");
    }

    private synchronized void secondRun() {
        System.out.println(">>> Second to run >>>");
    }
}
