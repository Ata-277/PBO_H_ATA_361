import Manusia.Farmer;
import Plant.Flower;
import Plant.TalkAble;
import Plant.plant;

public class Main {

    public static void main(String[] args) {
        Farmer farmer = new Farmer("ata"  );

        TalkAble Myplant =  new Flower("rose");
        farmer.Talk(Myplant);

        plant cactus = new plant("cactus");
        cactus.Grow();
        cactus.Breathe();
    }
    
}
