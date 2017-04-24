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
        // given
        boolean[][] initialState = {
                {O, O, O, O, O},
                {O, X, O, X, O},
                {O, O, X, O, O},
                {O, O, O, O, O},
        };
        Board board = new Board(initialState);

        // then
        assertThat(board.getCurrentStates()).containsExactly(initialState);
    }

    @Test
    public void should_update_cells_when_neighbors_are_on_border_line() {
        // given
        boolean[][] initialState = {
                {X, O, X, O},
                {O, X, O, X}, /** row: 1 col: 1 ALIVE -> ALIVE and row: 1 col: 2 DEAD -> ALIVE */
                {O, O, O, O},
        };
        Board board = new Board(initialState);

        // when
        board.update();

        // then
        boolean[][] newState = board.getCurrentStates();

        assertThat(newState[0][0]).isEqualTo(DEAD);
        assertThat(newState[1][1]).isEqualTo(ALIVE);
        assertThat(newState[1][2]).isEqualTo(ALIVE);
        assertThat(newState[2][2]).isEqualTo(DEAD);
    }

    @Test
    public void should_update_cell_when_neighbors_are_not_on_border_line() {
        // given
        boolean[][] initialState = {
                {O, O, O, O, O},
                {O, X, O, X, O},
                {O, O, X, O, O}, /** row:2 col:2 Alive-->Alive */
                {O, O, O, O, O},
        };
        Board board = new Board(initialState);

        // when
        board.update();

        // then
        boolean[][] newState = board.getCurrentStates();
        assertThat(newState[2][2]).isEqualTo(ALIVE);
    }


    @Test
    public void should_change_state() {
        // given
        boolean[][] initialState = {
                {O, O, O, O, O, O, O, O, O},
                {O, O, X, O, O, O, X, O, O},
                {O, X, O, O, O, O, O, X, O},
                {O, O, X, O, O, O, O, X, O},
                {O, O, O, O, O, O, O, O, O},
        };


        boolean[][] secondState = {
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},
                {O, X, X, O, O, O, X, X, O},
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},

        };
        Board board = new Board(initialState);

        // when
        board.update();

        // then
        assertThat(board.getCurrentStates()).containsExactly(secondState);
    }

    @Test
    public void should_override_previous_board_after_update() {
        // given
        boolean[][] initialState = {
                {O, O, O, O, O, O, O, O, O},
                {O, O, X, O, O, O, X, O, O},
                {O, X, O, O, O, O, O, X, O},
                {O, O, X, O, O, O, O, X, O},
                {O, O, O, O, O, O, O, O, O},
        };


        boolean[][] secondState = {
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},
                {O, X, X, O, O, O, X, X, O},
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},

        };
        Board board = new Board(initialState);

        // when
        board.update();

        boolean[][] previousBoardState = new boolean[board.height][board.width];

        for (int row = 0; row < previousBoardState.length; row++) {
            for (int col = 0; col < previousBoardState[0].length; col++) {
                previousBoardState[row][col] = board.previousBoard[row][col].getState();
            }
        }

        // then
        assertThat(previousBoardState).containsExactly(secondState);
    }
}