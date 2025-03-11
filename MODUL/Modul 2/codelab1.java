class Hewan{
    String nama ;
    String jenis;
    String suara;

    void tampilkanInfo(String namahewan,String jenishewan,String suarahewan){
     nama = namahewan;
     jenis = jenishewan;
     suara = suarahewan;
     System.out.println("nama : "+ nama);
     System.out.println("jenis : "+ jenis);
     System.out.println("suara : "+ suara);
    }
        
    }





public class codelab1 {
 public static void main(String[] args) {
    Hewan hewan1 = new Hewan();
    Hewan hewan2 = new Hewan();
    hewan1.tampilkanInfo("kucing","Mamalia","Nyann~~" );
    System.out.println();
    hewan2.tampilkanInfo("Anjing", "Mamalia", "Woof-Woof!!");
 }
    
}