package design.proxy;

/**
 * 组合方式实现的静态代理<br>
 * 此处也可以是继承后通过super调用目标函数
 */
public class AutomobileProxy implements Vehicle {

    private Automobile automobile;

    public AutomobileProxy(Automobile automobile) {
        this.automobile = automobile;
    }

    @Override
    public void move() {
        // 此处类似AOP，为原本的方法增加其他功能，如权限检查等
        System.out.println("[Proxy] Proxy runs.");
        this.automobile.move();
    }
}
