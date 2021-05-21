package org.bd.java_exercise.design.run;

import org.bd.java_exercise.design.factory.*;

public class RunAbstractFactoryPattern {

    public static void main(String[] args) {
        System.out.println(">>> Mi factory >>>");

        // Mi factory
        ProductFactory miFactory = new MiProductFactory();

        //生产小米路由器
        RouterProduct miRouter = miFactory.makeRouter();

        // Run
        miRouter.powerOn();
        miRouter.wifiOn();
        miRouter.powerOff();

        //生产小米手机
        PhoneProduct miPhone = miFactory.makePhone();
        miPhone.boot();
        miPhone.run();
        miPhone.shutdown();

        System.out.println(">>> Huawei factory >>>");

        //华为产品工厂实例
        ProductFactory huaweiFactory = new HuaweiProductFactory();

        //生产华为路由器
        RouterProduct huaweiRouter = huaweiFactory.makeRouter();
        huaweiRouter.powerOn();
        huaweiRouter.wifiOn();
        huaweiRouter.powerOff();

        //生产华为手机
        PhoneProduct huaweiPhone = huaweiFactory.makePhone();
        huaweiPhone.boot();
        huaweiPhone.run();
        huaweiPhone.shutdown();
    }
}
