package design.iterator;

/**
 * 自定义的迭代器接口
 */
public interface CustomizedIterator {

    /**
     * 返回当前遍历过程的下一个元素
     *
     * @return 下一个元素
     */
    Object next();

    /**
     * 判断是否还有未遍历元素
     *
     * @return 是否有未遍历元素
     */
    boolean hasNext();
}
