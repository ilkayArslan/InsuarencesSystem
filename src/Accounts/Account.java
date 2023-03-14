package Accounts;
import Insuarences.Insuarence;
import Users.User;

import java.util.ArrayList;

public abstract class Account {
    private User user;
    private boolean isInvidual;
    private ArrayList<Insuarence> insuarences=new ArrayList<>();
    private AuthenticationStatus authenticationStatus;

    public enum AuthenticationStatus{
        FAIL, SUCCESS;
    }

    public ArrayList<Insuarence> getInsuarences() {
        return insuarences;
    }

    public void setInsuarences(ArrayList<Insuarence> insuarences) {
        this.insuarences = insuarences;
    }

    public Account(User user) {
        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isInvidual() {
        return isInvidual;
    }

    public void setInvidual(boolean invidual) {
        isInvidual = invidual;
    }
    public Account login(String name, String password,Account account)  {
        Account a = null;
        if (user.getName().equals(name) && user.getPassword().equals(password)) {
            this.authenticationStatus = AuthenticationStatus.SUCCESS;
            a =  account;
        }else{
            this.authenticationStatus = AuthenticationStatus.FAIL;
        }
        return a;

    }
}
