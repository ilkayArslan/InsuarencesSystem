package Accounts;

import java.util.Comparator;
import java.util.TreeSet;

public class AccountManager {
    TreeSet<Account> accounts = new TreeSet<>(new Comparator<Account>() {
        @Override
        public int compare(Account o1, Account o2) {
            return o1.getUser().getName().compareTo(o2.getUser().getName());
        }
    });
    public void GetAccounts (Account account){
        accounts.add(account);
        //geçici işlem
        listacoounts();
    }
    public void listacoounts(){
        for (Account a:
             accounts) {
            System.out.println(a.getUser().getName() + " - "+a.getUser().getAge());
        }
    }

    public Account LOGIN(String name,String password) throws InvalidAuthenticationException {

            Account account = null;
            for (Account a: accounts) {
                a.login(name,password,a);
                if (a.login(name,password,a)!=null){
                    account =a;
                }
            }
            if (account==null){
                throw new InvalidAuthenticationException("Invalid email or name");
            }
            return account;


    }
}
