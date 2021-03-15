package io;

import java.io.*;
import java.nio.file.*;
import java.util.Properties;

public class TestIO {
    public static void main(String[] args) throws Exception{
        testFile();
        testProperty();
        testTraverse();
        testInputStream();
    }

    public static void testFile() {
        try {
            File f = new File("/Users/lichenghao02/Workspace/VSCode_workspace/Cpp_Java_Exercise/src/java/io/sample.txt");
            System.out.println("File path: " + f.toString());
            System.out.println(f.isFile());
            System.out.println("File size: " + f.length() + " byte");
    
            InputStream out = new FileInputStream(f);
            int size = out.available(); // 剩余可从输入流中读出的字节数

            System.out.println("Print file: ");
            for (int i = 0; i < size; i++) {
                System.out.print((char) out.read());
            }
            System.out.print("\n");
            out.close();
        
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println();
        }
        
    }

    public static void testProperty() throws Exception{
        // 从 .properties 文件中读取配置
        String settingFile = "/Users/lichenghao02/Workspace/VSCode_workspace/Cpp_Java_Exercise/src/java/io/settings.properties";
        Properties props = new Properties();
        props.load(new java.io.FileInputStream(settingFile));

        String option1 = props.getProperty("option1");
        String option2 = props.getProperty("option2");

        System.out.println("option1: " + option1 + ", option2: " + option2);
        System.out.println();
    }

    public static void testTraverse() {
        File d = new File("./"); //* 此处 ./ 表示的是项目根目录
        for (File f : d.listFiles()) {
            System.out.println(f);
        }

        System.out.println();
        
        Path path = Paths.get(".", "src", "java"); // 使用 Path 构造路径
        System.out.println(path);
        System.out.println("Absolute path: " + path.toAbsolutePath()); // 获取绝对路径
        System.out.println("Canonical Path: " + path.normalize()); // 获取标准路径

        System.out.println();
    }

    public static void testInputStream() throws IOException{
        // 一次读取一个字节
        try(InputStream input = new FileInputStream("src/java/io/sample.txt")) { 
            // try(resource) 语法可以让 JDK 自动添加关闭资源的语句
            // 前提是 resource 实现了 java.lang.AutoCloseable 接口
            int n;
            while ((n = input.read()) != -1) {
                System.out.print((char) n);
            }
            System.out.println();
        }

        // 利用缓冲区读取
        try (InputStream input = new FileInputStream("src/java/io/sample.txt")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input.read(buffer)) != -1) { // 读取到缓冲区，此时 n 返回的是读取的字节数
                System.out.println("read " + n + " bytes.");
                System.out.println(buffer.toString()); // TODO: print buffer to string
            }
        }
    }
}