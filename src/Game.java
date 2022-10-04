import java.util.Random;
import java.util.Scanner;

public class Game {

    Board board;
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    char turn = ' ';

    public Game(Board board) {
        this.board = board;

    }



    //Prints whose turn it is.
    public void printMakeAMove(Player player){
        System.out.println(player.name + ", make a move.");
    }

    //Checks if input position is taken.
    public boolean isInputTaken(int input){
        //System.out.println("isInputTaken: " + (board.positionNumber[input] == 'O' || board.positionNumber[input] == 'X'));
        return (board.positionNumber[input] == 'O' || board.positionNumber[input] == 'X');
    }

    //Checks if input range is valid (1 to 9, all the locations on the game board).
    public boolean isValidRange(int input){
        return input >= 1 && input <= 9;
    }

    public boolean isValidChoice(String input) {
//        try { return input;} catch (Exception e) {
//            System.out.println("Yes/no?");
//        }
        return input.equals("yes") || input.equals("no");
    }

    //The selected player makes a move. It then prints the updated board and checks for victory conditions.
    public void play(Player player1, Player player2) {

        //winCondition(board, player1, player2);

        boolean exitWhileLoop = false;
        Scanner sc = new Scanner(System.in);

        while (!exitWhileLoop) {

            String s = sc.nextLine();
            int inputPosition = Integer.parseInt(s);

            boolean isValidInput = isValidRange(inputPosition);
            System.out.println("isValidRange: " + isValidInput);

            if(isValidInput) {
                //Here is a valid input between 1 to 9
                boolean isTaken = isInputTaken(inputPosition);

                if (!isTaken) { //kommer tillbaka rätt = false ska vara här
                    if (turn == 'X') {
                        printMakeAMove(player2);
                        board.positionNumber[inputPosition] = 'X';
                        turn = 'O';
                    } else if (turn == 'O') {
                        printMakeAMove(player1);
                        board.positionNumber[inputPosition] = 'O';
                        turn = 'X';
                    }
                    exitWhileLoop = true;

                } else {
                    System.out.println("Position is taken; please select another location.");
                }
            } else {
                System.out.println("Error. Out of boundaries.");
            }

        }
        //Checks for victory/draw conditions after each turn.
        board.printBoard();
    }


    //Selects a random player to begin the game.
    public void randomPlayerStart(Player[] players) {
        int plNum = random.nextInt(2);
        turn = players[plNum].symbol;
        System.out.println(players[plNum].name + ", you have the first move.");
    }



    //Checks for winning conditions. Three rows, three columns and two diagonals containing the same symbol.
    public char winCondition(Board board, Player player1, Player player2) {

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

        //If no rows, no columns or no diagonals contain X or O, start a loop though all the positions of the board and check if they have valid value.
        //If all values are valid (aka X or O), it means the board is full, and the game is therefore a draw.
        if (winner == 'O') {
            System.out.println(player2.name + " wins this game.");
            player2.score = player2.score + 1;
            System.out.println("+1 score to " + player2.name);
            System.out.println(player2.name + " score: " + player2.score);
            return winner;

        }
        if (winner == 'X') {
            System.out.println(player1.name + " wins this game.");
            player1.score = player1.score + 1;
            System.out.println("+1 score to " + player1.name);
            System.out.println(player1.name + " score: " + player1.score);
            return winner;

        }

        for (int i = 1; i <= 9; i++) {
            if (board.positionNumber[i] == 'X' || board.positionNumber[i] == 'O') {
                if (i==9) {
                    char draw = 'D';
                    System.out.println("Game is a draw");
                    return draw;
                }

            } else break;
        }

        return winner;


    }

    //Groups all new start functions.
    public void start(Player[] players) {
        board.printInstructions();
        randomPlayerStart(players);
        board.resetBoard();
    }

    //Input handling to use in playAgain
    public boolean menuChoice (int n) {
        return n == 1 || n == 2;
    }

    //Replay menu method WIP
    public boolean playAgain(Player player1, Player player2) {
        System.out.println("Would you like to play again? \n [1] Play again \n [2] Quit program");
        int choice = Integer.parseInt(scan.nextLine());
        if (menuChoice(choice)) {
            if (choice == 1) {
                System.out.println("Score: " + "\n" + player1.name + " score: " + player1.score + "\n" + player2.name + " score: " + player2.score);
                System.out.println("Restarting....");
                return true;

            } else if (choice == 2) {
                System.out.println("Thank you for playing!");
                System.out.println("Final score: " + "\n" + player1.name + " score: " + player1.score + "\n" + player2.name + " score: " + player2.score);
                return false;
            } else return false;
        }

        return true;
    }
}
