import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStok {
        
    public static void main(String[] args) {
    ArrayList<Barang> daftarBarang = new ArrayList<>();
    
    daftarBarang.add(new Barang("Laptop", 10));
    daftarBarang.add(new Barang("Mouse", 15));
    daftarBarang.add(new Barang("Keyboard", 7));

    Scanner scan = new Scanner(System.in);

     int pilihan;

        do {
            System.out.println("\n--- Menu Manajemen Stok ---");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scan.nextInt();
                scan.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("\nNama Barang: ");
                        String nama = scan.nextLine();

                        System.out.print("Stok Awal: ");
                        try {
                            int stok = scan.nextInt();
                            daftarBarang.add(new Barang(nama, stok));
                            System.out.println("Barang berhasil ditambahkan.");
                        } catch (InputMismatchException e) {
                            System.out.println("Input stok harus berupa angka!");
                            scan.nextLine();
                        }
                        break;

                    case 2:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("\nStok barang kosong.");
                        } else {
                            System.out.println("\nDaftar Barang:");
                            Iterator<Barang> iterator = daftarBarang.iterator();
                            int i = 0;
                            while (iterator.hasNext()) {
                                Barang b = iterator.next();
                                System.out.println(i++ + ". " + b.getNama() + " - Stok: " + b.getStok());
                            }
                        }
                        break;

                    case 3:
                        try {
                            if (daftarBarang.isEmpty()) {
                                System.out.println("\nStok barang kosong.");
                                break;
                            }

                            for (int i = 0; i < daftarBarang.size(); i++) {
                                Barang b = daftarBarang.get(i);
                                System.out.println(i + ". " + b.getNama() + " - Stok: " + b.getStok());
                            }

                            System.out.print("\nPilih indeks barang: ");
                            int indeks = scan.nextInt();

                            System.out.print("Jumlah yang akan diambil: ");
                            int jumlahAmbil = scan.nextInt();

                            Barang barangDipilih = daftarBarang.get(indeks);
                            if (jumlahAmbil > barangDipilih.getStok()) {
                                throw new StokTidakCukupException(
                                    "Stok untuk " + barangDipilih.getNama() + " hanya tersisa " + barangDipilih.getStok());
                            }

                            barangDipilih.setStok(barangDipilih.getStok() - jumlahAmbil);
                            System.out.println("Stok berhasil dikurangi.");

                        } catch (InputMismatchException e) {
                            System.out.println("Input harus berupa angka!");
                            scan.nextLine();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Indeks tidak valid.");
                        } catch (StokTidakCukupException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Terima kasih!");
                        break;

                    default:
                        System.out.println("Menu tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scan.nextLine();
                pilihan = 4;
            }

        } while (pilihan != 0);

        scan.close();
    }
     
    }
 