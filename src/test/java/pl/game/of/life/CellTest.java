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
}