import java.util.ArrayList;

public class Player {
    private String name;
    private int code;
    private ArrayList<Disk> disks;

    public Player(String name, int code) {
        this.name = name;
        this.code = code;
        disks = new ArrayList<Disk>();
    }

    public void addDisk(int x, int y) {
        disks.add(new Disk(x, y));
    }

    public String getName() {
        return name;
    }

    public boolean isFiveDisk() {
        int mainDiagonal, antiDiagonal;
        mainDiagonal = antiDiagonal = 0;
        int mainDiagonalScore, antiDiagonalScore;
        antiDiagonalScore = mainDiagonalScore = 0;
        int[][] row = new int[6][2];
        int[] []column = new int[6][2];
        for (int i = 0; i < 6; i++) {
            row[i][0] = 0;
            column[i][0] = 0;
            row[i][1] = 0;
            column[i][1] = 0;
        }
        for (Disk disk:disks)
        {
            column[disk.getY()][0] ++;
            column[disk.getY()][1] = 1 + disk.getX()+ column[disk.getY()][1];
            row[disk.getX()][0]++ ;
            row[disk.getX()][1] = 1+ disk.getY() +  row[disk.getX()][1] ;

            if (disk.getX()==disk.getY()) {
                mainDiagonal++;
                mainDiagonalScore = mainDiagonalScore + 1 + disk.getY();
            }
            if (disk.getY()+disk.getX()==5) {
                antiDiagonal++;
                antiDiagonalScore = antiDiagonalScore + 1 + disk.getY();
            }
        }
        if ( ( antiDiagonal>=5 && (antiDiagonalScore==21 || antiDiagonalScore==15)) ||( mainDiagonal>=5 && (mainDiagonalScore==21 || mainDiagonalScore==15)) )
            return true;
        for (int i = 0; i < 6; i++) {
           if ( (row[i][0]>=5 && (row[i][1]==21 || row[i][1]==15)) || (column[i][0]>=5 && (column[i][1]==21 || column[i][1]==15) ) )
               return true;
        }
        return false;

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
