package pl.game.of.life;

/**
 * Created by pbartoch on 13.04.2017.
 */
public class Cell {

    public static final boolean DEAD = false;
    public static final boolean ALIVE = true;
    private boolean state;

    public Cell(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public void updateCellState(int numOfNeighbors) {
        if (state == ALIVE) {
            this.state = numOfNeighbors == 2 || numOfNeighbors == 3 ? ALIVE : DEAD;
        } else {
            this.state = numOfNeighbors == 3 ? ALIVE : DEAD;
        }
    }
}
