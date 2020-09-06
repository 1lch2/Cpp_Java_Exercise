package oo;

public class TestOO {
    public static void main(String[] args) {
        var someone = new Person("Dow Joe", 30);
        someone.getInfo();
        
        someone.hello();
        someone.hello("Hello world !");
        System.out.println(someone.toString());

        var studentone = new Student("A B", 20, 123456);
        studentone.getInfo();
        studentone.hello();

        // 子类可以指向为父类，但是反之不行
        Person temp = studentone;
        temp.getInfo();
        System.out.println(temp instanceof Person);

        System.out.print("\n------------------\n");

        /*
         * 定义了抽象方法后，可以直接通过抽象类引用具体类的实例 
         */
        BaseClass someobj = new RealClass("Sample");
        someobj.runMethod("World !");

        System.out.print("\n------------------\n");

        /*
         * 接口测试 
        */
        var testInterface = new TestInterface("World");
        testInterface.hello();
        testInterface.hola();
        testInterface.你好啊();
    }
}

class Person{
    protected String name;
    private String firstName;
    private String lastName;
    private int age;

    // 若指定了构造方法，则编译器不再自动生成空的构造方法，需要手动写出来
    public Person(){
        // name 成员是引用类型，初始化时赋值为 null
        // age 成员是基本类型，初始化时赋值为 0
    }


    public Person(String name, int age){
        this.name = name;
        this.age = age;

        this.firstName = name.split(" ")[0];
        this.lastName = name.split(" ")[1];
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name.strip();
    }

    public void setAge(int age){
        if (age < 0){
            throw new IllegalArgumentException("age cannot be negative.");
        }
        this.age = age;
    }

    public void getInfo(){
        System.out.println("Name: " +  this.name);
        System.out.println("Age: " + this.age);
    }

    //* 方法重载
    //* 多个同名方法，但是可以有不同参数，执行相同或相似功能
    public void hello(){
        System.out.println(this.firstName + " " + this.lastName);
    }

    public void hello(String greetingMsg){
        System.out.println(greetingMsg + " " + this.firstName + " " + this.lastName);
    }


    /*
     * 覆写 Object 方法
     */
    @Override
    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // 当类型相同且 name 字段相同时返回 true
        if (obj instanceof Person){
            Person temp = (Person) obj;
            return this.name.equals(temp.name);
        } else {
            return false;
        }
    }

    public final void noOverride() { // final 修饰的方法不能被继承的类覆写
        System.out.println("Can not override this method.");
    }
}

// final 修饰的类不允许被其他类继承
final class Student extends Person{
    private final int SID; // final 字段修饰的变量在初始化后不允许修改

    public Student(String name, int age, int id){
        // 子类不继承父类的构造方法
        // 子类的构造方法必须先调用父类的构造方法
        super(name, age); 
        this.SID = id;
    }

    public int getSid(){
        return this.SID;
    }

    // 子类覆写父类方法（Override）
    @Override // 返回值，参数，方法名都要相同
    public void hello(){
        System.out.println(this.name);
        // 或使用 super.name 来访问父类的 name 成员
    }
}