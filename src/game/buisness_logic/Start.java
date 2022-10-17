package game.buisness_logic;

import game.ui.Game;

public class Start {
    public static void main(String[] args) {
        GameController miniMonopoly = new GameController("en");

        miniMonopoly.play();
    }
}
