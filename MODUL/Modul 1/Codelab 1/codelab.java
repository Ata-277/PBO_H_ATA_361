import java.util.Scanner;
import java.time.LocalDate;

public class codelab {
    public static void main(String[] args){
        String nama;
        int tahunlahir,umur;
        LocalDate today = LocalDate.now();
        
        String gender,genderfull;
        
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan nama anda : ");
        nama =scan.nextLine();
        System.out.print("masukan gender :(l/p) ");
        gender =scan.nextLine();
        System.out.print("masukan tahun lahir anda :");
        tahunlahir =scan.nextInt();

        switch (gender.toLowerCase()) {
            case "l":
                genderfull ="laki laki";
                break;
                case "p":
                genderfull="perempuan";
                break;
            default:
                genderfull="tidak diketahui";
        }
         umur =today.getYear()-tahunlahir;
       
           System.out.println("====DATA DIRI====");
        System.out.println("nama anda adalah : " + nama);
        System.out.println("umur   anda adalah : "+ umur);
        System.out.println("gender anda adalah : "+ genderfull);


    }
}