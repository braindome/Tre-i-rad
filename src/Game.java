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

        return (board.positionNumber[input] == 'O' || board.positionNumber[input] == 'X');
    }


    //Checks if input range is valid (1 to 9, all the locations on the game board).
    public boolean isValidRange(int input){
        return input >= 1 && input <= 9;
    }
    public boolean isValidBinaryChoice (int input){
        return input >= 1 && input <= 2;
    }

    public boolean playAgain() {

        System.out.println("Would you like to play another round?");
        String choice = scan.nextLine();
        boolean answer = choice.equals("yes") || choice.equals("no");
        while (!answer) {
            System.out.println("Invalid choice. Please type 'yes' or 'no'.");
            choice = scan.nextLine();
            answer = choice.equals("yes") || choice.equals("no");
        }
        return !choice.equals("no");
    }


    //Turn handling and moving, with input handling included in this block as well.
    public void play(Player player1, Player player2) {

        boolean exitWhileLoop = false;
        Scanner sc = new Scanner(System.in);

        //Turn handling case 1: human vs human.
        if (player1.type.equals("human") && player2.type.equals("human")) {
            while (!exitWhileLoop) {

                try {
                    String s = sc.nextLine();
                    int inputPosition = Integer.parseInt(s);

                    boolean isValidInput = isValidRange(inputPosition);
                    System.out.println("isValidRange: " + isValidInput);

                    if(isValidInput) {
                        //Here is a valid input between 1 and 9
                        boolean isTaken = isInputTaken(inputPosition);

                        if (!isTaken) {
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
                } catch (Exception e) {
                    System.out.println("Invalid input. Please pick an integer between 1 and 9.");
                }

            }
        }

        //Turn handling case 2: computer vs computer.
        //Computer inputs always an integer so there is no need for validity check.
        if (player1.type.equals("computer") && player2.type.equals("computer")) {
            while (!exitWhileLoop) {
                int inputPosition = random.nextInt(1,10);
                //System.out.println("computer inputPosition:: " + inputPosition);
                if (!isInputTaken(inputPosition)) {
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
                }
            }
        }

        //Turn handling case 3: human vs computer.
        if (player1.type.equals("human") && player2.type.equals("computer")) {
            while (!exitWhileLoop) {
                if (turn == 'X') {
                    try {
                        String s = sc.nextLine();
                        int inputPosition = Integer.parseInt(s);

                        boolean isValidInput = isValidRange(inputPosition);
                        System.out.println("isValidRange: " + isValidInput);
                        if (isValidInput) {
                            boolean isTaken = isInputTaken(inputPosition);
                            if (!isTaken) {
                                printMakeAMove(player2);
                                board.positionNumber[inputPosition] = 'X';
                                turn = 'O';
                            } else {System.out.println("Position is taken. Please select another location");}
                        } else {
                            System.out.println("Error. Out of boundaries.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please pick an integer between 1 and 9.");
                    }


                } else if (turn == 'O') {
                    int computerInput = random.nextInt(1,10);
                    boolean isTaken = isInputTaken(computerInput);
                    if (!isTaken) {
                        System.out.println("AI makes a move.");
                        board.positionNumber[computerInput] = 'O';
                        turn = 'X';
                    }
                }
                exitWhileLoop = true;


            }
        }

        //Turn handling case 4: computer vs human.
        if (player1.type.equals("computer") && player2.type.equals("human")) {
            while (!exitWhileLoop) {
                if (turn == 'O') {
                    try {
                        String s = sc.nextLine();
                        int inputPosition = Integer.parseInt(s);

                        boolean isValidInput = isValidRange(inputPosition);
                        System.out.println("isValidRange: " + isValidInput);
                        if (isValidInput) {
                            boolean isTaken = isInputTaken(inputPosition);
                            if (!isTaken) {
                                printMakeAMove(player2);
                                board.positionNumber[inputPosition] = 'O';
                                turn = 'X';
                            } else {System.out.println("Position is taken. Please select another location");}
                        } else {
                            System.out.println("Error. Out of boundaries.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please pick an integer between 1 and 9.");
                    }


                } else if (turn == 'X') {
                    int computerInput = random.nextInt(1,10);
                    boolean isTaken = isInputTaken(computerInput);
                    if (!isTaken) {
                        System.out.println("AI makes a move.");
                        board.positionNumber[computerInput] = 'X';
                        turn = 'O';
                    }
                }
                exitWhileLoop = true;


            }
        }

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

        if (winner == 'X') {
            return winner;

        }

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
            return winner;

        }


        for (int i = 1; i <= 9; i++) {
            if (board.positionNumber[i] == 'X' || board.positionNumber[i] == 'O') {
                if (i==9) {
                    return 'D';
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

}
