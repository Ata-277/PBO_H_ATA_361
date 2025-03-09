import java.util.Scanner;

public class Tugas1 {

    public static void main(String[] args) {
        System.out.println("pilih login : ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("masukan pilihan : ");

         Scanner scan = new Scanner(System.in);
         int pilihan =scan.nextInt();

         scan.nextLine();

         if (pilihan == 1){
           
            System.out.print("masukan username : ");
            String username =scan.nextLine();
            System.out.print("masukan password: ");
            String password =scan.nextLine();

            String validusername ="admin361";
            String validpassword ="password361";

            if (username.equals(validusername) && password.equals(validpassword)){
                System.out.println("login admin berhasi");
            } else{
                System.out.println("Login gagal! Username atau password salah.");
            }}
            else if(pilihan==2){
                String NamaMahasiswa = "athallahrasyadzaidan";
                String NimMahasiswa= "202410370110361";
                System.out.print("Masukan nama : ");
                String nama =scan.nextLine();
                System.out.print("Masukan NIM : ");
                String nim =scan.nextLine();
                 

                if(nama.equals(NamaMahasiswa) && nim.equals(NimMahasiswa)){
                    System.out.println("Login mahasiswa berhasil !");
                    System.out.println("Nama : "+ nama);
                    System.out.println("Nim : " + nim );
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }

            } else {
                System.out.println("pilihan tidak valid");
            }
            scan.close();
         }

   
}