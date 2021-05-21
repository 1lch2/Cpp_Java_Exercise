package org.bd.java_exercise.design.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现了观察者模型的商店类
 * <p>
 * 商店可以注册一系列订阅者（观察者），商店商品发生变动时发送通知给所有订阅者。
 */
public class Store implements ProductObservable {

    /** 订阅者列表 */
    private final List<ProductObserver> subscribers = new ArrayList<>();
    /** 商品列表 */
    private final Map<String, Product> products = new HashMap<>();

    @Override
    public void addObserver(ProductObserver observer) {
        this.subscribers.add(observer);
        System.out.println("[Store] New subscriber " + observer.getClass().getSimpleName() + " added.");
    }

    @Override
    public void removeObserver(ProductObserver observer) {
        this.subscribers.remove(observer);
        System.out.println("[Store] Subscriber " + observer.getClass().getSimpleName() + " removed.");
    }

    /**
     * 添加新商品并通知订阅者
     *
     * @param product 被添加的新商品
     */
    public void addNewProduct(Product product) {
        this.products.put(product.getName(), product);

        // 发送新增商品事件通知所有订阅者
        subscribers.forEach(o -> o.onEvent(ProductEvent.newProductEvent()));
    }

    /**
     * 修改指定商品的价格并通知订阅者
     *
     * @param name  被修改价格的商品名称
     * @param price 修改后的价格
     */
    public void setProductPrice(String name, int price) {
        Product changedProduct = products.get(name);
        changedProduct.setPrice(price);

        // 发送商品价格变化事件通知所有订阅者
        subscribers.forEach(o -> o.onEvent(ProductEvent.newPriceEvent()));
    }
}
