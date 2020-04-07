import java.util.Scanner;

public class GameManagment {
    Player [] players ;
    MainBoard board;

    public GameManagment(Player player1,Player player2, MainBoard board) {
        players = new Player [2] ;
        players[0] = player1;
        players[1] = player2;
        this.board = board;
    }

    public void playGame () throws InterruptedException {

        Scanner input = new Scanner(System.in);
        while (!endGame()) {
            for (int i = 0; i < 2; i++) {
                boolean flag = false;
                int x ;
                int y;
                do {
                    if (flag) {
                        // user has entered invalid input
                        System.out.println("Invalid Input Try Again");
                        //sleeps to give user time to process
                        Thread.sleep(800);
                        System.out.print("\033[H\033[2J");

                    }
                    flag = true;
                    System.out.println(players[i].getName() + " Turn");
                    System.out.println("Enter disk coordinate :");
                     x = (int) input.next().charAt(0)-49;
                     y = (int) input.next().charAt(0)-49;
                    System.out.println("Pleas chose one of blokes by entering number from 0 to 3 ");
                    System.out.println("Pleas enter 1 OR 2\n1)Clockwise)\n2)Anti clockwise :");
                    int cw = (int) input.next().charAt(0)-48;

                } while (!checkAndPutDisk(x, y, players[i]) &&  !endGame());
            }


        }
    }
    public boolean endGame()
    {
        return true;
    }
        public boolean checkAndPutDisk(int x, int y, Player playerToPlace)
        {
            if (x>=board.getROW() || y>=board.getCOLUMN() || x<0 || y<0 || !board.empty(x,y))
                return false;

            board.placeDisk(x,y,playerToPlace);
            return true;
        }


    }
