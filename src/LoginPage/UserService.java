package LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List <String> emails = new ArrayList<>();

    List <String> password = new ArrayList<>();
    //List <User> users = new ArrayList<>();

    //2) Kullanıcıdan ad soyad, email, şifre alıp listeye kaydet

    public void register() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ad-Soyad giriniz");
        String name = input.nextLine();

        //email geçersizse tekrar girilmeli
        String email;
        boolean isValid;
        boolean isExistEmail;
        do {
            System.out.println("Email giriniz");
            email=input.next().trim();

            isValid=validateEmail(email);
           isExistEmail= this.emails.contains(email);
            if (isExistEmail){
                System.out.println("Bu email ile kayıtlı kullanıcı zaten var");
                isValid=false;
            }

        }while (!isValid);

        //password oluşturma...

        String password;
        boolean isValidPassword;

        do {
            System.out.println("Şifrenizi oluşturunuz");
            password=input.next().trim();

            isValidPassword=validatePassword(password);


        }while (!isValidPassword);

        //user oluşturalım

        User user = new User(name, email, password);

        //userın bilgilerini listeye ekleyelim

        this.emails.add(user.email);
        this.password.add(user.password);

        System.out.println("Kayıt işlemi başarıyla gerçekleşti. \nEmail ve şifrenizi kullanarak sisteme giriş yapabilirsiniz");






    }

    //3) login: girilen email kayıtlı kullanıcıların arasında var mı
    //          girilen email ile aynı indexte bulunan password eşleşiyor mu?
    public void login(){

        Scanner input = new Scanner(System.in);
        System.out.println("Email giriniz");
        String email= input.next().trim();

        //girilen email listede varmı?
        boolean existEmail=this.emails.contains(email);
        if (existEmail) {
            //kullanıcı kaydı var, şifreyi kontrol et
            boolean isWrong=true;
            while (isWrong) {

                System.out.println("Şifrenizi girin");
                String passw = input.next().trim();

                //şifre ile email aynı indexte eşleşiyor mu?
                int index = this.emails.indexOf(email);
                if (this.password.get(index).equals(passw)) {
                    System.out.println("Sisteme giriş yaptınız. Hoşgeldiniz :)");
                    isWrong = false;
                } else {
                    System.out.println("Şifreniz yanlış, tekrar deneyiniz");
                }
            }

        }else {
            System.out.println("Sisteme kayıtlı kullanıcı bulunamadı");
            System.out.println("Üye iseniz bilgilerinizi kontrol ediniz, değilseniz üye olunuz");
        }





    }

    private boolean validateEmail(String email){
        return true;
    }

    private boolean validatePassword(String password) {
        boolean isValid;
        boolean space = password.contains(" ");
        boolean length6Character = password.length()>=6;
        String upperLetters = password.replaceAll("[^A-Z]", "");
        boolean existsUpperLetter=upperLetters.length()>0;

        if (space){
            System.out.println("Şifre boşluk içeremez");
        }else if (!length6Character){
            System.out.println("Şifre en az 6 karakter içermelidir");
        }
        isValid=!space && length6Character && existsUpperLetter;
        if (!isValid){
            System.out.println("Geçersiz şifre tekrar deneyiniz");
        }

        return isValid;
    }





}
