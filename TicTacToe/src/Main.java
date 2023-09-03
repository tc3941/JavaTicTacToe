import java.util.Scanner;

public class Main {

    public static void printDashLine() {
        System.out.println(" ");
        System.out.println("---------------------------------------------------------");
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Gameboard TicTacToe = new Gameboard();
        Scanner in = new Scanner(System.in);
        int xCord = 0;
        int yCord = 0;
        char winnerChar = ' ';
//        System.out.println(TicTacToe);
//print board

        TicTacToe.printBoard();
        while (true) {

            TicTacToe.turnPrompt();
            xCord = in.nextInt();

            if (in.hasNextInt()) {//if no comma
                yCord = in.nextInt();
            } else {
                in.next();
                yCord = in.nextInt();
            }
            printDashLine();

            if (xCord < 0 || xCord > 2 || yCord < 0 || yCord > 2) {
                System.out.println("Please choose a number between 0 and 2 (inclusively)");
                continue;
            }

            if (!TicTacToe.attemptMove(xCord, yCord)) {
                System.out.println("Please choose a valid spot");
                continue;
            }
            //   TicTacToe.attemptMove(xCord, yCord);//x
            TicTacToe.printBoard();
            winnerChar = TicTacToe.checkForWinner();

            if (winnerChar != TicTacToe.NO_WINNER) {
                break;
            }
        }

        printDashLine();

        TicTacToe.printBoard();

        if (winnerChar == TicTacToe.CAT_GAME) {
            System.out.println("Looks like a cat game! No one wins.");
        } else {
            System.out.println("Looks like the winner is: " + winnerChar + "! Congratulations!!!");
        }

    }
}