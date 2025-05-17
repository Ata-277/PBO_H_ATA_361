package Pepustakaan;

public class Anggota implements Peminjaman{
    private String nama;
    private int idAnggota;

    public Anggota(String nama, int idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }
    public void DisplayAnggota( ){
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ").");
    }
    @Override
    public void pinjamBuku(String judul) {
        System.out.println(nama + " dengan ID " + idAnggota + " telah meminjam buku: " + judul);
    }

    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " dengan ID " + idAnggota + " telah mengembalikan buku: " + judul);
    }

    public void pinjamBuku(String judul, int durasi) {
        System.out.println(nama + " dengan ID " + idAnggota + " telah meminjam buku: " + judul + " selama " + durasi + " hari.");
    }
    }

