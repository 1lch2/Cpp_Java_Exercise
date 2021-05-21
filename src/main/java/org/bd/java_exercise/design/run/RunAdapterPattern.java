package org.bd.java_exercise.design.run;

import org.bd.java_exercise.design.adapter.AudioDevice;
import org.bd.java_exercise.design.adapter.AudioToLightningAdapter;
import org.bd.java_exercise.design.adapter.AudioWrapLightningAdapter;
import org.bd.java_exercise.design.adapter.IPhone;

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
