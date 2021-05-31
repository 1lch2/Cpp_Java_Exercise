package org.bd.java_exercise.basics;

public class BufferedString {

    public static void main(String[] args) {
        testBufferedString();
        testBufferedString1();
        testStringBuilder();
        testStringLiteral();
    }

    private static void testBufferedString() {
        String str0 = new String("abc");
        String str1 = new String("abc");

        System.out.println(str0 == str1);       // false
    }

    private static void testBufferedString1() {
        String str2 = "abcdefghijk";
        String str3 = "abcdefghijk";
        String str4 = "ab" + "cdefghijk";
        String str5 = "cdefghijk";

        System.out.println(str2 == str3);       // true
        System.out.println(str2 == str4);       // true
        System.out.println(str2 == "ab" + str5);// false
    }

    private static void testStringBuilder() {
        StringBuilder builder = new StringBuilder("ab");
        String str0 = builder.append("c").toString();

        String str1 = "abc";
        String str2 = "ab" + "c";
        System.out.println(str0 == str1);       // false
        System.out.println(str1 == str2);       // true
    }

    private static void testStringLiteral() {
        String hello = "Hello";
        String lo = "lo";

        System.out.println(">>>>>>");
        System.out.println(hello == "Hello");             // true
        System.out.println(hello == ("Hel" + "lo"));      // true
        System.out.println(hello == ("Hel" + lo));        // false
        System.out.println(hello == ("Hel" + lo).intern());// true
    }

}
