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
        if (inputnama.equals(nama) && inputnim.equals(nim)) {
            displayInfo();
        } else{
            System.out.println("Login gagal . Nama atau nim salah .");
        }
    }
    void displayInfo(){
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
    }
}
class Admin extends User{
    private String username = "admin361";
    private String password = "password361";

    public Admin(String nama,String nim){
        super(nama, nim);
         
    }
    
    @Override
    void Login(String inputusername,String inputpassword){
        if (username.equals(inputusername) && password.equals(inputpassword)){
            displayInfo();
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
    @Override
    void displayInfo(){
        System.out.println("Selamat datang " + getNama());
        System.out.println(getNim());
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
        if(inputnama.equals(nama) && inputnim.equals(nim)){
         displayInfo();
        } else{
            System.out.println("Maaf coba lagi.");
        }
    }
    @Override
    void displayInfo(){
        System.out.println("Selamat datang .");
        System.out.println("Nama : " + nama);
        System.out.println("Nim : " + nim);
    }

     
 }

public class Main {

    public static void main(String[] args) {
         
        Scanner scan = new Scanner(System.in);
        
        Admin admin = new Admin("admi361", "Password361");
        Mahasiswa mahasiswa = new Mahasiswa("atha", "361");

        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scan.nextInt();
        scan.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan username: ");
            String inputUser = scan.nextLine();
            System.out.print("Masukkan password: ");
            String inputPass = scan.nextLine();
            admin.Login(inputUser, inputPass);
        } else if (pilihan == 2) {
            System.out.print("Masukkan nama: ");
            String inputNama = scan.nextLine();
            System.out.print("Masukkan NIM: ");
            String inputNim = scan.nextLine();
            mahasiswa.Login(inputNama, inputNim);
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scan.close();
    }
}