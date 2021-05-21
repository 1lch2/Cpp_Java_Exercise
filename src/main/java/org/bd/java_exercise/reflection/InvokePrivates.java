package org.bd.java_exercise.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射调用方法
 */
public class InvokePrivates {

    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        Class<HelloImpl> helloCls = HelloImpl.class;

        try {
            Method publicMethod = helloCls.getMethod("sayHi", String.class);

            // Set private method accessible.
            Method privateMethod = helloCls.getDeclaredMethod("diHola");
            privateMethod.setAccessible(true);

            System.out.println(">>> Calling public and private methods by using reflection.");
            publicMethod.invoke(hello, "world");
            privateMethod.invoke(hello);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
