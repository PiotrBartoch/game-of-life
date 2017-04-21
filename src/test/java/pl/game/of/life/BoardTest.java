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
                {O, O, O, O, O},
                {O, X, O, X, O},
                {O, O, X, O, O},
                {O, O, O, O, O},
        };
        Board board = new Board(initialState);
        assertThat(board.getCurrentStates()).containsExactly(initialState);
    }

    @Test
    public void should_update_cell_when_neighbors_are_on_ignored_line() {
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
        assertThat(newState[2][2]).isEqualTo(DEAD);
        assertThat(newState[1][1]).isEqualTo(ALIVE);
        assertThat(newState[1][2]).isEqualTo(ALIVE);
    }

    /**
     * ---------------------------above passes----------------------------------------------
     */


    @Test
    public void should_update_cell_when_neighbors_are_not_on_ignored_line() {
        boolean[][] initialState = {
                {O, O, O, O, O},
                {O, X, O, X, O},
                {O, O, X, O, O}, /** row:2 col:2 Alive-->Alive */
                {O, O, O, O, O},
        };
        Board board = new Board(initialState);
        board.update();
        boolean[][] newState = board.getCurrentStates();

        assertThat(newState[2][2]).isEqualTo(ALIVE);
    }

    @Test
    public void should_update_cell_when_it_does_not_touch_borders() {
        boolean[][] initialState = {
                {O, O, O, O, O},
                {O, O, O, O, O},
                {O, X, X, X, O}, // row: 2 col: 2 ALIVE -> DEAD
                {O, O, O, O, O},
                {O, O, O, O, O},
        };
        /** boolean[][] initialState = {
         {O, O, O, O, O},
         {O, O, O, O, O},
         {O, O, X, O, O}, // row: 2 col: 2 ALIVE -> DEAD
         {O, O, O, O, O},
         {O, O, O, O, O},
         }; */
        Board board = new Board(initialState);
        board.update();
        boolean[][] newState = board.getCurrentStates();

        assertThat(newState[2][2]).isEqualTo(ALIVE);
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

        /**  boolean[][] initialState = {
         {O, O, O, O, O, O, O, O, O},
         {O, O, X, O, O, O, X, O, O},
         {O, X, O, O, O, O, O, X, O},
         {O, O, X, O, O, O, O, X, O},
         {O, O, O, O, O, O, O, O, O},
         }; */


        boolean[][] secondState = {
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},
                {O, X, X, O, O, O, X, X, O},
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},

        };
        Board board = new Board(initialState);

        board.update();
//        assertThat(board.getCurrentStates()).containsExactly(secondState);
        boolean[][] newState = board.getCurrentStates();

        assertThat(newState[2][1]).isEqualTo(ALIVE);
    }
}