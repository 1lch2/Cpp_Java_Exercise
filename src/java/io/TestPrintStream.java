package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TestPrintStream {
    public static void main(String[] args) throws IOException{
        testReaderAndWriter();
    }

    public static void testReaderAndWriter() throws IOException{
        //* Reader 是一个输入流接口，以 char 为单位读取
        //* Reader 定义了所有字符输入流的超类
        // InputStream 以字节为单位读取

        //* FileReader 是 Reader 的一个子类，可以打开文件并获取 Reader
        System.out.println("FileReader 从文件中读取输入:");

        // Reader reader = new FileReader("src/java/io/sample.txt", StandardCharsets.UTF_8
        // 指定编码的参数在 Java 11 引入，Java 8 使用如下方法
        InputStream input = new FileInputStream("src/java/io/sample.txt");
        try (InputStreamReader reader = new InputStreamReader(input, "UTF-8")) {
            //* InputStreamReader 可以指定字符集参数，并接受一个 InputStream
            //* InputStreamReader 将任何 InputStream 转换为 Reader，本质上是 byte 到 char 的转换器


            while (true) {
                int n = reader.read(); // 反复调用 read 方法直到返回 -1
                if (n == -1) {
                    break;
                }
                System.out.print((char) n);
            }
        }
        System.out.println("\n");
    }
}