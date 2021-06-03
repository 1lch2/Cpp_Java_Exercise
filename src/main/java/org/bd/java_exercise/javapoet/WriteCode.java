package org.bd.java_exercise.javapoet;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.IOException;

public class WriteCode {

    public static void main(String[] args) {
        try {
            writeJava("Hello", "hello world!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJava(String className, String msg) throws IOException {
        // 声明方法
        MethodSpec main = MethodSpec.methodBuilder("main") // 方法名
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)  // 方法的修饰
                .returns(void.class)                             // 返回值类型
                .addParameter(String[].class, "args")      // 方法参数
                .addStatement("$T.out.println($S)", System.class, msg) // 语句
                .build();

        // 声明主类
        TypeSpec hello = TypeSpec.classBuilder(className) // 类名
                .addModifiers(Modifier.PUBLIC)            // 类的修饰
                .addMethod(main)                          // 类的方法
                .build();

        // 指定文件的包
        JavaFile javaFile = JavaFile.builder(WriteCode.class.getPackage().getName(), hello).build();

        // 输出到标准输出流
        javaFile.writeTo(System.out);
    }
}
