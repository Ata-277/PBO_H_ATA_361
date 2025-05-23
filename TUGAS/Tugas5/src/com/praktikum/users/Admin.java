package com.praktikum.users;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.praktikum.Data.Item;
import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import java.util.Iterator;

public class Admin extends User implements AdminActions  {
    private String username;
private String password;

public Admin(String username, String password) {
    super(username, password);
    this.username = username;
    this.password = password;
}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    Scanner scan = new Scanner(System.in);

    @Override
    public void manageItem() {
        boolean loop = true;

        while (loop) {
            System.out.println("\n===== KELOLA MAHASISWA =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Kembali");

            System.out.print("Masukkan pilihan: ");
            try {
                int pilihan = scan.nextInt();
                scan.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan Nama Mahasiswa: ");
                        String nama = scan.nextLine();

                        System.out.print("Masukkan NIM Mahasiswa: ");
                        String nim = scan.nextLine();

                        LoginSystem.userlist.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa berhasil ditambahkan!");
                        break;

                    case 2:
                        System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
                        String targetNim = scan.nextLine();
                        boolean ditemukan = false;

                        Iterator<User> it_user = LoginSystem.userlist.iterator();
                        while (it_user.hasNext()) {
                            User user = it_user.next();
                            if (user instanceof Mahasiswa && user.getNim().equals(targetNim)) {
                                it_user.remove();
                                ditemukan = true;
                                System.out.println("Mahasiswa dengan NIM " + targetNim + " berhasil dihapus.");
                                break;
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                        }

                        break;

                    case 3:
                        loop = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR: Input harus berupa angka!");
                scan.nextLine();
            }
        }
    }

    @Override
    public void manageUser() {
        boolean loop = true;

        while (loop) {
            try {
                System.out.println("\n1. Lihat Semua Laporan");
                System.out.println("2. Tandai Barang Yang Diambil");
                System.out.println("3. Kembali");
                System.out.print("Masukkan pilihan: ");
                int pilihan = scan.nextInt();
                scan.nextLine(); // membersihkan newline

                switch (pilihan) {
                    case 1:
                        lihatSemuaLaporan();
                        break;
                    case 2:
                        tandaiBarangDiambil();
                        break;
                    case 3:
                        loop = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Hanya masukkan angka!!");
                scan.nextLine();  
            }
        }
    }

    private void lihatSemuaLaporan() {
        Iterator<Item> barangIterator = LoginSystem.reportItems.iterator();

        if (!barangIterator.hasNext()) {
            System.out.println("Tidak ada barang...");
            return;
        }

        System.out.printf("%-5s %-25s %-40s %-30s %-30s\n", "NO", "NAMA", "DESKRIPSI", "LOKASI", "STATUS");
        int index = 1;
        while (barangIterator.hasNext()) {
            Item barang = barangIterator.next();
            System.out.printf("%-5d %-25s %-40s %-30s %-30s\n", index++, barang.getItemName(),
                    barang.getDescription(), barang.getLocation(), barang.getStatus());
        }
    }

    private void tandaiBarangDiambil() {
        boolean adaReported = false;
        int index = 0;

        System.out.printf("%-5s %-25s %-40s %-30s %-30s\n", "NO", "NAMA", "DESKRIPSI", "LOKASI", "STATUS");

        for (int i = 0; i < LoginSystem.reportItems.size(); i++) {
            Item barang = LoginSystem.reportItems.get(i);
            if ("Reported".equalsIgnoreCase(barang.getStatus())) {
                System.out.printf("%-5d %-25s %-40s %-30s %-30s\n", i, barang.getItemName(),
                        barang.getDescription(), barang.getLocation(), barang.getStatus());
                adaReported = true;
            }
        }

        if (!adaReported) {
            System.out.println("Tidak ada barang yang masih berstatus 'Reported'.");
            return;
        }

        try {
            System.out.print("Masukkan nomor indeks barang yang ingin ditandai: ");
            int inputIndex = scan.nextInt();
            scan.nextLine();

            Item barangDipilih = LoginSystem.reportItems.get(inputIndex);

            if ("Claimed".equalsIgnoreCase(barangDipilih.getStatus())) {
                System.out.println("Barang sudah ditandai sebagai 'Claimed'.");
            } else {
                barangDipilih.setStatus("Claimed");
                System.out.println("Barang berhasil ditandai sebagai 'Claimed'!");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Input harus berupa angka!");
            scan.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: Indeks tidak valid. Pastikan angka sesuai daftar!");
        }
    }

   @Override
    public void displayInfo(String nama, String nim) {
        System.out.println("Nama: " + nama);
        System.out.println("Nim: "+ nim);
    }

    @Override
    public void displayAppMenu() {
        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan: ");

            try {
                pilihan = scan.nextInt();
                scan.nextLine();  

                switch (pilihan) {
                    case 1:
                        manageItem();
                        break;
                    case 2:
                        manageUser();
                        break;
                    case 0:
                        System.out.println("Logout...");
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Input harus berupa angka!");
                scan.nextLine();
            }
        }
    }
}
