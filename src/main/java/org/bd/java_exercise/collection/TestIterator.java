package org.bd.java_exercise.collection;

import java.util.*;

public class TestIterator {
    public static void main(String[] args) {
        ReverseList<String> rlist = new ReverseList<>();
        rlist.add("Apple");
        rlist.add("Orange");
        rlist.add("Pear");
        for (String s : rlist) {
            System.out.print(s);
            if (rlist.iterator().hasNext()){
                System.out.print(", ");
            } else {
                System.out.print("\n");
            }
        }
    }
}

class ReverseList<T> implements Iterable<T> {
    //* 集合类实现 Iterable 接口
    //* 接口要求返回一个 Iterator 对象，

    private List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        //* 这里必须返回一个 Iterator 对象
        return new ReverseIterator(list.size());
    }

    class ReverseIterator implements Iterator<T> {
        //* 通常用内部类来实现 Iterator 接口
        //* 必须覆写 hasNext 和 next 两个方法
        int index;

        ReverseIterator(int index) {
            this.index = index - 1;
        }

        @Override
        public boolean hasNext() {
            //* hasNext() 判断的 不是 是否还有下一个元素
            //* 而是当前下标是否超出范围
            return index >= 0;
        }

        @Override
        public T next() {
            //* 只有在调用 next() 时，下标才会移动
            T temp =  ReverseList.this.list.get(index); // 此处内部类通过 外部类名.this 访问到了外部类的成员
            index--;
            return temp;
        }
    }
}