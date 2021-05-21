package org.bd.java_exercise.design.adapter;

/**
 * 需要引用lightning接口对象的类
 */
public class IPhone {

    public void play(LightningJack earpiece) {
        earpiece.lightningAudio();
    }
}
