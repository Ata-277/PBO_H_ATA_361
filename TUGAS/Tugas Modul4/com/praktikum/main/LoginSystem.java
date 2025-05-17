package com.praktikum.main;

import java.util.Scanner;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

public class LoginSystem {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        User admin = new Admin("admin361", "password361");
        User mahasiswa = new Mahasiswa("ata", "361");
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

