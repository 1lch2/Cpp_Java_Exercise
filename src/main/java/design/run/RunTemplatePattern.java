package design.run;

import design.template.FirearmsReload;
import design.template.PistolReload;

public class RunTemplatePattern {

    public static void main(String[] args) {
        FirearmsReload reload = new PistolReload();
        reload.reload();
    }
}
