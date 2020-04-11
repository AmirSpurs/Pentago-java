public class Computer extends Player
{
    public Computer(String name, int code) {
        super(name, code);
    }
    public boolean isITN(int n)
    {
        if (n==5)
            isFiveDisk();
        int mainDiagonal, antiDiagonal,diagonal1,diagonal2;
        mainDiagonal = antiDiagonal =diagonal1=diagonal2= 0;
        int[] row = new int[6];
        int[] column = new int[6];
        for (int i = 0; i < 6; i++) {
            row[i] = 0;
            column[i] = 0;
        }
        for (Disk disk: getDisks())
        {

            column[disk.getY()] ++;
            row[disk.getX()]++ ;
            if (disk.getX()==disk.getY())
                mainDiagonal++;

            if (disk.getY()+disk.getX()==5)
                antiDiagonal++;

            if (disk.getX()+disk.getY()==4)
                diagonal2++ ;
            if (disk.getX()-disk.getY()==1)
                diagonal1++;
        }
        if (  antiDiagonal>=n || mainDiagonal>=n || diagonal1==n || diagonal2==n )
            return true;

        for (int i = 0; i < 6; i++) {
            if (row[i]>=n  || column[i]>=n )
                return true;
        }
        return false;
    }
    public int [] bestPutMove (MainBoard mainBoard) {

        for (int n = 5;n>0;n--)
            for (int i = 0; i < mainBoard.getROW(); i++)
            {
                for (int j = 0; j < mainBoard.getCOLUMN(); j++)
                {
                    if (mainBoard.empty(i,j)) {
                        int[] coordinate = new int[2];
                        coordinate[0] = i;
                        coordinate[1] = j;
                        addDisk(i, j);
                        if (isITN(n))
                            return coordinate;
                        updateDisk(mainBoard);
                    }
                }
            }
        return null ;
    }
    public int [] bestTwistMove (MainBoard mainBoard)
    {


            for (int n = 5; n >= 0; n--) {
                for (int subNumber = 0; subNumber < 4; subNumber++) {
                    mainBoard.twistSubBoard(0, subNumber);
                    updateDisk(mainBoard);
                    int[] twist = new int[2];
                    twist[0] = 0;
                    twist[1] = subNumber;
                    if (isITN(n))
                        return twist;
                    mainBoard.twistSubBoard(1, subNumber);
                    mainBoard.twistSubBoard(1, subNumber);
                    updateDisk(mainBoard);
                    twist[0] = 1;
                    twist[1] = subNumber;
                    if (isITN(n))
                        return twist;
                    mainBoard.twistSubBoard(0, subNumber);
                    updateDisk(mainBoard);

                }
            }



        return null ;
    }
}


