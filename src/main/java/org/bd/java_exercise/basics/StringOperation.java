package org.bd.java_exercise.basics;

import java.util.StringJoiner;

public class StringOperation {
    public static void main(String[] args) {
        /**
         * StringBuilder 构造字符串
         */
        // 使用 + 拼接字符串，会导致循环操作时每次都新建对象，耗费内存
        String plusSignStr = "";
        for (int i = 0; i < 100; i++) {
            plusSignStr = plusSignStr + "->" + i;
        }
        System.out.println("使用 + 拼接字符串");
        System.out.println(plusSignStr);
        System.out.println();

        // 使用 StringBuilder 作为可变对象来构造字符串
        StringBuilder strBuilderStr = new StringBuilder(128);
        for (int i = 0; i < 100; i ++) {
            strBuilderStr.append(",");
            strBuilderStr.append(i);
        }
        System.out.println("使用 StringBuilder 拼接字符串");
        System.out.println(strBuilderStr.toString());
        System.out.println();

        /**
         * StringJoiner 构建字符串
         */
        String[] strArray = {"Ash", "Blitz", "Frost", "Tachanka"};

        StringJoiner sj = new StringJoiner(",", "[ ", " ]"); // 参数分别是 分隔符，开头和结尾字符
        for (String name : strArray) {
            sj.add(name);
        }
        System.out.println("使用 StringJoiner 连接字符串数组");
        System.out.println(sj.toString());

        // 不需要指定开头结尾时候，直接用 String.join()
        System.out.println(String.join(",", strArray));
    }
}