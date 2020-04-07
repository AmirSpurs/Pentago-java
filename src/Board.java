public class Board {
    protected final int ROW;
    protected final int COLUMN;
    public Board(int row, int column) {
        ROW = row;
        COLUMN = column;
    }

    public int getROW() {
        return ROW;
    }

    public int getCOLUMN() {
        return COLUMN;
    }
}
