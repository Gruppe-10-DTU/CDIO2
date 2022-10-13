package game;

public class Game {
    private static final Player[] players = new Player[2];
    static Field[] fields = new Field[11];
    static DiceHolder diceHolder = new DiceHolder();
    /*
    Not implemented yet but will be needed
    Language language;
     */

    public static void main(String[] args) {
        play();
    }
    public static void play(){
        players[0]=new Player("Player 1");
        players[1] = new Player("Player 2");
        int[] effects = new int[]{250, -100, 100,-20,180,0,-70,60,-80,-50,650};
        for (int i = 0; i < effects.length; i++) {
            fields[i] = new Field(effects[i], "Field " + i+2);
        }
        //Variables for core loop
        boolean win = false;
        int turn = 0;
        //Main game logic
        while(!win){
            diceHolder.roll();

            //Set the players new balance based on the fields effect
            //sum - 2 since 1, there's only 11 fields but you can roll two and arrays are 0-indexed so it goes 0-10
            players[turn % 2].setMoney(players[turn % 2].getMoney() + fields[diceHolder.sum()-2].getEffect());

            if(players[turn % 2].getMoney() >= 3000){
                win = true;
            }
            //If the player lands on The Werewall - field 10, they get an extra turn.
            if(diceHolder.sum() != 10 || win){
                turn++;
            }
        }
        System.out.println("Player "+players[turn%2].getIdentifier() + " won");
    }

}
