import java.util.Scanner;

public class Player {
    String name;
    char symbol;
    int score = 0;
    Scanner scan = new Scanner(System.in);
    public Player() {

    }


    //Functions create players and assign name, symbol and keep track of the score.
    public void createPlayerX() {
        System.out.println("Please enter name of Player X:");
        this.name = scan.nextLine();
        this.symbol = 'X';
        this.score = 0;
    }

    public void createPlayerO() {
        System.out.println("Please enter name of Player O:");
        this.name = scan.nextLine();
        this.symbol = 'O';
        this.score = 0;
    }

    //Prints string with player data.
    public String toString() {
        return "Player name: " + name + ", symbol chosen " + symbol + ". Score: " + score;
    }
}
