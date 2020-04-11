/**
 * The SubBoard class implant a class to manage the Sub boards of game.
 * it's 3*3 block that can twist/rotate.
 *
 * @author Amirreza Hashemi
 * @version 1.0
 * @since 4/4/2020
 */
public class SubBoard extends Board {
    //A 2D array that contain status (it's 0 for empty or the code of player) of each cell of sub board
    private int[][] map;

    /**
     * Instantiates a new Sub board with given row and column.
     *
     * @param row    the row
     * @param column the column
     */
    public SubBoard(int row, int column) {
        super(row, column);
        map = new int[row][column];
        //The default is 0
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                map[i][j] = 0;
    }

    /**
     * Get map of sub board.
     *
     * @return the 2D int that represent sub board
     */
    public int[][] getMap() {
        return map;
    }

    /**
     * Twists the sub board in given direction.
     *
     * @param clockWise the int that determinate rotation direction clockwise if 0 and anticlockwise if 1
     */
    public void twist(int clockWise) {
        int[][] copy = new int[3][3];
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COLUMN; j++)
                copy[i][j] = map[i][j];
        if (clockWise == 0) {
            int k = 0;
            for (int i = ROW - 1; i >= 0; i--) {
                for (int j = 0; j < COLUMN; j++) {

                    map[j][i] = copy[k][j];
                }
                k++;
            }
        } else {
            int k = 2;
            for (int i = ROW - 1; i >= 0; i--) {
                int q = 2;

                for (int j = 0; j < COLUMN; j++) {

                    map[j][i] = copy[k][q];
                    q--;
                }
                k--;
            }
        }

    }

}
