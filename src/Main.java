public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game();
        Player p1 = new Player();
        Player p2 = new Player();
        Player[] players = {p1, p2};

        board.printInstructions();

        p1.createPlayerX();
        p2.createPlayerO();
        System.out.println(p1);
        System.out.println(p2);

        //boolean mainLoop = true;

        //FIXME: Main loop and winning conditions
        //FIXME: Both "Quit game" and "Play again" stop the program

        boolean loop = true;
        boolean loop2 = true;
        while (loop) {
            game.start(players);
            while (loop2) {
                game.play(p1, p2);
                game.winCondition(board, p1, p2);
                System.out.println("Loop end");
                if (!game.winCondition(board, p1, p2)) {
                    game.playAgain(p1, p2);
                    if (!game.playAgain(p1, p2)) {
                        loop = false;
                        loop2 = false;
                        //break;
                    }

                }
            }

        }

    }


}