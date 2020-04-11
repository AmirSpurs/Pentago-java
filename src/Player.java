import java.util.ArrayList;

/**
 * The Player class implant a class to manege players
 *
 * @author Amirreza Hashemi
 * @version 1.0
 * @since 4/4/2020
 */
public class Player {
    //The player's name.
    private String name;
    //The player's code.
    private int code;
    //An ArrayList of disks.
    private ArrayList<Disk> disks;

    /**
     * Instantiates a new Player with given name and code.
     *
     * @param name the player's name
     * @param code the player's code
     */
    public Player(String name, int code) {
        this.name = name;
        this.code = code;
        disks = new ArrayList<Disk>();
    }

    /**
     * Gets ArrayList of disks.
     *
     * @return the ArrayList of disks
     */
    public ArrayList<Disk> getDisks() {
        return disks;
    }

    /**
     * Gets player's disk number.
     *
     * @return player's disk number
     */
    public int diskNumber() {
        return disks.size();
    }

    /**
     * Add disk to player
     *
     * @param x the vertical coordinates of disk
     * @param y the horizontal coordinates of disk
     */
    public void addDisk(int x, int y) {
        disks.add(new Disk(x, y));
    }

    /**
     * Gets name of player.
     *
     * @return the name of player
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if player has at least 5 consecutive disk .
     *
     * @return A boolean true if player has at least 5 consecutive disk and false otherwise
     */
    public boolean isFiveDisk() {
        int mainDiagonal, antiDiagonal, diagonal1, diagonal2;
        mainDiagonal = antiDiagonal = diagonal1 = diagonal2 = 0;
        int mainDiagonalScore, antiDiagonalScore;
        antiDiagonalScore = mainDiagonalScore = 0;
        //The second element dimension represents score.
        int[][] row = new int[6][2];
        int[][] column = new int[6][2];
        for (int i = 0; i < 6; i++) {
            row[i][0] = 0;
            column[i][0] = 0;
            row[i][1] = 0;
            column[i][1] = 0;
        }
        for (Disk disk : disks) {

            column[disk.getY()][0]++;
            column[disk.getY()][1] = 1 + disk.getX() + column[disk.getY()][1];
            row[disk.getX()][0]++;
            row[disk.getX()][1] = 1 + disk.getY() + row[disk.getX()][1];

            if (disk.getX() == disk.getY()) {
                mainDiagonal++;
                mainDiagonalScore = mainDiagonalScore + 1 + disk.getY();
            }
            if (disk.getY() + disk.getX() == 5) {
                antiDiagonal++;
                antiDiagonalScore = antiDiagonalScore + 1 + disk.getY();
            }
            if (disk.getX() + disk.getY() == 4)
                diagonal2++;
            if (disk.getX() - disk.getY() == 1)
                diagonal1++;
        }
        if ((antiDiagonal >= 5 && (antiDiagonalScore == 21 || antiDiagonalScore == 15 || antiDiagonalScore == 20)) ||
                (mainDiagonal >= 5 && (mainDiagonalScore == 21 || mainDiagonalScore == 15 || mainDiagonalScore == 20)))
            return true;
        if (diagonal1 == 5 || diagonal2 == 5)
            return true;
        for (int i = 0; i < 6; i++) {
            if ((row[i][0] >= 5 && (row[i][1] == 21 || row[i][1] == 15 || row[i][1] == 20)) ||
                    (column[i][0] >= 5 && (column[i][1] == 21 || column[i][1] == 15 || column[i][1] == 20)))
                return true;
        }
        return false;

    }

    /**
     * Update player's disk according to current situation of game's board.
     *
     * @param mainBoard the mainboard of board
     */
    public void updateDisk(MainBoard mainBoard) {
        disks.clear();

        for (int i = 0; i < mainBoard.getROW(); i++) {
            for (int j = 0; j < mainBoard.getCOLUMN(); j++) {
                int[] witchONe = mainBoard.witchSubBoard(i, j);
                if (mainBoard.getSubBoards()[witchONe[0]].getMap()[witchONe[1]][witchONe[2]] == code)
                    addDisk(i, j);
            }
        }
    }

    /**
     * Sets name of player.
     *
     * @param name the player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets player's code.
     *
     * @return the player's code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets player's code.
     *
     * @param code the player's code
     */
    public void setCode(int code) {
        this.code = code;
    }
}
