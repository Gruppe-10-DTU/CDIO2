package Test;
public class testDiceHolder extends game.models.DiceHolder{
    public int sum = 0;

    public void setSum(int sum) {
        this.sum = sum;
    }


    @Override
    public int sum(){
        return this.sum;
    }

}
