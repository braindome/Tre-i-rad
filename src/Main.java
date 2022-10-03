import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        Player p1 = new Player();
        Player p2 = new Player();
        Player[] players = {p1, p2};
        Scanner scan = new Scanner(System.in);

        board.printInstructions();

        p1.createPlayerX();
        p2.createPlayerO();
        System.out.println(p1);
        System.out.println(p2);



        //FIXME: Score counter loops three times. Why?


        game.start(players);                            //Initializes the game with a random player moving first.
        while (true) {
            game.play(p1, p2);                          //Main game loop and turn handling.

            if (game.winCondition(board, p1, p2) == 'X' || game.winCondition(board, p1, p2) == 'O' || game.winCondition(board, p1, p2) == 'D') {        //Victory/stalemate conditions.
                System.out.println("Play again?");
                String choice = scan.nextLine();
                if (choice.equals("no")) {                      //Keep playing or quit.
                    break;
                } else if (choice.equals("yes")){
                    System.out.println("Restarting game");
                    game.start(players);

                }
            }

        }

    }

}