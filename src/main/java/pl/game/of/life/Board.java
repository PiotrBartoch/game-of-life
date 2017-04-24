package pl.game.of.life;

import java.util.Arrays;

/**
 * Created by pbartoch on 13.04.2017.
 */
public class Board {

    Cell[][] previousBoard;
    Cell[][] currentBoard;

    int width;
    int height;

    Board(boolean[][] initialStates) {
        width = initialStates[0].length;
        height = initialStates.length;
        previousBoard = new Cell[height][width];
        currentBoard = new Cell[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                boolean initialState = initialStates[row][col];
                previousBoard[row][col] = new Cell(initialState);
                currentBoard[row][col] = new Cell(initialState);
            }
        }
    }

    boolean[][] getCurrentStates() { // for test now only
        boolean[][] cellsStates = new boolean[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                cellsStates[row][col] = currentBoard[row][col].getState();
            }
        }
        return cellsStates;
    }

    void update() {
        for (int row = 0; row < height; row++) { // iterates all board
            for (int col = 0; col < width; col++) {
                int numberOfNeighbors = countNeighbors(row, col);
                currentBoard[row][col].updateCellState(numberOfNeighbors);
            }
        }
        overrideOldBoard(); // overrides previous board for next check

    }

    private void overrideOldBoard() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                previousBoard[row][col] = currentBoard[row][col];
            }
        }
    }


    private int countNeighbors(int row, int col) {
        /** if "main" cell is alive we initiate aliveNeighbors with -1. It's because in algorithm it checks itself too, but should not count itself, so we subtract it from sum. If its dead, it's  zero anyway.*/
        int aliveNeighbors = previousBoard[row][col].getState() ? -1 : 0;
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
        return previousBoard[r][c].getState() ? 1 : 0;
    }

    @Override
    public String toString() {
        String[][] board = new String[height][width];
        Cell cell;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                cell = currentBoard[row][col];
                board[row][col] = cell.toString();
            }
        }
        return Arrays.deepToString(board).replaceAll("\\s", "")
                .replace("[","")
                .replace("]","\n")
                .replace(",","");
    }
}

