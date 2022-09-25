public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();


        //board.printBoard();
        player1.createPlayerX(player1);
        player2.createPlayerO(player2);


        System.out.println(player1.toString());
        System.out.println(player2.toString());
        System.out.println("Let the game begin!");
        board.printBoard();

        board.positionNumber[1] = 'O';
        board.positionNumber[2] = 'X';
        board.positionNumber[3] = 'O';
        board.positionNumber[4] = 'O';
        board.positionNumber[5] = 'X';
        board.positionNumber[6] = 'X';
        board.positionNumber[7] = 'X';
        board.positionNumber[8] = 'O';
        board.positionNumber[9] = 'X';

//        board.positionNumber[1] = 'X';
//        board.positionNumber[2] = 'X';
//        board.positionNumber[3] = 'X';


        board.printBoard();
        game.winCondition(board, player1, player2);

    }
}