package pl.game.of.life;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by pbartoch on 14.04.2017.
 */
public class CellTest {

    private Cell cell;

    @Before
    public void setUp() {
        cell = new Cell(true);
    }

    @Test
    public void should_die_when_has_one_or_zero_neighbors() {
        cell.setNewState(0);
        assertThat(cell.getState()).isFalse();

        cell.setNewState(1);
        assertThat(cell.getState()).isFalse();
    }

    @Test
    public void should_die_when_has_four_or_more_neighbors() {
        cell.setNewState(4);
        assertThat(cell.getState()).isFalse();

        cell.setNewState(5);
        assertThat(cell.getState()).isFalse();

        cell.setNewState(150);
        assertThat(cell.getState()).isFalse();
    }

    @Test
    public void should_survive_when_has_two_neighbors() {
        cell.setNewState(2);
        assertThat(cell.getState()).isTrue();
    }

    @Test
    public void should_survive_when_has_three_neighbors() {
        cell.setNewState(3);
        assertThat(cell.getState()).isTrue();
    }

    @Test
    public void should_be_populated_when_it_is_dead_and_have_three_neighbors() {
        Cell deadCell = new Cell(false);
        assertThat(deadCell.getState()).isFalse();
        deadCell.setNewState(3);
        assertThat(deadCell.getState()).isTrue();
    }

    @Test
    public void should_stay_dead_when_it_is_dead_and_have_two_neighbors() {
        Cell deadCell = new Cell(false);
        assertThat(deadCell.getState()).isFalse();
        deadCell.setNewState(2);
        assertThat(deadCell.getState()).isFalse();
    }

}