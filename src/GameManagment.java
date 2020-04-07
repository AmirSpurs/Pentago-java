import java.util.Scanner;

public class GameManagment {
    private Player [] players ;
    private MainBoard board;

    public GameManagment(Player player1,Player player2, MainBoard board) {
        players = new Player [2] ;
        players[0] = player1;
        players[1] = player2;
        this.board = board;
    }

    public void playGame () throws InterruptedException {

        Scanner input = new Scanner(System.in);
        boolean isGameFinished = false;
        while (!isGameFinished) {
            for (int i = 0; i < 2; i++) {
                board.print();

                boolean flag = false;
                int x;
                int y;
                do {
                    if (flag)
                        invalid();
                    flag = true;
                    System.out.println(players[i].getName() + " Turn");
                    System.out.println("Enter disk coordinate :");
                    x = (int) input.next().charAt(0) - 48;
                    y = (int) input.next().charAt(0) - 48;
                } while (!checkAndPutDisk(x, y, players[i]) );
                board.print();

                if (endGame())
                {
                    isGameFinished = true;
                    break;
                }
                int cw;
                int subNumber;
                flag = false ;
                do {
                    if (flag)
                        invalid();
                    flag = true;
                    System.out.println("Pleas chose one of blokes by entering number from 0 to 3 ");
                     subNumber = (int) input.next().charAt(0) - 48;
                    System.out.println("Pleas enter 0 OR 1\n0)Clockwise)\n1)Anti clockwise :");
                     cw = (int) input.next().charAt(0) - 48;
                } while (!checkAndTwist(cw,subNumber));
                if (endGame())
                {
                    isGameFinished = true;
                    break;
                }
            }
        }
    }
    public void invalid() throws InterruptedException {
        // user has entered invalid input
        System.out.println("Invalid Input Try Again");
        //sleeps to give user time to process
        Thread.sleep(800);
        System.out.print("\033[H\033[2J");
        board.print();
    }
    public boolean checkAndTwist(int cw,int subNumber)
    {
        if (cw<0 || cw>1 || subNumber<0 ||subNumber>3)
            return false;
        board.twistSubBoard(cw,subNumber);
        return true;
    }
    public boolean endGame()
    {
        for (int i = 0; i < 2; i++) {
            if (players[i].isFiveDisk()) {
                System.out.print("\033[H\033[2J");
                board.print();
                System.out.println("Game Ended");
                System.out.println(players[i].getName() + " IS THE  !!!!WINNER!!!");
                return true;
            }
        }
        return false;

    }
        public boolean checkAndPutDisk(int x, int y, Player playerToPlace)
        {
            if (x>=board.getROW() || y>=board.getCOLUMN() || x<0 || y<0 || !board.empty(x,y))
                return false;

            board.placeDisk(x,y,playerToPlace);
            return true;
        }


    }
