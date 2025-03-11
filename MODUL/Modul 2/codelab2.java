class RekeningBank{
    String nomorRekening ;
    String namaPemilik ;
    double saldo;

    void tampilkanInfo(String getnomorRekening,String getnamaPemilik, double getsaldo){
        nomorRekening = getnomorRekening;
        namaPemilik = getnamaPemilik;
        saldo = getsaldo;
        System.out.println("Nomor rekening :"+nomorRekening);
        System.out.println("Nama pemilik : "+namaPemilik);
        System.out.println("saldo : "+ saldo );
    }
    void setorUang(double jumlah){
        saldo += jumlah;
        System.out.println(namaPemilik+" menyetor Rp "+jumlah +". Saldo sekarang Rp"+saldo);
    }
    void tarikUang(double jumlah){
        if (saldo < jumlah) {
            System.out.println(namaPemilik+"(Gagal, saldo tidak menyukupi)"+"Saldo saat ini Rp"+saldo);
        }else{
            saldo -= jumlah;
            System.out.println(namaPemilik+" Menarik Rp"+jumlah + ". Saldo sekarang Rp"+saldo);
        }
    }
    void saldoakhir(){
        System.out.println("Nomor rekening :"+nomorRekening);
        System.out.println("Nama pemilik : "+namaPemilik);
        System.out.println("saldo : "+ saldo );
    }
}


public class codelab2 {
  public static void main(String[] args) {
    RekeningBank rekening1= new RekeningBank();
    RekeningBank rekening2= new RekeningBank();
    rekening1.tampilkanInfo("202410370110361","atha",50000);
    rekening2.tampilkanInfo("202410370110380", "rama", 60000);
    System.out.println();
    rekening1.setorUang(20000);
    rekening2.setorUang(20000);
   System.out.println();
    rekening1.tarikUang(20000);
    rekening2.tarikUang(30000);
   System.out.println();
   rekening1.saldoakhir();
   rekening2.saldoakhir();
    
  }
    
}