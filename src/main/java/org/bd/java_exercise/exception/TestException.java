package org.bd.java_exercise.exception;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class TestException {
    public static void main(String[] args) {
        try {
            int res = 5 / 0;
        } catch (Exception e) { // 若方法声明了可能抛出的异常，则可以不用写catch
            e.printStackTrace();
            // System.out.println(e); // 打印了异常栈以后就不需要在打印异常信息了
        } finally { 
            System.out.println("Exception captured!");
        }

        /**
         * 多捕获异常
         * 从子类往父类写，先捕获匹配最精准的
         */

        // TODO: 没有例子，用心感受

        /**
         * 当前方法没有捕获异常时，会交由调用的上层继续捕获
         */
        try {
            process1();
        } catch (Exception e) {
            System.out.println("Captured exception at call stack.");
            e.printStackTrace();

            // 若在catch中又出现了异常，则程序会在finally执行后终止
            // 并在最后抛出异常，finally后的语句不会被执行
            // throw new ValueException("Test exception"); // 暂时注释掉
        } finally {
            System.out.println("Exception capture finished.");

            //* 若在finally中抛出异常，则原本在catch中抛出的异常会被屏蔽
            //* 只会抛出 finally中的异常
            // throw new IllegalArgumentException();
        }
        System.out.println("Is this line going to be executed?"); // No

        /**
         * 若在捕获异常时又抛出新异常，则原先的异常不会被后续过程捕获
         * 为了追踪到完整的异常栈，在构造异常时把原先的异常传入
         * 新的异常可以拥有原始的异常信息
         */
        try {
            procedure1();
        } catch (Exception e) {
            System.out.println("Captured full exception tree.");
            e.printStackTrace();
        }

    }

    static void process1() {
        process2();
    }

    static void process2() {
        Integer.parseInt(null); // 会抛出NumberFormatException
    }

    static void procedure1() {
        try {
            procedure2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e); // 在这里传入捕获到的异常对象
        }
    }

    static void procedure2() {
        throw new NullPointerException();
    }
}