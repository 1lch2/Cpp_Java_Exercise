package io;

import java.io.*;
import java.util.Properties;

public class TestIO {
    public static void main(String[] args) throws Exception{
        testFile();
        testProperty();
    }

    public static void testFile() {
        File f = new File("/Users/lichenghao02/Workspace/VSCode_workspace/Cpp_Java_Exercise/src/java/io/sample.txt");
        System.out.println(f.toString());
        System.out.println(f.isFile());

        // TODO: print file
    }

    public static void testProperty() throws Exception{
        String settingFile = "/Users/lichenghao02/Workspace/VSCode_workspace/Cpp_Java_Exercise/src/java/io/settings.properties";
        Properties props = new Properties();
        props.load(new java.io.FileInputStream(settingFile));

        String option1 = props.getProperty("option1");
        String option2 = props.getProperty("option2");

        System.out.println("option1: " + option1 + ", option2: " + option2);
        System.out.println();
    }
}