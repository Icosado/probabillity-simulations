package simulation;

import game.Game;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Simulator {
    private long selectionsTested;
    private long selectionsPassed;
    private Case checker;
    private int blockSize;
    private int blockIterations;
    private String filePath;

    private Game game;

    public static void main(String[] args) {
        Game g = Game.GAME_STANDARD;

        Simulator simulator = new Simulator(new AllUniqueMasks(), g, 3000, 100);
        simulator.simulate();
    }

    public Simulator(Case checker, Game game, int blockSize, int blockIterations) {
        java.util.Date date = new Date();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        this.filePath = timeStamp + "_" + checker + "_data.txt";

        this.checker = checker;
        this.blockSize = blockSize;
        this.blockIterations = blockIterations;
        this.game = game;

        selectionsTested = 0;
        selectionsPassed = 0;
    }

    public void simulate() {
        for (int i = 0; i < blockIterations; ++i) {
            long blockSelectionsTested = 0;
            long blockSelectionsPassed = 0;
            for (int j = 0; j < blockSize; ++j) {
                ++blockSelectionsTested;
                Selection selection = new Selection(new Deck(game), game); // Slightly redundant in hindsight, but i'll just suck it up
                if (checker.fulfillsCase(selection)) {
                    ++blockSelectionsPassed;
                }
            }

            double blockPassPercentage = (double) blockSelectionsPassed / (double) blockSelectionsTested;
//            System.out.println(blockPassPercentage);
            selectionsTested += blockSelectionsTested;
            selectionsPassed += blockSelectionsPassed;
        }
        double passPercentage = (double) selectionsPassed / (double) selectionsTested;
        System.out.println("\nOverall pass rate:" + passPercentage);
    }
}
