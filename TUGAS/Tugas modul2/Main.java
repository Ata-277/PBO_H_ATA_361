import java.util.Scanner;

class Admin {
    String validusername = "admin361";
    String validpassword = "password361"; 
    void Login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan username: ");
        String username = scan.nextLine();
        System.out.println("Masukkan password: ");
        String password = scan.nextLine();

        if (username.equals(validusername) && password.equals(validpassword)) {
            System.out.println("Login admin berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
}

class Mahasiswa {
    String namavalid = "athallahrasyadzaidan";
    String nimvalid = "202410370110361";

    void Login() {
        Scanner scan = new Scanner(System.in); 
        System.out.print("Masukkan nama: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scan.nextLine();

        if (nama.equals(namavalid) && nim.equals(nimvalid)) {
            displayInfo(nama, nim);
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    void displayInfo(String nama, String nim) {
        System.out.println("Login mahasiswa berhasil!");
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 

        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scan.nextInt();
        scan.nextLine(); 

        if (pilihan == 1) {
            Admin admin = new Admin();
            admin.Login();
        } else if (pilihan == 2) {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.Login();
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}