import java.util.ArrayList;

public class Board {
    int boardSize;
    char[] positionNumber = new char[10];

    public Board() {


    }

    public void printBoard() {

        System.out.println("\n\n");
        System.out.println("\n\n");
        System.out.println("\t\t  " + positionNumber[1] + " | " + positionNumber[2] + " | " + positionNumber[3]);
        System.out.println("\t\t ___|___|___ " );
        System.out.println("\t\t  " + positionNumber[4] + " | " + positionNumber[5] + " | " + positionNumber[6]);
        System.out.println("\t\t ___|___|___ " );
        System.out.println("\t\t  " + positionNumber[7] + " | " + positionNumber[8] + " | " + positionNumber[9]);
        System.out.println("\n\n" );

    }
}
