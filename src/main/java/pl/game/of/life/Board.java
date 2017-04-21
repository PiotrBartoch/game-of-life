package pl.game.of.life;

/**
 * Created by pbartoch on 13.04.2017.
 */
public class Board {

    Cell[][] boardOfCells; // todo: think if i want to use cells or just states
    Cell[][] currentState;

    int width;
    int height;

    public Board(boolean[][] initialStates) {
        width = initialStates[0].length;
        height = initialStates.length;
        boardOfCells = new Cell[height][width];
        currentState = new Cell[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                boolean initialState = initialStates[row][col];
                boardOfCells[row][col] = new Cell(initialState);
                currentState[row][col] = new Cell(initialState);
            }
        }
    }

    public boolean[][] getCurrentStates() {
        boolean[][] cellsStates = new boolean[currentState.length][currentState[0].length];
        for (int row = 0; row < cellsStates.length; row++) {
            for (int col = 0; col < cellsStates[0].length; col++) {
                cellsStates[row][col] = currentState[row][col].getState();
            }
        }
        return cellsStates;
    }

    public void update() {
        for (int row = 0; row < boardOfCells.length; row++) {
            for (int col = 0; col < boardOfCells[0].length; col++) {
                int numberOfNeighbors = countNB(row, col);
                currentState[row][col].updateCellState(numberOfNeighbors);
            }
        }
    }

    private int getNeighbors(int row, int col) {
        int rowBack = row - 1;
        int rowForward = row + 1;
        int colBack = col - 1;
        int colForward = col + 1;
        int neighbors = 0;

        /**Middle cells*/
        if (row != 0 && row != boardOfCells.length - 1 && col != 0 && col != boardOfCells[0].length - 1) {
            for (int r = rowBack; r <= rowForward; r++) {
                for (int c = colBack; c <= colForward; c++) {
                    neighbors = countNeighbors(row, col, neighbors, r, c);
                }
            }
        }

        /**Corner cells*/
        if (row == 0 && col == 0) { // upper left corner
            for (int r = row; r <= rowForward; r++) {
                for (int c = col; c <= colForward; c++) {
                    neighbors = countNeighbors(row, col, neighbors, r, c);
                }
            }
        }
        if (row == 0 && col == boardOfCells[0].length - 1) { // upper right corner !!!!!!!!!!!!!!!!!!!!!!!!!!!!
            for (int r = row; r <= rowForward; r++) {
                for (int c = colBack; c <= col; c++) {
                    neighbors = countNeighbors(row, col, neighbors, r, c);
                }
            }

        }
        if (row == boardOfCells.length - 1 && col == boardOfCells[0].length - 1) { // bottom right corner
            for (int r = rowBack; r <= row; r++) {
                for (int c = colBack; c <= col; c++) {
                    neighbors = countNeighbors(row, col, neighbors, r, c);
                }
            }
        }
        if (row == boardOfCells.length - 1 && col == 0) { // bottom left corner
            for (int r = rowBack; r <= row; r++) {
                for (int c = col; c <= colForward; c++) {
                    neighbors = countNeighbors(row, col, neighbors, r, c);
                }
            }
        }

        /**Border Cells*/
        if (row == 0 && (1 <= col && col <= boardOfCells[0].length - 1)) { // upper border
            for (int r = row; r <= rowForward; r++) {
                for (int c = colBack; c <= colForward; c++) {
                    neighbors = countNeighbors(row, col, neighbors, r, c);
                }
            }
        }
        if ((1 <= row && row <= boardOfCells.length - 1) && col == boardOfCells[0].length - 1) { // right border
            for (int r = rowBack; r <= rowForward; r++) {
                for (int c = colBack; c <= col; c++) {
                    neighbors = countNeighbors(row, col, neighbors, r, c);
                }
            }
        }
        if (row == boardOfCells.length - 1 && (1 <= col && col <= boardOfCells[0].length - 1)) { // bottom border
            for (int r = rowBack; r <= row; r++) {
                for (int c = colBack; c <= colForward; c++) {
                    neighbors = countNeighbors(row, col, neighbors, r, c);
                }
            }
        }
        if ((1 <= row && row <= boardOfCells.length - 1) && col == 0) { // left border
            for (int r = rowBack; r <= rowForward; r++) {
                for (int c = colBack; c <= col; c++) {
                    neighbors = countNeighbors(row, col, neighbors, r, c);
                }
            }
        }
        return neighbors;
    }

    private int countNeighbors(int row, int col, int neighbors, int r, int c) {
        if (r != row || c != col) {
            boolean neighborCellState = boardOfCells[r][c].getState();
            if (neighborCellState == true) {
                neighbors++;
            }
        }
        return neighbors;
    }


    int countNB(int x, int y) {
        int aliveNB = boardOfCells[x][y].getState() ? -1 : 0;
        for (int r = x-1; r <= x+1; r++) {
            for (int c = y-1; c <= y+1; c++) {
                aliveNB += isAlive(r, c);
            }
        }
        return aliveNB;
    }

    private int isAlive(int r, int c) {
        if (r < 0 || r > height - 1 || c < 0 || c > width - 1) {
            return 0;
        }
        return boardOfCells[r][c].getState() ? 1 : 0;
    }

}