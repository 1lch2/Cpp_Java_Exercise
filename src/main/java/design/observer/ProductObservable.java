package design.observer;

/**
 * 抽象观察者接口
 */
public interface ProductObservable {

    /**
     * 增加观察者
     *
     * @param observer 被添加的观察者对象
     */
    void addObserver(ProductObserver observer);

    /**
     * 移除观察者
     *
     * @param observer 被移除的观察者对象
     */
    void removeObserver(ProductObserver observer);
}
