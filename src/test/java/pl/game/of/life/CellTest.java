package pl.game.of.life;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by pbartoch on 14.04.2017.
 */
public class CellTest {

    private Cell aliveCell;

    /**    ---Alive Cells------------------------------------------------------------------------------------- */

    @Before
    public void setUp() {
        aliveCell = new Cell(true);
    }

    @Test
    public void should_die_when_is_alive_and_has_one_or_zero_neighbors() {
        aliveCell.setNewState(0);
        assertThat(aliveCell.getState()).isFalse();

        aliveCell.setNewState(1);
        assertThat(aliveCell.getState()).isFalse();
    }

    @Test
    public void should_die_when_is_alive_and_has_four_or_more_neighbors() {
        aliveCell.setNewState(4);
        assertThat(aliveCell.getState()).isFalse();

        aliveCell.setNewState(5);
        assertThat(aliveCell.getState()).isFalse();

        aliveCell.setNewState(150);
        assertThat(aliveCell.getState()).isFalse();
    }

    @Test
    public void should_survive_when_is_alive_and_has_two_or_three_neighbors() {
        aliveCell.setNewState(2);
        assertThat(aliveCell.getState()).isTrue();

        aliveCell.setNewState(3);
        assertThat(aliveCell.getState()).isTrue();
    }


    /**    ---Dead Cells------------------------------------------------------------------------------------- */

    @Before


    @Test
    public void should_be_populated_when_it_is_dead_and_have_three_neighbors() {
        Cell deadCell = new Cell(false);
        assertThat(deadCell.getState()).isFalse();
        deadCell.setNewState(3);
        assertThat(deadCell.getState()).isTrue();
    }

    @Test
    public void should_stay_dead_when_it_is_dead_and_have_two_neighbors() { // todo: make it pass, and test all cases
        Cell deadCell = new Cell(false);
        assertThat(deadCell.getState()).isFalse();
        deadCell.setNewState(2);
        assertThat(deadCell.getState()).isFalse();
    }

}