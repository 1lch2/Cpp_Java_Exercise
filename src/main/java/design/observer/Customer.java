package design.observer;

/**
 * 消费者类<br>
 * 实现了观察者接口，代表订阅商店消息的观察者。
 */
public class Customer implements ProductObserver {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void onEvent(ProductEvent event) {
        String eventType = event.getEventType();

        switch (eventType) {
            case ProductEvent.NEW_PRODUCT_EVENT:
                System.out.println("[" + this.name + "] " + "Notified by new product.");
                break;

            case ProductEvent.PRICE_CHANGE_EVENT:
                System.out.println("[" + this.name + "] " + "Notified by price changing.");
                break;

            default:
                throw new IllegalArgumentException("Wrong event type!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
