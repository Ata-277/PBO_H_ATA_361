package com.praktikum.users;

public abstract class User {
     private String nama;
     private String nim;

     public User(String nama,String nim){
        this.nama = nama;
        this.nim = nim;
     }
     public String getNama(){
        return nama;
     }
     public String getNim(){
        return nim;
     }
     public void setNama(String nama){
        this.nama = nama;
     }
     public void setNim(String nim){
        this.nim = nim;
     }
     public abstract void Login(String inputnama,String inputnim);
     public abstract void displayInfo();
     public void displayGagal() {  
        System.out.println("Login gagal! Data yang Anda masukkan salah.");
    }
    public abstract void displayAppMenu();

}
