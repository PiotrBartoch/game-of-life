package pl.game.of.life;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Piotrek on 17.04.2017.
 */
public class BoardTest {

    public static final boolean DEAD = false;
    public static final boolean ALIVE = true;
    public static final boolean X = ALIVE;
    public static final boolean O = DEAD;

    @Test
    public void should_return_initial_state() {

        boolean[][] initialState = {
                {X, O, X},
                {O, X, O},
                {O, O, O},
        };
        Board board = new Board(initialState);
        assertThat(board.getBoardState()).containsExactly(initialState);
    }

    @Test
    public void should_update_cell_when_it_sticks_with_borders() {

        boolean[][] initialState = {
                {X, O, X}, // row:0 col:0 ALIVE -> DEAD
                {O, X, O},
                {O, O, O},
        };
        Board board = new Board(initialState);
        board.update();
        boolean[][] updatedState = board.getBoardState();

        assertThat(updatedState[0][0]).isEqualTo(DEAD);
    }

    @Test
    public void should_update_cell_when_it_does_not_touch_borders() {
        boolean[][] initialState = {
                {O, O, O},
                {O, X, O}, // row: 1 col: 1 ALIVE -> DEAD
                {O, O, O},
        };
        Board board = new Board(initialState);
        board.update();
        boolean[][] updatedState = board.getBoardState();

        assertThat(updatedState[1][1]).isEqualTo(DEAD);
    }

    @Test
    public void should_count_all_neighbors() {
        boolean[][] initialState = {
                {O, O, O, O, O, O, O, O, O},
                {O, O, X, O, O, O, X, O, O},
                {O, X, O, O, O, O, O, X, O},
                {O, O, X, O, O, O, O, X, O},
                {O, O, O, O, O, O, O, O, O},
        };

        int[][] numberOfNeighborsArray = {
                {0,1,1,1,0,1,1,1,0},
                {1,2,1,1,0,1,1,2,1},
                {1,2,3,2,0,1,3,2,2},
                {1,2,1,1,0,0,2,1,2},
                {0,1,1,1,0,0,1,1,1},
        };

        Board board = new Board(initialState);
        int[][] neighborsCounted = board.countAllNeighbors(board.getBoardOfCells());

        assertThat(neighborsCounted).containsExactly(numberOfNeighborsArray);

    }

    @Test
    public void should_change_state() {
        boolean[][] initialState = {
                {O, O, O, O, O, O, O, O, O},
                {O, O, X, O, O, O, X, O, O},
                {O, X, O, O, O, O, O, X, O},
                {O, O, X, O, O, O, O, X, O},
                {O, O, O, O, O, O, O, O, O},
        };

        boolean [][] secondState = {
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},
                {O, X, X, O, O, O, X, X, O},
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},

        };
        Board board = new Board(initialState);

        board.update();
        assertThat(board.getBoardState()).containsExactly(secondState);
    }
}