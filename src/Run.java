import java.util.Random;
import java.util.Scanner;

/**
 * The Run class show users a menu to determine game mode and then runs the game.
 *
 * @author Amirreza Hashemi
 * @version 1.0
 * @since 4/4/2020
 */
public class Run {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws InterruptedException the interrupted exception
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.print("\u001B[47m" + "\u001B[32m");
        System.out.print("\033[H\033[2J");

        Scanner input = new Scanner(System.in);
        Player player2, player1;
        String sName, fName;
        MainBoard board = new MainBoard(6, 6);
        //to give players a random color
        Random random = new Random();
        int color = random.nextInt(2);
        System.out.println("Main Menu\n1)MultiPlayer\n2)Single Player\n3)Exit");
        int mainMenu = (int) input.nextLine().charAt(0) - 48;
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
        } else {
            sName = "COM";
            if (color == 1) {
                player1 = new Player(fName, -1);
                player2 = new Computer(sName, 1);

            } else {
                player1 = new Player(fName, 1);
                player2 = new Computer(sName, -1);
            }

        }

        GameManagement game = new GameManagement(player1, player2, board);
        game.playGame();

    }
}
