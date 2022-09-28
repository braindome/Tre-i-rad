public class Board {
    //Board design: list of 10 chars. 3x3 grid numbered from 1 to 9 left to right, from top row to bottom.
    //Position number index starting at 1 for ease of coding.
    char[] positionNumber = new char[10];

    public Board() {

    }

    //Resets board to empty.
    public void resetBoard() {
        for (int i = 1; i <= 9; i++) {
            positionNumber[i] = ' ';
        }
        System.out.println("\n\n");
        System.out.println("\t\t  " + positionNumber[1] + " | " + positionNumber[2] + " | " + positionNumber[3]);
        System.out.println("\t\t ___|___|___ " );
        System.out.println("\t\t  " + positionNumber[4] + " | " + positionNumber[5] + " | " + positionNumber[6]);
        System.out.println("\t\t ___|___|___ " );
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
        System.out.println("\t\t ___|___|___ " );
        System.out.println("\t\t  " + positionNumber[4] + " | " + positionNumber[5] + " | " + positionNumber[6]);
        System.out.println("\t\t ___|___|___ " );
        System.out.println("\t\t  " + positionNumber[7] + " | " + positionNumber[8] + " | " + positionNumber[9]);
        System.out.println("\n\n" );

    }

}
