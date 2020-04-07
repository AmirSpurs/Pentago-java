public class MainBoard extends Board {

    SubBoard[] subBoards;

    public MainBoard(int row, int column) {
        super(row, column);
        subBoards = new SubBoard[4];
        for (int i = 0; i < 4; i++)
            subBoards[i] = new SubBoard(3, 3, i);
    }

    private int witchSubBoard(int x, int y) {
        if (x < 3) {
            if (y < 3)
                return 0;
            else
                return 1;
        } else if (y < 3)
            return 2;
        return 3;
    }

    public void placeDisk(int x, int y, Player playerToPlace) {
        playerToPlace.addDisk(x, y);
        subBoards[witchSubBoard(x, y)].getMap()[x][y] = playerToPlace.getCode();
    }

    public void print() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++)
                System.out.println();
            System.out.println();


        }
    }
}
