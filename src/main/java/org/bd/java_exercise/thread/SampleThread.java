package org.bd.java_exercise.thread;

import java.util.Date;

/**
 * 自定义的固定任务线程
 */
public class SampleThread implements Runnable {

    /** 线程的ID */
    private final int id;
    /** 运行时间：秒 */
    private final int time;

    public SampleThread(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(">>> SampleThread[" + this.id + "] started at: " + new Date() + " >>>");

        try {
            System.out.println("SampleThread[" + this.id + "] running...");
            for (int i = this.time; i >= 0; i--) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>> SampleThread[" + this.id + "] ends >>>");
    }
}
