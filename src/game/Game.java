package game;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private int discoveryTiles;
    private int masksTotal;
    private int startingSelectionAmount;
    private ArrayList<Mask> uniqueMasks;
    public Random rng;

    public static Game GAME_STANDARD = new Game(54, 19,
            new Mask("1", 3),
            new Mask("2", 3),
            new Mask("3", 3),
            new Mask("4", 3),
            new Mask("5", 2),
            new Mask("6", 2),
            new Mask("7", 1)
    );

    public Game(int discoveryTiles, int startingSelection, Mask... masks) {
        rng = new Random();
        this.discoveryTiles = discoveryTiles;
        this.startingSelectionAmount = startingSelection;
        uniqueMasks = new ArrayList<>();
        for (Mask m: masks) {
            uniqueMasks.add(m);
        }
        this.masksTotal = countTotalMasks();
    }

    private int countTotalMasks() {
        int n = 0;

        for (Mask m: uniqueMasks) {
            n += m.numberOfMasks;
        }

        return n;
    }

    public int discoveryTiles() {
        return discoveryTiles;
    }
    public int masksTotal() {
        return masksTotal;
    }
    public int startingSelection() {
        return startingSelectionAmount;
    }
    public ArrayList<Mask> getUniqueMasks() {
        return uniqueMasks;
    }
}
