package pl.game.of.life;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by pbartoch on 24.04.2017.
 */
public class GameRunnerTest {

    public static final boolean DEAD = false;
    public static final boolean ALIVE = true;
    public static final boolean X = ALIVE;
    public static final boolean O = DEAD;

    @Test
    public void should_return_third_state() {
        // given
        boolean[][] initialState = {
                {X, O, X, O},
                {O, X, O, X},
                {O, O, O, O},
        };

        boolean[][] thirdState = {
                {O, X, X, O},
                {O, X, X, O},
                {O, O, O, O},
        };

        Board board = new Board(initialState);

        // when
        GameRunner.runGame(board, 3);

        // then
        assertThat(board.getCurrentStates()).containsExactly(thirdState);
    }

    @Test
    public void should_return_empty_board_on_4th_state() {
        // given
        boolean[][] initialState = {
                {O, O, O, O, O, O, O, O, O},
                {O, O, X, O, O, O, X, O, O},
                {O, X, O, O, O, O, O, X, O},
                {O, O, X, O, O, O, O, X, O},
                {O, O, O, O, O, O, O, O, O},
        };

        boolean[][] fourthState = {
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O},
        };

        Board board = new Board((initialState));

        // when
        GameRunner.runGame(board,4);

        // then
        assertThat(board.getCurrentStates()).containsExactly(fourthState);
    }
}