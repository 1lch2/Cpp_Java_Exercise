package org.bd.java_exercise.basics;

public class TestEnum {
    public static void main(String[] args) {
        Weekday day = Weekday.SAT;
        
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Free");
        } else {
            System.out.println("Work");
        }

        // name() 返回常量的名字
        System.out.println("Weekday.MON: " + Weekday.MON.name());

        // ordinal() 返回顺序
        System.out.println("Number of Weekday.SUN: " + Weekday.SUN.ordinal());


    }
}

/**
 * enum 本身也是 class (public final class)，可以定义 private 构造方法
 * enum 本身带有类型信息
 * 不同枚举类型不能互相比较
 */
enum Weekday {
    // 最基本的定义
    // MON, TUE, WED, THU, FRI, SAT, SUN;

    // 添加构造方法和字段
    MON(1, "星期一"),
    TUE(2, "星期二"),
    WED(3, "星期三"),
    THU(4, "星期四"),
    FRI(5, "星期五"),
    SAT(6, "星期六"),
    SUN(0, "星期日");

    public final int dayVal;
    private final String cnName;

    Weekday(int dayVal, String cnName) {
        this.dayVal = dayVal;
        this.cnName = cnName;
    }

    /**
     * name() 无法被覆写，给 Weekday 添加 toString() 方法，使得输出时更易读
     */
    @Override
    public String toString() {
        return this.cnName;
    }
}