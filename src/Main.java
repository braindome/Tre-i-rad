public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game();
        Player p1 = new Player();
        Player p2 = new Player();
        Player[] players = {p1, p2};

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

        p1.createPlayerX();
        p2.createPlayerO();
        System.out.println(p1);
        System.out.println(p2);


        board.resetBoard();

        game.randomPlayerStart(players);

        while (true) {
            game.turn(p1, p2);
        }



    }
}