import Pepustakaan.Anggota;
import Pepustakaan.Fiksi;
import Pepustakaan.NonFiksi;

public class Main {
        public static void main(String[] args) {
            Fiksi fiksi = new Fiksi("Harry Potter", "J.K. Rowling", "Fantasy");
        NonFiksi nonFiksi = new NonFiksi("Carl Sagan: A Life", "Keay Davidson", "Sains");

        Anggota anggota1 = new Anggota("ATA", 361);
        Anggota anggota2 = new Anggota("Rama", 345);

        fiksi.displayInfo();
        nonFiksi.displayInfo();

        System.out.println();

        anggota1.DisplayAnggota();
        anggota2.DisplayAnggota();
        System.out.println();

        anggota1.pinjamBuku("Harry potter");
        anggota2.pinjamBuku("Carl Sagan: A life", 3);
        System.out.println();

        anggota1.kembalikanBuku("Harry potter");
        anggota2.kembalikanBuku("Carl sagan: A Life");






        
         

        }
    }