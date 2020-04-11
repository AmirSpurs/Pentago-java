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
                System.out.print("\033[H\033[2J");
                board.print();
//                for (Disk disk:players[i].getDisks()
//                     ) {
//                    System.out.println("sss");
//                    System.out.println(disk.getX()+" "+disk.getY());
//
//                }

                boolean flag = false;
                int x;
                int y;
                if (players[i] instanceof Computer)
                {
                    System.out.println(players[i].getName() + " Turn");
                    //the player is COM so we should cast it
                    Computer ai = (Computer) players[i];
                    int[] coordinates = ai.bestPutMove(board);
                    ai.updateDisk(board);
                    System.out.println("Enter disk coordinate (COLUMN ROW) :");

                    System.out.println( coordinates[1] + "  " +  coordinates[0]);
                    //sleeps to give user time to process
                    Thread.sleep(1500);
                    checkAndPutDisk(coordinates[0],coordinates[1],players[i]);
                }
                else {
                    do {
                        if (flag)
                            invalid();
                        flag = true;
                        System.out.println(players[i].getName() + " Turn");
                        System.out.println("disk coordinate (COLUMN ROW) :");
                        y = (int) input.next().charAt(0) - 48;
                        x = (int) input.next().charAt(0) - 48;
                    } while (!checkAndPutDisk(x, y, players[i]));
                }

                System.out.print("\033[H\033[2J");

                board.print();

                if (endGame())
                {
                    isGameFinished = true;
                    break;
                }
                int cw;
                int subNumber;

                if (players[i] instanceof Computer)
                {
                    System.out.println(players[i].getName() + " Turn");
                    //the player is COM so we should cast it
                    Computer ai = (Computer) players[i];

                    int[] twist = ai.bestTwistMove(board);
                    players[1].updateDisk(board);
                    players[0].updateDisk(board);
                    System.out.println("Block number");
                    System.out.println(twist[1]+1);
                    if (twist[0]==0)
                        System.out.println("Clockwise");
                    else
                        System.out.println("Anti clockwise");
                    //sleeps to give user time to process
                    Thread.sleep(1500);
                }
                else {
                    flag = false;
                    do {
                        if (flag)
                            invalid();
                        flag = true;
                        System.out.println(players[i].getName() + " Turn");
                        System.out.println("Please chose one of blocks by entering number from 1 to 4 ");
                        subNumber = (int) input.next().charAt(0) - 49;
                        System.out.println("Please enter 1 OR 2\n1)Clockwise\n2)Anti clockwise");
                        Thread.sleep(800);
                        cw = (int) input.next().charAt(0) - 49;
                    } while (!checkAndTwist(cw, subNumber));
                }
                if ( draw() || endGame())
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
        players[1].updateDisk(board);
        players[0].updateDisk(board);
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
        public boolean draw()
        {
            if (players[0].diskNumber()+players[1].diskNumber()==36 ||   (players[0].isFiveDisk() && players[1].isFiveDisk())     )
            {
                System.out.println("!!!!Draw!!!!");
                return true;
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
