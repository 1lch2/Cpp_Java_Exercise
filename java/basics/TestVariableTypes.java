package basics;

import java.util.Arrays;

public class TestVariableTypes {
    public static void main(final String[] args) {
        // Java 基本类型，赋值时使用传值操作
        // 变量必须先初始化再引用

        BasicTypes.printInfo(); // 基础类型信息
        // BasicTypes.printArray(); // 打印数组和数组地址
        // BasicTypes.testOverflow(); // 测试整数溢出
        // BasicTypes.testTypeConvert(); // 测试强制类型转换
        WrapperTypes.testWrapperTypes(); // 测试包装类型
    }
}

class BasicTypes {
    /*
    * Java 基本类型 (Primitive Types)
    * 基本类型的赋值是传值操作，使用 = 即可将一个变量的值传给另一个变量
    * 若使用 = 在对象之间进行赋值，则实际上是传递了对应的内存指针，被引用的对象修改时，引用的对象也会随之而变
    */
    // 静态方法，不通过实例对象调用
    public static void printInfo() {
        System.out.println("----------基本类型----------");

        // * Java 各基础类型的位数，最大值和最小值
        // * 来源：https://www.runoob.com/java/java-basic-datatypes.html

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
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE); //32
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // * double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE); //64
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // * char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE); //16
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE=" + (int) Character.MIN_VALUE); // \u0000
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE=" + (int) Character.MAX_VALUE); // \uffff
        System.out.println();

    }

    public static void printArray() {
        System.out.println("----------数组类型----------");

        /*
        * 打印数组的多种方法
        */
        int[] intArray = new int[5]; 

        for (int i = 0; i < intArray.length; i++){
            intArray[i] = 1 << i;
        }
        System.out.println("\nintArray[5]: " + Arrays.toString(intArray) );
        System.out.println("Address of intArray: " + intArray); 

        intArray = new int[] {1, 2, 3, 5, 7, 11};
        System.out.println("\n对基本类型元素的数组进行赋值，结果是在新的地址存放内容");
        System.out.println("Address of intArray: " + intArray);

        String[] stringArray = new String[] {"00", "01", "10", "11"};
        System.out.println("\n对引用类型元素的数组进行赋值，结果是在对应下标连续存放字符串的指针");
        System.out.println("对数组元素进行修改，结果是在新的内存地址存入字符串，然后修改对应下标的指针");
        System.out.println("Address of stringArray: " + stringArray);

        String ref = stringArray[0]; // 此处是将对应元素的指针赋值给了 ref 
        System.out.println(ref);

        stringArray[0] = "modified";
        System.out.println("\n对原始数组元素进行修改，不影响通过 = 进行赋值的变量");
        System.out.println("因此在对原数组修改元素后，通过变量 ref 仍然能访问到修改前的内容");;
        System.out.println("stringArray[0]: " + stringArray[0]);
        System.out.println("ref: " + ref);

        // for each 循环类似 Python的 for in循环
        System.out.println("\nfor each 循环");
        for (int i : intArray){
            System.out.printf("%d ", i);
        }

        /*
         * 二维数组 
         */
        int[][] twoDArray = {
            {0, 1, 2},
            {2, 3, 4},
            {4, 5, 6, 7}
        };

        // 可以使用两层循环遍历二维数组
        // 或者直接使用 Arrays 的内建方法转换成字符串
        System.out.println("\n2D array:" + Arrays.deepToString(twoDArray));
    }

    public static void testOverflow() {
        /*
         * 测试整数溢出 
         */
        int num = 0x7fffffff;
        
        // Java 中整数采用补码表示，32位正整数最大值再加 1 会溢出到负值
        System.out.println("\nJava正整数溢出：");
        System.out.println("0 111 1111 1111 1111 1111 1111 1111 1111: " + num);
        System.out.println("1 111 1111 1111 1111 1111 1111 1111 1110: " +  (num+1));
    }

    public static void testTypeConvert() {
        /*
         * 测试类型转换 
         */
        int num = 0x0000037f;
        byte num_ = (byte) num;

        System.out.println("\nJava 强制类型转换，位数多的转少的会舍弃高位：");
        System.out.println("0 000 0000 0000 0000 0000 0011 0111 1111: " + num);
        System.out.println("0 111 1111: " + num_);

        num = 0x000001ff;
        num_ = (byte) num;
        /*
        * Java 使用补码表示，补码为反码+1
        * 1111 1111 作为 8 位整数，先-1，
        * 再除符号位外按位取反，得到 1 000 0001，即 -1
        */

        System.out.println("0 000 0000 0000 0000 0000 0001 1111 1111: " + num);
        System.out.println("1 111 1111: " + num_); 
    }
}

class WrapperTypes{
    /*
     * Java 包装类型 
     * 包装类本质是一个对象，含有属性和方法
     * 包装类可以定义泛型（Generics）
     * 包装类支持序列化（Serializable）
     * 包装类提供了类型转换方法
     */

    public static void testWrapperTypes() {
        System.out.println("----------包装类型----------");

        /* 
        * Integer 
        */

        // 包装类型和基本类型的拆箱与装箱（Autoboxing and Unboxing）
        Integer intNum = 10; // 装箱：调用 Integer.valueOf(10)
        int x = intNum;      // 拆箱：调用 intNum.intValue()

        // 在 Java 9 之后已经废弃的构造方法
        // Integer numA = new Integer(10);

        // 一般使用
        Integer numA = Integer.valueOf(10);
        System.out.println("numA == inNum : ");
        System.out.println(numA == intNum); // true
        System.out.println();

        /*        
        * String
        */
        
        // 在创建String对象时，若已有相同的缓存对象，则直接返回引用
        String str = "string";
        String str_2 = str;

        System.out.println("Is equal: str == str_2: "); 
        System.out.println(str == str_2);
        System.out.println();

        // new 会直接创建一个新对象
        String new_str = new String("string");

        System.out.println("Is equal: str == new_str: ");
        System.out.println(str == new_str);
        System.out.println();

        // 字符串截取
        System.out.println("原字符串：" + str);
        System.out.println("使用substring()截取，左开右闭，原理同Python的切片：" + str.substring(1,3));

        // String 本身不可变，使用变量赋值只是更改了指针
        String s1 = "first";
        String s2 = s1; // 此时 s2 指向 “first”

        s1 = "second";
        System.out.println("s2 的引用没有变化，依然指向内存中存储 “first” 的地址\n" + "s2: " + s2);

        // 格式化字符串
        // 格式化符同C语言
        String formatted_str = String.format("Name: %s, Age: %d", "John", 24);
    }
}