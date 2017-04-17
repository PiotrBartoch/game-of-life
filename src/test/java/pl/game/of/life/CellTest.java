package pl.game.of.life;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pbartoch on 14.04.2017.
 */
public class CellTest {

    private Cell aliveCell;
    public static final boolean DEAD = false;
    public static final boolean ALIVE = true;

    /**
     * ---Conditions for Alive Cells-------------------------------
     */

    @Before
    public void setUp() {
        aliveCell = new Cell(true);
    }

    @Test
    public void should_die_when_is_alive_and_has_one_or_zero_neighbors() {
        aliveCell.updateCellState(0);
        assertThat(aliveCell.getState()).isEqualTo(DEAD);

        aliveCell.updateCellState(1);
        assertThat(aliveCell.getState()).isEqualTo(DEAD);
    }

    @Test
    public void should_die_when_is_alive_and_has_four_or_more_neighbors() {
        aliveCell.updateCellState(4);
        assertThat(aliveCell.getState()).isEqualTo(DEAD);

        aliveCell.updateCellState(5);
        assertThat(aliveCell.getState()).isEqualTo(DEAD);

        aliveCell.updateCellState(8);
        assertThat(aliveCell.getState()).isEqualTo(DEAD);
    }

    @Test
    public void should_survive_when_is_alive_and_has_two_or_three_neighbors() {
        aliveCell.updateCellState(2);
        assertThat(aliveCell.getState()).isEqualTo(ALIVE);

        aliveCell.updateCellState(3);
        assertThat(aliveCell.getState()).isEqualTo(ALIVE);
    }

    /**
     * ---Conditions for Dead Cells-------------------------------
     */

    @Test
    public void should_be_populated_when_it_is_dead_and_have_three_neighbors() {
        Cell deadCell = new Cell(false);
        assertThat(deadCell.getState()).isEqualTo(DEAD);
        deadCell.updateCellState(3);
        assertThat(deadCell.getState()).isEqualTo(ALIVE);
    }

    @Test
    public void should_stay_dead_when_it_is_dead_and_have_two_neighbors() {
        Cell deadCell = new Cell(false);
        assertThat(deadCell.getState()).isEqualTo(DEAD);
        deadCell.updateCellState(2);
        assertThat(deadCell.getState()).isEqualTo(DEAD);
    }

    @Test
    public void should_stay_dead_when_is_dead_and__has_one_or_zero_neighbors() {
        Cell deadCell = new Cell(false);
        assertThat(deadCell.getState()).isEqualTo(DEAD);

        deadCell.updateCellState(0);
        assertThat(deadCell.getState()).isEqualTo(DEAD);

        deadCell.updateCellState(1);
        assertThat(deadCell.getState()).isEqualTo(DEAD);
    }

    @Test
    public void should_stay_dead_when_is_dead_and_has_four_or_more_neighbors() {
        Cell deadCell = new Cell(false);
        assertThat(deadCell.getState()).isEqualTo(DEAD);

        deadCell.updateCellState(4);
        assertThat(deadCell.getState()).isEqualTo(DEAD);

        deadCell.updateCellState(5);
        assertThat(deadCell.getState()).isEqualTo(DEAD);

        deadCell.updateCellState(8);
        assertThat(deadCell.getState()).isEqualTo(DEAD);
    }
}