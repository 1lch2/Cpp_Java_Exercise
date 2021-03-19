package io;

import java.io.*;
import java.util.Arrays;

public class TestSerialize {
    public static void main(String[] args) throws IOException{
        testSerializable();
    }

    public static void testSerializable() throws IOException{
        //* 序列化 (Serialize) 是指把一个 Java 对象变成二进制内容，即一个 byte[] 数组
        //* 通过序列化，Java 对象可以保存到文件中，或通过网络传输到远程位置

        //* 一个 Java 对象必须实现 Serializable 接口才能被序列化
        // Serializable 接口并没有定义任何方法，称之为标记接口 (Marker Interface)

        System.out.println("序列化输出整数，字符串和 Java 对象");

        ByteArrayOutputStream buffer_out = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer_out)) {
            output.writeInt(65535);
            output.writeUTF("yes");
            output.writeObject(Double.valueOf(3.14159265)); // 此处用包装类并没有必要
        }
        System.out.println("ObjectOutputStream: " + Arrays.toString(buffer_out.toByteArray()));
        System.out.println();

        System.out.println("将字节流反序列化");

        ByteArrayInputStream buffer_in = new ByteArrayInputStream(buffer_out.toByteArray());
        try (ObjectInputStream input = new ObjectInputStream(buffer_in)) {
            int n = input.readInt();
            String str = input.readUTF();
            Double d = (Double) input.readObject(); // 此处必须捕获 ClassNotFoundException

            System.out.println("n: " + n + "; str: " + str + "; Double: " + d);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();        
    }
}