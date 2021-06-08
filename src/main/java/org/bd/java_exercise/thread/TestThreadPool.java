package org.bd.java_exercise.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

    public static void main(String[] args) {
//        testFixedThreadPool();
        testScheduledThreadPool(1);
    }

    /**
     * FixedThreadPool：固定数量的线程池
     */
    private static void testFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int id = 0; id < 6 ; id++) {
            executorService.submit(new SampleThread(Integer.toString(id), id+1));
        }
        // 超出线程池数量的线程会在先前任务结束后再获取线程并执行
        executorService.shutdown();
    }

    /**
     * ScheduledThreadPool：定期反复执行的线程池
     * <p>相比较Timer类，可以执行多个定期任务</p>
     */
    private static void testScheduledThreadPool(int taskId) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        switch (taskId) {
            case 0:
                // 指定延迟执行一次性任务：3秒后执行一次
                executorService.schedule(new SampleThread("one-time", 1), 3, TimeUnit.SECONDS);
                break;
            case 1:
                // 指定触发时间周期执行定期任务：0秒后以2秒的触发周期反复执行
                executorService.scheduleAtFixedRate(new SampleThread("fixed-rate", 1), 0, 2, TimeUnit.SECONDS);

                // 5秒后关闭线程池
                new Thread(() -> {
                    try {
                        Thread.sleep(5000);
                        executorService.shutdown();
                        System.out.println("shutdown() executed");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();

                // 检查线程池状态
                new Thread(() -> {
                    boolean flag = true;
                    while (!executorService.isShutdown() || !executorService.isTerminated()) {
                        if (executorService.isShutdown() && flag) {
                            System.out.println("shutdown success");
                            flag = false;
                        }
                        //* 对线程池执行shutdown()后，经过短暂的时间后才会进入Terminated状态
                        if (executorService.isTerminated()) {
                            System.out.println("terminated");
                        }
                    }
                }).start();
                break;
            case 2:
                // 指定触发时间间隔执行定期任务：1秒后以3秒的触发间隔反复执行
                executorService.scheduleWithFixedDelay(new SampleThread("fixed-delay", 2), 2, 3, TimeUnit.SECONDS);

                // TODO: shutdown after a few seconds
                break;
            default:
                System.out.println("Wrong argument!");
                break;
        }
    }
}
