package pl.game.of.life;

/**
 * Created by pbartoch on 13.04.2017.
 */
public class Board {

    private Cell[][] boardOfCells;

    public Board(boolean[][] initialStates) {
        boardOfCells = new Cell[initialStates.length][initialStates[0].length];
        for (int row = 0; row < boardOfCells.length; row++) {
            for (int col = 0; col < boardOfCells[0].length; col++) {
                boolean initialState = initialStates[row][col];
                boardOfCells[row][col] = new Cell(initialState);
            }
        }
    }

    public Cell[][] getBoardOfCells() {
        return boardOfCells;
    }

    public boolean[][] getBoardState() {
        boolean[][] cellsStates = new boolean[boardOfCells.length][boardOfCells[0].length];
        for (int row = 0; row < cellsStates.length; row++) {
            for (int col = 0; col < cellsStates[0].length; col++) {
                boolean cellState = boardOfCells[row][col].getState();
                cellsStates[row][col] = cellState;
            }
        }
        return cellsStates;
    }

    public void update() {
        for (int row = 0; row < boardOfCells.length; row++) {
            for (int col = 0; col < boardOfCells[0].length; col++) {
                boardOfCells[row][col].updateCellState(getNumOfNeighbors());
            }
        }
    }

    private int getNumOfNeighbors() {
        return 0;
    }

    public int[][] countAllNeighbors(Cell[][] boardOfCells) {
        int[][] countedNeighbors = new int[boardOfCells.length][boardOfCells[0].length];
        for (int row = 0; row < countedNeighbors.length; row++) {
            for (int col = 0; col < countedNeighbors[0].length; row++) {
                countedNeighbors[row][col] = boardOfCells[row][col].countNeighbors();
            }
        }
        return countedNeighbors;
    }

}
