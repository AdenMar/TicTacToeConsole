import java.util.Scanner;

/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 *
 * @author relkharboutly
 * @date 1/5/2017
 */
public class TTTConsole {

    public static Scanner in = new Scanner(System.in); // the input Scanner

    public static TicTacToe TTTboard = new TicTacToe();

    public static int HUMAN_PLAYER = 1, COMPUTER_PLAYER = 2;

    /**
     * The entry main method (the program starts here)
     */
    public static void main(String[] args) {

        int currentState = ITicTacToe.PLAYING;
        //game loop
        while (currentState == ITicTacToe.PLAYING) {
            TTTboard.printBoard();

            // Print message if game-over
            currentState = TTTboard.checkForWinner();

            if (currentState == ITicTacToe.PLAYING) {
                System.out.println("Please enter a position 0-8: ");
                int location = in.nextInt();
                TTTboard.setMove(HUMAN_PLAYER, location);

                TTTboard.setMove(COMPUTER_PLAYER, TTTboard.getComputerMove());
            }

            if (currentState == ITicTacToe.CROSS_WON) {
                System.out.println("'X' won! Bye!");
            } else if (currentState == ITicTacToe.NOUGHT_WON) {
                System.out.println("'O' won! Bye!");
            } else if (currentState == ITicTacToe.TIE) {
                System.out.println("It's a TIE! Bye!");
            }
        } // repeat if not game-over
    }


}