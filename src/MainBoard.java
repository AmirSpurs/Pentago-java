/**
 * The MainBoard class implant a class to manage the main board of the game.
 * it's 6*6 board that contains four 3*3 sub boards.
 *
 * @author Amirreza Hashemi
 * @version 1.0
 * @since 4/4/2020
 */
public class MainBoard extends Board {

    //An array that contain 4 sub boards.
    private SubBoard[] subBoards;

    /**
     * Instantiates a new Main board with given row and column.
     *
     * @param row    the row
     * @param column the column
     */
    public MainBoard(int row, int column) {
        super(row, column);
        subBoards = new SubBoard[4];
        for (int i = 0; i < 4; i++)
            subBoards[i] = new SubBoard(3, 3);
    }

    /**
     * This method receives coordinates of a cell in main board
     * and it determine to witch sub boards it belongs and what's
     * the coordinates of the cell in that sub boards.
     *
     * @param x the vertical coordinates of disk
     * @param y the horizontal coordinates of disk
     * @return An array fist element sub board number second and third element coordinates of disk in sub board
     */
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

    /**
     * Twists a sub board.
     *
     * @param cw             the twist direction
     * @param subBoardNumber the sub board number
     */
    public void twistSubBoard(int cw, int subBoardNumber) {
        subBoards[subBoardNumber].twist(cw);
    }

    /**
     * Places disk in main board.
     *
     * @param x             the vertical coordinates of disk
     * @param y             the horizontal coordinates of disk
     * @param playerToPlace the player to place disk
     */
    public void placeDisk(int x, int y, Player playerToPlace) {
        int[] witchONe = witchSubBoard(x, y);
        playerToPlace.addDisk(x, y);
        subBoards[witchONe[0]].getMap()[witchONe[1]][witchONe[2]] = playerToPlace.getCode();

    }

    /**
     * Returns true if the given coordinates cell is empty in main board and false otherwise.
     *
     * @param x the vertical coordinates of disk
     * @param y the horizontal coordinates of disk
     * @return the boolean true if cell is empty and false otherwise
     */
    public boolean empty(int x, int y) {
        int[] witchONe = witchSubBoard(x, y);
        return subBoards[witchONe[0]].getMap()[witchONe[1]][witchONe[2]] == 0;
    }

    /**
     * Get sub boards of main board.
     *
     * @return the sub boards array
     */
    public SubBoard[] getSubBoards() {
        return subBoards;
    }

    /**
     * Print the main board.
     */
    public void print() {

        for (int i = 0; i < ROW; i++)
            System.out.print("\u001B[32m" + "     " + i);
        System.out.println();
        System.out.println("\u001B[32m" + "  ____________________________________");


        for (int i = 0; i < ROW; i++) {
            System.out.print("\u001B[32m" + i + " ");
            for (int j = 0; j < COLUMN; j++) {
                int[] witchONe = witchSubBoard(i, j);
                if (j % 3 == 0)
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
            if (i == 5 || i == 2)
                System.out.println("  ____________________________________" + "\u001B[32m");
            else
                System.out.println("                                                  " + "\u001B[47m" + "\u001B[32m");

        }
    }


}
