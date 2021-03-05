package generics;

public class GenericesExtend {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);

        //* PairHelper 是 Pair<Number> 的子类，因此可以正常运行
        int sum = PairHelper.add(new Pair<Number>(1, 2));
        System.out.println(sum);
    }
    
    static int add(Pair<? extends Number> p) { 
        // 这里的参数类型 Integer 是 Number 的子类
        // 但是泛型 Pair<Integer> 不是 Pair<Number> 的子类

        //* 使用 ? extends Number 可以使方法接受所有泛型类型为 Number 和 Number 的子类
        //* <? extends Number> 称为上界通配符
        //* 

        //* Number 是可转换为 基本数字类型（int，long，short等）的超类，即 Integer，Double等
        //* 
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}

class Pair<T> {
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
}

class PairHelper {
    static int add(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}
