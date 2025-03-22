class Pahlawan{
    private String name;
    public int umur;

    public Pahlawan(String name,int umur){
        this.name = name;
        this.umur = umur;

    } 

    void Melindungi(){
        System.out.println(name + "Melidungi masyaraakat");
    }

    public void setname(String name){
        this.name = name;
    }

    public String getname(){
        return name;
    }
}

class Superman extends Pahlawan{
    public Superman(String name,int umur){
       super( name, umur)
    }
    void Terbang(){
        System.out.println(getname() +"terbang...");
    }
    @Override
    void Melindungi(){
        System.out.println(getname()+ "Melindungi masyarakat bumi dari monster. ");
    }
}
class Spiderman extends Pahlawan{
 public Spiderman(String name,int umur){
    super(name, umur)
 }
}

    void memanjat(){
        System.out.println(getname() + "memanjat tebing. ");
    }
}
class Deadpool extends Pahlawan{
    public Deadpool(String name,int umur){
        super(name, umur);
    }
    void menyembuhkan(){
        System.out.println(super.getname()+ "Menyembuhkan diri ");
    }
    void Infoumur(){
        System.out.println(super.getname() + "berumur" + super.umur);
    }
}

public class Hero {

    public static void main(String[] args) {
        Superman superman =new Superman("christoper", 42);
        Deadpool deadpool = new Deadpool("ryan reynold", 40);
        Spiderman spiderman = new Spiderman("toby marguaire", 25);

        
        deadpool.Melindungi();
        superman.Melindungi();
        spiderman.Melindungi();

        deadpool.Infoumur();
    }
}