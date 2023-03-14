package Adresses;

import Users.User;

public class AdressManager {
    public static void AddingAdress(User user,IAdress adress){
        user.getAdresses().add(adress);
    }
    public static void RemoveAdress(User user, IAdress adress){
        user.getAdresses().remove(adress);
    }
}
