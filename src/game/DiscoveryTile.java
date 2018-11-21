package game;

public class DiscoveryTile {
    public String name;
    public DiscoveryTile() {
        this.name = "Generic Tile";
    }
    public boolean isMask() {
        return false;
    }
    public boolean equals(DiscoveryTile other) {
        return this.name.equals(other.name);
    }

    public String toString() {
        return this.name;
    }
}
