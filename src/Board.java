/**
 * The Board class has row and column.
 *
 * @author Amirreza Hashemi
 * @version 1.0
 * @since 4/4/2020
 */
public class Board {
    //The row of the board.
    protected final int ROW;
    //The column of the board.
    protected final int COLUMN;

    /**
     * Instantiates a new Board.
     *
     * @param row    the row
     * @param column the column
     */
    public Board(int row, int column) {
        ROW = row;
        COLUMN = column;

    }

    /**
     * Gets row number.
     *
     * @return the row number
     */
    public int getROW() {
        return ROW;
    }

    /**
     * Gets column number.
     *
     * @return the column number
     */
    public int getCOLUMN() {
        return COLUMN;
    }
}
