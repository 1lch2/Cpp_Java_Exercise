package org.bd.java_exercise.design.template;

public abstract class FirearmsReload {

    protected abstract void unloadMagazine();
    protected abstract void swapMagazine();
    protected abstract void loadMagazine();
    protected abstract void pullBoltHandle();

    public void reload() {
        System.out.println("Starting reloading.");

        unloadMagazine();
        swapMagazine();
        loadMagazine();
        pullBoltHandle();

        System.out.println("Gun reloaded.");
    }
}
