package simulation;

import game.DiscoveryTile;

/**
 * Problem 1
 */
public class AtLeastOneMask implements Case {
    @Override
    public boolean fulfillsCase(Selection selection) {
        for (DiscoveryTile tile: selection.selectionTiles) {
            if (tile.isMask()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}
