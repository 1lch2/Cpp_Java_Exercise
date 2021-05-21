package org.bd.java_exercise.generics;

public class SampleGenerics {
    public static void main(String[] args) {
        Pairs<Integer, String> pairs = new Pairs<>(10, "a");
        System.out.println(pairs.toString());
    }
}

/**
 * 自定义泛型
 * @param <T> 第一个对象
 * @param <K> 第二个对象
 */
class Pairs<T, K> {
    /*
     * Java 使用擦除法（Type Erasure）实现泛型
     * 编译器将<T>视为 Object，并根据 <T> 实现安全的强制转型
     * 
     * 泛型局限性
     * 1. <T> 不能是基本类型，如 int
     * 2. 无法取得泛型的 Class 对象（见反射部分）
     * 3. 无法判断带泛型的类型，例：不能用 instanceof 判断类型
     * 4. 不能实例化 T 类型
     */

    private T first;
    private K second;

    public Pairs(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return this.first;
    }

    public K getSecond() {
        return this.second;
    }

    @Override
    public String toString() {
        return first.toString() + ", " + second.toString();
    }

    //* 泛型类型 <T> 不能用于静态方法
    //* 若需要静态方法，需要改写泛型类型，
    //* 例：Pairs<T> 改写为 public static <K> Pairs <K> method(K first)
}

/*
 * 一个类可以继承自一个泛型类，需要泛型有具体的泛型类型 
 * 这里继承了泛型的类可以获取到父类的泛型类型，即 T
 */
class IntPairs extends Pairs<Integer, String> {
    public IntPairs(Integer first, String second) {
        super(first, second);
    }
}