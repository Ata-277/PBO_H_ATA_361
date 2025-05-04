package Plant;

public abstract class LivingThing {
    protected String name;

    public abstract void Grow();

    public void Breathe(){
        System.out.println(name + "is breathing. ");
    }

}
