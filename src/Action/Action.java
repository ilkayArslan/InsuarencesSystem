package Action;

import Accounts.*;
import Adresses.AdressManager;
import Adresses.BusinessAdress;
import Adresses.HomeAdress;
import Adresses.IAdress;
import Insuarences.*;
import Users.User;

import java.util.Date;
import java.util.Scanner;

public class Action {
    Scanner sc = new Scanner(System.in);
    Scanner lines = new Scanner(System.in);
    private String name;
    AccountManager a = new AccountManager();
    public Action(){
        Action2();
    }

    public User CreateAccount(){
        System.out.println("Adınızı Giriniz lütfen");
        this.name = lines.nextLine();
        System.out.println("Soyisminizi Giriniz Lütfen");
        String surname = lines.nextLine();
        System.out.println("Email adresiniz : ");
        String email = lines.nextLine();
        System.out.println(" Password : ");
        String password = lines.nextLine();
        System.out.println(" işiniz : ");
        String job = lines.nextLine();
        System.out.println("Yaşınız : ");
        int age = sc.nextInt();
        return new User(this.name,surname,email,password,job,age);

    }
    public void ShowAdresses(User user){
        user.getAdressesList();

    }
    public void Action2(){
        System.out.println("------------------Hoşgeldiniz------------------");
        User newuser = null;
        Account account = null;
        System.out.println("1 - Kayıt olmak için \n" +
                "2 - Giriş Yapmak için \n" +
                "Lütfen Seçiminizi Yapınız");
        int choosenentry = sc.nextInt();
        if (choosenentry == 1){
            System.out.println("1 - Bireysel Müşteri \n" +
                    "2 - Kurumsal Müşteri ");
            int choosencustomer = sc.nextInt();
            newuser = CreateAccount();
            if (choosencustomer == 1){
                account = new Invidual(newuser);
                account.setInvidual(true);
                System.out.println("Tebrikler Bireysel Kullanıcınız oluşturuldu");
            } else if (choosencustomer ==2) {
                account = new Enterprise(newuser);
                account.setInvidual(false);
                System.out.println("Tebrikler Kurumsal Müşteri Hesabınız oluşturuldu");
            }
            a.GetAccounts(account);

        } else if (choosenentry==2) {
            System.out.println("Lütfen isminizi giriniz");
            String name= lines.nextLine();
            System.out.println("Lütfen şifrenizi giriniz");
            String password = lines.nextLine();
            try {
                account= a.LOGIN(name,password);
            } catch (InvalidAuthenticationException e) {
                 new RuntimeException(e);
            }
            if (account==null){
                   Action2();
               }

        }
        AfterUserCreating(account);
    }
    public void Adressislemleri(Account account){
        System.out.println("1 - Adres eklemek için \n" +
                "2 - Adres silmek için\n" +
                "3 - Adres listesi inceleme\n" +
                "0 - Çıkış");
        int choseadress = sc.nextInt();
        if (choseadress == 1){
            System.out.println("Adress ekleme ekranına hoş geldiniz lütfen girmek istediğiniz adresi seçiniz \n" +
                    "1 - Ev adresi \n" +
                    "2 - İşyeri adresi ");
            int chosehome = sc.nextInt();
            if (chosehome==1){
                System.out.println("Lütfen ev adresinizi giriniz");
                IAdress adress = new HomeAdress(lines.nextLine());
                AdressManager.AddingAdress(account.getUser(),adress);
            } else if (chosehome ==2) {
                System.out.println("Lütfen işyeri adresinizi giriniz");
                IAdress adress = new BusinessAdress(lines.nextLine());
                AdressManager.AddingAdress(account.getUser(),adress);
            }
            Adressislemleri(account);
        } else if (choseadress == 2) {
            System.out.println("Adress silme ekranına hoşgeldiniz");
            if (account.getUser().getAdresses().size()<1){
                System.out.println("Eklenmiş Adresiniz yoktur....");
            }else{
                ShowAdresses(account.getUser());
                System.out.println("Silmek istediğiniz adresi seciniz");
                int choseremove= sc.nextInt();
                AdressManager.RemoveAdress(account.getUser(),account.getUser().getAdresses().get(choseremove-1));
            }
            Adressislemleri(account);
        } else if (choseadress==3) {
            ShowAdresses(account.getUser());
            Adressislemleri(account);
        }else if (choseadress==0){
            AfterUserCreating(account);
        }

    }
    public void AfterUserCreating(Account account){
        System.out.println("Merhaba " + account.getUser().getName() + "\n" +
                "Yapmak istediğiniz işlemi seçiniz \n" +
                "1 - Adres işlemleri \n" +
                "2 - Sigorta İşlemleri\n" +
                "0 - Çıkış");
        int chosenislem = sc.nextInt();
        if (chosenislem == 1){
            Adressislemleri(account);
        } else if (chosenislem==2) {
            Insuarenceislemleri(account);
        } else if (chosenislem ==0) {
            Action2();
        }
    }
    public void Insuarenceislemleri(Account account){
        System.out.println("Sigorta işlemlerine hoşgeldiniz");
        System.out.println("1 - Sigorta Listenize bakmak için\n" +
                "2 - Sigorta yaptırmak için\n" +
                "0 - Çıkış");
        int choseins = sc.nextInt();
        if (choseins == 1){
            if (account.getInsuarences().size()<1){
                System.out.println("Şuan hiç bir sigortanız yoktur");
            }else{
                for (Insuarence ins:account.getInsuarences()) {
                    System.out.println(ins.getName() + " : "+ ins.getPrice() + " : " + ins.getDate());
                }
            }
            Insuarenceislemleri(account);
        } else if (choseins==2) {
            System.out.println("1 - Araç Sigortası\n" +
                    "2 - Sağlık sigortası\n" +
                    "3 - Konut sigortası\n" +
                    "4 - Seyahat sigortası  ");
            int chosenesig = sc.nextInt();
            switch (chosenesig){
                case 1:
                    Insuarence car = new Car("Araba",new Date());
                    account.getInsuarences().add(car);
                    break;
                case 2:
                    Insuarence health = new Health("Sağlık",new Date());
                    account.getInsuarences().add(health);
                    break;
                case 3:
                    Insuarence home = new Residance("Ev",new Date());
                    account.getInsuarences().add(home);
                    break;
                case 4:
                    Insuarence travel = new Travel("Seyahat",new Date());
                    account.getInsuarences().add(travel);
                    break;
            }
            Insuarenceislemleri(account);
        } else if (choseins==0) {
            AfterUserCreating(account);
        }


    }
}
