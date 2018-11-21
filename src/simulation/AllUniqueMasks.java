package simulation;

import game.DiscoveryTile;
import game.Mask;

import java.util.ArrayList;

public class AllUniqueMasks implements Case {
    @Override
    public boolean fulfillsCase(Selection selection) {
        ArrayList<Mask> uniqueMasks = selection.game.getUniqueMasks();
        for (Mask m: uniqueMasks) {
            if (!hasSpecificMask(selection, m)) {
                return false; // If the selection doesn't have a specific mask, it can't have all of them.
            }
        }
        return true; // If it passed all of the tests, then it does have all of the unique masks.
    }

    private boolean hasSpecificMask(Selection selection, Mask mask) {
        for (DiscoveryTile tile: selection.selectionTiles) {
            if (tile.equals(mask)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}
