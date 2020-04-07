import java.util.ArrayList;

public class Player {
    private String name;
   private int code ;
   private ArrayList<Disk> disks;

    public Player(String name, int code) {
        this.name = name;
        this.code = code;
        disks = new ArrayList<Disk>();
    }
    public void addDisk (int x,int y)
    {
        disks.add(new Disk(x,y));
    }

    public String getName() {
        return name;
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
