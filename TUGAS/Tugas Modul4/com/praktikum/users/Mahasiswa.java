package com.praktikum.users;

import java.util.Scanner;

import com.praktikum.actions.MahasiswaActions;

public class Mahasiswa extends User implements MahasiswaActions {
    private String nama  = "ata";
    private String nim = "202410370110361";

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
        this.nama = nama;
        this.nim = nim;
    }

    @Override
    public void reportItem() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukan nama Barang : ");
        String namabarang = scan.nextLine();
        System.out.println("Masukan deskripsi Barang tersebut : ");
        String deskripsibarang = scan.nextLine();
        System.out.println("Dimana Lokasi terkahir/Ditemukan : ");
        String lokasibarang = scan.nextLine();
        System.out.println("Nama barang : " + namabarang +". Deskripsi barang: " + deskripsibarang + ". Lokasi terkhir ditemukan: " + lokasibarang);
    }

    @Override
    public void viewreportItem() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
        
    }

    @Override
    public void Login(String inputnama, String inputnim) {
         if (nama.equalsIgnoreCase(inputnama) && nim.equalsIgnoreCase(inputnim)){
            displayAppMenu();
         } else{
            displayGagal();
         }
    }

    @Override
    public void displayInfo() {
        System.out.println("Selamat datang.");
        System.out.println("Nama : " + nama);
        System.out.println("NIM : " + nim);
    }

    @Override
    public void displayAppMenu() {
        Scanner scan = new Scanner(System.in);
        int pilihan = 0;
        while(pilihan == 0){
            System.out.println("Tentukan pilihan.");
            System.out.println("1.Kelola laporan barang.");
            System.out.println("2.Kelola data mahasiswa.");
            System.out.println("0.Logout");
            pilihan = scan.nextInt();
            
            if(pilihan == 1){
                reportItem();
            } else if(pilihan == 2){
                viewreportItem();
            } else {
                pilihan = 1;
            }
        }
    }
    


}
