package LoginPage;

import java.util.Scanner;

/*

Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

         menü: kullanıcıya işlem seçimi için menü gösterilir.

         üye olma(register): kullanıcıdan ad-soyad, email ve şifre bilgileri alınız.
                             email ve şifre birer listede tutulur.
                             aynı email kabul edilmez.

         giriş(login): email ve şifre girilir.
                       email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
                       email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

         email validation: boşluk içermemeli
                         : @ içermeli
                         : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                         : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

         password validation: boşluk içermemeli
                            : en az 6 karakter olmalı
                            : en az bir tane küçük harf içermeli
                            : en az bir tane büyük harf içermeli
                            : en az bir tane rakam içermeli
                            : en az bir tane sembol içermeli
 */
public class LoginPageApp {
    public static void main(String[] args) {

        start();
        //tüm userların ortak özellikleri için User class oluşturalım

    }

    private static void start() {
        Scanner input = new Scanner(System.in);

        //service objesi oluşturalım

        UserService service = new UserService();
        //menü gösterelim

        int select;

        do {
            System.out.println("--- TECHPRO EDUCATION ---");
            System.out.println("1- üye ol");
            System.out.println("2- giriş yap");
            System.out.println("0- ÇIKIŞ");
            System.out.println("Seçiminiz : ");
            select = input.nextInt();

            switch (select){
                case 1:
                    service.register();
                    //test için userları görelim
                    System.out.println(service.emails);
                    System.out.println(service.password);
                    break;
                case 2:
                    service.login();
                    break;
                case 0:
                    System.out.println("İyi günler dileriz");
                    break;
                default:
                    System.out.println("Hatalı giriş! Tekrar deneyiniz");
                    break;
            }


        }while (select!=0);






    }

}
