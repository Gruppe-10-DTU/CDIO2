package game.models;

public class State {
    private Player[] players;
    private Field[] fields;
    private int turnCounter = 0;

    public void setPlayers(Player[] players){
        this.players = players;
    }
    public Player[] getPlayers(){return players;}

    public void setFields(Field[] fields){
        this.fields = fields;
    }
    public Field[] getFields(){return fields;}

    public int getTurnCounter() {
        return turnCounter;
    }
    public void incrementTurnCounter(){
        turnCounter++;
    }
}
