package design.template;

public class PistolReload extends FirearmsReload{

    @Override
    protected void unloadMagazine() {
        System.out.println("[Pistol] Unload pistol magazine.");
    }

    @Override
    protected void swapMagazine() {
        System.out.println("[Pistol] Swap pistol mag.");
    }

    @Override
    protected void loadMagazine() {
        System.out.println("[Pistol] Fresh magazine going in.");
    }

    @Override
    protected void pullBoltHandle() {
        System.out.println("[Pistol] Pulling pistol sleeve.");
    }
}
