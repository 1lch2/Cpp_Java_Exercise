package design.run;

import design.adapter.AudioDevice;
import design.adapter.AudioToLightningAdapter;
import design.adapter.AudioWrapLightningAdapter;
import design.adapter.IPhone;

public class RunAdapterPattern {

    public static void main(String[] args) {
        IPhone iPhone = new IPhone();

        System.out.println(">>> Class adapter >>>");
        AudioWrapLightningAdapter classAdapter = new AudioWrapLightningAdapter();
        classAdapter.lightningAudio();

        System.out.println(">>> Object adapter >>>");
        AudioToLightningAdapter objectAdapter = new AudioToLightningAdapter(new AudioDevice());
        iPhone.play(objectAdapter); // Lightning device required by iPhone.
        objectAdapter.lightningAudio();
    }
}
