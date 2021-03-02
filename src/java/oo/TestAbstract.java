package oo;

abstract class BaseClass{
    /*
     * 抽象类本身不能执行，只能用于继承
     * 抽象类可以强制子类实现它定义的抽象方法
     * 抽象类中不一定有抽象方法，但是抽象方法必定在抽象类中
    */
    protected final String name;

    // 抽象类的构造方法并不能构造对象
    public BaseClass(String name){
        this.name = name;
    }

    public abstract void runMethod(String name);
}


class RealClass extends BaseClass{
    // 必须重写构造方法
    public RealClass(String name){
        super(name);
    }

    @Override
    public void runMethod(String name) {
        System.out.println("Hello " + name);
    }
}