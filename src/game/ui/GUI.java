package game.ui;

import game.controllers.GameController;
import gui_fields.GUI_Board;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

public class GUI {
    GUI_Board gui;

    GameController gameController;
    public GUI(GUI_Field[] fields, GUI_Player[] players){
        gameController = new GameController("en");
        gui = new GUI_Board(gameController.getFields());
        for (GUI_Player player: players
             ) {
            gui.addPlayer(player);
        }
    }
    public void updateFields(GUI_Field[] fields){
        GUI_Field[] gameFields = gui.getFields();
        for (int i = 0; i < gameFields.length; i++) {
            gameFields[i].setTitle(fields[i].getTitle());
            gameFields[i].setDescription(fields[i].getDescription());
            gameFields[i].setSubText(fields[i].getSubText());
        }
    }
    public void movePlayer(String playerName, int roll) {
        GUI_Player player= gui.getPlayer(playerName);
        gui.getFields()[roll].setCar(player, true);
    }
    public void RemovePlayer(int roll){
        gui.getFields()[roll].removeAllCars();
    }
    public void showDice(int[] dice){
        gui.setDice(4, 1, dice[0],0,5, 1, dice[1],0);
    }
    public void updatePlayer(String name, int update){
        gui.getPlayer(name).setBalance(update);
        gui.updatePlayers();
    }
}
