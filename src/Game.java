import java.util.Random;
import java.util.Scanner;

public class Game {

    Board board = new Board();
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    char turn = ' ';
    public Game() {

    }

    public void play1(Player player1) {

        System.out.println(player1 + " , it's your turn.");
        int input = scan.nextInt();
        if (input > 0 && input <= 9) {
            board.positionNumber[input] = 'X';
        } else if (board.positionNumber[input] == 'O' || board.positionNumber[input] == 'X') {
            System.out.println("Position is taken; please select another location.");
        } else {
            System.out.println("Input not accepted. Please insert a number between 1 and 9.");
        }
    }

    public void play2(Player player2) {

        System.out.println(player2 + " , it's your turn.");
        int input = scan.nextInt();
        if (input > 0 && input <= 9) {
            board.positionNumber[input] = 'O';

        } else if (board.positionNumber[input] == 'O' || board.positionNumber[input] == 'X') {
            System.out.println("Position is taken; please select another location.");
        } else {
            System.out.println("Input not accepted. Please insert a number between 1 and 9.");
        }
    }

//    public void selectPosition(Board board) {
//        System.out.println("Select a position.");
//        int p = scan.nextInt();
//        if (p < 1 || p >= 10) {
//            System.out.println("Position is invalid. Select another location.");
//        } else if (board.positionNumber[p] == 'O' || board.positionNumber[p] == 'X') {
//            System.out.println("Position is taken; please select another location.");
//        } else {
//            System.out.println("Position " + p + " selected.");
//        }
//    }

    public void randomPlayerStart(Player[] players) {
        int plNum = random.nextInt(2);
        System.out.println(players[plNum].name + " starts the game.");
        turn = players[plNum].symbol;
    }

    public void checkTurn(Player player1, Player player2) {
        if (turn == 'X') {
            System.out.println(player2 + " , make a move.");
            play2(player2);
            turn = 'O';
        } else if (turn == 'O') {
            System.out.println(player1 + " , make a move.");
            play1(player1);
            turn = 'X';
        }
        board.printBoard();
    }

    //Checks for winning conditions. Three rows, three columns and two diagonals containing the same symbol.
    public void winCondition(Board board, Player player1, Player player2) {
        char winner = ' ';

        if (board.positionNumber[1] == 'X' && board.positionNumber[2] == 'X' && board.positionNumber[3] == 'X') winner = 'X';
        if (board.positionNumber[4] == 'X' && board.positionNumber[5] == 'X' && board.positionNumber[6] == 'X') winner = 'X';
        if (board.positionNumber[7] == 'X' && board.positionNumber[8] == 'X' && board.positionNumber[9] == 'X') winner = 'X';
        if (board.positionNumber[1] == 'X' && board.positionNumber[4] == 'X' && board.positionNumber[7] == 'X') winner = 'X';
        if (board.positionNumber[2] == 'X' && board.positionNumber[5] == 'X' && board.positionNumber[8] == 'X') winner = 'X';
        if (board.positionNumber[3] == 'X' && board.positionNumber[6] == 'X' && board.positionNumber[9] == 'X') winner = 'X';
        if (board.positionNumber[1] == 'X' && board.positionNumber[5] == 'X' && board.positionNumber[9] == 'X') winner = 'X';
        if (board.positionNumber[3] == 'X' && board.positionNumber[5] == 'X' && board.positionNumber[7] == 'X') winner = 'X';


        if (board.positionNumber[1] == 'O' && board.positionNumber[2] == 'O' && board.positionNumber[3] == 'O') winner = 'O';
        if (board.positionNumber[4] == 'O' && board.positionNumber[5] == 'O' && board.positionNumber[6] == 'O') winner = 'O';
        if (board.positionNumber[7] == 'O' && board.positionNumber[8] == 'O' && board.positionNumber[9] == 'O') winner = 'O';
        if (board.positionNumber[1] == 'O' && board.positionNumber[4] == 'O' && board.positionNumber[7] == 'O') winner = 'O';
        if (board.positionNumber[2] == 'O' && board.positionNumber[5] == 'O' && board.positionNumber[8] == 'O') winner = 'O';
        if (board.positionNumber[3] == 'O' && board.positionNumber[6] == 'O' && board.positionNumber[9] == 'O') winner = 'O';
        if (board.positionNumber[1] == 'O' && board.positionNumber[5] == 'O' && board.positionNumber[9] == 'O') winner = 'O';
        if (board.positionNumber[3] == 'O' && board.positionNumber[5] == 'O' && board.positionNumber[7] == 'O') winner = 'O';

        if (winner == 'O') {
            System.out.println(player2.name + " wins the game");

        } else if (winner == 'X') {
            System.out.println(player1.name + " wins this game.");

        }
        //If no rows, no columns or no diagonals contain X or O, start a loop though all the positions of the board and check if they have valid value.
        //If all values are valid (aka X or O), it means the board is full, and the game is therefore a draw.
        else {
            for (int i = 1; i <= 9; i++) {
                if (board.positionNumber[i] == 'X' || board.positionNumber[i] == 'O') {
                    if (i==9) {
                        winner = 'N';
                        System.out.println("Game is a draw");
                        break;
                    }
                }
            }
        }


    }
}
