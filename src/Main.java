public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        Player p1 = new Player();
        Player p2 = new Player();
        Player[] players = {p1, p2};

        board.printInstructions();

        p1.createPlayerX();
        p2.createPlayerO();
        System.out.println(p1);
        System.out.println(p2);



        game.start(players);                            //Initializes the game with a random player moving first.

        while (true) {
            game.play(p1, p2);                          //Main game loop and turn handling.

            //Checking for victory or draw.

            if (game.winCondition(board, p1, p2) == 'O') {
                p2.score = p2.score + 1;
                System.out.println(p2.name + " score: " + p2.score);
                if (!game.playAgain()) break;
                else game.start(players);
            }

            if (game.winCondition(board, p1, p2) == 'X') {
                p1.score = p1.score + 1;
                System.out.println(p1.name + " score: " + p1.score);
                if (!game.playAgain()) break;
                else game.start(players);
            }

            if (game.winCondition(board, p1, p2) == 'D') {
                System.out.println("DRAW");
                if (!game.playAgain()) break;
                else game.start(players);
            }


        }

    }

}