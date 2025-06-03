package com.praktikum.users;

import java.util.Scanner;

import com.praktikum.Data.Item;
import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
import java.util.Iterator;

public class Mahasiswa extends User implements MahasiswaActions {
    private String nama  = "ata";
    private String nim = "202410370110361";

    Scanner scan = new Scanner(System.in);

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
        this.nama = nama;
        this.nim = nim;
    }
     public String getNama() {
        return nama;
    }

    
    public String getNim() {
        return nim;
    }

    @Override
    public void reportItem() {
        System.out.print("Masukkan nama barang: ");
        String namaBarang = scan.nextLine();

        System.out.print("Masukkan deskripsi barang: ");
        String deskripsiBarang = scan.nextLine();

        System.out.print("Lokasi terakhir ditemukan: ");
        String lokasiTerakhir = scan.nextLine();
 
          LoginSystem.reportItems.add(new Item(namaBarang, deskripsiBarang, lokasiTerakhir));

        System.out.println("\n===============");
        System.out.println("Barang: " + namaBarang);
        System.out.println("Deskripsi Barang: " + deskripsiBarang);
        System.out.println("Lokasi terakhir: " + lokasiTerakhir);
        System.out.println("===============");
    }
    

    @Override
    public void viewreportItem() {
       Iterator<Item> Barang = LoginSystem.reportItems.iterator();
        int index = 1;
        boolean ditemukan  = true;

        while (Barang.hasNext()) {
            Item barang = Barang.next();
            if (barang.getStatus().equals("Reported")) {
                if (ditemukan ) {
                    System.out.println("NO\tNAMA\t\tDESKRIPSI\t\tLOKASI");
                    ditemukan  = false;
                }
               System.out.println(index++ + ". " + barang.getItemName() + " | " +
                   barang.getDescription() + " | " +
                   barang.getLocation());
            }
        }

        if (ditemukan ) {
            System.out.println("Tidak ada barang berstatus 'Reported'...");
        }
    }
        
    @Override
    public void displayInfo(String nama, String nim) {
        System.out.println("Nama: " + nama);
        System.out.println("Nim: "+ nim);
    }


    @Override
    public void displayAppMenu() {
        boolean loop = true;

        do {
            System.out.println("\n===== MAHASISWA MENU =====");
            System.out.println("1. Laporkan Barang Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0: LogOut");
            int pilihan = 0;
            try {
                System.out.print("Masukkan pilihan (1/2/0): ");
                pilihan = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Masukkan hanya angka!!");
                scan.nextLine();
                continue;
            }
            switch (pilihan) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewreportItem(); 
                    break;
                case 0:
                    loop = false;
                    LoginSystem.main(null);
                    break;
                default:
                    System.err.println("Pilihan Tidak Valid...coba lagi");
                    break;
            }
        } while (loop);
    
    }
     
}
    



