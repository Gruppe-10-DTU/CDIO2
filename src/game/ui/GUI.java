package game.ui;

import game.controllers.GameController;
import gui_fields.GUI_Board;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

import javax.swing.*;
import java.awt.*;
import static javax.swing.JOptionPane.*;

public class GUI {
    GUI_Board gui;
    GameController gameController;
    private Button waitButton;
    private Button rollButton;
    private Button languageMenu;

    //TODO better way to show buttons
    public GUI(){
        gameController = new GameController();
        gui = new GUI_Board(gameController.getFields());
        for (GUI_Player player: gameController.getPlayers()
             ) {
            gui.addPlayer(player);
        }
        waitButton = new Button("Ok");
        waitButton.addActionListener(e -> endTurn());
        rollButton = new Button("Roll");
        rollButton.setBounds(0,0,50,20);
        rollButton.addActionListener(e -> startTurn());
        gui.getUserInput("",rollButton);

        languageMenu = new Button(gameController.getLanguageButton());
        languageMenu.addActionListener(e -> {
            //TODO add function to see supported language
            String[] list = new String[] {"English", "Danish"};
            String language = (String) JOptionPane.showInputDialog(
                gui, "Please choose a language", "Language", QUESTION_MESSAGE,null,list,"English" );
            updateFields(gameController.updateFields(language));
            languageMenu.setLabel(gameController.getLanguageButton());
            rollButton.setLabel(gameController.getRollButton());
        });
        gui.getUserInput("",languageMenu);

    }
    private void startTurn(){
        showDice(gameController.roll());
        int sum = gameController.sum();
        GUI_Player tmp = gui.getPlayer(gameController.getActivePlayer());
        gui.getFields()[sum].setCar(tmp,true);
        gui.clearInputPanel();
        tmp.setBalance(gameController.turn());
        if(gameController.hasWon()){
            gameOver(gameController.getActivePlayer());
        }else{
            gui.getUserInput("",waitButton);
            gui.getUserInput(gui.getFields()[sum].getDescription(),languageMenu);
        }
    }
    private void gameOver(String winner){
        System.out.println(winner);
    }
    private void endTurn(){
        //gui.updatePlayers();
        gui.getFields()[gameController.sum()].removeAllCars();
        gui.clearInputPanel();
        gui.getUserInput("",rollButton);
        gui.getUserInput(gameController.rollText(),languageMenu);
    }
    public void updateFields(GUI_Field[] fields){
        GUI_Field[] gameFields = gui.getFields();
        for (int i = 0; i < gameFields.length; i++) {
            gameFields[i].setTitle(fields[i].getTitle());
            gameFields[i].setDescription(fields[i].getDescription());
            gameFields[i].setSubText(fields[i].getSubText());
        }
    }
    private void showDice(int[] dice){
        gui.setDice(4, 1, dice[0],0,5, 1, dice[1],0);
    }
}
