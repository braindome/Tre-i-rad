import java.util.Random;
import java.util.Scanner;

public class Game {

    Board board = new Board();
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    Player player1 = new Player();
    Player player2 = new Player();
    char turn = ' ';
    char winner = ' ';

    public Game() {

    }

    public void play() {
        int input = scan.nextInt();
        if (positionCheck(input)) {
            if (input > 0 && input <= 9) {
                if (turn == 'O') {
                    board.positionNumber[input] = 'X';
                } else if (turn == 'X') {
                    board.positionNumber[input] = 'O';
                }
            } else {
                System.out.println("Input not valid. Please insert an integer from 1 to 9.");           //Fix input error-handling
            }
        }

        board.printBoard();
        winCondition(board, player1, player2);
    }

    public boolean positionCheck(int n) {
        if (board.positionNumber[n] == 'O' || board.positionNumber[n] == 'X') {
            System.out.println("Position is taken; please select another location.");                   //Fix position overlap error-handling
            return false;

        }
        return true;
    }


    public void randomPlayerStart(Player[] players) {
        int plNum = random.nextInt(2);
        turn = players[plNum].symbol;
    }

    public void checkTurn(Player player1, Player player2) {
        if (turn == 'X') {
            System.out.println(player2.name + ", make a move.");
            play();
            turn = 'O';
        } else if (turn == 'O') {
            System.out.println(player1.name + ", make a move.");
            play();
            turn = 'X';
        }
    }



    //Checks for winning conditions. Three rows, three columns and two diagonals containing the same symbol.
    public void winCondition(Board board, Player player1, Player player2) {
        //char winner = ' ';

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

        //If no rows, no columns or no diagonals contain X or O, start a loop though all the positions of the board and check if they have valid value.
        //If all values are valid (aka X or O), it means the board is full, and the game is therefore a draw.
        if (winner == 'O') {
            System.out.println(player2.name + " wins the game");
            player2.score++;
            System.out.println(player2.name + " score: " + player2.score);

        } else if (winner == 'X') {
            System.out.println(player1.name + " wins this game.");
            player1.score++;
            System.out.println(player1.name + " score: " + player1.score);

        } else {
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
