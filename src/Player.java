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
        int row[] = new int[6];
        int column[] = new int[6];
        for (int i = 0; i < 5; i++) {
            row[i] = 0;
            column[i] = 0;
        }
        for (Disk disk:disks)
        {
            column[disk.getY()]++;
            row[disk.getX()]++ ;
            if (disk.getX()==disk.getY())
                mainDiagonal++;
            if (disk.getY()+disk.getX()==5)
                antiDiagonal++;
        }
        if (antiDiagonal>=5 || mainDiagonal>=5)
            return true;
        for (int i = 0; i < 5; i++) {
           if (row[i]>=5 || column[i]>=5)
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
