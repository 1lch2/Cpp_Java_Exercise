package reflection;

public class TestReflection {
    public static void main(String[] args) {
        //* 通过类的静态变量获取
        Class cls0 = FireArm.class;

        //* 通过类的某个实例获取
        Pistol m9 = new Pistol(15);
        Class cls1 = m9.getClass();

        //* 通过完整类名获取
        // Class cls2 = Class.forName("java.lang.String");
        // TODO: ClassNotFoundException

        // 打印信息
        printClassinfo(cls0);
        System.out.println();
        printClassinfo(cls1);
        // printClassinfo(cls2);
    }

    /**
     * 打印传入的Class实例的信息
     * @param cls Class 对象的实例
     */
    private static void printClassinfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }

}

class FireArm {
    private int magzine;

    public FireArm (int magzine){
        this.magzine = magzine;
    }
}

class Pistol extends FireArm {
    public Pistol(int magzine) {
        super(magzine);
    }

    public void fire() {
        System.out.println("Pew!");
    }
}