package design.adapter;

/**
 * 类适配器。<br>
 * 将带3.5mm接口的设备类转接到Lightning接口的设备
 */
public class AudioWrapLightningAdapter extends AudioDevice implements LightningJack {

    @Override
    public void lightningAudio() {
        System.out.println("[Class adapter] Passing audio from 3.5mm jack to lightning jack.");

        // Convert method to suit target API
        this.transferAudio();
    }
}
