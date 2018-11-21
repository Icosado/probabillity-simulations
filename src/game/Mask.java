package game;

public class Mask extends DiscoveryTile {
    public int numberOfMasks;

    public Mask(String maskName, int numberOfMasks) {
        super();
        this.name = "Mask" + maskName;
        this.numberOfMasks = numberOfMasks;
    }

    @Override
    public boolean isMask() {
        return true;
    }
}
