package simulation;

import game.Game;

public class Simulator {
    private long selectionsTested;
    private long selectionsPassed;
    private Case checker;
    private int blockSize;
    private int blockIterations;
    private String filePath;

    public static void main(String[] args) {
        Game g = Game.GAME_STANDARD;
    }
}
