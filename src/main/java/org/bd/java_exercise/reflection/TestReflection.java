package org.bd.java_exercise.reflection;

import java.util.Arrays;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class TestReflection {
    public static void main(String[] args) throws Exception{
        //* 通过类的静态变量获取
        Class cls0 = FireArm.class;

        //* 通过类的某个实例获取
        Pistol m9 = new Pistol(15);
        Class cls1 = m9.getClass();

        //* 通过完整类名获取
        // Class cls2 = Class.forName("java.lang.String");
        // TODO: ClassNotFoundException

        // 打印信息
        printClassInfo(cls0);
        printClassInfo(cls1);
        // printClassInfo(cls2);

        // 打印方法的信息
        printClassMethodInfo(cls1);

        /*
         * 先通过类获取到 Class对应的 Method对象
         * 再通过对应的实例调用获取到的Method对象对应的方法
         * 调用静态方法时，invoke() 的第一个参数为 null，第二个参数为方法的参数
         */
        Method m = Pistol.class.getMethod("fire"); 
        System.out.println(m.invoke(m9)); 

        Method m1 = Pistol.class.getMethod("getType");
        System.out.println(m1.invoke(null));

        /*
         * 调用 private 方法还需要使用 m.setAccessible(true)
         */

        /*
         * 通过反射来创建新对象
         */
        // Pistol degal = Pistol.class.newInstance(); // 只能调用无参数的构造方法
        
        // 通过 Constructor 获取目标类的构造方法 Integer(int)
        Constructor cons1 = Integer.class.getConstructor(int.class); 
        Integer n = (Integer) cons1.newInstance(10);
        System.out.println(n);

        /*
        * 获取父类的 Class 对象
        */
        Class pistolClass = Pistol.class;
        Class firearmClass = pistolClass.getSuperclass();
        Class baseClass = firearmClass.getSuperclass();

        System.out.println(pistolClass);
        System.out.println(firearmClass);
        System.out.println(baseClass);
    }

    /**
     * 打印传入的Class实例的信息
     * @param cls Class 对象的实例
     */
    private static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
        System.out.println();
    }

    /**
     * 获取类的方法的信息
     */
    private static void printClassMethodInfo(Class cls) {
        System.out.println(Arrays.toString(cls.getMethods())); // 获取所有 public 方法，包括父类
        System.out.println(Arrays.toString(cls.getDeclaredMethods())); // 获取所有 private 方法，结果不包括父类
        System.out.println();
    }
}

class FireArm {
    public int magzine;

    public FireArm (int magzine){
        this.magzine = magzine;
    }

    public void reload() {
        System.out.printf("Reloading ammo! Magzine size: %d", this.magzine);
    }
}

class Pistol extends FireArm {
    public Pistol(int magzine) {
        super(magzine);
    }

    public String fire() {
        return "Pew!";
    }

    public static String getType() {
        return "Pistol";
    }
}