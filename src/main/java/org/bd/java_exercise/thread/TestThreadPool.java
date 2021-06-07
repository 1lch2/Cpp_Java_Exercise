package org.bd.java_exercise.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {

    public static void main(String[] args) {
        testFixedThreadPool();
    }

    /**
     * FixedThreadPool：固定数量的线程池
     */
    private static void testFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int id = 0; id < 6 ; id++) {
            executorService.submit(new SampleThread(id, id+1));
        }
        // 超出线程池数量的线程会在先前任务结束后再获取线程并执行
        executorService.shutdown();
    }
}
