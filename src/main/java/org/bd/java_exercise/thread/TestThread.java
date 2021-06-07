package org.bd.java_exercise.thread;

public class TestThread {
    public static void main(String[] args) throws Exception{
        testThread();
        testThreadOperations();
    }

    public static void testThread () throws InterruptedException {
        System.out.println("main start..."); // 该条语句最先执行，之后都无法确定顺序

        Thread t = new Thread(() -> {
            /*
             * 此处为 lambda 语法，原写法：
             * Thread t = new Thread() {
             *     @Override
             *     public void run () {
             *         ...
             *     }
             * };
             */
            System.out.println("thread run...");

            try {
                Thread.sleep(1000); // 使当前执行的线程暂停
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread end.");
        });

        t.setPriority(8); // 优先级为 1~10，默认为 5，但是不保证绝对会先执行
        t.start(); //* 调用 t.run() 不会启动线程，必须使用 t.start()
        t.join(); // 主线程等待 t 线程结束后再运行
        System.out.println("main end...");
        System.out.println();
    }

    public static void testThreadOperations () throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (! isInterrupted()) {
                    i++;
                    System.out.print(i + ", ");

                    if (isInterrupted()) {
                        System.out.println("\n>>> Thread interrupted >>>");
                    }
                }
            }
        };

        t.start();
        Thread.sleep(1);
        t.interrupt(); //* 调用 interrupt() 后，需要等待 t 线程处理终止
        t.join(); // 等待 t 终止后，终止主线程
        System.out.println("Thread terminated.");
    }
}
