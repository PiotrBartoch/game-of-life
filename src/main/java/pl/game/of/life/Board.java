package pl.game.of.life;

/**
 * Created by pbartoch on 13.04.2017.
 */
public class Board {

    private Cell[][] boardOfCells; // todo: think if i want to use cells or just states

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
    } // for tests

    public boolean[][] getBoardState() {
        boolean[][] cellsStates = new boolean[boardOfCells.length][boardOfCells[0].length];
        for (int row = 0; row < cellsStates.length; row++) {
            for (int col = 0; col < cellsStates[0].length; col++) {
                cellsStates[row][col] = boardOfCells[row][col].getState();
                System.out.printf("");
            }
        }
        return cellsStates;
    }

    public void update() {
         for (int row = 1; row < boardOfCells.length - 1; row++) { // edge rows are ignored
            for (int col = 1; col < boardOfCells[0].length - 1; col++) { // edge columns are ignored
                int numberOfNeighbors = countNeighbors(boardOfCells, row, col);
                boardOfCells[row][col].updateCellState(numberOfNeighbors);
            }
        }
    }

    private int countNeighbors(Cell[][] boardOfCells, int row, int col) {
        int rowBack = row  - 1;
        int rowForward = row + 1;
        int colBack = col - 1;
        int colForward = col + 1;
        int neighbors = 0;

        for (int r = rowBack; r <= rowForward; r++) {
            for (int c = colBack; c <= colForward; c++) {
                if (r != row || c != col) {
                    boolean neighborCellState = boardOfCells[r][c].getState();
                    if (neighborCellState == true) {
                        neighbors++;
                    }
                }
            }
        }
        return neighbors;
    }

}