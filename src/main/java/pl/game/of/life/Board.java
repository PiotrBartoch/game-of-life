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
                int numberOfNeighbors = countNeighbors(boardOfCells,row,col);
                boardOfCells[row][col].updateCellState(numberOfNeighbors);
            }
        }
    }

    private int countNeighbors(Cell[][] boardOfCells, int row, int col) { // todo: out of boundary exception fix it
        int rowBack = row -1;
        int rowForward = row +1;
        int colBack = col -1;
        int colForward = col +1;
        int neighbors = 0;

        for (int r = rowBack; r <= rowForward; r++) {
            for (int c = colBack; c <= colForward; c++) {
                boolean mainCellState = boardOfCells[row][col].getState();
                boolean neighborCellState = boardOfCells[r][c].getState();
                if (mainCellState == neighborCellState) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }

}
