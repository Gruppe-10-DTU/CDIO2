package game;

public class Player {

    private int money = 1000;
    private String identifier;

    //Constructor
    public Player(String name){
        identifier = name;
    }

    // getter
    public int getMoney() {
        return money;
    }
    // setter
    public void setMoney(int newMoney) {
        this.money = newMoney;
    }

    // getter
    public String getIdentifier() {
        return identifier;
    }
    // setter
    public void setIdentifier(String newIdentifier) {
        this.identifier = newIdentifier;
    }
}
