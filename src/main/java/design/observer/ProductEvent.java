package design.observer;

/**
 * 商品变化事件<br>
 * 只能通过提供的两种静态方法构造对象。
 * 包括两种事件：新发布商品和商品价格变动
 */
public class ProductEvent {

    /** 新商品上架 */
    public static final String NEW_PRODUCT_EVENT = "subscribe";
    /** 商品价格变动 */
    public static final String PRICE_CHANGE_EVENT = "price_change";

    /** 事件类型 */
    private final String event;

    private ProductEvent(String event) {
        this.event = event;
    }

    public String getEventType() {
        return event;
    }

    public static ProductEvent newProductEvent() {
        return new ProductEvent(NEW_PRODUCT_EVENT);
    }

    public static ProductEvent newPriceEvent() {
        return new ProductEvent(PRICE_CHANGE_EVENT);
    }
}
