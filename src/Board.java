public class Board {
    //Board design: list of 10 chars. 3x3 grid numbered from 1 to 9 left to right, from top row to bottom.
    //Position number index starting at 1 for ease of coding.
    char[] positionNumber = new char[10];

    public Board() {

    }

    public void printInstructions() {
        System.out.println("1. The game is played on a grid.");
        System.out.println("2. Insert player names and select a symbol to use (X or O).");
        System.out.println("3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.");
        System.out.println("4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie. ");
        System.out.println("5. Squares are inputted according to the following table:");
        System.out.println("\n");
        System.out.println("\t\t  " + 1 + " | " + 2 + " | " + 3);
        System.out.println("\t\t ---+---+--- " );
        System.out.println("\t\t  " + 4 + " | " + 5 + " | " + 6);
        System.out.println("\t\t ---+---+--- " );
        System.out.println("\t\t  " + 7 + " | " + 8 + " | " + 9);
        System.out.println("\n" );
        System.out.println("Let the game begin!");
    }
    //Resets board to empty.
    public void resetBoard() {
        for (int i = 1; i <= 9; i++) {
            positionNumber[i] = ' ';
        }
        System.out.println("\n\n");
        System.out.println("\t\t  " + positionNumber[1] + " | " + positionNumber[2] + " | " + positionNumber[3]);
        System.out.println("\t\t ---+---+--- " );
        System.out.println("\t\t  " + positionNumber[4] + " | " + positionNumber[5] + " | " + positionNumber[6]);
        System.out.println("\t\t ---+---+--- " );
        System.out.println("\t\t  " + positionNumber[7] + " | " + positionNumber[8] + " | " + positionNumber[9]);
        System.out.println("\n\n" );

    }

    //Prints board with updated positions.
    public void printBoard() {
        for (int i = 1; i <= 9; i++) {
            if (positionNumber[i] != 'X' && positionNumber[i] != 'O') {
                positionNumber[i] = ' ';
            }
        }
        System.out.println("\n\n");
        System.out.println("\t\t  " + positionNumber[1] + " | " + positionNumber[2] + " | " + positionNumber[3]);
        System.out.println("\t\t ---+---+--- " );
        System.out.println("\t\t  " + positionNumber[4] + " | " + positionNumber[5] + " | " + positionNumber[6]);
        System.out.println("\t\t ---+---+--- " );
        System.out.println("\t\t  " + positionNumber[7] + " | " + positionNumber[8] + " | " + positionNumber[9]);
        System.out.println("\n\n" );

    }

}
