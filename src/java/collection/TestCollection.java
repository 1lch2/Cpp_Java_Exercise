package collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TestCollection {
    public static void main(String[] args) {
        testList();
    }

    public static void testList() {
        //* List 是一种基本的有序表，本身是接口，有多种实现，如 ArrayList，LinkedList
        //* 类比 Python 的 List 和 手动实现的链表

        // 向 List 添加元素
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add(0, "zero");
        list.add(null);
        System.out.println("ArrayList list: " + list.toString());
        System.out.println();

        // 创建 List
        List<Integer> list0 = Arrays.asList(1, 1, 2, 3, 5);
        System.out.println("ArrayList list0: " + list0.toString());
        System.out.println();

        // 遍历 List (迭代器)
        System.out.println("遍历 ArrayList：迭代器");
        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            String s = itr.next();
            System.out.print(s + ", ");
        }
        System.out.print("\n");
        System.out.println();

        // 遍历 List (for each)
        //* 只要实现了 Iterable 接口的类都可以用 for each来循环
        System.out.println("遍历 ArrayList：for each 循环");
        for (String temp : list) {
            //* 类比 Python 的 for in
            System.out.print(temp + ", ");
        }
        System.out.print("\n");
        System.out.println();

    }
}