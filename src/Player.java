import java.util.Scanner;

public class Player {
    String name;
    String type;
    char symbol;
    int score = 0;
    Scanner scan = new Scanner(System.in);
    public Player() {

    }

    public boolean isValidBinaryChoice (int input){
        return input >= 1 && input <= 2;
    }



    //Functions create players and assign name, symbol and keep track of the score. UPDATE: Added player type (human or computer).
    public void createPlayerX() {
        System.out.println("Please enter name of Player X:");
        this.name = scan.nextLine();
        this.symbol = 'X';
        this.score = 0;
        System.out.println("Is this player a [1] human or a [2] computer?");

        boolean exitWhileLoop = false;

        //Input error handling. Binary choice between 1 and 2.
        while (!exitWhileLoop) {
            try {
                String s = scan.nextLine();
                int playerType = Integer.parseInt(s);
                if (isValidBinaryChoice(playerType)) {
                    if (playerType == 1) {
                        this.type = "human";
                        exitWhileLoop = true;
                    } else if (playerType == 2) {
                        this.type = "computer";
                        exitWhileLoop = true;
                    } else {
                        System.out.println("Please enter 1 or 2.");
                    }

                } else {
                    System.out.println("Please enter 1 or 2");
                }

            } catch (Exception e) {
                System.out.println("Invalid input type.");
            }
        }




    }

    public void createPlayerO() {
        System.out.println("Please enter name of Player O:");
        this.name = scan.nextLine();
        this.symbol = 'O';
        this.score = 0;
        System.out.println("Is this player a [1] human or a [2] computer?");

        boolean exitWhileLoop = false;

        while (!exitWhileLoop) {
            try {
                String s = scan.nextLine();
                int playerType = Integer.parseInt(s);
                if (isValidBinaryChoice(playerType)) {
                    if (playerType == 1) {
                        this.type = "human";
                        exitWhileLoop = true;
                    } else if (playerType == 2) {
                        this.type = "computer";
                        exitWhileLoop = true;
                    } else {
                        System.out.println("Please enter 1 or 2.");
                    }

                } else {
                    System.out.println("Please enter 1 or 2");
                }

            } catch (Exception e) {
                System.out.println("Invalid input type.");
            }
        }
    }

    //Prints string with player data.
    public String toString() {
        return "Player name: " + name + ", symbol chosen " + symbol + ". Score: " + score;
    }
}
