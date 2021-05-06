package design.factory;

public class HuaweiRouter implements RouterProduct {

    @Override
    public void powerOn() {
        System.out.println("Huawei router power up.");
    }

    @Override
    public void wifiOn() {
        System.out.println("Huawei router WiFi on.");
    }

    @Override
    public void powerOff() {
        System.out.println("Huawei router shutdown.Pro");
    }
}
