package com.praktikum.users;

import java.util.Scanner;

import com.praktikum.actions.AdminActions;

public class Admin extends User implements AdminActions  {
    private String username = "Admin361";
    private String password = "Password361";

    public Admin(String nama, String nim) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public void manageItem() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUser() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
    
    @Override
    public void Login(String inputusername,String inputpassword){
        if (username.equalsIgnoreCase(inputusername) && password.equalsIgnoreCase(inputpassword)){
            displayAppMenu();
            System.out.println("login berhasil");
        } else{
            displayGagal();
        }
    }

    @Override
    public void displayInfo() {
       
        System.out.println("Selamat datang!.");
        System.out.println(username);
    }

    @Override
    public void displayAppMenu() {
        Scanner scan = new Scanner(System.in);
        int pilihan = 0 ;
        while(pilihan == 0){
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan: ");
            pilihan = scan.nextInt();

            if (pilihan == 1) {
                manageItem();
            } else if (pilihan == 2) {
                manageUser();
            } else{
                pilihan = 1;
            }
        }
        scan.close();
    }

}
