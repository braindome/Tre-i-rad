public class AI extends Player{
    String quote;
    int position;
    Player AI1 = new Player();
    Player AI2 = new Player();
    Player AI3 = new Player();
    Player[] evilAIs = {AI1, AI2, AI3,};

    public AI() {
        AI1.name = "HAL9000";
        AI2.name = "Agent Smith";
        AI3.name = "Skynet";
        this.score = 0;
    }
}
