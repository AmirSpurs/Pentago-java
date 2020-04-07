public class SubBoard extends Board{
    private int color;
    private int [] [] map;

    public SubBoard(int row, int column,int color) {
        super(row, column);
        this.color = color;
        map = new int [row][column] ;
        for (int i=0;i<row;i++)
            for (int j=0;j<column;j++)
                map[i][j] = 0;
    }

    // for test
    public void setMap(int x ,int y,int n) {
        map[x][y] = n;
    }

    public int[][] getMap() {
        return map;
    }

    public void twist(int clockWise) {
        int [][] copy = new int[3][3];
        for (int i=0;i<ROW;i++)
            for (int j=0;j<COLUMN;j++)
                copy[i][j] = map[i][j];
        if (clockWise==0)
        {
            int k =0 ;
            for (int i=ROW-1;i>=0;i--) {
                for (int j = 0; j < COLUMN; j++) {

                    map[j][i] = copy[k][j];
                  //  System.out.println(" "+k+" "+j+" "+copy[k][j]);
                }
                k++ ;
            }
        }
        else
        {
            int k =2 ;
            for (int i=ROW-1;i>=0;i--) {
                int q = 2;

                for (int j = 0; j < COLUMN; j++) {

                    map[j][i] = copy[k][q];
                    q--;
                }
                k-- ;
            }
        }

    }

}
