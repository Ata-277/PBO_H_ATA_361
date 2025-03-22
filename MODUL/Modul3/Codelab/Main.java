class KarakterGame {
    private String nama;
    private int kesehatan;

    // Konstruktor dengan nama dan kesehatan sebagai parameter
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // Method setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Method getter untuk nama
    public String getNama() {
        return nama;
    }

    // Method setter untuk kesehatan
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    // Method getter untuk kesehatan
    public int getKesehatan() {
        return kesehatan;
    }

    // Method serang
    public void serang(KarakterGame target) {
        System.out.println(this.nama + " menyerang " + target.getNama());
    }
}

class Pahlawan extends KarakterGame {
    // Konstruktor dengan keyword super untuk Pahlawan
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override // Mengoverride method dari kelas induknya
    public void serang(KarakterGame target) {
        // Efek serang
        System.out.println(this.getNama() + " menyerang " + target.getNama() + " menggunakan pedang");
        target.setKesehatan(target.getKesehatan() - 20);  // Mengurangi kesehatan target
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan()); // Menampilkan kesehatan terbaru target
    }
}

class Musuh extends KarakterGame {
    // Konstruktor dengan keyword super untuk Musuh
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override // Mengoverride method dari kelas induknya
    public void serang(KarakterGame target) {
        // Efek serang
        System.out.println(this.getNama() + " menyerang " + target.getNama() + " menggunakan sihir");
        target.setKesehatan(target.getKesehatan() - 15); // Mengurangi kesehatan target
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan()); // Menampilkan kesehatan terbaru target
    }
}

public class Main {

    public static void main(String[] args) {
        // pembuatan objek
        KarakterGame karakterumum = new KarakterGame("Karakter umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);
      
        //menampilkan awal status karakter
        System.out.println(brimstone.getNama() + " Memiliki " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " Memiliki " + viper.getKesehatan());


        // pemanggilan method serang
        brimstone.serang(viper); // Brimstone menyerang Viper
        viper.serang(brimstone); // Viper menyerang Brimstone
    }
}