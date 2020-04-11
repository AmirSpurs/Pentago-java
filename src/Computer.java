/**
 * The Computer class implant a AI to play with opponent
 * Computer class is a subclass of Player class.
 *
 * @author Amirreza Hashemi
 * @version 1.0
 * @since 4/4/2020
 */
public class Computer extends Player {
    /**
     * Instantiates a new Computer.
     *
     * @param name the Computer's name
     * @param code the Computer's code
     */
    public Computer(String name, int code) {
        super(name, code);
    }

    /*
    This method returns true  if player has n (the input) disks
    vertical,horizontal or diagonal and returns false otherwise.
     */
    private boolean isItN(int n) {
        if (n == 5)
            isFiveDisk();
        int mainDiagonal, antiDiagonal, diagonal1, diagonal2;
        mainDiagonal = antiDiagonal = diagonal1 = diagonal2 = 0;
        int[] row = new int[6];
        int[] column = new int[6];
        for (int i = 0; i < 6; i++) {
            row[i] = 0;
            column[i] = 0;
        }
        for (Disk disk : getDisks()) {

            column[disk.getY()]++;
            row[disk.getX()]++;
            if (disk.getX() == disk.getY())
                mainDiagonal++;

            if (disk.getY() + disk.getX() == 5)
                antiDiagonal++;

            if (disk.getX() + disk.getY() == 4)
                diagonal2++;
            if (disk.getX() - disk.getY() == 1)
                diagonal1++;
        }
        if (antiDiagonal >= n || mainDiagonal >= n || diagonal1 == n || diagonal2 == n)
            return true;

        for (int i = 0; i < 6; i++) {
            if (row[i] >= n || column[i] >= n)
                return true;
        }
        return false;
    }

    /**
     * Finds the best move in putting disk step
     * it tries to put disk in a place that has most same color disk.
     *
     * @param mainBoard the main board of the game
     * @return the coordinates of put disk
     */
    public int[] bestPutMove(MainBoard mainBoard) {

        for (int n = 5; n > 0; n--)
            for (int i = 0; i < mainBoard.getROW(); i++) {
                for (int j = 0; j < mainBoard.getCOLUMN(); j++) {
                    if (mainBoard.empty(i, j)) {
                        int[] coordinate = new int[2];
                        coordinate[0] = i;
                        coordinate[1] = j;
                        addDisk(i, j);
                        if (isItN(n))
                            return coordinate;
                        updateDisk(mainBoard);
                    }
                }
            }
        return null;
    }

    /**
     * Finds the best move in twisting step
     * it tries to twist a sub board in a way that create most same color disk .
     *
     * @param mainBoard the main board of game
     * @return a array first element represent rotate direction second element represent sub board number
     */
    public int[] bestTwistMove(MainBoard mainBoard) {


        for (int n = 5; n >= 0; n--) {
            for (int subNumber = 0; subNumber < 4; subNumber++) {
                mainBoard.twistSubBoard(0, subNumber);
                updateDisk(mainBoard);
                int[] twist = new int[2];
                twist[0] = 0;
                twist[1] = subNumber;
                if (isItN(n))
                    return twist;
                mainBoard.twistSubBoard(1, subNumber);
                mainBoard.twistSubBoard(1, subNumber);
                updateDisk(mainBoard);
                twist[0] = 1;
                twist[1] = subNumber;
                if (isItN(n))
                    return twist;
                mainBoard.twistSubBoard(0, subNumber);
                updateDisk(mainBoard);

            }
        }

        return null;
    }
}


