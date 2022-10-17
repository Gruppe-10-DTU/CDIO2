package game.models;
import game.models.*;


public class Field {
    int[] effects = new int[]{250, -100, 100,-20,180,0,-70,60,-80,-50,650};
    int effect;
    String fieldDesc;
    public Field(int effect, String fieldDesc) {
           this.effect = effect;
           this.fieldDesc = fieldDesc;

    }
    public int getEffect(){
            return effect;
}
    public String getDesc(){
            return fieldDesc;
    }
}


