import java.util.Random;
import java.util.Scanner;

public class Game {

    Board board = new Board();
    Random random = new Random();
    //Scanner scan = new Scanner(System.in);
    char turn = ' ';
    char winner = ' ';

    public Game() {

    }

    //Plays a turn and hands the next turn to the other player.
    public void turn(Player player1, Player player2) {
        if (turn == 'X') {
            printMakeAMove(player2);
            play(player1, player2);
            turn = 'O';
        } else if (turn == 'O') {
            printMakeAMove(player1);
            play(player1, player2);
            turn = 'X';
        }
    }


    //Prints whose turn it is.
    public void printMakeAMove(Player player){
        System.out.println(player.name + ", make a move.");
    }

    //Checks if input position is taken.
    public boolean isInputTaken(int input){
        System.out.println("isInputTaken: " + (board.positionNumber[input] == 'O' || board.positionNumber[input] == 'X'));
        return (board.positionNumber[input] == 'O' || board.positionNumber[input] == 'X');
    }

    //Checks if input range is valid (1 to 9, all the locations on the game board).
    public boolean isValidRange(int input){
        return input >= 1 && input <= 9;
    }

    //The selected player makes a move. It then prints the updated board and checks for victory conditions.
    public void play(Player player1, Player player2) {

        boolean exitWhileLoop = false;
        Scanner sc = new Scanner(System.in);

        while (!exitWhileLoop) {

                System.out.println("Entering play method while-loop");

              //int inputPosition = readIntFromUser(scan);
                String s = sc.nextLine();
                int inputPosition = Integer.parseInt(s);


//            try {

//              if(isValidRange(inputPosition)){

//              positionCheck(inputPosition);
                boolean isValidInput = isValidRange(inputPosition);
                System.out.println("isValidRange: " + isValidInput);

                if(isValidInput) {
                    //Here is a valid input between 1 to 9

                    boolean isTaken = isInputTaken(inputPosition);

                    if (!isTaken) { //kommer tillbaka rätt = false ska vara här
                        if (turn == 'O') {
                            System.out.println("turn O - placing X");
                            board.positionNumber[inputPosition] = 'X';
                        } else if (turn == 'X') {
                            System.out.println("turn X - placing O");
                            board.positionNumber[inputPosition] = 'O';
                        }
                        exitWhileLoop = true;
                    } else {
                        System.out.println("Position is taken; please select another location.");
                    }
                } else {
                    System.out.println("Error. Out of boundaries.");
                }

//
//            } catch (Exception e) {
//
////                inputPosition = readIntFromUser(scan);
////                exitWhileLoop = true;
//            }
        }

        board.printBoard();
        winCondition(board, player1, player2);
    }

    //Checks if input is valid (The input must be 1) an integer 2) between and included 1 and 9). UPDATE: Incorporated into play().
//    public int readIntFromUser(Scanner scan) {
//        while (true) {
//            try {
//                String s = scan.nextLine();
//                return Integer.parseInt(s);
//            } catch (Exception e) {
//                System.out.println("Try again");
//            }
//        }
//    }


    //Checks if position picked is valid (assuming input is a valid integer) UPDATE: no longer in used. See: isInputTaken.
//    public int positionCheck(int n) {
//
//        while (true) {
//            // While true take input from scanner
//            if (board.positionNumber[n] == 'O' || board.positionNumber[n] == 'X') {
//                System.out.println("Position is taken; please select another location.");       //Fix position overlap error-handling
//                n = readIntFromUser(scan);
//
//            } else break;
//        }
//        return n;
//
//    }

    //Selects a random player to begin the game.
    public void randomPlayerStart(Player[] players) {
        int plNum = random.nextInt(2);
        turn = players[plNum].symbol;
    }



    //Checks for winning conditions. Three rows, three columns and two diagonals containing the same symbol.
    public void winCondition(Board board, Player player1, Player player2) {

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
