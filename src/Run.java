import java.util.Random;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("\u001B[47m" + "\u001B[32m");
        System.out.print("\033[H\033[2J");

        Scanner input = new Scanner(System.in);
        Player player2, player1;
        String sName,fName;
        MainBoard board = new MainBoard(6, 6);
        Random random = new Random();
        int color = random.nextInt(2);
        System.out.println("Main Menu\n1)MultiPlayer\n2)Single Player\n3)Exit");
        int mainMenu = (int) input.nextLine().charAt(0) - 48 ;
        if (mainMenu != 2 && mainMenu != 1)
            return;
        System.out.print("Enter first player name :");
        fName = input.nextLine();

        if (mainMenu == 1) {
            System.out.print("Enter second player name :");
            sName = input.nextLine();

            if (color == 1) {
                player1 = new Player(fName, -1);
                player2 = new Player(sName, 1);

            } else {
                player1 = new Player(fName, 1);
                player2 = new Player(sName, -1);
            }
        }
        else
        {
            sName = "COM" ;
            if (color == 1) {
                player1 = new Player(fName, -1);
                player2 = new Computer(sName, 1);

            } else {
                player1 = new Player(fName, 1);
                player2 = new Computer(sName, -1);
            }

        }

        GameManagment game = new GameManagment(player1, player2, board);
        game.playGame();


        // lets.print();
//        SubBoard s = new SubBoard(3, 3, 1);
//        int k = 0;

//
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++) {
//                k++;
//                s.setMap(i, j, k);
//            }
//        s.twist(0);
//        for (int i = 0; i < 3; i++)
//        {
//            for (int j = 0; j < 3; j++)
//                System.out.print(s.getMap()[i][j] + " ");
//            System.out.println();
//
//        }
    }
}
