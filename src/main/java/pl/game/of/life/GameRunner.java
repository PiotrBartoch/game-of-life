package pl.game.of.life;

public class GameRunner {
    private static final boolean DEAD = false;
    private static final boolean ALIVE = true;
    private static final boolean X = ALIVE;
    private static final boolean O = DEAD;

    public static void main(String[] args) {


        boolean[][] initialState = {
                {O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O},
                {O, O, X, O, O, O, X, O, O, O, O, X, O, O, O, O, X, O, O, O, X, O, O, O, X, O, O, O, O, X, O, O, O, X, O, O, O, O, X, O, O, O, O, X, O, O, O, X, O, O, O, X, O, O},
                {O, X, O, O, O, O, O, X, O, O, X, O, O, O, O, X, O, O, O, O, O, X, O, O, O, X, O, O, X, O, O, O, O, O, X, O, O, X, O, O, O, O, X, O, O, O, O, O, X, O, O, O, X, O},
                {O, O, X, O, X, O, O, X, O, X, O, X, O, X, O, O, X, O, O, O, O, X, O, O, O, X, O, O, O, X, O, O, O, O, X, O, O, O, X, O, O, O, O, X, O, O, O, O, X, O, O, O, X, O},
                {X, O, O, X, O, O, O, O, O, O, O, X, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, X, O, O, O, O, O, O, O, O, O, O, O},
                {O, O, O, X, O, O, O, X, O, O, O, O, O, O, O, X, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, X, X, O, O, O, O, O, O, O, O, O, O, O, O},
                {X, O, X, O, O, X, X, X, O, X, O, X, O, X, X, O, X, O, O, O, X, O, O, O, X, O, O, O, O, X, O, O, O, X, O, O, O, O, X, O, X, O, O, X, O, O, O, X, O, O, O, X, O, O},
                {O, X, O, X, O, X, O, X, O, O, X, O, O, O, X, X, O, O, O, X, O, X, O, O, O, X, X, O, X, O, O, O, O, O, X, O, O, X, O, X, O, X, X, O, X, O, O, O, X, O, O, O, X, O},
                {X, O, X, O, O, X, O, X, O, X, O, X, O, X, O, O, X, O, O, O, O, X, O, O, O, X, O, O, O, X, O, O, O, O, X, O, O, O, X, X, X, O, O, X, O, O, O, O, X, O, O, O, X, O},
                {O, O, O, O, O, O, O, O, X, O, O, O, X, O, X, X, O, O, O, O, O, O, O, O, O, O, X, O, O, O, O, O, O, O, O, O, O, O, O, X, O, X, X, O, O, O, O, O, O, O, O, O, O, O},
                {O, O, O, X, O, X, O, O, O, X, O, O, O, O, O, O, O, O, O, X, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, X, O, X, X, O, O, O, O, O, O, O, O, O, O, O},
                {O, O, X, O, O, X, X, O, O, X, O, X, X, O, O, X, X, O, O, O, X, O, O, O, X, O, O, O, O, X, O, O, O, X, O, O, O, O, X, O, X, O, O, X, X, O, O, X, O, O, O, X, O, O},
                {O, X, O, O, O, O, O, X, O, X, X, O, O, O, O, X, O, O, O, O, O, X, O, O, O, X, O, O, X, O, O, O, O, O, X, O, O, X, O, O, O, O, X, O, O, O, O, O, X, O, O, O, X, O},
                {X, O, X, O, O, X, O, X, O, O, O, X, O, O, O, O, X, O, O, O, O, X, O, O, O, X, O, O, O, X, O, O, O, O, X, O, O, O, X, O, O, O, O, X, O, O, O, O, X, O, O, O, X, O},
                {O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O}
        };

        Board board = new Board(initialState);
        runGame(board, 100);
    }


    static void runGame(Board board, int gameLoop) {
        for (int i = 0; i < gameLoop; i++) {
            System.out.println("\r");
            System.out.print(board);
            System.out.flush();
            waitForNextFrame();
            board.update(); // updates both boards
        }
    }

    private static void waitForNextFrame() {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
