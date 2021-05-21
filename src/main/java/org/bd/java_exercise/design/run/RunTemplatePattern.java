package org.bd.java_exercise.design.run;

import org.bd.java_exercise.design.template.FirearmsReload;
import org.bd.java_exercise.design.template.PistolReload;

public class RunTemplatePattern {

    public static void main(String[] args) {
        FirearmsReload reload = new PistolReload();
        reload.reload();
    }
}
