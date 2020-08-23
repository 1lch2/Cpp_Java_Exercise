package basics;

import java.util.Scanner;

public class TestFlowControl {
    public static void main(String[] args) {
        BasicIO.testPrintf();
        BasicIO.testInput();
        BasicIO.testCondition();
    }
}

class BasicIO {
    public static void testPrintf() {
        // 格式化输出
        char s = 'a'; // String 用双引号，char 用单引号
        int i = 97;
        System.out.printf("String: %c\n", s);
        System.out.printf("int: %c\n", i); // Java 可以将整数作为ACSII字符输出，反过来不行
    }

    public static void testInput() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine(); // 读取一行输入，以回车为结束符号
        System.out.println("inputString: " + inputString);
        scanner.close(); // 使用 close() 避免警告
    }

    public static void testCondition() {
        // 浮点数在计算机中无法精确表示
        // 为避免浮点数作为判断条件导致错误，应该使用某个临界值判断
        final float DELTA = 1e-6f;
        int a = 1;
        if (a - 0.9 == 0.1){
            System.out.println("a / 10 = 0.1");
        } else {
            System.out.println("a / 10 != 0.1"); // 实际情况
        } 

        if (a - 0.9 - 0.1 < DELTA ){
            System.out.println("a / 10 - 0.1 < 10^-6");
        }

        String s1 = "string";
        String s2 = "string";

        // s1 和 s2 指向内存中同一块区域
        if (s1 == s2){
            System.out.println("s1 == s2");
            System.out.println("s1 address: " + System.identityHashCode(s1));
            System.out.println("s2 address: " + System.identityHashCode(s2));
        } else{
            System.out.println("s1 != s2");
        }

        String s3 = "STRING".toLowerCase();

        // s1 和 s3 内容完全一致，但是两者不是同一个对象，因此不相等
        if (s1 == s3){
            System.out.println("s1 == s3");
            System.out.println("s1 address: " + System.identityHashCode(s1));
            System.out.println("s3 address: " + System.identityHashCode(s3));
        } else {
            System.out.println("s1 != s3");
            System.out.println("s1 address: " + System.identityHashCode(s1));
            System.out.println("s3 address: " + System.identityHashCode(s3));
        }
        
        // 使用 equals() 方法判断值是否相等
        // 方法的调用对象不能为 null
        if (s1.equals(s3)){
            System.out.println("s1.equals(s3) == true");
        }
    }
}