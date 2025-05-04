package Plant;

public class Flower implements TalkAble  {

    protected String name;

    public Flower(String name){
        this.name = name;
    }

    @Override
    public void Talk() {
         System.out.println("Hi am " + name + " & I'am a Flower");
    }
     


}
