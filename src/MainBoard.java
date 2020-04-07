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

    public void twistSubBoard (int cw,int subBoardNumber)
    {
        subBoards[subBoardNumber].twist(cw);
    }
    public void placeDisk(int x, int y, Player playerToPlace) {
        int witchONe = witchSubBoard(x,y);
        playerToPlace.addDisk(x, y);
        switch (witchONe) {
            case 1:
                y -= 3;
                break;
            case 2:
                x -= 3;
                break;
            case 3:
                x -= 3;
                y -= 3;
        }
        subBoards[witchONe].getMap()[x][y] = playerToPlace.getCode();


    }

    public boolean empty(int x,int y)
    {
        return subBoards[witchSubBoard(x, y)].getMap()[x][y] == 0;
    }
    public void print() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++)
                System.out.println();
            System.out.println();


        }
    }
}
