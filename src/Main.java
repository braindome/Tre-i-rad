public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player[] players = {player1, player2};



        System.out.println("1. The game is played on a grid.");
        System.out.println("2. Insert player names and select a symbol to use (X or O).");
        System.out.println("3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.");
        System.out.println("4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie. ");
        System.out.println("5. Squares are inputted according to the following table:");
        System.out.println("\n");
        System.out.println("\t\t  " + 1 + " | " + 2 + " | " + 3);
        System.out.println("\t\t ___|___|___ " );
        System.out.println("\t\t  " + 4 + " | " + 5 + " | " + 6);
        System.out.println("\t\t ___|___|___ " );
        System.out.println("\t\t  " + 7 + " | " + 8 + " | " + 9);
        System.out.println("\n" );

        System.out.println("Let the game begin!");
        player1.createPlayerX();
        player2.createPlayerO();
        System.out.println(player1);
        System.out.println(player2);


        board.resetBoard();

        game.randomPlayerStart(players);

        while (true) {
            game.checkTurn(player1, player2);
            //game.winCondition(board, player1, player2);
        }


//        board.positionNumber[1] = 'O';
//        board.positionNumber[2] = 'X';
//        board.positionNumber[3] = 'O';
//        board.positionNumber[4] = 'O';
//        board.positionNumber[5] = 'X';
//        board.positionNumber[6] = 'X';
//        board.positionNumber[7] = 'X';
//        board.positionNumber[8] = 'O';
//        board.positionNumber[9] = 'X';

//        board.positionNumber[1] = 'X';
//        board.positionNumber[2] = 'X';
//        board.positionNumber[3] = 'X';


    }
}