package org.bd.java_exercise.design.adapter;

/**
 * 对象适配器
 */
public class AudioToLightningAdapter implements LightningJack {

    private AudioDevice audioDevice;

    public AudioToLightningAdapter(AudioDevice audioDevice) {
        this.audioDevice = audioDevice;
    }

    @Override
    public void lightningAudio() {
        System.out.println("[Object adapter] Passing audio from plugged 3.5mm jack to lightning.");
        this.audioDevice.transferAudio();
    }
}
