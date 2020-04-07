public class SubBoard extends Board{
    private int color;
    private int [] [] map;
    public SubBoard(int row, int column,int color) {
        super(row, column);
        map = new int [row][column] ;
        for (int i=0;i<row;i++)
            for (int j=0;j<column;j++)
                map[i][j] = 0;
        this.color = color;
    }


    public int[][] getMap() {
        return map;
    }

    public void twist(int clockWise) {
        int [][] copy = new int[3][3];
        copy = map.clone();
        if (clockWise==1)
        {
            int k =0 ;
            for (int i=ROW-1;i>=0;i--) {
                for (int j = 0; j < COLUMN; j++) {

                    map[j][i] = copy[k][j];
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
