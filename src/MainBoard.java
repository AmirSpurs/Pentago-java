public class MainBoard extends Board {

    private SubBoard[] subBoards;

    public MainBoard(int row, int column) {
        super(row, column);
        subBoards = new SubBoard[4];
        for (int i = 0; i < 4; i++)
            subBoards[i] = new SubBoard(3, 3);
    }

    public int[] witchSubBoard(int x, int y) {

        int[] pos = new int[3];
        if (x < 3) {
            if (y < 3) {
                pos[0] = 0;
                pos[1] = x;
                pos[2] = y;
                return pos;
            } else {
                pos[0] = 1;
                pos[1] = x;
                pos[2] = y - 3;
                return pos;
            }
        } else if (y < 3) {
            pos[0] = 2;
            pos[1] = x - 3;
            pos[2] = y;
            return pos;
        }
        pos[0] = 3;
        pos[1] = x - 3;
        pos[2] = y - 3;
        return pos;
    }

    public void twistSubBoard(int cw, int subBoardNumber) {
        subBoards[subBoardNumber].twist(cw);
    }

    public void placeDisk(int x, int y, Player playerToPlace) {
        int[] witchONe = witchSubBoard(x, y);
        playerToPlace.addDisk(x, y);
        subBoards[witchONe[0]].getMap()[witchONe[1]][witchONe[2]] = playerToPlace.getCode();

    }

    public boolean empty(int x, int y) {
        int[] witchONe = witchSubBoard(x, y);
        return subBoards[witchONe[0]].getMap()[witchONe[1]][witchONe[2]] == 0;
    }

    public SubBoard[] getSubBoards() {
        return subBoards;
    }

    public void print() {

        for (int i = 0; i < ROW; i++)
            System.out.print("\u001B[32m" + "     " + i);
        System.out.println();
        System.out.println("\u001B[32m" + "  ____________________________________" );


        for (int i = 0; i < ROW; i++) {
            System.out.print("\u001B[32m" + i + " ");
            for (int j = 0; j < COLUMN; j++) {
                int[] witchONe = witchSubBoard(i, j);
                if (j % 3 ==0)
                    System.out.print("\u001B[32m" + "|  ");
                else
                    System.out.print("\u001B[32m" + "   ");


                if (subBoards[witchONe[0]].getMap()[witchONe[1]][witchONe[2]] == 1)
                    System.out.print("\u001B[30m" + '⬤' + "\u001B[32m" + "  ");
                else if (subBoards[witchONe[0]].getMap()[witchONe[1]][witchONe[2]] == -1)
                    System.out.print("\u001B[31m" + '⬤' + "\u001B[32m" + "  ");
                else
                    System.out.print("\u001B[37m" + '⬤' + "\u001B[32m" + "  ");
            }
            System.out.println("|");
            if (i ==5 || i==2)
            System.out.println("  ____________________________________" + "\u001B[32m");
            else
             System.out.println("                                                  " + "\u001B[47m"+"\u001B[32m");

        }
    }


}
