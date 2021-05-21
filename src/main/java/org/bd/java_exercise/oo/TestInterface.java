package org.bd.java_exercise.oo;

interface Hello{
    /*
     * 接口是抽象类的一种，没有字段，只有抽象方法的定义
     * 接口定义方法默认 abstract public 
     */
    void hello();
    String getName();

    /* 
     * default 方法可以不用覆写 
     */
    default void bye() {
        System.out.println("Bye~");
    }
}

interface Hola{
    void hola();
}

interface 你好{
    void 你好啊();
}

// public 关键字定义的实现接口的类必须在它自己的文件里
public class TestInterface implements Hello, Hola, 你好{
    /*
     * 使用 implements 来实现接口 
     * 类只能继承自一个类，但是可以继承自多个接口
     */

    private String name;

    public TestInterface(String name){
        this.name = name;
    }


    @Override
    public void hello() {
        System.out.println("Hello " + this.name);
    }

    @Override
    public void hola() {
        System.out.println("Como estas " + this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void 你好啊(){
        System.out.println("你好 " + this.name);
    }
}