package Adresses;

public class HomeAdress implements IAdress {
    private String home;
    private boolean isHome;

    public HomeAdress(String home) {
        this.home = home;
        this.isHome = true;
    }

    @Override
    public String gettheadress() {
        return  this.home;
    }

    @Override
    public void settheadreses(String adress) {
        this.home=adress;
    }

    @Override
    public boolean isHome() {
        return isHome;
    }
}
