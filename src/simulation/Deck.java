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
        this.game = game;
        rng = new Random();
    }

    private void randomlyAssort() {
        // Insert all the masks for a total of (masksTotal) masks in the tile list.
        for (Mask mask: game.getUniqueMasks()) {
            for (int i = 0; i < mask.numberOfMasks; ++i) {
                randomlyInsertTile(mask, tiles);
            }
        }

        // Insert the remaining non-mask tiles: (masksTotal) + (total tiles - masksTotal) = (total tiles)
        //                                       equivalent to (non-mask tiles)
        for (int i = 0; i < (game.discoveryTiles() - game.masksTotal()); ++i) {
            randomlyInsertTile(new DiscoveryTile(), tiles);
        }
    }

    private void randomlyInsertTile(DiscoveryTile tile, ArrayList<DiscoveryTile> tiles) {
        // Insert the tile randomly at any of the possible indices of the deck: from 0 (the first position) to size() (the end of the list).
        // nextInt(bound) does not include bound in the possible values; thus, + 1.
        tiles.add(rng.nextInt(tiles.size() + 1), tile);
    }
}
