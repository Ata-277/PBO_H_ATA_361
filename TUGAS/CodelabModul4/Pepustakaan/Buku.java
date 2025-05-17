package Pepustakaan;

public abstract class Buku {
    private String judul;
    private String penulis;
    private String gendre;
    private String bidang;

    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
        
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
     

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
     
    //ini method abstrak
    public abstract void displayInfo();
}
