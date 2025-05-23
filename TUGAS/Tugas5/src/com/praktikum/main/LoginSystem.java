package com.praktikum.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.praktikum.Data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import com.praktikum.error.LoginError;

public class LoginSystem {
 
    public static ArrayList<User> userlist = new ArrayList<>();
    public static ArrayList<Item> reportItems = new ArrayList<>();

    public static User login(String inputUser, String inputPass) {
        for (User user : userlist) {
            if (user instanceof Admin admin) {
                if (admin.getUsername().equals(inputUser) && admin.getPassword().equals(inputPass)) {
                    return admin;
                }
            } else if (user instanceof Mahasiswa mahasiswa) {
                if (mahasiswa.getNama().equals(inputUser) && mahasiswa.getNim().equals(inputPass)) {
                    return mahasiswa;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

       
        userlist.add(new Admin("Admin", "password361"));
        userlist.add(new Mahasiswa("ata", "361"));

        Scanner scan = new Scanner(System.in);
        User loggedIn = null;

        System.out.println("\n=== Sistem Login ===");

        while (loggedIn == null) {
            System.out.print("Masukkan username/nama: ");
            String username = scan.nextLine();
            System.out.print("Masukkan password/NIM: ");
            String password = scan.nextLine();

            try {
                loggedIn = login(username, password);

                if (loggedIn == null) {
                    throw new LoginError("\nUser not found!");
                }

                System.out.println("Login berhasil!");
                loggedIn.displayInfo(username, password);
                loggedIn.displayAppMenu();
            } catch (LoginError e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("Silakan coba lagi.\n");
            }
        }

        scan.close();
    }
}