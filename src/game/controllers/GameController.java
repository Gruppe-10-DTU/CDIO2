package game.controllers;

import game.models.*;
import game.ui.GUI;

public class GameController {
    private final Player[] players = new Player[2];
    Field[] fields = new Field[11];
    DiceHolder diceHolder = new DiceHolder();
    private GUIConverter guiConverter;

    GUI GUI;
    /*
    Not implemented yet but will be needed
    Language language;
     */
    public GameController(String language){
        players[0]=new Player("Player 1");
        players[1] = new Player("Player 2");
        int[] effects = new int[]{250, -100, 100,-20,180,0,-70,60,-80,-50,650};
        for (int i = 0; i < effects.length; i++) {
            fields[i] = new Field(effects[i], "Field " + i+2);
        }
        GUI = new GUI(guiConverter.fieldToGui(fields), guiConverter.playerToGUI(players));
    }
    public void play() {
        //Variables for core loop
        boolean win = false;
        int turn = 0;
        //Main game logic
        while(!win){

            turn(players[turn % 2]);

            if(players[turn % 2].getBalance() >= 3000){
                win = true;
            }
            //If the player lands on The Werewall - field 10, they get an extra turn.
            if(diceHolder.sum() != 10 || win){
                turn++;
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Player "+players[turn%2].getIdentifier() + " won");
    }
    private Player turn(Player player){
        System.out.println(player.getIdentifier() + "s turn");
        diceHolder.roll();
        GUI.showDice(diceHolder.getRolls());
        GUI.movePlayer(player.getIdentifier(), diceHolder.sum() - 2);
        //Set the players new balance based on the fields effect
        //sum - 2 since 1, there's only 11 fields but you can roll two and arrays are 0-indexed so it goes 0-10
        player.setBalance(fields[diceHolder.sum()-2].getEffect());
        GUI.updatePlayer(player.getIdentifier(), player.getBalance());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GUI.RemovePlayer(diceHolder.sum()-2);
        return player;
    }
}
