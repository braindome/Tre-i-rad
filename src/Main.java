public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player[] players = {player1, player2};


        player1.createPlayerX();
        player2.createPlayerO();


        System.out.println(player1);
        System.out.println(player2);


        System.out.println("Let the game begin!");

        board.printInstructions();
        board.printPositions();
        board.resetBoard();

        game.randomPlayerStart(players);

        while (true) {
            game.checkTurn(player1, player2);
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