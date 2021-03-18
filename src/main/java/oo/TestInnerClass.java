package oo;

public class TestInnerClass {
    public static void main(String[] args) {
        Outer outerClass = new Outer("CLASS");
        Outer.Inner innerClass = outerClass.new Inner(); // 内部类需要通过实例化的外部类来创建对象

        innerClass.hi();

        Outer.StaticNested sn = new Outer.StaticNested(); // 静态内部类需要通过外部类实例化
        sn.hello();
    }
}

class Outer {
    private String name;
    private static String NAME = "Monsieur";

    Outer(String name) {
        this.name = name;
    }

    /**
     * 内部类，可以访问外部类的 private 字段
     */
    class Inner {
        void hi(){
            System.out.println("Hello, " + name);
        }
    }

    /**
     * 静态内部类
     * 静态内部类不依附于外部类，无法通过外部类的实例来访问
     * 但是静态内部类可以访问外部类的 static 字段以及方法
     */
    static class StaticNested {
        void hello() {
            System.out.println("Bonjour, " + Outer.NAME);
        }
    }
}