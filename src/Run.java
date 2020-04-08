import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("\u001B[47m"+"\u001B[32m");
        System.out.print("\033[H\033[2J");

        Scanner input = new Scanner(System.in);
        Player player2, player1;
        MainBoard board = new MainBoard(6, 6);
        System.out.print("Enter first player name :");
        player1 = new Player(input.nextLine(), 1);
        System.out.print("Enter second player name :");
        player2 = new Player(input.nextLine(), -1);
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
