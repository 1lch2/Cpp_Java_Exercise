package generics;

public class GenericesExtend {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);

        //* PairHelper 是 Pair<Number> 的子类，因此可以正常运行
        int sum = PairHelper.add(new Pair<Number>(1, 2));
        System.out.println(sum);

        System.out.println();

        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }
    
    static int add(Pair<? extends Number> p) { 
        // 这里的参数类型 Integer 是 Number 的子类
        // 但是泛型 Pair<Integer> 不是 Pair<Number> 的子类

        //* 使用 ? extends Number 可以使方法接受所有泛型类型为 Number 和 Number 的子类
        //* <? extends Number> 称为上界通配符
        //* 传入的泛型对象不一定能接受所有 Number 子类
        //* 例：Pair<Double> 无法接受 Integer，即使使用了Pair<? extends Number>

        //* Number 是可转换为 基本数字类型（int，long，short等）的超类，即 Integer，Double等
        //* 
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        //* Pair<? super Integer> 表示方法参数接受 Integer 以及 Integer 父类的类型
        
        //* 使用<? super Integer>通配符表示：
        //* 允许调用set(? super Integer)方法传入Integer的引用；
        //* 不允许调用get()方法获得Integer的引用。
        //* 唯一例外是可以获取Object的引用：Object o = p.getFirst()。
        //* 换句话说，使用<? super Integer>通配符作为方法参数，表示方法内部代码对于参数只能写，不能读。

        p.setFirst(n);
        p.setLast(n);
    }
}

class Pair<T> {
    //* 定义泛型时候，也可以用 Pair<T extends Number> 来限定 T 的类型

    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    
    public T getFirst() {
        return first;
    }
    
    public T getLast() {
        return last;
    }
    
    public void setFirst(T first) {
        this.first = first;
    }
    
    public void setLast(T last) {
        this.last = last;
    }
}

class PairHelper {
    static int add(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}
