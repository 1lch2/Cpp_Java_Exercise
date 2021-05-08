package design.observer;

/**
 * 抽象观察者接口
 */
public interface ProductObserver {

    /**
     * 注册的观察者在接受到事件时触发的动作
     *
     * @param event 触发观察者动作的事件
     */
    void onEvent(ProductEvent event);
}
