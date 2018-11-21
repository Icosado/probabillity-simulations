package simulation;

import game.DiscoveryTile;
import game.Game;

import java.util.ArrayList;

/**
 * Holds a subset of a deck to be verified against a binary case.
 */
public class Selection {
    public ArrayList<DiscoveryTile> selectionTiles;
    Deck deck;
    Game game;

    public Selection(Deck deck, Game game) {
        this.selectionTiles = new ArrayList<>();
        this.deck = deck;
        this.game = game;
        select();
    }

    private void select() {
        for (int i = 0; i < game.startingSelection(); ++i) {
            deck.put(game.startingSelection(), selectionTiles);
        }
    }
}
