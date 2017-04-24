package pl.game.of.life;

/**
 * Created by pbartoch on 13.04.2017.
 */
public class Board {

    Cell[][] boardOfCells;
    Cell[][] currentBoardState;

    int width;
    int height;

    public Board(boolean[][] initialStates) {
        width = initialStates[0].length;
        height = initialStates.length;
        boardOfCells = new Cell[height][width];
        currentBoardState = new Cell[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                boolean initialState = initialStates[row][col];
                boardOfCells[row][col] = new Cell(initialState);
                currentBoardState[row][col] = new Cell(initialState);
            }
        }
    }

//    public void runGame(boolean[][] initialStates, int gameLoop) {
//        Board board = new Board(initialStates);
//        for (int i = 0; i < gameLoop; i++) {
//            for ()
//        }
//    }

    public boolean[][] getCurrentStates() {
        boolean[][] cellsStates = new boolean[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                cellsStates[row][col] = currentBoardState[row][col].getState();
            }
        }
        return cellsStates;
    }

    public void update() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int numberOfNeighbors = countNeighbors(row, col);
                currentBoardState[row][col].updateCellState(numberOfNeighbors);
            }
        }

    }


    private int countNeighbors(int row, int col) {
        /** if "main" cell is alive we initiate aliveNeighbors with -1. It's because in algorithm it checks itself too, but should not count itself, so we subtract it from sum. If its dead, it's  zero anyway.*/
        int aliveNeighbors = boardOfCells[row][col].getState() ? -1 : 0;
        /** iterate all cells around main cell*/
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                aliveNeighbors += isAlive(r, c);
            }
        }
        return aliveNeighbors;
    }

    private int isAlive(int r, int c) {
        /** Condition for border cases, prevents from OutOfBoundsException in array*/
        if (r < 0 || r > height - 1 || c < 0 || c > width - 1) {
            return 0;
        }
        return boardOfCells[r][c].getState() ? 1 : 0;
    }
}

