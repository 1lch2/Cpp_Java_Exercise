package basics;

import java.util.Arrays;

public class TestVariableTypes {
    public static void main(final String[] args) {
        // Java 基本类型，赋值时使用传值操作
        // 变量必须先初始化再引用

        // * Java 各基础类型的位数，最大值和最小值
        // * 来源：https://www.runoob.com/java/java-basic-datatypes.html
        BasicTypes.printInfo();

        BasicTypes.printArray();
    }
}

class BasicTypes {
    // 静态方法，不通过实例对象调用
    public static void printInfo() {
        // * byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE); // 8
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // * short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE); // 16
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // * int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE); // 32
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // * long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE); // 64
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // * float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // * double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // * char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE=" + (int) Character.MIN_VALUE); // \u0000
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE=" + (int) Character.MAX_VALUE); // \uffff
    }

    public static void printArray() {
        final int[] intArray = new int[5];

        for (int i = 0; i < intArray.length; i++){
            intArray[i] = 1 << i;
        }
        System.out.println("\nintArray[5]: " + Arrays.toString(intArray) );
        System.out.println("Address of intArray: " + intArray); 
    }
}