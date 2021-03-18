package io;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFiles {
    public static void main(String[] args) throws IOException{
        testFiles();
    }

    public static void testFiles() throws IOException{
        //* 使用 Files 将文件读成 String
        
        // readString 从 Java 11 开始才有
        // String file_content = Files.readString(Paths.get("src/java/io/sample.txt"));
        System.out.println("使用 Files 将文件读成 List<String>:");

        List<String> lines = Files.readAllLines(Paths.get("src/java/io/sample.txt"));
        System.out.println("Multi-line: " + lines.toString());
    }
}