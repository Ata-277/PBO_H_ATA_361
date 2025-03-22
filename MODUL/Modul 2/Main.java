class Farmer{
   private String nama;
   private String favorite;

   public String getnama(){
    return nama;
   }
   public String favorite(){
    return favorite;
   }

   public Farmer(String nama,String favorite){
    this.nama = nama;
    this.favorite = favorite;
    }
    void talk(){
        System.out.println("hi my name is "+ nama +". My favorite plant is "+ favorite);
   }
}
class Plant{
    private String nama;
    public String getnama(){
        return nama ;
    }
    public Plant(String nama){
        this.nama = nama;
    }
    void talk(){
        System.out.println("iam plant named"+ getnama());
    }
}
class Flower extends Plant{
    public Flower(String nama){
        super(nama);
    }
    @Override
    public void talk(){
        System.out.println("Hi! im "+getnama() + " and i am a Flower");
    }
}
class Fungus extends Plant{
    public Fungus(String nama){
        super(nama);
    }
    @Override
    public void talk(){
        System.out.println("Hi iam "+getnama() +" and iam a fungus");
    }
}
public class Main {

    public static void main(String[] args) {
        Plant plant1 = new Flower("sunflower");
        Plant plant2 = new Fungus("Sun shroom");
        Plant plant3 = new Flower("marigold");
        Plant plant4 = new Fungus("puff shoom");
        Plant plant5 = new Plant("cactus");
        Farmer farmer1 = new Farmer("Crazy", plant1.getnama());
        Farmer farmer2 = new Farmer("normal", plant2.getnama());

        farmer1.talk();
        farmer2.talk();
        ((Flower) plant1).talk();
        ((Fungus) plant2).talk();
        ((Flower) plant3).talk();
        ((Fungus) plant4).talk();
        plant5.talk();
    
      
    }
}