import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        Player p1 = new Player();
        Player p2 = new Player();
        AI AI;
        Player[] players = {p1, p2};
        Scanner scan = new Scanner(System.in);

        board.printInstructions();

        p1.createPlayerX();
        p2.createPlayerO();
        System.out.println(p1);
        System.out.println(p2);

        //TODO: play again choice input error handling.
        //TODO: AI player class with functions.

        game.start(players);                            //Initializes the game with a random player moving first.

        while (true) {
            game.play(p1, p2);                          //Main game loop and turn handling.

            if (game.winCondition(board, p1, p2) == 'X' /*|| game.winCondition(board, p1, p2) == 'O' || game.winCondition(board, p1, p2) == 'D' */) {        //Victory/stalemate conditions.
                System.out.println("Play again?");
                String choice = scan.nextLine();
                if (choice.equals("no")) {                      //Keep playing or quit.
                    break;
                } else if (choice.equals("yes")){
                    System.out.println("Restarting game");
                    game.start(players);

                }

            } else if (game.winCondition(board, p1, p2) == 'O') {
                System.out.println("Play again?");
                String choice = scan.nextLine();
                if (choice.equals("no")) {                      //Keep playing or quit.
                    break;
                } else if (choice.equals("yes")){
                    System.out.println("Restarting game");
                    game.start(players);

                }
            } else if (game.winCondition(board, p1, p2) == 'D') {
                System.out.println("Play again?");
                String choice = scan.nextLine();
                game.isValidChoice(choice);
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