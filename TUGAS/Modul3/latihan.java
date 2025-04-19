import java.util.Scanner;

class User{
    private String nama;
    private String nim;

    public User(String nama,String nim){
        this.nama = nama;
        this.nim = nim;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNim(){
        return nim;
    }
    public void setNim(String nim){
        this.nim = nim;
    }
    void Login(String inputnama,String inputnim){
        if(inputnama.equals(nama) && inputnim.equals(nim)){
          Displayinfo();
        } else{
            System.out.println("gagal : ");
        }
    }
    void Displayinfo(){
        System.out.println("SELAMAT !!");
        System.out.println("Nama : " + nama);
        System.out.println("Nim : " + nim);
    }    
} 

class Admin extends User{
    private String username = "admin361";
    private String password = "password361";

    public Admin(String username,String password){
        super(username, password);
         this.username = username;
         this.password = password;
    }

    @Override
    void Login(String inputusername,String inputpassword){
        if(inputusername.equals(username) && inputpassword.equals(password)){

        } else {
            System.out.println("Gagal !");
        }
    }

    @Override
    void Displayinfo(){
        System.out.println("Selamat datang : " + username);
        System.out.println(password);
    }
}
class Mahasiswa extends User{
    private String nama = "atha";
    private String nim = "361";

   public Mahasiswa(String nama,String nim){
      super(nama, nim);
      this.nama = nama;
      this.nim = nim;
   }

   @Override
   void Login(String inputnama,String inputnim){
    if (inputnama.equals(nama) && inputnim.equals(nim)){
      Displayinfo();
    } else{
        System.out.println("Gagal !");
    }
   }
   @Override
   void Displayinfo(){
    System.out.println("Nama : " + nama);
    System.out.println("Nim : " + nim);
   }
}


public class latihan {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
    
        Admin admin = new Admin("Admin361", "password361");
        Mahasiswa mahasiswa = new Mahasiswa("ATHA", "361");

        System.out.println("SELAMAT DATANG .");
        System.out.println("1.Admin .");
        System.out.println("2. Mahasiswa .");
        System.out.println("Silahkan pilih : ");
        int pilihan = scan.nextInt();
         

        if(pilihan == 1){
            System.out.println("Masukan username : ");
            String username = scan.nextLine();
            System.out.println("Masukan password : ");
            String password = scan.nextLine();
            admin.Login(username, password);
        } else if(pilihan == 2){
            System.out.println("Masukan nama : ");
            String nama = scan.nextLine();
            System.out.println("masukan nim : ");
            String nim = scan.nextLine();
            mahasiswa.Login(nama, nim);
        } else{
            System.out.println("tidak diketahui");
        }
     
         
    }
}
