package game;

public class Game {
    private static Player[] players = new Player[2];
    static Field[] fields = new Field[11];
    DiceHolder diceHolder = new DiceHolder();
    /*
    Not implemented yet but will be needed
    Language language;
     */

    public static void play(){
        players[0]=new Player("Player 1");
        players[1] = new Player("Player 2");
        int[] effects = new int[]{250, -100, 100,-20,180,0,-70,60,-80,-50,650};
        for (int i = 0; i < effects.length; i++) {
            fields[i] = new Field(effects[i]);
        }
    }

}
