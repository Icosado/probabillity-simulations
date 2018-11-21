package simulation;


import game.DiscoveryTile;
import game.Game;
import game.Mask;

import java.util.ArrayList;
import java.util.Random;

/**
 * Holds a randomized, possible assortment of one game.
 */
public class Deck {
    public ArrayList<DiscoveryTile> tiles;
    private Game game;
    private Random rng;

    public Deck(Game game) {
        this.tiles = new ArrayList<>();
        this.game = game;
        this.rng = new Random();
        randomlyAssort();
    }

    private void randomlyAssort() {
        // Insert all the masks for a total of (masksTotal) masks in the tile list.
        for (Mask mask: game.getUniqueMasks()) {
            for (int i = 0; i < mask.numberOfMasks; ++i) {
                randomlyInsertTile(mask, tiles);
            }
        }

        // Insert the remaining non-mask selectionTiles: (masksTotal) + (total selectionTiles - masksTotal) = (total selectionTiles)
        //                                       equivalent to (non-mask selectionTiles)
        for (int i = 0; i < (game.discoveryTiles() - game.masksTotal()); ++i) {
            randomlyInsertTile(new DiscoveryTile(), tiles);
        }
    }

    private void randomlyInsertTile(DiscoveryTile tile, ArrayList<DiscoveryTile> tiles) {
        // Insert the tile randomly at any of the possible indices of the deck: from 0 (the first position) to size() (the end of the list).
        // nextInt(bound) does not include bound in the possible values; thus, + 1.
        tiles.add(rng.nextInt(tiles.size() + 1), tile);
    }

    public void put(int startingSelection, ArrayList<DiscoveryTile> selectionTiles) {
        // After the selectionTiles are shuffled initially, they are simply drawn off of the top.
        // (game) is preserved. Although selectionTiles are drawn without replacement, they are simply taken sequentially, and not removed.
        for (int i = 0; i < startingSelection; ++i) {
            selectionTiles.add(this.tiles.get(i));
        }
    }
}
