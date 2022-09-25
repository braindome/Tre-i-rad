public class Game {

    public Game() {

    }

    public void play() {

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
        //If all values are valid (aka X or O), it means the board is full and the game is therefore a draw.
        else {
            for (int i = 1; i <= 9; i++) {
                if (board.positionNumber[i] == 'X' || board.positionNumber[i] == 'O') {
                    if (i==9) {
                        System.out.println("Game is a draw");
                        break;
                    }
                }
            }
        }


    }
}
