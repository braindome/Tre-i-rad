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


        game.start(players);
        do {
            game.play(p1, p2);

        } while (!game.winCondition(board, p1, p2));



    }
}