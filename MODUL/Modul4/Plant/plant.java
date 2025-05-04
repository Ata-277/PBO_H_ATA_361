package Plant;

public class plant extends LivingThing implements TalkAble {
    protected String name;

    public plant(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void Talk() {
       System.out.println("I'am plant named : " + name);
    }

    @Override
    public void Grow() {
         System.out.println(name + " is growing slowly. ");
    }
    public void Breathe(){
        System.out.println(name + " is breathing");
    }

}
