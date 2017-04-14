package pl.game.of.life;

/**
 * Created by pbartoch on 13.04.2017.
 */
public class Cell {

    private boolean state;

    public Cell(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public void setNewState(int numOfNeighbors) {
        this.state = numOfNeighbors <= 1 || numOfNeighbors >= 4 ? false : true;
    }

}
