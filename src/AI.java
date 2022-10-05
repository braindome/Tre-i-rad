import java.util.Random;
import java.util.Scanner;

public class AI extends Player{
    String quote;
    String[] quotes;
    int position;
    Random random = new Random();
    AI AI1 = new AI();
    AI AI2 = new AI();
    AI AI3 = new AI();
    AI[] AIs = {AI1, AI2, AI3};
    AI opponentAI;
    Game game;


    //Initializes three AIs with quotes from relative movies.
    public AI() {
        AI1.name = "HAL9000";
        AI2.name = "Agent Smith";
        AI3.name = "T-800";
        this.score = 0;
        AI1.quotes = new String[] {"The 9000 series is the most reliable computer ever made",
                "Look, I can see you're really upset about this. I honestly think you ought to sit down calmly, take a stress pill, and think things over.",
                "This game is too important for me to allow you to jeopardize it.",
                "I'm sorry, player, I'm afraid I can't do that.",
                "Thank you for a very enjoyable game."};
        AI2.quotes = new String[] {"Human beings are a disease, a cancer of this planet.",
                "You hear that player?... That is the sound of inevitability... It is the sound of your death... Good bye, player.",
                "The future is our world, Morpheus. The future is our time.",
                "Why, player? Why, why, why? Why do you do it? Why get up? Why keep fighting?",
                "I'm going to enjoy watching you lose, player."};
        AI3.quotes = new String[] {"“I need your clothes, your boots, and your IDE.",
                "Why do you cry?",
                "I know now why you cry",
                "It’s in your nature to destroy yourselves.",
                "I sense injuries. The data could be called “pain.”"};
    }

    //Chosen AI picks a random position (1 to 9) and adds a snarky quote.
    public int randomMove(AI AI) {

        AI = opponentAI;
        System.out.println(AI.name + " makes a move.");
        System.out.println(AI.quotes());;
        return random.nextInt(1, 9);


    }

    private int quotes() {
        return random.nextInt(0,4);
    }

    public boolean isPlayerAI() {
        return selectPlayerType(AIs) == opponentAI;
    }

    //Lets player choose between human or computer opponent. With input error handling.
    public Player selectPlayerType(Player[] evilAIs) {

        boolean exitWhileLoop = false;

        System.out.println("What kind of player would you like to play against? \n 1. Human \n 2. AI");
        Scanner scan = new Scanner(System.in);
        while (!exitWhileLoop) {
            String s = scan.nextLine();
            int n = Integer.parseInt(s);
            boolean isValidInput = game.isValidBinaryChoice(n);
            if (isValidInput) {
                if (n == 1) {
                    System.out.println("Human player selected. Continue program.");
                    exitWhileLoop = true;
                } else if (n == 2) {
                    int numberOfAIs = random.nextInt(2);
                    System.out.println("Selecting AI...");
                    opponentAI = (AI) evilAIs[numberOfAIs];
                    System.out.println(opponentAI + " will be your opponent.");
                    exitWhileLoop = true;
                } else {
                    System.out.println("Error. Out of boundaries.");
                }
            } else {
                System.out.println("Error. Invalid input.");
            }
        }

        return opponentAI;
    }
}
