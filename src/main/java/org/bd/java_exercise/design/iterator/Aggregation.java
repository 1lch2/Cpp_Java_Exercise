package org.bd.java_exercise.design.iterator;

/**
 * 自定义的集合接口
 */
public interface Aggregation {

    /**
     * 添加元素
     *
     * @param obj 被添加的元素
     */
    void add(Object obj);

    /**
     * 移除元素
     *
     * @param obj 被移除的元素
     */
    void remove(Object obj);

    /**
     * 获取对应的迭代器
     *
     * @return 迭代器对象
     */
    CustomizedIterator getIterator();
}
