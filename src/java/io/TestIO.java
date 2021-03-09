package io;

import java.io.*;

public class TestIO {
    public static void main(String[] args) {
        testFile();
    }

    public static void testFile() {
        File f = new File("/Users/lichenghao02/Workspace/VSCode_workspace/Cpp_Java_Exercise/src/java/io/sample.txt");
        System.out.println(f.toString());
        System.out.println(f.isFile());

        // TODO: print file
    }
}