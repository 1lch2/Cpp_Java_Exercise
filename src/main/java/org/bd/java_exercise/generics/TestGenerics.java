package org.bd.java_exercise.generics;

import java.util.List;
import java.util.ArrayList;

public class TestGenerics {
    public static void main(String[] args) {
        //* ArrayList<T> 可以向上转型为 List<T>，但是 T 不能变，不同的T之间也没有继承关系

        //* 编译器可以自动推断泛型的类型（T）
        List<String> list = new ArrayList<>(); //此处不需要写 <String>
        list.add("str0");
        list.add("str2");

        System.out.println(list.toString());
    }
}