package collection;

import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        testList();
        testMap();
        testTreeMap();
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

        // List 转化为 Array
        List<Integer> list3 = Arrays.asList(1, 3, 5, 7, 9);
        Integer[] array = list3.toArray(new Integer[list3.size()]); // 传入恰好一样大的数组
        for (Integer i : array) {
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.print("\n");
        System.out.println();

    }

    public static void testMap() {
        //* Map 是一种键值对形式的数据结构
        //* 类比 Python 的 Dict
        //* 最常见的实现类是 HashMap

        Student stu0 = new Student("Alice", 30);
        Student stu1 = new Student("Bob", 50);
        Map<String, Student> map = new HashMap<>();
        
        // 添加字符串和对象指针的映射
        map.put("Alice", stu0); 
        map.put("Bob", stu1);
        
        // 通过 key 查找对象
        Student tempStu = map.get("Alice"); 
        System.out.println(tempStu.name + " " + tempStu.score);
        System.out.print("Is the same object: ");
        System.out.println(tempStu == stu0); // true
        System.out.println();

        // 遍历 Map
        // 使用 for-each 遍历 Map 对象的 keySet() 方法返回的 Set 集合
        System.out.println("遍历 Map：for-each 通过 keySet() 遍历");
        for (String key : map.keySet()) {
            Student temp = map.get(key);
            System.out.print(temp.name + " " + temp.score + ", ");
        }
        System.out.print("\n");
        System.out.println();

        // 使用 for-each 遍历 Map 对象的 entrySet() 集合
        System.out.println("遍历 Map：for-each 通过 keySet() 遍历");
        for (Map.Entry<String, Student> entry : map.entrySet()) {
            String key = entry.getKey();
            Student temp = entry.getValue();
            System.out.print("key: " + key + ", name: " + temp.name + " " + temp.score + "; ");
        }
        System.out.print("\n");
        System.out.println();

        //* HashMap 内部对 key 的比较是通过作为 key 对象的 equals() 方法来实现的
        //* 作为 key 的对象必须正确覆写 equals() 和 hashCode() 方法
    }

    public static void testTreeMap() {
        //* SortedMap 是一个接口，实现类是 TreeMap
        //* TreeMap 保证遍历时按照 key 被加入的顺序来排序
        Map<String, Integer> map = new TreeMap<>();

        //* TreeMap 的 key 对象必须实现 Comparable 接口，或传入 Comparator
        //* 如果没有，创建 TreeMap 时需要实现一个自定义排序算法

        System.out.println("遍历 TreeMap：for-each 通过 keySet() 遍历");
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.print(key + ", ");
        }
        System.out.print("\n");
        System.out.println();

    }

    public static void testSet() {
        //* Set 用于存储不重复的元素，内部元素没有顺序
        //* 类比 Python 的 set()
        //* 最常用的实现类是 HashSet
        System.out.println("Set 添加，删除测试");

        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc")); // true
        System.out.println(set.add("xyz")); // true
        System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在
        System.out.println(set.contains("xyz")); // true，元素存在
        System.out.println(set.contains("XYZ")); // false，元素不存在
        System.out.println(set.remove("hello")); // false，删除失败，因为元素不存在
        System.out.println(set.size()); // 2，一共两个元素

        //* TreeSet 类似 TreeMap，保证内部元素有序
        //* TreeSet 和 TreeMap 的要求一样，都需要传入元素实现 Comparable 接口，或传入 Comparator 对象
    }

    public static void testQueue() {
        //* 先进先出的队列
        
    }
}

class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
