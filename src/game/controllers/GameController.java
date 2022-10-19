package game.controllers;

import game.models.*;
import game.ui.GUI;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

public class GameController {
    DiceHolder diceHolder = new DiceHolder();
    private GUIConverter guiConverter;

    private Player[] players;
    private Field[] fields;

    private int turnCounter = 0;
    Language language;

    public GameController(String language){
        this.language = new Language(language);
        players = new Player[2];
        players[0]=new Player("Player 1");
        players[1] = new Player("Player 2");
        fields = new Field[12];
        int[] effects = new int[]{0,250, -100, 100,-20,180,0,-70,60,-80,-50,650};
        for (int i = 0; i < effects.length; i++) {
            fields[i] = new Field(effects[i], this.language.getLanguageValue("fieldName"+(i+1)), this.language.getLanguageValue("field"+(i+1)));
        }
    }
    public String getFieldDescription(){
        return fields[diceHolder.sum() - 1].getDescription();
    }

    public GUI_Player[] getPlayers(){
        return guiConverter.playerToGUI(players);
    }
    public GUI_Field[] getFields(){
        return guiConverter.fieldToGui(fields);
    }
    public int[] roll(){
        diceHolder.roll();
        return diceHolder.getRolls();
    }
    public int turn(){
        Player player = players[turnCounter % 2];
        player.setBalance(fields[diceHolder.sum()-1].getEffect());
        increaseTurn();
        return player.getBalance();
    }

    public int sum(){
        return diceHolder.sum() - 1;
    }
    public String getActivePlayer(){
        return players[turnCounter%2].getIdentifier();
    }
    private void increaseTurn(){
        if(diceHolder.sum() != 10){
            turnCounter++;
        }
    }
}
